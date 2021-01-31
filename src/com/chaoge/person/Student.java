package com.chaoge.person;

public class Student extends Person {
    private double score;

    public Student(String id, String name, char sex, int age, String times, double score) {
        super(id, name, sex, age, times);
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "score=" + score +
                '}';
    }
}
