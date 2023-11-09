package org.HW_051023.hw_3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Bicycle mountBike = new Bicycle(2, 18,"BMW", BikeType.MOUNTBIKE);
        Bicycle speedBike = new Bicycle(2, 21, "Shimano", BikeType.RACINGBIKE);
        Bicycle kidBike = new Bicycle(3, 1, "Gnomik", BikeType.KIDSBIKE);
        System.out.println(mountBike);
        System.out.println(speedBike);
        System.out.println(kidBike);

        Bicycle[] bikes = {mountBike, speedBike, kidBike};
        System.out.println(Arrays.toString(bikes));

    }
}
