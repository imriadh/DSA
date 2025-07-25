package datastructures.binarysearchtree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
     Node root;
    class Node{
        int value;
        Node left;
        Node right;
        
        public Node(int value){
            this.value = value;
            left=right=null;
        }                                                                        
    }
    //Recursive Insert
    private Node rInsert(Node currentNode,int value){
        if(currentNode == null) return new Node(value);
        if(value < currentNode.value){
            currentNode.left = rInsert(currentNode.left, value);
        }else if(value > currentNode.value){
            currentNode.right = rInsert(currentNode.right, value);
        }
        return currentNode;
    }
    public void rInsert(int value){
        if(root==null) root = new Node(value);
        rInsert(root,value);
    }

    //Non-Recursive
    public boolean insert(int value){
        Node newNode = new Node(value);
        if(root==null){
            root =newNode;
            return true;
        }
        Node temp = root;
        while(true){
            if(newNode.value==temp.value) return false;
            if(newNode.value<temp.value){
                if(temp.left==null){
                    temp.left=newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if(temp.right==null){
                    temp.right=newNode;
                    return true;
                }
                temp = temp.right;
            }
            
        }
    }
    
    //Rucursive Contains
    private boolean rContains(Node currentNode, int value){
        if(currentNode == null) return false;
        if(currentNode.value == value) return true;
        if(value<currentNode.value){
            return rContains(currentNode.left, value);
        }
        else{
            return rContains(currentNode.right, value);
        }
    }
    public boolean rContains(int value){
        return rContains(root,value);
    }
    //Non-Recursive 
    public boolean contains(int value){
        if(root==null) return false;
        Node temp = root;
        while(temp!=null){
            if(value<temp.value){
                temp = temp.left;
            }
            else if(value>temp.value){
                temp = temp.right;
            }
            else{
                return true;
            }
        }
        return false;
    }
    // Minimum value of Node
    public int minValue(Node currentNode){
        while (currentNode.left !=null) {
            currentNode = currentNode.left;
            
        }
        return currentNode.value;
    }
    // Maximum value of Node
    public int  maxValue(Node currentNode){
        while (currentNode.right !=null) {
            currentNode = currentNode.right;
            
        }
        return currentNode.value;
    }
    
    // Convenience methods for min/max without passing node
    public int minValue(){
        if(root == null) throw new RuntimeException("Tree is empty");
        return minValue(root);
    }
    
    public int maxValue(){
        if(root == null) throw new RuntimeException("Tree is empty");
        return maxValue(root);
    }
    //Delete Node
    private Node deleteNode(Node currentNode, int value){
        if(currentNode==null) return null;
        if(value < currentNode.value){
            currentNode.left = deleteNode(currentNode.left, value);
        }
        else if(value> currentNode.value){
            currentNode.right = deleteNode(currentNode.right, value);
        }
        else{
            if(currentNode.left ==null && currentNode.right==null){
                currentNode = null;
            }
            else if (currentNode.left == null){
                currentNode = currentNode.right;
            }
            else if (currentNode.right == null){
                currentNode = currentNode.left;
            }
            else{
                int subTreeMin = minValue(currentNode.right);
                currentNode.value = subTreeMin;
                currentNode.right = deleteNode(currentNode.right, subTreeMin);
            }
        }
        return currentNode;

    }
    public void deleteNode(int value){
        deleteNode(root,value);
    }

    //BFS 
    public ArrayList<Integer> BFS (){
        Node currentNode = root;
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> results = new ArrayList<>();
        queue.add(currentNode);
       
        while (!queue.isEmpty()) {
            currentNode = queue.remove();
            results.add(currentNode.value);
            if(currentNode.left != null){
                queue.add(currentNode.left);
            }
            if(currentNode.right != null){
                queue.add(currentNode.right);
            }
        }
        return results;
    }

    //DFS
    public ArrayList<Integer> DFS() {
        ArrayList<Integer> results = new ArrayList<>();
        dfsHelper(root, results);
        return results;
    }

    private void dfsHelper(Node node, ArrayList<Integer> results) {
        if (node == null) return;
        results.add(node.value); // Pre-order traversal
        dfsHelper(node.left, results);
        dfsHelper(node.right, results);
    }
}
       