package utn.frd.action;

import utn.frd.bean.Persona;
import db.PersistentManager;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;

public class PersonaAction extends ActionSupport{
	
	private String name;
	private String age;
	private String gender;
	private List<Persona> personas;
	private long id;
	
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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	
	public String save(){
		personas = PersistentManager.getInstance();
		int edad = 0;

		try{
			edad = Integer.parseInt(age);
		}catch(Exception e){
			addActionError("Ocurrió un error con la edad");
			return "ERROR";
		}

		new Persona(personas.size(), name, edad, gender);
		
		return "SUCCESS";
	}
}
