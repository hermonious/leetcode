





// 一个密码锁由 4 个环形转轮组成，每个转轮由 0～9 这 10 个数字组成。
// 每次可以上下拨动一个转轮，如可以将一个转轮从 0 拨到 1，也可以从 0 拨到 9。
// 密码锁有若干死锁状态，一旦 4 个转轮被拨到某个死锁状态，这个锁就不可能打开。
// 密码锁的状态可以用一个长度为 4 的字符串表示，字符串中的每个字符对应某个转轮上的数字。
// 输入密码锁的密码和它的所有死锁状态，请问至少需要拨动转轮多少次才能从起始状态"0000"开始打开这个密码锁？如果锁不可能打开，则返回-1

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class _5openLock {
    



    // 2个队列实现bfs
    public int openLock(String[] deadends, String target) {

        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        String init = "0000";

        if (dead.contains(init) || dead.contains(target)) {
            return -1;
        }

        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        int steps = 0;
        
        queue1.offer(init);
        visited.add(init);

        while (!queue1.isEmpty()) {
            String cur = queue1.remove();

            if (cur.equals(target)) {
                return steps;
            }

            List<String> nexts = getNeighbors(cur);

            for (String next : nexts) {
                if (!dead.contains(next) && !visited.contains(next)) {
                    queue2.add(next);
                    visited.add(next);
                }
            }

            if (queue1.isEmpty()) {
                steps++;
                queue1 = queue2;
                queue2 = new LinkedList<>();
            }
        }
        return -1;
    }





    // 单向bfs
    private List<String> getNeighbors(String cur) {
        
        List<String> nexts = new LinkedList<>();

        for (int i = 0; i < cur.length(); i++) {
            char ch = cur.charAt(i);

            char newCh = ch == '0' ? '9' : (char)(ch - 1);
            StringBuilder sb = new StringBuilder(cur);
            sb.setCharAt(i, newCh);
            nexts.add(sb.toString());

            newCh = ch == '9' ? '0' : (char)(ch + 1);
            sb.setCharAt(i, newCh);
            nexts.add(sb.toString());
        }
        return nexts;
    }
}
