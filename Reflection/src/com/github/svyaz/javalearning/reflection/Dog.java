package com.github.svyaz.javalearning.reflection;

public class Dog extends Animal {
    private String name;

    /**
     * Creates a dog with name
     *
     * @param name of the dog
     */
    public Dog(String name) {
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
        System.out.println(name + " moved.");
    }

    /**
     * Animal says something using private method.
     */
    @Override
    public void say() {
        System.out.println(getVoice());
    }

    private String getVoice() {
        return "Wof, wof.";
    }
}
