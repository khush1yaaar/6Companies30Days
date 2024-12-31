import java.util.Arrays;

public class minimum_moves_to_equal_array_elements {
    public static int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int mid = n / 2;
        int result = 0;
        for(int i = 0; i < n; i++) {
            result += Math.abs(nums[i] - nums[mid]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(minMoves2(arr)); // 2
    }
}
