public class BinaryTreeNode<T> {
    private T element;
    private BinaryTreeNode leftChild;
    private BinaryTreeNode rightChild;

    public BinaryTreeNode(T element) {
        this.element = element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }

    public void addLeftChild(BinaryTreeNode child) {
        if (leftChild != null) {
            leftChild.addLeftChild(child);
            return;
        }
        leftChild = child;
    }

    public void addRightChild(BinaryTreeNode child) {
        if (rightChild != null) {
            rightChild.addRightChild(child);
            return;
        }
        rightChild = child;
    }

    public BinaryTreeNode getLeftChild() {
        return leftChild;
    }

    public BinaryTreeNode getRightChild() {
        return rightChild;
    }
}
