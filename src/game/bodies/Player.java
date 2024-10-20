package game.bodies;

import city.cs.engine.*;
import game.levels.GameLevel;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Player extends Walker {
    // my player extends the walker class as I want the player to move
    // making an origin of vec2 makes it easy to send the character back to spawn
    // requires a getter
//    public Vec2 getOrigin() {
//        return origin;
//    }

    @Override
    public GameLevel getWorld() {
        return world;
    }

    private GameLevel world;
    public boolean getHasWeapon() {
        return hasWeapon;
    }

    private static SoundClip playerDeath;

    static {
        try {
            playerDeath = new SoundClip("data/playerDeath.wav");
            System.out.println("Loading books sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    public void setHasWeapon(boolean hasWeapon) {
        this.hasWeapon = hasWeapon;
    }

    private boolean hasWeapon;
    // make lives
    private int lives;
    // will need getters and setters, very important for player lives
    public int getLives() {
        return lives;
    }
    public void setLives(int lives) {
        this.lives = lives;
        if(lives==2){
//            world.getLives().removeAllImages();
//            world.getLives().addImage(new BodyImage("data/hearts.png", 2f));
        }
    }

    // make a coin count
    private int coinCount;
    private String coinString;

    public int getCrystalCount() {
        return crystalCount;
    }

    public void setCrystalCount(int crystalCount) {
        this.crystalCount = crystalCount;

    }

    private int crystalCount;
    public void setCoinCount(int count){
        coinCount= count;
        System.out.println("Coins held: "+count);
    }
    public int getCoinCount(){
        return coinCount;
    }
    //player shape is final and static
    public String getCoinString(){
        coinString = Integer.toString(coinCount);
        return coinString;
    }
    private static final Shape playerShape = new BoxShape(1,2);

    // image for looking right
    private final BodyImage imageR =
            new BodyImage("data/walkr.gif", 4f);

    //image for looking left
    private final BodyImage imageL =
            new BodyImage("data/walkl.gif", 4f);
    public BodyImage getImageL() {
        return imageL;
    }

    private final BodyImage imageidle= new BodyImage("data/mcleft.gif",4f);

    public BodyImage getImageidle() {
        return imageidle;
    }

    public BodyImage getImageR() {
        return imageR;
    }

    private final BodyImage jumpleft = new BodyImage("data/jumpl.gif",4f);

    public BodyImage getJumpleft() {
        return jumpleft;
    }

    public Player(GameLevel world) {
        super(world, playerShape);
        this.world=world;
        addImage(imageidle);
        setCrystalCount(0);
        setLives(3);
        setHasWeapon(false);

        // DEBUGGING
        // this.setAlwaysOutline(true);
//        GenericCollisionListener playerCollisions = new GenericCollisionListener();
//        this.addCollisionListener(playerCollisions);
    }




}