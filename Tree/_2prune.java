



// 一棵二叉树的所有节点的值要么是 0 要么是 1，请剪除该二叉树中所有节点的值全都是 0 的子树


public class _2prune {
    // 后序遍历解决
    public TreeNode prune(TreeNode root) {
        if (root == null) {
            return root;
        }

        root.left = prune(root.left);
        root.right = prune(root.right);

        // 如果一个节点可以被删除，那么它的子树的所有节点都可以被删除
        if (root.left == null && root.right == null && root.val == 0) {
            // 删除一个节点，就是返回 ‘null’ 给它的父节点
            return null;
        }   
        return root;
    }
}
