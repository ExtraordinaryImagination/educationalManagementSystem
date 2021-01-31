package com.chaoge.reception;

import java.util.Scanner;

/**
 * 主菜单栏:
 */
public class MainMenu {
    //创建Scanner对象，使其所有数据能够通过键盘手动输入
    private Scanner scanner=new Scanner(System.in);
    //菜单栏
    public MainMenu(){
        //设定退出
        boolean loop=true;
        //设置主菜单
        while (loop){
            System.out.println("<<<<<<<<<<<<教务系统<<<<<<<<<<<<");
            System.out.println("1.学生信息管理");
            System.out.println("2.教师信息管理");
            System.out.println("3.返回上一级菜单");
            System.out.println("4.退出程序");
            System.out.print("请选择:");
            switch (scanner.nextInt()){
                case 1:
                    //创建StudentMenu对象，进入学生信息管理界面
                    new StudentMenu();
                    break;
                case 2:
                    new TeacherMenu();
                    break;
                case 3:
                    loop=false;
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("请输入正确的编号!!!!!!");
                    break;
            }
        }

    }
}
