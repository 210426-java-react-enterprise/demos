package com.revature.functional_java;

import com.revature.functional_java.models.AppUser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDriver {

    public static void main(String[] args) {

        AppUser chris = new AppUser("Chris", "New York", 22, Arrays.asList("Java", "SQL", "JDBC"));
        AppUser kyle = new AppUser("Kyle", "New York", 35, Arrays.asList("Java", "SQL", "JDBC"));
        AppUser ej = new AppUser("EJ", "New York", 22, Arrays.asList("Java", "SQL", "JDBC"));
        AppUser thomas = new AppUser("Thomas", "California", 32, Arrays.asList("Java", "SQL", "JDBC"));
        AppUser seunghoon = new AppUser("Seunghoon", "Ohio", 51, Arrays.asList("Java", "SQL", "JDBC"));
        AppUser ann = new AppUser("Ann", "Florida", 25, Arrays.asList("Java", "SQL", "JDBC"));
        AppUser nobody = new AppUser("", "nowhere", 17, new ArrayList<>());

        List<AppUser> users = new ArrayList<>(Arrays.asList(chris, kyle, ej, thomas, seunghoon, ann, nobody));

        long numberOfEmptyNames = users.stream()
                                       .map(AppUser::getName) // this is an intermediate operation, it returns a new Stream
                                       .filter(String::isEmpty) // this is also an intermediate operation
                                       .count(); // this is a terminal operation (it does not return another Stream)

        System.out.println("The number of users with an empty string for a name is: " + numberOfEmptyNames);

        Stream<AppUser> userStream = users.stream();
        Stream<String> nameStream = userStream.map(AppUser::getName);
        Stream<String> nonEmptyNamesStream = nameStream.filter(name -> !name.isEmpty());
        long numberOfNonEmptyNames = nonEmptyNamesStream.count();
        System.out.println("The number of users with an non-empty string for a name is: " + numberOfNonEmptyNames);

        // The underlying structure is unmodified by the functional operations we are performing
        users.forEach(System.out::println);

        /*
            Optional class
                - Acts as a container for a potentially null value
                - Provides useful methods for handling null values in a cleaner manner
                - Useful methods:
                    + T get()
                    + boolean isPresent(Consumer c)
                    + T orElse(T t)
                    + T orElseThrow(Supplier s)
         */

        Optional<AppUser> nick = users.stream()
                                      .filter(u -> u.getName().equals("Nick"))
                                      .findFirst();

        // Nick is not present in our list of users, so the sout below does not run.
        nick.ifPresent(n -> System.out.println("This is " + n.getName() + ", he says hi."));
        AppUser maybeNick = nick.orElseThrow(() -> new RuntimeException("No user with name nick present!"));


        int ageSum = users.stream()
                          .map(AppUser::getAge)
                          .reduce(0, (age1, age2) -> age1 + age2);

        System.out.println(ageSum);

        /*
            Flat Map
                - flattens nested streams into a single stream
         */

        // gross
        List<Stream<String>> skillStream = users.stream()
                                           .map(user -> user.getSkills().stream()) // returns a Stream<Stream<String>>
                                           .collect(Collectors.toList());

        // better
        List<String> skills = users.stream()
                                   .flatMap(user -> user.getSkills().stream()) // returns a Stream<String>
                                   .collect(Collectors.toList());

        /*
            Java 8 introduced a package: java.util.function

                - a set of functional interfaces
                - there are more than 40 individual interfaces provided by this package

                - organized into 4 main categories (there is a 5th we will discuss):

                    - Supplier<T>
                        + T get();
                        + takes in no value; returns a value

                    - Consumer<T>
                        + void accept(T val);
                        + takes in a value; returns no value

                    - Predicate<T>
                        + boolean test(T val);
                        + takes in a value; returns a boolean

                    - Function<T, R>
                        + T = the parameter, R = return type
                        + R apply(T val);
                        + takes in a value of type T, returns a value of type R

                The fifth type of functional interface is not actually in the java.util.function
                package. It comes from java.lang, and is the Runnable interface (since java 1.0)
                    + void run();
                    + takes in nothing; returns nothing
         */

        Supplier<String> stringSupplier = () -> {
            return "supplied string";
        };

        System.out.println(stringSupplier.get());

    }



}
