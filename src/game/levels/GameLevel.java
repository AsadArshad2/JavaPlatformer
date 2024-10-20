package game.levels;

import city.cs.engine.*;
import game.Game;
import game.bodies.*;
//import game.bodies.ui.Lives;
import game.collisions.deaths.PlayerFall;
import game.collisions.pickups.CrystalPickup;
import org.jbox2d.common.Vec2;

public abstract class GameLevel extends World {
    public abstract String getLevelName();

    private Player player1;



    private Game game;

    public Game getGame() {
        return game;
    }

    public Crystal getEnd() {
        return end;
    }

    private Crystal end;

    public GameLevel(Game game) {
        this.game=game;
        player1 = new Player(this);
        end = new Crystal(player1,this);
       // lives = new Lives(12,22,player1,this);

        player1.addCollisionListener(new CrystalPickup(player1,end,this,game));
    }


    public Player getPlayer() {
        return player1;
    }


    public  boolean isComplete(){
        if (player1.getCrystalCount()==1){
            return true;
        }
        else return false;
    };


}
