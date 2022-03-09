package com.example.book.utils;

import com.example.book.pojo.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class WebUtils {
    //把map值注入到对应的javabean属性中，适用范围广，扩展性强，耦合度低
    public static <T> T copyParamToBean(Map map, T bean){

        try {
            BeanUtils.populate(bean, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
