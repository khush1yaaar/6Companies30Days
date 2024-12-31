public class image_smoother {
    public static int smooth(int i, int j, int[][] img, int n, int m) {
        int total = 1;
        int sum = img[i][j];
        int[] dr = {-1, 1, 0, 0, 1, -1, -1, 1};
        int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
        for(int k = 0; k < 8; k++) {
            int row = i + dr[k];
            int col = j + dc[k];
            if(row < n && col < m && row >= 0 && col >= 0) {
                total++;
                sum += img[row][col];
            }
        }

        return sum / total;
    }
    public static int[][] imageSmoother(int[][] img) {
        int n = img.length;
        int m = img[0].length;
        int[][] result = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                result[i][j] = smooth(i, j, img, n, m);
            }
        }

        return result;
    }
    public static void main(String[] args) {
        int[][] img = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };
        img = imageSmoother(img);
    }
}
