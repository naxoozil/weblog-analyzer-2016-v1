import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AnalizadorAccesosAServidor
{
    private ArrayList<Acceso> accesos;
    
    
    public AnalizadorAccesosAServidor() 
    {
        accesos = new ArrayList<>();
    }
    
    
    public void analizarArchivoDeLog(String archivo)
    {
        accesos.clear();
        File archivoALeer = new File(archivo);
        try {
            Scanner sc = new Scanner(archivoALeer);
            while (sc.hasNextLine()) {
                String lineaLeida = sc.nextLine();               
                Acceso accesoActual = new Acceso(lineaLeida);
                
                accesos.add(accesoActual);
            }
            sc.close();
        }
        catch (Exception e) {
            System.out.println("Ocurrio algun error al leer el archivo.");
        }
    }
    
    
    public int obtenerHoraMasAccesos() 
    {
        int valorADevolver = -1;
        
        if (!accesos.isEmpty()) {
            int[] accesosPorHora = new int[24];
    
            for (Acceso accesoActual : accesos) {
                int horaAccesoActual = accesoActual.getHora();
                accesosPorHora[horaAccesoActual] = accesosPorHora[horaAccesoActual] + 1;
            }
            
            int numeroDeAccesosMasAlto = accesosPorHora[0];
            int horaDeAccesosMasAlto = 0;
            for (int i = 0; i < accesosPorHora.length; i++) {
                if (accesosPorHora[i] >= numeroDeAccesosMasAlto) {
                    numeroDeAccesosMasAlto = accesosPorHora[i];
                    horaDeAccesosMasAlto = i;
                }
            }
            
            valorADevolver = horaDeAccesosMasAlto;                      
        }
        
        return valorADevolver;
    }
    
    public String paginaWebMasSolicitada() 
    {
        String paginaADevolver = null;
        Map<String, Integer> nombreMap = new HashMap<String,Integer>();
        if (!accesos.isEmpty()) {
            for (Acceso accesoActual : accesos){
                if(nombreMap.containsKey(accesoActual.getPaginaWeb()) != true){
                    nombreMap.put(accesoActual.getPaginaWeb(), 1);
                }
                else{
                    nombreMap.put(accesoActual.getPaginaWeb(), nombreMap.get(accesoActual.getPaginaWeb() + 1));
                }
            }
            
        }
        return paginaADevolver;
    }
    
    public String clienteConMasAccesosExitosos()
    {
        return "";
    }


}
