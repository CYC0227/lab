package yc.lab.woo;

public class SingletonRepository {

    private static final SingletonRepository instance = new SingletonRepository();

    private SingletonRepository(){

    }

    public static SingletonRepository getInstance(){
        return instance;
    }
}
