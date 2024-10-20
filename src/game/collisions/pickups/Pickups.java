package game.collisions.pickups;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.DynamicBody;
import game.bodies.Player;
import org.jbox2d.common.Vec2;


public abstract class Pickups implements CollisionListener{
    private Player player;
    private final DynamicBody collectable;
    public Pickups(Player player,DynamicBody collectable){
        this.player = player; this.collectable = collectable;
    }

    @Override
    // when the player touches a collectable, it will be set to the outside of the map
    public void collide(CollisionEvent e){
        if(e.getOtherBody()==collectable){
            collectable.destroy();
        }
    }
}
