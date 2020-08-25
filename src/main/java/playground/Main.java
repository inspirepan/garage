package playground;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) {
        Object p = new Person("testMan");
        Class c = p.getClass();
        Field f;

        {
            try {
                f = c.getDeclaredField("name");
                Object s = f.get(p);
                System.out.println(s);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}

class Person {
    public String name;

    public Person(String name) {
        this.name = name;
    }
}

