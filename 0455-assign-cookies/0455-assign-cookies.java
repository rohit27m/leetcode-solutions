import java.util.*;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int j = 0;
        int res = 0;

        for (int i : g) {
            while (j < s.length && s[j] < i) {
                j++;
            }

            if (j < s.length) {
                res++;
                j++;
            } else {
                break;
            }
        }

        return res;
    }
}