package DataStructureTest.Tree;


/**
 * 一、建立二叉树，（参考哈希表）分析实现：
 * 1. 建立节点类 TreeNode类，属性：自身、左子树、右子树、各种方法
 * 2. 建立树类 TreeLink，大树撑起一片天，具体实现整棵树的前序遍历、中序遍历、后序遍历
 *  |---根节点这里有些疑惑
 *  |---对 return 什么有疑惑，并且对于 Treenode 里面的方法，
 *      和 TreeLink 里面方法的关系不知如何组织。
 *
 * 二、前序、中序、后序遍历的区别：父节点输出的顺序。
 * 前序遍历：先输出父节点-左子节点-右子节点
 * 中序遍历：先输出左子节点-父节点-右子节点
 * 后序遍历：先输出左子节点-右子节点-父节点
 *
 * 三、具体实现方法
 * 1.首先需要节点类：TreeNode，它本身提供遍历查找删除的功能
 * 2.其次需要将整个节点组织起来的二叉树类，TreeLink类，提供实际可以调用的遍历查找删除的方法。
 * 而实际其内部实现也只是调用节点本身的各种方法。
 *    |--- 二叉树的前序、中序、后序遍历
 *    |--- 二叉树的前序、中序、后序查找
 *    |--- 删除节点
 *
 * @Auther:sommer1111
 * @date 2020/7/15 14:33
 */
public class BinaryTreeOrderDemo {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1,"孔子");
        TreeNode node2 = new TreeNode(2,"老子");
        TreeNode node3 = new TreeNode(3,"孟子");
        TreeNode node4 = new TreeNode(4,"荀子");
        TreeNode node5 = new TreeNode(5,"墨子");

        //设置根节点
        TreeLink tree = new TreeLink();
        tree.setRoot(node1);
        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node3.setRight(node5);

//        System.out.println("前序遍历：");
//        tree.preView();
//        System.out.println();
//        System.out.println("中序遍历：");
//        tree.midView();
//        System.out.println();
//        System.out.println("后序遍历：");
//        tree.postView();
//
//        System.out.println("-----------");
//        System.out.println("前序查找：");
//        tree.preFind(node5);
//        System.out.println();
//        System.out.println("中序查找：");
//        tree.midFind(node5);
//        System.out.println();
//        System.out.println("后序查找：");
//        tree.postFind(node5);

        System.out.println("删除前，前序遍历：");
        tree.preView();
        System.out.println();
        System.out.println("删除后前序遍历：");
        tree.delNode(3);
        tree.preView();


    }


}

class TreeNode{
    private int id;
    private String name;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    //前序遍历，自身——递归左节点——递归右节点
    //遍历不用返回
    public void preOrder(){
        System.out.println(this);
        if(this.getLeft()!= null){//如果存在左节点，则递归遍历
            this.getLeft().preOrder();
        }
        if(this.getRight()!=null){
            this.getRight().preOrder();
        }
    }

    //中序遍历，递归左节点——自身——递归右节点
    public void midOrder(){

        if(this.getLeft()!= null){//如果存在左节点，则递归遍历
           this.getLeft().midOrder();
        }
        System.out.println(this);
        if(this.getRight()!=null){
           this.getRight().midOrder();
        }
    }
    //后序遍历，递归左节点——递归右节点——自身
    public void postOrder(){
        if(this.getLeft()!= null){//如果存在左节点，则递归遍历
            this.getLeft().postOrder();
        }
        if(this.getRight()!=null){
            this.getRight().postOrder();
        }
        System.out.println(this);
    }

    //查找：
    //1.与根节点比较大小，相等返回，前序、中序、后序查找
    public void preSearch(TreeNode s){
        if(this.getId()==s.getId()){
            System.out.println(this);;
        }

        if(this.getLeft()!= null){//如果存在左节点，则递归遍历
            this.getLeft().preSearch(s);
        }
        if(this.getRight()!=null){
            this.getRight().preSearch(s);
        }
    }

    //中序遍历，递归左节点——自身——递归右节点
    public void midSearch(TreeNode s){


        if(this.getLeft()!= null){//如果存在左节点，则递归遍历
            this.getLeft().midSearch(s);
        }
        if(this.getId()==s.getId()){
            System.out.println(this);;
        }
        if(this.getRight()!=null){
            this.getRight().midSearch(s);
        }
    }
    //后序遍历，递归左节点——递归右节点——自身
    public void postSearch(TreeNode s){
        if(this.getLeft()!= null){//如果存在左节点，则递归遍历
            this.getLeft().postSearch(s);
        }

        if(this.getRight()!=null){
            this.getRight().postSearch(s);
        }

        if(this.getId()==s.getId()){
            System.out.println(this);;
        }

    }


    //删除
    //1.如果为叶子节点，则直接删除。
    //2.如果非叶子节点，则把以下的所有部分都删除。
    //分析步骤
    //1.判断是否为根节点，是则直接置为空。
    //2.判断左子节点，是则删除
    //3.如果左子节点不等，判断右子节点。
    //依旧没有找到，则递归左子节点、右子节点找

    public void delNode(int no){
        if(this.getLeft() != null && this.getLeft().getId() == no){
            this.setLeft(null);
            return;
        }

        if(this.getRight() != null && this.getRight().getId()== no){
            this.setRight(null);
            return;
        }

        //都找不到，则递归查找删除
        if(this.getLeft()!=null){
            this.getLeft().delNode(no);
        }

        if(this.getRight()!=null){
            this.getRight().delNode(no);
        }
    }



}

class TreeLink{
    private TreeNode root;//设置根节点，把整个二叉树组织起来。

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public void preView(){
        if(this.root != null){
            this.root.preOrder();
        }else{
            System.out.println("二叉树为空，无法遍历！");
        }

    }

    public void midView(){
        if(this.root !=null){
            this.root.midOrder();
        }else{
            System.out.println("二叉树为空，无法遍历！");
        }

    }

    public void postView(){
        if(this.root !=null){
            this.root.postOrder();
        }else{
            System.out.println("二叉树为空，无法遍历！");
        }
    }

    public void preFind(TreeNode s){
        if(this.root != null){
            this.root.preSearch(s);
        }else{
            System.out.println("二叉树为空，无法遍历！");
        }

    }

    public void midFind(TreeNode s){
        if(this.root !=null){
            this.root.midSearch(s);
        }else{
            System.out.println("二叉树为空，无法遍历！");
        }

    }

    public void postFind(TreeNode s){
        if(this.root !=null){
            this.root.postSearch(s);
        }else{
            System.out.println("二叉树为空，无法遍历！");
        }
    }

    public void delNode(int no){
        if(this.root != null){
            if(this.root.getId()==no){
                this.root = null;
            }else{
                this.root.delNode(no);
            }
        }else{
            System.out.println("该节点不存在！");
        }
    }
}

