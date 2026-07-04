public class ShortestSubarrayToBeRemovedToMakeArraySorted {

// так ну тут сразу наверное slidingWindow

// как будто хочется идти слева направо и просто считать
// допустим иду я такое
// 1,2,3,10,4,2,3,5
// дошел до 4 и сразу стало невалидным, и хочется левый указатель двигать влево
// но опять же, как и в тех задачках была ошибка, что идти назад как будто не самый лучший вариант.
// Как насчёт вместо того чтобы искать самый... а хотя блять это итак итак ищем же, ищем самый длинный убывающий подмассив.
// Вот только вопрос как его найти нахуй?

// 1,2,3,10,4,2,3,5
//        l
//     m
//                 r

// 5,4,3,2,1
// l
// m
// r

// 1,2,3,10,4,2,3,5,1
//            l
// m
//                  r


// 5 6 1 2 3 4
// l
// m
//     r

// 5 6 7 8 1 2

// 1 8 2 3 4 9

// так вот тут подумал что тут 8 2 3 4 9 пойдет под удаление, а на самом деле, только 1 8. Еще раз подумал и на самом деле тут только 8 не подходит

// окей щас сделаю пример с 3мя горками

// 7 8 9 4 5 6 1 2 3

// бля че то как-то сложновато нахуй

// прикол что его можно удалить залупу только 1 раз нахуй
// че то на slidingWindow мб не похоже. Мб 2 указателя испозотвать? Почему? мы точно знаем что? то что слева будет самое маленькое, а справа самое большое число и будем просто удалять центр мб?

// 7 8 9 1 2 3 4 5 6
//       l
//                 r

// вот щас чуть чуть подумал и решил. Просто кручу лево или правое.
// Так походу придумал че то.
// Смотри. Сперва кручу максимально слева и максимально справа, потом их сравниваю
// и докручиваю меньшую сторону

// 1,2,3,10,4,2,3,5

// Так вот пример, на самом деле даже сранивать не нужно, просто еще подкручивать еще одну сторону и до упора

// public int findLengthOfShortestSubarray(int[] arr) {
//         int res = 0;
//         int l = 0, r = arr.length - 1;

//         int min = l;
//         while (l < arr.length && arr[l] >= arr[min]) {
//             res = Math.max(res, l + 1);
//             min = l;
//             l++;
//         }

//         int max = r;
//         while (r >= 0 && arr[r] <= arr[max]) {
//             res = Math.max(res, arr.length - r);
//             max = r;
//             r--;
//         }

//         if (res == arr.length) return 0;

//         l = 0;
//         while (arr[l] <= arr[max]) {
//             res = Math.max(res, arr.length - max + l + 1);
//             l++;
//         }

//         r = arr.length - 1;
//         while (arr[r] >= arr[min]) {
//             res = Math.max(res, arr.length - r + min + 1);
//             r--;
//         }

//         return arr.length - res;
//     }

// пиздец еле еле сделал эту хуйню и она оказывается не верной

// 1,2,3,10,0,7,8,9

// вот тут всё таки отматывать нахуй назад надо
// блять ну та же хуита как в прошлой (1658), а до меня всё не доходит нахуй

// всё таки наверное slidingWindow, но хз че тут двигать блять. Точнее как держать окно?

// 1,2,4,10,0,7,8,9,1,2,3,4,5,6

// бля крч вообще нихуя не приходит в голову

// использую подсказку:

// The key is to find the longest non-decreasing subarray starting with the first element or ending with the last element, respectively.

// чет нихуя не понятно из этого

// крч крутить обратно мне в падлу я открываю вторую подсказку

// After removing some subarray, the result is the concatenation of a sorted prefix and a sorted suffix, where the last element of the prefix is smaller than the first element of the suffix.

// тоже ничего не стрельнуло в голове.

// БЛЯТЬ Я НЕ ПОНИМАЮ НАХУЙ
// КАКОЙ БРЕД ЕБАНЫЙ. Я ВСЕ ПЫТАЮСЬ РАСКРУТИТЬ ЕГО.
// НО ПРОБЛЕМА В ТОМ ЧТО Я НЕ ЕБУ КАКУЮ СТОРОНУ КРУТИТЬ БЛЯТЬ

// хуета ебаная. пиздец жопа начинает гореть с задачния ебаного нахуй.
// бля гну что такое префикс и суффикс? какой то стек то ли или что нахуй
// что это такое нахуй и как его сделать. вот че блять не понятно
// ахуенно помогли суки
// что я сука должен сделать то? не понимаю нахуй
// мапу? какую мапу тогда? мапу чего?
// может быть мапу суффиксов ИЛИ префиксов? а чего ты решил что число будет совпадать то нахуй?
// тогда что? priorityQueue?
// 1 3 2 4 5

// не бля. просто хз как решить в пизду

// посмотрел решение, вроде код похож на мой. первая часть точно похожа, вторую надо исправлять


//    public static int findLengthOfShortestSubarray(int[] arr) {
//        int res = 0;
//        int l = 0, r = arr.length - 1;
//
//        int min = l;
//        while (l < arr.length && arr[l] >= arr[min]) {
//            res = Math.max(res, l + 1);
//            min = l;
//            l++;
//        }
//
//        int max = r;
//        while (r >= 0 && arr[r] <= arr[max]) {
//            res = Math.max(res, arr.length - r);
//            max = r;
//            r--;
//        }
//
//        if (res == arr.length) return 0;
//
//        l = 0;
//        r = arr.length - 1;
//
//        while (r > 0 && arr[r - 1] <= arr[r] && arr[r] >= arr[l]) {
//            r--;
//        }
//
//        while (l <= r) {
//            while (r < arr.length && arr[l] > arr[r]) {
//                r++;
//            }
//
//            res = Math.max(res, arr.length - r + l + 1);
//
//            if (arr[l] > arr[l + 1]) break;
//            l++;
//        }
//
//        return arr.length - res;
//    }

//    ЕБАТЬ
//    хуйня решилась
//    runtime 3ms beats 19.83% memory 75%
//    осталось только оптимальное решение досмотреть

    public static int findLengthOfShortestSubarray(int[] arr) {
        int res = 0;
        int l = 0, r = arr.length - 1;

        int min = l;
        while (l < arr.length && arr[l] >= arr[min]) {
            res = Math.max(res, l + 1);
            min = l;
            l++;
        }

        int max = r;
        while (r >= 0 && arr[r] <= arr[max]) {
            res = Math.max(res, arr.length - r);
            max = r;
            r--;
        }

        if (res == arr.length) return 0;

        l = 0;
        r++;
        while (l <= r) {
            while (r < arr.length && arr[l] > arr[r]) {
                r++;
            }

            res = Math.max(res, arr.length - r + l + 1);

            if (arr[l] > arr[l + 1]) break;

            l++;
        }

        return arr.length - res;
    }

//    тот же результат, только по меньше кода

    public static void main(String[] args) {
//        System.out.println("3 -> " + findLengthOfShortestSubarray(new int[]{1,2,3,10,4,2,3,5}));
//        System.out.println("3 -> " + findLengthOfShortestSubarray(new int[]{1,3,4,1,4,2,5}));
//        System.out.println("4 -> " + findLengthOfShortestSubarray(new int[]{5, 4, 3, 2, 1}));
//        System.out.println("3 -> " + findLengthOfShortestSubarray(new int[]{5, 4, 3, 1, 2}));
//        System.out.println("2 -> " + findLengthOfShortestSubarray(new int[]{1,2,3,10,0,7,8,9}));
        System.out.println("2 -> " + findLengthOfShortestSubarray(new int[]{1,2,3,3,10,1,3,3,5}));
    }
}
