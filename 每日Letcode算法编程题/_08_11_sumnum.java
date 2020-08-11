import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * 1.计算该数组前面各位数组的和
 * 2.求两个数组的交集
 *
 * @Auther:sommer1111
 * @date 2020/8/11 17:40
 */
public class _08_11_sumnum {
    public static void main(String[] args) {
        int[] nums = {4,9,5};
        System.out.println(Arrays.toString(runningSum(nums)));
        int[] nums1 = {9,4,9,8,4};
        System.out.println(Arrays.toString(intersection(nums,nums1)));


    }

    public  static int[] runningSum(int[] nums) {
        int[] sunnum = new int[nums.length];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count+= nums[i];
            sunnum[i] =count;
        }

        return sunnum;
    }

    public  static int[] intersection(int[] nums1, int[] nums2) {
        //1.判断哪个数组更短，遍历完短的就ok
        //2.如何处理本身的重复，也有一种是直接两个数组都进行set处理，好像会更简单一些
        
        ArrayList<Integer> list = new ArrayList<>();
        if(nums1.length >= nums2.length){//保证 nums2 更短
            HashSet<Integer> num = new HashSet<>();
            for (int i = 0; i < nums2.length; i++) {
                num.add(nums2[i]);//不重复形式加入
            }
            for (int i = 0; i < nums1.length; i++) {
                if(num.contains(nums1[i])){
                    list.add(nums1[i]);
                    num.remove(nums1[i]);
                }
            }
        }else{
            return intersection(nums2,nums1);//这里如果不加上return 的话又会继续执行下面的步骤。
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
