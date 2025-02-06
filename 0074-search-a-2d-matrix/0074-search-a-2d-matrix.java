class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix[0][0] > target || matrix[matrix.length - 1][matrix[0].length - 1] < target) {
            return false;
        }
        int row = findRow(matrix, target);
        if (matrix[row][0] == target) {
            return true;
        }
        return findColumn(matrix[row], target);
    }

    private int findRow(int[][] matrix, int target) {
        int lt = 0, rt = matrix.length - 1;

        while (lt < rt) {
            int mid = (lt + rt) / 2;
            if (matrix[mid][0] == target) {
                return mid;
            } else if (matrix[mid][0] > target) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        if (matrix[lt][0] > target) {
            return lt - 1;
        }

        return lt;
    }

    private boolean findColumn(int[] arr, int target) {
        int lt = 0, rt = arr.length - 1;

        while (lt < rt) {
            int mid = (lt + rt) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] > target) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        if (arr[lt] == target) {
            return true;
        }

        return false;
    }
}