import java.util.Stack;



// 给定一棵二叉搜索树，请将它的 ’每个节点的值‘ 替换成 ’树中 >= 该节点值的所有节点值之和‘
// 假设二叉搜索树中节点的值唯一



public class _10convertBST {
    // 颠倒的中序排序
    public TreeNode convertNode(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        int sum = 0;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.right;
            }

            cur = stack.pop();
            sum += cur.val;
            cur.val = sum;
            cur = cur.left;
        }
        return root;
    }
}
