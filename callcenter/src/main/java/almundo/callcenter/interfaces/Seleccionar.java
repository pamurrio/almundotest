package almundo.callcenter.interfaces;

import java.util.SortedSet;

import almundo.callcenter.model.Empleado;

public interface Seleccionar {
	Empleado seleccion (SortedSet<Empleado> empleados);

}
