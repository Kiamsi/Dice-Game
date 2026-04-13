package com.kiamsi.diceapi.Services;

import com.kiamsi.diceapi.Repositories.UserRepository;
import com.kiamsi.diceapi.Users.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class DiceService {

    private final UserRepository userRepository;

    public DiceService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void SetHighScore(String username, int highScore){

        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Integer currentHighScore = user.getHighScore();

        if (currentHighScore == null || currentHighScore <= highScore) {
            user.setHighScore(highScore);
            userRepository.save(user);
        }
        else
            throw new RuntimeException();



    }

}
