package game.bodies;

import city.cs.engine.*;
import game.collisions.pickups.CrystalPickup;
import org.jbox2d.common.Vec2;

public class Crystal extends DynamicBody {
    // instead of making in crystal in main with all the long code
    // i will use crystal method instead

    // make the crystal shape final and static
    private static final Shape crystalShape = new CircleShape(1);

    // image is final and static for same reason
    private static final BodyImage crystalImage =
            new BodyImage("data/crystal.gif", 2f);

    // declare a player because i want to add crystal pickup into the crystal object
    private Player player;


    public Crystal(Player player, World w){
        // super to dynamic body (the world and shape)
        super(w,crystalShape);
        // make the player inputted into the player field
        this.player=player;
        // add the crystal image
        addImage(crystalImage);
        // set position specified while creating the crystal object
        // gravity to zero so crystals can hover and look cool
        setGravityScale(0);
        // here i implement crystal pickup into the crystal method itself
        // which requires you to put a player while making a crystal, but saves mess over time
        // add a collision listener to the player this extra line of code is now in here instead of game world


    }




}

