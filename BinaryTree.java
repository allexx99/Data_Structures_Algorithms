import java.util.LinkedList;  
import java.util.Queue;  

public class BinaryTree {
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public Node root;

    public BinaryTree() {
        this.root = null;
    }

    // difference() will calculate the difference between sum of odd and even levels of binary tree  
    public int difference() {
        int oddLevel = 0, evenLevel = 0, diffOddEven = 0;

        // variable nodesInLevel keep tracks of number of nodes in each level  
        int nodesInLevel = 0;

        // variable currentLevel keep track of level in binary tree  
        int currentLevel = 0;

        // queue will be used to keep track of nodes of tree level-wise 
        Queue<Node> queue = new LinkedList<Node>();

        // Check if root is null
        if(root == null) {
            System.out.println("Tree is empty");
            return 0;
        } else {
            // add root to queue as it represents the first level
            queue.add(root);
            currentLevel++;

            while(queue.size() != 0) {
                // variable nodesInLevel will hold the size of queue
                nodesInLevel = queue.size();

                while (nodesInLevel > 0) {
                    // removes the node at the front of the queue
                    Node current = queue.remove();

                    // check if current level is even or not
                    if(currentLevel % 2 == 0) {
                        // if level is even, add nodes to variable evenLevel
                        evenLevel += current.data;
                    } else {
                        oddLevel += current.data;
                    }

                    if(current.left != null) {
                        queue.add(current.left);
                    }
                    if(current.right != null) {
                        queue.add(current.right);
                    }
                    nodesInLevel--;
                }
                currentLevel++;
            }
            // calculate the difference between oddLevel and evenLevel
            diffOddEven = Math.abs(oddLevel - evenLevel);
        }
        return diffOddEven;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();

        // add nodes to the binary tree
        bt.root = new Node(1);
        bt.root.left = new Node(2);
        bt.root.right = new Node(3);  
        bt.root.left.left = new Node(4);  
        bt.root.right.left = new Node(5);  
        bt.root.right.right = new Node(6);  

        // difference between odd and even levels sums
        System.out.println("Difference: " + bt.difference());
    }
}