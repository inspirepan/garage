package playground.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SubjectInvocationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        System.out.println(" 🧱 🧱 🧱 进入代理调用处理器 ");
        return "success";
    }
}
