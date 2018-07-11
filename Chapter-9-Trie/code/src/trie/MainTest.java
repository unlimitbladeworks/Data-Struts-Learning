package trie;

import java.util.ArrayList;
import java.util.List;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName MainTest
 * @Description Tire≤‚ ‘¿‡
 * @Date 2018/6/17 12:28
 */
public class MainTest {

    public static void main(String[] args) {
        System.out.println("Pride-and-prejudice");
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("./Data-Struts-Learning/Chapter9-Trie/code/pride-and-prejudice.txt", words)) {

            long startTime = System.nanoTime();
            BSTSet<String> set = new BSTSet<>();
            for (String word : words) {
                set.add(word);
            }
            for (String word : words) {
                set.contains(word);
            }
            long endTime = System.nanoTime();
            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("Total differenet words:" + set.getSize());
            System.out.println("BSTSet 's time :" + time + " s");

            startTime = System.nanoTime();
            Trie trie = new Trie();
            for (String word : words) {
                trie.add(word);
            }
            for (String word : words) {
                trie.contains(word);
            }
            endTime = System.nanoTime();
            time = (endTime - startTime) / 1000000000.0;
            System.out.println("Total differenet words:" + trie.getSize());
            System.out.println("Trie 's time :" + time + " s");
        }
    }
}
