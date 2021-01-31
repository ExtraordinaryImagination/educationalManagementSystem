package com.chaoge.reception;

import com.chaoge.logic.TeacherLogic;
import com.chaoge.person.Teacher;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class TeacherMenu {
    //创建Scanner对象，使其所有数据能够通过键盘手动输入
    private Scanner scanner=new Scanner(System.in);
    //设置教师信息管理的菜单
    public TeacherMenu(){
        //循环终止条件
        boolean loop=true;
        //设置菜单
        while (loop){
            System.out.println("============教师信息管理============");
            System.out.println("1.添加新的教师信息");
            System.out.println("2.查看所有的教师信息");
            System.out.println("3.某个教师详细信息");
            System.out.println("4.修改教师信息");
            System.out.println("5.删除教师信息");
            System.out.println("6.返回上一级菜单");
            System.out.println("7.退出程序");
            System.out.print("\n请选择:");
            switch (scanner.nextInt()){
                case 1:
                    addTeacher();
                    break;
                case 2:
                    showTeacher();
                    break;
                case 3:
                    showOneTeacher();
                    break;
                case 4:
                    alterTeacher();
                    break;
                case 5:
                    deleteTeacher();
                    break;
                case 6:
                    loop=false;
                    break;
                case 7:
                    System.out.println("已退出");
                    System.exit(0);
                default:
                    System.out.println("请输入正确的编号!!!");
                    break;
            }
        }
    }

    //添加教师信息
    //创建StudentLogic对象，让其能够向其发送数据
    private TeacherLogic teacherLogic=new TeacherLogic();
    public void addTeacher(){
        System.out.println("---添加教师信息---");
        System.out.print("\n教师ID:");
        String id=scanner.next();
        System.out.print("\n教师姓名:");
        String name=scanner.next();
        System.out.print("\n性别:");
        char sex=scanner.next().charAt(0);
        System.out.print("\n年龄:");
        int age=scanner.nextInt();
        //添加时间
        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.print("\n工资:");
        double salary=scanner.nextDouble();
        //将数据发送到studentLogic中，进行逻辑判断
        int i=teacherLogic.addTeacher(new Teacher(id,name,sex,age,ft.format(dNow),salary));
        //接收数据的判断
        switch (i){
            case 0:
                System.out.println("添加成功");
                break;
            case 1:
                System.out.println("id重复，请重新输入");
                addTeacher();
                break;
            case 2:
                System.out.println("年龄不合理，请重新输入");
                addTeacher();
                break;
            default:
                System.out.println("工资输入不合理，请重新输入");
                addTeacher();
                break;
        }
    }

    //查看所有教师数据
    public void showTeacher() {
        ArrayList<Teacher> arrayList=teacherLogic.showTeacher();
        if (teacherLogic.showTeacher().isEmpty()){
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~教师详细信息~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("教师信息表为空，请先添加教师");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
        else {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~教师详细信息~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("教师编号---姓名---年龄---性别----工资----添加时间");
            for (Teacher teacher:arrayList){
                System.out.println(teacher.getId()+"---"+teacher.getName()+"---"+teacher.getAge()+"---"+teacher.getSex()+"---"+teacher.getSalary()+"---"+teacher.getTimes());
            }
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
    }

    //查看单个学生
    public void showOneTeacher(){
        System.out.print("\n要查找教师的id->");
        String id=scanner.next();
        Teacher teacher=teacherLogic.showOneTeacher(id);
        if (teacher==null){
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~单个教师信息~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("为找到该教师信息，请先添加教师");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }else {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~单个教师信息~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("教师编号---姓 名---年龄---性别----工资----添加时间");
            System.out.println(teacher.getId()+"---"+teacher.getName()+"---"+teacher.getAge()+"---"+teacher.getSex()+"---"+teacher.getSalary()+"---"+teacher.getTimes());
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        }
    }

    //修改某个教师信息
    public void alterTeacher(){
        System.out.print("\n请输入需要修改教师的id->");
        String id=scanner.next();
        System.out.print("\n新的姓名->");
        String name=scanner.next();
        System.out.print("\n新的性别->");
        char sex=scanner.next().charAt(0);
        System.out.print("\n新的年龄->");
        int age=scanner.nextInt();
        System.out.print("\n新的工字资->");
        double salary=scanner.nextDouble();
        int i=teacherLogic.alterTeacher(id,name,sex,age,salary);
        if (i==1){
            System.out.println("<<<<<<<未查找到该教师信息，请核实>>>>>>>>");
            showTeacher();
        }else {
            System.out.println("修改成功!!!!!!!!!");
        }
    }
    //删除学生
    public void deleteTeacher(){
        System.out.print("\n请输入需要删除教师的id->");
        String id=scanner.next();
        int i=teacherLogic.deleteTeacher(id);
        if (i==1){
            System.out.println("<<<<<<<未查找到该教师信息，请核实>>>>>>>>");
            showTeacher();
        }else {
            System.out.println("删除成功!!!!!!!!!");
        }
    }
}
