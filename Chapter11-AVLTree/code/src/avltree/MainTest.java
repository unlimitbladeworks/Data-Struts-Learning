package avltree;

import com.imooc.map.BSTMap;
import com.imooc.map.LinkedListMap;
import com.imooc.map.Map;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName MainTest
 * @Description Map测试类
 * @Date 2018年05月24日22:41:32
 */
public class MainTest {


    @Test
    public void testBSTMap() {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();


        if (FileOperation.readFile("./Data-Struts-Learning/Chapter11-AVLTree/code/src/pride-and-prejudice.txt", words1)) {
            long startTime = System.nanoTime();
            System.out.println("Total words: " + words1.size());
            BSTMap<String, Integer> map = new BSTMap<>();
            for (String word : words1) {
                if (map.contains(word)) {
                    map.set(word, map.get(word) + 1);
                } else {
                    map.add(word, 1);
                }
            }
            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE : " + map.get("pride"));
            long endTime = System.nanoTime();
            double time = (endTime - startTime)/1000000000.0;
            //BST spend time:0.228477757s
            System.out.println("BST spend time:" + time + "s");
        }
    }

    @Test
    public void testAVLTree() {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();


        if (FileOperation.readFile("./Data-Struts-Learning/Chapter11-AVLTree/code/src/pride-and-prejudice.txt", words1)) {
            long startTime = System.nanoTime();
            System.out.println("Total words: " + words1.size());
            AVLTree<String, Integer> avlTree = new AVLTree<>();
            for (String word : words1) {
                if (avlTree.contains(word)) {
                    avlTree.set(word, avlTree.get(word) + 1);
                } else {
                    avlTree.add(word, 1);
                }
            }
            System.out.println("Total different words: " + avlTree.getSize());
            System.out.println("Frequency of PRIDE : " + avlTree.get("pride"));
            System.out.println("Is BST:" + avlTree.isBST());
            System.out.println("Is Balanced:" + avlTree.isBalanced());
            long endTime = System.nanoTime();
            double time = (endTime - startTime)/1000000000.0;
            //AVL spend time:0.518091708s（因打印原因造成的）
            System.out.println("AVL spend time:" + time + "s");
        }
    }
}
