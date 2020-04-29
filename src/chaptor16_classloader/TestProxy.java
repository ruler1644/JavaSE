package chaptor16_classloader;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestProxy {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        MyInterFace proxy = (MyInterFace) ProxyFactory.getInstance(superMan);
        System.out.println(proxy.fly("hello"));
    }
}

interface MyInterFace {
    String fly(String name);
}

class SuperMan implements MyInterFace {
    @Override
    public String fly(String name) {
        return name + ",I can fly";
    }
}

class ProxyFactory {
    public static Object getInstance(Object obj) {
        MyInvocationHadler handler = new MyInvocationHadler();
        handler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
    }
}

class MyInvocationHadler implements InvocationHandler {
    Object obj;

    public void bind(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(obj, args);
    }
}