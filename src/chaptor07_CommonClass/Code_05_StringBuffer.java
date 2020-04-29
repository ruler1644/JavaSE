package chaptor07_CommonClass;

public class Code_05_StringBuffer {
    public static void main(String[] args) {
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);  //appendNull添加四个字符

        /**
         * private AbstractStringBuilder appendNull() {
         *         int c = count;
         *         ensureCapacityInternal(c + 4);
         *         final char[] value = this.value;
         *         value[c++] = 'n';
         *         value[c++] = 'u';
         *         value[c++] = 'l';
         *         value[c++] = 'l';
         *         count = c;
         *         return this;
         *     }
         */

        System.out.println(sb.length());            //4
        System.out.println(sb);                     //字符串"null"

        StringBuffer sb1 = new StringBuffer(str);   //抛异常，NullPointerException
        /**
         * 构造器中调用方法时，产生空指针
         * public StringBuffer(String str) {
         *         super(str.length() + 16);
         *         append(str);
         *     }
         */
        System.out.println(sb1);

    }
}
