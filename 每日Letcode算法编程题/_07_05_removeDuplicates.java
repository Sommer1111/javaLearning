import java.util.ArrayList;
import java.util.Arrays;

/**
 * 实现：给定一个排序数组，你需要在原地删除重复出现的元素，
 * 使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 总结：
 *  1.注意这里是有序数组，所以可以使用双指针：快慢指针法。学到了。
 *  2.++i 与 i++ 的灵活运用，能够很大程度的提高代码简洁性
 *
 *  双指针分析：
 *   1.i=0,j=1,判断nums[j] == nums[i],相等则重复，直接j++
 *   2.不相等则，++i，将nums[i]==nums[j],就把值改过来了。
 *   3.最后 return i+1
 * @Auther:sommer1111
 * @date 2020/7/5 18:30
 */
public class _07_05_removeDuplicates {
    public static void main(String[] args) {
        int[] nums ={1,1,1,3,4,5,5,5,};
        int i = removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(i);
    }

    //1.自己的思路1.0，比较耿直的找了个中间list来存储,数据大是必定慢
    //时间复杂度：O(n)
    //空间复杂度：O(n)
    public static int removeDuplicates(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(!list.contains(nums[i])){
                list.add(nums[i]);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return list.size();
    }


    //过渡版2.0
    public int removeDuplicates2(int[] nums) {
        if (null == nums || nums.length < 2) {
            return nums.length;
        }
        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                ++j;
            } else {
                nums[++i] = nums[j++];
            }
        }
        return ++i;
    }

    //优化版3.0
    public int removeDuplicates3(int[] nums) {
        if (null == nums || nums.length == 1) return nums.length;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }
}
