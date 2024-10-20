package game.collisions.pickups;

import city.cs.engine.CollisionEvent;
import game.Game;
import game.bodies.Crystal;
import game.bodies.Player;
import game.levels.GameLevel;

public class CrystalPickup extends Pickups {

    private GameLevel currentLevel;
    private Player player;
    private Crystal crystal;
    private Game game;

    public CrystalPickup(Player s, Crystal c, GameLevel g, Game game) {
        super(s, c);
        this.game=game;
        this.player = s;
        this.crystal = c;
        this.currentLevel = g;
    }

    @Override
    public void collide(CollisionEvent e) {
        super.collide(e);
        if (e.getOtherBody() instanceof Crystal) {
            System.out.println("crystal collide");

            game.goToNextLevel();
            //game.goToNextLevel();
        }
    }}
