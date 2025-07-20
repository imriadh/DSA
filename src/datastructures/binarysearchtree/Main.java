package datastructures.binarysearchtree;
public class Main {
    public static void main(String[] args) {
        BinarySearchTree myBST = new BinarySearchTree();
        // myBST.insert(47);
        // myBST.insert(21);
        // myBST.insert(76);
        // myBST.insert(18);
        // myBST.insert(52);
        // myBST.insert(82);
        // myBST.insert(90);

        myBST.rInsert(27);
        myBST.rInsert(100);
        System.out.println(myBST.root.right.value);
        System.out.println(myBST.rContains(20));
        System.out.println("contain => 100");
        System.out.println(myBST.rContains(100));
    }
    
     
}
