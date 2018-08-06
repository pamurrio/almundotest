package almundo.callcenter.model;

public class Director extends Empleado {
	public Director(String name) {
		super(name);
		super.setPrioridad(10);
	}
	
	@Override
	public String toString() {
		return "Director [" + getNombre() +  "]";
	}
}
