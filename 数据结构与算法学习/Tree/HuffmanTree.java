package DataStructureTest.Tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 实现哈夫曼树。权值之和最小。节点值*节点层数（权值） 之和最小。即值越大越靠近根节点
 *  1.所给无序数组，先进行排序。将每一个树当作一个节点
 *  2.从数组中选取最小的两树构建子树，得到新的节点值。并把新值取代两个子节点。
 *  3.重复，构建哈夫曼树
 *
 * @Auther:sommer1111
 * @date 2020/7/27 17:59
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13,7,8,3,29,6,1};
        Node node = huffmanTree(arr);
        preOrder(node);

    }

    public static Node huffmanTree(int[] arr){
        //1.将传入的数组进行处理，转换成list
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(new Node(arr[i]));
        }

        //2.循环建立哈夫曼树
        while(list.size() > 1){
            Collections.sort(list);
            Node leftNode = list.get(0);
            Node rightNode = list.get(1);
            Node fathernode = new Node(leftNode.val+rightNode.val);
            fathernode.left = leftNode;
            fathernode.right = rightNode;

            list.remove(leftNode);
            list.remove(rightNode);
            list.add(fathernode);

        }
        return list.get(0);

        //3.验证哈夫曼树是否正确
    }
    public static void preOrder(Node root){
        if(root != null){
            root.preOrder();
        }else{
            System.out.println("树为空无法遍历！");
        }
    }
}
//构建树节点
//因为要排序，变动数组，所以这里使用集合Collection，要实现Comparable接口
class Node implements Comparable<Node>{
    public  int val;
    public Node left;
    public Node right;

    public Node(int val) {
        this.val = val;
    }


    @Override
    public String toString() {
        return
                "{val=" + val +
                '}';
    }

    @Override
    public int compareTo(Node node) {
        return this.val-node.val;
    }

    //还要进行前序遍历，验证·输出正确
    public void preOrder(){
        System.out.println(this);
        if(this.left!=null){
            this.left.preOrder();
        }
        if(this.right!=null){
            this.right.preOrder();
        }

    }
}
