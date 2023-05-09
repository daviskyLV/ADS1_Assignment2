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
        if (root == null) {return false;}

        var elemNode = findWithParent(element, root, null); // node, parent
        if (elemNode.size() == 0) {return false;}

        BinaryTreeNode<T> left = elemNode.get(0).getLeftChild();
        BinaryTreeNode<T> right = elemNode.get(0).getLeftChild();
        BinaryTreeNode<T> parent = elemNode.get(1);
        // no child nodes
        if (left == null && right == null) {
            if (parent == null) {
                root = null;
                return true;
            }

            if (parent.getLeftChild() == elemNode.get(0)) {
                parent.addLeftChild(null);
            } else {
                parent.addRightChild(null);
            }
            return true;
        }

        // left empty, set right as new node
        if (left == null) {
            if (parent == null) {
                root = right;
                return true;
            }

            if (parent.getLeftChild() == elemNode.get(0)) {
                parent.addLeftChild(right);
            } else {
                parent.addRightChild(right);
            }
            return true;
        }

        // right is empty, set left as new node
        if (right == null) {
            if (parent == null) {
                root = left;
                return true;
            }

            if (parent.getLeftChild() == elemNode.get(0)) {
                parent.addLeftChild(left);
            } else {
                parent.addRightChild(left);
            }
            return true;
        }

        // both are taken, taking left's most right side
        var leftMostRight = findMax(left);
        if (leftMostRight == left) {
            leftMostRight.addRightChild(right);
            if (parent == null) {root = leftMostRight;}
            return true;
        }

        var leftMostRightLeft = leftMostRight.getLeftChild();
        left.addRightChild(leftMostRightLeft);
        leftMostRight.addLeftChild(left);
        leftMostRight.addRightChild(right);
        if (parent == null) {root = leftMostRight;}

        return true;
    }

    public T findMin() {
        if (root == null)
            return null;

        BinaryTreeNode<T> minNode = findMin(root);
        return minNode.getElement();
    }

    private BinaryTreeNode<T> findMin(BinaryTreeNode<T> node) {
        BinaryTreeNode<T> left = node.getLeftChild();
        if (left != null)
            return findMin(left);

        return node;
    }

    public T findMax() {
        if (root == null)
            return null;

        BinaryTreeNode<T> maxNode = findMax(root);
        return maxNode.getElement();
    }

    private BinaryTreeNode<T> findMax(BinaryTreeNode<T> node) {
        BinaryTreeNode<T> right = node.getRightChild();
        if (right != null)
            return findMax(right);

        return node;
    }

    public void rebalance() {

    }
}
