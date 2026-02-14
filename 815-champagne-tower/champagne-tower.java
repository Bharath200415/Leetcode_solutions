class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        
        double[][] grid = new double[101][101];
        grid[0][0] = (double) poured;
        double pour = (double) poured;
        for(int i = 0;i <= query_row;i++){
            for(int j = 0;j <= i ;j++){
                if(grid[i][j] > 0){
                    if(grid[i][j] >= 1){
                        double remaining = grid[i][j] - 1;
                        grid[i+1][j] += (double)remaining/2;
                        grid[i+1][j+1] += (double)remaining/2;
                    }
                    
                }
                
            }
        }
        return Math.min(1.0, grid[query_row][query_glass]);
    }

}    