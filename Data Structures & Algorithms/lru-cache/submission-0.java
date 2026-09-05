

class LRUCache {

    class Pair {
        int key;
        int value;

        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int n;
    ArrayList<Pair> cache;

    public LRUCache(int capacity) {
        n = capacity;
        cache = new ArrayList<>();
    }

    public int get(int key) {

        for (int i = 0; i < cache.size(); i++) {

            if (cache.get(i).key == key) {

                int val = cache.get(i).value;

                // Save the pair
                Pair temp = cache.get(i);

                // Remove it from its old position
                cache.remove(i);

                // Put it at the back = most recently used
                cache.add(temp);

                return val;
            }
        }

        return -1;
    }

    public void put(int key, int value) {

        for (int i = 0; i < cache.size(); i++) {

            if (cache.get(i).key == key) {

                // Remove old key-value pair
                cache.remove(i);

                // Add updated pair at the back
                cache.add(new Pair(key, value));

                return;
            }
        }

        // If cache is full
        if (cache.size() == n) {
            cache.remove(0);
        }

        // Add new pair at the back
        cache.add(new Pair(key, value));
    }
}