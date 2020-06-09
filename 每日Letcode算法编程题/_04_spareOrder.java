package Algorithm_ex;

/**
 * ����������
 * ��˳ʱ��������������Ԫ��
 *
 * @Auther:sommer1111
 * @date 2020/6/5 19:40
 */
public class _04_spareOrder {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[] a = spiralOrder(matrix);

        for (int i = 0; i <a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }


    public static int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int t = 0;//��ʼ��������������Ϊ0
        int l = 0;//��ʼ�������������Ϊ0
        int r = matrix.length - 1;     //��ʼ�������ұ�����
        int b = matrix[0].length - 1; //��ʼ��������������
        int[] out = new int[matrix.length * matrix[0].length];
        int index = 0;

        while (true) {//���� break ���Ժ������еľ������

            //��ʼ�������������ұ���
            for (int i = l; i <= r; i++) {
                out[index++] = matrix[t][i];//����������������t����������������i
            }//ע���������мӣ���ʼ������
            if (++t > b) {//��Ϊ������Ϊ��λ�����������ƣ�ֹͣ�����ټӾ�Ҫ����b
                break;
            }


            //�����ұ������ϵ��±�����
            for (int i = t; i <= b; i++) {
                out[index++] = matrix[i][r];//���ϵ�С������i�����ұ�����������r
            }
            if (--r < l) {//��Ϊ������Ϊ��λ�������������ƣ�ֹͣ���������ټ���Ҫ��lС
                break;
            }

            //�����������д��ҵ������
            for (int i = r; i >= l; i--) {
                out[index++] = matrix[b][i];//���������У�������b��
            }
            if (--b < t) {//��Ϊ������Ϊ��λ��������Ҫ���ƣ�������--��ֹͣ�����ټ��ͱ�t��С
                break;
            }


            //����������д��µ��ϱ���
            for (int i = b; i >= t; i--) {
                out[index++] = matrix[i][l];
            }
            if (++l > r) {//��Ϊ��λ�����������ƣ�ֹͣ�������ټӴ���r
                break;
            }

        }
        return out;
    }

}

