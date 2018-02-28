package opower;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@NamedQueries(
@NamedQuery(name="home.find.all", query="select h from Home h")
)
@XmlRootElement

public class Home {
    private List<Device> Devices = new ArrayList<Device>();
    private Integer id;
    private String name;
    private Person person;
    private Double size;
    private Integer pieces;

    public Home() {
        super();
    }

    public Home(Double size, Integer pieces, String name) {
        this.name = name;
        this.size = size;
        this.pieces = pieces;
    }

    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
    @JoinColumn(
        name = "idHome",
        referencedColumnName = "idHome"
    )
    public List<Device> getDevice() {
        return Devices;
    }

    public void setDevice(List<Device> devices) {
        Devices = devices;
    }

    @Id
    @Column(name = "idHome")
    @GeneratedValue
    public Integer getId() {
        return id;
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

    @ManyToOne(optional = false, fetch=FetchType.LAZY)
    @JoinColumn(
        name = "idPerson",
        referencedColumnName = "idPerson"
    )
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Integer getPieces() {
        return pieces;
    }

    public void setPieces(Integer pieces) {
        this.pieces = pieces;
    }

    public Double getTaille() {
        return size;
    }

    public void setTaille(Double taille) {
        this.size = taille;
    }
}
