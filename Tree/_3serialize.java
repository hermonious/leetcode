



// 请设计一个算法将二叉树序列化成一个字符串，并能将该字符串反序列化出原来二叉树的算法。
public class _3serialize {
    // 前序遍历，进行序列化，也方便进行反序列化
    public String serialize(TreeNode root) {
        // null序列化为 ‘#’
        if (root == null) {
            return "#";
        }

        String leftStr = serialize(root.left);
        String rightStr = serialize(root.right);
        return String.valueOf(root.val) + "," + leftStr + "," + rightStr;
    }
}
