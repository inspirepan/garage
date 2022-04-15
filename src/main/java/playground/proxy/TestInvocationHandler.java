package playground.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TestInvocationHandler implements InvocationHandler {

    // 一定是通过构造函数持有目标对象
    Object target;

    public TestInvocationHandler(Object target) {
        this.target = target;
    }

    // 一个疑问是如果有多个方法，它是怎么确定代理哪一个方法呢
    // 实际上就是会代理接口里面的全部方法

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object res = method.invoke(target, args);
        System.out.println("after");
        return res;
    }
}
