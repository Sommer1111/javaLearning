/**
 * 题目描述：找到数组中大于某数的 最短连续子数组
 *
 * 方法：
 *    双指针。找到一个子数组之后再往后移，最先的数据要在求和中减去，更新记录的数组长短。
 *
 * 我考虑的欠缺：
 *   1。先是找到最大的值，然后比较左右相加，这样会很难分清讨论的情况。
 *      而且这样左右两边都要考虑这个。还不如固定双指针，像滑动窗口一样去考虑。
 *
 * @Auther:sommer1111
 * @date 2020/8/14 19:33
 */
public class _08_14_minSubArrayLen {
    public static void main(String[] args) {
        int[] nums = {5,1,3,5,10,7,4,9,2,8};
        System.out.println(minSubArrayLen(15,nums));

    }

    public static int minSubArrayLen(int s, int[] nums) {
        int max = nums.length;
        int start = 0;
        int end = 0;
        int ans = 0;
        int sum = 0;

        while(end<max){
            //这里遇到的问题是，end已经到末尾了，但是start还可以继续缩小，原来是用whilie判断的就无法处理这种情况。
            //改用while就可以一直增加 start了。
            sum += nums[end];
            while(sum>=s){
                sum-=nums[start];
                ans = (end-start+1) > ans && ans>0?ans:end-start+1;
                start++;

            }
            end++;
        }
        return ans;
    }
}
