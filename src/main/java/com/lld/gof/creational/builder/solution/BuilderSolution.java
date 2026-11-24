package com.lld.gof.creational.builder.solution;

public class BuilderSolution {
    public static void main(String[] args) {
        Course course = Course.builder()
                .name("LLD")
                .level("Intermediate")
                .durationInHours(40)
                .certificateIncluded(true)
                .build();

        System.out.println(course.summary());
    }

    /*
     * Builder Pattern
     *
     * Intent:
     * Build complex objects step by step without a huge constructor.
     *
     * Good use case:
     * Object has many optional fields or needs validation before creation.
     */
    static final class Course {
        private final String name;
        private final String level;
        private final int durationInHours;
        private final boolean certificateIncluded;

        private Course(Builder builder) {
            this.name = builder.name;
            this.level = builder.level;
            this.durationInHours = builder.durationInHours;
            this.certificateIncluded = builder.certificateIncluded;
        }

        static Builder builder() {
            return new Builder();
        }

        String summary() {
            return name + " | " + level + " | " + durationInHours + " hours | certificate="
                    + certificateIncluded;
        }

        static final class Builder {
            private String name;
            private String level;
            private int durationInHours;
            private boolean certificateIncluded;

            Builder name(String name) {
                this.name = name;
                return this;
            }

            Builder level(String level) {
                this.level = level;
                return this;
            }

            Builder durationInHours(int durationInHours) {
                this.durationInHours = durationInHours;
                return this;
            }

            Builder certificateIncluded(boolean certificateIncluded) {
                this.certificateIncluded = certificateIncluded;
                return this;
            }

            Course build() {
                if (name == null || name.isBlank() || level == null || level.isBlank()
                        || durationInHours <= 0) {
                    throw new IllegalStateException("name, level, and positive duration are required");
                }
                return new Course(this);
            }
        }
    }
}
