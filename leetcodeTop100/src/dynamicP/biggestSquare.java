package dynamicP;

import java.util.Arrays;

public class biggestSquare {
    public static void main(String[] args){
        char[][] matrix = new char[][]{{'0','1','1','1'},
                                        {'1','1','0','1'},
                                        {'1','1','1','1'}
                                        };

        //System.out.println(Arrays.deepToString(matrix));
        for(char[] mat:matrix){
            System.out.println(mat);
        }
        //求矩形的话，我觉得应该便利三遍数组，, 每一行，每一列，并记录连续。最后一次根据连续dp
        rectangle(matrix);

        //square(matrix);

    }
    public static void square(char[][] matrix){
        int row = matrix.length;
        int col = matrix[0].length;
        //int[][] dp = new int[row][col];
        int[] dp1 = new int[col];
        int[] dp2 = new int[col];
        int line = 0;
        //while(i<row && Arrays.asList(matrix[i++]).contains('1'));
        for(int j=0;j<col;j++)
            if(matrix[0][j]=='1'){
                dp1[j] = 1;
                line += 1;
            }

        for(int i =1;i<row;i++){
            if(matrix[i][0] == '1') {
                dp2[0] = 1;
                line+=1;
            }
            System.out.println();
            for(int j = 1;j<col;j++){
                if(matrix[i][j] == '0') continue;
                dp2[j] = Math.min(Math.min(dp1[j-1],dp1[j]),dp2[j-1])+1;
                if(i == 3)
                    System.out.println(dp2[j] +" "+dp1[j-1]+" " +dp2[j-1]+" "+line);
                line += dp2[j];
                System.out.println("count="+ line);
            }
            int[] tem = dp1;
            dp1 = dp2;
            dp2 = tem;
            Arrays.fill(dp2,0);
        }
        System.out.println(line);
    }
    public static void rectangle(char[][] matrix){
        int row = matrix.length;
        int col = matrix[0].length;
        //int[][] dp = new int[row][col];
        int[][][] dp = new int[row][col][2];
        //dp[][][0] row
        //dp[][][1] col
        int count = 0;
        //while(i<row && Arrays.asList(matrix[i++]).contains('1'));
        for(int j=0;j<col;j++)
            if(matrix[0][j]=='1'){
                dp[0][j][0] = dp[0][j-1][0]+1;
                dp[0][j][1] = 1;
                count += dp[0][j][0];
            }
        System.out.println(count);
        for(int i =1;i<row;i++){
            if(matrix[i][0] == '1') {
                dp[i][0][0] = 1;
                dp[i][0][1] = dp[i-1][0][1] + 1;
                count += dp[i][0][1];
            }
            System.out.println();
            for(int j = 1;j<col;j++){
                if(matrix[i][j] == '0') continue;
                 dp[i][j][0] = Math.min(dp[i-1][j-1][0],dp[i][j-1][0])+1;
                 dp[i][j][1] = Math.min(dp[i-1][j-1][1],dp[i-1][j][0])+1;
                 count = dp[i][j][0] * dp[i][j][1]+count+dp[i][j-1][0]+dp[i-1][j][1];
                System.out.println(count+" "+dp[i][j-1][0]+""+dp[i-1][j][1]);
            }

        }
        System.out.println(count);
    }
}
