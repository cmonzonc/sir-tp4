package opower;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

public class Friendship {

	private Person person;
	private Long id;
	
	
	public Friendship() {
		super();
	}
	public Friendship(Long id) {
		this.id = id;
	}
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}	
	
}
