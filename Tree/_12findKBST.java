import java.util.HashSet;
import java.util.Set;
import java.util.Stack;


// 给定一棵二叉搜索树和一个值 k，请判断该二叉搜索树中是否存在值之和等于 k 的两个节点。
// 假设二叉搜索树中节点的值均唯一。


public class _12findKBST {
    // 空间复杂度为O(n)的解法---哈希表
    public boolean findK(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            if (set.contains(k - cur.val)) {
                return true;
            }

            set.add(cur.val);
            cur = cur.right;
        }
        return false;
    }








                    // 先写颠倒顺序的BST的迭代器
                    public class BSTIteratorReversed{
                        TreeNode cur;
                        Stack<TreeNode> stack;

                        public BSTIteratorReversed(TreeNode root) {
                            cur = root;
                            stack = new Stack<>();
                        }

                        public boolean hasPrev() {
                            return cur != null || !stack.isEmpty();
                        }

                        public int prev() {
                            while (cur != null) {
                                stack.push(cur);
                                cur = cur.right;
                            }

                            cur = stack.pop();
                            int res = cur.val;
                            cur = cur.left;
                            return res;
                        }
                    }


                    // 基于中序遍历实现的迭代器
                    public class BSTIterator {
                        TreeNode cur;
                        Stack<TreeNode> stack;

                        public BSTIterator(TreeNode root) {
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




            // 空间复杂度为O(h)的解法---双指针
            public boolean findK1(TreeNode root, int k) {
                if (root == null) {
                    return false;
                }

                BSTIterator iterNext = new BSTIterator(root);
                BSTIteratorReversed iterPrev = new BSTIteratorReversed(root);

                int next = iterNext.next();
                int prev = iterPrev.prev();
                while (next != prev) {
                    if (next + prev == k) {
                        return true;
                    } else if (next + prev < k) {
                        next = iterNext.next();
                    } else {
                        prev = iterPrev.prev();
                    }
                }
                return false;
            }
}
