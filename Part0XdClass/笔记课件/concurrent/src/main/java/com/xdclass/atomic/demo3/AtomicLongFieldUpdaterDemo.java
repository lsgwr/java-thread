package com.xdclass.atomic.demo3;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * AtomicLongFieldUpdaterDemo
 */
public class AtomicLongFieldUpdaterDemo {

    public static void main(String[] args) {
        AtomicLongFieldUpdater<Student> longFieldUpdater = AtomicLongFieldUpdater.newUpdater(Student.class, "id");

        Student xdclass = new Student(1L, "xdclass");
        longFieldUpdater.compareAndSet(xdclass, 1L, 100L);
        System.out.println("id="+xdclass.getId());

        AtomicReferenceFieldUpdater<Student, String> referenceFieldUpdater = AtomicReferenceFieldUpdater.newUpdater(Student.class, String.class, "name");
        referenceFieldUpdater.compareAndSet(xdclass, "xdclass", "wiggin");
        System.out.println("name="+xdclass.getName());
    }
}

class Student{
    volatile long id;
    volatile String name;

    public Student(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}