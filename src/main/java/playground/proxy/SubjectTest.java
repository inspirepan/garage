package playground.proxy;

import java.lang.reflect.Proxy;

public class SubjectTest {
    public static void main(String[] args) {
        Subject s = (Subject) Proxy.newProxyInstance(
                Subject.class.getClassLoader(),
                new Class[]{Subject.class},
                new SubjectInvocationHandler()
        );
        // 通过代理，返回值变成了handler提供的返回值
        System.out.println(s.subject());
    }
}
