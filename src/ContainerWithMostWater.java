public class ContainerWithMostWater {
    
    // Очень интересная задачка, не могу ничего сообразить. Хоть и задача на 2 указателя,
    // то это уже микроподсказка, но все же нет. Скорее всего начну с простого решения - брутфорса

    // public static int maxArea(int[] height) {
    //     int s = 0;
    //     for (int i = 0; i < height.length; i++) {
    //         for (int j = i + 1; j < height.length; j++) {
    //             int h = Math.min(height[i], height[j]);
    //             int l = j - i;
    //             s = Math.max(h * l, s);
    //         }
    //     }

    //     return s;
    // }

    // Так ну решение вроде работает, но при сабмите мы уперлись в Time Limit Exceeded
    // Так что думаем что можно сделать дальше

    // Взял вторую подсказку: 
    // Try to use two-pointers. Set one pointer to the left and one to the right of the array. Always move the pointer that points to the lower line.
    // "Попробуйте использовать два указателя. Установите один указатель
    //  в левой и один в правой части массива. Всегда перемещайте указатель,
    // указывающий на нижнюю строку.
    // В принципе я в эту сторону начинал думать, но что-то не додумался. Думаю стоит еще подумать
    // Мб даже оставлю это на завтра

    // Case : 1 2 3 4 (крч возврастание как тут будет работать надо продумать)


    // public static int maxArea(int[] height) {
    //     int max = 0;
    //     int left = 0;
    //     int right = height.length - 1;

    //     while (left < right) {
    //         int h = Math.min(height[left], height[right]);
    //         int w = right - left;
    //         int sq = h * w;

    //         max = Math.max(sq, max);
    //         if (h == height[left]) {
    //             left++;
    //         } else {
    //             right--;
    //         }
    //     }

    //     return max;
    // }

    // Runtime 5ms beats 74.7% memory 15%
    // Ну хоть решил, но думаю если скипать какие-то очевидные значения, то можно добится
    // быстрее результата

    public static int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        int ph = Math.min(height[left], height[right]); // previus min height

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            if (h >= ph) {
                int w = right - left;
                int sq = h * w;

                max = Math.max(sq, max);
                ph = h;
            }
            if (h == height[left]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }

    // Runtime 4ms beats 90%
    // бля вообще так то изи было, хз че я мозги ебал себе. По сути ведь я знал решение
    // но почему то не верил себе
    
    public static void main(String[] args) {
        int res = maxArea(new int[]{1,8,6,2,5,4,8,3,7});
        System.out.println(res);
    }
}
