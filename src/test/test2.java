package test;

import java.util.Scanner;

/**
* @Description:    输入的第一行为一个单独的整数n (n<=20)表示单词数，
 *                 以下n 行每行有一个单词，输入的最后一行为一个单个字符，表示“龙”开头的字母。
 *                 你可以假定以此字母开头的“龙”一定存在.
* @Author:         zdq
* @Create:     2019/4/10 10:02
* @Version:        1.0
*/
public class test2 {

    public int length=0;
    public String []str=new String[30];
    public int using[]=new int[30];
    public int n;
    public int repeat(String arr,String brr){
        int min=0;
        if(arr.length()<brr.length()){
            min=arr.length();
        }
        else{
            min=brr.length();
        }
        for(int i = 0 ; i < min ; i++ ){
            int flag=1;
            for(int j = 0; j <= i; j++){
                if(arr.charAt(arr.length() -1- i + j) != brr.charAt(j)) {
                    flag = 0;
                }
            }
            if(flag==1) return i+1;
        }
        return 0;
    }
    public void process(String arr,int lengthnow){
        if(length<lengthnow){
            length=lengthnow;
        }
        for(int i = 0; i < n; i++) {
            if(using[i] >= 2) continue;
            int c = repeat(arr, str[i]);
            if(c > 0) {
                using[i]++;
                process(str[i], lengthnow + str[i].length() - c);
                using[i]--;
            }
        }

    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        test2 java=new test2();
        java.n=s.nextInt();
        for(int i=0;i< java.n;i++){
            java.str[i]=s.next();
            java.using[i]=0;
        }
        String tou=new String(s.next());
        java.process(tou,tou.length());
        System.out.println(java.length);
    }
}
