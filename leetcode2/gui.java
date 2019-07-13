package leetcode2;

import java.util.Stack;

public class gui {

    public static void main(String[] args) {

        int a[] = {3, 1, 5, 2, 7, 6, 4};
        System.out.println("**********");

        a = gui1(a, 0, a.length - 1);

        for (int i = 0; i < a.length; i++) {

            System.out.print(a[i] + "_");
        }

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
            if (a[i] < a[jj]) {
                b[m] = a[i];
                m++;
                i++;
            } else {
                b[m] = a[jj];
                jj++;
                m++;
            }
            if (jj > j || i > ii)
                break;

        }

        while (jj <= j) {
            b[m] = a[jj];
            m++;
            jj++;
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


    static int[] gui1(int a[], int i, int j) {
        Stack<String> stack = new Stack<>();
        stack.push(i + "," + j);
        while (stack.size() > 0) {
            String item = stack.pop();
            i = Integer.parseInt(item.split(",")[0]);
            j = Integer.parseInt(item.split(",")[1]);


            if (i >= j)
                continue;

            int k = (i + j) / 2;
            stack.push(i + "," + k);
            stack.push((k + 1) + "," + j);

            int index = i;


            int ii = k;
            int jj = k + 1;

            //合并有序数组
            int b[] = new int[j - i + 1];
            int m = 0;
            while (true) {
                if (a[i] < a[jj]) {
                    b[m] = a[i];
                    m++;
                    i++;
                } else {
                    b[m] = a[jj];
                    jj++;
                    m++;
                }
                if (jj > j || i > ii)
                    break;

            }

            while (jj <= j) {
                b[m] = a[jj];
                m++;
                jj++;
            }


            while (i <= ii) {
                b[m] = a[i];
                i++;
                m++;
            }


            for (m = 0; m < b.length; m++) {
                a[index + m] = b[m];
            }
            m = 0;


        }
        return a;
    }

}



