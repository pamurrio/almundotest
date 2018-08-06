package almundo.callcenter;

import org.junit.Test;

import almundo.callcenter.center.CentroLlamada;
import almundo.callcenter.center.Llamar;
import almundo.callcenter.center.Operador;
import almundo.callcenter.dispatcher.Dispatcher;
import almundo.callcenter.model.Director;
import almundo.callcenter.model.Empleado;
import almundo.callcenter.model.Supervisor;

/**
 * Unit test for simple App.
 */
public class AppTest {
	private void testNCalls(int cantidadLLamadas, int cantidadEmpleados)
    {
    	CentroLlamada cll = new CentroLlamada();
    	
    	for (int i = 0; i < (cantidadEmpleados)/2; i++) {
    		Empleado op = new Operador("Operador_"+i);    		    		
    		cll.addEmpleado(op);    		    		
    	}
    	
    	for (int i = 0; i < (cantidadEmpleados-cantidadEmpleados/2)-1; i++) {    		
    		Empleado sup = new Supervisor("Supervisor_"+i);    		    		
    		cll.addEmpleado(sup);    		
    	}
    	Empleado dir = new Director("Director");
    	cll.addEmpleado(dir);
    	
    	System.out.println("---- Lista de empleados en orden de prioridad ----");
    	System.out.println(cll.toString());
    	System.out.println("");
    	
    	cll.startCallCenter();
    	
    	for (int i = 0; i < cantidadLLamadas; i++) {
    		Llamar ll = new Llamar();
    		cll.incomingCall(ll);
    	}
    	
    	System.out.println("\n-------------- no mas llamadas entrantes ------------------\n");
    	
    	cll.pararCentroLlamada();
    	
    	assert(Dispatcher.LLAMADAS_EN_CURSO == 0);
    }
    
    /**
     * Test con exactamente 10 llamadas y exactamente 10 empleados 
     */
   @Test
    public void pruebaDiezLlamadas() {
	   System.out.println("PruebaDiezLlamadas");
    	testNCalls(10,10);
    }
    
    /**
     * Test con mas de 10 llamadas y exactamente 10 empleados 
     */
   @Test
    public void pruebaMasDiezLlamadas() {
	   System.out.println("testMorethanTenCalls");
    	testNCalls(15,10);
    }
    
    /**
     * Test con menos de 10 llamadas y menos de 10 empleados 
     */
   @Test
    public void pruebaMenosDiezLlamadas() {
	   System.out.println("pruebaMenosDiezLlamadas");
    	testNCalls(5,10);
    }
    
    /**
     * Test con exactamente 10 llamadas y sin suficintes empleados
     */
   @Test
    public void pruebaDiezLlamadasNoEmpleadosLibre() {
	   System.out.println("pruebaDiezLlamadasNoEmpleadosLibre");
    	testNCalls(10,8);
    }
    
    /**
     * Test con mas de 15 llamadas y exactamente 15 empleados 
     */
   @Test
    public void pruebaMasDiezLlamadasYEmpleados(){
	   System.out.println("pruebaMasDiezLlamadasYEmpleados");
    	testNCalls(15,15);
    }
}
