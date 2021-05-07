package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class University {
    String name;
    int age;
    private List<Student> students;

    public University(String name, int age) {
        this.name = name;
        this.age = age;
        students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        return students.stream().filter(stud -> stud.getAverageGrade() == averageGrade).findAny().orElse(null);
    }

    public Student getStudentWithMaxAverageGrade() {
        return Collections.max(students, Comparator.comparingDouble(Student::getAverageGrade));
    }

    public Student getStudentWithMinAverageGrade() {
        return Collections.min(students, Comparator.comparingDouble(Student::getAverageGrade));
    }

    public void expel(Student student) {
        students.remove(student);
    }
}