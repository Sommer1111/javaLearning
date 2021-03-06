package Algorithm_ex;

/**
 * @Auther:sommer1111
 * @date 2020/6/3 9:14
 */
public class MyBook {
    /**
     * 【我的算法学习笔记】：
     *
     * 心得体会：
     * 1.发现算法的关键节点，没有那么容易理解，最快的方法是自己推算一下。就清晰了。
     *    更清晰的是用 Debug调试
     *
     * 2.很多思路没有不一定是自己笨，这些技巧是可以学会的。需要一个积累的过程。
     *
     * 3.递归为什么是这个步骤有时有点难理解。 这个时候可以直接看拆分到最小的时候，它的步骤要怎样。
     *
     * 4.理解时，太拘泥于参考代码，有时不理解，一直纠结它为什么要这样写。又是一个标准答案的思维。
     *   其实写法又很多，人家只是碰巧这样写了，我并没有必要一定跟他一样，只要最终都可实现，殊途同归。
     *   往往一定要跟他写的一模一样，毕竟不是我的思维，有时就是理解不了他为什么要这样写。
     *
     * 5.编程抽象从易到难：如：从个位数分析十位数、百位数，再从中看出规律，推及到所有情况。
     *
     *
     * 笔记学习：
     * 1.边界问题分类讨论思想：
     *   对于边界上的问题讨论，非常复杂麻烦：可以在左右两边再加上数据，避免分类讨论。如种花问题。
     *
     * 2.取模的考虑：其中两个更大的靠近极限，单个取不到模，相加又会溢出
     *    f(n) =（（f(n-1) + f(n-2)）%1000000 + f(n-3)）%1000000
     *    取余操作比较耗时（底层中取模是如何实现的？），可以增加一个判断然后减去大值。
     *
     * 3.迭代：容易理解，但是中间资源一直握着不释放导致耗时低效。同时会重复计算。时间复杂度O(2^n)，空间复杂度O(N)
     *  解决办法：
     *    * 记忆化递归：采用数组，将中间结果用数组存起来，但是需要注意数组越界。而避免重复计算，但是也会占用O(N)的空间内存
     *    * 动态规划：采用中间变量将中间的值取出来，释放资源。这里只用到了三个变量,a,b,temp，空间复杂度降到了O(1)
     *
     * 4.贪心算法：不拘泥于细节去考虑问题，如由具体的数，改成个数是否对应。
     *
     * 5.改变思考的角度，A——B，B——A
     *
     * 6.学习二分法：
     *   |--- 找到左端点、右端点，找中点：mid = left+(right-left)/2
     *   |--- 判断中点大了还是小了。
     *      |---如果大了，则缩小范围为[left,mid-1]
     *      |---如果小了，则扩大范围为[mid+1,right]
     *
     *  7.循环的位数：
     *  |--得到数字位数的方法：(max+"").length
     *  |--在一轮循环中需要计数，从新开始之后要重新计数，但是碰到新的情况又要接下去计数的方法时
     *     |--另外创建一个专门存储计数的数组，就不会存在归零的苦恼。
     *  注意：我们在一开始创建数组时，就已填充了默认的数字0，此时用arr.length并得不到实际的位数！
     *
     *
     */
}
