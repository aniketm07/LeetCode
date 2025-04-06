class ListNode { 
    int val;
    int key;
    ListNode next;
    ListNode prev;

    public ListNode(int key, int val){
        this.key = key;
        this.val = val;
        next = null;
        prev = null;
    }
}

class LRUCache {
    Map<Integer, ListNode> map;
    ListNode head;
    ListNode tail;
    int capacity = -1;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            ListNode node = map.get(key);
            reArrangeCache(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            ListNode node = map.get(key);
            node.val = value;
            reArrangeCache(node);
        }else{
            ListNode node = new ListNode(key, value);
            if(map.size() >= capacity){
                ListNode toBeDeleted = tail.prev;
                removeNode(toBeDeleted);
                map.remove(toBeDeleted.key);
            }
            map.put(node.key, node);
            addNode(node);
        }
    }

    public void addNode(ListNode node){
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    public void removeNode(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void reArrangeCache(ListNode node) {
        removeNode(node);
        addNode(node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */