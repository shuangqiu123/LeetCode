class LRUCache {
    LinkedHashMap<Integer, Integer> cache;
    int maxCapacity = 0;
    int currentCapacity = 0;
    
    public LRUCache(int capacity) {
        cache = new LinkedHashMap<>();
        maxCapacity = capacity;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        int value = cache.get(key);
        cache.remove(key);
        cache.put(key, value);
        
        return value;
    }
    
    public void put(int key, int value) {
        
        if (cache.containsKey(key)) {
            cache.put(key, value);
            get(key);
            return;
        }
        
        if (currentCapacity == maxCapacity) {
            cache.remove(cache.keySet().iterator().next());
        }
        else {
            currentCapacity++;
        }
        cache.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */