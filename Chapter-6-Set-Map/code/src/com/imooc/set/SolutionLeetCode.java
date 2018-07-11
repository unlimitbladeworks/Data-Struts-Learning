package com.imooc.set;

import java.util.TreeSet;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName SolutionLeetCode
 * @Description LeetCode 804
 * Solution Morse Code
 * @Date 2018年05月22日21:51:19
 */
public class SolutionLeetCode {

    public static int uniqueMorseRepresentations(String[] words) {

        //Morse Code mapping a-z
        String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        TreeSet<String> set = new TreeSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                //charAt(i) - 'a' 字符转成ASCII码做差了,所以减出来就是个偏移
                sb.append(codes[word.charAt(i) - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }

    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};
        System.out.println(SolutionLeetCode.uniqueMorseRepresentations(words));
    }

}
