package com.chaoge.reception;

import com.chaoge.logic.SignInLogic;

import java.util.Scanner;

/**
 * 注册处理
 */
public class SignIn {
    //创建对象signInLogic,将数据传到逻辑处理部分
    private SignInLogic signInLogic=new SignInLogic();
    //创建Scanner对象，使其所有数据能够通过键盘手动输入
    Scanner scanner=new Scanner(System.in);

    //注册方法
    public void sigin(){
        System.out.println("------注册页面------");
        System.out.print("\n用户名->");
        String userName=scanner.next();
        System.out.print("\n新密码->");
        String passWord=scanner.next();
        System.out.print("\n确认密码->");
        String certainPass=scanner.next();
        if (passWord.equals(certainPass)){
            //调用signInLogic对象中的方法，会有一个int的返回值。
            // 若返回0则说明数据文件中已存在该账号
            //若返回1，则注册成功
            int i=signInLogic.sigin(userName,passWord);
            if(i==0){
                System.out.println("！！！用户名重复，请重新输入！！！");
                sigin();
            }else {
                System.out.println("注册成功");
            }
        }else {
            System.out.println("两次密码输入有误，请重新输入!!!!!!!!!!!");
        }

    }


    //登录方法
    public void login(){
        System.out.println("------登录界面------");
        System.out.print("用户名:");
        String userName=scanner.next();
        System.out.print("\n密码:");
        String passWord=scanner.next();
        int i=signInLogic.loginLogic(userName,passWord);
        if (i==1){
            new MainMenu();
        }else {
            System.out.println("登录失败，用户名或密码不正确");
        }
    }
}
