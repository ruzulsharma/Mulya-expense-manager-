package com.entities.Mulya;

import javax.persistence.*;

@Entity
@Table(name = "registrations")
public class Registeration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int regid;

    @Column(unique = true)
    private String registrationName;

    private String password;

    // Constructors
    public Registeration() {}

    public Registeration(int regid, String registrationName, String password) {
        this.regid = regid;
        this.registrationName = registrationName;
        this.password = password;
    }

    // Getters and setters
    public int getRegid() {
        return regid;
    }

    public void setRegid(int regid) {
        this.regid = regid;
    }

    public String getRegistrationName() {
        return registrationName;
    }

    public void setRegistrationName(String registrationName) {
        this.registrationName = registrationName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public void setRegisterationname(String regname) {
		// TODO Auto-generated method stub
		
	}
}
