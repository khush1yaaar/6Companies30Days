public class number_of_incremovable_subarray {
    public static int incremovableSubarrayCount(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                boolean ok = true;
                int last = -1;
                for(int k = 0; k < n; k++) {
                    if(k >= i && k <= j) continue;

                    else {
                        ok &= (last < nums[k]);
                        last = nums[k];
                    }
                }

                ans += ok ? 1 : 0;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(incremovableSubarrayCount(nums));// 10
    }
}
