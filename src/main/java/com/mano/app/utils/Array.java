package com.mano.app.utils;

import java.util.Random;

/**
 * Array
 */
public class Array {

    public void shuffle(Integer[] arr) {
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            int index = rand.nextInt(arr.length - i) + i;
            Integer temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
    }

    public Integer[] restart(int length) {
        Integer[] res = new Integer[length];
        for (int i = 0; i < length; i++) {
            res[i] = i + 1;
        }
        return res;
    }

    public Integer[] createIndexArray(int length) {
        Integer[] res = new Integer[length];
        for (int i = 0; i < length; i++) {
            res[i] = i;
        }
        return res;
    }

    public void print(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }

    public Integer[] remove(Integer[] arr, int index) {
        Integer[] res = new Integer[arr.length - 1];
        for (int i = 0, k = 0; i < arr.length; i++) {
            if (i != index) {
                res[k++] = arr[i];
            }
        }
        return res;
    }
}
