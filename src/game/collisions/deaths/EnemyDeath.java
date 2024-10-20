package game.collisions.deaths;

import game.bodies.Player;
import game.bodies.Enemy;

import java.util.Random;

public class EnemyDeath extends Death {
    // when you touch a predator body you die
        private Player player;
        private Enemy enemy;

        // array of game lines for player deaths
        public String[] PredDeathLines = new String[]
                {       "The Guardian ripped off your head!",
                        "The Guardian sliced through you!",
                        "You became a nice meal for the dogs!",
                        "Dont be a fool!",
                        "Try harder next time!",
                        "You cant get past a Guardian!"

                };

        // random to select game death line
    Random random  = new Random();
    public EnemyDeath(Player s, Enemy c) {
        super(s,c);
            this.player = s;
            this.enemy = c;
        }

    }



