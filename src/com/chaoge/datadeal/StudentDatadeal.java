package com.chaoge.datadeal;

import com.chaoge.person.Student;

import java.io.*;
import java.util.ArrayList;

/**
 * 学生信息数据处理
 */
public class StudentDatadeal {
    //创建File文件对象
    File file=new File("educationalManagementSystem\\dataFile\\studentData.txt");
    //创建ArrayList集合
    private ArrayList<Student> arrayList=new ArrayList<Student>();

    //项数据文件添加学生
    public void addStudent(Student student){
        //创建FileOutputStream对象
        FileOutputStream fileOutputStream=null;
        //创建ObjectOutputStream对象
        ObjectOutputStream objectOutputStream=null;
        //添加异常处理机制
        try {
            fileOutputStream=new FileOutputStream(file,true);
            objectOutputStream=new ObjectOutputStream(fileOutputStream);
            //向文件中写入对象
            objectOutputStream.writeObject(student);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileOutputStream.close();
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //显示文件中所有数据
    public ArrayList<Student> showStudent(){
        try {
            //如果集合不为空，先要清楚集合中的数据
            if (!arrayList.isEmpty()){
                arrayList.clear();
            }
            //创建FileInputStream、ObjectInputStream将数据从文件中输入
            FileInputStream fileInputStream=null;
            ObjectInputStream objectInputStream=null;
            //添加异常处理机制
            try {
                fileInputStream =new FileInputStream(file);
                while (true){
                    objectInputStream=new ObjectInputStream(fileInputStream);
                    Student student= (Student) objectInputStream.readObject();
                    //将数据读入ArrayList集合中
                    arrayList.add(student);
                }
            } catch (FileNotFoundException e) {
            } catch (IOException e) {
            } catch (ClassNotFoundException e) {
            }finally {
                try {
                    fileInputStream.close();
                    objectInputStream.close();
                } catch (IOException e) {
                }
            }
        }catch (NullPointerException e){}
        return arrayList;
    }

    //将修改后的数据放入数据文件中（修改删除都用这一个方法）
    public int alteranddeleteStudent(ArrayList<Student> newArrayList) {
        //判断是否有文件
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            //清空文件内容
            FileWriter fileWriter=new FileWriter(file);
            fileWriter.write("");
            fileWriter.close();
            //遍历添加修改后的数据
            for (Student student:newArrayList){
                ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(file,true));
                objectOutputStream.writeObject(student);
                objectOutputStream.close();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
