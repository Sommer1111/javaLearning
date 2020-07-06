import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 题目：给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，
 * 数组中的元素一些出现了两次，另一些只出现一次。找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * 不能使用额外空间
 *
 * 思路分析：
 * 1.遍历。得到不重复的数组
 * 2.将缺的数补到数组末尾，再删除有的数。
 * 3.返回
 *
 * @Auther:sommer1111
 * @date 2020/7/6 15:40
 */
public class _07_06_FindLostOne {
    public static void main(String[] args) {
        int[] nums = {1,1,3,4,5,7,9,3,5};
        List<Integer> disappearedNumbers = findDisappearedNumbers2(nums);
        System.out.println(disappearedNumbers);

    }

    //1.低效，超出时间限制
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(!list.contains(nums[i])){
                list.add(nums[i]);
            }
        }
        int count = 0;
        for (int i = 1; i <= nums.length; i++) {
            if(!list.contains(i)){
                count++;
                list.add(i);
            }
        }

        while(list.size()>count){
            list.remove(0);
        }
        return list;

    }

    //方法二：参考数据结构里面，索引+值以一维数组的方式代替二维数组的这种方式
    public static List<Integer> findDisappearedNumbers2(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();

        //将每一个位置的值当作索引，将数组该索引下的数字改成负的
        //要判断该值是不是负，如果已经是负的就不要再改了
        for (int i = 0; i < nums.length; i++) {
            if(nums[Math.abs(nums[i])-1]>0){
                nums[Math.abs(nums[i])-1] *= -1;
            }
        }
        //非负值的索引就是没有出现过的数字
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0){
                list.add(i+1);
            }
        }
        return list;
    }
}
