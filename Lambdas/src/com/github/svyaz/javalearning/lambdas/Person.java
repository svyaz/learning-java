package com.github.svyaz.javalearning.lambdas;

import java.util.Objects;

public class Person {
    private static final String MSG_ILLEGAL_PERSON_PARAMETERS = "Parameters must be: 'age' > 0 and 'name' not empty.";
    /**
     * Person's name
     */
    private String name;

    /**
     * Person's age
     */
    private int age;

    /**
     * Creates a Person instance with filled name and age.
     *
     * @param name Person's name
     * @param age  Person's age
     */
    public Person(String name, int age) {
        if (age < 1 || name.isEmpty()) {
            throw new IllegalArgumentException(MSG_ILLEGAL_PERSON_PARAMETERS);
        }
        this.name = name;
        this.age = age;
    }

    /**
     * Person's name getter.
     *
     * @return Person's name
     */
    public String getName() {
        return name;
    }

    /**
     * Person's age getter.
     *
     * @return Person's age
     */
    public int getAge() {
        return age;
    }

    /**
     * Returns string representation of the Person.
     *
     * @return Returns string representation of the Person
     */
    @Override
    public String toString() {
        return "Person {name = '" + name + '\'' + ", age = " + age + '}';
    }

    /**
     * Compares the person to the specified object.
     *
     * @param object to compare person to.
     * @return true if the object is equals to the person.
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Person person = (Person) object;
        if (age != person.age) {
            return false;
        }
        return Objects.equals(name, person.name);
    }

    /**
     * Calculates hash code of the person.
     *
     * @return hash code of the person.
     */
    @Override
    public int hashCode() {
        return 37 * age + Objects.hashCode(name);
    }
}
