package almundo.callcenter.model;

public abstract class Empleado {
	
	private static int NUMERO_EMPLEADO = 0;
	private String nombre;
	private int idEmpleado;
	private int prioridad;
	private boolean ocupado;
	
	public Empleado(String nombre) {
		this.nombre = nombre;
		this.ocupado = false;
		NUMERO_EMPLEADO++;
		this.idEmpleado = NUMERO_EMPLEADO;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

}
