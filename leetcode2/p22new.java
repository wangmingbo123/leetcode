package leetcode2;

import java.util.Stack;

public class p22new {
    public static void main(String[] args) {
        dfs2("", 3, 0, 0);

    }


    // 深度优先
    static void dfs(String s, int n, int left, int right) {

        if (left == n && left == right) {

            System.out.println(s);
            return;
        }

        if (left < n) {

            dfs(s + "(", n, left + 1, right);

        }

        if (left > right) {
            dfs(s + ")", n, left, right + 1);
        }


    }


    static void dfs2(String s, int n, int left, int right) {

        // 采用站改写
        Stack<String> stack = new Stack<>();
        stack.push(n + "," + left + "," + right);
        Stack<String> mm = new Stack();
        mm.push("");
        while (stack.size() > 0) {
            String item = stack.pop();
            n = Integer.parseInt(item.split(",")[0]);
            left = Integer.parseInt(item.split(",")[1]);
            right = Integer.parseInt(item.split(",")[2]);
            s = mm.pop();

            if (left == n && left == right) {
                System.out.println(s);
                continue;
            }

            if (left < n) {

                mm.push(s + "(");
                stack.push(n + "," + (left + 1) + "," + right);

            }

            if (left > right) {
                mm.push(s + ")");
                stack.push(n + "," + left + "," + (right + 1));
            }
        }


    }


}
