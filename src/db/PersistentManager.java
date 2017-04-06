package db;
import java.util.List;
import java.util.ArrayList;
import utn.frd.bean.Persona;

public class PersistentManager {
	
	private static List<Persona> data = new ArrayList<Persona>();
	
	public static List<Persona> getInstance(){
		return data;
	}
}
