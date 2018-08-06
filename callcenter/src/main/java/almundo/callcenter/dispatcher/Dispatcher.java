package almundo.callcenter.dispatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;

import almundo.callcenter.center.Llamar;
import almundo.callcenter.interfaces.Seleccionar;
import almundo.callcenter.model.Empleado;

public class Dispatcher {
	
	public static Integer LLAMADAS_EN_CURSO = 0;
	public static final int LLAMADAS_CONCURRENTES = 10;
	
	private Seleccionar seleccionar;
	private SortedSet<Empleado> empleados;
	private List<Thread> llamadasencurso;
	
	
	public Dispatcher(Seleccionar seleccionar, SortedSet<Empleado> empleados) {
		this.seleccionar = seleccionar;
		this.empleados = empleados;
		this.llamadasencurso = new ArrayList<Thread>();
	}
	
	public void dispatch(Llamar c) {
		Empleado empleadoselect = seleccionar.seleccion(empleados);
		if(empleadoselect != null) {
			synchronized (LLAMADAS_EN_CURSO) {
				if (LLAMADAS_EN_CURSO < LLAMADAS_CONCURRENTES) {
					c.asignarLlamada(empleadoselect);
					Thread llamadaencurso = new Thread(c);
					llamadaencurso.start();
					llamadasencurso.add(llamadaencurso);
				}else {
					System.err.println("No se aceptan mas llamadas concurrentes, llamdas en curso: " + LLAMADAS_EN_CURSO);
				}
			}		
		}else {
			System.out.println("No hay empleados libres!");
		}
	}
	
	public Seleccionar getSeleccionar() {
		return seleccionar;
	}

	public void setSeleccionar(Seleccionar seleccionar) {
		this.seleccionar = seleccionar;
	}

	public void releaseDispatcher() {
		try {
			for (Thread llamadaencurso : llamadasencurso) {
				llamadaencurso.join();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

/* Debe existir una clase Dispatcher encargada de manejar las
llamadas, y debe contener el método dispatchCall para que las
asigne a los empleados disponibles.

El método dispatchCall puede invocarse por varios hilos al mismo
tiempo.

La clase Dispatcher debe tener la capacidad de poder procesar 10
llamadas al mismo tiempo (de modo concurrente).

Cada llamada puede durar un tiempo aleatorio entre 5 y 10
segundos.

Debe tener un test unitario donde lleguen 10 llamadas. */

/*Extras/Plus

Dar alguna solución sobre qué pasa con una llamada cuando no hay
ningún empleado libre.

Dar alguna solución sobre qué pasa con una llamada cuando entran
más de 10 llamadas concurrentes.

Agregar los tests unitarios que se crean convenientes.

Agregar documentación de código*/