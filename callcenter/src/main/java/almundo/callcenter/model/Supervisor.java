package almundo.callcenter.model;

public class Supervisor extends Empleado {
	public Supervisor(String name) {
		super(name);		
		super.setPrioridad(5);
	}
	
	@Override
	public String toString() {
		return "Supervisor [" + this.getNombre() +  "]";
	}
}
