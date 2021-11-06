package ru.vsu.marbles;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {

    public static final int BALLS_INITIAL_COUNT = 10;
    private final List<Ball> balls = new ArrayList<>();
    private final String name;
    private int stake = 0;

    public Player(String name, Color ballsColor) {
        this.name = name;
        for (int i = 0; i < BALLS_INITIAL_COUNT; i++) {
            balls.add(new Ball(ballsColor));
        }
    }

    public String getName() {
        return name;
    }

    public MarbleGuess makeStake() {
        Random r = new Random();
        stake = r.nextInt(balls.size()+1);
        if ((stake % 2) == 0) {
            return MarbleGuess.EVEN;
        }
        return MarbleGuess.ODD;
    }

    public boolean guess(MarbleGuess guess) {
        boolean isEven = (stake % 2 == 0);
        return isEven && (guess == MarbleGuess.EVEN);
    }

    public List<Ball> takeBalls() {
        List<Ball> ballsToGive = new ArrayList<>();
        for (int i = 0; i < stake; i++) {
            ballsToGive.add(balls.remove(0));
        }
        return ballsToGive;
    }

    public void giveBalls(List<Ball> balls) {
        this.balls.addAll(balls);
    }

    public int getBallsCount(){
        return balls.size();
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                "balls='" + balls.size() + '\'' +
                '}';
    }
}