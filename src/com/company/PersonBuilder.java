package com.company;

public class PersonBuilder {

    private String name;
    private String surname;
    private int age = -1;
    private String address;

    public PersonBuilder setName(String name) throws IllegalStateException {
        if (name.isEmpty() || name == null) {
            throw new IllegalStateException("Не задано имя");
        } else this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        if (surname.isEmpty() || surname == null) {
            throw new IllegalStateException("Не задана фамилия");
        } else this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalStateException("Неверно задан возраст");
        } else this.age = age;
        return this;

    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        Person person;
        if (name == null || surname == null) throw new IllegalStateException("Не задано имя или фамилия");
        if (age < 0) {
            person = new Person(name, surname);
        } else person = new Person(name, surname, age);
        person.setAddress(address);
        return person;
    }
}
