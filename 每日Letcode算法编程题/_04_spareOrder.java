

/**
 * 问题描述：
 * 按顺时针输出矩阵的所有元素
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
        int t = 0;//初始矩阵最上面那行为0
        int l = 0;//初始矩阵最左边那列为0
        int r = matrix.length - 1;     //初始矩阵最右边那行
        int b = matrix[0].length - 1; //初始矩阵最下面那行
        int[] out = new int[matrix.length * matrix[0].length];
        int index = 0;

        while (true) {//四种 break 可以涵盖所有的矩阵情况

            //开始最上面那行左到右遍历
            for (int i = l; i <= r; i++) {
                out[index++] = matrix[t][i];//最上面那行所以是t，从左往右所以是i
            }//注意这里是行加，初始理解错误
            if (++t > b) {//因为是以行为单位，遍历完下移，停止条件再加就要大于b
                break;
            }


            //从最右边那列上到下遍历，
            for (int i = t; i <= b; i++) {
                out[index++] = matrix[i][r];//从上到小所以是i，最右边那行所以是r
            }
            if (--r < l) {//因为是以列为单位，遍历完往左移，停止的条件是再减就要比l小
                break;
            }

            //从最下面那行从右到左遍历
            for (int i = r; i >= l; i--) {
                out[index++] = matrix[b][i];//最下面那行，所以是b，
            }
            if (--b < t) {//因为是以行为单位，遍历完要上移，所以行--，停止条件再减就比t还小
                break;
            }


            //从最左边那列从下到上遍历
            for (int i = b; i >= t; i--) {
                out[index++] = matrix[i][l];
            }
            if (++l > r) {//列为单位，遍历完右移，停止条件是再加大于r
                break;
            }

        }
        return out;
    }

}

