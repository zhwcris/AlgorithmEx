package tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LowestCommonAncestorOfABinaryTree_236 {

    /**
     * 方法1 后续遍历到p和q都表记起来，当p和q都被遍历后，且res.node为空时，判断当前节点是不是p和q的父节点，如果是则此节点就是最近祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        Result res = new Result();
        dfsGetLCA(root, p, q, res);
        return res.node;
    }

    private void dfsGetLCA(TreeNode root, TreeNode p, TreeNode q, Result res) {
        if (root == null || res.node != null) {
            return;
        }
        dfsGetLCA(root.left, p, q, res);
        dfsGetLCA(root.right, p, q, res);
        if (p.val == root.val) {
            res.p = true;
        }
        if (q.val == root.val) {
            res.q = true;
        }
        if (res.p && res.q && res.node == null) {
            if (root.val == p.val || root.val == q.val) {
                if (hasChild(root.left, p, q) || hasChild(root.right, p, q)) {
                    res.node = root;
                }
            } else {
                if (hasChild(root.left, p, q) && hasChild(root.right, p, q)) {
                    res.node = root;
                }
            }
        }
    }

    private static class Result {
        boolean p;
        boolean q;
        TreeNode node;
    }

    private boolean hasChild(TreeNode root, TreeNode target1, TreeNode target2) {
        if (root == null) {
            return false;
        }
        if (root.val == target1.val || root.val == target2.val) {
            return true;
        }
        return hasChild(root.left, target1, target2) || hasChild(root.right, target1, target2);
    }

    /**
     * 判断左右子树是否含有p或者q
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        Result res = new Result();
        dfsInTree(root, p, q, res);
        return res.node;
    }

    private boolean dfsInTree(TreeNode root, TreeNode p, TreeNode q, Result res) {
        if (root == null || res.node != null) {
            return false;
        }
        boolean inCurrentNode = root.val == p.val || root.val == q.val;
        boolean inLeft = dfsInTree(root.left, p, q, res);
        boolean inRight = dfsInTree(root.right, p, q, res);
        if ((inLeft && inRight) || (inCurrentNode && (inLeft || inRight))) {
            res.node = root;
        }
        return inCurrentNode || inLeft || inRight;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<Integer, TreeNode> fatherMap = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        fatherMap.put(root.val, null);
        dfsBuildFMap(root, p, q, fatherMap);
        while (p != null) {
            visited.add(p.val);
            p = fatherMap.get(p.val);
        }
        while (q != null) {
            if (visited.contains(q.val)) return q;
            q = fatherMap.get(q.val);
        }
        return null;
    }

    private boolean pVisted;
    private boolean qVisted;
    private void dfsBuildFMap(TreeNode root, TreeNode p, TreeNode q, Map<Integer, TreeNode> fatherMap) {
        if (pVisted && qVisted) {
            return;
        }
        if (root.left != null) {
            fatherMap.put(root.left.val, root);
            if (root.left.val == p.val) {
                pVisted = true;
            }
            if (root.left.val == q.val) {
                qVisted = true;
            }
            dfsBuildFMap(root.left, p, q, fatherMap);
        }
        if (root.right != null) {
            fatherMap.put(root.right.val, root);
            if (root.right.val == p.val) {
                pVisted = true;
            }
            if (root.right.val == q.val) {
                qVisted = true;
            }
            dfsBuildFMap(root.right, p, q, fatherMap);
        }
    }
}
