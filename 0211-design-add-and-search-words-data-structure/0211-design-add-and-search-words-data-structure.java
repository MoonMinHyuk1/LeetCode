class WordDictionary {

    Node root;

    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node node = root;

        for (char c: word.toCharArray()) {
            if (node.map.containsKey(c)) {
                node = node.map.get(c);
            } else {
                Node newNode = new Node(c);
                node.map.put(c, newNode);
                node = newNode;
            }
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        Queue<Node> queue = new LinkedList<>();
        int index = 0;

        queue.offer(root);
        while (!queue.isEmpty()) {
            if (index >= word.length()) {
                break;
            }
            int size = queue.size();
            char c = word.charAt(index++);
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                Map<Character, Node> map = node.map;
                if (c == '.') {
                    for (Node next: map.values()) {
                        queue.offer(next);
                        if (index == word.length() && next.isEnd) {
                            return true;
                        }
                    }
                } else {
                    if (map.containsKey(c)) {
                        queue.offer(map.get(c));
                        if (index == word.length() && map.get(c).isEnd) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    static class Node {
        Character c;
        Map<Character, Node> map;
        boolean isEnd;

        public Node() {
            this.map = new HashMap<>();
            this.isEnd = false;
        }

        public Node(Character c) {
            this.c = c;
            this.map = new HashMap<>();
            this.isEnd = false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */