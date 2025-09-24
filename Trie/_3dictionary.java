




// 请实现有如下两个操作的神奇字典。 
// 函数 buildDict，输入单词数组用来创建一个字典。
// 函数 search，输入一个单词，判断能否修改该单词中的一个字符，使修改之后的单词是字典中的一个单词。



public class _3dictionary {
    
    static class TrieNode {
        TrieNode[] children;
        boolean isWord;

        public TrieNode() {
        children = new TrieNode[26];
        }
    }

    TrieNode root;

    public _3dictionary() {
        root = new TrieNode();
    }



    public void buildDict(String[] dict) {
        for (String word : dict) {

            TrieNode cur = root;
            for (char ch : word.toCharArray()) {

                int index = ch - 'a';

                if (cur.children[index] == null) {
                    cur.children[index] = new TrieNode();
                }
                cur = cur.children[index];
            }
            cur.isWord = true;
        }
    }



    public boolean search(String word) {
        return dfs(root, word, 0, 0);
    }


    private boolean dfs(TrieNode root, String word, int i, int edit) {
        if (root == null) {
            return false;
        }

        if (root.isWord && i == word.length() && edit == 1) {
            return true;
        }

        if (i < word.length() && edit <= 1) {

            boolean found = false;

            for (int j = 0; j < 26 && !found; j++) {
                int next = j == word.charAt(i) - 'a' ? edit : edit + 1;
                found = dfs(root.children[j], word, i + 1, next);
            }
            return found;
        }
        return false;
    }  
}
