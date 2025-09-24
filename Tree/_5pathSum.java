import java.util.HashMap;
import java.util.Map;


// 给定一棵二叉树和一个值 sum，求二叉树中节点值之和等于 sum 的路径的数目。
// 路径是：二叉树中顺着指向子节点的指针向下移动所经过的节点，但不一定从根节点开始，也不一定到叶节点结束。



public class _5pathSum {
    // 使用前序遍历解决
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        return dfs(root, sum, map, 0);
    }

    private int dfs(TreeNode root, int sum, Map<Integer, Integer> map, int path) {
        if (root == null) {
            return 0;
        }

        path += root.val;
        int cnt = map.getOrDefault(path - sum, 0);
        map.put(path, map.getOrDefault(path, 0) + 1);

        cnt += dfs(root.left, sum, map, path);
        cnt += dfs(root.right, sum, map, path);

        map.put(path, map.get(path) - 1);
        return cnt;
    }
}
