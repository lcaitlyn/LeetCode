public class Program {

    public static void main(String[] args) {
//        {
//            LRUCache lruCache = new LRUCache(2);
//
//            lruCache.put(1, 1);
//            lruCache.put(2, 2);
//            System.out.println(lruCache.get(1));
//            lruCache.put(3, 3);
//            System.out.println(lruCache.get(2));
//            lruCache.put(4, 4);
//            System.out.println(lruCache.get(1));
//            System.out.println(lruCache.get(3));
//            System.out.println(lruCache.get(4));
//        }

//        {
//            LRUCache lruCache = new LRUCache(2);
//
//            System.out.println(lruCache.get(3));
//            lruCache.put(1, 1);
//            lruCache.put(2, 2);
//            lruCache.put(4, 4);
//            System.out.println(lruCache.get(1));
//        }

        {
            LRUCache lruCache = new LRUCache(1);

            System.out.println(lruCache.get(6));
            System.out.println(lruCache.get(8));
            lruCache.put(12, 1);
            System.out.println(lruCache.get(2));
            lruCache.put(15, 11);
            lruCache.put(5, 2);
            lruCache.put(1, 15);
            lruCache.put(4, 2);
            System.out.println(lruCache.get(5));
            lruCache.put(15, 15);
        }
    }
}
