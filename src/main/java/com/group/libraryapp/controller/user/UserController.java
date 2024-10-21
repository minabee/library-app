package com.group.libraryapp.controller.user;

import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.service.user.UserServiceV1;
import com.group.libraryapp.service.user.UserServiceV2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController{

    private final UserServiceV2 userService;

    public UserController(UserServiceV2 userService){
        this.userService = userService;
    }

    @PostMapping("/user")
    public void saveUser(@RequestBody UserCreateRequest request){
        userService.saveUser(request);
    }

    @GetMapping("/user")
    public List<UserResponse> getUsers(){
        return userService.getUsers();
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request){
        userService.updateUser(request);
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name){
        userService.deleteUser(name);
    }




    //    @GetMapping("/user")
    //    public List<UserResponse> getUsers(){
    //        String sql = "SELECT * FROM user";
    //        return jdbcTemplate.query(sql, new RowMapper<UserResponse>() {
    //            @Override
    //            public UserResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
    //                long id = rs.getLong("id");
    //                String name = rs.getString("name");
    //                int age = rs.getInt("age");
    //                return new UserResponse(id, name, age);
    //            }
    //        });
    //    }
}