package com.revature.intro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Driver {

    int[] nonStaticArray = new int[5];
    static int[] ourArray;

    public static void main(String[] args) {

        int[] intArray1 = new int[10]; // an empty array of ints, with space for 10 elements
        ourArray = createArrayOfSize(10);
        System.out.println(ourArray); // prints [I@5e2de80c

        boolean[] test = new boolean[3];
        System.out.println(test); // prints [Z@1d44bcfa

        double[] test2 = new double[3];
        System.out.println(test2); // [D@266474c2

        // methinks that the second value in the output string refers to the data type contained within the array

        // to reference non-static members from a static context
        // you need an instance of the class
        // btw: making an instance of class within itself is not
        // a normal/common practice
        Driver driverInstance = new Driver();
        driverInstance.nonStaticArray = null;

        System.out.println(ourArray.length);

        for (int i : intArray1) {
            System.out.println(i);
        }

        System.out.println("+---------------+");

        int[] intArray2 = { 2, 4, 6, 8, 10, 12 }; // array literal

        // remember: Java arrays use 0-based indexing
        System.out.println(intArray2[3]); // access members in an array using bracket notation

        int[][] multiDimensionalArray1 = new int[3][3];

        int[][] multiDimensionalArray2 = {
            { 4, 2, 4 },
            { 3, 5, 6 },
            { 7, 1, 9 }
        };

        Arrays.sort(multiDimensionalArray2);

        int[][] multiDimensionalArray3 = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9, 10 }
        };

        for (int i = 0; i < multiDimensionalArray3.length; i++) {
            for (int j = 0; j < multiDimensionalArray3[i].length; j++) {
                System.out.printf("Array %d, value: %d\n", i, multiDimensionalArray3[i][j]);
            }
        }

//        System.out.println(intArray1[10]); // throws ArrayIndexOutOfBoundsException

        System.out.println("+---------------+");
        printValues(); // valid with nothing!
        printValues("hello");
        printValues("goodbye", "see ya later");

        String[] strArray = { "Wezley", "Nick", "Robert", "Genesis" };
        printValues(strArray); // takes a String[] as well!

        // The Arrays utility class
        int[] arrayForSorting = { 4, 1, -1, 0, 0, 34, 9, 93};
        Arrays.sort(arrayForSorting);
        for (int value : arrayForSorting) {
            System.out.println(value);
        }

        System.out.println("+------------+");

        int[] aBitLargerArray = Arrays.copyOf(arrayForSorting, arrayForSorting.length + 1);
        for (int value : aBitLargerArray) {
            System.out.println(value);
        }

        Object[] crazyArray = {new Object(), "hello", 3, 3.14, true};

        Object[][] multiDimensionalArray4 = {
                { 1, 2, 3 },
                { "gross", 5, 6 }
        };

        String gross = (String) multiDimensionalArray4[1][0]; // explicit casting!
        System.out.println(gross);

        String mistake = (String) multiDimensionalArray4[0][0]; // throws a ClassCastException!
        System.out.println(mistake);


    }

    // instance method!
    public int[] createArrayOfSize_instance(int size) {
        return new int[size];
    }

    // class-scope (static) method!
    public static int[] createArrayOfSize(int size) {
        return new int[size];
    }

    // methods with a varargs parameter can take in 0 or more arguments
    // only one vararg param is allow in a method
    // the varargs param must be the last one in the parameters list
    public static void printValues(String... strings) {

        if (strings.length == 0) {
            System.out.println("Nothing provided!");
        }

        for (String string : strings) {
            System.out.println(string);
        }

    }

}
