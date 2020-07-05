/**
 * Ҫ��
 * ����һ���Ǹ����� c ����Ҫ�ж��Ƿ������������ a �� b��ʹ�� a2 + b2 = c��
 *
 * �ҵ�˼·��ȱ���ַ���˼ά
 *   |---����ö�� a������֤ c - a^2 >= 0
 *   |---�������ͨ�����ֲ��ҵķ����ҳ��Ƿ���� b������ b^2 = c - a^2��
 *   |---���ֲ��ҵķ�ΧΪ [0, c - a^2]
 *
 * ѧϰ���ַ���
 *   |--- �ҵ���˵㡢�Ҷ˵㣬���е㣺mid = left+(right-left)/2
 *   |--- �ж��е���˻���С�ˡ�
 *      |---������ˣ�����С��ΧΪ[left,mid-1]
 *      |---���С�ˣ�������ΧΪ[mid+1,right]
 *
 *
 * @Auther:sommer1111
 * @date 2020/7/1 21:22
 */
public class _07_01_judgeSquareSum {
    public static void main(String[] args) {
        System.out.println(judgeSquareSum(5));
        System.out.println(judgeSquareSum2(25));

    }
    public static  boolean judgeSquareSum(int c) {
        for (int a = 0; a <=Math.sqrt(c); a++) {
            double b = Math.sqrt(c-a*a);
            if(b == (int) b){
                return true;
            }
        }
        return false;
    }

    public static boolean judgeSquareSum2(int c){
        for (int a = 0; a *a<c ; a++) {
            int b = c- a*a;
            if(find_binary(0,b,b)){
                return true;
            }
        }
        return false;
    }

    public static boolean find_binary(int left,int right,int findnum){

        if(left>right){
            return false;
        }
        int mid = left +(right-left)/2;
        if(mid *mid==findnum){
            return true;
        }else if(mid*mid>findnum){
            return find_binary(left,mid-1,findnum);
        }else{
            return find_binary(mid+1,right,findnum);
        }

    }
}
