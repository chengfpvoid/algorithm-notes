package org.cheng.algo.lc146;

import java.util.HashMap;
import java.util.Map;

/**
 * 设计和实现一个  LRU (最近最少使用) 缓存机制 。
 * 在 O(1) 时间复杂度内完成这两种操作
 */
public class LRUCache {

    private static class Node {
        private int key;
        private int value;
        private Node pre;
        private Node next;
    }

    private Node head;

    private Node tail;

    private int capacity;

    private Map<Integer,Node> map;

    public LRUCache(int capacity) {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
        this.capacity = capacity;
        map = new HashMap<>();

    }

    /**
     *  如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
     * @param key
     * @return
     */
    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }
        //注意每次访问到 位置就调整到头部
        Node node  = map.get(key);
        // 从当前位置删掉
        removeNode(node);
        //从头部插入
        insertToHead(node.key,node.value);
        return node.value;

    }

    /**
     * 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。
     * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
     * @param key
     * @param value
     */
    public void put(int key, int value) {

        if (map.containsKey(key)) {
            //注意每次访问到 位置就调整到头部
            Node node  = map.get(key);
            // 从当前位置删掉
            removeNode(node);
            //从头部插入,这里不能用node中取值，因为value可能已经变了
            insertToHead(key,value);

        } else {
            insertToHead(key,value);
        }
        if (map.size() > capacity) {
            // 超过容量大小 则删除末尾的数据
            removeNode(tail.pre);
        }


    }

    /**
     * 从头部插入k,v组成的新的节点
     * @param key
     * @param value
     */
    private void insertToHead(int key, int value) {
        Node node = new Node();
        node.key = key;
        node.value = value;
        // node与head下一个节点建立关系
        node.next = head.next;
        head.next.pre = node;
        //node与head建立关系
        node.pre = head;
        head.next = node;
        this.map.put(key,node);

    }

    /**
     * 从链表中删除节点，从map中删除这个映射
     * @param node
     */
    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        this.map.remove(node.key);
    }
}
