package com.kiamsi.diceapi.Dice;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.ThreadLocalRandom;

@Data
@NoArgsConstructor
public class Dice {

    private int sides;

    private String color;

    public Dice(int sides){
        this.sides = sides;

        switch(sides){
            case 4: color = "green";
            break;
            case 6: color = "yellow";
            break;
            case 8: color = "red";
            break;
            case 10: color = "blue";
            break;
            case 12: color = "purple";
            break;
            case 20: color = "cyan";
            break;
            case 100: color = "white";
            break;
        }
    }

    public int roll(){

        return ThreadLocalRandom.current().nextInt(1, sides + 1);

    }

}
