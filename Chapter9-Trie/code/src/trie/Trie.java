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

    }
}
