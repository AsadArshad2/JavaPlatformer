package game.bodies;

import city.cs.engine.BodyImage;
import game.bodies.Player;
import game.levels.GameLevel;
import org.jbox2d.common.Vec2;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class PlayerController implements KeyListener {
    // use this to control player

    Player player;
    private AWTKeyStroke e;
    private int jumpPower =12;
    public int getJumpPower() {
        return jumpPower;
    }
    public void setJumpPower(int jumpPower) {
        this.jumpPower = jumpPower;
    }
    public PlayerController(Player player) {
        this.player=player;
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        //move left with a and set gif
        if (code == KeyEvent.VK_A ) {
            player.startWalking(-5);
            player.removeAllImages();
            player.addImage(player.getImageL());
        }
        //move right with d and set gif
        if (code == KeyEvent.VK_D) {
            player.startWalking(5);
            player.removeAllImages();
            player.addImage(player.getImageR());
        }
        //jump with w and set jump gif
        if (code == KeyEvent.VK_W){

            player.jump(jumpPower);
            player.removeAllImages();
            player.addImage(player.getJumpleft());
        }




    }

    @Override
    public void keyReleased(KeyEvent e) {
        // releasing a or d will stop walking
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            player.stopWalking();
            player.setLinearVelocity(new Vec2(0,0));

        } if (code == KeyEvent.VK_D) {
            player.stopWalking();
            player.setLinearVelocity(new Vec2(0,0));
        }
        // releasing w will keep the jumping animation on to make it look more natural
        if (code == KeyEvent.VK_W){
            player.addImage(player.getJumpleft());
        }
        // anything else will cause defailt idle gif

        else {player.removeAllImages();
        player.addImage(new BodyImage("data/mcleft.gif",4f));}
    }


    public void updatePlayer(Player player) {
        this.player=player;
    }
}
