package com.example.pawtropolis.model.Game;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
public class Player {
    private String name;
    private int lifePoints;
    private BagPlayer bagPlayer;
}
