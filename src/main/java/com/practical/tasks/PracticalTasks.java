package com.practical.tasks;

import java.math.BigInteger;

public class PracticalTasks {

    public static void main(String[] args) {
        task_1_0 ();
    }

    public static void task_1_0(){
        Integer[] arr1 = new Integer[20];
        Integer maxValue;
        Integer minValue;
        Integer count = 0;

        for (int i=0; i < arr1.length; i++) {
            arr1[i] = (int)(Math.random()*100);
            System.out.print(arr1[i] + " ");
        }
        maxValue = minValue = arr1[0];

        for (int j = 0; j < arr1.length; j++) {
            if (arr1[j] > maxValue) {
                maxValue = arr1[j];
            }
            if (arr1[j] < minValue) {
                minValue = arr1[j];
            }
            count += arr1[j];

        }
        System.out.println();
        System.out.println("Average value: " + count/arr1.length);
        System.out.println("Max value in array: " + maxValue);
        System.out.println("Min value in array: " + minValue);
     }
}
