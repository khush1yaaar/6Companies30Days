public class counting_nice_sub_arrays {
    class Solution {
        public int findTheCity(int n, int[][] edges, int distanceThreshold) {
            int[][] matrix = new int[n][n];
            for(int i = 0; i < n; i++) {
                for(int j=0;j<n;j++) {
                    matrix[i][j] = (int)1e9;
                }
            }
            for(int i = 0; i < edges.length; i++) {
                int u = edges[i][0];
                int v = edges[i][1];
                int wt = edges[i][2];
                matrix[u][v] = wt;
                matrix[v][u] = wt;
            }
    
            for(int i = 0; i < n; i++) {
                matrix[i][i] = 0;
            }
            
            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    for( int j = 0; j < n; j++) {
                        matrix[i][j] = Math.min(matrix[i][j],
                        matrix[i][k] + matrix[k][j]);
                    }
                }
            }
            
    
            int city = -1;
            int minCount = Integer.MAX_VALUE;
            for(int i = 0;i < n; i++) {
                int count = 0;
                for(int j = 0; j < n; j++) {
                    if(matrix[i][j] <= distanceThreshold) {
                        count++;
                    }
                }
                if(minCount >= count) {
                    minCount = count;
                    city = i;
                }
            }
    
            return city;
        }
    }
}
