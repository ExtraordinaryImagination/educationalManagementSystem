package com.chaoge.person;

public class Teacher extends Person {
    private double salary;

    public Teacher(String id, String name, char sex, int age, String times, double salary) {
        super(id, name, sex, age, times);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "salary=" + salary +
                '}';
    }
}
