package com.github.svyaz.javalearning.lambdas;

import org.junit.Assert;
import org.junit.Test;

public class PersonTest {
    @Test
    public void constructorTest() {
        Person person = new Person("Vasya", 25);
        Assert.assertTrue(person.getName().equals("Vasya") && person.getAge() == 25);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorExceptionByAgeTest() {
        new Person("Vasya", 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorExceptionByNameTest() {
        new Person("", 25);
    }

    @Test
    public void getNameTest() {
        Person person = new Person("Arkadiy", 15);
        Assert.assertEquals(person.getName(), "Arkadiy");
    }

    @Test
    public void getAgeTest() {
        Person person = new Person("Arkadiy", 31);
        Assert.assertEquals(person.getAge(), 31);
    }

    @Test
    public void toStringTest() {
        Person person = new Person("Alen Prost", 60);
        Assert.assertEquals(person.toString(), "Person {name = 'Alen Prost', age = 60}");
    }

    @Test
    public void equalsSameObjectTest() {
        Person person = new Person("Pastor Maldonado", 30);
        Assert.assertEquals(person, person);
    }

    @Test
    public void equalsNullTest() {
        Person person = new Person("Nico Hulkenberg", 28);
        Assert.assertNotEquals(person, null);
    }

    @Test
    public void equalsDifferentTypesObjectsTest() {
        Person person = new Person("Jenson Button", 39);
        Assert.assertNotEquals(person, "Jenson Button");
    }

    @Test
    public void equalsTrueTest() {
        Person person1 = new Person("Lewis Hamilton", 35);
        Person person2 = new Person("Lewis Hamilton", 35);
        Assert.assertEquals(person1, person2);
    }

    @Test
    public void equalsFalseTest() {
        Person person1 = new Person("Lewis Hamilton", 35);
        Person person2 = new Person("Valteri Bottas", 35);
        Assert.assertNotEquals(person1, person2);
    }

    @Test
    public void hashCode1Test() {
        Person person = new Person("Sebastian Vettel", 33);
        Assert.assertEquals(person.hashCode(), -1863091689);
    }

    @Test
    public void hashCode2Test() {
        Person person1 = new Person("Daniil Kvyat", 27);
        Person person2 = new Person("Daniil Kvyat", 27);
        Assert.assertEquals(person1.hashCode(), person2.hashCode());
    }

    @Test
    public void hashCode3Test() {
        Person person1 = new Person("Daniil Kvyat", 27);
        Person person2 = new Person("Alex Albon", 23);
        Assert.assertNotEquals(person1.hashCode(), person2.hashCode());
    }
}
