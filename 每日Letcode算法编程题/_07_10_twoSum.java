import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 题目描述：
 * 给定一个整数数组 nums和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，
 * 并返回他们的数组下标。你可以假设每种输入只会对应一个答案。同一个元素不能使用两遍。
 *
 * 思路分析：
 * 1.双重遍历，外层遍历取第一个数，内层遍历判断是否有 nums[j]=target-nums[i]
 * 2.分析：
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 *
 * 另一想法：用空间换时间————用哈希表！
 * 1.复制数组内容到 ArrayList 中。list.contains。我这个初步有了思路，但是应该换成哈希表
 *
 *
 * @Auther:sommer1111
 * @date 2020/7/10 17:36
 */
public class _07_10_twoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] findindex = twoSum3(nums, target);
        System.out.println(Arrays.toString(findindex));

    }

    //1.暴力力求解法
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {//优化不用从0开始判断
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");

    }

    //哈希表：空间换时间
    public static int[] twoSum2(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);//这样放可以根据get直接获得i判断是否相同
        }
        for (int i = 0; i < nums.length; i++) {
            int other = target-nums[i];
            if(map.containsKey(other) && map.get(other)!=i){
                return new int[]{i,map.get(other)};
            }
        }
        throw new IllegalArgumentException();//非法参数异常



    }

    // 方法三进一步优化
    // a+b=t, a与b相当于对称的存在，所以不必先后遍历判断，可以同时进行
    public static int[] twoSum3(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int other = target-nums[i];
            if(map.containsKey(other) && map.get(other)!=i){
                return new int[]{map.get(other),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException();
    }
}
