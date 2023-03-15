package yc.lab.woo;

public class SingletonService {

    private final SingletonRepository singletonRepository;

    private static final SingletonService instance = new SingletonService();

    private SingletonService(){
        singletonRepository = SingletonRepository.getInstance();
    }

    public static SingletonService getInstance(){
        return instance;
    }

    public void helloWorld(){
        System.out.println("hello world");
    }
}
