class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> answer = new ArrayList<>();
        List<int[]> list = new ArrayList<>();

        for (int[] arr: intervals) {
            list.add(arr);
        }
        list.add(newInterval);
        Collections.sort(list, (o1, o2) -> ((o1[0] == o2[0]) ? (o1[1] - o2[1]) : (o1[0] - o2[0])));
        for (int i = 0; i < list.size(); i++) {
            int[] now = list.get(i);
            int s = now[0], e = now[1];
            for (int j = i + 1; j < list.size(); j++) {
                int[] next = list.get(j);
                if (next[0] <= e) {
                    if (next[1] > e) {
                        e = next[1];
                    }
                    i = j;
                }
            }
            answer.add(new int[]{s, e});
        }
        
        return answer.stream().toArray(int[][]::new);
    }
}