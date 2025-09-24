import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



// 二叉树的广度优先搜索 = 层序遍历
public class _3bfs {

    // 二叉树节点的定义
    class TreeNode {
        int val; 
        TreeNode left; 
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    
    public List<Integer> bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }

        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res.add(node.val);

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return res;
    }  
}
