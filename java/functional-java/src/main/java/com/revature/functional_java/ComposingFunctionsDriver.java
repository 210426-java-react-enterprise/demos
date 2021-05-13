package com.revature.functional_java;

import com.revature.functional_java.models.AppUser;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComposingFunctionsDriver {

    public static void main(String[] args) {
        List<String> myStrings = Arrays.asList("one", "two", "three", "four", "five",
                                               "six", "seven", "eight", "nine");

        Comparator<String> gross = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        };

        Comparator<String> better = (String s1, String s2) -> s1.compareTo(s2);

        Comparator<String> best = String::compareTo;

        System.out.println(myStrings);
        myStrings.sort(best);
        System.out.println(myStrings);

        Comparator<String> reverse_better = (String s1, String s2) -> s2.compareTo(s1);
        Comparator<String> reverse_best = Comparator.reverseOrder();

        myStrings.sort(reverse_best);
        System.out.println(myStrings);

        System.out.println("+--------------------------------+");

        //-------------------------------------------------------

        List<AppUser> users = Arrays.asList(new AppUser("Nick", "Pennsylvania", 25),
                                            new AppUser("Sheckeem", "Florida", 25),
                                            new AppUser("Ozzy", "Texas", 39),
                                            new AppUser("Nick", "Florida", 25),
                                            new AppUser("Sean", "Colorado", 44),
                                            new AppUser("Wezley", "Florida", 30));

        Comparator<AppUser> userComparator = Comparator.comparing(AppUser::getName)
                                                       .thenComparing(AppUser::getAge)
                                                       .thenComparing(AppUser::getState);

        users.forEach(System.out::println);
        users.sort(userComparator);
        System.out.println("+---------------------------+");
        users.forEach(System.out::println);



    }
}
