package com.lld.gof.behavioral.state.solution;

public class StateSolution {
    public static void main(String[] args) {
        Player player = new Player(new PausedState());
        System.out.println(player.pressPlay());
    }

    /*
     * State Pattern
     *
     * Intent:
     * Change behavior when internal state changes.
     */
    interface PlayerState {
        String play();
    }

    static final class PausedState implements PlayerState {
        public String play() {
            return "start playing";
        }
    }

    record Player(PlayerState state) {
        String pressPlay() {
            return state.play();
        }
    }
}
