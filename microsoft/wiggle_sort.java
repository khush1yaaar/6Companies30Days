import java.util.Arrays;
import java.util.PriorityQueue;

public class wiggle_sort {
    class Solution {
        public void wiggleSort(int[] nums) {
            PriorityQueue<Integer> q = new PriorityQueue<>((a,b)->Integer.compare(b,a));
            Arrays.sort(nums);
            for(int i = 0; i < nums.length; i++) {
                q.add(nums[i]);
            }

            for(int i = 1; i < nums.length; i += 2) {
                nums[i] = q.remove();
            }
            for(int i = 0; i < nums.length; i += 2) {
                nums[i] = q.remove();
            }
        }
    }
}
