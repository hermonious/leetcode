


// 在完全二叉树中，除最后一层之外其他层的节点都是满的（第 n 层有 2n1 个节点）。最后一层的节点可能不满，该层所有的节点尽可能向左边靠拢。例如，图 7.3 中的 4 棵二叉树均为完全二叉树。实现数据结构CBTInserter 有如下 3 种方法。 
// 构造函数 CBTInserter(TreeNode root)，用一棵完全二叉树的根节点初始化该数据结构。 
// 函数 insert(int v)在完全二叉树中添加一个值为 v 的节点，并返回被插入节点的父节点。例如，在如图 7.3（a）所示的完全二叉树中添加一个值为 7 的节点之后，二叉树如图 7.3（b）所示，并返回节点 3。在如图 7.3（b）所示的完全二叉树中添加一个值为 8 的节点之后，二叉树如图 7.3（c）所示，并返回节点 4。在如图 7.3（c）所示的完全二叉树中添加节点 9 会得到如图 7.3（d）所示的二叉树，并返回节点 4。 
// 函数 get_root()返回完全二叉树的根节点。

import java.util.LinkedList;
import java.util.Queue;


public class _4CBTInserter {
    private Queue<TreeNode> queue;
    private TreeNode root;


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

    public _4CBTInserter(TreeNode root) {
        this.root = root;

        queue = new LinkedList<>();
        queue.offer(root);
        while (queue.peek().left != null && queue.peek().right != null) {
            TreeNode node = queue.poll();
            queue.offer(node.left);
            queue.offer(node.right);
        }
    }


    public int insert(int v) {
        TreeNode parent = queue.peek();
        TreeNode node = new TreeNode(v);

        if (parent.left == null) {
            parent.left = node;
        } else {
            parent.right = node;

            queue.poll();
            queue.offer(parent.left);
            queue.offer(parent.right);
        }

        return parent.val;
    }

    public TreeNode get_root() {
        return root;
    }
}

