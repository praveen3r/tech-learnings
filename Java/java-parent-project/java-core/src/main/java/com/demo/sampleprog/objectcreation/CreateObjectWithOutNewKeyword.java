package com.demo.sampleprog.objectcreation;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CreateObjectWithOutNewKeyword {

    public CreateObjectWithOutNewKeyword() {
        System.out.println("I am a CreateObjectWithOutNewKeyword Object. ");
    }

    public static void main(String str[]) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        //TODO : Way 1
        Student student = new Student();

        //TODO : Way 2
        Class ref = Class.forName("common.objectcreation.Student");
        Student obj00 = (Student) ref.newInstance();

        Student obj01 = Student.class.newInstance();
        // System.out.println("Way 1 :-"+ obj);


        //TODO :Way3
        Student obj1 = new Student();
        // System.out.println(obj1);
        try {
            Student obj2 = (Student) obj1.clone();
            // System.out.println(obj2);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        //TODO: Way4
        Student obj_ = null;
        try {
            obj_ = (Student) new CreateObjectWithOutNewKeyword().getClass()
                    .getClassLoader().loadClass("common.objectcreation.Student").newInstance();
            // Fully qualified classname should be used.
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(obj_);

        //TODO : Way5

        Constructor<Student> constructor = null;
        try {
            constructor = Student.class.getConstructor();
            Student emp3 = constructor.newInstance();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //TODO : Way6
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream("common.objectcreation.Student"));
            Student emp5 = (Student) in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


class Student implements Cloneable {
    Student() {
        System.out.println("I am a Student Object. ");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "I am a Student Object + toString()";
    }
}