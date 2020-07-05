import java.util.ArrayList;
import java.util.Arrays;

/**
 * ʵ�֣�����һ���������飬����Ҫ��ԭ��ɾ���ظ����ֵ�Ԫ�أ�
 * ʹ��ÿ��Ԫ��ֻ����һ�Σ������Ƴ���������³��ȡ�
 *
 * �ܽ᣺
 *  1.ע���������������飬���Կ���ʹ��˫ָ�룺����ָ�뷨��ѧ���ˡ�
 *  2.++i �� i++ ��������ã��ܹ��ܴ�̶ȵ���ߴ�������
 *
 *  ˫ָ�������
 *   1.i=0,j=1,�ж�nums[j] == nums[i],������ظ���ֱ��j++
 *   2.�������++i����nums[i]==nums[j],�Ͱ�ֵ�Ĺ����ˡ�
 *   3.��� return i+1
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

    //1.�Լ���˼·1.0���ȽϹ�ֱ�����˸��м�list���洢,���ݴ��Ǳض���
    //ʱ�临�Ӷȣ�O(n)
    //�ռ临�Ӷȣ�O(n)
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


    //���ɰ�2.0
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

    //�Ż���3.0
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
