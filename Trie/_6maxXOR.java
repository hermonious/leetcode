



// 输入一个整数数组（每个数字都大于或等于 0），请计算其中任意两个数字的异或的最大值。
// 例如，在数组[1, 3, 4, 7]中，3 和 4 的异或结果最大，异或结果为 7。 



public class _6maxXOR {
    

    static class TrieNode {
        public TrieNode[] children;
        public TrieNode() {
            children = new TrieNode[2];
        }
    }



    private TrieNode buildTrie(int[] nums) {
        TrieNode root = new TrieNode();
        for (int num : nums) {
            TrieNode cur = root;

            for (int i = 31; i >= 0; i--) {

                int bit = (num >> i) & 1;

                if (cur.children[bit] == null) {
                    cur.children[bit] = new TrieNode();
                }
                cur = cur.children[bit];
            }
        }
        return root;
    }


    public int maxXOR(int[] nums) {
        TrieNode root = buildTrie(nums);
        int max = 0;
        for (int num : nums) {
            TrieNode cur = root;
            int xor = 0;

            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;

                if (cur.children[1 - bit] != null) {
                    xor = (xor << 1) + 1;
                    cur = cur.children[1 - bit];
                } else {
                    cur = cur.children[bit];
                }
            }
            max = Math.max(max, xor);
        }
        return max;
    }
}
