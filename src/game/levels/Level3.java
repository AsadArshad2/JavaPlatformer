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

public class Level3 extends GameLevel{
    private Player player1;
    public Level3(Game game){
        super(game);
        player1=getPlayer();
        getPlayer().setPosition(new Vec2(-14,-22));
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
       // player1.addCollisionListener(fallOffMap);

        //add 8 coins per level, so will make 8
//        Coins coin1 = new Coins(-8,1,player1,this);
//        Coins coin2 = new Coins(-10,11,player1,this);
//        Coins coin3 = new Coins(-10,-21,player1,this);
//        Coins coin4 = new Coins(-10,-6,player1,this);
//        Coins coin5 = new Coins(0,9,player1,this);
        Coins coin6 = new Coins(8,15,player1,this);
        Coins coin7 = new Coins(14,-5,player1,this);
//        Coins coin8 = new Coins(10,-21,player1,this);

        // add a super coin which will give player powers ( wll add in future patch)

        // create the transformium crystal which the player must steal
        Crystal transformium = getEnd();
        transformium.setPosition(new Vec2(-8,-22));
       // CrystalPickup cpick = new CrystalPickup(player1,transformium,this,game);
        //player1.addCollisionListener(cpick);


        // create the game platforms through the platform method
        Platform plat1 = new Platform(-13,-23,this);
        Platform plat2 = new Platform(-7,-23,this);
        Platform plat3 = new Platform(-1,-23,this);
        Platform plat4 = new Platform(5,-23,this);
        Platform plat5 = new Platform(11,-23,this);
        Platform plat5r = new Platform(16,-23,this);





        Platform platfive = new Platform(-13,-16,this);
        Platform platf5 = new Platform(-7,-16,this);
        Platform plat6 = new Platform(-1,-16,this);


        Platform plat87 = new Platform(-12,-23,this);
        Platform plat61 = new Platform(2,-8,this);
        Platform plat62 = new Platform(8,-8,this);
        Platform plat71 = new Platform(11,4,this);
        Platform plat7 = new Platform(0,7,this);
        Platform plat8 = new Platform(8,-2,this);
        Platform plat9 = new Platform(8,-2,this);
        Platform plat10 = new Platform(8,-2,this);
        Platform plat11 = new Platform(8,-2,this);
        Platform plat12 = new Platform(-10,0,this);
        Platform plat13 = new Platform(3,14,this);
        Platform plat14 = new Platform(-8,20,this);

        // make the guardians
        // for these the collision detectors are implemented into the method, hence player is one of the parameters
        Enemy pred1
                = new Enemy(10,-22,this,player1,new BodyImage("data/night.png", 4f),7,5);
        pred1.setSPEED(7);
        pred1.setRANGE(5);

        Enemy pred2
                = new Enemy(-10 ,-14,this,player1,new BodyImage("data/night.png", 4f),5,6);
        pred2.setSPEED(5);
        pred2.setRANGE(6);
        Enemy pred3
               = new Enemy(7 ,-5,this,player1,new BodyImage("data/night.png", 4f),3,2);
        pred3.setRANGE(2);
        pred3.setSPEED(3);
    }
    @Override
    public boolean isComplete() {
        if (getPlayer().getCrystalCount()==3 )
            return true;
        else return false;
    }
    @Override
    public String getLevelName() {
        return "Level3";


    }
    }
