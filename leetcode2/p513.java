package leetcode2;


import java.util.*;

/**
 * Created by wy on 2017/6/14.
 */
public class p513 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void haha() {

//            findBottomLeftValue();

    }

    // bfs
    public int findBottomLeftValue(TreeNode root) {
        int leftmost = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root != null) {
            queue.offer(root);
        }
        int size = queue.size();
        while (size > 0) {
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (i == 0)
                    leftmost = temp.val;
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            size = queue.size();
        }
        return size;
    }

    // dfs
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    void test(TreeNode root, int depth) {

        if (root == null)
            return;
        Integer value = map.get(depth + 1);
        if (value == null)
            map.put(depth + 1, root.val);
        test(root.left, depth + 1);
        test(root.right, depth + 1);
    }

    static int d[][] = new int[10][10];


    static void dfs3(String s, int i, int j, Map<Integer, Integer> resultMap, Integer deep) {
//        if (i == s.length() || j == s.length())
//            return;
        int max = 0;
        if (i >= j) {
            // 特殊处理
            d[i][j] = 1;
            if (i > j)
                max = 0;
            if (i == j)
                max = 1;

            // 第deep层最大值
            if (resultMap.containsKey(deep)) {
                resultMap.put(deep, Math.max(resultMap.get(deep), max));
            } else {
                resultMap.put(deep, max);
            }


        } else {

            int a = deep;
            a++;
            for (int k = i; k < j; k++) {

                dfs3(s, k + 1, j - 1, resultMap, a);
                // 进行来越界处理
                if (s.charAt(k) == s.charAt(j) && d[k + 1][j - 1] == 1) {
                    d[k][j] = 1;
                    max = Math.max(max, j - k + 1);


//                    if (resultMap.containsKey(deep)) {
//                        resultMap.put(deep, Math.max(resultMap.get(deep), max));
//                    } else {
//
//                    }

                }
                if (resultMap.containsKey(deep)) {
                    resultMap.put(deep, Math.max(resultMap.get(deep), max));
                } else {
                    resultMap.put(deep, max);
                }


            }


        }
    }


    static void dfs2(String s, int i, int j) {
//        if (i == s.length() || j == s.length())
//            return;
        if (i >= j) {
            // 特殊处理
            d[i][j] = 1;
        } else {
            for (int k = i; k < j; k++) {
                dfs2(s, k + 1, j - 1);
                // 进行来越界处理
                if (s.charAt(k) == s.charAt(j) && d[k + 1][j - 1] == 1) {
                    d[k][j] = 1;
                }


            }

        }
    }


    static void dfs(String s, int i, int j) {
        if (i > j) {
        } else if (i == j) {
            d[i][j] = 1;
        } else {
            for (int k = i; k <= j; k++) {
                if (j - k <= 1) {
                    if (s.charAt(k) == s.charAt(j)) {
                        d[k][j] = 1;
                    }

                } else {
                    // 进入递归
                    dfs(s, k + 1, j - 1);
                    if (s.charAt(k) == s.charAt(j)) {
                        if (d[k + 1][j - 1] == 1) {
                            d[k][j] = 1;
                        }

                    }

                }


//                if (s.charAt(k) == s.charAt(j)) {
//                    if (j - k == 1) {
//                        d[k][j] = 1;
//                        continue;
//                    }
//
//                    dfs(s, k + 1, j - 1);
//                    if (d[k + 1][j - 1] == 1) {
//                        d[k][j] = 1;
//                    }
//                } else {
//                    // 重要
//                    dfs(s, k + 1, j - 1);
//                }

            }


        }

    }

    public static void main(String[] args) {

        int a[] = {3, 1, 5, 2, 7, 6, 4};
//        hhhheap(a);
        System.out.println("**********");


        a = gui(a, 0, a.length-1);

        for (int i = 0; i < a.length; i++) {

            System.out.print(a[i] + "_");

        }

        System.out.println("&&&&&&&");


//        a = num(a, 0, a.length - 1);
        a = llll(a, 0, a.length - 1);


        for (int i = 0; i < a.length; i++) {

            System.out.print(a[i] + "_");

        }
        System.out.println();
        String str = "abcccbd";

        int maxLen = dfs5(str, 0, str.length() - 1);
        System.out.println("maxLen is " + maxLen);


//        dfs(str, 0, str.length() - 1);
//        dfs2(str, 0, str.length() - 1);
        Map<Integer, Integer> resultMap = new HashMap<>();
        dfs3(str, 0, str.length() - 1, resultMap, 0);

        System.out.println("result map is " + resultMap.get(1));

        int max = 0;
        for (int j = 0; j < str.length(); j++) {
            for (int i = 0; i <= j; i++) {

                if (d[i][j] == 1) {
                    max = Math.max(max, j - i + 1);
                }


            }
        }

        System.out.println("max is " + max);


    }

    static int dp[][] = new int[10][10];

    static int dfs5(String s, int i, int j) {

        if (i == j) {
            dp[i][j] = 1;
            return 1;

        } else if (i + 1 == j) {
            if (s.charAt(i) == s.charAt(j)) {
                dp[i][j] = 1;
                return 2;
            } else
                return 0;

        } else {
            int max = 0;
            for (int k = i; k <= j; k++) {
                if (k == j) {
                    max = Math.max(1, max);
                    dp[k][j] = 1;
                } else if (k + 1 == j) {
                    if (s.charAt(k) == s.charAt(j)) {
                        max = Math.max(max, 2);
                        dp[k][j] = 1;
                    }
                } else {

                    max = Math.max(dfs5(s, k + 1, j - 1), max);
                    if (s.charAt(k) == s.charAt(j) && dp[k + 1][j - 1] == 1) {
                        max = Math.max(max, j - k + 1);
                        dp[k][j] = 1;
                    }

                }


            }
            return max;

        }


    }

    static int[] num(int a[], int i, int j) {
        // 为1个元素或者越界了
        if (i >= j)
            return a;

        int left = i;
        int right = j;
        int com = a[i];
        for (int k = i + 1; left < right; k++) {
            if (com > a[k]) {
                a[left] = a[k];
                left++;
            } else {
                int temp = a[right];
                a[right] = a[k];
                a[k] = temp;
                right--;
                k--;
            }


        }
        a[left] = com;
        a = num(a, i, left - 1);
        a = num(a, right + 1, j);
        return a;


    }

    // 采用stack

    static int[] llll(int a[], int i, int j) {
        String root = i + "," + j;
        Stack<String> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {

            String item = stack.pop();
            i = Integer.parseInt(item.split(",")[0]);
            j = Integer.parseInt(item.split(",")[1]);

            //类似退出递归条件
            if (i >= j)
                continue;

            int left = i;
            int right = j;
            int com = a[i];
            for (int k = i + 1; left < right; k++) {
                if (com > a[k]) {
                    a[left] = a[k];
                    left++;
                } else {
                    int temp = a[right];
                    a[right] = a[k];
                    a[k] = temp;
                    right--;
                    k--;
                }


            }
            a[left] = com;

            stack.push(i + "," + (left - 1));
            stack.push((right + 1) + "," + j);


        }

        return a;

    }


    public void test() {

    }


    static void hhhheap(int a[]) {

        for (int i = a.length - 1; i >= 0; i--) {

            a = heap(a, i);
            int tem = a[0];
            a[0] = a[i];
            a[i] = tem;

        }

        for (int i = 0; i < a.length; i++) {

            System.out.print(a[i] + "_");

        }


    }


    static int[] heap(int a[], int j) {
        int k = j / 2;
        while (k >= 0) {
            a = step3(a, k, j);
            k--;
        }
        return a;

    }


    // 1/递归
    // 2/stack

    static int[] step(int a[], int k, int j) {
        int left = 2 * k + 1;
        int right = 2 * k + 2;
        if (j < left) {

        } else if (j == left) {
            if (a[k] < a[left]) {
                int com = a[k];
                a[k] = a[left];
                a[left] = com;
            }

        } else {
            int com = left;
            if (a[left] < a[right]) {
                com = right;
            }

            if (a[k] < a[com]) {
                int temp = a[k];
                a[k] = a[com];
                a[com] = temp;
                a = step(a, com, j);
            }


        }

        return a;

    }


    // stack
    static int[] step2(int a[], int k, int j) {
        Stack<String> stack = new Stack<>();
        stack.push(k + "," + j);
        while (stack.size() > 0) {
            String item = stack.pop();
            k = Integer.parseInt(item.split(",")[0]);
            j = Integer.parseInt(item.split(",")[1]);

            int left = 2 * k + 1;
            int right = 2 * k + 2;
            if (j < left) {

            } else if (j == left) {
                if (a[k] < a[left]) {
                    int com = a[k];
                    a[k] = a[left];
                    a[left] = com;
                }

            } else {
                int com = left;
                if (a[left] < a[right]) {
                    com = right;
                }

                if (a[k] < a[com]) {
                    int temp = a[k];
                    a[k] = a[com];
                    a[com] = temp;
                    stack.push(com + "," + j);
                }


            }

        }


        return a;

    }


    static int[] step3(int a[], int k, int j) {

        while (true) {
            int left = 2 * k + 1;
            int right = 2 * k + 2;
            if (j < left) {
                break;

            } else if (j == left) {
                if (a[k] < a[left]) {
                    int com = a[k];
                    a[k] = a[left];
                    a[left] = com;

                }
                break;

            } else {
                int com = left;
                if (a[left] < a[right]) {
                    com = right;
                }

                if (a[k] < a[com]) {
                    int temp = a[k];
                    a[k] = a[com];
                    a[com] = temp;
                    // 进入递归
                    k = com;
                    continue;
                }
                break;


            }

        }

        return a;

    }


    static int[] gui(int a[], int i, int j) {
        if (i >= j)
            return a;

        int index = i;
        int k = (i + j) / 2;
        a = gui(a, i, k);
        a = gui(a, k + 1, j);
        int ii = k;
        int jj = k + 1;

        //合并有序数组
        int b[] = new int[j - i + 1];
        int m = 0;
        while (true) {
            if (a[i] < a[k + 1]) {
                b[m] = a[i];
                m++;
                i++;
            } else {
                b[m] = a[k + 1];
                k++;
                m++;
            }
            if (k + 1 > j || i > ii)
                break;


        }

        while (k + 1 <= j) {
            b[m] = a[k + 1];
            m++;
            k++;
        }


        while (i <= ii) {
            b[m] = a[i];
            i++;
            m++;
        }


        for (m = 0; m < b.length; m++) {
            a[index + m] = b[m];
        }

        return a;

    }


}
