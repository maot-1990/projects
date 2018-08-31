package test;

/**
 * 泛型
 * @author maot
 *
 * @param <T>
 */
public class MyTest<T> {

	private T data;
	
	public MyTest(T data){
		this.data = data;
	}
	
	
	
	public T getData() {
		return data;
	}



	public void setData(T data) {
		this.data = data;
	}



	public static void main(String[] args) {
		System.out.println(new MyTest<MyTest>(new MyTest<String>("data")).getData().getData());
	}
}
