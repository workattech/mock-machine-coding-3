package models;

public class User {
	private String id;
	private String name;
	private String email;
	
	public User(String id,String name,String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	public String getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	@Override
	public String toString() {
		return "{ id : "+id+", name : "+name+", email : "+email+" }";
	}
	
	@Override
	public boolean equals(Object user) {
		if(user == this) {
			return true;
		}
		
		if(!(user instanceof User)) {
			return false;
		}
		
		return this.getEmail().equals(((User)user).getEmail());
	}
	
	@Override
	public int hashCode() {
		return this.email.hashCode();
	}
}
