package game;

import city.cs.engine.SoundClip;
import city.cs.engine.World;
import game.bodies.PlayerController;
import game.levels.GameLevel;
import game.levels.Level1;
import game.levels.Level2;
import game.levels.Level3;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

import java.io.IOException;
import java.util.Scanner;

/**
 * Your main game entry point
 */
public class Game {
    public GameView getView() {
        return view;
    }

    private GameView view;
   private SoundClip gameMusic;


    public GameLevel getLevel() {
        return level;
    }

    // add the world (which is already populated)
    private GameLevel level;
    private PlayerController controller;

    /** Initialise a new Game. */
    public Game() {
        // make a view to look into the game world
        level=new Level1(this);

        view = new GameView(level, 600, 1000);
        // create player controller
        controller = new PlayerController(level.getPlayer());
        // create a Java window (frame) and add the game view to it
        final JFrame frame = new JFrame("City Game");
        frame.add(view);
        // enable frame to quit the application when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // put the frame on the right side so command line is visible
        frame.setLocation(20000, 0);
        // don't let frame be resized
        frame.setResizable(true);
        // size frame to fit the world view
        frame.pack();
        // make the frame visible
        frame.setVisible(true);
        // start simulation!
        level.start();
        // add player controller to game view
        view.addKeyListener(controller);
        // get the focus for using keyboard controlls etc
        view.requestFocus();
        // focus where the mouse is
        GiveFocus MouseListener = new GiveFocus();
        try {
            gameMusic = new SoundClip("data/theme1.wav");   // Open an audio input stream
            gameMusic.loop();                              // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            //code in here will deal with any errors
            //that might occur while loading/playing sound
            System.out.println(e);
        }
    }
    public void goToNextLevel() {
        if (level instanceof Level1) {
            level.stop();
            level = new Level2(this);
            //level now refer to the new level
            view.setWorld(level);
            controller.updatePlayer(level.getPlayer());
            getView().setBackground(new ImageIcon("data/level2.png").getImage());

            level.start();

        }
        else if (level instanceof Level2) {
            level.stop();
            level=new Level3(this);
            view.setWorld(level);
            controller.updatePlayer(level.getPlayer());
            getView().setBackground(new ImageIcon("data/level3.png").getImage());

            level.start();
        }
        else if (level instanceof Level3) {
          //  System.exit(0);

        }
    }
    public static void main(String[] args) {
        new Game();



}}