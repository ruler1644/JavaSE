package chaptor13_reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestReflect {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        System.out.println(proxyInstance.getBelief());
        System.out.println(proxyInstance.eat("西瓜"));
    }
}

interface Human {
    String getBelief();

    String eat(String food);
}

//被代理类
class SuperMan implements Human {
    @Override
    public String getBelief() {
        return "我信仰自己";
    }

    @Override
    public String eat(String food) {
        return "我喜欢吃" + food;
    }
}

class ProxyFactory {

    //返回一个代理类的对象，其中形参obj是被代理类的对象
    public static Object getProxyInstance(Object obj) {
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);

        return Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                handler
        );
    }
}


class MyInvocationHandler implements InvocationHandler {

    //使用被代理对象进行赋值
    private Object obj;

    public void bind(Object obj) {
        this.obj = obj;
    }

    //通过代理类的对象，调用方法a时，会自动调用invoke方法
    //将被代理类要执行的方法a的功能声明在invoke方法中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Exception {

        //method即为代理类对象调用的方法,也是被代理类对象要调用的方法
        Object returnValue = method.invoke(obj, args);
        return returnValue;
    }
}