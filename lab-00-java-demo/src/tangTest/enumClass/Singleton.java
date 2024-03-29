package tangTest.enumClass;


/*
* 单例模式枚举
* */
public class Singleton {
    // 构造函数私有化，避免外部创建实例
    private Singleton() {

    }

    //定义一个内部枚举
    public enum SingletonEnum{

        SEED;  // 唯一一个枚举对象，我们称它为“种子选手”！

        private Singleton singleton;

        SingletonEnum(){
            singleton = new Singleton(); //真正的对象创建隐蔽在此！
        }

        public Singleton getInstance(){
            return singleton;
        }
    }

    // 故意外露的对象获取方法，也是外面获取实例的唯一入口
    public static Singleton getInstance(){
        return SingletonEnum.SEED.getInstance(); // 通过枚举的种子选手来完成
    }
}
