package org.cheng.trie;

import java.util.HashMap;

public class Trie {
    /**
     *  trie树 结点 数据结构
     */

    private static class Node {

        private int count;

        private HashMap<Character,Node> child;

        private Node () {
            this.count = 0;
            this.child = new HashMap<>(16);
        }



    }

    private Node root;

    public Trie() {
        root = new Node();
    }



    public boolean find(String s, boolean exactMatch, boolean insertIfNotExist) {
        Node cur = root;
        for (Character ch : s.toCharArray()) {
            if (!cur.child.containsKey(ch)) {
                if (!insertIfNotExist) {
                    return false;
                }
                cur.child.put(ch,new Node());
            }
            cur = cur.child.get(ch);

        }
        if (insertIfNotExist) {
            cur.count++;
        }
        return !exactMatch || cur.count > 0 ;
    }

    public void insert(String word) {
        find(word,true,true);
    }

    public boolean search(String word) {
        return find(word,true,false);
    }

    public boolean startWith(String prefix) {
        return find(prefix,false,false);
    }




}
