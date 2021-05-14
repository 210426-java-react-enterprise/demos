package com.revature.reflective_java.loading_classes;

import com.revature.reflective_java.loading_classes.classloaders.CustomClassLoader;
import com.revature.reflective_java.loading_classes.nested_app.models.AppUser;
import com.revature.reflective_java.loading_classes.nested_app.util.Entity;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class Driver {

    public static void main(String[] args) {

        try {
            Driver driver = new Driver();
            driver.exploringClasses();

            System.out.println("+------------------------------------+");

            List<Class<?>> modelClasses = driver.getClassesInPackage("com.revature.reflective_java.loading_classes.nested_app.models");
            for (Class<?> model : modelClasses) {
                System.out.println(model);
            }

            System.out.println("+------------------------------------+");

            String packageName = "com.revature.reflective_java.loading_classes.nested_app.models";
            List<Class<?>> entityClasses = driver.getClassesInPackageWithConstraints(packageName,
                                                    clazz -> clazz.isAnnotationPresent(Entity.class));
            for (Class<?> entity : entityClasses) {
                driver.exploreClassMembers(entity);
                System.out.println();
            }

            driver.exploreClassMembers(driver.getClass());

            System.out.println("+------------------------------------+");

            driver.guessWho("this is a string");
            driver.guessWho(new AppUser());
            driver.guessWho(new Object());

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

    public List<Class<?>> getClassesInPackage(String packageName) throws MalformedURLException, ClassNotFoundException {

        List<Class<?>> packageClasses = new ArrayList<>();
        List<String> classNames = new ArrayList<>();

        File packageDirectory = new File("target/classes/" + packageName.replace('.', '/'));

        for (File file : Objects.requireNonNull(packageDirectory.listFiles())) {
            if (file.isDirectory()) {
                packageClasses.addAll(getClassesInPackage(packageName + "." + file.getName()));
            } else if (file.getName().contains(".class")) {
                classNames.add(file.getName());
            }
        }

        URLClassLoader ucl = new URLClassLoader(new URL[] { new File("target/classes/").toURI().toURL() });

        for (String className : classNames) {
            packageClasses.add(ucl.loadClass(packageName + "." + className.substring(0, className.length() - 6)));
        }

        return packageClasses;

    }

    public List<Class<?>> getClassesInPackageWithConstraints(String packageName, Predicate<Class<?>> predicate) throws MalformedURLException, ClassNotFoundException {

        List<Class<?>> packageClasses = new ArrayList<>();
        List<String> classNames = new ArrayList<>();

        File packageDirectory = new File("target/classes/" + packageName.replace('.', '/'));

        for (File file : Objects.requireNonNull(packageDirectory.listFiles())) {
            if (file.isDirectory()) {
                packageClasses.addAll(getClassesInPackageWithConstraints(packageName + "." + file.getName(), predicate));
            } else if (file.getName().contains(".class")) {
                classNames.add(file.getName());
            }
        }

        URLClassLoader ucl = new URLClassLoader(new URL[] { new File("target/classes/").toURI().toURL() });

        for (String className : classNames) {
            Class<?> clazz = ucl.loadClass(packageName + "." + className.substring(0, className.length() - 6));
            if (predicate.test(clazz)) {
                packageClasses.add(clazz);
            }
         }

        return packageClasses;
    }

    public void exploreClassMembers(Class<?> clazz) {
        System.out.println("Class name: " + clazz);

        Annotation[] classAnnotations = clazz.getAnnotations();
        printMembers(classAnnotations, "Annotations");

        Field[] declaredClassFields = clazz.getDeclaredFields();
        printMembers(declaredClassFields, "Declared Fields");

        Method[] declaredClassMethods = clazz.getDeclaredMethods();
        printMembers(declaredClassMethods, "Declared Methods");

        Field[] classFields = clazz.getFields();
        printMembers(classFields, "All Fields");

        Method[] classMethods = clazz.getMethods();
        printMembers(classMethods, "All Methods");

    }

    private void printMembers(Object[] members, String memberType) {
        if (members.length != 0) {
            System.out.println("\t" + memberType + " on class: ");
            for (Object o : members) {
                System.out.println("\t\t- " + o);
            }
        }
    }

    private void guessWho(Object o) {
        Class<?> oClass = Objects.requireNonNull(o.getClass());
        System.out.println(oClass);
    }

}
