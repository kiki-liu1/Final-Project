/**
 * A Node represents a record in Dictionary.
 * @param <K> Key Type, must be Comparable
 * @param <V> Value Type
 */
public class Node<K extends Comparable<? super K>, V> {
   //the left of the node,and the key of left is less than this
    private Node<K, V> left;
   //the right of the node,and the key of right is greater than this
    private Node<K, V> right;
    private K key;
    private V value;

    /**
     * @param key key of this node
     * @param value value of this node
     */
    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public Node<K, V> getLeft() {
        return left;
    }

    public void setLeft(Node<K, V> left) {
        this.left = left;
    }

    public Node<K, V> getRight() {
        return right;
    }

    public void setRight(Node<K, V> right) {
        this.right = right;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
