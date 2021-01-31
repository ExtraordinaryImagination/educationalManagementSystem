package com.chaoge.logic;

import com.chaoge.datadeal.SignInDatadeal;

import java.util.Properties;
import java.util.Set;

/**
 * 注册登录逻辑
 */
public class SignInLogic {
    private SignInDatadeal signInDatadeal=new SignInDatadeal();

    //注册的业务逻辑
    public int sigin(String userName, String passWord) {
        //调用sigInDatadeal对象中的showSignin()方法
        //遍历集合，查找是否有重复的用户名
        Set<String> set=signInDatadeal.showSignin().stringPropertyNames();
        for (String str:set){
            if (str.equals(userName)){
                return 0;
            }
        }
        //若没有直接将数据添加的数据文件中
        signInDatadeal.sigin(userName,passWord);
        return 1;
    }

    public int loginLogic(String userName, String passWord) {
        //调用sigInDatadeal对象中的showSignin()方法
        //查看是否有改组用户名及密码
        Properties properties=signInDatadeal.showSignin();
        Set<String> set=properties.stringPropertyNames();
        for (String str:set){
            if (str.equals(userName)&&properties.getProperty(str).equals(passWord)){
                return 1;
            }
        }
        return 0;
    }
}
