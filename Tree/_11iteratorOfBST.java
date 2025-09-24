import java.util.Stack;


// 请实现二叉搜索树的迭代器 BSTIterator，它主要有如下 3 个函数。 
// 构造函数：输入二叉搜索树的根节点初始化该迭代器。 
// 函数 next：返回二叉搜索树中下一个最小的节点的值。 
// 函数 hasNext：返回二叉搜索树是否还有下一个节点。 


public class _11iteratorOfBST {
    // 基于中序遍历的迭代实现
    TreeNode cur;
    Stack<TreeNode> stack;

    public _11iteratorOfBST(TreeNode root) {
        cur = root;
        stack = new Stack<>();
    }

    public boolean hasNext() {
        return cur != null || !stack.isEmpty();
    }

    public int next() {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int res = cur.val;
        cur = cur.right;
        return res;
    }
}
