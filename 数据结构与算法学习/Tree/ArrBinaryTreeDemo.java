package DataStructureTest.Tree;

/**
 * 实现数组与二叉树的转换，可以将数组以二叉树的前序、中序、后序遍历的方式输出
 *  数组————>二叉树特点：
 *   |---二叉树为完全二叉树（即每一个节点都具备左子节点、右子节点）
 *   |---根节点从 0 开始计数，父节点为 n ，左子节点 = 2*n + 1，右子节点为 = 2*n + 2
 *
 * 原数组：  1  2  3  4  5  6  7
 * 前序遍历：1  2  4  5  3  6  7
 * 中序遍历：4  2  5  1  6  3  7
 * 后序遍历：4  5  2  6  7  3  1
 *
 * 总结；
 * 1. 使用数组，最需要小心的是进行数组越界，常需加入判断条件：
 *    |--- arr==null ||arr.length = 0
 *    |--- index < arr.length
 * 2. 重载的意义，想当于加上一个默认实现。
 *
 * @Auther:sommer1111
 * @date 2020/7/25 9:59
 */
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder();

    }


}

class ArrBinaryTree{
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void  preOrder(){
        this.preOrder(0);
    }

    public void preOrder(int index){
        //实际前序遍历即按节点索引的特点进行一一对应的输出
        //找到二叉树遍历下的节点的对应数组的索引特点。
        if(arr ==null || arr.length==0){
            System.out.println("数组为空，无法遍历");
        }else{
            //输出父节点
            System.out.print(arr[index]+ "  ");
            //遍历左子树
            if ((index * 2 + 1) < arr.length) {//防止数组越界
                preOrder(index * 2 + 1);//直接使用递归实现循环
            }
            //遍历右子树
            if (index * 2 + 2 < arr.length) {
                preOrder(index * 2 + 2);
            }
        }
    }
}
