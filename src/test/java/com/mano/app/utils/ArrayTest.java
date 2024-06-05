package com.mano.app.utils;

import static org.junit.Assert.assertFalse;
import java.util.Arrays;
import org.junit.Test;

/**
 * ArrayTest
 */
public class ArrayTest {

    // @Test
    // public void testRemove() {
    // Integer[] array1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    // Integer[] expected1 = { 1, 2, 3, 4, 6, 7, 8, 9 };
    // Array arrayUtil = new Array();
    // Integer[] output1 = arrayUtil.remove(array1, 4);
    // assertArrayEquals("Test Remove", expected1, output1);
    // }
    @Test
    public void testShuffle() {
        Integer[] array1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        Integer[] expected1 = { 1, 2, 3, 4, 6, 7, 8, 9 };
        Array arrayUtil = new Array();
        arrayUtil.shuffle(array1);
        arrayUtil.print(array1);
        assertFalse(Arrays.equals(array1, expected1));
    }
}
