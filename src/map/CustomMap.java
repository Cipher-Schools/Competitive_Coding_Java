package map;


import java.util.ArrayList;

class MapNode {
    int key;
    int value;
    MapNode next;

    public MapNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class CustomMap {

    private ArrayList<MapNode> bucketList;
    private int size;
    private int bucketSize;

    public CustomMap() {
        bucketList = new ArrayList<>();
        bucketSize = 16;

        for (int i = 0; i < bucketSize; i++) {
            bucketList.add(null);
        }
    }

    public void put(int key, int value) {

        int bucketIndex = getBucketIndex(key);
        MapNode head = bucketList.get(bucketIndex);


        MapNode temp = head;
        boolean isFound = false;
        while (temp != null) {
            if (temp.key == key) {
                temp.value = value;
                isFound = true;
                break;
            }
            temp = temp.next;
        }
        if (!isFound) {
            MapNode newNode = new MapNode(key, value);
            newNode.next = head;
            bucketList.set(bucketIndex, newNode);
            size++;
        }

        if ((1.0 * size / bucketSize > 0.7)) {
            rehash();
        }
    }

    public Integer get(int key) {
        int bucketIndex = getBucketIndex(key);
        MapNode head = bucketList.get(bucketIndex);

        MapNode temp = head;

        while (temp != null) {
            if (temp.key == key) {
                return temp.value;
            }
            temp = temp.next;
        }
        return null;
    }

    private void rehash() {
        ArrayList<MapNode> temp = bucketList;
        bucketList = new ArrayList<>();

        for (int i = 0; i < bucketSize * 2; i++) {
            bucketList.add(null);
        }

        bucketSize = bucketSize * 2;
        size = 0;
        for (MapNode head : temp) {
            while (head != null) {
                put(head.key, head.value);
                head = head.next;
            }
        }

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int getBucketIndex(Integer key) {

        int hashCode = Math.abs(key.hashCode());
        int compressed = hashCode % bucketSize;
        return compressed;
    }
}
