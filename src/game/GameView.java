package game;
import city.cs.engine.UserView;
import city.cs.engine.World;
import game.bodies.Player;
import game.levels.GameLevel;

import javax.swing.*;
import java.awt.*;

public class GameView extends UserView {

    public void setBackground(Image background) {
        this.background = background;
    }

    // initialise an image called background
    private Image background;

    public void setForeground(Image foreground) {
        this.foreground = foreground;
    }

    private Image foreground;
    private Player player;
    private GameLevel world;

    public void setLives(int lives) {
        this.lives = lives;
    }

    private int lives;


    public GameView(GameLevel world, int width, int height) {
        // super goes to user view to add the dimensions
        super(world, width, height);
        this.world = world;
        player=world.getPlayer();
        lives=player.getLives();
        // once you create an instance of game view the image will be added
        setBackground(new ImageIcon("data/level1.png").getImage());
        setForeground(new ImageIcon("data/fsupercoin.gif").getImage());
    }

    @Override
    protected void paintBackground(Graphics2D g) {

        g.drawImage(background, 0, 0, this);
        {
        }
    }

    @Override
    protected void paintForeground(Graphics2D g) {
        g.drawImage(foreground,300,0,this);
        g.drawString("Coins: "+player.getCoinString(),520,20);
    }
}

