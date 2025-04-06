class Solution {
    public int trap(int[] height) {
        int answer = 0;
        int lt = 0, rt = height.length - 1;
        int lmax = 0, rmax = 0;

        while (lt < rt) {
            lmax = Math.max(lmax, height[lt]);
            rmax = Math.max(rmax, height[rt]);
            if (lmax < rmax) {
                answer += (lmax - height[lt]);
                lt++;
            } else {
                answer += (rmax - height[rt]);
                rt--;
            }
        }

        return answer;
    }
}