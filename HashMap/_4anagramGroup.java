import java.util.*;


// 给定一组单词，请将它们按照变位词分组。
// 例如，输入一组单词["eat", "tea", "tan", "ate", "nat", "bat"]，这组单词可以分成 3 组，分别是["eat", "tea", "ate"]、["tan", "nat"]和["bat"]。
// 假设单词中只包含英文小写字母。



public class _4anagramGroup {
    
    // 1.把每个英文小写字母映射到一个质数
    // 每给出一个单词，就把单词中的所有字母对应的数字相乘，于是每个单词都可以算出一个数字
    // 如果两个单词互为变位词，那么它们中每个字母出现的次数都对应相同
    public List<List<String>> groupAnagram(String[] strs) {
        int hash[] = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101};

        Map<Long, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            long wordHash = 1;
            for (int i = 0; i < str.length(); i++) {
                wordHash *= hash[str.charAt(i) - 'a'];
            }
            groups.putIfAbsent(wordHash, new LinkedList<String>());
            groups.get(wordHash).add(str);
        }
        return new LinkedList<>(groups.values());
    }



    


    // 第二种方法是把一组变位词映射到同一个单词。
    // 由于互为变位词的单词的字母出现的次数分别相同，因此如果把单词中的字母排序就会得到相同的字符串
    public List<List<String>> groupAnagram2(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sorted = new String(charArray);

            groups.putIfAbsent(sorted, new LinkedList<String>());
            groups.get(sorted).add(str);
        }
        return new LinkedList<>(groups.values());
    }
}
