package tree;

public class HouseRobberIII_337 {

    public int rob(TreeNode root) {
        int[] res = dfsRob(root);
        return Math.max(res[0], res[1]);
    }

    /**
     * f(root)代表在盗取root节点时能获得的钱
     * fn(root)代表不到去root节点时能获取的钱数
     * 在root节点获取的最大钱数是Max(f(root),fn(root))
     * f(root) = fn(root.left) + fn(root.right) + root.val
     * fn(root) = Max(f(root.left), fn(root.left)) + Max(f(root.right), fn(root.right))
     * @param root
     * @return
     */
    private int[] dfsRob(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] left = dfsRob(root.left);
        int[] right = dfsRob(root.right);
        int[] res = new int[2];
        res[0] = left[1] + right[1] + root.val;
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return res;
    }


}
