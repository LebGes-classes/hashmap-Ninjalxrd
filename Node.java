public class Node <K,V> {
    private final int hash;
    private final K key;
    private V value;
    private Node<K,V>  next;

    Node (int hash, K key, V value) {
        this.hash = hash;
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }
    public V getValue() {
        return value;
    }
    public Node<K,V> getNext() {
        return next;
    }

    public int getHash() {
        return hash;
    }
    public void setValue(V value) {
        this.value = value;
    }
    public void setNext(Node<K,V> next) {
        this.next = next;
    }

}
