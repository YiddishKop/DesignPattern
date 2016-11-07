package typeinfo;

public class Position {
	// 该职位的名字和任职人
	private String title;
	private Person person;
	
	public Position(String jobTitle, Person employee) {
		title = jobTitle;
		person = employee;
		if (person == null) {
			person = Person.NULL;
		}
	}
	
	public Position(String jobTitle) {
		title = jobTitle;
		person = Person.NULL;
	}
	
	public String getTitle() {return title;}
	public void setTitile(String newTitle) {
		title = newTitle;
	}
	public Person getPerson() {return person;}
	public void setPerson(Person newPerson) {
		person = newPerson;
		if (person == null) {
			person = Person.NULL;
		}
	}
	public String toString() {
		return "Position: " + title + " " + person;
	}
	

}
