




// 一种外星语言的字母都是英文字母，但字母的顺序未知。给定该语言排序的单词列表，请推测可能的字母顺序。
// 如果有多个可能的顺序，则返回任意一个。如果没有满足条件的字母顺序，则返回空字符串。
// 例如，如果输入排序的单词列表为["ac", "ab", "bc", "zc", "zb"]，那么一个可能的字母顺序是"acbz"

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class _10alienOrder {
    
    public String alienOrder(String[] words) {

        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegrees = new HashMap<>();

        for (String word : words) {
            for (char ch : word.toCharArray()) {

                graph.putIfAbsent(ch, new HashSet<>());
                inDegrees.putIfAbsent(ch, 0);
            }
        }

        for (int i = 1; i < words.length; i++) {

            String w1 = words[i - 1];
            String w2 = words[i];

            if (w1.startsWith(w2) && !w1.equals(w2)) {
                return "";
            }

            for (int j = 0; j < w1.length() && j < w2.length(); j++) {

                char ch1 = w1.charAt(j);
                char ch2 = w2.charAt(j);

                if (ch1 != ch2) {
                    if (!graph.get(ch1).contains(ch2)) {
                        graph.get(ch1).add(ch2);
                        inDegrees.put(ch2, inDegrees.get(ch2) + 1);
                    }

                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for (char ch : inDegrees.keySet()) {
            if (inDegrees.get(ch) == 0) {
                queue.add(ch);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            char ch = queue.remove();
            sb.append(ch);

            for (char next : graph.get(ch)) {
                inDegrees.put(next, inDegrees.get(next) - 1);
                if (inDegrees.get(next) == 0) {
                    queue.add(next);
                }
            }
        }

        return sb.length() == graph.size() ? sb.toString() : "";
    }
}
