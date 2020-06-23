/**
 * Ҫ��
 *    ���������������ַ������������ǵĺͣ��ö����Ʊ�ʾ����
 *    ����Ϊ �ǿ� �ַ�����ֻ�������� 1 �� 0��
 *
 *  ˼·һ���������ַ�������>ת����ʮ����������͡���>��ת���ɶ�������ʽ
 *
 *   ���⣺�����˳���Χ���,�� Java �У�
     * ����ַ������� 3333 λ������ת��Ϊ Integer
     * ����ַ������� 6565 λ������ת��Ϊ Long
     * ����ַ������� 500000001500000001 λ������ת��Ϊ BigInteger
     * ��ˣ�Ϊ�������ڳ��Ƚϴ���ַ������㣬����Ӧ��ʹ�ø��ӽ�׳���㷨��
 *
 *
 *  ˼·������λ��ӣ������һ���̵���ǰ�油�㡣ÿһλ��ӻ�Ҫ���Ϻ�һλ�Ľ�λ��
 *
 *  �ܽ᣺
 *  1.�ж�˭��˭С�ľ�����
 *   int n = Math.max(a.length(), b.length())
 *  2.���жϷ�Χ�ĸ��������ֵд��һ�仰�ľ������
 *   carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
 *  3.���ڿ��ǽ�λʱ�������ڽ�λ�Ĵ��ݣ��������ÿһλ����������˼����
 *  �Լ���λȡ���ȡ��Ӧ��ѭ�������ʵ�֣�����������м���������Թ�ͬʹ�á�
 *
 * @Auther:sommer1111
 * @date 2020/6/23 14:07
 */
public class _06_BinarySum {
    public static void main(String[] args) {
        System.out.println(addBinary("1101","1"));
        System.out.println(addBinary3("1101","1"));
    }

    public static String addBinary(String a, String b) {
        int a1 = Integer.valueOf(a,2);
        int a2 = Integer.valueOf(b,2);
        String sum = Integer.toBinaryString(a1 + a2);
        return sum;
        //�Ż���
        // return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));

    }

    public String addBinary2(String a, String b) {
        StringBuffer ans = new StringBuffer();

        int n = Math.max(a.length(), b.length()), carry = 0;//��ʼ��λ����Ϊ0
        for (int i = 0; i < n; ++i) {
            //��Ӧλ����ӣ�ÿһλ�Ĵ�Ϊ ��carry+a+b)%2�������ʱ�����Ѿ����ڳ��ˣ����㡣
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            //��λ����=��carry+a+b)/2
            carry /= 2;
        }
        //������һһ�εĽ�λΪ1����ô��Ҫ����Ҫ��һλ
        if (carry > 0) {
            ans.append('1');
        }
        return ans.reverse().toString();
    }

    public static String addBinary3(String a,String b){
        StringBuffer res = new StringBuffer();
        int n = Math.max(a.length(),b.length());
        int carry = 0;

        for (int i = 0; i < n; i++) {
           carry += i< a.length() ? (a.charAt(a.length()-1-i)-'0'):0;
           carry += i< b.length() ? (b.charAt(b.length()-1-i)-'0'):0;

           res.append( (carry %2));//�Ƿ�ת����charû��ʲôӰ��
           carry = carry/2;
        }
        if(carry>0){
            res.append(1);
        }

        return res.reverse().toString();
    }

}
