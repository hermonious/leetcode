
import java.util.LinkedList;
import java.util.List;


// 输入一个只包含数字的字符串，请列出所有可能恢复出来的 IP 地址。
// 例如，输入字符串"10203040"，可能恢复出 3 个 IP 地址，分别为"10.20.30.40"、"102.0.30.40"和"10.203.0.40"。





public class _9IPAddress {
    
    public List<String> restore(String s) {
        List<String> res = new LinkedList<>();
        helper(s, 0, 0, "", "", res);

        return res;
    }



    private void helper(String s, int i, int segI, String seg, String ip, List<String> res) {

        if (i == s.length() && segI == 3 && isValidSeg(seg)) {
            res.add(ip + seg);
        } else if (i < s.length() && segI <= 3) {

            char ch = s.charAt(i);

            if (isValidSeg(seg + ch)) {
                helper(s, i + 1, segI, seg + ch, ip, res);
            }

            if (seg.length() > 0 && segI < 3) {
                helper(s, i + 1, segI + 1, "" + ch, ip + seg + ".", res);
            }
        }
    }



    private boolean isValidSeg(String seg) {
        return Integer.valueOf(seg) <= 255 && (seg.equals("0") || seg.charAt(0) != '0');
    }
}
