import java.util.Stack;



// 给定一棵二叉搜索树，请调整节点的指针使每个节点都没有左子节点。
// 调整之后的树看起来像一个链表，但仍然是二叉搜索树


public class _8flattenBST {
    

    public TreeNode flattenBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        TreeNode first = null;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            if (prev != null) {
                prev.right = cur;
            } else {
                first = cur;
            }

            prev = cur;
            cur.left = null;
            cur = cur.right;
        }
        return first;
    }
}
