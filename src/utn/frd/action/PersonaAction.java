package utn.frd.action;

import utn.frd.bean.Persona;
import db.PersistentManager;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;

public class PersonaAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String age;
	private String gender;
	private List<Persona> personas;
	private long id;
	private static long contador;
	Persona p;
	
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
			return ERROR;
		}

		if (personas.size()==0) {
			id = 1;
			contador = 1;
			p = new Persona(id, name, edad, gender);
			PersistentManager.getInstance().add(p);
		}
		else {
			id = id + 1;
			contador = contador + 1;
			p = new Persona(contador, name, edad, gender);
			PersistentManager.getInstance().add(p);
		}
		
		return SUCCESS;
	}
	
	public String execute(){
		personas = PersistentManager.getInstance();
		
		return SUCCESS;
	}
	public String delete(){
		personas = PersistentManager.getInstance();
		personas.removeIf(p->p.getId()==id);
		return SUCCESS;
}

	public String modify(){
		personas = PersistentManager.getInstance();
		Persona persona = personas.stream().filter(p->p.getId()==id).findFirst().get();
		id = persona.getId();
		name = persona.getName();
		gender = persona.getGender();
		age = String.valueOf(persona.getAge());
		return SUCCESS;
}
}
