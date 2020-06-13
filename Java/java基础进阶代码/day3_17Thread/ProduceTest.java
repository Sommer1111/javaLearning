package day3_17Thread;


//对于生产者 消费者问题的分析
//分析
//1.是否多线程，是分别是生产线，消费线
//2.是否共享数据，是，共享产品
//3.是否存在安全问题，是，要同步代码块
//4.是否存在线程通信，是，产品数量相互影响
public class ProduceTest {
    public static void main(String[] args) {
        clerk c = new clerk();

        Producter p = new  Producter(c);
        p.setName("生产者一号");

        Customer c1 = new Customer(c);
        c1.setName("消费者一号");

        p.start();
        c1.start();

    }
}

//创建共享数据，包括所有对数据的处理
class clerk{
    private  int number = 0;
    //生产产品
    public synchronized void product() {
        if(number<20){
            number++;
            System.out.println(Thread.currentThread().getName()+"生产产品"+number);
            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //消费产品
    public synchronized void custom() {
        if(number>0){
            System.out.println(Thread.currentThread().getName()+"消费产品"+number);
            number--;
            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

//创建生产线程，单纯把厂家的行为作为一个线程
class Producter extends Thread{//生成生产者
    private clerk people = new clerk();

    //利用构造函数把数据传入线程
    public Producter(clerk people) {
        this.people = people;
    }

    @Override
    public void run() {
        System.out.println("生产者开始生产");
        while(true){
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            people.product();
        }
    }
}


//创建消费线程，单纯把消费者的行为作为一个线程
class Customer extends  Thread{
    private clerk people = new clerk();

    public Customer(clerk people) {
        this.people = people;
    }

    @Override
    public void run() {
        System.out.println("消费者开始消费");
        while(true){
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           people.custom();
        }
    }
}

