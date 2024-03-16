
//k наследует comparable для сравнения
public class MyHashmap <K extends Comparable<K>,V>  {
    //создание массива нодов, в каждом хранится ключ-значение и связный список в случае коллизии
    private Node<K,V> [] table;
    private int size;
    MyHashmap() {
        this.table = new Node[4];
    }

    public void put (K key, V value) {
        int count = 0;
        // хешируем объект key
        int hash = key.hashCode();
        // вставляем в рандомное место по формуле
        int bucketIndex = hash % table.length;

        //проверка коллизии
        Node <K,V> someNode = new Node<>(hash,key,value);
        while (someNode != null) {
            if (someNode.getHash() == hash) {
                // при совпадении хэша нужно выполнить проверку, совпадают ли ключи, если да
                // то перезапишем ячейку, иначе создадим отвлетвление next в Nod`e
                if (someNode.getKey().equals(key)) {
                    someNode.setValue(value);
                } else {
                    someNode.setNext(someNode);
                }
            }
            count ++;
            //проход по массиву
            someNode = someNode.getNext();
        }

        //если ключ уникален
        Node<K,V> newNode = new Node<>(hash, key, value);
        table[bucketIndex] = newNode;
        size++;

        //увеличение массива, в случае, когда кол-во бакетов приближается к вместимости
        if (count >= table.length) {
            boostCapacity(table.length * 2);
        }
    }

    public V get (K key) {
        int hash = key.hashCode();
        int indexBucket = hash % table.length;
        Node <K,V> varNode = table[indexBucket];
        while (varNode != null) {
            if (varNode.getKey().equals(key)) {
                return varNode.getValue();
            }
            varNode = varNode.getNext();
        }
        return null;
    }

    public boolean containsKey (K key) {
        // Высчитывается hash по ключу
        int hash = key.hashCode();
        // Используется хэш-код для определения индекса bucket
        int bucketIndex = hash % table.length;
        // Поиск ключа
        Node<K,V> curNode = table[bucketIndex];
        while (curNode != null) {
            if (curNode.getKey().equals(key)) {
                return true;
            }
            curNode = curNode.getNext();
        }
        return false;
    }


    public boolean containsValue(V value) {
        for (Node <K,V> buckets : table) {
            while (buckets != null) {
                if (buckets.getValue().equals(value)) {
                    return true;
                }
                buckets = buckets.getNext();
            }
        }
        return false;
    }

    public void remove(K key) {
        int hash = key.hashCode();
        int bucketIndex = hash % table.length;
        table[bucketIndex] = table[bucketIndex].getNext();
        size--;
    }

    public int size () {
        return size;
    }
    //специальный метод увеличения вместимости
    public void boostCapacity (int capacity) {
        Node <K,V> [] newTable = new Node[capacity];
        for (Node<K,V> bucket : table) {
            while (bucket != null) {
                int newBucketIndex = bucket.getHash() % table.length;
                while (newTable[newBucketIndex] != null) {
                    newTable[newBucketIndex] = newTable[newBucketIndex].getNext();
                }
                newTable[newBucketIndex] = bucket;
                bucket = bucket.getNext();
            }
        }
    }








}

