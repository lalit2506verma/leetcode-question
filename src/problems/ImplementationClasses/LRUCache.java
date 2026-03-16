package problems.ImplementationClasses;

import problems.Node.Node;

import java.util.HashMap;

public class LRUCache {
    Node root;
    int size;
    HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        size = capacity;
        root = new Node();
        map = new HashMap<>();
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            return node.val[1];
        }
        else{
            return -1;
        }
    }

    public void put(int key, int value) {
        // if map already contain the key - updated the value
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val[1] = value;
        }
        else{
            // if capacity is full
            if(map.size() == size){
                // remove the first element from DLL
                Node node = root;
                root = root.next;
                map.remove(node.val[0]);

                // add the Node add the end and in the map
                Node temp = new Node();
            }
        }
    }
}

