package game;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GiveFocus extends MouseAdapter {
    //class used to get focus on the the game

    @Override
    public void mouseEntered(MouseEvent e) {
        e.getComponent().requestFocus();
    }

}
