package playground.proxy;

import java.lang.reflect.Proxy;

public class MessageImpl implements Message {
    public String send(String msg) {
        System.out.println("Message " + msg);
        return msg;
    }

    public String send2(String msg) {
        System.out.println("Message2 " + msg);
        return msg;
    }

    public static void main(String[] args) {
        // 用这个代理方法包装一下
        Message x = (Message) ProxyFacotry.getProxy(new MessageImpl());
        x.send2("hello");

        //手动给类加载器和接口的class文件也是可以的
        Message k = (Message) Proxy.newProxyInstance(
                Message.class.getClassLoader(),
                new Class[]{Message.class},
                new TestInvocationHandler(new MessageImpl())
        );
        k.send("ok");
    }
}
