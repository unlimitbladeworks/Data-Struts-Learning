package com.imooc.stacks;

import org.junit.Test;

import java.util.Stack;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName LeetCodeStackTest
 * @Description LettCode的问题解决方案---通过栈解决
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * 示例 1:
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * 输入: "(]"
 * 输出: false
 * @Date 18-4-27 下午10:45
 */
public class LeetCodeStackTest {

    @Test
    public void testStack(){
        System.out.println(isVaild("(){}[]"));
        System.out.println(isVaild("([)]"));
    }


    /**
     * 括号合法
     * @param s
     * @return
     */
    public boolean isVaild(String s) {

        Stack<Character> stack = new Stack();
        //遍历给定的字符串,比对每一个字符,如果c字符为各种括号的左边,则进行压栈
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                //判断栈是否为空,若为空返回 false
                if (stack.isEmpty()){
                    return false;
                }
                char topChar = stack.pop();
                if (c == ')' && topChar != '('){
                    return false;
                }
                if (c == '}' && topChar != '{'){
                    return false;
                }
                if (c == ']' && topChar != '['){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
