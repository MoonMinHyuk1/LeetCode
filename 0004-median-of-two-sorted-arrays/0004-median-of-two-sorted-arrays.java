class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double answer = 0;
        int size = nums1.length + nums2.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int num: nums1) {
            pq.offer(num);
        }
        for (int num: nums2) {
            pq.offer(num);
        }
        if (size % 2 == 0) {
            for (int i = 0; i < (size / 2) - 1; i++) {
                pq.poll();
            }
            answer = (pq.poll() + pq.poll()) / 2.0;
        }
        else {
            for (int i = 0; i < (size / 2); i++) {
                pq.poll();
            }
            answer = pq.poll();
        }

        return answer;
    }
}