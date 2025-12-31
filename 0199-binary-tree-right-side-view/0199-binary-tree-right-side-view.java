class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            int lastVal = 0;
            for(int i = 0; i< size;i++){
                TreeNode node = queue.poll();
                lastVal = node.val;
                if(node.left!= null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            res.add(lastVal);
        }
        return res;
    }
}