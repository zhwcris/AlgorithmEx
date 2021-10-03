package tree;

import java.util.*;

public class SumOfDistancesInTree_834 {


    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        int[] res = new int[n];
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            // [0] = to  [1] = count  [2] = sum
            graph[edges[i][0]].add(new int[]{edges[i][1], 0, 0});
            graph[edges[i][1]].add(new int[]{edges[i][0], 0, 0});
        }
        for (int i = 0; i < n; i++) {
            int[] tmpRes = dfs(i, -1, graph);
            res[i] = tmpRes[1];
        }
        return res;
    }

    //graph每个元素[0] 表示边的终点to，[1]表示count,[2]表示sum
    private int[] dfs(int root, int pre, List<int[]>[] graph) {
        int count = 1;
        int sum = 0;
        for (int[] child : graph[root]) {
            if (pre != child[0]) {
                if (child[1] == 0 && child[2] == 0) { //没有命中缓存
                    int[] res = dfs(child[0], root, graph);
                    child[1] = res[0];
                    child[2] = res[1];
                }
                count += child[1];
                sum += child[1] + child[2];
            }
        }
        return new int[] {count, sum};
    }

    /**
     * 该方法会按有方向的边如1->2这种方式来存储中间结果，防止重复计算，但可能由于中间过程会产生大量的string临时内存,速度较慢
     * @param n
     * @param edges
     * @return
     */
    public int[] sumOfDistancesInTre3(int n, int[][] edges) {
        int[] res = new int[n];
        List<HashSet<Integer>> edgesTree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edgesTree.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            edgesTree.get(edge[0]).add(edge[1]);
            edgesTree.get(edge[1]).add(edge[0]);
        }
        Map<String, int[]> cache = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int[] tmpRes = dfs(i, -1, cache, edgesTree);
            res[i] = tmpRes[1];
        }
        return res;
    }

    private int[] dfs(int root, int pre, Map<String, int[]> cache, List<HashSet<Integer>> graph) {
        int count = 1;
        int sum = 0;
        for (Integer child : graph.get(root)) {
            if (pre != child) {
                String key = root + "->" + child;
                int[] countSum;
                if (cache.containsKey(key)) {
                    countSum = cache.get(key);
                } else {
                    countSum = dfs(child, root, cache, graph);
                }
                count += countSum[0];
                sum += countSum[0] + countSum[1];
            }
        }
        int[] res = new int[] {count, sum};
        cache.put(pre + "->" + root, res);
        return res;
    }

    /**
     * 暴力求解，对所有节点对应的树都求一次sum of distances in tree
     * @param n
     * @param edges
     * @return
     */
    public int[] sumOfDistancesInTre4(int n, int[][] edges) {
        int[] res = new int[n];
        List<HashSet<Integer>> edgesTree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edgesTree.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            edgesTree.get(edge[0]).add(edge[1]);
            edgesTree.get(edge[1]).add(edge[0]);
        }
        for (int i = 0; i < n; i++) {
            dfs(i, n, -1, edgesTree, 0);
            res[i] = count;
            count = 0;
        }
        return res;
    }

    int count;
    private void dfs(int k, int n, int pre, List<HashSet<Integer>> edgesTree, int level) {
        for (int i = 0; i < n; i++) {
            if (i != pre && edgesTree.get(k).contains(i)) {
                count += level + 1;
                dfs(i, n, k, edgesTree, level + 1);
            }
        }
    }
}
