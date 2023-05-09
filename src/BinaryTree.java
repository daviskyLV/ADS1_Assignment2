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
        return 0;
    }

    public boolean contains(T element) {
        return false;
    }

    public ArrayList<T> inOrder() {
        return null;
    }

    public ArrayList<T> preOrder() {
        return null;
    }

    public ArrayList<T> postOrder() {
        return null;
    }

    public ArrayList<T> levelOrder() {
        return null;
    }

    public int height() {
        return height;
    }
}
