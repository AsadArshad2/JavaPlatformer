package game.bodies;

import city.cs.engine.*;
import game.collisions.deaths.EnemyDeath;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Enemy extends Walker implements StepListener{
    // predator class
    // a predator will kill a player if the player touches them
    // in my games there are guardians who are instances of predators

    private Vec2 origin;
    public Vec2 getOrigin() {
        return origin;
    }

    private static SoundClip enemyDeath;

    static {
        try {
            enemyDeath = new SoundClip("data/playerDeath.wav");
            System.out.println("Loading books sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    @Override
    public void destroy()
    {
        enemyDeath.play();
        super.destroy();
    }

    private float left, right;
    private  int RANGE ;

    public int getRANGE() {
        return RANGE;
    }

    public void setRANGE(int RANGE) {
        this.RANGE = RANGE;
    }

    public int getSPEED() {
        return SPEED;
    }

    public void setSPEED(int SPEED) {
        this.SPEED = SPEED;
    }

    private  int SPEED;


    private static final Shape predShape = new BoxShape(1,2);
    public static void setImage(BodyImage image) {
        Enemy.image = image;
    }
    private static  BodyImage image =
            new BodyImage("data/fireman.gif", 4f);
    public Enemy(int x, int y, World world, Player p, BodyImage image1,int speed, int range) {
        super(world, predShape);
        addImage(image1);
        this.RANGE=range;

        setPosition(new Vec2(x,y));
        EnemyDeath pred1 = new EnemyDeath(p,this);
        p.addCollisionListener(pred1);
        world.addStepListener(this);
        startWalking(speed);


    }
    @Override
    public void setPosition(Vec2 position) {
        super.setPosition(position);
        left = position.x-RANGE;
        right = position.x+RANGE;

    }
    @Override
    public void preStep(StepEvent stepEvent) {
        if (getPosition().x > right){
            startWalking(-SPEED);
        }
        if (getPosition().x < left){
            startWalking(SPEED);
        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
