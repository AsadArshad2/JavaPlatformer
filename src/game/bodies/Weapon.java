package game.bodies;

import city.cs.engine.*;
import game.collisions.pickups.CoinPickup;
import game.collisions.pickups.WeaponPickup;
import org.jbox2d.common.Vec2;

public class Weapon extends DynamicBody {
    private static final Shape coinShape = new CircleShape(1);

    // image is final and static for same reason
    private static final BodyImage coinImage =
            new BodyImage("data/sword.png", 2f);

    // declare a player because i want to add coin pickup into the coin object
    private Player player;


    public Weapon(float x, float y, Player player, World w){
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
        WeaponPickup pickup1 = new WeaponPickup(player,this);
        // add a collision listener to the player this extra line of code is now in here instead of game world
        player.addCollisionListener(pickup1);

    }



}

