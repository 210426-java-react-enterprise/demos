package com.revature.intro;

public class Driver {

    static int[] ourArray;

    public static void main(String[] args) {
        int[] intArray1 = new int[10];
        ourArray = createArrayOfSize(10);

        System.out.println(ourArray.length);

        for (int i : intArray1){
            System.out.println(i);
        }

        int[] intArray2 = {2, 4, 6, 8, 10, 12};
    }

    //instance method!
    public int[] createArrayOfSize_instance(int size){
        return new int[size];
    }

    //class-scope (static) method!
    public static int[] createArrayOfSize(int size){
        return new int[size];
    }

    //Strings... = strings of any size?  variable argument (vararg)
    // methods with varargs parameter can take in 0 or more arguments
    // only 1 vararg param is allowed in a method
    // the varargs param must be the last one in the parameter list
    public static void printValues(String... strings){
        if(strings.length == 0){
            System.out.println("Nothing provided!");
        }

        for (int i = 0; i < strings.length; i++){
            System.out.println(strings[i]);
        }


    }

}