package chapter6atomic.section5Reference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 更新引用
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

@Data
@AllArgsConstructor
@NoArgsConstructor
class Student{
    private long id;
    private String name;
}
