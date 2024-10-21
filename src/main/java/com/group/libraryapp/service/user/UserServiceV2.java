package com.group.libraryapp.service.user;

import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceV2 {

    private final UserRepository userRepository;

    public UserServiceV2(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveUser(UserCreateRequest request){
        userRepository.save(new User(request.getName(), request.getAge()));
    }

    @Transactional(readOnly = true)
    public List<UserResponse> getUsers(){
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(UserResponse::new)//생성자를 호출하여 UserResponse로 변환
                .collect(Collectors.toList());
    }

//    public List<UserResponse> getUsers(){
//        List<User> users = userRepository.findAll(); // 모든 유저정보 가져옴(select * from user)
//        return users.stream() // users에 담긴 데이터를 처리
//                .map(user -> new UserResponse(user.getId(), user.getName(), user.getAge())) //user객체를 userResponse객체로 변환(map : Stream의 각 요소를 변환)
//                .collect(Collectors.toList()); // stream을 다시 리스트로 변환 -> 결과적으로 List<UserResponse> 반환
//    }

    @Transactional
    public void updateUser(UserUpdateRequest request){
        // select * from user where id = ?;
        // Optional<User>
        User user = userRepository.findById(request.getId())
                .orElseThrow(IllegalArgumentException::new);

        user.updateName(request.getName());
        userRepository.save(user);
    }

    @Transactional
    public void deleteUser(String name){
        // select * from user where name = ?
        User user = userRepository.findByName(name)
                .orElseThrow(IllegalArgumentException::new);

        userRepository.delete(user);
    }
}
