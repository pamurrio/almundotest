package almundo.callcenter.center;

import java.util.SortedSet;

import almundo.callcenter.interfaces.Seleccionar;
import almundo.callcenter.model.Empleado;

public class SeleccionPrioridad implements Seleccionar { 
	
		public Empleado seleccion(SortedSet<Empleado> empleados) {
			/* Metodo que busca los empleados de prio 1 o 2 o 3 en ese orden. 
			 * El Set se asume ordenado por prioridad. Solo debo encontrar el primero libre.
			 */
			Empleado empleadoSeleccionado = null;
			
			for (Empleado employee : empleados) {
				if(!employee.isOcupado()) {
					empleadoSeleccionado = employee;
				}
			}
			
			return empleadoSeleccionado;
		}
}
