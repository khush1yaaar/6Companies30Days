import java.util.Arrays;
import java.util.HashMap;

public class envelops_and_dolls {
    static class Pair {
        int w;
        int h;
        public Pair(int w, int h) {
            this.w = w;
            this.h = h;
        }
    }
    public static int helper(int idx, int[][] e, Pair prev, HashMap<String, Integer> dp) {
        if(idx == e.length) {
            return 0;
        }
        String key = idx + "," + prev.w + "," + prev.h;
        if(dp.containsKey(key)) {
            return dp.get(key);
        }

        int pick = 0;
        int notPick = helper(idx + 1, e, prev, dp);
        if(prev.w < e[idx][0] && prev.h < e[idx][1]) {
            pick = 1 + helper(idx + 1, e, new Pair(e[idx][0], e[idx][1]), dp);
        }
        dp.put(key, Math.max(pick, notPick));
        return Math.max(pick, notPick);
    }
    public static int maxEnvelopes(int[][] e) {
        Arrays.sort(e, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1]; // Descending for height if widths are equal
            return a[0] - b[0]; // Ascending for width
        });


        int dp[] = new int[e.length];
        int len = 0;
        for(int[] envelope : e){
            int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
            if(index < 0)
                index = -(index + 1);
            dp[index] = envelope[1];
            if(index == len)
                len++;
        }
        return len;
    }
    public static void main(String[] args) {
        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        maxEnvelopes(envelopes); // 3
    }
}
