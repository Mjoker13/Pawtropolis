package Controller;

import Domain.GameDomain.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyListnerClass implements KeyListener {
    private int selectedIndex = 0;


    private String[] methods = {"go <direzione>", "look", "bag", "get <item>", "drop <item>"};

    public KeyListnerClass() {
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_UP) {
            selectedIndex = (selectedIndex - 1 + methods.length) % methods.length;
        } else if (keyCode == KeyEvent.VK_DOWN) {
            selectedIndex = (selectedIndex + 1) % methods.length;
        } else if (keyCode == KeyEvent.VK_ENTER) {
            String selectedMethod = methods[selectedIndex];
            executeMethod(selectedMethod);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    private void executeMethod(String method) {
        GameController gameController= new GameController();
        Player player= gameController.getPlayer();
        if (method.equals("look")) {
            gameController.getInformationInRoom(player.getActuallyRoom());
        } else if (method.startsWith("go ")) {
            gameController.changeRoom(player,method);
        } else if (method.equals("bag")) {
            gameController.getBag();
        } else if (method.startsWith("get ")) {
            gameController.addItemBag(player, method);
        } else if (method.startsWith("drop ")) {
            gameController.removeItemBag(player, method);
        }
    }

}
