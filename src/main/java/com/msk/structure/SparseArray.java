package com.msk.structure;

/**
 * 稀疏数组
 * 以围棋为例
 * 1代表黑子，2代表白子
 */
public class SparseArray {

    public static void main(String[] args) {
        //初始化一个棋盘二维数组
        int[][] chessArray = initArray();
        System.out.println("初始化的原始数组---------------");
        print(chessArray);
        //转为稀疏数组
        int[][] sparseArray = toSparseArray(chessArray);
        System.out.println("稀疏数组---------------");
        print(sparseArray);
        //回复原始数组
        int[][] newChessArray = toChessArray(sparseArray);
        System.out.println("还原的原始数组---------------");
        print(newChessArray);
    }

    /**
     * 初始化一个原始二维数据
     */
    public static int[][] initArray() {
        int[][] chessArray = new int[11][12];
        chessArray[1][3] = 1;//黑子位置
        chessArray[2][4] = 2;//白子位置
        return chessArray;
    }

    /**
     * 把正常的二维数据转成稀疏数组
     * @param chessArray
     * @return
     */
    public static int[][] toSparseArray(int[][] chessArray) {

        //遍历获取二维数组中总共有多少个数据
        int sum = 0;
        for (int[] row : chessArray) {
            for (int val : row) {
                if (0 != val) {
                    sum++;
                }
            }
        }
        //创建一个稀疏数组 每行有三个元素，第一个为行号，第二个为列号，第三个为值
        int[][] sparesArray = new int[sum+1][3];
        //初始化稀疏数组的第一行
        int rowNum = chessArray.length;
        int colNum = chessArray[0].length;
        //第一行第一列为原二维数组的行数
        sparesArray[0][0] = rowNum;
        //第一行第二列为原二维数组的列数
        sparesArray[0][1] = colNum;
        //第一行第三列为原二维数组的有效元素总个数
        sparesArray[0][2] = sum;
        //二维数组转稀疏数组
        //记录稀疏数组行数
        int sparesRowNum = 0;
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                if (chessArray[i][j] != 0) {
                    sparesRowNum++;
                    sparesArray[sparesRowNum][0] = i;
                    sparesArray[sparesRowNum][1] = j;
                    sparesArray[sparesRowNum][2] = chessArray[i][j];
                }
            }
        }
        return sparesArray;
    }

    /**
     * 把稀疏数组还原成正常的二维数据
     * @param sparseArray
     * @return
     */
    public static int[][] toChessArray(int[][] sparseArray) {
        //还原行列总数
        int[] initData = sparseArray[0];
        int[][] chessArray = new int[initData[0]][initData[1]];
        //填充原始数据
        for (int i = 1; i < sparseArray.length; i++) {
            int[] rowData = sparseArray[i];
            chessArray[i][rowData[1]] = rowData[2];
        }
        return chessArray;
    }

    /**
     * 打印数据内容
     */
    public static void print(int[][] chessArray) {
        for (int[] row : chessArray) {
            for (int val : row) {
                System.out.printf("%d  ", val);
            }
            System.out.println();
        }
    }
}
