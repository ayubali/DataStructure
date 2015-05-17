package com.data.structure;

/**
 *
 * @author ayub
 */
class TNode {

    int value;
    TNode leftChild;
    TNode rightChild;

    @Override
    public String toString() {
        return "Node{" + "value=" + value + ", leftChild=" + leftChild + ", rightChild=" + rightChild + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.value;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {

        if ((obj instanceof TNode) && (((TNode) obj).value == this.value)) {
            return true;
        }
        return false;

    }
}

interface ITree {

    public TNode find(int value);

    public void insert(int value);

    public boolean delete(int value);

    public void inOderTranverse(TNode root);

    public TNode minimum();

    public TNode maximum();
}

class Tree implements ITree {

    private TNode root;

    public TNode getRoot() {
        return root;
    }

    @Override
    public TNode find(int value) {

        TNode current = root;
        while (current != null) {
            if (current.value == value) {
                System.out.println("Found: " + value + " Node " + current);
                break;
            }
            else if (value < current.value) {
                current = current.leftChild;
            }
            else {
                current = current.rightChild;
            }
        }
        return current;
    }

    @Override
    public void insert(int value) {
        TNode newNode = new TNode();
        newNode.value = value;
        if (root == null) {
            root = newNode;
        }
        else {
            TNode current;
            TNode parent;
            current = root;
            while (true) {
                parent = current;
                if (value < current.value) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                }
                else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    // returns node with next-highest value after delNode
    // goes to right child, then right child's left descendants
    public TNode getSuccessorNode(TNode delNode) {
        TNode successorparent = delNode;
        TNode succssor = delNode;
        TNode current = delNode.rightChild;
        while (current != null) {
            successorparent = succssor;
            succssor = current;
            current = current.leftChild;
        }

        if (succssor != delNode.rightChild) {
            successorparent.leftChild = succssor.rightChild;
            succssor.rightChild = delNode.rightChild;
        }
        return succssor;
    }

    @Override
    public boolean delete(int value) {
        TNode current = root;
        TNode parent = null;
        boolean isLeftChild = false;
        while (current.value != value) { // find the number
            parent = current;
            if (value < current.value) {
                isLeftChild = true;
                current = current.leftChild;
            }
            else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) {
                System.out.println("Item not found");
                return false;
            }
        }
        /*
         *                  45
         *                /     \ 
         *              40       56
         *            /    \   
         *           20   
         *    del 20 ,  just set null as 20 has no child
         */
        if (current.leftChild == null & current.rightChild == null) {
            if (current.equals(root)) {
                root = null;
            }
            else if (isLeftChild) {
                parent.leftChild = null;
            }
            else {
                parent.rightChild = null;
            }
        }
        /*
         *                  45                     45     
         *                /     \                /     \  
         *              40       56   after:-> 20       56 
         *            /      
         *           20   
         *    del 40 ,  just set null as 20 has no child
         */
        else if (current.rightChild == null) {
            if (current.equals(root)) {
                root = current.leftChild;
            }
            else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            }
            else {
                parent.rightChild = current.leftChild;
            }
        }
        /*
         *                  45                     45     
         *                /     \                /     \  
         *              40       56   after:-> 43       56 
         *                \  
         *                 43
         *    del 40 ,  just set null as 20 has no child
         */
        else if (current.leftChild == null) {
            if (current.equals(root)) {
                root = current.rightChild;
            }
            else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            }
            else {
                parent.rightChild = current.rightChild;
            }
        }
        else {
            TNode succssor = getSuccessorNode(current);
            if (current.equals(root)) {
                root = succssor;
            }
            else if (isLeftChild) {
                parent.leftChild = succssor;
            }
            else {
                parent.rightChild = succssor;
            }
            succssor.leftChild = current.leftChild;
        }
        return true;
    }

    @Override
    public void inOderTranverse(TNode root) {
        if (root != null) {
            inOderTranverse(root.leftChild);
            System.out.println(root);
            inOderTranverse(root.rightChild);
        }
    }

    @Override
    public TNode minimum() {
        TNode last = null;
        TNode current;
        current = root;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last;
    }

    @Override
    public TNode maximum() {
        TNode last = null;
        TNode current = root;
        while (current != null) {
            last = current;
            current = current.rightChild;
        }
        return last;
    }
}

public class BTree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tree tree = new Tree();

        tree.insert(60);
        tree.insert(66);
        tree.insert(25);
        tree.insert(50);
        tree.insert(33);
        tree.insert(44);
        tree.insert(12);

        //tree.inOderTranverse(tree.getRoot());
        tree.delete(25);
        tree.inOderTranverse(tree.getRoot());
    }
}
