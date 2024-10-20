package game.collisions.deaths;

import city.cs.engine.BodyImage;
import city.cs.engine.CollisionEvent;
import city.cs.engine.StaticBody;
import game.Game;
import game.GameView;
import game.bodies.Player;

import java.util.Random;

public class PlayerFall extends Death {
    // this is for when the player touches a barrier which causes them to die
    // this one is specifically for when the player falls and dies

    // i created an array of death lines which will be selected randomly everytime

    public String[] FallDeathLines = new String[]{
            "Someone slipped haha",
            "Gravity got the best of you",
            "Falling is for losers",

    };

    // random for the deathlines
    private Random random = new Random();

    private Player s;
    private StaticBody deathZone;

    private Game game;
    private GameView view;

    public PlayerFall(Player s, StaticBody d,Game g){
        super(s,d);
    this.s=s;
    this.deathZone=d;
    this.game=g;
    }

    @Override
    public void collide(CollisionEvent e) {
        super.collide(e);
        if(e.getOtherBody()==deathZone){
        System.out.println("you fell");}
        //game.getLevel().getLives().addImage(new BodyImage("data/sword.png", 2f) );
        //view.repaint();
    }
}


//    @Override
//    // when the player touches the ground which is specified (for this it is the ground)
//    public void collide(CollisionEvent e) {
//        // if the other body is the deathzone specifed
//        if (e.getOtherBody() == deathZone) {
//
//            // player will respawn in original spawn
//            s.setPosition(s.getOrigin());
//            // system will print out random death line from the array
//            System.out.println(FallDeathLines[random.nextInt(2)]);
//            // player loses 1 life
//            s.setLives(s.getLives()-1);
//            System.out.println("You have "+s.getLives()+" lives remaining");
//            // player will lose all coins
//            s.setCoinCount(0);
//            // if the lives are zero then the game will end and code will stop
//            if(s.getLives()==0){
//                System.out.println("You failed");
//                System.out.println("Try again");
//                System.exit(0);
//            }
//        }




