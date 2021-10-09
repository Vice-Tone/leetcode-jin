
/**
 * @author ：jin
 * @description: 单例模式-双重检查
 * @date ：Created in 2021/3/5 13:29
 */
public class Singleton {


    /**
     * 饿汉式
     */
    static class StarveSingleton {

        private static final StarveSingleton instance = new StarveSingleton();

        private StarveSingleton() {
        }

        public static StarveSingleton getInstance() {
            return instance;
        }
    }

    /**
     * 懒汉式
     */
    static class LazySingleton {

        private static LazySingleton instance;

        private LazySingleton() {
        }

        public static synchronized LazySingleton getInstance() {
            if (instance == null) {
                instance = new LazySingleton();
            }
            return instance;
        }
    }


    /**
     * 双重检查
     */
    static class DoubleCheckSingleton {

        private static volatile DoubleCheckSingleton instance;

        private DoubleCheckSingleton() {
        }

        public static DoubleCheckSingleton getInstance() {
            if (instance == null) {
                synchronized (DoubleCheckSingleton.class) {
                    if (instance == null) {
                        instance = new DoubleCheckSingleton();
                    }
                }
            }
            return instance;
        }
    }

    /**
     * 静态内部类
     */
    static class InnerClassSingleton {

        private InnerClassSingleton() {
        }

        private static class SingletonHolder {
            private static final InnerClassSingleton instance = new InnerClassSingleton();
        }

        public static InnerClassSingleton getInstance() {
            return SingletonHolder.instance;
        }
    }


    /**
     * 枚举
     */
    public enum EnumSingleton {

        INSTANCE;

        public void doSomething() {
            System.out.println("doSomething");
        }
    }

}
