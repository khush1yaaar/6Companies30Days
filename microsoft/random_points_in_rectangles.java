import java.util.Random;

public class random_points_in_rectangles {

    class Solution {
        int[][] rects;
        int[] areas;
        Random rand;

        public Solution(int[][] rects) {
            this.rects = rects;
            this.areas = new int[rects.length];
            this.rand = new Random();

            // Calculate prefix sum of areas
            for (int i = 0; i < rects.length; i++) {
                int x1 = rects[i][0], y1 = rects[i][1];
                int x2 = rects[i][2], y2 = rects[i][3];
                int area = (x2 - x1 + 1) * (y2 - y1 + 1);
                areas[i] = area + (i > 0 ? areas[i - 1] : 0);
            }
        }

        public int[] pick() {
            // Pick a rectangle using weighted random selection
            int target = rand.nextInt(areas[areas.length - 1]);
            int rectIndex = binarySearch(target);

            // Get the rectangle
            int[] rect = rects[rectIndex];
            int x1 = rect[0], y1 = rect[1];
            int x2 = rect[2], y2 = rect[3];

            // Pick a random point inside the selected rectangle
            int x = x1 + rand.nextInt(x2 - x1 + 1);
            int y = y1 + rand.nextInt(y2 - y1 + 1);

            return new int[]{x, y};
        }

        private int binarySearch(int target) {
            int left = 0, right = areas.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (areas[mid] > target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }
    public static void main(String[] args) {

    }
}
