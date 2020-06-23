/**
 * Ҫ��ͳ������С�ڷǸ����� n ��������������
 * ˼·��
 * 1.ѭ����������
 * 2.���⣺����ж�������������2��3��5��7�ľͲ���
 *
 *
 * ѧϰ��
 * 1.�����Ҫ����ʱ�临�ӶȺͿռ临�Ӷȵģ����ǵ����Ľ�����Ϳ����ˡ�
 * 2.�Ż����������ܵĵط���
 *      �� ����������n�����ñ�����n���������ǶԳƵġ�
 *      �� ɸ��
 * 3.Ϊʲô����Ҫ�����飿��Ϊͨ�������ǣ�if�����ж�һ���ֱ�Ӿͼ������жϵĴ��� ��������˹����ɸ����
 *
 * @Auther:sommer1111
 * @date 2020/6/15 15:11
 */
public class _07_PrimesJudge {

    public static void main(String[] args) {
        System.out.println(judge(100000));
        System.out.println(countPrimes1(100000));
        System.out.println(countPrimes2(100000));
    }

    //��֪��Ϊ�Σ�����������1000000�ܴ�ʱ�ͳ������ˡ�
    //�߼��������⣬�������޷��ж������������ı���
    //ʱ�临�Ӷȣ�O(n)���������
    public static int judge(int n){
        int count =0;
        //��������һ���ж�n�Ƿ���Ϸ�Χ
        for (int i = 1; i <n; i++) {

            if(i <= 10){
                if(i==2||i==3||i==5||i==7){
                    count++;
                }
            }else if(!(i%2==0 || i%3 ==0 || i%5==0 || i%7 ==0)){
                count++;
            }
        }
        return count;
    }

    //�ο�
    public static int countPrimes1(int n) {
        int result = 0;
        boolean[] b = new boolean[n];   // ��ʼ��Ĭ��ֵ��Ϊ false��Ϊ�������
        if(2 < n) result++; // ������� 2 ��һ��ӵ�� 2 �������

        for(int i = 3; i < n; i += 2){  // �� 3 ��ʼ��������ֻ����������2�ı���ɸ��
            if(!b[i]){  // ������
                //������
                //3��ʼ��false��Ȼ�����ѭ������3*3=9��3*5=15��3*7=21.....���������ɹ����һ����
                //5�ı���
                //7�ı���
                for(int j = 3; i * j < n; j += 2){
                    b[i * j] = true;    // ����ǰ�����������������óɷ�������� true
                }
                result++;   // �������� +1
            }
        }
        return result;
    }

    public static int countPrimes2(int n) {
        boolean[] isPrim = new boolean[n];

        for (int i = 2; i * i < n; i++) {//ֻҪ����������n�Ϳ�����
            if (!isPrim[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrim[j] = true;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!isPrim[i]) count++;
        }
        return count;
    }

}
