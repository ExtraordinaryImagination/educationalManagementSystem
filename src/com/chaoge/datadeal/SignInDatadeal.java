package com.chaoge.datadeal;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/**
 * 注册登录数据处理类
 */
public class SignInDatadeal {
    private Properties properties=new Properties();
    //注册数据处理
    public void sigin(String userName, String passWord) {
        //判断集合是否为空
        if (!properties.isEmpty()){
            properties.clear();
        }
        //将数据放入集合
        properties.put(userName,passWord);
        //创建FileOutputStream对象
        FileOutputStream fileOutputStream=null;
       try {
           //创建FileOutputStream对象
           fileOutputStream=new FileOutputStream("educationalManagementSystem\\dataFile\\signin.properties",true);
           //利用store()方法将数据放入文件
           properties.store(fileOutputStream,"用户名密码");
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }finally {
           try {
               fileOutputStream.close();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
    }


    //登录查看账号密码
    public Properties showSignin(){
        //判断proerties集合是否为空
        if (!properties.isEmpty()){
            properties.clear();
        }
        //创建FileInputStream对象
        FileInputStream fileInputStream=null;

        try {
            fileInputStream=new FileInputStream("educationalManagementSystem\\dataFile\\signin.properties");
            //将FileInputStream读取到的数据放入集合中
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
