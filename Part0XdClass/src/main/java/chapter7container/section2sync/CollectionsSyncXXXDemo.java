package chapter7container.section2sync;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsSyncXXXDemo {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        // 此外Collections.synchronizedSet、Collections.synchronizedMap、Collections.synchronizedCollection也是类似的
        List<String> stringList = Collections.synchronizedList(strings);
    }
}
