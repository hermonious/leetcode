




// 请设计实现一个类型 MapSum，它有如下两个操作。 
// 函数 insert，输入一个字符串和一个整数，在数据集合中添加一个字符串及其对应的值。如果数据集合中已经包含该字符串，则将该字符串对应的值替换成新值。 
// 函数 sum，输入一个字符串，返回数据集合中所有以该字符串为前缀的字符串对应的值之和。


public class _5mapSum {
    

    static class TrieNode {
        public TrieNode[] children;
        public int val;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    private TrieNode root;

    public _5mapSum() {
        root = new TrieNode();
    }



    public void insert(String key, int val) {
        TrieNode cur = root;
        
        for (int i = 0; i < key.length(); i++) {

            int index = key.charAt(i) - 'a';

            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
        }
        cur.val = val;
    }



    public int sum(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (cur.children[index] == null) {
                return 0;
            }
            cur = cur.children[index];
        }
        return getSum(cur);
    }


    private int getSum(TrieNode node) {
        if (node == null) {
            return 0;
        }
        
        int res = node.val;

        for (TrieNode child : node.children) {
            if (child != null) {
                res += getSum(child);
            }
        }
        return res;
    }
}
