package datastructures.binarysearchtree;
public class Main {
    public static void main(String[] args) {
        BinarySearchTree myBST = new BinarySearchTree();
        myBST.insert(47);
        myBST.insert(21);
        myBST.insert(76);
        myBST.insert(18);
        myBST.insert(52);
        myBST.insert(82);
        myBST.insert(90);

        // myBST.rInsert(27);
        // myBST.rInsert(100);
        System.out.println(myBST.root.right.value);
       
        System.out.println("-----------------");
        
        // Print minimum and maximum values
        System.out.println("Minimum value: " + myBST.minValue());
        System.out.println("Maximum value: " + myBST.maxValue());
        
        myBST.deleteNode(21);
        System.out.println(myBST.root.left.value);
    }
    
     
}
