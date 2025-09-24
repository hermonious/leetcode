


// 输入一个包含 n 个单词的数组，可以把它们编码成一个字符串和 n 个下标。
// 例如，单词数组["time", "me", "bell"]可以编码成一个字符串"time#bell#"，然后这些单词就可以通过下标[0, 2, 5]得到。



public class _4minEncoding {
    

    // 使用dfs的思路
    static class TrieNode {
        public TrieNode[] children;
        public boolean isWord;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }


    public int minEncoding(String[] words) {
        TrieNode root = buildTrie(words);

        int[] total = {0};
        dfs(root, 1, total);
        return total[0];
    }


    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode cur = root;
            
            for (int i = word.length() - 1; i >= 0; i--) {

                int index = word.charAt(i) - 'a';

                if (cur.children[index] == null) {
                    cur.children[index] = new TrieNode();
                }
                cur = cur.children[index];
            }
        }
        return root;
    }



    private void dfs(TrieNode root, int depth, int[] total) {
        boolean isLeaf = true;

        for (TrieNode child : root.children) {
            if (child != null) {
                isLeaf = false;
                dfs(child, depth + 1, total);
            }
        }
        if (isLeaf) {
            total[0] += depth;
        }
    }
}

