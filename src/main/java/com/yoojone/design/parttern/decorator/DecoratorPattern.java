package com.yoojone.design.parttern.decorator;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

/**
 * @author yuqiang.zhang
 * @date 2021/9/15
 * description: 装饰者模式
 * 对目标类的功能进行增强
 *
 * （1） 装饰对象和真实对象有相同的接口。
 *
 * （2） 装饰对象包含一个真实对象的引用（reference）
 *
 * （3） 装饰对象接受所有的来自客户端的请求。它把这些请求转发给真实的对象。
 *
 * （4） 装饰对象可以在转发这些请求以前或以后增加一些附加功能。这样就确保了在运行时，不用修改给定对象的结构就可以在外部增加附加的功能。

 *
 * （1）比如java的io体系，可以一层包装一层，一层包装一层，外面的一层，都会对立面的一层进行功能的增强。
 *    new BufferedReader(new InputStreamReader(new FileInputStream("")));
 *
 * （2）还有就是spring的aop，aop这块可以基于动态代理的理念，装饰我们的目标对象，然后加入事务控制，
 *  日志打印之类的功能。
 *
 *  public interface UserService {
 *
 *     void save(User user);
 *
 * }
 * @Transactional
 * public class UserServiceImpl implements UserService {
 *
 *     public void save(User user) {
 *         // 执行插数据库的操作
 *     }
 *
 * }
 * // spring aop
 * public class UserServiceImplProxy implements UserSerivce {
 *
 *     private UserSerivce userService;
 *
 *     public void save(User user) {
 *         // 执行操作之前打开事务
 *         connection.startTransaction();
 *         // 执行目标的功能
 *         userService.save(user);
 *         // 执行完之后提交事务
 *         connection.commitTransaction();
 *     }
 *
 * }
 */
public class DecoratorPattern {

    public static void main(String[] args) {
        Component component = new ConcreteComponentComponent();


        Decorator decorator = new Decorator(component) ;

        decorator.execute();

    }

    public interface Component {
        void execute();
    }

    public static class ConcreteComponentComponent implements Component {

        @Override
        public void execute() {

            /*try {
                new BufferedReader(new InputStreamReader(new FileInputStream("")));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }*/
            System.out.println("执行基础功能");
        }
    }


    public static class Decorator implements Component {

        private Component component;

        public Decorator(Component component) {
            this.component = component;
        }

        @Override
        public void execute() {
            System.out.println("之前，部分功能增强");

            component.execute();

            System.out.println("之后，部分功能增强");
        }
    }

}
