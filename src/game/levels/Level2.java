package game.levels;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import game.Game;
import game.bodies.*;
import game.collisions.deaths.PlayerFall;
import game.collisions.pickups.CrystalPickup;
import org.jbox2d.common.Vec2;

public class Level2 extends GameLevel{
    private Player player1;
    public Level2(Game game){
        super(game);
        player1=getPlayer();
        getPlayer().setPosition(new Vec2(14,-22));
        Shape shape = new BoxShape(19, 0.00000001f);
        // make a static body in the world and name it ground with the shape we just made
        StaticBody floorBarrier = new StaticBody(this, shape);
        // set the position just off the bottom of the map
        floorBarrier.setPosition(new Vec2(0f, -28));
        // add the collision listener that kills the player upon touching
        PlayerFall fallOffMap=new PlayerFall(player1,floorBarrier,game);
        // add the listener to the player
        // this is the only collision listener you have to add in the game world code
        // the rest of the listeners are implemented in the methods e.g. coinPickup is inside Coins
        player1.addCollisionListener(fallOffMap);

        //add 8 coins per level, so will make 8
        Coins coin1 = new Coins(-2,-20,player1,this);
        Coins coin2 = new Coins(10,-8,player1,this);


        // add a super coin which will give player powers ( wll add in future patch)

        // create the transformium crystal which the player must steal
        Crystal transformium = getEnd();
        transformium.setPosition(new Vec2(13,18));
        CrystalPickup cpick = new CrystalPickup(player1,transformium,this,game);
        player1.addCollisionListener(cpick);


        // create the game platforms through the platform method
        Platform floor1 = new Platform(12,-23,this);
        Platform floor2 = new Platform(6,-23,this);
        Platform floor3 = new Platform(0,-23,this);
        Platform secnd = new Platform(-12,-17,this);
        Platform thrd1 = new Platform(-5,-11,this);
        Platform thrd2 = new Platform(1,-11,this);
        Platform thrd3 = new Platform(7,-11,this);
        Platform frth = new Platform(0,-4,this);
        Platform fifth = new Platform(10,2,this);
        Platform sixth = new Platform(-6,4,this);
        Platform seven = new Platform(-12,10,this);
        Platform ate = new Platform(4,16,this);
        Platform ate2 = new Platform(0,16,this);









        Platform plat14 = new Platform(8,16,this);
        Platform plat15 = new Platform(12,16,this);
        Platform plat16 = new Platform(16,16,this);









        // make the guardians
        // for these the collision detectors are implemented into the method, hence player is one of the parameters
        Enemy pred1
                = new Enemy(5,-22,this,player1,new BodyImage("data/ice.png", 4f),7,5);
        pred1.setSPEED(7);
        pred1.setRANGE(10);

        Enemy pred2
                = new Enemy(0 ,-10,this,player1,new BodyImage("data/ice.png", 4f),7,8);
        pred2.setSPEED(7);
        pred2.setRANGE(8);
//
        Enemy pred3
                = new Enemy(4,18,this,player1,new BodyImage("data/ice.png", 4f),9,3);
        pred3.setSPEED(9);
        pred3.setRANGE(3);
    }
    @Override
    public boolean isComplete() {
        if (getPlayer().getCrystalCount()==1)
            return true;
        else return false;
    }
    @Override
    public String getLevelName() {
        return "Level2";


    }

    }
