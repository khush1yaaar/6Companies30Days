import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;


public class min_cost_to_convert_string {
    class Solution {
    public long[] helper(int start, ArrayList<int[]>[] adj) {
        PriorityQueue<Pair<Long, Integer>> pq = new PriorityQueue<>(
            (e1, e2) -> Long.compare(e1.getKey(), e2.getKey())
        );
        pq.add(new Pair<>(0L, start));
        long[] minCosts = new long[26];
        Arrays.fill(minCosts, -1);
        while(!pq.isEmpty()) {
            Pair<Long, Integer> currentPair = pq.poll();
            long currentCost = currentPair.getKey();
            int currentChar = currentPair.getValue();

            if (
                minCosts[currentChar] != -1L &&
                minCosts[currentChar] < currentCost
            ) continue;

            // Explore all possible conversions from the current character
            for (int[] conversion : adj[currentChar]) {
                int targetChar = conversion[0];
                long conversionCost = conversion[1];
                long newTotalCost = currentCost + conversionCost;

                // If we found a cheaper conversion, update its cost
                if (
                    minCosts[targetChar] == -1L ||
                    newTotalCost < minCosts[targetChar]
                ) {
                    minCosts[targetChar] = newTotalCost;
                    pq.add(new Pair<>(newTotalCost, targetChar));
                }
            }
        }
        return minCosts;
    }
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long result = 0;
        ArrayList<int[]>[] adj = new ArrayList[26];
        for(int i = 0; i < 26; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < original.length; i++) {
            int from = original[i] - 'a';
            int to = changed[i] - 'a';
            adj[from].add(new int[]{to, cost[i]});
        }


        long[][] minCosts = new long[26][26];
        for(int i = 0; i < 26; i++) {
            minCosts[i] = helper(i, adj);
        }

        for(int i = 0; i < source.length(); i++) {
            if(source.charAt(i) != target.charAt(i)) {
                long currCost = minCosts[source.charAt(i) - 'a'][target.charAt(i) - 'a'];

                if(currCost == -1) {
                    return -1;
                }

                result += currCost;
            }
        }

        return result;
    }
}
}
