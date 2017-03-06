public class Acceso
{
    private String ip;
    private int ano;
    private int mes;
    private int dia;
    private int hora;
    private int minutos;
    private String paginaWeb;
    private int codigoRespuesta;
    
    public Acceso(String lineaLeida)
    {
        String[] elementosLinea = lineaLeida.split(" ");
        ip = elementosLinea[0];
        ano = Integer.parseInt(elementosLinea[1].substring(1,5));
        mes = Integer.parseInt(elementosLinea[2]);
        dia = Integer.parseInt(elementosLinea[3]);
        hora = Integer.parseInt(elementosLinea[4]);
        minutos = Integer.parseInt(elementosLinea[5].substring(0,2));
        paginaWeb = elementosLinea[6];
        codigoRespuesta = Integer.parseInt(elementosLinea[7]);
    }
    
    public int getAno() 
    {
        return ano;
    }
    
    public int getMes()
    {
        return mes;
    }
    
    public int getDia()
    {
        return dia;
    }
    
    public int getHora()
    {
        return hora;
    }
    
    public int getMinutos()
    {
        return minutos;
    }
    
    public String getPaginaWeb(){
        return paginaWeb;
    }
}