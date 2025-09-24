


// 在一棵二叉树中所有节点都在 0～9 的范围之内，
// 从根节点到叶节点的路径表示一个数字。求二叉树中所有路径表示的数字之和。


public class _4sumNum {
    // 前序遍历解决
    public int sumNum(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int path) {
        if (root == null) {
            return 0;
        }

        path = path * 10 + root.val;
        if (root.left == null && root.right == null) {
            return path;
        }
        return dfs(root.left, path) + dfs(root.right, path);
    }
}
