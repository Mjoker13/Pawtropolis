import Controller.GameCreator;
import lombok.extern.java.Log;

import java.util.Scanner;



@Log
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       // System.out.println("What do you want to do?");
       // String input = scanner.nextLine();

        GameCreator gameCreator = new GameCreator();
        gameCreator.getAllRooms();
    }
}