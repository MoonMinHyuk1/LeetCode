class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[3] - o2[3]));

        for (int i = 0; i < nums1.length; i++) {
            pq.offer(new int[]{nums1[i], nums2[0], 0, nums1[i] + nums2[0]});
        }
        while (k-- > 0) {
            int[] arr = pq.poll();
            answer.add(List.of(arr[0], arr[1]));
            if (arr[2] == nums2.length - 1) continue;
            pq.offer(new int[]{arr[0], nums2[arr[2] + 1], arr[2] + 1, arr[0] + nums2[arr[2] + 1]});
        }

        return answer;
    }
}