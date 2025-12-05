public class SubarrayProductLessThanK {

//    похоже что че-то на дп. решу сперва через рекурсию

//    public static int numSubarrayProductLessThanK(int[] nums, int k) {
//        int res = 0;
//        for (int i = 0; i < nums.length; i++) {
//            int total = 1;
//            for (int j = i; j < nums.length; j++) {
//                total *= nums[j];
//                if (total >= k) break;
//                res++;
//            }
//        }
//        return res;
//    }

//    beats 11.35% memory 13.18% runtime 851ms
//    я в ахуе что такое брут форс вообще прошел нах)

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0, product = 1;
        int l = 0, r = 0;

        while (r < nums.length) {
            product *= nums[r];

            while (l <= r && product >= k) {
                product /= nums[l];
                l++;
            }

            res += r - l + 1;
            r++;
        }
        return res;
    }

//    beats 99.88% memory 11% runtime 4ms
//    я блять вообще не понимаю почему это говнище работает
//    какого хуя всё так просто в коде (код я с первого раза написал)
//    почему я думал что эта задача решается сложнеее нахуй
//    крч итог только один - ебаный тильт
//    когда блять так решается задача, а ты думал над ней минут 40
//    думал что тут есть какая- то хитрость, а это обычно ебучее слайдинг виндов
//    которое нахуй мне первой мыслью пришло, но я по просту не поверил в это
//    крч идет оно нахуй просто
//    одна из худший задач

    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    }
}
