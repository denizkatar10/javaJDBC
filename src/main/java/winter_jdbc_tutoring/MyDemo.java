package winter_jdbc_tutoring;

public class MyDemo {
	
	//To create POJO Class
	//1.Step: Create private variables per field
	private int demo_id;
	private String name_of_demo;
	private String demo_address;
	private String demo_code;
		
	//2.Step: Create constructor by using variables

	public MyDemo(int demo_id, String name_of_demo, String demo_address, String demo_code) {
		super();
		this.demo_id = demo_id;
		this.name_of_demo = name_of_demo;
		this.demo_address = demo_address;
		this.demo_code = demo_code;
	}

	//3.Step: Create all getters and setters
	public int getDemo_id() {
		return demo_id;
	}

	public void setDemo_id(int demo_id) {
		this.demo_id = demo_id;
	}

	public String getName_of_demo() {
		return name_of_demo;
	}

	public void setName_of_demo(String name_of_demo) {
		this.name_of_demo = name_of_demo;
	}

	public String getDemo_address() {
		return demo_address;
	}

	public void setDemo_address(String demo_address) {
		this.demo_address = demo_address;
	}

	public String getDemo_code() {
		return demo_code;
	}

	public void setDemo_code(String demo_code) {
		this.demo_code = demo_code;
	}

	//4.Step: Create toString() method
	@Override
	public String toString() {
		return "MyDemo [demo_id=" + demo_id + ", name_of_demo=" + name_of_demo + ", demo_address=" + demo_address
				+ ", demo_code=" + demo_code + "]";
	}
	
	
	

}
