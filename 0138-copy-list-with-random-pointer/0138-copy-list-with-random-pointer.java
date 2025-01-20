/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node answer = new Node(1);
        Node node = answer;
        Map<Node, Integer> index = new HashMap<>();
        Map<Integer, Integer> randomIndex = new HashMap<>();
        Map<Integer, Node> copyIndex = new HashMap<>();
        int i = 0;

        Node now = head;
        while (now != null) {
            index.put(now, i);
            node.next = new Node(now.val);
            node = node.next;
            copyIndex.put(i++, node);
            now = now.next;
        }
        now = head;
        while (now != null) {
            if (now.random != null) {
                randomIndex.put(index.get(now), index.get(now.random));
            }
            now = now.next;
        }
        for (int key: randomIndex.keySet()) {
            int value = randomIndex.get(key);
            copyIndex.get(key).random = copyIndex.get(value);
        }

        return answer.next;
    }
}