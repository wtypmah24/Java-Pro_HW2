package org.HW_091123.task_1;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class RandomNumbersTest {
    RandomNumbers randomNumbers = new RandomNumbers();

    @Test
    void positiveTestGetRandomEvenInteger() {
        Random random = Mockito.mock(Random.class);
        Mockito.when(random.nextInt(-100, 99)).thenReturn(-88);
        int expected = -87;
        assertEquals(expected, randomNumbers.getRandomEvenInteger(random));
    }

    @Test
    void checkIfMethodThrowsException(){
        assertThrows(IllegalArgumentException.class, () -> randomNumbers.getRandomEvenInteger(null));
    }

    @Test
    void checkLimits(){
        for (int i = 0; i < 1000; i++){
            int result = randomNumbers.getRandomEvenInteger(new Random());
            assertTrue(result >= -100 && result <= 100);
        }
    }

    @Test
    void checkForEvenNumbers(){
        for (int i = 0; i < 1000; i++){
            int result = randomNumbers.getRandomEvenInteger(new Random());
            assertTrue(result % 2 != 0);
        }
    }
}