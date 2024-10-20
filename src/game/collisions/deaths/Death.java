package game.collisions.deaths;

import city.cs.engine.*;
import game.bodies.Player;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;


public abstract class Death implements CollisionListener{
    private Player player;
    private final Body killer;

    private static SoundClip lol;
    private static SoundClip cry;

    static {
        try {
            cry = new SoundClip("data/cry.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    static {
        try {
            lol = new SoundClip("data/playerDeathlol.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }
    public Death(Player player,Body killer){
        this.player = player; this.killer = killer;
    }

    @Override
    // when the player touches a collectable, it will be set to the outside of the map
        public void collide(CollisionEvent e) {
        if (e.getOtherBody() == killer && e.getOtherBody() instanceof StaticBody) {
            // player goes to spwan
            player.setPosition(new Vec2(14, -22));
            lol.play();

            System.out.println("Tip: Get Better");
            player.setLives(player.getLives() - 1);
            System.out.println("You have " + player.getLives() + " lives remaining");
            // player loses all coins upon death
            player.setCoinCount(0);
            // if no lives left game ends
            if (player.getLives() == 0) {
                System.out.println("You failed");
                System.out.println("Try again");
                System.exit(0);
            }
        } else if (e.getOtherBody() == killer && e.getOtherBody() instanceof DynamicBody && player.getHasWeapon() == false) {
            // player goes to spwan
            player.setPosition(new Vec2(14, -22));
            cry.play();
            System.out.println("Tip: Get Better");
            player.setLives(player.getLives() - 1);
            System.out.println("You have " + player.getLives() + " lives remaining");
            // player loses all coins upon death
            player.setCoinCount(player.getCoinCount()-1);
            // if no lives left game ends
            if (player.getLives() == 0) {
                System.out.println("You failed");
                System.out.println("Try again");
                System.exit(0);
            }
        } else if (e.getOtherBody()==killer&&e.getOtherBody()instanceof DynamicBody&& player.getHasWeapon()==true) {
            killer.destroy();
            System.out.println("Enemy Felled");

        }
        if(player.getLives()==3){
        player.getWorld().getGame().getView().setForeground(new ImageIcon("data/fullHealth.png").getImage());}
        if(player.getLives()==2){
            player.getWorld().getGame().getView().setForeground(new ImageIcon("data/secHealth.png").getImage());}
        if(player.getLives()==1){
            player.getWorld().getGame().getView().setForeground(new ImageIcon("data/finalHealth.png").getImage());}


    }

    }
