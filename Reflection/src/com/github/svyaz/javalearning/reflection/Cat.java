package com.github.svyaz.javalearning.reflection;

public class Cat extends Animal {
    private static final String TYPE = "cat";
    private String name;

    /**
     * Creates a cat with name
     *
     * @param name of the cat
     */
    public Cat(String name) {
        this.name = name;
    }

    /**
     * @return animal name.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Animal moves itself
     */
    @Override
    public void move() {
        System.out.println(TYPE + " " + name + " is ignoring it.");
    }

    /**
     * Animal says something
     */
    @Override
    public void say() {
        System.out.println("Meow, meow.");
    }

    @Override
    public String toString() {
        return "Cat { TYPE = '" + TYPE + "', name = '" + name + "'}";
    }
}
