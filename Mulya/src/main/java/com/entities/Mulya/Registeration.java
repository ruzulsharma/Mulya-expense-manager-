package com.entities.Mulya;

import javax.persistence.*;

@Entity
@Table(name = "Registerations")
public class Registeration {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int regid;
	
    @Column(unique = true)
    private String Registerationname;
    
    private String password;

    //Getter Setter Method
    public int getregId() {
		return regid;
	}

	public void setregId(int regid) {		
		this.regid = regid;
	}

	public String getRegisterationname() {
		return Registerationname;
	}

	public void setRegisterationname(String Registerationname) {
		this.Registerationname = Registerationname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



    // Constructors, getters, setters, and other methods
	public Registeration(int id,String Registerationname, String password) {
		super();
		this.regid = regid;
		this.Registerationname = Registerationname;
		this.password = password;
	}
	
	public Registeration() {
		super();
	}
}


