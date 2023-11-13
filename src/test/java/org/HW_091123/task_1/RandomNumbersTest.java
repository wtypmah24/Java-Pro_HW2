package org.HW_091123.task_1;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
}