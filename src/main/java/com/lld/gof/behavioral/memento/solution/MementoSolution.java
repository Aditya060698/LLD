package com.lld.gof.behavioral.memento.solution;

public class MementoSolution {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.type("draft");
        EditorMemento saved = editor.save();
        editor.type(" changed");
        editor.restore(saved);

        System.out.println(editor.text());
    }

    /*
     * Memento Pattern
     *
     * Intent:
     * Capture and restore object state without exposing internals.
     */
    static final class Editor {
        private String text = "";

        void type(String value) {
            text += value;
        }

        EditorMemento save() {
            return new EditorMemento(text);
        }

        void restore(EditorMemento memento) {
            text = memento.text();
        }

        String text() {
            return text;
        }
    }

    record EditorMemento(String text) {
    }
}
