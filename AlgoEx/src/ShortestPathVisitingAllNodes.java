import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ShortestPathVisitingAllNodes {
    public int shortestPathLength(int[][] graph) {//bfs
        int N = graph.length, mask = 1, count = 0;
        Set<String> set = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            mask |= (1 << i);
            int[] make = new int[] {(1<<i),i};
            set.add(make[0] + "+" + make[1]);
            q.offer(make);
        }
        while (true) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int[] curr = q.poll();
                if (curr[0] == mask) return count;
                for (int next : graph[curr[1]]) {
                    int nextPath = curr[0] | (1 << next);
                    if (!set.add(nextPath + "+" + next)) continue;
                    q.offer(new int[]{nextPath,next});
                }
            }
            count++;
        }
    }
}

/** c++ version  bfs使用数组代表当前状态  i代表访问到第一个节点， vis二进制数据代表哪些节点访问过了
 *
 * struct State {
 *     int node;
 *     int vis;
 *     int step;
 *
 *     State(int node, int vis, int step):node(node), vis(vis), step(step) {}
 * };
 *
 * class Solution {
 * private:
 * public:
 *     int shortestPathLength(vector<vector<int>>& graph) {
 *         int n = graph.size();
 *
 *         queue<State> q;
 *         vector<vector<bool>> vis(n, vector<bool>(1 << n, false));
 *
 *         for (int i = 0; i < n; ++i) {
 *             q.push(State(i, 1 << i, 0));
 *             vis[i][1 << i] = true;
 *         }
 *
 *         int res = -1;
 *         while (!q.empty()) {
 *             State s = q.front();
 *             q.pop();
 *
 *             if (s.vis == ((1 << n) - 1)) {
 *                 res = s.step;
 *                 break;
 *             }
 *
 *             for (int next : graph[s.node]) {
 *                 int nvis = s.vis | (1 << next);
 *                 if (!vis[next][nvis]) {
 *                     q.push(State(next, nvis, s.step + 1));
 *                     vis[next][nvis] = true;
 *                 }
 *             }
 *         }
 *
 *         return res;
 *     }
 * };
 */
