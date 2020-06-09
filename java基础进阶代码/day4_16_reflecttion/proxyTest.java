package cn.code.day4_16_reflecttion;

/**
 * @Auther:sommer1111
 * @date 2020/4/21 19:28
 */
public class proxyTest {
    //静态代理的共同父类接口
    //1.创建代理对象实现父类接口
    //2.创建被代理对象实现父类接口
    //3.实现代理

    //测试
    public static void main(String[] args) {
        //1.创建被代理类实例化对象
        Bookbuyer bookbuyer = new Bookbuyer();

        //2.创建代理类实例化对象
        Bookshop bookshop = new Bookshop(bookbuyer);

        //相当于递归调用
        bookshop.read();
    }
}

interface Book{
    public void read();

}

//代理类
class Bookshop implements Book{
    private Book books;

    //构造器
    // 即此时传入被代理对象，来创建代理类的实例化对象，实现经纪人处理明星的所有事项。
    public Bookshop(Book books) {
        this.books = books;
    }

    @Override
    public void read() {
        System.out.println("这是代理书店，你需要什么书籍我都有！");
        books.read();
        System.out.println("书已经卖出去了");
    }
}

//被代理类，作为代理类的参数传入
class Bookbuyer implements Book{
    @Override
    public void read() {
        System.out.println("我是顾客我来买我想要的书啦！");
    }
}






