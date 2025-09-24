


// 有一门外星语言，它的字母表刚好包含所有的英文小写字母，只是字母表的顺序不同。
// 给定一组单词和字母表顺序，请判断这些单词是否按照字母表的顺序排序


public class _5isAlienSorted {
    

    public boolean isAlienSorted(String[] words, String order) {
        int[] orderArray = new int[order.length()];

        for (int i = 0; i < order.length(); i++) {
            orderArray[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            if (!(isSorted(words[i], words[i + 1], orderArray))) {
                return false;
            }
        }
        return true;
    }



    private boolean isSorted(String s1, String s2, int[] order) {
        int i = 0;

        for (; i < s1.length() && i < s2.length(); i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            if (order[ch1 - 'a'] < order[ch2 - 'a']) {
                return true;
            } else if (order[ch1 - 'a'] > order[ch2 - 'a']) {
                return false;
            }
        }
        return i == s1.length();
    }
}
