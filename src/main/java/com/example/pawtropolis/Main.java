package com.example.pawtropolis;

import com.example.pawtropolis.Controller.GameController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
        public static void main(String[] args) {
            SpringApplication.run(Main.class, args);
            GameController gameController=new GameController();
            gameController.startGame();
        }
}