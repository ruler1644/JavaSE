package chaptor02_grammar;

//交换两个变量的值(三种方法)
public class Code02_ChangeNum {
    public static void main(String[] args) {
        int a = 12;
        int b = 5;

        /*//临时变量法
        int temp = a;
        a = b;
        b = temp;*/

       /* //两数相加法
        a = a + b;
        b = a - b;
        a = a - b;*/

        //按位异或法
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println(a + "\t" + b);
    }
}
