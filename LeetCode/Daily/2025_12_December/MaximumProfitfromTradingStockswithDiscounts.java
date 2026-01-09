import java.util.*;

class MaximumProfitfromTradingStockswithDiscounts {

    void DFS(
        int u,
        int[] present,
        int[] future,
        Map<Integer, List<Integer>> adj,
        int[][][] statesProfit,
        int budget
    ) {

        // childrenStatesProfit:
        // first  -> child profit if parent NOT bought
        // second -> child profit if parent IS bought
        List<int[][]> childrenStatesProfit = new ArrayList<>();

        // Process children first
        for (int v : adj.getOrDefault(u, new ArrayList<>())) {
            DFS(v, present, future, adj, statesProfit, budget);
            childrenStatesProfit.add(new int[][] {
                statesProfit[v][0],
                statesProfit[v][1]
            });
        }

        // parentBought = 0 or 1
        for (int parentBought = 0; parentBought <= 1; parentBought++) {

            int price  = (parentBought == 1) ? present[u] / 2 : present[u];
            int profit = future[u] - price;

            int[] bestProfitAtU = new int[budget + 1];

            // ---------------- Case 1: Do NOT buy node u ----------------
            int[] childrenProfitIfUNotBought = new int[budget + 1];

            for (int[][] child : childrenStatesProfit) {
                int[] childNotBought = child[0];
                int[] temp = new int[budget + 1];

                for (int used = 0; used <= budget; used++) {
                    for (int take = 0; used + take <= budget; take++) {
                        temp[used + take] = Math.max(
                            temp[used + take],
                            childrenProfitIfUNotBought[used] + childNotBought[take]
                        );
                    }
                }
                childrenProfitIfUNotBought = temp;
            }

            for (int b = 0; b <= budget; b++) {
                bestProfitAtU[b] = Math.max(bestProfitAtU[b], childrenProfitIfUNotBought[b]);
            }

            // ---------------- Case 2: Buy node u ----------------
            if (price <= budget) {
                int[] childrenProfitIfUBought = new int[budget + 1];

                for (int[][] child : childrenStatesProfit) {
                    int[] childBought = child[1];
                    int[] temp = new int[budget + 1];

                    for (int used = 0; used <= budget; used++) {
                        for (int take = 0; used + take <= budget; take++) {
                            temp[used + take] = Math.max(
                                temp[used + take],
                                childrenProfitIfUBought[used] + childBought[take]
                            );
                        }
                    }
                    childrenProfitIfUBought = temp;
                }

                for (int b = price; b <= budget; b++) {
                    bestProfitAtU[b] = Math.max(
                        bestProfitAtU[b],
                        childrenProfitIfUBought[b - price] + profit
                    );
                }
            }

            statesProfit[u][parentBought] = bestProfitAtU;
        }
    }

    public int maxProfit(
        int n,
        int[] present,
        int[] future,
        int[][] hierarchy,
        int budget
    ) {

        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] h : hierarchy) {
            int u = h[0] - 1;
            int v = h[1] - 1;
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        }

        // statesProfit[u][0][b] = profit at u if parent NOT bought
        // statesProfit[u][1][b] = profit at u if parent BOUGHT
        int[][][] statesProfit = new int[n][2][budget + 1];

        DFS(0, present, future, adj, statesProfit, budget);

        int ans = 0;
        for (int b = 0; b <= budget; b++) {
            ans = Math.max(ans, statesProfit[0][0][b]);
        }
        return ans;
    }
}
