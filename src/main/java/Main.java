import Controller.GameController;
import Controller.KeyListnerClass;
import Domain.GameDomain.Bag;
import Domain.GameDomain.Player;
import Domain.GameDomain.Room;
import lombok.extern.java.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

@Log
public class Main {
    public static void main(String[] args) {
/*
        freccia giù= '\u2193'
        freccia sù= '\u2191'
         */
        KeyListnerClass keyListnerClass= new KeyListnerClass();

        JFrame frame = new JFrame("Pawtropolis");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        JPanel panel= new JPanel();
        frame.add(panel);

        JLabel textField= new JLabel();
        panel.add(textField);
        textField.addKeyListener(keyListnerClass);
        frame.addKeyListener(keyListnerClass);
        Font customFont = new Font("Arial", Font.ITALIC, 24);
        frame.setFont(customFont);
        Color colorFont= Color.BLACK;
        frame.setForeground(colorFont);
        frame.setVisible(true);
        GameController gameController = new GameController();
        Player player1 = gameController.getPlayer();
        Bag bag1 = gameController.getPlayer().getBag();
        Room room1 = gameController.getPlayer().getActuallyRoom();


    }
}