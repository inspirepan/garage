package playground;

/*


1. 父类初始化，静态代码块
2. 属性赋值，类静态对象初始化

3. 父类构造函数
4. 子类实例初始化，类普通对象初始化
5. 子类实例构造函数

 */

public class Parent {
    static {
        System.out.println("---static Parent---");
    }

    public Parent() {
        System.out.println("----Parent----");
    }
}

class Child extends Parent {
    static Other other = new Other();
    Brother b = new Brother();

    public Child() {
        System.out.println("----Child-----");
    }

    public static void main(String[] args) {
        Child child = new Child();
    }
}

class Brother {
    static {
        System.out.println("---static Brother---");
    }

    public Brother() {
        System.out.println("----Brother----");
    }
}

class Other {
    static {
        System.out.println("---static Other---");
    }

    public Other() {
        System.out.println("---Other---");
    }
}
