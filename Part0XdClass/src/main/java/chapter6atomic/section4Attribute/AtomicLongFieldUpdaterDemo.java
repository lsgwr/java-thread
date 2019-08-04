package chapter6atomic.section4Attribute;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * 更新属性
 */
public class AtomicLongFieldUpdaterDemo {

    public static void main(String[] args) {
        // 指定要更新的额字段: id
        AtomicLongFieldUpdater<Student> longFieldUpdater = AtomicLongFieldUpdater.newUpdater(Student.class, "id");

        Student xdclass = new Student(1L, "xdclass");
        // 更新属性
        longFieldUpdater.compareAndSet(xdclass, 1L, 100L);
        // 打印修改后的Id
        System.out.println("id=" + xdclass.getId());

        // 利用引用类型修改name属性
        AtomicReferenceFieldUpdater<Student, String> referenceFieldUpdater = AtomicReferenceFieldUpdater.newUpdater(Student.class, String.class, "name");
        referenceFieldUpdater.compareAndSet(xdclass, "xdclass", "wiggin");
        System.out.println("name=" + xdclass.getName());
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Student {
    /**
     * 必须是volcatile的基础数据类型，不能是包装类哦！
     */
    volatile long id;
    volatile String name;
}