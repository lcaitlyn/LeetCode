import java.util.Stack;

public class OnlineStockSpan {


    private static class StockSpanner {

        private final Stack<int []> s;


        public StockSpanner() {
            s = new Stack<>();
        }

        public int next(int price) {
            int span = 1;
            while (!s.isEmpty() && s.peek()[0] <= price) {
                span += s.pop()[1];
            }

            s.push(new int[]{price, span});
            return s.peek()[1];
        }
    }

//    runtime 32ms beats 46.81% memory 29.98%

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100)); // return 1
        System.out.println(stockSpanner.next(80));  // return 1
        System.out.println(stockSpanner.next(60));  // return 1
        System.out.println(stockSpanner.next(70));  // return 2
        System.out.println(stockSpanner.next(60));  // return 1
        System.out.println(stockSpanner.next(75));  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
        System.out.println(stockSpanner.next(85));  // return 6
    }
}
