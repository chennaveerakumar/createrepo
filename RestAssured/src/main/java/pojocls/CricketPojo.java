package pojocls;

public class CricketPojo {
     String name;
     String location;
     String phone;
     String fitness[];
     
//	public CricketPojo() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public CricketPojo(String name, String location, String phone, String[] fitness) {
//		super();
//		this.name = name;
//		this.location = location;
//		this.phone = phone;
//		this.fitness = fitness;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String[] getFitness() {
		return fitness;
	}

	public void setFitness(String[] fit) {
		this.fitness = fit;
	}
     
     
}
