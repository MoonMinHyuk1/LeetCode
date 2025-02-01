class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();

        Arrays.sort(intervals, (o1, o2) -> ((o1[0] == o2[0]) ? (o1[1] - o2[1]) : (o1[0] - o2[0])));
        int start = intervals[0][0], end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int[] arr = intervals[i];
            if (start <= arr[0] && arr[0] <= end) {
                end = Math.max(end, arr[1]);
            } else {
                list.add(new int[]{start, end});
                start = arr[0];
                end = arr[1];
            }
        }
        list.add(new int[]{start, end});
        int[][] answer = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            int[] arr = list.get(i);
            answer[i][0] = arr[0];
            answer[i][1] = arr[1];
        }

        return answer;
    }
}