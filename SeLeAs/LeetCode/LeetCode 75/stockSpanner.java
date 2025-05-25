import java.util.Stack;

class StockSpanner {

    private Stack<int[]> prices;

    public StockSpanner() {
        prices = new Stack<>();
    }

    public int next(int price) {
        int span = 1;
        while (!prices.isEmpty() && prices.peek()[0] <= price) {
            int[] top = prices.pop();
            span += top[1];
        }
        prices.push(new int[]{price, span});
        return span;
    }
}
