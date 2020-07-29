import java.util.Arrays;

/**
 * 题目描述：
 * 给定一个排序数组，原地删除重复出现的元素，
 * 使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 思路：双指针
 * 1.快指针遍历数组
 * 2.慢指针指向非重复元素
 *
 * @Auther:sommer1111
 * @date 2020/7/29 20:10
 */
public class _07_29_RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {3,4,4,4,6,7,9};
        System.out.println("不相同的个数是；"+removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));


    }

    public static int removeDuplicates(int[] nums) {
        if(nums ==null || nums.length==0){
            return 0;
        }

        int k=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[k]!=nums[i]){
                nums[++k] = nums[i];
            }
        }
        return k+1;

    }
}
