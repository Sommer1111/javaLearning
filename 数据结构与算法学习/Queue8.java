package DataStructureTest;

/**
 * 问题描述：在8×8格的国际象棋上摆放八个皇后，
 *         任意两个皇后都不能处于同一行、同一列或同一斜线上，有多少种摆法。
 *
 * 思路分析：
 *     用一维的数组来代替二维的棋盘，下标表示横坐标，具体的值value表示纵坐标
 *
 * 问题分析：1.是否在同一行，表示为不同索引的值相同就是相同的列
 *          2.是否在同一列，直接通过递增就可以保证不在同一列
 *          3.是否在同一条对角线，值和索引的比值是否相同，即具有相同的斜率。
 * 具体实现：
 *          1.判断是否冲突(Judge)
 *          2.判断放置位置（循环递归）
 *          3.输出结果
 * @Auther:sommer1111
 * @date 2020/6/24 9:06
 */
public class Queue8 {
    static int max = 8;//代表8皇后
    static int[] myput = new int[max];
    static int count=0;//计数

    public static void main(String[] args) {//测试代码不会写。。。。笑哭
        Queue8 queue = new Queue8();
        queue.check(0);
        System.out.printf("一共有%d种皇后的放置方法",count);
    }

    //检查是否冲突，当我们放置第n个皇后时，是否跟之前放置的皇后不冲突
    public static boolean Judge(int n){
        for (int i = 0; i < n; i++) {
            if(myput[i] == myput[n] || Math.abs(n-i) == Math.abs(myput[i] - myput[n])){
                return false;
            }
        }
        return true;
    }

    //递归放置位置(这里在写的时候不太流畅，逻辑不顺畅)
    public static void check(int n){//放第n个皇后
        //当然你先放的时候就需要判断是不是已经放完皇后了
        if(n ==max){
            print();
            count++;
            return;//表示结束
        }

        for (int i = 0; i <max; i++) {//从第一列开始找位置，判断冲突，所以有一个for循环
            myput[n]=i;//先放在第一个位置，在继续判断是否跟其它皇后冲突
            if(Judge(n)){//如果不冲突，判断下一个皇后
                check(n+1);//如果下一个皇后找不到位置，又触发了回溯机制，回到上一个皇后
                //机选判断后面的位置。依次一次，直到放完皇后就可以return了。
            }
            //如果冲突了，通过循环i自增的方式继续判断后面的位置
        }
    }


    //打印结果
    public static void print(){
        for (int i = 0; i <myput.length; i++) {
            System.out.print(myput[i]+" ");
        }
        System.out.println();
    }

}

