package com.chaoge.reception;

import com.chaoge.logic.StudentLogic;
import com.chaoge.person.Student;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class StudentMenu {
    //创建Scanner对象，使其所有数据能够通过键盘手动输入
    private Scanner scanner=new Scanner(System.in);
    //设置学生信息管理的菜单
    public StudentMenu(){
        //循环终止条件
        boolean loop=true;
        //设置菜单
        while (loop){
            System.out.println("============学生信息管理============");
            System.out.println("1.添加新的学生信息");
            System.out.println("2.查看所有的学生信息");
            System.out.println("3.某个学生详细信息");
            System.out.println("4.修改学生信息");
            System.out.println("5.删除学生信息");
            System.out.println("6.返回上一级菜单");
            System.out.println("7.退出程序");
            System.out.print("\n请选择:");
            switch (scanner.nextInt()){
                case 1:
                    addStudent();
                    break;
                case 2:
                    showStudent();
                    break;
                case 3:
                    showOneStudent();
                    break;
                case 4:
                    alterStudent();
                    break;
                case 5:
                    deleteStudent();
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

    //添加学生信息
    //创建StudentLogic对象，让其能够向其发送数据
    private StudentLogic studentLogic=new StudentLogic();
    public void addStudent(){
        System.out.println("---添加学生信息---");
        System.out.print("\n学生ID:");
        String id=scanner.next();
        System.out.print("\n学生姓名:");
        String name=scanner.next();
        System.out.print("\n性别:");
        char sex=scanner.next().charAt(0);
        System.out.print("\n年龄:");
        int age=scanner.nextInt();
        //添加时间
        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.print("\n总成绩成绩:");
        double score=scanner.nextDouble();
        //将数据发送到studentLogic中，进行逻辑判断
        int i=studentLogic.addStudent(new Student(id,name,sex,age,ft.format(dNow),score));
        //接收数据的判断
        switch (i){
            case 0:
                System.out.println("添加成功");
                break;
            case 1:
                System.out.println("id重复，请重新输入");
                addStudent();
                break;
            case 2:
                System.out.println("年龄不合理，请重新输入");
                addStudent();
                break;
            default:
                System.out.println("成绩输入不合理，请重新输入");
                addStudent();
                break;
        }
    }

    //查看所有学生数据
    public void showStudent() {
        ArrayList<Student> arrayList=studentLogic.showStuent();
        if (studentLogic.showStuent().isEmpty()){
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~学生详细信息~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("学生信息表为空，请先添加学生");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
        else {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~学生详细信息~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("学生编号---姓名---年龄---性别----成绩-----添加时间");
            for (Student student:arrayList){
                System.out.println(student.getId()+"---"+student.getName()+"---"+student.getAge()+"---"+student.getSex()+"---"+student.getScore()+"---"+student.getTimes());
            }
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
    }

    //查看单个学生
    public void showOneStudent(){
        System.out.print("\n要查找学生的id->");
        String id=scanner.next();
        Student student=studentLogic.showOneStudent(id);
        if (student==null){
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~单个学生信息~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("为找到该学生信息，请先添加学生");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }else {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~单个学生信息~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("学生编号---姓名---年龄---性别----成绩-----添加时间");
            System.out.println(student.getId()+"---"+student.getName()+"---"+student.getAge()+"---"+student.getSex()+"---"+student.getScore()+"---"+student.getTimes());
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        }
    }

    //修改某个学生信息
    public void alterStudent(){
        System.out.print("\n请输入需要修改学生的id->");
        String id=scanner.next();
        System.out.print("\n新的姓名->");
        String name=scanner.next();
        System.out.print("\n新的性别->");
        char sex=scanner.next().charAt(0);
        System.out.print("\n新的年龄->");
        int age=scanner.nextInt();
        System.out.print("\n新的总成绩成绩->");
        double score=scanner.nextDouble();
        int i=studentLogic.alterStudent(id,name,sex,age,score);
        if (i==1){
            System.out.println("<<<<<<<未查找到该同学信息，请核实>>>>>>>>");
            showStudent();
        }else {
            System.out.println("修改成功!!!!!!!!!");
        }
    }
    //删除学生
    public void deleteStudent(){
        System.out.print("\n请输入需要删除学生的id->");
        String id=scanner.next();
        int i=studentLogic.deleteStudent(id);
        if (i==1){
            System.out.println("<<<<<<<未查找到该同学信息，请核实>>>>>>>>");
            showStudent();
        }else {
            System.out.println("删除成功!!!!!!!!!");
        }
    }
}
