import java.util.*;

public class Main {
    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();
        
        for(int i = 1; i<=cases; i++){
            
            if(i == 1){
                System.out.println("Case " + i + ":");
            }else{
                System.out.println("");
                System.out.println("\nCase " + i + ":");
            }
            
            
            int nodes = sc.nextInt();
            
            Tree tree = new Tree();
            
            for(int j = 0; j < nodes; j++){
                
                int nodeValue = sc.nextInt();
                
                Node node = new Node(nodeValue);
                
                tree.insert(node);
                
            }
            
            Queue<Node> q = new LinkedList<Node>();
            
            q.offer(tree.root);
            
            while(q.peek() != null){
                
                Node currNode = q.poll();
                
                if(currNode == tree.root){
                    System.out.print(currNode.value);
                }else{
                    System.out.print(" " + currNode.value);
                }
                
                
                if(currNode.left != null){
                    q.offer(currNode.left);
                }
                if(currNode.right != null){
                    q.offer(currNode.right);
                }
                
            }
            
            
        }
        
        System.out.println();
        System.out.println();
            
        
    }
    
    public static class Tree{
        
        Node root;
        
        public Tree(){
            this.root = null;
        }
        
        public void insert(Node node){
            if(root == null){
                root = node;
                return;
            }else{
                Node currNode = root;
                Node nextNode = root;
                while(nextNode != null){
                    currNode = nextNode;
                    if(node.value > currNode.value){
                        nextNode = currNode.right;
                    }else{
                        nextNode = currNode.left;
                    }
                }
                
                if(node.value > currNode.value){
                    currNode.right = node;
                }else{
                    currNode.left = node;
                }
                
            }
            
            return;
        }
        
    }
    
    public static class Node {
        int value;
        Node left;
        Node right;
        
        public Node(int value){
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    
}
