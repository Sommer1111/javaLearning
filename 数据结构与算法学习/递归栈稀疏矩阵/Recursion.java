package DataStructureTest;

/**
 * 递归解决迷宫出路问题
 * 1.先用数组模拟迷宫
 * 2.行走策略：右——下——左——上
 * 3.走通条件：递归能够到达最后一个点
 *           1代表是墙，2代表是走通的路，3代表死路，0代表没走过的路
 *
 * @Auther:sommer1111
 * @date 2020/6/23 11:13
 */
public class Recursion {
    public static void main(String[] args) {
        //模拟迷宫
        int[][] map = new int[7][8];
        for (int i = 0; i <8; i++) {
            map[0][i] = 1;
            map[6][i] = 1;
        }

        for (int i = 0; i <7; i++) {
            map[i][0] = 1;
            map[i][7] = 1;
        }

        map[2][1] = 1;
        map[2][2] = 1;
        map[4][5] = 1;
        map[3][3] = 1;

        System.out.println("这是迷宫矩阵：");
        for (int i = 0; i <7; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

        findWay(map,1,1);

        System.out.println();
        System.out.println("这是出走迷宫矩阵：");
        for (int i = 0; i <7; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static boolean findWay(int[][] map,int i,int j){
        //策略1：右——下——左——上
        if(map[5][6]==2){
            return true;
        }else{
            //map[1][1]————>map[2][1]————>map[3][1]————>map[4][1],如果到4，1这个位置是
            //死路了，就返回到map[3][1]这个地方继续判断其它方向，map[3][2]————>map[4][2]
            //这样递归下来，遇到不通就返回，也就是回溯的由来。最后执行成功就像触发了多米诺骨牌
            //一样，往回传递，传递到最后整条路的探索。
            if(map[i][j]==0){
                map[i][j]=2;
                if(findWay(map,i+1,j)){//向下寻找出路
                    return true;
                }else if(findWay(map,i,j+1)){//向右寻找出路
                    return true;
                }else if(findWay(map,i,j-1)){//向左寻找出路
                    return true;
                }else if(findWay(map,i-1,j)){//向上寻找出路
                    return true;
                }else{
                    map[i][j]=3;//死路不通
                }
            }else{
                return false;//如果不是0，要么已经是死路3、是墙1、走过了2
            }
        }
        return false;

    }

    //扩展，寻找最短路径。
    //思路：分别用不同的策略走路，计算步数，比较得出最小值。
    public static boolean findWay2(int[][] map,int i,int j){
        if(map[5][6]==2){
            return true;
        }else{
            //策略2：右——下——左——上
            if(map[i][j]==0){
                map[i][j]=2;
                if(findWay2(map,i+1,j)){//向下寻找出路
                    return true;
                }else if(findWay2(map,i,j+1)){//向右寻找出路
                    return true;
                }else if(findWay2(map,i,j-1)){//向左寻找出路
                    return true;
                }else if(findWay2(map,i-1,j)){//向上寻找出路
                    return true;
                }else{
                    map[i][j]=3;//死路不通
                }
            }else{
                return false;//如果不是0，要么已经是死路3、是墙1、走过了2
            }
        }
        return false;

    }
}

