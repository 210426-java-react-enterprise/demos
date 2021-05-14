package com.revature.reflective_java.loading_classes;

import com.revature.reflective_java.loading_classes.classloaders.CustomClassLoader;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Driver {

    public static void main(String[] args) {

        try {
            Driver driver = new Driver();
            driver.exploringClasses();

            System.out.println("+------------------------------------+");

            List<Class<?>> modelClasses = driver.getClassesInPackage("com.revature.reflective_java.loading_classes.nested_app.models");

            System.out.println("+------------------------------------+");

        } catch (ClassNotFoundException | MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void exploringClasses() throws ClassNotFoundException, MalformedURLException {

        // Accessing a class object using the class literal on types
        Class<?> thisClass = Driver.class;
        System.out.println(thisClass);

        // Accessing a class object using the getClass() instance method
        Class<?> sameClass = this.getClass();
        System.out.println(sameClass);

        // Accessing a class object using the current thread's classloader
        ClassLoader currentClassLoader = Thread.currentThread().getContextClassLoader();;
        Class<?> someClass = currentClassLoader.loadClass("com.revature.reflective_java.loading_classes.Driver");
        System.out.println(someClass);

        // Accessing a class object using a URLClassLoader to load potentially external class files
        URL[] urls = new URL[] { new File("target/classes/").toURI().toURL() };
        URLClassLoader ucl = new URLClassLoader(urls);
        Class<?> anotherClass = ucl.loadClass("com.revature.reflective_java.loading_classes.Driver");
        System.out.println(anotherClass);

        // Here is an example of grabbing a class file from a completely different application
        // and loading into the this application's memory
        URL[] urls_1 = new URL[] { new File("../../quizzard/target/classes/").toURI().toURL() };
        URLClassLoader ucl_1 = new URLClassLoader(urls_1);
        Class<?> quizzardDriver = ucl_1.loadClass("com.revature.quizzard.Driver");
        System.out.println(quizzardDriver);

        // All references to a Class class of the same type point to the same object in memory
        System.out.println(thisClass == sameClass); // true
        System.out.println(sameClass == someClass); // true
        System.out.println(someClass == anotherClass); // true

        // Unless...
        Class<?> aClass = new CustomClassLoader().loadClass("com.revature.reflective_java.loading_classes.Driver");
        Class<?> diffClass = new CustomClassLoader().loadClass("com.revature.reflective_java.loading_classes.Driver");
        System.out.println(aClass == diffClass); // false

        // Even though Quizzard's Driver and this application's Driver have the same simple name
        // they have differing "fully-qualified" name
        System.out.println(quizzardDriver == thisClass); // false

    }

    public List<Class<?>> getClassesInPackage(String packageName) {

        List<Class<?>> packageClasses = new ArrayList<>();
        List<String> classNames = new ArrayList<>();

        File packageDirectory = new File("target/classes/" + packageName.replace('.', '/'));

        for (File file : Objects.requireNonNull(packageDirectory.listFiles())) {
            if (file.isDirectory()) {
                packageClasses.addAll(getClassesInPackage(packageName + "." + file.getName()))
            } else if (file.getName().contains(".class")) {
                classNames.add(file.getName());
            }
        }

        return packageClasses;

    }

}
