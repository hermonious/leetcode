


// 在BST中根据节点值查找对应节点
public class _7searchBST {
    
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode cur = root;

        while (cur != null) {
            if (cur.val == val) {
                break;
            }

            if (cur.val > val) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return cur;
    }
}
