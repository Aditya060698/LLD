package com.lld.gof.behavioral.visitor.solution;

import java.util.List;

public class VisitorSolution {
    public static void main(String[] args) {
        ReportNode report = new SectionNode(List.of(new TextNode("LLD")));
        System.out.println(report.accept(new PlainTextVisitor()));
    }

    /*
     * Visitor Pattern
     *
     * Intent:
     * Add operations to object structures without changing node classes.
     */
    interface ReportNode {
        String accept(ReportVisitor visitor);
    }

    record TextNode(String text) implements ReportNode {
        public String accept(ReportVisitor visitor) {
            return visitor.visitText(this);
        }
    }

    record SectionNode(List<ReportNode> children) implements ReportNode {
        public String accept(ReportVisitor visitor) {
            return visitor.visitSection(this);
        }
    }

    interface ReportVisitor {
        String visitText(TextNode node);

        String visitSection(SectionNode node);
    }

    static final class PlainTextVisitor implements ReportVisitor {
        public String visitText(TextNode node) {
            return node.text();
        }

        public String visitSection(SectionNode node) {
            return node.children().stream().map(child -> child.accept(this)).toList().toString();
        }
    }
}
