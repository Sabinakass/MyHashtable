public class MyHashTable<K,V> {

    private static final int initCap = 16;
    private static final double loadFact = 0.75;
    private int size;
    MyHashNode<K,V>[] buckets;
    private class MyHashNode<K,V>{
        private K key;
        private V value;
        MyHashNode<K,V> next;
        public MyHashNode(K key, V value){
            this.key=key;
            this.value=value;
        }
        @Override
        public String toString(){
            return "{" + key + " " + value + "}";
        }
    }
    public MyHashTable(){
        this(initCap);
    }
    public MyHashTable(int cap){
        this.buckets=new MyHashNode[cap];
        size=0;
    }
    public int getSize(){
        return size;
    }
    private int hash( K key) {
       return Math.abs(key.hashCode()% buckets.length);
    }


    public void put(K key, V value){
        int index=hash(key);
        MyHashNode head=buckets[index];
        while(head!=null){
            if(head.key.equals(key)){
                head.value=value;
                return;
            }
            head=head.next;
        }
        head=buckets[index];
        MyHashNode node=new MyHashNode(key, value);
       node.next=head;
       buckets[index]=node;
        size++;
        if ((double) size / buckets.length >= loadFact) {
            resize();
        }
    }

    public V get(K key){
        int index=hash(key);
        MyHashNode head=buckets[index];
        while (head!=null){
            if(head.key.equals(key)){
                return (V) head.value;
            }
            head=head.next;
        }
        return null;
    }

    public V remove(K key){
        int index=hash(key);
        MyHashNode head=buckets[index];
        MyHashNode previous=null;
        while(head!=null){
            if(head.key.equals(key)){
                break;
            }
            previous=head;
            head=head.next;
        }
        if(head==null){
            return null;
        }
        size--;
        if(previous != null){
            previous.next=head.next;
        }
        else{
            buckets[index]=head.next;
        }
        return (V) head.value;
    }
    public boolean contains(V value){
        for(int i=0;i<buckets.length;i++){
            MyHashNode node=buckets[i];
            while(node!=null){
                if(node.value.equals(value)){
                    return true;
                }
                node=node.next;
            }
        }
        return false;
    }
    public K getKey(V value){
        for(int i=0;i<buckets.length;i++){
            MyHashNode node=buckets[i];
            while(node!=null){
                if(node.value.equals(value)){
                    return (K)node.key;
                }
                node=node.next;
            }
        }
        return null;
    }
    private void resize(){
        int newCap= buckets.length*2;
        MyHashNode[] temp=new MyHashNode[newCap];
        for(int i=0;i<buckets.length;i++){
            MyHashNode node=buckets[i];
            while(node!=null){
                int newIndex = hash((K) node.key);
                MyHashNode newNode = new MyHashNode(node.key, node.value);
                newNode.next = temp[newIndex];
                temp[newIndex] = newNode;
                node = node.next;
            }
        }

    }

    public void printBucketSizes() {
        int[] bucketSizes=new int[buckets.length];
        for (int i = 0; i < buckets.length; i++) {
            MyHashNode node=buckets[i];
            while(node!=null){
                bucketSizes[i]+=1;
                node=node.next;
            }
        }
        for (int i = 0; i < buckets.length; i++){
            System.out.println("Bucket #"+i+" has length of "+bucketSizes[i]);
        }
    }

}
