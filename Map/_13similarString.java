



// 如果交换字符串 X 中的两个字符就能得到字符串 Y，那么两个字符串 X 和 Y 相似
// 输入一个字符串数组，根据字符串的相似性分组，请问能把输入数组分成几组？
// 如果一个字符串至少和一组字符串中的一个相似，那么它就可以放到该组中。假设输入数组中的所有字符串的长度相同并且两两互为变位词。
// 例如，输入数组为["tars","rats","arts","star"]，可以分成两组，一组为{"tars", "rats", "arts"}，另一组为{"star"}





public class _13similarString {
    

    public int similarGroup(String[] a) {

        int[] fathers = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            fathers[i] = i;
        }

        int groups = a.length;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (similar(a[i], a[j]) && union(fathers, i, j)) {
                    groups--;
                }
            }
        }
        return groups;
    }


    private boolean similar(String s1, String s2) {
        int diffCount = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffCount++;

            }
        }
        return diffCount <= 2;
    }



    private boolean union(int[] fathers, int i, int j) {

        int fatherOfI = findFather(fathers, i);
        int fatherOfJ = findFather(fathers, j);

        if (fatherOfI != fatherOfJ) {
            fathers[fatherOfI] = fatherOfJ;
            return true;
        }
        return false;
    }



    private int findFather(int[] fathers, int i) {
        if (fathers[i] != i) {
            fathers[i] = findFather(fathers, fathers[i]);
        }
        return fathers[i];
    }
}
