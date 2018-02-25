package opower;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Home {
	
	private Integer id;
	private String name;
	private Person person;
	private Double size;
	private Integer pieces;
	
    private List<Device> Devices = new ArrayList<Device>();


    @Id
    @Column(name = "idHome")
    @GeneratedValue
	public Integer getId() {
		return id;
	}
    
	public Home() {
		super();
	}
	
	public Home(Double size, Integer pieces, String name) {
		this.name = name;
		this.size = size;
		this.pieces = pieces;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getTaille() {
		return size;
	}
	public void setTaille(Double taille) {
		this.size = taille;
	}
	public Integer getPieces() {
		return pieces;
	}
	public void setPieces(Integer pieces) {
		this.pieces = pieces;
	}
	@ManyToOne(optional=false)
	@JoinColumn(name="idPerson",referencedColumnName="idPerson")
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name="idHome", referencedColumnName = "idHome")	
	public List<Device> getDevice() {
		return Devices;
	}
	public void setDevice(List<Device> devices) {
		Devices = devices;
	
	}

}
