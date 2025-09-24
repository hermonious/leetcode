import java.util.LinkedList;
import java.util.List;
import java.util.Queue;







// 输入一棵二叉树，请找出二叉树中每层的最大值



public class _5maxValues {
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






    // 1、使用一个队列实现二叉树的广度优先搜索
    public List<Integer> maxValues(TreeNode root) {
        int cur = 0;
        int next = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
            cur = 1;
        }

        List<Integer> res = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            cur--;
            max = Math.max(max, node.val);

            if (node.left != null) {
                queue.offer(node.left);
                next++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                next++;
            }

            if (cur == 0) {
                res.add(max);
                max = Integer.MIN_VALUE;
                cur = next;
                next = 0;
            }
        }
        return res;
    }








    // 2、使用两个队列实现二叉树的广度优先搜索
    public List<Integer> maxValues2(TreeNode root) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        if (root != null) {
            queue1.offer(root);
        }

        List<Integer> res = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        while (!queue1.isEmpty()) {
            TreeNode node = queue1.poll();
            max = Math.max(max, node.val);

            if (node.left != null) {
                queue2.offer(node.left);
            }
            if (node.right != null) {
                queue2.offer(node.right);
            }

            if (queue1.isEmpty()) {
                res.add(max);
                max = Integer.MIN_VALUE;
                queue1 = queue2;
                queue2 = new LinkedList<>();
            }
        }
        return res;
    }
}
