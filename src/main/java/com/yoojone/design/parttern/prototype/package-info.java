/**
 *
 * 原型模式
 *  是一种对象创建型模式，通过原型实例执行创建对象的中类，并采用 copy 原型实例的方法来创建新的对象。
 *  所有原型模式创建的实例，具有与原型实例一样的数据
 *
 *  原型模式的创建
 *      原型模式主要用于对象的复制
 *      1. 实现Cloneable接口。在java语言有一个Cloneable接口，它的作用只有一个，就是在运行时通知虚拟机可以安全地
 *      在实现了此接口的类上使用clone方法。在java虚拟机中，只有实现了这个接口的类才可以被拷贝，否则在运行时会抛出
 *      CloneNotSupportedException异常
 *
 *      2.重写Object类中的clone方法。Java中，所有类的父类都是Object类，Object类中有一个clone方法，
 *      作用是返回对象的一个拷贝，但是其作用域protected类型的，一般的类无法调用，因此，Prototype类需
 *      重写clone方法并将的方法的作用域修改为public类型

 *  原型模式是一种比较简单的模式，也非常容易理解，实现一个接口，重写一个方法即完成了原型模式。
 *  在实际应用中，原型模式很少单独出现，经常与其他模式混用，他的原型类Prototype也常用抽象类来替代
 *
 *
 *  原型模式的表现形式：
 *      1.简单形式
 *      2.登记形式
 *
 *   https://blog.csdn.net/pengjunlee/article/details/51484227
 */
package com.yoojone.design.parttern.prototype;