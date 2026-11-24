package com.lld.gof.creational.builder.practice;

public class BuilderPractice {
    public static void main(String[] args) {
        PracticeCourse course = PracticeCourse.builder()
                .name("LLD")
                .level("Intermediate")
                .durationInHours(40)
                .certificateIncluded(true)
                .build();

        System.out.println(course.summary());
    }

    /*
     * Builder Practice
     *
     * Goal:
     * Avoid telescoping constructors like Course(String, String, int, boolean).
     *
     * Learning task:
     * Implement validation inside build(), not randomly in main.
     */
    static final class PracticeCourse {
        private final String name;
        private final String level;
        private final int durationInHours;
        private final boolean certificateIncluded;

        private PracticeCourse(Builder builder) {
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

            PracticeCourse build() {
                // TODO: Builder task
                // Validate required fields before object creation.
                return new PracticeCourse(this);
            }
        }
    }
}
