package JavaCollectionsFramework2;


import java.io.IOException;
import java.rmi.RemoteException;

public class TryCatchLesson {

    public static void processExceptions() throws NoSuchFieldException {
        try {
            TryCatchLesson.method1();
            TryCatchLesson.method2();
            TryCatchLesson.method3();
        } catch (RemoteException e) {
            System.out.println("RemoteException");
        } catch (IOException e) {
            System.out.println("IOException");
            throw new NoSuchFieldException();
        } catch (NoSuchFieldException e) {
            System.out.println("NoSuchFieldException");
        }

    }

    public static void method1() throws IOException {
        throw new IOException();
    }

    public static void method2() throws NoSuchFieldException {
        throw new NoSuchFieldException();
    }

    public static void method3() throws RemoteException {
        throw new RemoteException();
    }


    public static void main(String[] args) {


        try {
            processExceptions();
        } catch (NoSuchFieldException e) {
            System.out.println("NoSuchFieldException");
        }

    }


}
