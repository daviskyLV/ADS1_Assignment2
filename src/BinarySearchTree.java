public class BinarySearchTree<T> extends BinaryTree<T> {
    public boolean insert(T element) {
        if (root == null) {
            root = new BinaryTreeNode<>(element);
            return true;
        }

        return insert(element, root);
    }

    private boolean insert(T element, BinaryTreeNode<T> node) {
        if (node.getElement().equals(element))
            return false;

        BinaryTreeNode<T> left = node.getLeftChild();
        BinaryTreeNode<T> right = node.getRightChild();
        // idk how to compare for unspecified types
        if (element > node.getElement()) {
            if (right == null) {
                node.addRightChild(
                        new BinaryTreeNode<>(element)
                );
                return true;
            }
            return insert(element, right);
        }

        if (element < node.getElement()) {
            if (left == null) {
                node.addLeftChild(
                        new BinaryTreeNode<>(element)
                );
                return true;
            }
            return insert(element, left);
        }

        return false; // bug?
    }

    public boolean removeElement(T element) {
        return false;
    }

    public T findMin() {
        if (root == null)
            return null;

        return findMin(root);
    }

    private T findMin(BinaryTreeNode<T> node) {
        BinaryTreeNode<T> left = node.getLeftChild();
        if (left != null)
            return findMin(left);

        return node.getElement();
    }

    public T findMax() {
        if (root == null)
            return null;

        return findMax(root);
    }

    private T findMax(BinaryTreeNode<T> node) {
        BinaryTreeNode<T> right = node.getRightChild();
        if (right != null)
            return findMax(right);

        return node.getElement();
    }

    public void rebalance() {

    }
}
