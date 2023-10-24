package com.example.pawtropolis.controller;


import com.example.pawtropolis.model.Game.*;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Getter
@Service
public class PlayerController {
    private final Player player;

    @Autowired
    public PlayerController(Player player) {
        this.player = player;
    }

}

