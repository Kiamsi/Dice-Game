package com.kiamsi.diceapi.Controllers;

import com.kiamsi.diceapi.Dice.Dice;
import com.kiamsi.diceapi.Services.DiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/game")
public class DiceController {

    private final DiceService diceService;

    public DiceController(DiceService diceService){
        this.diceService = diceService;
    }

    @PatchMapping("/save")
    public ResponseEntity<Void> save (@RequestBody int highScore){

        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        diceService.SetHighScore(username,highScore);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/roll")
        public ResponseEntity<Integer> roll (@RequestBody Dice dice){

        int rolled = dice.roll();
        return ResponseEntity.ok(rolled);
    }

    @GetMapping("/dice/{sides}")
        public ResponseEntity<Dice> getDice(@PathVariable int sides){

        return ResponseEntity.ok(new Dice(sides));
    }
}



