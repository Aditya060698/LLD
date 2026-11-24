package com.lld.gof.behavioral.mediator.practice;

import java.util.ArrayList;
import java.util.List;

public class MediatorPractice {
    public static void main(String[] args) {
        PracticeChatRoom room = new PracticeChatRoom();
        room.join("Rahul");
        room.join("Ananya");
        System.out.println(room.send("Rahul", "Hi"));
    }

    /*
     * Mediator Practice
     *
     * Goal:
     * Users communicate through the room, not directly with each other.
     */
    static final class PracticeChatRoom {
        private final List<String> users = new ArrayList<>();

        void join(String user) {
            users.add(user);
        }

        String send(String sender, String message) {
            // TODO: Mediator task
            // Use this room as the central communication object.
            return "TODO mediator";
        }
    }
}
