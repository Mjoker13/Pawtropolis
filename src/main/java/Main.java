import Controller.ZooController;
import GameDomain.Item;
import GameDomain.RoomNord;
import lombok.extern.java.Log;
import org.Domain.*;

import java.util.ArrayList;
import java.util.List;


@Log
public class Main {
    public static void main(String[] args) {

        ZooController zooController= new ZooController();

        List<Item> items= new ArrayList<>();
        Item item1= new Item("Martello", "ahahahshsiejd",1);
        Item item2= new Item("Martello", "ahahahshsiejd",1);
        items.add(item2);
        items.add(item1);

       // RoomNord roomNord = new RoomNord("Tiger room",items,zooController.getAllAnimalsForSpecies(Tiger.class));

    }
}