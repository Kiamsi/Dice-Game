package com.kiamsi.diceapi.Services;

import com.kiamsi.diceapi.Repositories.UserRepository;
import com.kiamsi.diceapi.Security.JwtService;
import com.kiamsi.diceapi.Users.UserDto;
import com.kiamsi.diceapi.Users.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public UserDto register (UserDto request){
        UserEntity user = UserEntity.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        userRepository.save(user);

        return request;

    }

    public String login (UserDto request){
        Optional<UserEntity> optionalUser
                = userRepository.findByUsername(request.getUsername());

        if (optionalUser.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        UserEntity user = optionalUser.get();

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Wrong password");
        }

        return jwtService.generateToken(user.getUsername());
    }
}
