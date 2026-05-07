package com.kiamsi.diceapi.Controllers;

import com.kiamsi.diceapi.Services.UserService;
import com.kiamsi.diceapi.Users.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody UserDto userDto)
    {
        userService.register(userDto);
        return ResponseEntity.status(201).body(userDto);

    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDto userDto){
       String token = userService.login(userDto);
        return ResponseEntity.ok(token);
    }

}
