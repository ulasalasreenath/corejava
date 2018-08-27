package designpatterns;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static java.lang.Class.forName;

public class SingletonTest {

    public static void main(String[] args)  {
        Singleton instance = Singleton.getInstance();

        /*
            cannot access private constructor, so cannot create one more instance
            Singleton instance2 = new Singleton();
        */

        /**
         *         The below code will throw a run time exception
         *
         *         Class aClass = Class.forName("designpatterns.Singleton");
         *         Constructor<Singleton> constructor = aClass.getDeclaredConstructor();
         *         constructor.setAccessible(true);
         *         Singleton newInstance = constructor.newInstance();
         *
         *         System.out.println(instance);
         *         System.out.println(newInstance);
         */


        /**
         *
         *          The below code will throw CloneNotSupportedException, since clone() method will throw an exception
         *          if an instance is already created
         *
         *          try {
         *              Singleton instance2 = (Singleton) instance.clone();
         *              System.out.println(instance);
         *              System.out.println(instance2);
         *          } catch (CloneNotSupportedException e) {
         *              e.printStackTrace();
         *          }
         *
         */

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("instance.ser"));
            oos.writeObject(instance);

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("instance.ser"));
            Singleton instance2 = (Singleton) ois.readObject();

            System.out.println(instance);
            System.out.println(instance2);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
