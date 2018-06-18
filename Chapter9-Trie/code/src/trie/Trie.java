package trie;

import java.util.TreeMap;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName Trie
 * @Description Trie 树
 * @Date 2018/6/17 12:27
 */
public class Trie {

    /**
     * 创建内部类节点
     */
    private class Node {

        /**
         * 是否是一个单词
         */
        public boolean isWord;

        /**
         * 以char-node作为映射,此trie仅为英文单词,
         * 因为字母的单元包装是Character
         */
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;

    private int size;


    public Trie() {
        root = new Node();
        size = 0;
    }

    /**
     * 获取Trie中存储的单词数量
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 向Trie中添加一个新的单词word
     *
     * @param word
     */
    public void add(String word) {

        Node current = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (current.next.get(c) == null) {
                current.next.put(c, new Node());
            }
            current = current.next.get(c);
        }
        if (!current.isWord) {
            current.isWord = true;
            size++;
        }
    }

    /**
     * 查询word 是否在Trie中
     *
     * @param word
     * @return
     */
    public boolean contains(String word) {

        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (current.next.get(c) == null) {
                return false;
            }
            current = current.next.get(c);
        }
        return current.isWord;
    }
}
