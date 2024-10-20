package game.collisions.pickups;

import city.cs.engine.CollisionEvent;
import game.bodies.Coins;
import game.bodies.Player;

// this is for when a player touches a coin
public class CoinPickup extends Pickups {
    private Player player;
    private Coins coin;
    public CoinPickup(Player s,Coins c){
        super(s,c);
        this.player=s;
        this.coin=c;
    }

    @Override
    public void collide(CollisionEvent e) {
        super.collide(e);
        if(e.getOtherBody()==coin){
        player.setCoinCount(player.getCoinCount()+1);}
}

}
