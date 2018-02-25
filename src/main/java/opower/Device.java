package opower;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Device {
    @Column(name = "idDevice")
    private long id;
    protected String name;
    protected String unit;

    public Device() {

        // TODO Auto-generated constructor stub
    }

    public Device(String name, String unit) {
        super();
        this.name = name;
        this.unit = unit;
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}