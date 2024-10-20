//package game.bodies.ui;
//
//import city.cs.engine.*;
//import game.bodies.Player;
//import game.collisions.pickups.CoinPickup;
//import org.jbox2d.common.Vec2;
//
//public class Lives extends DynamicBody {
//    // instead of making in coin in main with all the long code
//    // i will use coin method instead
//
//    // make the coin shape final and static as all coins will use this same shape and i don't want it to change
//    private static final Shape coinShape = new CircleShape(1);
//
//    public static void setLifeImage(BodyImage lifeImage) {
//        Lives.lifeImage = lifeImage;
//    }
//
//    // image is final and static for same reason
//    private static  BodyImage lifeImage =
//            new BodyImage("data/hearts.png", 2f);
//
//    // declare a player because i want to add coin pickup into the coin object
//    private Player player;
//
//
//    public Lives(float x, float y, Player player, World w){
//        // super to dynamic body (the world and shape)
//        super(w,coinShape);
//        // make the player inputted into the player field
//        this.player=player;
//        // add the coins image
//        addImage(lifeImage);
//        // set position specified while creating the coin object
//        setPosition(new Vec2(x,y));
//        // gravity to zero so coins can hover and look cool
//        setGravityScale(0);
//        // here i implement coin pickup into the coin method itself
//        // which requires you to put a player while making a coin, but saves mess over time
//        // add a collision listener to the player this extra line of code is now in here instead of game world
//
//    }
//
//
//
//}
