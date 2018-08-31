package design.patterns.maot.builder;

public class Animal {

	private String name;
	private String age;
	private String city;
	
	/**
	 * 成员内部类
	 * 成员内部类可以无条件访问外部类的所有成员属性和成员方法（包括private成员和静态成员）。
	 * @author maot
	 *
	 */
	public static class Builder{
		
		private String name;
		private String age;
		private String city;
		
		public Builder(){}
		
		public Builder name(String name){
			this.name=name;
			return this;
		}
		
		public Builder age(String age){
			this.age=age;
			return this;
		}
		
		public Builder city(String city){
			this.city=city;
			return this;
		}
		
		public Animal build(){
			return new Animal(this);
		}
		
	}
	
	public Animal(Builder builder){
		this.name = builder.name;
		this.age = builder.age;
		this.city = builder.city;
		
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + ", age=" + age + ", city=" + city + "]";
	}
	
	public static void main(String[] args) {
		Animal animal = new Animal.Builder().age("12").name("mao").city("bj").build();
		System.out.println(animal.toString());
	}
}
