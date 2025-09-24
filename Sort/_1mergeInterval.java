
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;





// 输入一个区间的集合，请将重叠的区间合并。
// 每个区间用两个数字比较，分别表示区间的起始位置和结束位置。例如，输入区间[[1, 3], [4, 5], [8, 10], [2, 6], [9, 12], [15, 18]]，合并重叠的区间之后得到[[1, 6], [8, 12], [15, 18]]。 


public class _1mergeInterval {



    // 如果先将所有区间按照起始位置排序，那么只需要比较相邻两个区间的结束位置就能知道它们是否重叠。
    // 如果它们重叠就将它们合并，然后判断合并的区间是否和下一个区间重叠。重复这个过程，直到所有重叠的区间都合并为止。 
    public int[][] mergeInterval(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> merge = new LinkedList<>();

        int i = 0;

        while (i < intervals.length) {

            int[] temp = new int[] {intervals[i][0], intervals[i][1]};
            int j = i + 1;

            while (j < intervals.length && intervals[j][0] <= temp[1]) {
                temp[1] = Math.max(temp[1], intervals[j][1]);
                j++;
            }

            merge.add(temp);
            i = j;
        }

        int[][] res = new int[merge.size()][];
        return merge.toArray(res);
    }
}
