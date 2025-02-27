class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] course = new boolean[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            graph.get(a).add(b);
            set.add(a);
        }
        for (int i = 0; i < graph.size(); i++) {
            if (!set.contains(i)) {
                course[i] = true;
            }
        }
        for (int i = 0; i < graph.size(); i++) {
            for (int j = 0; j < graph.size(); j++) {
                boolean flag = true;
                for (int num: graph.get(j)) {
                    if (!course[num]) {
                        flag = false;
                        break;
                    }
                }
                course[j] = flag;
            }
        }
        
        for (int i = 0; i < course.length; i++) {
            if (!course[i]) {
                return false;
            }
        }
        return true;
    }
}