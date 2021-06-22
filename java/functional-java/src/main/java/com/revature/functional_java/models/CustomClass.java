package com.revature.functional_java.models;

import java.util.Comparator;

public class CustomClass {

    public CustomClass(Runnable runnable) {
        System.out.println("CustomClass#Runnable constructor invoked");
    }

    public CustomClass(CustomRunnable customRunnable) {
        System.out.println("CustomClass#CustomRunnable constructor invoked");
    }

    public void foo() {
        System.out.println("Foo invoked!");
    }
}
