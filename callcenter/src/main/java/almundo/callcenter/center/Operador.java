package almundo.callcenter.center;

import almundo.callcenter.model.Empleado;

public class Operador extends Empleado {

	public Operador(String name) {
		super(name);		
		super.setPrioridad(10);
	}
	
	@Override
	public String toString() {
		return "Operador [" + getNombre() +  "]";
	}
}
