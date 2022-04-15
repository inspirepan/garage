package playground.proxy;

import java.lang.reflect.Proxy;

public class ProxyFacotry {
    // 获取代理类的工厂方法
    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                // 指定代理对象需要实现哪些接口
                // 可以是多个接口 Class[]
                target.getClass().getInterfaces(),
                new TestInvocationHandler(target)
        );
    }
}
