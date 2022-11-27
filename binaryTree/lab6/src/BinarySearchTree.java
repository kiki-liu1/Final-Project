/**
 * PreOrder: Print root value first and then left subtree and then right subtree.
 * InOrder: Print left subtree first and then root value and then right subtree.
 * PostOrder: Print left subtree first and then right subtree and then root value.
 */
//Create an enumeration class to record the traversal method
enum Order {
    PreOrder,
    InOrder,
    PostOrder
}

public class BinarySearchTree<K extends Comparable<? super K>, V> {
   //the root node of binarySearchTree
    private Node<K, V> root;
   //the num of node
    private int size = 0;

    /**
     * @return True if this tree is an empty tree, otherwise False.
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * @return The number of the nodes in this tree.
     */
    public int getSize() {
        return size;
    }

    /**
     * Find a Node from the tree.
     * @param key key of the node to search.
     * @return The node corresponding to the key.
     */
    public Node<K, V> search(K key) {
        Node<K, V> node = root;
        while(node != null) {
            if (key.compareTo(node.getKey()) < 0) {
                node = node.getLeft();
            } else if (key.compareTo(node.getKey()) > 0) {
                node = node.getRight();
            } else {
                return node;
            }
        }
        return null;
    }

    /**
     * Insert a Node to the tree.
     * @param key key of the node to be inserted.
     * @param value value of the node to be inserted.
     */
    public void insert(K key, V value) {
        if (isEmpty()) {
            root = new Node<K, V>(key, value);
            size++;
        } else {
            Node<K, V> node = root;
            while (true) {
                //if the key less than the key of node,then insert it to the left of node
                if (key.compareTo(node.getKey()) < 0) {
                    if (node.getLeft() == null) {
                        node.setLeft(new Node<K, V>(key, value));
                        size++;
                        break;
                    } else {
                        node = node.getLeft();
                    }
                } else if (key.compareTo(node.getKey()) > 0) {//if the key greater than the key of node,then insert it to the right of node
                    if (node.getRight() == null) {
                        node.setRight(new Node<K, V>(key, value));
                        size++;
                        break;
                    } else {
                        node = node.getRight();
                    }
                } else {
                    // @TODO
                    System.out.println("ERROR");
                    break;
                }
            }
        }
    }

    /**
     * Delete a Node from the tree.
     * @param key key of the Node to be deleted.
     */
    public void delete(K key) {
        if (!isEmpty()) {
            if (key.compareTo(root.getKey()) == 0) {
                root = deleteNode(root);
                size--;
            } else {
                Node<K, V> node = root;
                while (node != null) {
    	   //if the key less then the key of node,then delete it from the  left of the node
                    if (key.compareTo(node.getKey()) < 0) {
                        if (node.getLeft().getKey() != null && key.compareTo(node.getLeft().getKey()) == 0) {
                            node.setLeft(deleteNode(node.getLeft()));
                            size--;
                        } else {
                            node = node.getLeft();
                        }
                    } else {
	      //if the key greater then the key of node,then delete it from the right of the node
                        if (node.getRight().getKey() != null && key.compareTo(node.getRight().getKey()) == 0) {
                            node.setRight(deleteNode(node.getRight()));
                            size--;
                        } else {
                            node = node.getRight();
                        }
                    }
                }
            }
        }
    }

    /**
     * Delete a Node from the tree.
     * @param node Node to be deleted.
     * @return
     */
    private Node<K, V> deleteNode(Node<K, V> node) {
        if (node.getLeft() == null && node.getRight() == null) {
            return null;
        }
        if (node.getLeft() == null) {
            return node.getRight();
        }
        if (node.getRight() == null) {
            return node.getLeft();
        }
        Node<K, V> tmp = node.getRight();
        if (tmp.getLeft() == null) {
            tmp.setLeft(node.getLeft());
            return tmp;
        }
        while (tmp.getLeft().getLeft() != null) {
            tmp = tmp.getLeft();
        }
        Node<K, V> left = tmp.getLeft();
        left.setLeft(node.getLeft());
        left.setRight(node.getRight());
        tmp.setLeft(null);
        return left;
    }

    /**
     * Lookup the whole tree in a certain order.
     * @param order Lookup order.
     */
    public void Lookup(Order order) {
        LookupTree(root, order);
    }

    /**
     * Look up a tree in a centain order.
     * @param root root of a tree.
     * @param order Lookup order.
     */
    private void LookupTree(Node<K, V> root, Order order) {
        if (root == null) {
            return;
        }
        switch (order) {
            //inorder travel
            case InOrder:
                LookupTree(root.getLeft(), order);
                System.out.println("Key: " + root.getKey().toString() + ", Value: " + root.getValue().toString());
                LookupTree(root.getRight(), order);
                break;
           //preorder travel
            case PreOrder:
                System.out.println("Key: " + root.getKey().toString() + ", Value: " + root.getValue().toString());
                LookupTree(root.getLeft(), order);
                LookupTree(root.getRight(), order);
                break;
           //postorder travel
            case PostOrder:
                LookupTree(root.getLeft(), order);
                LookupTree(root.getRight(), order);
                System.out.println("Key: " + root.getKey().toString() + ", Value: " + root.getValue().toString());
                break;
        }
    }
}
