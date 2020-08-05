/**
 * 题目描述：
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。数组中无重复元素。
 *
 * 思路：
 * 1.直接遍历
 * 2.!!!!! 二分查找！！！
 *
 * @Auther:sommer1111
 * @date 2020/8/5 15:34
 */
public class _08_05_searchInsert {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,8};
        System.out.println(searchInsert(nums,2));
        System.out.println(searchInsert(nums,0));
        System.out.println(searchInsert(nums,9));

    }

    public static int searchInsert(int[] nums, int target) {
        if(nums[0]>target){
            return 0;
        }

        for (int i = 1; i < nums.length; i++) {
            if(target>nums[i-1] && target<=nums[i]){
                return i;
            }
        }
        return nums.length;
    }

    //二分查找
    public int searchInsert2(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

}
