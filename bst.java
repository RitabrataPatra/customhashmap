
class TreeNode{
    int root;
    TreeNode left;
    TreeNode right;
        TreeNode(int root){
            this.root =root;
            this.left =null;
            this.right = null;
        }

    void BST(int uservalue){
        if (uservalue >= root) {
            if (this.right == null) {
                this.right = new TreeNode(uservalue);
                System.out.println(uservalue + " added to the right of "+ root);
            }  
            else{
            this.right.BST(uservalue); // rescusion kore check krchi je right e kono node er jonno jaiga faka ache kina
            } 
        }
        else{
            if (this.left == null) {
                this.left = new TreeNode(uservalue);
                System.out.println(uservalue + " added to the left of "+ root);
            }
            else{
                this.left.BST(uservalue);
            }
        }
        
    }
}
class bst{
    public static void main(String[] args) {
        TreeNode bst = new TreeNode(10);
        bst.BST(20);
        bst.BST(35);
        bst.BST(3);
        bst.BST(11);

        //Output :
        // 20 added to the right of 10
        // 35 added to the right of 20
        // 3 added to the left of 10
        // 11 added to the left of 20
    }
}