class Trie {

    TreeNode root;

    public Trie() {
        root = new TreeNode(null);
    }
    
    public void insert(String word) {
        TreeNode node = root;
        
        for (char c: word.toCharArray()) {
            if (node.map.containsKey(c)) {
                node = node.map.get(c);
            } else {
                TreeNode newNode = new TreeNode(c);
                node.map.put(c, newNode);
                node = newNode;
            }
        }
        node.map.put('-', null);
    }
    
    public boolean search(String word) {
        TreeNode node = root;

        for (char c: word.toCharArray()) {
            if (node.map.containsKey(c)) {
                node = node.map.get(c);
            } else {
                return false;
            }
        }
        if (!node.map.containsKey('-')) {
            return false;
        }

        return true;
    }
    
    public boolean startsWith(String prefix) {
        TreeNode node = root;

        for (char c: prefix.toCharArray()) {
            if (node.map.containsKey(c)) {
                node = node.map.get(c);
            } else {
                return false;
            }
        }

        return true;
    }

    static class TreeNode {
        Character c;
        Map<Character, TreeNode> map;

        public TreeNode(Character c) {
            this.c = c;
            this.map = new HashMap<>();
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */