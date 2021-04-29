package com.revature.intro;

/**
 * Created by IntelliJ IDEA.
 * User: Jbialon
 * Date: 4/28/2021
 * Time: 11:36 AM
 * Description: {Insert Description}
 */
public class Driver {

    // Static makes this variable class based not instanced based.
    static int[] ourArray;

    public static void main(String[] args) {

        int[] intArray1 = new int[10];
        ourArray = createArrayOfSize(10);

        System.out.println(ourArray.length);

        for (int i : intArray1) {
            System.out.println(i);
        }

        int[] intArray2 = { 1, 3, 4, 9, 12, 18 };
        System.out.println(intArray2[3]);

    }

    // Non-static = instance level scope
    public int[] createArrayOfSize_instance(int size){
        return new int[size];
    }

    public static int[] createArrayOfSize(int size){
        return new int[size];
    }
}
