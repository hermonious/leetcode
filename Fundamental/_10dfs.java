import java.util.ArrayList;
import java.util.List;


public class _10dfs {
    

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { 
            this.val = val; 
        }
    }


    // 使用 递归 实现dfs
    // 前序遍历
    public List<Integer> pre(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }

    private void preOrder(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        res.add(node.val);
        preOrder(node.left, res);
        preOrder(node.right, res);
    }



    // 中序遍历
    public List<Integer> in(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrder(root, res);
        return res;
    }
    private void inOrder(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        inOrder(node.left, res);
        res.add(node.val);
        inOrder(node.right, res);
    }






    // 后序遍历
    public List<Integer> post(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postOrder(root, res);
        return res;
    }
    private void postOrder(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        postOrder(node.left, res);
        postOrder(node.right, res);
        res.add(node.val);
    }
}
