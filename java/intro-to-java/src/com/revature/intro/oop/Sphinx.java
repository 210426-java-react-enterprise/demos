package com.revature.intro.oop;

import java.io.IOException;

public class Sphinx extends Cat {

    public Sphinx() {
        super();
    }

    /*
        Using @Override

        While not actually required by the compiler to indicate that the annotated method
        will be overriding an inherited method from the parent class, it is considered
        good practice to include it on overridden methods.

        Additionally, using @Override can help you to ensure that you are properly overriding
        an inherited method (ensures that the method signature is compatible). If the annotated
        method's signature is not compatible with the inherited method's signature, a compiler
        error will be thrown.

     */

    @Override
    public void makeSound() {
        System.out.println("meow. (sphinx)");
    }

    /*
        Overridden Method Signature Compatibility

        When overriding a method inherited from a parent class, there are variations to the
        inherited method's signature that can be made in the overriding method:

            - The access modifier can be made to be more visible
            - The type of the input parameters can be that of a sub type
            - The return type can be substituted with a sub type
            - Any unchecked exceptions can be added to the throws clause
            - Sub types of the inherited method's thrown checked exceptions can be used in the throws clause

     */

    @Override
    public void setCatNumberOfLives(int newLives) throws RuntimeException {
        super.setCatNumberOfLives(newLives);
    }



}
