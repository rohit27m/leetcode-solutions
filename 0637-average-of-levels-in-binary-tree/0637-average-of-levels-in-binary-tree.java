class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null)
        {
            res.add(0.000);
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty())
        {
            int size = q.size();
            int k = size;
            double curSum = 0.0;
            while (k-- > 0)
            {
                TreeNode cur = q.poll();
                curSum = curSum + cur.val;
                if (cur.left != null)
                    q.offer(cur.left);
                if (cur.right != null)
                    q.offer(cur.right);
            }
            res.add(curSum/(size*1.0));
        }

        return res;
    }
}