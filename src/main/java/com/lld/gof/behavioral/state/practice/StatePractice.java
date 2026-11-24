package com.lld.gof.behavioral.state.practice;

public class StatePractice {
    public static void main(String[] args) {
        PracticePlayer player = new PracticePlayer(new PracticePausedState());
        System.out.println(player.pressPlay());
    }

    /*
     * State Practice
     *
     * Goal:
     * Move state-specific behavior into state classes.
     */
    interface PracticePlayerState {
        String play();
    }

    static final class PracticePausedState implements PracticePlayerState {
        public String play() {
            // TODO: State task
            // Return behavior for pressing play while paused.
            return "TODO state";
        }
    }

    record PracticePlayer(PracticePlayerState state) {
        String pressPlay() {
            return state.play();
        }
    }
}
