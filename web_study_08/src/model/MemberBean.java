package model;

public class MemberBean { // 아까 했던 DTO

	private String id;
	private String pass1;
	private String email;
	private String tel;
	private String hobby;
	private String job;
	private String age;
	private String info;

	public MemberBean(String id, String pass1, String email, String tel, String hobby, String job, String age,
			String info) {
		this.id = id;
		this.pass1 = pass1;
		this.email = email;
		this.tel = tel;
		this.hobby = hobby;
		this.job = job;
		this.age = age;
		this.info = info;
	}

	public MemberBean() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass1() {
		return pass1;
	}

	public void setPass1(String pass1) {
		this.pass1 = pass1;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}
