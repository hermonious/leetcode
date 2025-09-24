


// 请设计实现一棵前缀树 Trie，它有如下操作。
// 函数 insert，在前缀树中添加一个字符串。 
// 函数 search，查找字符串。如果前缀树中包含该字符串，则返回true；否则返回 false。 
// 函数 startWith，查找字符串前缀。如果前缀树中包含以该前缀开头的字符串，则返回 true；否则返回 false。 






// 前缀树实现类
public class _1implement {
    // 前缀树节点类
    private static class TrieNode {
        TrieNode[] children; // 子节点数组，对应26个小写字母
        boolean isWord;      // 标记当前节点是否为一个单词的结尾
        
        // 节点构造方法
        public TrieNode() {
            children = new TrieNode[26]; // 初始化26个字母的位置
            isWord = false;
        }
    }
    
    private TrieNode root; // 根节点
    
    // 前缀树构造方法
    public _1implement() {
        root = new TrieNode();
    }
    
    // 向前缀树中插入一个字符串
    public void insert(String word) {
        TrieNode cur = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a'; // 计算字符对应的索引(0-25)
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
        }
        cur.isWord = true; // 标记单词结束
    }
    
    // 查找字符串是否在前缀树中
    public boolean search(String word) {
        TrieNode cur = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (cur.children[index] == null) {
                return false; // 字符不存在，直接返回false
            }
            cur = cur.children[index];
        }
        return cur.isWord; // 检查是否是完整单词
    }
    
    // 查找是否有以指定前缀开头的字符串
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (cur.children[index] == null) {
                return false; // 前缀字符不存在
            }
            cur = cur.children[index];
        }
        return true; // 前缀存在
    }
}
