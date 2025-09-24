import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


// 深度优先搜索
public class _1dfs {
    

    // 1、中序遍历(递归)
    public List<Integer> inorder(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        dfs1(root, nodes);
        return nodes;
    }
    private void dfs1(TreeNode root, List<Integer> nodes) {
        if (root != null) {
            dfs1(root.left, nodes);
            nodes.add(root.val);
            dfs1(root.right, nodes);
        }
    }
    // 1、中序遍历(迭代)
    public List<Integer> inorder2(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            nodes.add(cur.val);
            cur = cur.right;
        }
        return nodes;
    }





    // 2、前序遍历(递归)
    public List<Integer> preorder(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        dfs2(root, nodes);
        return nodes;
    }
    private void dfs2(TreeNode root, List<Integer> nodes) {
        if (root != null) {
            nodes.add(root.val);
            dfs2(root.left, nodes);
            dfs2(root.right, nodes);
        }
    }
    // 2、前序遍历(迭代)
    public List<Integer> preorder2(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                nodes.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        return nodes;
    }





    // 3、后序遍历(递归)
    public List<Integer> postorder(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        dfs3(root, nodes);
        return nodes;
    }
    private void dfs3(TreeNode root, List<Integer> nodes) {
        if (root != null) {
            dfs3(root.left, nodes);
            dfs3(root.right, nodes);
            nodes.add(root.val);
        }
    }
    // 3、后序遍历(迭代)
    public List<Integer> postorder2(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                nodes.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        return nodes;
    }
}
