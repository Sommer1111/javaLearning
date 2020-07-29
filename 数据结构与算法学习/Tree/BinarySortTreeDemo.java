package DataStructureTest.Tree;

/**
 * 内容： 生成二叉排序树，小的放左边，大的放右边
 *
 * @Auther:sommer1111
 * @date 2020/7/29 10:29
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {3,1,5,8,2,9,0,2};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new SortNode(arr[i]));
        }
        binarySortTree.infixOrder();
        //输出从小到大的次序
    }


}

//创建二叉排序树类
class BinarySortTree{
    SortNode root;//默认设置根节点将树组织起来

    //增添的方法
    public void add(SortNode node){
        if(root==null){//如果为空则直接将节点加到根节点
            root = node;
        }else{//否则遍历添加
            root.add(node);
        }
    }

    //中序遍历的方法
    public void infixOrder(){
        if(root !=null){
            root.infixOrder();
        }else{
            System.out.println("树为空无法遍历！");
        }
    }
}


//创建节点类
class SortNode{
    int value;
    SortNode left;
    SortNode right;

    public SortNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SortNode{" +
                "value=" + value +
                '}';
    }

    //添加子树的方法
    public  void add(SortNode node){
        if(this ==null){//如果当前节点为空，不做处理直接结束。防止空指针异常
           return;
        }
        //比较新加的值小
        if(this.value > node.value){
            if(this.left == null){
                this.left = node;
            }else{//如果左节点不为空，递归遍历
                this.left.add(node);
            }
        }else{//这里就包括了等于的情况
            if(this.right ==null){
                this.right = node;
            }else{//如果右节点不为空，递归遍历
                this.right.add(node);
            }
        }
    }

    //利用中序遍历使输出的顺序为从小到大
    public void infixOrder(){
        if(this.left!=null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right!= null){
            this.right.infixOrder();
        }
    }
}
