import Phaser from 'phaser';
import TitleScreen from './scenes/titleScreen';

const config = {
    width: 1000,
    height: 800,
    type: Phaser.AUTO
}
console.log(Phaser);

const diceGame = new Phaser.Game(config);
diceGame.scene.add("tittle", TitleScreen);

diceGame.scene.start("tittle");