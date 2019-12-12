package com.lecode.datastructure;

/**
 * 〈一句话功能简述〉<br>
 * 〈在受污染的二叉树中查找元素〉
 *  给定一下满足条件的二叉树：
 *  1、root.val = 0;
 *  2、如果 treeNode.val == x 且 treeNode.left != null，那么 treeNode.left.val == 2 * x + 1
 *    如果 treeNode.val == x 且 treeNode.right != null，那么 treeNode.right.val == 2 * x + 2
 *  3、现在这棵二叉树受污染了，节点的值都是-1，请先还原二叉树
 *  4、FindElements(TreeNode* root) 用受污染的二叉树初始化对象，你需要先把它还原。
 *  5、bool find(int target) 判断目标值 target 是否存在于还原后的二叉树中并返回结果。
 *
 * @author baiwc
 * @date 2019-12-09 18:24
 * @since 2019.12.09
 */
public class FindElements {

    private TreeNode root;

    public FindElements(TreeNode root){
        if (root == null){
            return;
        }
        recover(root,0);
        this.root = root;

    }
    private void recover(TreeNode node,int x){
        node.val = x;
        if (node.left != null){
            recover(node.left,node.val * 2 + 1);
        }
        if (node.right != null){
            recover(node.right,node.val * 2 + 2);
        }
    }

    public boolean find(int target){
       return dfs(root,target);
    }

    private boolean dfs(TreeNode treeNode,int target){
        if (treeNode.val == target){
            return true;
        }
        if (treeNode.left != null && dfs(treeNode.left,target)){
           return true;
        }
        if (treeNode.right != null && dfs(treeNode.right,target)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        int a = 9;
        a |= (a >>2);
        System.out.println(" a 的值应该是 11，a的真正的值：" + a );
        System.out.println(Integer.highestOneBit(9));
    }
}

class TreeNode{

    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val = val;
    }
}