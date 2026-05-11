import Phaser from 'phaser';

export default class TitleScreen extends Phaser.Scene{
    preload(){

    }

    create(){
        this.add.text(300,200,'Dice Game').setOrigin(0.5,0.5);
    }
}