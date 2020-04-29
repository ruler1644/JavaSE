package chaptor02_grammar;

import java.util.Scanner;

//判断某一天是当年的第几天
public class Code04_DaysJuge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入年份：");
        int year = scanner.nextInt();
        System.out.print("请输入月份：");
        int month = scanner.nextInt();
        System.out.print("请输入日期：");
        int day = scanner.nextInt();

        int sum = 0;
        switch (month) {
            case 12:
                sum += 30;
            case 11:
                sum += 30;
            case 10:
                sum += 30;
            case 9:
                sum += 31;
            case 8:
                sum += 31;
            case 7:
                sum += 30;
            case 6:
                sum += 31;
            case 5:
                sum += 30;
            case 4:
                sum += 31;
            case 3:
                if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
                    sum += 29;
                } else {
                    sum += 28;
                }
            case 2:
                sum += 31;
            case 1:
                sum += day;
        }
        System.out.println(sum);
    }
}
