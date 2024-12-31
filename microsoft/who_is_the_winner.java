import java.util.ArrayList;

public class who_is_the_winner {
    public static int findTheWinner(int n, int k) {
        ArrayList<Integer> nums = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            nums.add(i+1);
        }
        int start = 0;
        while(nums.size() > 1) {
            start = (start + k - 1) % nums.size();
            nums.remove(start);
        }

        return nums.get(0);
    }

    public static void main(String[] args) {
        System.out.println(findTheWinner(5, 2)); // 3
    }
}
