



// 树可以看成无环的无向图。在一个包含 n 个节点（节点标号为从 1 到 n）的树中添加一条边连接任意两个节点，这棵树就会变成一个有环的图。
// 给定一个在树中添加了一条边的图，请找出这条多余的边（用这条边连接的两个节点表示）。
// 输入的图用一个二维数组 edges 表示，数组中的每个元素是一条边的两个节点[u, v]（u<v）。
// 如果有多个答案，请输出在数组 edges 中最后出现的边




public class _14redundantConnect {
    


    public int[] connect(int[][] edges) {

        int maxVertex = 0;
        for (int[] edge : edges) {
            maxVertex = Math.max(maxVertex, edge[0]);
            maxVertex = Math.max(maxVertex, edge[1]);
        }

        int[] fathers = new int[maxVertex + 1];
        for (int i = 1; i <= maxVertex; i++) {
            fathers[i] = i;
        }

        for (int[] edge : edges) {
            if (!union(fathers, edge[0], edge[1])) {
                return edge;
            }
        }
        return new int[2];
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
