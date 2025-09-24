import java.util.List;

// 给定一组范围在 00:00 至 23:59 的时间，求任意两个时间之间的最小时间差。
// 例如，输入时间数组["23:50", "23:59", "00:00"]，"23:59"和"00:00"之间只有 1 分钟的间隔，是最小的时间差
public class _6minDifference {
    

    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 1440) {
            return 0;
        }

        boolean minuteFlags[] = new boolean[1440];
        for (String time : timePoints) {
            String[] timeArray = time.split(":");
            int minute = Integer.parseInt(timeArray[0]) * 60 + Integer.parseInt(timeArray[1]);
            if (minuteFlags[minute]) {
                return 0;
            }
            minuteFlags[minute] = true;
        }

        return helper(minuteFlags);
    }


    private int helper(boolean[] minuteFlags) {
        int minDiff = minuteFlags.length - 1;
        int prev = -1;
        int first = minuteFlags.length - 1;
        int last = -1;

        for (int i = 0; i < minuteFlags.length; i++) {
            if (minuteFlags[i]) {
                if (prev >= 0) {
                    minDiff = Math.min(minDiff, i - prev);
                }
                prev = i;
                first = Math.min(first, i);
                last = Math.max(last, i);
            }
        }
        minDiff = Math.min(minDiff, first + minuteFlags.length - last);
        return minDiff;
    }
}
