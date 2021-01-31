package com.chaoge.logic;

import com.chaoge.datadeal.StudentDatadeal;
import com.chaoge.person.Student;

import java.util.ArrayList;

/**
 * 学生信息管理 的业000务逻辑处理
 */
public class StudentLogic {
    //创建StudentDatadeal对象，向其发送数据
    private StudentDatadeal studentDatadeal=new StudentDatadeal();
    //创建ArrayList集合
    private ArrayList<Student> arrayList=new ArrayList<Student>();
    //添加学生的逻辑处理
    public int addStudent(Student student) {
        //判断集合是否为空，若不为空，则将集合清空
        if (!arrayList.isEmpty()){
            arrayList.clear();
        }
        //判断学生的id是否充符
        arrayList=studentDatadeal.showStudent();
        if (!arrayList.isEmpty()){
            for (Student stu:arrayList){
                if (stu.getId().equals(student.getId())){
                    return 1;//返回1代表id有重复
                }
            }
        }
        //判断年龄是否合理
        if (!(student.getAge()<=150&&student.getAge()>0)){
            return 2;
        }
        //判断成绩
        if (!(student.getScore()<=750&&student.getScore()>=0)){
            return 3;
        }
        studentDatadeal.addStudent(student);
        return 0;
    }

    //查看所有学生数据
    public ArrayList<Student> showStuent() {
        return studentDatadeal.showStudent();
    }
    //查找单个写生
    public Student showOneStudent(String id) {
        //判断集合是否为空，若不为空，则将集合清空
        if (!arrayList.isEmpty()){
            arrayList.clear();
        }
        //判断学生的id是否充符和
        arrayList=studentDatadeal.showStudent();
        if (!arrayList.isEmpty()){
            for (Student stu:arrayList){
                if (stu.getId().equals(id)){
                    return stu;//返回该学生对象
                }
            }
        }else {
            return null;//返回空值
        }
        return null;
    }

    //修改某个同学的信息
    public int alterStudent(String id, String name, char sex, int age, double score) {
        //查看是否有该学生
        if (showOneStudent(id)==null){
            return 1;
        }
        //判断集合是否为空，若不为空，则将集合清空
        if (!arrayList.isEmpty()){
            arrayList.clear();
        }
        //判断学生的id是否充符和
        arrayList=studentDatadeal.showStudent();
        //创建新集合
        ArrayList<Student> newArrayList=new ArrayList<Student>();
        if (!arrayList.isEmpty()){
            for (Student stu:arrayList){
                if (stu.getId().equals(id)){
                    stu.setName(name);
                    stu.setAge(age);
                    stu.setSex(sex);
                    stu.setScore(score);
                }
                newArrayList.add(stu);
            }
            return studentDatadeal.alteranddeleteStudent(newArrayList);
        }
        return 0;
    }

    //删除某个学生
    public int deleteStudent(String id) {
    //查看是否有该学生
        if (showOneStudent(id)==null){
            return 1;
        }
        //判断集合是否为空，若不为空，则将集合清空
        if (!arrayList.isEmpty()){
            arrayList.clear();
        }
        //判断学生的id是否充符和
        arrayList=studentDatadeal.showStudent();
        //创建新集合
        ArrayList<Student> newArrayList=new ArrayList<Student>();
        if (!arrayList.isEmpty()){
            for (Student stu:arrayList){
                if (!stu.getId().equals(id)){
                    newArrayList.add(stu);
                }
            }
            return studentDatadeal.alteranddeleteStudent(newArrayList);
        }
        return 0;
    }
}
