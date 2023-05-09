public class BinaryTreeNode<T> {
    private T element;
    private BinaryTreeNode<T> leftChild;
    private BinaryTreeNode<T> rightChild;

    public BinaryTreeNode(T element) {
        this.element = element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }

    public void addLeftChild(BinaryTreeNode<T> child) {
        if (leftChild != null) {
            leftChild.addLeftChild(child);
            return;
        }
        leftChild = child;
    }

    public void addRightChild(BinaryTreeNode<T> child) {
        if (rightChild != null) {
            rightChild.addRightChild(child);
            return;
        }
        rightChild = child;
    }

    public BinaryTreeNode<T> getLeftChild() {
        return leftChild;
    }

    public BinaryTreeNode<T> getRightChild() {
        return rightChild;
    }
}
