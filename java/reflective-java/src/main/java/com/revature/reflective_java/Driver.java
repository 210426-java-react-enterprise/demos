package com.revature.reflective_java;

import com.revature.reflective_java.classloaders.CustomClassLoader;
import com.revature.reflective_java.nested_app.models.AppUser;
import com.revature.reflective_java.nested_app.util.Column;
import com.revature.reflective_java.nested_app.util.Entity;
import sun.misc.Unsafe;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Driver {

    public static void main(String[] args) {

        try {
            Driver driver = new Driver();

            say("Welcome to Reflective Java!");
            say("What? No, I'm not a barista, we don't serve coffee here. We learn about Java Reflection.");
            pause(1000);
            say("*though now I do want coffee...*");
            pause(1000);

            while (true) {
                say("Anything you'd like to see?\n" +
                        "a) Tell me about the Class class\n" +
                        "b) Tell me about getting all of the types in a package\n" +
                        "c) Tell me about getting all of the types in a package that meet some criteria\n" +
                        "d) Tell me about how I can create objects using a Class reference\n" +
                        "e) Tell me about how I can invoke methods on an object that is passed to me as an Object\n" +
                        "f) I've been here before, and am looking for something new");

                String choice = getResponse();

                switch (choice.toLowerCase()) {
                    case "a":
                        driver.exploringClasses();
                        break;
                    case "b":
                        driver.getPackageClassesDialogue();
                        break;
                    case "c":
                        driver.filterTypesInPackageDialogue();
                        break;
                    case "d":
                        driver.howToMakeObjectsUsingReflection();
                        break;
                    case "e":
                        break;
                    case "f":
                        driver.seemsSafe();
                        break;
                    default:
                        return;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getPackageClassesDialogue() throws MalformedURLException, ClassNotFoundException {
        try {

            while (true) {
                say("What package in this application would you like to list the classes for?\n" +
                        "a) All of them!\n" +
                        "b) com.revature.reflective_java.classloaders\n" +
                        "c) com.revature.reflective_java.nested_app\n" +
                        "d) com.revature.reflective_java.nested_app.models\n" +
                        "e) com.revature.reflective_java.nested_app.models.enums\n" +
                        "f) com.revature.reflective_java.nested_app.repos\n" +
                        "g) com.revature.reflective_java.nested_app.screens\n" +
                        "h) com.revature.reflective_java.nested_app.services\n" +
                        "i) com.revature.reflective_java.nested_app.util\n" +
                        "j) I changed my mind. I'd like to go.");

                String choice = getResponse();

                List<Class<?>> classes;
                switch (choice.toLowerCase()) {
                    case "a":
                        classes = getClassesInPackage("com.revature.reflective_java");
                        say("These are the types I found in all packages within this application:");
                        classes.forEach(clazz -> System.out.println("\t- " + clazz));
                        break;
                    case "b":
                        classes = getClassesInPackage("com.revature.reflective_java.classloaders");
                        say("These are the types I found within that package:");
                        classes.forEach(clazz -> System.out.println("\t- " + clazz));
                        break;
                    case "c":
                        classes = getClassesInPackage("com.revature.reflective_java.nested_app");
                        say("These are the types I found within that package:");
                        classes.forEach(clazz -> System.out.println("\t- " + clazz));
                        break;
                    case "d":
                        classes = getClassesInPackage("com.revature.reflective_java.nested_app.models");
                        say("These are the types I found within that package:");
                        classes.forEach(clazz -> System.out.println("\t- " + clazz));
                        break;
                    case "e":
                        classes = getClassesInPackage("com.revature.reflective_java.nested_app.models.enums");
                        say("These are the types I found within that package:");
                        classes.forEach(clazz -> System.out.println("\t- " + clazz));
                        break;
                    case "f":
                        classes = getClassesInPackage("com.revature.reflective_java.nested_app.repos");
                        say("These are the types I found within that package:");
                        classes.forEach(clazz -> System.out.println("\t- " + clazz));
                        break;
                    case "g":
                        classes = getClassesInPackage("com.revature.reflective_java.nested_app.screens");
                        say("These are the types I found within that package:");
                        classes.forEach(clazz -> System.out.println("\t- " + clazz));
                        break;
                    case "h":
                        classes = getClassesInPackage("com.revature.reflective_java.nested_app.services");
                        say("These are the types I found within that package:");
                        classes.forEach(clazz -> System.out.println("\t- " + clazz));
                        break;
                    case "i":
                        classes = getClassesInPackage("com.revature.reflective_java.nested_app.util");
                        say("These are the types I found within that package:");
                        classes.forEach(clazz -> System.out.println("\t- " + clazz));
                        break;
                    case "j":
                        say("Sure thing.");
                        return;
                    default:
                        say("Go home, you're drunk");
                        return;
                }
            }

        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

    }

    public void filterTypesInPackageDialogue() throws IOException, ClassNotFoundException, InterruptedException {

        while (true) {
            sayAndPause("So this is pretty much the exact same thing as searching for all the types within a package,\n" +
                        "except this time we introduce a Predicate that is used to test each type against some criteria\n" +
                        "to determine if we want it.", 7000);

            sayAndPause("For instance, say that we want to get all of the types in the models package that are annotated\n" +
                        "with @Entity.", 5000);

            sayAndPause("We may write something like:\n\n" +
                    "String packageName = \"com.revature.reflective_java.nested_app.models\";\n" +
                    "List<Class<?>> entityClasses = getClassesInPackageWithConstraints(packageName, clazz -> clazz.isAnnotationPresent(Entity.class));\n" +
                    "for (Class<?> entity : entityClasses) {\n" +
                    "    exploreClassMembers(entity);\n" +
                    "    System.out.println();\n" +
                    "}", 20000);

            say("Which yields: ");
            String packageName = "com.revature.reflective_java.nested_app.models";
            List<Class<?>> entityClasses = getClassesInPackageWithConstraints(packageName, clazz -> clazz.isAnnotationPresent(Entity.class));
            entityClasses.forEach(entityClass -> System.out.println("\t- " + entityClass));

            say("Did you wanna go through that one more time?");
            String choice = getResponse();

            switch (choice) {
                case "y":
                    say("Let's go again! Let's go again! Let's go again!");
                    break;
                case "n":
                    say("Glad to help, goodbye!");
                    return;
                default:
                    say("Go home, you're drunk.");
                    return;
            }
        }


    }

    public void exploringClasses() throws ClassNotFoundException, MalformedURLException {

        try {

            say("The Class class, eh?");

            sayAndPause("You likely know by this point that every thing in Java can be represented as an object,\n" +
                        "even the primitives have corresponding wrapper classes. But what if I told you that classes\n" +
                        "themselves were represented as objects that were stored in the JVM's heap?", 9000);

            sayAndPause("Let that sink in for second. The class definition you write in your source code has a\n" +
                        "object representation of itself that is stored in the JVM's heap memory even if there are\n" +
                        "no instances of that class.", 9000);

            say("I know that might be a little confusing, so let's discuss things a bit more...");

            sayAndPause("Instances of `Class` class act as a container that holds on to the definition of\n" +
                        "some type which we wish to reflect upon. These definitions are stored as objects in\n" +
                        "the heap are accessible through the `.getClass()` method that exists on every\n" +
                        "object, or the class literal (`.class`) that can be used on type (primitive or not).", 12000);

            say("Let's see some examples of getting access to a types Class reference...");
            say("Accessing a class object using the class literal on types:");
            sayAndPause("Class<?> thisClass = Driver.class;", 6000);

            Class<?> thisClass = Driver.class;
            say("A System.out.println(thisClass) yields: %s\n", thisClass);

            say("+----------------------------------------------------------------------+\n");

            say("Accessing a class object using the getClass() instance method:");
            sayAndPause("Class<?> sameClass = this.getClass();", 6000);

            Class<?> sameClass = this.getClass();
            say("A System.out.println(sameClass) yields: %s\n", sameClass);

            say("+----------------------------------------------------------------------+\n");

            say("Accessing a class object using the current thread's classloader:");
            sayAndPause("ClassLoader currentClassLoader = Thread.currentThread().getContextClassLoader();\n" +
                        "Class<?> someClass = currentClassLoader.loadClass(\"com.revature.reflective_java.Driver\");", 10000);

            ClassLoader currentClassLoader = Thread.currentThread().getContextClassLoader();;
            Class<?> someClass = currentClassLoader.loadClass("com.revature.reflective_java.Driver");
            say("A System.out.println(someClass) yields: %s\n", someClass);

            say("+----------------------------------------------------------------------+\n");

            say("Accessing a class object using a URLClassLoader to load potentially external class files:");
            sayAndPause("URL[] urls = new URL[] { new File(\"target/classes/\").toURI().toURL() };\n" +
                        "URLClassLoader ucl = new URLClassLoader(urls);\n" +
                        "Class<?> anotherClass = ucl.loadClass(\"com.revature.reflective_java.Driver\");", 10000);

            say("Huh? Well, yeah, that class there isn't actually external, but its an example!");

            URL[] urls = new URL[] { new File("target/classes/").toURI().toURL() };
            URLClassLoader ucl = new URLClassLoader(urls);
            Class<?> anotherClass = ucl.loadClass("com.revature.reflective_java.Driver");
            say("Anyway, a System.out.println(anotherClass) yields: %s\n", anotherClass);

            say("+----------------------------------------------------------------------+\n");

            say("You probably noticed that printing out all of those objects yielded the same output string, right?");
            say("Well, that is because all references to a Class class of the same type point to the same object in memory");

            say("System.out.println(thisClass == sameClass) yields: %s", thisClass == sameClass);
            say("System.out.println(sameClass == someClass) yields: %s", sameClass == someClass);
            say("System.out.println(someClass == anotherClass) yields: %s\n", someClass == anotherClass);

            say("+----------------------------------------------------------------------+\n");

            sayAndPause("Now, there is something we could do in order to get a Class to be loaded more than once,\n" +
                        "and that would be to use two separate instances of some custom class loader to load the\n" +
                        "class definition", 8000);

            sayAndPause("Assume that I have written a custom class loader that is intuitively named CustomClassLoader\n" +
                        "and consider the following lines:\n", 4000);

            sayAndPause("Class<?> aClass = new CustomClassLoader().loadClass(\"com.revature.reflective_java.Driver\");\n" +
            "Class<?> diffClass = new CustomClassLoader().loadClass(\"com.revature.reflective_java.Driver\");", 10000);

            Class<?> aClass = new CustomClassLoader().loadClass("com.revature.reflective_java.Driver");
            Class<?> diffClass = new CustomClassLoader().loadClass("com.revature.reflective_java.Driver");
            say("System.out.println(aClass == diffClass) yields: %s\n", aClass == diffClass);

            say("+----------------------------------------------------------------------+\n");

            say("What's that? Load class files from other places outside of the current application?");

            say("Well yeah, it's possible. You'd simply use a URLClassLoader instance with access to the external\n" +
                "file you are targeting.");

            say("There is, of course, the assumption that your application has permission to poke around in the area\n" +
                "where the target file is stored.");

            say("Here is an example of grabbing a class file from a completely different application\n" +
                "and loading it into the this application's memory:");

            sayAndPause("URL[] urls_1 = new URL[] { new File(\"../../quizzard/target/classes/\").toURI().toURL() };\n" +
                        "URLClassLoader ucl_1 = new URLClassLoader(urls_1);\n" +
                        "Class<?> quizzardDriver = ucl_1.loadClass(\"com.revature.quizzard.Driver\");", 12000);

            URL[] urls_1 = new URL[] { new File("../../quizzard/target/classes/").toURI().toURL() };
            URLClassLoader ucl_1 = new URLClassLoader(urls_1);
            Class<?> quizzardDriver = ucl_1.loadClass("com.revature.quizzard.Driver");
            say("A System.out.println(quizzardDriver) yields: %s", quizzardDriver);

            say("+----------------------------------------------------------------------+\n");

            sayAndPause("Even though Quizzard's Driver and this application's Driver have the same simple name\n" +
                "they have differing \"fully-qualified\" name", 5000);
            say("See? A System.out.println(quizzardDriver == thisClass); yields %s\n", quizzardDriver == thisClass);

            sayAndPause("Once you have a reference to the Class object of some type, you can access *anything* you want within\n" +
                "that type's definition: fields, methods (and their parameters), constructors (and their parameters)\n," +
                "nested types, annotations of the class or any of its members, and much more!\n", 10000);

            say("That about wraps up what I can tell you about the Class class. Thanks for listening!");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public List<Class<?>> getClassesInPackage(String packageName) throws MalformedURLException {

        final List<Class<?>> packageClasses = new ArrayList<>();
        List<String> classNames = getClassNamesInPackage(packageName);

        URLClassLoader ucl = new URLClassLoader(new URL[] { new File("target/classes/").toURI().toURL() });
        classNames.forEach(className -> {
            try {
                packageClasses.add(ucl.loadClass(packageName + "." + className.substring(0, className.length() - 6)));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

        return packageClasses;

    }

    public List<String> getClassNamesInPackage(String packageName) {

        List<String> classNames = new ArrayList<>();
        File packageDirectory = new File("target/classes/" + packageName.replace('.', '/'));

        for (File file : Objects.requireNonNull(packageDirectory.listFiles())) {
            if (file.isDirectory()) {
                classNames.addAll(getClassNamesInPackage(packageName + "." + file.getName()));
            } else if (file.getName().contains(".class")) {
                classNames.add(file.getName());
            }
        }

        return classNames;
    }

    public List<Class<?>> getClassesInPackageWithConstraints(String packageName, Predicate<Class<?>> predicate) throws MalformedURLException, ClassNotFoundException {
        List<Class<?>> packageClasses = getClassesInPackage(packageName);
        return packageClasses.stream().filter(predicate).collect(Collectors.toList());
    }

    public void classDefinitionExplorer(Class<?> clazz) {

        try {
            say("\nWelcome to the Class Definition Explorer!");
            say("\nOk, so we are looking at the %s, eh?", clazz.getName());

            while (true) {
                say("\nWhat do you wanna know about it?\n" +
                        "a) Tell me the annotations that exist at the class level\n" +
                        "b) Tell me the fields explicitly declared in the class\n" +
                        "c) Tell me the all of the public fields that the class has\n" +
                        "d) Tell me the methods explicitly declared in the class\n" +
                        "e) Tell me the all of the public methods that the class has\n" +
                        "f) I'm done. Thanks.");
                String choice = getResponse();

                switch (choice.toLowerCase()) {
                    case "a":
                        Annotation[] classAnnotations = clazz.getAnnotations();
                        printMembers(classAnnotations, "Annotations");
                        break;
                    case "b":
                        Field[] declaredClassFields = clazz.getDeclaredFields();
                        printMembers(declaredClassFields, "Declared Fields");
                        break;
                    case "c":
                        Field[] classFields = clazz.getFields();
                        printMembers(classFields, "All Public Fields");
                        break;
                    case "d":
                        Method[] declaredClassMethods = clazz.getDeclaredMethods();
                        printMembers(declaredClassMethods, "Declared Methods");
                        break;
                    case "e":
                        Method[] classMethods = clazz.getMethods();
                        printMembers(classMethods, "All Methods");
                        break;
                    case "f":
                        say("Always a pleasure!");
                        return;
                    default:
                        say("Go home you're drunk.");
                        return;
                }
            }

        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    private void printMembers(Object[] members, String memberType) {
        if (members.length != 0) {
            System.out.println("\t" + memberType + " on class: ");
            for (Object o : members) {
                System.out.println("\t\t- " + o);
            }
        }
    }

    public void objectExplorer(Object o) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException, InterruptedException, IOException {
        say("\nWelcome to the Object Explorer, please wait while we load your object's class definition.");
        Class<?> oClass = Objects.requireNonNull(o.getClass());

        while (true) {
            say("\nLoading complete. What would you like to know?\n" +
                    "a) What is the type of this object?\n" +
                    "b) Get the value of some field within this instance\n" +
                    "c) Invoke some method within this instance\n" +
                    "d) I think I want to know more about this object's class definition\n" +
                    "e) Nothing, I'm done.");

            String choice = getResponse();

            switch (choice.toLowerCase()) {
                case "a":
                    say("The fully qualified name of this object is:\n\t%s", oClass.getName());
                    break;
                case "b":
                    Field[] oClassFields = oClass.getDeclaredFields();
                    for (Field field : oClassFields) {
                        field.setAccessible(true);
                        String simpleName = oClass.getSimpleName() + "." + field.getName();
                        System.out.println(simpleName + " contains the value: " + field.get(o));
                        System.out.println(simpleName + " is annotated with: ");
                        Annotation[] fieldAnnos = field.getAnnotations();
                        for (Annotation anno: fieldAnnos) {
                            System.out.println("\t- " + anno.annotationType().getSimpleName());
                        }
                        field.setAccessible(false);
                    }
                    break;
                case "c":
                    break;
                case "d":
                    say("Sure, let me get you to the right place...");
                    classDefinitionExplorer(oClass);
                    break;
                case "e":
                    say("Ok, see you later");
                    return;
                default:
                    say("Go home you're drunk.");
                    return;

            }
        }




    }

    /**
     * This method requires that the Object passed as an argument must be annotated with @Entity
     * @param o
     */
    private void guessWho(Object o) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {

        System.out.println("Thread.currentThread().getContectClassLoader(): " + Thread.currentThread().getContextClassLoader());
        Class<?> oClass = Objects.requireNonNull(o.getClass());

        if (!oClass.isAnnotationPresent(Entity.class)) {
            throw new RuntimeException("Cannot read values of non-Entity class!");
        }

        System.out.println("Class name: " + oClass);

        Entity entityAnno = oClass.getAnnotation(Entity.class);
        System.out.println("Value inside of @Entity: " + entityAnno.name());

        Field[] oClassFields = oClass.getDeclaredFields();
        for (Field field : oClassFields) {
            field.setAccessible(true);
            String simpleName = oClass.getSimpleName() + "." + field.getName();
            System.out.println(simpleName + " contains the value: " + field.get(o));
            System.out.println(simpleName + " is annotated with: ");
            Annotation[] fieldAnnos = field.getAnnotations();
            for (Annotation anno: fieldAnnos) {

                System.out.println("\t- " + anno.annotationType().getSimpleName());

                if(anno instanceof Column) {
                    Column column = (Column) field.getAnnotation(anno.annotationType());
                    System.out.println("\t\t+ It has the value: " + column.name());
                }


            }
            field.setAccessible(false);
        }

        Method getIdMethod = oClass.getMethod("getId");
        int id = (int) getIdMethod.invoke(o);
        System.out.println(id);

        Method setIdMethod = oClass.getMethod("setId", int.class);
        setIdMethod.invoke(o, 201);

        id = (int) getIdMethod.invoke(o);
        System.out.println(id);

        Constructor<?> objectConstructor = oClass.getConstructor();
        Object obj  = objectConstructor.newInstance();
        System.out.println(obj.getClass() == o.getClass()); // obj and o are of the same type!
        System.out.println(o == obj); // but they are not the same instance!

        AppUser dynamicUser = (AppUser) obj;
        System.out.println(dynamicUser.getId());

    }

    public void howToMakeObjectsUsingReflection() throws InterruptedException, IOException {

        sayAndPause("\nI'm guessing you have found yourself in a scenario where you have access\n" +
            "to some Class reference and you want to make a new object using that reference\n" +
            "since you can use the 'new' keyword to invoke its constructor directly.", 10000);

        say("No worries, I can help with that!");
        sayAndPause("First thing is first, we need to understand that we can access everything\n" +
            "about a type's definition using a Class reference for that type, including\n" +
            "constructors!", 10000);

        sayAndPause("So there is a method, Class#getConstructor(Class<?>...), it will return to us\n" +
            "a reference to an object that represents the constructor that takes in the type\n" +
            "arguments we provide as parameters.", 10000);

        sayAndPause("Once we have an reference to this Constructor object for the type that we want\n" +
            "to create an instance of, we simply need to invoke the Constructor#newInstance(Object...)\n" +
            "method (passing in the required arguments to the constructor). This will yield a\n" +
            "instance of the type for us that we are free to do with as we please.", 10000);

        if (!promptProceed()) return;

        sayAndPause("Consider this method:\n\n" +
            "@SuppressWarnings({\"unchecked\"})\n" +
            "public <T> T makeNewObject(Class<T> clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {\n" +
            "    Constructor<?> objectConstructor = clazz.getConstructor();\n" +
            "    Object obj  = Objects.requireNonNull(objectConstructor.newInstance());\n" +
            "    return (T) obj;\n" +
            "}", 10000);

        say("Yeah, that's a lot of exceptions potentially thrown by such a few lines of code, but that\n" +
            "is what it's like working with Java Reflection!");

        say("Wanna give it a try? Give me the fully qualified class name of some class in this application\n" +
            "that you want an instance of and I'll try to get it for you.");

        String className = getResponse();

        try {
            Object o = makeNewObject(getClassByClassName(className));
            say("There we are!");
            say("Don't take my word for it, let's run it through our object explorer...");
            objectExplorer(o);
            say("Satisfied? I told you I would get it for you!");

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    public Class<?> getClassByClassName(String className) throws ClassNotFoundException {
        ClassLoader currentClassLoader = Thread.currentThread().getContextClassLoader();;
        return currentClassLoader.loadClass("com.revature.reflective_java.Driver");
    }

    @SuppressWarnings({"unchecked"})
    public <T> T makeNewObject(Class<T> clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<?> objectConstructor = clazz.getConstructor();
        Object obj  = Objects.requireNonNull(objectConstructor.newInstance());
        return (T) obj;
    }

    public void seemsSafe() {

        try {
            say("Well, the only thing else I can think to show you at the moment is...");
            pause(1000);
            say("Erm. Maybe I shouldn't...");
            say("...");
            say("Eh, why not. Would you like learn about the sun.misc.Unsafe class?");
            if (!unsafePromptProceed()) return;


            say("Let's see what makes it so \"unsafe\"");
            say("Running: exploreClassMembers(Unsafe.class);");
            classDefinitionExplorer(Unsafe.class);
            pause(10000);
            say("Looks boring honestly...");
            say("...");
            say("...");
            say("...oh, but this seems interesting:\n");
            sayAndPause("There is a static method called \"getTheUnsafe()\". It is decorated by an annotation, @CallerSensitive.", 3000);
            sayAndPause("You can find more information about that annotation and its mechanism here: https://openjdk.java.net/jeps/176", 3000);
            sayAndPause("That's ok though, we can use a little bit of reflection magic to get access to that field, no problem.", 3000);
            sayAndPause("Check it out:\n", 3000);
            say("Unsafe unsafe;\n" +
                "Field f = Unsafe.class.getDeclaredField(\"theUnsafe\");\n" +
                "f.setAccessible(true);\n" +
                "unsafe = (Unsafe) f.get(null);");
            pause(10000);

            Unsafe unsafe;
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            unsafe = (Unsafe) f.get(null);

            say("Let's run our guessWho method...");
            say("Running guessWho(unsafe)");
            guessWho(unsafe);


        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static boolean promptProceed() throws IOException, InterruptedException {
        System.out.print("Should I go on? [y/n]: ");

        String choice = new BufferedReader(new InputStreamReader(System.in)).readLine();
        switch (choice.toLowerCase()) {
            case "y":
            case "yes":
                say("Moving on then.");
                return true;
            case "n":
            case "no":
                say("Ok, I'll stop.");
                return false;
            default:
                say("I'll take that as a no.");
                return false;
        }
    }

    public static boolean unsafePromptProceed() throws IOException, InterruptedException {
        System.out.print("Are you sure? I don't know if it is really safe. [y/n]: ");

        String choice = new BufferedReader(new InputStreamReader(System.in)).readLine();
        switch (choice.toLowerCase()) {
            case "y":
            case "yes":
                say("Alright, if you say so....");
                return true;
            case "n":
            case "no":
                say("Probably a good idea, plenty of other stuff to look at.");
                return false;
            default:
                say("I'll take that as a no. Moving on then...");
                return false;
        }
    }

    public static void say(String msg, Object... args) throws InterruptedException {
        System.out.printf("\n" + msg + "\n", args);
        Thread.sleep(2500);
    }

    public static void pause(long millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    public static void sayAndPause(String msg, long millis) throws InterruptedException {
        if (millis < 2500) {
            say(msg);
            return;
        }
        System.out.println("\n" + msg);
        Thread.sleep(millis);
    }

    public static String getResponse() throws IOException {
        return new BufferedReader(new InputStreamReader(System.in)).readLine();
    }

}
