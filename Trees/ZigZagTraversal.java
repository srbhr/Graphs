import java.util.*;

class ZigZagTraversal {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> que = new ArrayDeque<>(Arrays.asList(root));
        boolean isLeftToRight = true;

        while (!que.isEmpty()) {
            List<Integer> currLevel = new ArrayList<>();
            for (int sz = que.size(); sz > 0; --sz)
                if (isLeftToRight) {
                    TreeNode node = que.pollFirst();
                    currLevel.add(node.val);
                    if (node.left != null)
                        que.addLast(node.left);
                    if (node.right != null)
                        que.addLast(node.right);
                } else {
                    TreeNode node = que.pollLast();
                    currLevel.add(node.val);
                    if (node.right != null)
                        que.addFirst(node.right);
                    if (node.left != null)
                        que.addFirst(node.left);
                }
            ans.add(currLevel);
            isLeftToRight = !isLeftToRight;
        }

        return ans;
    }
}