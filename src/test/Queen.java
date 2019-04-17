package test;

import java.util.Date;

public class Queen {
    private static int n = 12;
    private static int count = 0;
    public void putQueenAtRow(int[][] chess, int row){
        if(row==n){
            count++;
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    System.out.print(chess[i][j]+" ");
//                }
//                System.out.println();
//            }
            return;
        }
        int[][] chessTemp = chess.clone();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chessTemp[row][j] = 0;
            }
            chessTemp[row][i] = 1;
            if(check(chessTemp, row, i)){
                putQueenAtRow(chessTemp, row+1);
            }
        }
    }
    private boolean check(int[][] chess,int row, int i){
        for (int j = 0; j < row; j++) {
            if (chess[j][i]==1||i-row+j>=0&&chess[j][i-row+j]==1||i+row-j<n&&chess[j][i+row-j]==1){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Date start = new Date();
        int [][] chess = new int[n][n];
        Queen q = new Queen();
        q.putQueenAtRow(chess, 0);
        Date end = new Date();
        System.out.println(String.valueOf(end.getTime()-start.getTime())+"毫秒。有"+count+"种。");
    }
}
