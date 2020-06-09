package cn.code.day4_16_reflecttion;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Auther:sommer1111
 * @date 2020/4/21 20:19
 */
public class ChangingProxyTest {

    public static void main(String[] args) {
        //1.创建被代理类
        Teacher teacher = new Teacher();
        //2.通过代理类的生产共厂定制该被代理类的代理类
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(teacher);
        String teach = proxyInstance.teach();
        System.out.println(teach);
        proxyInstance.work();


        /**
         * 用代理书店来测试，非常好用
         */
        //1，创建被代理类
        Bookbuyer b = new Bookbuyer();
        //2.代理工厂生产定制代理类
        Book bookshop1 = (Book) ProxyFactory.getProxyInstance(b);
        //3.借你的身子做我想做的事情
        bookshop1.read();


    }
}

//1.创建父类接口
interface Human{
    public String teach();
    public void work();
}

//2.被代理类实现父类
class Teacher implements Human{


    @Override
    public String teach() {
        return "I teacher student";
    }

    @Override
    public void work() {
        System.out.println("hardworking!");
    }
}

//3.代理类的生产工厂
class ProxyFactory{
    public static Object getProxyInstance(Object obj){//obj即为被代理类

        MyInvocation handle = new MyInvocation();
        handle.trans(obj);
        //根据被代理类，获取它的类加载器、实现接口、内部方法(利用handle链接到invoke())，定制一个代理类，解决问题一
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handle);
    }
}

class MyInvocation implements InvocationHandler{

    //我们需要实现被代理类的同名方法
    //1.此时代理类还没有被创建出来，我们需要创建一个被代理类的实例化对象，方便在invoke()里面可以使用
    //因为这是一个加工厂，我们并不知道哪个被代理类要送进来，所以这里折衷用Object

    private Object obj;

    // 再通过调用的方法，把生产工厂传入的被代理类obj传送到这里
    public void trans(Object obj){
        this.obj = obj;
    }



    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        //被代理类 o 要执行的方法 method 变成了代理类要执行的方法
        //并将被代理类需要的返回值返回回去,实现同名方法的调用
        Object returnValue = method.invoke(obj, objects);
        //这里就是反射了，相当于obj.a被代理类实现方法。objects表示被方法的参数
        return returnValue;
    }


}

