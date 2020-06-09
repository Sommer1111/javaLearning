package Algorithm_ex;
/**
 * 【问题描述】：
     * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。
     * 可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
     * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。
     * 能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
 *
 * @Auther:sommer1111
 * @date 2020/5/30 17:24
 */

//种花问题，我的思路与此类似，但是不知道怎么写

/**
 * 【思路分析】：
 * 解题思路一：
 * 遍历flowerbed[]数组，依次判断各位置是否适合种花，
 * 判断的标准是当前位置为0，且前一位置为0或其下标为-1，且后一位置为0或其下标为flowerbed.length。
 * 若判断为真，则修改flowerbed[]数组当前位置为1，n--。最后若n<=0,则能种下所有花。
 *
 * 解题思路二：
 * 防御式编程思想：
 * 在 flowerbed 数组两端各增加一个 0， 这样处理的好处在于不用考虑边界条件，
 * 任意位置处只要连续出现三个 0 就可以栽上一棵花。
 *
 * 思路三：
 * 双指针i，j找到两个相邻的1，要分几种情况：
 * [0,0,0,...,1],[1,...,0,0,0]这两种情况，还可以种的花的数量是0的个数除以2下取整：count_0/2
 * [1,0,...,0,1]这种情况是0的个数-1除以2下取整，即（count_0 - 1）/2
 */
public class _01_placeFlowers {
    public static void main(String[] args) {
        int[] f = new int[]{1,0,0,0,1,0,0,1,0,0,0,0,1,0,1,0,0,0,0,0,0};

        for (int j = 0; j <f.length; j++) {
            System.out.print(f[j]+ " ");;
        }
        System.out.println();

        System.out.println(PlaceFlower.canPlaceFlowers(f,7));
        //此处已改数组，害得后面遍历数组一直与原数组不一致，一脸懵逼。戒之戒之
        System.out.println(PlaceFlower.canPlace1(f,4));
        System.out.println(PlaceFlower.canPlace2(f,4));
    }


}

class PlaceFlower{
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0
                    && (i - 1 == -1 || flowerbed[i - 1] == 0)
                    && (i + 1 == flowerbed.length || flowerbed[i + 1] == 0)) {
                n--;
                flowerbed[i] = 1;
            }
        }
        return n <= 0;
    }

    //方法一：直接产生一个新的数组，遍历循环赋值，当数组很大的时候低效时间超出限制
    public static boolean canPlace1(int[] flower,int n){
        //step1：先对数组进行前后加0，避免分类判断
        int i = flower.length;
        int[] newflower = new int[i+2];
        newflower[0]=0;
        newflower[i+1] = 0;
        for (int j = 0; j < i; j++) {//这里复制遍历出错，导致输出有误
            newflower[j+1]=flower[j];

        }

        //step2：出现3个连续的0种1盆花，是从0开始遍历
        for (int index = 1; index < newflower.length-2; index++) {
            if(newflower[index]==0 && newflower[index-1]==0 && newflower[index+1]==0){
               n--;
               newflower[index]=1;//必须把判断过的种上花，避免 0000 重复判断两次
            }
        }
        return n<=0;
    }

    //方法二：简直就是优秀！
    public static boolean canPlace2(int[] flower,int n){
        int count = 1;//左边加一个0，这里引用计数，不需要切实给数组加0，省去了很大一部分内存
        int number = 0;

        for(int i =0;i<flower.length;i++){
            if(flower[i]==0){
                count++;//如果当前是0，则计数器加0
            }else{
                count=0;//如果非0，说明没有连续，重新计数
            }
            if(count==3){
                number++;//出现连续3个0，种一盆花
                count=1;//重新从当前位置计数，因为当前位置为0，所以开始是1
            }
        }

        if(count==2){//遍历到最后一个位置，计出count，此时只要count=2就可以种花，相当于右边加0
            number++;
        }
        return number >= n;
    }

}
