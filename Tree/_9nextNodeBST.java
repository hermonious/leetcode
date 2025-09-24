import java.util.Stack;



// 给定一棵二叉搜索树和它的一个节点 p，请找出按中序遍历的顺序该节点 p 的下一个节点。
// 假设二叉搜索树中节点的值都是唯一的


public class _9nextNodeBST {
    

    // O(n)的解法，使用中序遍历
    public TreeNode nextNode(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        boolean found = false;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            if (found) {
                break;
            } else if (p == cur) {
                found = true;
            }
            cur = cur.right;
        }
        return cur;
    }




    // O(h)的解法
    public TreeNode nextnOde(TreeNode root, TreeNode p) {
        TreeNode cur = root;
        TreeNode res = null;

        while (cur != null) {
            if (cur.val > p.val) {
                res = cur;
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return res;
    }
}
