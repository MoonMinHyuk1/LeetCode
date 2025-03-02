class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        if (startGene.equals(endGene)) {
            return 0;
        }
        if (startGene.length() != endGene.length()) {
            return -1;
        }
        int answer = -1;
        boolean flag = false;
        boolean[] visited = new boolean[bank.length];
        Queue<String> queue = new LinkedList<>();

        queue.offer(startGene);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String a = queue.poll();
                if (a.equals(endGene)) {
                    flag = true;
                    queue.clear();
                    break;
                }
                for (int j = 0; j < bank.length; j++) {
                    if (!visited[j] && checkOne(a, bank[j])) {
                        visited[j] = true;
                        queue.offer(bank[j]);
                    }
                }
            }
            answer++;
        }

        return flag ? answer : -1;
    }

    private boolean checkOne(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        int cnt = 0;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                cnt++;
            }
            if (cnt > 1) {
                return false;
            }
        }

        return (cnt == 1) ? true : false;
    }
}