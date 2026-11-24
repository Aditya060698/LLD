package com.lld.gof.behavioral.visitor.practice;

import java.util.List;

public class VisitorPractice {
    public static void main(String[] args) {
        PracticeReportNode report = new PracticeSectionNode(List.of(new PracticeTextNode("LLD")));
        System.out.println(report.accept(new PracticePlainTextVisitor()));
    }

    /*
     * Visitor Practice
     *
     * Goal:
     * Put operations in visitors instead of repeatedly modifying node classes.
     */
    interface PracticeReportNode {
        String accept(PracticeReportVisitor visitor);
    }

    record PracticeTextNode(String text) implements PracticeReportNode {
        public String accept(PracticeReportVisitor visitor) {
            // TODO: Visitor task
            // Dispatch to visitor.visitText(this).
            return "TODO text visitor";
        }
    }

    record PracticeSectionNode(List<PracticeReportNode> children) implements PracticeReportNode {
        public String accept(PracticeReportVisitor visitor) {
            // TODO: Visitor task
            // Dispatch to visitor.visitSection(this).
            return "TODO section visitor";
        }
    }

    interface PracticeReportVisitor {
        String visitText(PracticeTextNode node);

        String visitSection(PracticeSectionNode node);
    }

    static final class PracticePlainTextVisitor implements PracticeReportVisitor {
        public String visitText(PracticeTextNode node) {
            return node.text();
        }

        public String visitSection(PracticeSectionNode node) {
            return node.children().stream().map(child -> child.accept(this)).toList().toString();
        }
    }
}
