import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;


// 输入两个长度相同但内容不同的单词（beginWord 和 endWord）和一个单词列表，求从 beginWord 到 endWord 的演变序列的最短长度，要求每步只能改变单词中的一个字母，并且演变过程中每步得到的单词都必须在给定的单词列表中。
// 如果不能从 beginWord 演变到 endWord，则返回 0。假设所有单词只包含英文小写字母



public class _4ladder {
    


    // 使用单向bfs
    public int ladder(String beginWord, String endWord, List<String> wordList) {
        
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        Set<String> notVisited = new HashSet<>(wordList);
        int length = 1;
        queue1.add(beginWord);
        

        while (!queue1.isEmpty()) {
            String word = queue1.remove();
            if (word.equals(endWord)) {
                return length;
            }

            List<String> neighbors = getNeighbors(word);

            for (String neighbor : neighbors) {
                if (notVisited.contains(neighbor)) {
                    queue2.add(neighbor);
                    notVisited.remove(neighbor);
                }
            }

            if (queue1.isEmpty()) {
                queue1 = queue2;
                queue2 = new LinkedList<>();
                length++;
            }
        }
        return 0;
    }








    // 双向bfs
    public int ladder2(String beginWord, String endWord, List<String> wordList) {

        Set<String> notVisited = new HashSet<>(wordList);

        if (!notVisited.contains(endWord)) {
            return 0;
        }

        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        int length = 2;
        set1.add(beginWord);
        set2.add(endWord);
        notVisited.remove(endWord);

        while (!set1.isEmpty() && !set2.isEmpty()) {
            if (set2.size() < set1.size()) {
                Set<String> temp = set1;
                set1 = set2;
                set2 = temp;
            }

            Set<String> set3 = new HashSet<>();

            for (String word : set1) {
                List<String> neighbors = getNeighbors(word);

                for (String neighbor : neighbors) {
                    if (set2.contains(neighbor)) {
                        return length;
                    }

                    if (notVisited.contains(neighbor)) {
                        set3.add(neighbor);
                        notVisited.remove(neighbor);
                    }
                }
            }

            length++;
            set1 = set3;
        }
        return 0;
    }



    private List<String> getNeighbors(String word) {

        List<String> neighbors = new LinkedList<>();
        char[] chars = word.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char old = chars[i];

            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (old != ch) {
                    chars[i] = ch;
                    neighbors.add(new String(chars));
                }
            }

            chars[i] = old;
        }

        return neighbors;
    }
}
