package money;

public class BankDTO {
	private String id;		//아이디
	private String name;	//이름
	private int age;		//나이
	private String tel;		//전화번호
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	@Override
	public String toString() {
		return "[아이디:" + id + " / 이름:" + name + " / 나이:" + age + " / 전화번호:" + tel + "]";
	}	
}
