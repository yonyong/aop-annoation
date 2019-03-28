package com.cn.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface SecureValid {
	String desc() default "身份和安全验证开始...";
}

/**
@Target 用于描述注解的使用范围（即：被描述的注解可以用在什么地方），其取值有：
CONSTRUCTOR 用于描述构造器（领盒饭）。
FIELD 用于描述域（领盒饭）。
LOCAL_VARIABLE 用于描述局部变量（领盒饭）。
METHOD 用于描述方法。
PACKAGE 用于描述包（领盒饭）。
PARAMETER 用于描述参数。
TYPE 用于描述类或接口（甚至 enum ）

@Retention 用于描述注解的生命周期（即：被描述的注解在什么范围内有效），其取值有：
SOURCE 在源文件中有效（即源文件保留，领盒饭）。
CLASS 在 class 文件中有效（即 class 保留，领盒饭）。
RUNTIME 在运行时有效（即运行时保留）。

@Documented 在默认的情况下javadoc命令不会将我们的annotation生成再doc中去的，所以使用该标记就是告诉jdk让它也将annotation生成到doc中去
@Inherited 比如有一个类A，在他上面有一个标记annotation，那么A的子类B是否不用再次标记annotation就可以继承得到呢，答案是肯定的

Annotation属性值 有以下三种： 基本类型、数组类型、枚举类型 

1：基本串类型 

public @interface UserdefinedAnnotation {  
    int value();  
    String name();  
    String address();  
}
使用：
@UserdefinedAnnotation(value=123,name="wangwenjun",address="火星")  
    public static void main(String[] args) {  
        System.out.println("hello");  
    }  
}

2：数组类型 
我们在自定义annotation中定义一个数组类型的属性，代码如下：
public @interface UserdefinedAnnotation {  
    int[] arr();  
}  
使用：  
public class UseAnnotation {  
      
    @UserdefinedAnnotation(arr={123，234})  
    public static void main(String[] args) {  
        System.out.println("hello");  
    }  
} 

3：枚举类型 

public enum DateEnum {  
    Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday  
}  
然后在定义一个annotation  
public @interface UserdefinedAnnotation {  
    DateEnum week();  
}  
使用： 
public class UseAnnotation {  
    @UserdefinedAnnotation(week=DateEnum.Sunday)  
    public static void main(String[] args) {  
        System.out.println("hello");  
    }  
}  

4：默认值
public @interface UserdefinedAnnotation {  
    String name() default "zhangsan";  
}  
使用：  
public class UseAnnotation {  
    @UserdefinedAnnotation()  
    public static void main(String[] args) {  
        System.out.println("hello");  
    }  
}  



*/