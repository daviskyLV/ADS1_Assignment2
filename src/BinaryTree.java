import java.util.ArrayList;

public class BinaryTree<T> {
    protected BinaryTreeNode<T> root;

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
        return inOrder().size();
    }

    public boolean contains(T element) {
        if (getRoot() == null) {
            return false;
        }

        var found = findWithParent(element, root, null);
        return found.size() != 0;
    }

    protected ArrayList<BinaryTreeNode<T>> findWithParent(T element, BinaryTreeNode<T> node, BinaryTreeNode<T> parent) {
        ArrayList<BinaryTreeNode<T>> out = new ArrayList<>(); // node, parent
        if (node.getElement().equals(element)) {
            out.add(node);
            out.add(parent);
            return out;
        }

        BinaryTreeNode<T> left = node.getLeftChild();
        BinaryTreeNode<T> right = node.getRightChild();
        // idk how to compare for unspecified types
        if (element > node.getElement() && right != null) {
            return findWithParent(element, right, node);
        }
        if (element < node.getElement() && left != null) {
            return findWithParent(element, left, node);
        }

        return out;
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
        ArrayList<T> traversedElements = new ArrayList<>();
        if (root == null) {
            return traversedElements;
        }

        ArrayList<BinaryTreeNode<T>> nodes = new ArrayList<>();
        nodes.add(root);
        for (var node: nodes) {
            traversedElements.add(node.getElement());
            var nextNodes = levelOrder(node);
            if (nextNodes.get(0) != null) {nodes.add(nextNodes.get(0));}
            if (nextNodes.get(1) != null) {nodes.add(nextNodes.get(1));}
        }

        return traversedElements;
    }

    private ArrayList<BinaryTreeNode<T>> levelOrder(BinaryTreeNode<T> node) {
        ArrayList<BinaryTreeNode<T>> out = new ArrayList<>();
        out.add(node.getLeftChild());
        out.add(node.getRightChild());
        return out;
    }

    public int height() {
        if (root == null) {return -1;}

        return getHeight(root,0);
    }

    private int getHeight(BinaryTreeNode<T> node, int curHeight) {
        BinaryTreeNode<T> left = node.getLeftChild();
        BinaryTreeNode<T> right = node.getRightChild();
        int leftH = curHeight;
        int rightH = curHeight;

        if (left != null) {
            leftH = getHeight(left, curHeight+1);
        }
        if (right != null) {
            rightH = getHeight(right, curHeight+1);
        }
        return Math.max(leftH, rightH);
    }
}
