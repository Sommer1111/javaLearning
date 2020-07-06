package DataStructureTest.递归栈稀疏矩阵;

/**
 * @Auther:sommer1111
 * @date 2020/5/21 11:19
 */
public class SparseArray {
    public static void main(String[] args) {
        //1.创建一个很多相同数据的数组
        //2.将数组转换为稀疏数组
        //3.将稀疏数组重新转换成普通数组显示

        //生成初始的全零数组
        int[][] normalArr = new int[11][11];

        //替换0值
        normalArr[2][3] = 3;
        normalArr[1][2] = 5;
        normalArr[4][6] = 7;

        //对于二阶矩阵的输出很不熟练，各种问题
        for (int[] row :normalArr) {
            for(int a:row){
                //printf:格式化输出
                //println:换行输出
                //print:标准输出
                System.out.printf("%d\t",a);
            }
            System.out.println();
        }

        //将普通数组转换成稀疏数组
        //第一行：存储行类以及非0值的数目。
        //其余行记录非0数据的位置。

        //果然看起来很简单，这个地方就卡住了，不能直接知道要创建几乘几的数组——sum
        //行数=非0数的个数加一
        int sum = 0;
        for(int[] s :normalArr){
            for(int s1:s){
                if(s1!=0){
                    sum++;
                }
            }
        }
        System.out.println();
        System.out.println("以下是转换成稀疏数组的结果：");


        int count = 0;
        int[][] sparseArr = new int[sum+1][3];
        //二位数组，A.length代表行数，A[0].length代表列数
        sparseArr[0][0] = normalArr.length;
        sparseArr[0][1] = normalArr[0].length;
        sparseArr[0][2] = sum;
        //这里要遍历出非0的数，赋给稀疏矩阵
        for (int i = 0; i <normalArr.length; i++) {
            for (int j = 0; j < normalArr[i].length; j++) {
                if(normalArr[i][j] != 0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = normalArr[i][j];
                }
            }
        }

        //输出显示稀疏矩阵
        for(int[] i:sparseArr){
            for(int i1:i){
                System.out.printf("%d\t",i1);
            }
            System.out.println();
        }

        //下面实现稀疏数组对普通数组的转化

        System.out.println();
        System.out.println("下面是稀疏数组转换成普通矩阵：");
        int[][] newArr = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
                newArr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        for(int[] row: newArr){
            for(int a:row){
                System.out.printf("%d\t",a);
            }
            System.out.println();
        }


    }
}
