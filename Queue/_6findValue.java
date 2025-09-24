import java.util.LinkedList;
import java.util.Queue;




// 如何在一棵二叉树中找出它最低层最左边节点的值？假设二叉树中最少有一个节点。




public class _6findValue {

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
    

    public int findValue(TreeNode root) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        
        queue1.offer(root);
        int bottomLeft = root.val;

        while (!queue1.isEmpty()) {
            TreeNode node = queue1.poll();

            if (node.left != null) {
                queue2.offer(node.left);
            }
            if (node.right != null) {
                queue2.offer(node.right);
            }
            if (queue1.isEmpty()) {
                bottomLeft = node.val;
                queue1 = queue2;
                queue2 = new LinkedList<>();
                if (!queue1.isEmpty()) {
                    bottomLeft = queue1.peek().val;
                }
            }
        }
        return bottomLeft;
    }
}
