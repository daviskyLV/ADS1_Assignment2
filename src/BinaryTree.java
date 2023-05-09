import java.util.ArrayList;

public class BinaryTree<T> {
    protected BinaryTreeNode<T> root;
    protected int height = -1;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode<T> node) {
        root = node;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        if (getRoot() == null) {
            return 0;
        }

        ArrayList<T> elems = new ArrayList<>();
        inOrder(root, elems);
        return elems.size();
    }

    public boolean contains(T element) {
        return false;
    }

    public ArrayList<T> inOrder() {
        ArrayList<T> traversedElements = new ArrayList<>();
        if (getRoot() == null) {
            return traversedElements;
        }

        inOrder(root, traversedElements);
        return traversedElements;
    }

    private void inOrder(BinaryTreeNode<T> node, ArrayList<T> outputArray) {
        BinaryTreeNode<T> left = node.getLeftChild();
        BinaryTreeNode<T> right = node.getRightChild();

        if (left != null) {inOrder(left, outputArray);}
        outputArray.add(node.getElement());
        if (right != null) {inOrder(right, outputArray);}
    }

    public ArrayList<T> preOrder() {
        ArrayList<T> traversedElements = new ArrayList<>();
        if (getRoot() == null) {return traversedElements;}

        preOrder(root, traversedElements);
        return traversedElements;
    }

    private void preOrder(BinaryTreeNode<T> node, ArrayList<T> outputArray) {
        BinaryTreeNode<T> left = node.getLeftChild();
        BinaryTreeNode<T> right = node.getRightChild();

        outputArray.add(node.getElement());
        if (left != null) {preOrder(left, outputArray);}
        if (right != null) {preOrder(right, outputArray);}
    }

    public ArrayList<T> postOrder() {
        ArrayList<T> traversedElements = new ArrayList<>();
        if (getRoot() == null) {return traversedElements;}

        postOrder(root, traversedElements);
        return traversedElements;
    }

    private void postOrder(BinaryTreeNode<T> node, ArrayList<T> outputArray) {
        BinaryTreeNode<T> left = node.getLeftChild();
        BinaryTreeNode<T> right = node.getRightChild();

        if (left != null) {postOrder(left, outputArray);}
        if (right != null) {postOrder(right, outputArray);}
        outputArray.add(node.getElement());
    }

    public ArrayList<T> levelOrder() {
        return null;
    }

    public int height() {
        return height;
    }
}
