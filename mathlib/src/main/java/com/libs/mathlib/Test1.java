package com.libs.mathlib;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description:
 * @Author: 肖邦
 * @CreateDate: 2021/8/19 4:33 PM
 */
public class Test1 {

  public static void main(String[] args) {
    String[] s={"2","1","+","3","*"};
    int i = evalRPN(s);
    System.out.println(i);
  }
  public static int evalRPN(String[] tokens) {
    Stack<Integer> stack =  new Stack<>();
    int length = tokens.length;
    for(int i=0;i<length;i++){
      String c = tokens[i];

      if(isNum(c)==true){
        int ch=Integer.parseInt(c);
        stack.push(ch);
      }else{
        int num1=stack.pop();
        int num2=stack.pop();
        if(c=="+"){
          stack.push(num1+num2);
        }else if(c=="-"){
          stack.push(num1-num2);
        }else if(c=="*"){
          stack.push(num1*num2);
        }else if(c=="/"){
          stack.push(num1/num2);
        }
      }
    }
    return stack.pop();

  }

  public static boolean isNum(String c){

    return !("+".equals(c)||"-".equals(c)||"*".equals(c)||"/".equals(c));
  }
}
