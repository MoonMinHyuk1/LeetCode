class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0, index = 0, now = 0;

        for (int i = 0; i < gas.length; i++) {
            sum += (gas[i] - cost[i]);
            now += (gas[i] - cost[i]);
            if (now < 0) {
                now = 0;
                index = i + 1;
            }
        }
        if (sum < 0) {
            return -1;
        }

        return index;
    }
}