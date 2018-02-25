package opower;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("Heater")
public class Heater extends Device {
    private String nameHeater;
    private Integer power;
    private String locationHome;
    private Home home;

    public Heater() {
        super();
    }

    public Heater(String name, Integer power, String unit, String locationHome) {
        super();
        this.nameHeater = name;
        this.locationHome = locationHome;
        this.power = power;
        this.unit = unit;

        // this.home = home;
    }

    @ManyToOne(optional = true)
    @JoinColumn(
        name = "idHome",
        referencedColumnName = "idHome"
    )
    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    public String getLocationHome() {
        return locationHome;
    }

    public void setLocationHome(String locationHome) {
        this.locationHome = locationHome;
    }

    public String getNameHeater() {
        return nameHeater;
    }

    public void setNameHeater(String nameHeater) {
        this.nameHeater = nameHeater;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
