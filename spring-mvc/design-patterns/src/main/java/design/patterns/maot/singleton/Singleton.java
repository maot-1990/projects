package design.patterns.maot.singleton;

/**
 * 单列模式
 * @author maot
 *
 */
public class Singleton {

	private static Singleton instance = null;
	
	/**
	 * 私有方法，防止被实例化
	 */
	private Singleton(){}
	
	/**
	 * 线程不安全
	 * @return
	 */
	public static Singleton getInstance(){
		if(instance == null){
			instance = new Singleton();
		}
		return instance;
	}
	
	/**
	 * 线程安全,性能低
	 * 但是，synchronized关键字锁住的是这个对象，这样的用法，
	 * 在性能上会有所下降，因为每次调用getInstance()，
	 * 都要对对象上锁，事实上，只有在第一次创建对象的时候需要加锁，之后就不需要了
	 * @return
	 */
	public static synchronized Singleton getInstanceSafe(){
		if(instance == null){
			instance = new Singleton();
		}
		return instance;
	}
	
	//高性能,高安全性的单列模式,将单列和初始化分开
	public static Singleton getSingleton(){
		if(instance == null){
			init2();
		}
		return instance;
	}
	
	public synchronized static void init(){
		if(instance == null){
			instance = new Singleton();
		}
	}
	
	public static void init2(){
		synchronized(Singleton.class){
			if(instance == null){
				instance = new Singleton();
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(Singleton.getSingleton());
	}
	
}
