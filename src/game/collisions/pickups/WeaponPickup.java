package game.collisions.pickups;

import city.cs.engine.CollisionEvent;
import game.bodies.Coins;
import game.bodies.Player;
import game.bodies.Weapon;

// this is for when a player touches a coin
public class WeaponPickup extends Pickups {
    private Player player;
    private Weapon w;
    public WeaponPickup(Player s, Weapon c){
        super(s,c);
        this.player=s;
        this.w=c;
    }

    @Override
    public void collide(CollisionEvent e) {
        super.collide(e);
        if(e.getOtherBody()instanceof Weapon){
        player.setHasWeapon(true);
        System.out.println("you got a knife");
        }
    }
}
