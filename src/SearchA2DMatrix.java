public class SearchA2DMatrix {
    
    // private static boolean bs(int [] arr, int target) {
    //     int lo = 0;
    //     int hi = arr.length - 1;
    //     while (lo <= hi) {
    //         int med = (hi - lo) / 2 + lo;
    //         if (arr[med] == target) {
    //             return true;
    //         } else if (target < arr[med]) {
    //             hi = med - 1;
    //         } else {
    //             lo = med + 1;
    //         }
    //     }
    //     return false;
    // }

    // public static boolean searchMatrix(int[][] matrix, int target) {
    //     for (int i = 0; i < matrix.length; i++) {
    //         if (bs(matrix[i], target)) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    // результат: 0ms beats 100%, memory beats 96%
    // Вообще не понял почему такой результат, ведь мой алгорит O(MLogN), а должен быть
    // O(Log(N * M)). 
    // Делал вообще это как тестовое, потому что в searchMatrix должен быть тоже binarySearch

    private static boolean bs(int [] arr, int target) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi) {
            int med = (hi - lo) / 2 + lo;
            if (arr[med] == target) {
                return true;
            } else if (target < arr[med]) {
                hi = med - 1;
            } else {
                lo = med + 1;
            }
        }
        return false;
    }

    // return: -1 if it's lower, 0 if it in array and 1 if it's higher
    private static int findArray(int [] arr, int target) {
        if (target < arr[0]) return -1;
        if (target > arr[arr.length - 1]) return 1;
        return 0;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int lo = 0;
        int hi = matrix.length - 1;
        while (lo <= hi) {
            int med = (hi - lo) / 2 + lo;
            int res = findArray(matrix[med], target);
            if (res == 0) {
                return bs(matrix[med], target);
            } else if (res == -1) {
                hi = med - 1;
            } else {
                lo = med + 1;
            }
        }
        return false;
    }

    // результат runtime 0ms 100%(не удивительно), а вот по памяти beats 18% (лол)
    // но зато тут time complexity должна быть O(Log(N * M))
    // потому что применил BinarySearch к Массиву массивов, а потом к обычному массиву
    // посмотрел решения, там тоже есть что-то интересное с перемножение рядов и столбцов 

    public static void main(String[] args) {
        int [] a = new int[]{1,3,5,7};
        int [] b = new int[]{10,11,16,20};
        int [] c = new int[]{23,30,34,60};

        int [][] matrix = new int[][]{a, b, c};
        System.out.println(searchMatrix(matrix, 16));
    }
}
