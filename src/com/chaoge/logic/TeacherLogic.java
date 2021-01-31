package com.chaoge.logic;

import com.chaoge.datadeal.TeacherDatadeal;
import com.chaoge.person.Teacher;

import java.util.ArrayList;

public class TeacherLogic {
    //创建TeacherDatadeal对象，向其发送数据
    private TeacherDatadeal teacherDatadeal=new TeacherDatadeal();
    //创建ArrayList集合
    private ArrayList<Teacher> arrayList=new ArrayList<Teacher>();
    //添加学生的逻辑处理
    public int addTeacher(Teacher teacher) {
        //判断集合是否为空，若不为空，则将集合清空
        if (!arrayList.isEmpty()){
            arrayList.clear();
        }
        //判断教师的id是否充符
        arrayList=teacherDatadeal.showTeacher();
        if (!arrayList.isEmpty()){
            for (Teacher teach:arrayList){
                if (teacher.getId().equals(teach.getId())){
                    return 1;//返回1代表id有重复
                }
            }
        }
        //判断年龄是否合理
        if (!(teacher.getAge()<=150&&teacher.getAge()>0)){
            return 2;
        }
        //判断工资
        if (!(teacher.getSalary()>=0)){
            return 3;
        }
        teacherDatadeal.addTeacher(teacher);
        return 0;
    }

    //查看所有教师数据
    public ArrayList<Teacher> showTeacher() {
        return teacherDatadeal.showTeacher();
    }
    //查找单个教师
    public Teacher showOneTeacher(String id) {
        //判断集合是否为空，若不为空，则将集合清空
        if (!arrayList.isEmpty()){
            arrayList.clear();
        }
        //判断教师的id是否充符和
        arrayList=teacherDatadeal.showTeacher();
        if (!arrayList.isEmpty()){
            for (Teacher teach:arrayList){
                if (teach.getId().equals(id)){
                    return teach;//返回该学生对象
                }
            }
        }else {
            return null;//返回空值
        }
        return null;
    }

    //修改某个教师的信息
    public int alterTeacher(String id, String name, char sex, int age, double salary) {
        //查看是否有该教师
        if (showOneTeacher(id)==null){
            return 1;
        }
        //判断集合是否为空，若不为空，则将集合清空
        if (!arrayList.isEmpty()){
            arrayList.clear();
        }
        //判断教师的id是否充符和
        arrayList=teacherDatadeal.showTeacher();
        //创建新集合
        ArrayList<Teacher> newArrayList=new ArrayList<Teacher>();
        if (!arrayList.isEmpty()){
            for (Teacher teach:arrayList){
                if (teach.getId().equals(id)){
                    teach.setName(name);
                    teach.setAge(age);
                    teach.setSex(sex);
                    teach.setSalary(salary);
                }
                newArrayList.add(teach);
            }
            return teacherDatadeal.alteranddeleteTeacher(newArrayList);
        }
        return 0;
    }

    //删除某个教师
    public int deleteTeacher(String id) {
        //查看是否有该教师
        if (showOneTeacher(id)==null){
            return 1;
        }
        //判断集合是否为空，若不为空，则将集合清空
        if (!arrayList.isEmpty()){
            arrayList.clear();
        }
        //判断教师的id是否充符和
        arrayList=teacherDatadeal.showTeacher();
        //创建新集合
        ArrayList<Teacher> newArrayList=new ArrayList<Teacher>();
        if (!arrayList.isEmpty()){
            for (Teacher teach:arrayList){
                if (!teach.getId().equals(id)){
                    newArrayList.add(teach);
                }
            }
            return teacherDatadeal.alteranddeleteTeacher(newArrayList);
        }
        return 0;
    }
}
