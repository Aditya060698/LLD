package com.lld.gof.behavioral.mediator.solution;

import java.util.ArrayList;
import java.util.List;

public class MediatorSolution {
    public static void main(String[] args) {
        ChatRoom room = new ChatRoom();
        room.join("Rahul");
        room.join("Ananya");
        System.out.println(room.send("Rahul", "Hi"));
    }

    /*
     * Mediator Pattern
     *
     * Intent:
     * Centralize communication so objects do not directly depend on each other.
     */
    static final class ChatRoom {
        private final List<String> users = new ArrayList<>();

        void join(String user) {
            users.add(user);
        }

        String send(String sender, String message) {
            return sender + " to " + users + ": " + message;
        }
    }
}
