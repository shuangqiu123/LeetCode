// leetcode 138
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
        if (head == null) {
            return null;
        }
        
        Map<Node, Node> map = new HashMap<>();
        Node ptr = head;
        Node nodeHead = new Node(-1);
        Node node = nodeHead;

        while (ptr != null) {
            node.next = constructNodeNext(ptr, map);
            node = node.next;
            constructNodeRandom(ptr, node, map);
            ptr = ptr.next;
        }
        return nodeHead.next;
    }
    
    private Node constructNodeNext(Node ptr, Map<Node, Node> map) {
        if (ptr == null) {
            return null;
        }
        if (map.containsKey(ptr)) {
            return map.get(ptr);
        }
        Node nodeNext = new Node(ptr.val);
        map.put(ptr, nodeNext);
        return nodeNext;
    }
    
    private void constructNodeRandom(Node ptr, Node node, Map<Node, Node> map) {
        Node randomNode = ptr.random;
        if (randomNode == null) {
            node.random = null;
            return;
        }
        if (map.containsKey(randomNode)) {
            node.random = map.get(randomNode);
            return;
        }
        Node newRandomNode = new Node(randomNode.val);
        node.random = newRandomNode;
        map.put(randomNode, newRandomNode);
    }
}

/*
   map: {
    oldNode : new Node
   }
   val = node.val
   next = new Node()
   random = new Node()
*/