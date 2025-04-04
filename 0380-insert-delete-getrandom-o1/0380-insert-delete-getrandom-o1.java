class RandomizedSet {

    private Set<Integer> set;

    public RandomizedSet() {
        set = new TreeSet<>();
    }
    
    public boolean insert(int val) {
        if (set.contains(val)) {
            return false;
        }
        set.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (!set.contains(val)) {
            return false;
        }
        set.remove(val);
        return true;
    }
    
    public int getRandom() {
        Random random = new Random();
        int index = random.nextInt(set.size());
        int i = 0;
        for (int n: set) {
            if (i++ == index) {
                return n;
            }
        }
        return 0;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */