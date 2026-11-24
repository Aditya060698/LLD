package com.lld.gof.behavioral.memento.practice;

public class MementoPractice {
    public static void main(String[] args) {
        PracticeEditor editor = new PracticeEditor();
        editor.type("draft");
        PracticeEditorMemento saved = editor.save();
        editor.type(" changed");
        editor.restore(saved);

        System.out.println(editor.text());
    }

    /*
     * Memento Practice
     *
     * Goal:
     * Save and restore state without exposing the editor's mutable field directly.
     */
    static final class PracticeEditor {
        private String text = "";

        void type(String value) {
            text += value;
        }

        PracticeEditorMemento save() {
            // TODO: Memento task
            // Capture current text in a memento.
            return new PracticeEditorMemento("");
        }

        void restore(PracticeEditorMemento memento) {
            // TODO: Memento task
            // Restore text from memento.
        }

        String text() {
            return text;
        }
    }

    record PracticeEditorMemento(String text) {
    }
}
