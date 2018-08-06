package almundo.callcenter.center;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

import almundo.callcenter.dispatcher.Dispatcher;
import almundo.callcenter.model.Empleado;

public class CentroLlamada {
	private SortedSet<Empleado> empleados;
	private Dispatcher dispatcher;
	
	
	public CentroLlamada() {
		super();		
		Comparator<Empleado> comp = new Comparator<Empleado>() {

			public int compare(Empleado o1, Empleado o2) {
					int prio = o1.getPrioridad()-o2.getPrioridad();
				return prio == 0 ?  o1.getIdEmpleado()-o2.getIdEmpleado() : prio;
			}
		};
		this.empleados = new TreeSet<Empleado>(comp);
		this.dispatcher = new Dispatcher(new SeleccionPrioridad(),empleados);		
	}

	public void startCallCenter() {
		//...
	}
	
	public void addEmpleado(Empleado e) {
		empleados.add(e);
	}
	
	public void pararCentroLlamada() {
		//...
		dispatcher.releaseDispatcher();
		System.out.println("llamdas en curso: " + Dispatcher.LLAMADAS_EN_CURSO);
	}
	
	public void incomingCall(Llamar llamar) {
		dispatcher.dispatch(llamar);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.empleados.toString();
	}
}
