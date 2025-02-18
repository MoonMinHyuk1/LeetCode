class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] answer = new double[queries.size()];
        Map<String, Map<String, Double>> map = new HashMap<>();
        
        for (int i = 0; i < equations.size(); i++) {
            List<String> list = equations.get(i);
            String a = list.get(0), b = list.get(1);
            double value = values[i];
            map.putIfAbsent(a, new HashMap<>());
            map.putIfAbsent(b, new HashMap<>());
            map.get(a).put(b, value);
            map.get(b).put(a, 1 / value);
        }
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String a = query.get(0), b = query.get(1);
            if (map.containsKey(a) && a.equals(b)) {
                answer[i] = 1.0;
            } else {
                answer[i] = calculate(map, a, b, new HashSet<>());
            }
        }

        return answer;
    }

    public double calculate(Map<String, Map<String, Double>> map, String a, String b, Set<String> set) {
        if (!map.containsKey(a)) {
            return -1;
        }
        set.add(a);
        for (String s: map.get(a).keySet()) {
            if (s.equals(b)) {
                return map.get(a).get(b);
            } else {
                if (!set.contains(s)) {
                    double result = calculate(map, s, b, set);
                    if (result != -1) {
                        return result * map.get(a).get(s);
                    }
                }
            }
        }
        
        return -1;
    }
}