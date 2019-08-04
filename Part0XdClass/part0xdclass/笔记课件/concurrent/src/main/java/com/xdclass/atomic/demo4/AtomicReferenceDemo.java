package com.xdclass.atomic.demo4;

import java.util.concurrent.atomic.AtomicReference;

/**
 * AtomicReferenceDemo
 */
public class AtomicReferenceDemo {

    public static void main(String[] args) {
        AtomicReference<Student> studentAtomicReference = new AtomicReference<>();
        Student student = new Student(1L, "xdclass");
        Student student1 = new Student(2L, "wiggin");
        studentAtomicReference.set(student);
        studentAtomicReference.compareAndSet(student, student1);
        Student student2 = studentAtomicReference.get();
        System.out.println(student2.getName());
    }
}

class Student{
    private long id;
    private String name;

    public Student(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
