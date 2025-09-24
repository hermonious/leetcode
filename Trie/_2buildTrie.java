import java.util.List;




// 英语中有一个概念叫词根。在词根后面加上若干字符就能拼出更长的单词。
// 例如，"an"是一个词根，在它后面加上"other"就能得到另一个单词"another"。
// 现在给定一个由词根组成的字典和一个英语句子，如果句子中的单词在字典中有它的词根，则用它的词根替换该单词；
// 如果单词没有词根，则保留该单词。请输出替换后的句子。
// 例如，如果词根字典包含字符串["cat", "bat", "rat"]，英语句子为"the cattle was rattled by the battery"，
// 则替换之后的句子是"the cat was rat by the bat"。




public class _2buildTrie {
    // 前缀树节点定义（不变）
    private static class TrieNode {
        TrieNode[] children;
        boolean isWord;

        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }

    // 移除冗余的成员变量root，直接通过buildTrie返回根节点

    // 1. 构建前缀树（逻辑不变，仅移除冗余返回值的重复定义）
    public TrieNode buildTrie(List<String> dict) {
        
        TrieNode root = new TrieNode();

        for (String word : dict) {

            TrieNode cur = root;

            for (char ch : word.toCharArray()) {
                
                int index = ch - 'a';

                if (cur.children[index] == null) {
                    cur.children[index] = new TrieNode();
                }
                cur = cur.children[index];
            }
            cur.isWord = true; // 标记词根结尾
        }
        return root;
    }

    // 2. 修复：查找单词的最短词根
    public String findPrefix(TrieNode root, String word) {
        
        TrieNode cur = root;
        StringBuilder builder = new StringBuilder();
        for (char ch : word.toCharArray()) {

            int index = ch - 'a';
            
            if (cur.isWord || cur.children[index] == null) {
                break;
            }
            builder.append(ch);
            cur = cur.children[index];
        }
        return cur.isWord ? builder.toString() : "";
    }

    // 3. 替换句子中的单词（逻辑不变，补充边界处理）
    public String replaceWords(List<String> dict, String sentence) {
        
        TrieNode trieRoot = buildTrie(dict);
        StringBuilder builder = new StringBuilder();
        // 分割句子为单词数组
        String[] words = sentence.split(" ");
        // 遍历单词并替换
        for (int i = 0; i < words.length; i++) {
            String prefix = findPrefix(trieRoot, words[i]);
            if (!prefix.isEmpty()) {
                words[i] = prefix;
            }
        }
        // 重组句子
        return String.join(" ", words);
    }
}