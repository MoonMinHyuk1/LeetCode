class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        boolean[] visited = new boolean[nums.length];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[0] - o2[0]));

        pq.offer(new int[]{0, 0});
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int index = now[0];
            int jump = now[1];
            for (int i = index + 1; i <= index + nums[index]; i++) {
                if (i == nums.length - 1) {
                    return jump + 1;
                }
                if (visited[i]) continue;
                visited[i] = true;
                pq.offer(new int[]{i, jump + 1});
            }
        }

        return 0;
    }
}