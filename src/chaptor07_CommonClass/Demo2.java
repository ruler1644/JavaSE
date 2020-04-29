 package chaptor07_CommonClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo2 {
  public static void main(String []args) {
    int num=getTimes("abckcababa","ab");
    System.out.println(num);
    System.out.println();
    
    String s1=getMaxSubString("abcwerthello1yuiodef","abcwercvhello1bnm");
    System.out.println(s1);
    
    List<String> al=getMaxSubString2("abcwerthelloyuiodef","abcwecvhellobnm");
    System.out.println(al);
  }
  //4获取两个字符串最大相同字串
  public static List<String> getMaxSubString2(String str1,String str2) {
    String maxStr=(str1.length()>str2.length())?str1:str2;
    String minStr=(str1.length()<str2.length())?str1:str2;
    int len=minStr.length();
    List<String> list= new ArrayList<String>();
    for(int i=0;i<len;i++) {
      for(int x=0,y=len-i;y<=len;x++,y++) {
        String str=minStr.substring(x, y);
        if(maxStr.contains(str)) {
          list.add(str);
        }
      }
      if(list.size()!=0) {
        return list;
      }
    } 
    return null;
  }
  
  //4获取两个字符串最大相同字串
  public static String getMaxSubString(String str1,String str2) {
    String maxStr=(str1.length()>str2.length())?str1:str2;
    String minStr=(str1.length()<str2.length())?str1:str2;
    int len=minStr.length();
    for(int i=0;i<len;i++) {
      for(int x=0,y=len-i;y<=len;x++,y++) {
        String str=minStr.substring(x, y);
        if(maxStr.contains(str)) {
          return str;
        }
      }
    }
    
    return null;
  }
  
  
  //3str2在str1中出现次数ab-->abkkcadkabkebfkabkskab
  public static int getTimes(String str1,String str2) {
    int count=0;
    int index;
    while((index = str1.indexOf(str2))!=-1) {
      count++;
      str1=str1.substring(index+str2.length());
    }
    return count;
  }
}
