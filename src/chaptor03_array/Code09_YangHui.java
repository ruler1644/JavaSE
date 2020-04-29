package chaptor03_array;
//打印杨辉三角形
public class Code09_YangHui {
    public static void main(String[] args) {

        //初始化数组并赋值
        int[][] arr = new int[10][];
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = new int[i + 1];
        }

        for (int i = 0; i < arr.length; ++i) {
            arr[i][0] = arr[i][i] = 1;
            for (int j = 0; j <= arr[i].length; ++j) {
                if (i > 1 && j > 0 && j < i) {
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                }
            }
        }

        //打印
        for (int i = 0; i < arr.length; ++i) {
            for (int j = 0; j <= i; ++j) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
