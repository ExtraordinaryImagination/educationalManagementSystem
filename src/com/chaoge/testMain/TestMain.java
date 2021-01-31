package com.chaoge.testMain;

import com.chaoge.reception.SignIn;
import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {
        //创建Scanner对象，使其所有数据能够通过键盘手动输入
        Scanner scanner=new Scanner(System.in);
        //创建SignIn对象
        SignIn signIn= new SignIn();
        //登录显示及处理页面
        while (true){
            System.out.println("------------欢迎来到教务系统，请先登录------------");
            System.out.println("1.登录");
            System.out.println("2.注册");
            System.out.println("3.退出");
            System.out.print("请输入选择:");
            switch (scanner.nextInt()){
                case 1:
                    signIn.login();
                    break;
                case 2:
                    signIn.sigin();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("请输入正确的编号");
                    break;
            }
        }
    }
}
