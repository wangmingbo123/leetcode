package leetcode2;

import java.util.Scanner;

/**
 * Created by wy on 2017/6/14.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int len=0;
        while (n>=10){
              int data=1;
              while (n/10!=0){

              data=n%10*data;
                  n=n/10;
              }
              n=data*(n%10);
              len++;
        }
        System.out.println(len);
    }
}
