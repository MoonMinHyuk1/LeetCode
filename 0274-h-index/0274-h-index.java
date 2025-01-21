class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for (int i = citations[citations.length - 1]; i >= 0; i--) {
            int index = findIndex(citations, i);
            if (i <= citations.length - index) {
                return i;
            }
        }

        return 1;
    }

    private int findIndex(int[] arr, int n) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= n) {
                return i;
            }
        }

        return arr.length - 1;
    }
}