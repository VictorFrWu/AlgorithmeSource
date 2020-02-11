package Calypso;

/**
 * @author mac
 *
 *         1.class is single inherit, but interface is multi inherit
 *
 *         2.如何解决java多继承问题 为了完全理解如何解决Java的多重继承问题，有一个经典的问题需要描述如下：
 * 
 *         有类动物，它有子类鸟和马，现在需要制作一个从飞鸟和马延伸的类Pegasus，因为飞马座既是鸟又是马。
 * 
 *         解决这个问题的经典方法是制作Animal，Bird和Horse类接口并从中实现Pegasus。
 * 
 *         使用接口构造继承层次结构，在有用时使用抽象类，在需要时实现具体类，并在适当时使用委托。
 */

/*
 * public class Bird implements Avialae { }
 * public class Horse implements Equidae {}
 * public class Pegasus implements Avialae, Equidae {} public abstract class
 * AbstractHorse implements Equidae {} public class Horse extends AbstractHorse
 * {} public class Pegasus extends AbstractHorse implements Avialae {}
 */

public class ClassInterface {

}
