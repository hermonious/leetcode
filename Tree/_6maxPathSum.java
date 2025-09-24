



// 在二叉树中将路径是：顺着节点之间的连接从任意一个节点开始到达任意一个节点所经过的所有节点。
// 路径中至少包含一个节点，不一定经过二叉树的根节点，也不一定经过叶节点。
// 给定 ‘非空’ 的一棵二叉树，请求出二叉树所有路径上节点值之和的 ‘最大值’ 



public class _6maxPathSum {
    // 使用后序遍历解决
    public int maxPathSum(TreeNode root) {
        int[] maxSum = {Integer.MIN_VALUE};
        dfs(root, maxSum);
        return maxSum[0];
    }
    private int dfs(TreeNode root, int[] maxSum) {
        if (root == null) {
            return 0;
        }

        int[] sumLeft = {Integer.MIN_VALUE};
        int left = Math.max(0, dfs(root.left, sumLeft));

        int[] sumRight = {Integer.MIN_VALUE};
        int right = Math.max(0, dfs(root.right, sumRight));

        maxSum[0] = Math.max(sumLeft[0], sumRight[0]);
        maxSum[0] = Math.max(maxSum[0], left + right + root.val);

        return Math.max(left, right) + root.val;
    }



    // 简化
    // private int maxSum = Integer.MIN_VALUE;

    // public int maxPathSum(TreeNode root) {
    //     dfs(root);
    //     return maxSum;
    // }

    // private int dfs(TreeNode node) {
    //     if (node == null) {
    //         return 0;
    //     }

    //     // 递归计算左右子树的最大单边路径和（小于 0 的不要）
    //     int left = Math.max(0, dfs(node.left));
    //     int right = Math.max(0, dfs(node.right));

    //     // 当前节点作为“最高点”时，可能的最大路径和
    //     maxSum = Math.max(maxSum, left + right + node.val);

    //     // 返回当前节点能提供给父节点的最大单边路径和
    //     return Math.max(left, right) + node.val;
    // }
}