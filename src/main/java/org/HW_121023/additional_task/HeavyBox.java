package org.HW_121023.additional_task;

public class HeavyBox {

    private final int id;
    private final double weight;
    private final double boxVolume;

    public HeavyBox(int id, double weight, double boxVolume) {
        this.id = id;
        this.weight = weight;
        this.boxVolume = boxVolume;
    }

    public int getId() {
        return id;
    }

    public double getWeight() {
        return weight;
    }

    public double getBoxVolume() {
        return boxVolume;
    }
}
