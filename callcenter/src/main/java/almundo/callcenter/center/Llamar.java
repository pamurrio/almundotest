package almundo.callcenter.center;

import almundo.callcenter.dispatcher.Dispatcher;
import almundo.callcenter.model.Empleado;

public class Llamar implements Runnable{

	private Empleado empleado;
	public static final int MIN_DURATION = 5;
	public static final int MAX_DURATION = 10;
			
	
	private void finLlamada() {
		Dispatcher.LLAMADAS_EN_CURSO--;
		System.out.println("llamada de " + empleado.toString() + " termino " + " [llamadas en curso: " + Dispatcher.LLAMADAS_EN_CURSO + "]");
		empleado.setOcupado(false);
		empleado = null;
	}
	
	public void asignarLlamada(Empleado e) {
		empleado = e;
		empleado.setOcupado(true);
		Dispatcher.LLAMADAS_EN_CURSO++;
		System.out.println("llamada de " + empleado.toString() + " [llamadas en curso: " + Dispatcher.LLAMADAS_EN_CURSO + "]");
	}
	
	public boolean empleadoAsignado() {
		return empleado != null;
	}

	public void run() {
		if(empleadoAsignado()) {
			try {
				Thread.sleep((int)((Math.random()*(Llamar.MAX_DURATION-Llamar.MIN_DURATION)+Llamar.MIN_DURATION) * 1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.finLlamada();
			
		} else {
			System.err.println("llamada no asignada!");
		}
	}

}
