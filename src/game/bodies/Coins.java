package game.bodies;

import city.cs.engine.*;
import game.collisions.pickups.CoinPickup;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Coins extends DynamicBody {
    // instead of making in coin in main with all the long code
    // i will use coin method instead

    // make the coin shape final and static as all coins will use this same shape and i don't want it to change
    private static final Shape coinShape = new CircleShape(1);

    // image is final and static for same reason
    private static final BodyImage coinImage =
            new BodyImage("data/fcoin.gif", 2f);

    // declare a player because i want to add coin pickup into the coin object
    private Player player;

    private static SoundClip coinsSound;

    static {
        try {
            coinsSound = new SoundClip("data/coinpi.wav");
            System.out.println("Loading books sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    @Override
    public void destroy()
    {
        coinsSound.play();
        super.destroy();
    }


    public Coins(float x,float y,Player player,World w){
        // super to dynamic body (the world and shape)
        super(w,coinShape);
        // make the player inputted into the player field
        this.player=player;
        // add the coins image
        addImage(coinImage);
        // set position specified while creating the coin object
        setPosition(new Vec2(x,y));
        // gravity to zero so coins can hover and look cool
        setGravityScale(0);
        // here i implement coin pickup into the coin method itself
        // which requires you to put a player while making a coin, but saves mess over time
        CoinPickup pickup1 = new CoinPickup(player,this);
        // add a collision listener to the player this extra line of code is now in here instead of game world
        player.addCollisionListener(pickup1);

    }



}
