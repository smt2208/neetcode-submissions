class NumMatrix {
    private int[][] prefix;

    public NumMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        // Padded grid (+1 size) to handle boundaries cleanly
        prefix = new int[rows + 1][cols + 1];

        // Build the 2D Prefix Sum array
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                prefix[r + 1][c + 1] = matrix[r][c]
                                     + prefix[r][c + 1]
                                     + prefix[r + 1][c]
                                     - prefix[r][c];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        // Apply Inclusion-Exclusion principle in O(1) time
        return prefix[row2 + 1][col2 + 1]
             - prefix[row1][col2 + 1]
             - prefix[row2 + 1][col1]
             + prefix[row1][col1];
    }
}