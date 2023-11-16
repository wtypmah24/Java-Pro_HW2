package org.HW_141123.task_1.pizza;

import org.HW_141123.task_1.pizza.sauce.Sauce;

public class Pizza {
    private final String crust;
    private final Sauce sauce;
    private final boolean cheese;
    private final boolean pepperoni;
    private final boolean mushrooms;

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "crust='" + crust + '\'' +
                ", sauce=" + sauce +
                ", cheese=" + cheese +
                ", pepperoni=" + pepperoni +
                ", mushrooms=" + mushrooms +
                '}';
    }

    private Pizza(String crust, Sauce sauce, boolean cheese, boolean pepperoni, boolean mushrooms) {
        this.crust = crust;
        this.sauce = sauce;
        this.cheese = cheese;
        this.pepperoni = pepperoni;
        this.mushrooms = mushrooms;
    }

    public static class Builder {
        private String crust;
        private Sauce sauce = Sauce.UNKNOWN;
        private boolean cheese = false;
        private boolean pepperoni = false;
        private boolean mushrooms = false;

        public Builder crust(String crust) {
            this.crust = crust;
            return this;
        }

        public Builder sauce(Sauce sauce) {
            this.sauce = sauce;
            return this;
        }

        public Builder cheese(boolean cheese) {
            this.cheese = cheese;
            return this;
        }

        public Builder pepperoni(boolean pepperoni) {
            this.pepperoni = pepperoni;
            return this;
        }

        public Builder mushrooms(boolean mushrooms) {
            this.mushrooms = mushrooms;
            return this;
        }

        public Pizza build() {
            return new Pizza(crust, sauce, cheese, pepperoni, mushrooms);
        }
    }
}
