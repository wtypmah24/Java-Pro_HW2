package org.HW_021123.obstacle;

public enum Obstacle {
    PIT(10),

    PUDDLE(15),

    BORDER(26),

    BROKEN_GLASS(35),

    ROCK(24);

    private final int damage;

    Obstacle(int obstacleType) {
        this.damage = obstacleType;
    }

    public int getDamage() {
        return damage;
    }
}
