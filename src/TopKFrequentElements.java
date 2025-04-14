import java.util.*;

public class TopKFrequentElements {

    // Долго думал на этой задачей (минут 15 так). Думал посчитать каждый символ
    // и уже от него отталкиваться, но все не могу придумать реализацию этого метода
    // код я не писал, а только лишь думал. И все думал над подсказкой про O(n log n)
    // это явно должна была быть сортировка.
    // Спустя время я подумал, а как найти одно число часто встречающиеся, и потом вспомнил
    // что такую задачу я уже решал. Эта задача MajorityElement
    // и до меня дошло, что все что нужно сделать так это сделать MajorityElement, просто
    // некоторое количество раз, а точнее K раз

    // аухаух думал что я прозрел, но не нет. там условия были другие. сука :( 


    // private static int getMajorityElement(Map<Integer, Integer> map) {
    //     int max = 0;
    //     int res = -1;
    //     for (Integer i : map.keySet()) {
    //         if (map.get(i) > max) {
    //             max = map.get(i);
    //             res = i;
    //         }
    //     }
    //     return res;
    // }

    // public static int[] topKFrequent(int[] nums, int k) {
    //     Map<Integer, Integer> map = new HashMap<>();

    //     for (int i = 0; i < nums.length; i++) {
    //         map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    //     }
        
    //     int[] arr = new int[k];
    //     for (int i = 0; i < k; i++) {
    //         int a = getMajorityElement(map);
    //         map.remove(a);
    //         arr[i] = a;
    //     }

    //     return arr;
    // }


    // Резульат: 57 ms Beats 5.14%. Фигово че, но это был перебор так что так и должно быть
    // Осталось придумать как сделать time complexity O(log n), а не O(n)


    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer>[] list = new ArrayList[nums.length + 1];
        for (Integer i : map.keySet()) {
            int val = map.get(i);
            if (list[val] == null) {
                list[val] = new ArrayList<>();
            }
            list[val].add(i);
        }

        int[] res = new int[k];
        int i = list.length - 1;
        int j = 0;
        while (j < k) {
            if (list[i] != null) {
                for (Integer v : list[i]) {
                    res[j] = v;
                    j++;
                }
            }
            i--;
        }

        return res;
    }

    // runtime 11ms beats 92%. решение посмотрел в инете, и реализовал свой

    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }
}
