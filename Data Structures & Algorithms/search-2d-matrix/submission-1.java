class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowTarget = 0;
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        
        int low = 0;
        int high = numRows - 1;

        // target = 4
        // 0 1 2 3
        // 4 5 6 7
        // 8 9 10 11
        // low = 0, high = 3, mid = 1
        boolean found = false;
        while (low <= high) {
            int mid = low + (high-low) / 2;
            if (target <= matrix[mid][numCols - 1]
                && target >= matrix[mid][0]) {
                    rowTarget = mid;
                    found = true;
                    break;
            } else if (target < matrix[mid][0]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (!found) { return false; }

        // target = 1
        // 0 2 3 4
        // low = 0, high = 1, mid = 1
        low = 0;
        high = numCols - 1;
        while (low <= high) {
            int mid = low + (high-low) / 2;
            if (target == matrix[rowTarget][mid]) {
                return true;
            } else if (target < matrix[rowTarget][mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
