/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package microprocesador;

/**
 *
 * @author Alan
 */
public class ALU {
    
    /** operacion, muestra la operación que está en ejecución. Esta operación 
     * está ya en número decimal. 
     */
    int operacion;
    /** registroEntrada1, es el registro de entrada 1 de la ALU. */
    String registroEntradaX1;
    String registroEntradaY1;
    /** registroEntrada1, es el registro de entrada 2 de la ALU. */
    String registroEntradaX2;
    String registroEntradaY2;
    /** acumulador, es el registro donde se almacena el resultado de la operación
     * recién ejecutada. 
     */
    String acumulador;
    /** banderas, es el vector que almacenan las banderas del sistema, los valores son:
     * 0-InstruccionLista, 1-Dato1Listo, 2-Dato2Listo, 3-ResultadoListo
     */
    int[] banderas=new int[5];
    
    /**
     * este método constructor es para iniciar los atributos de la clase. 
     */
    public ALU(){
        acumulador="0";
        operacion=0;
        registroEntradaX1="";
        registroEntradaX2="";
        registroEntradaY1="";
        registroEntradaY2="";
    }
    
    public void muestraALU(){
        System.out.println("operacion="+this.operacion);
        System.out.println("registroEntradaX1="+this.registroEntradaX1);
        System.out.println("registroEntradaX2="+this.registroEntradaX2);
        System.out.println("registroEntradaY1="+this.registroEntradaY1);
        System.out.println("registroEntradaY2="+this.registroEntradaY2);
        System.out.println("acumulador="+this.acumulador);
        System.out.println("Banderas="+this.banderas[0]+","+this.banderas[1]+","+this.banderas[2]+","+this.banderas[3]);
    }
    
    /**
     * Es una de las operaciones de la ALU. La operación es la SUMA de los elementos. 
     * @param a, es el primero valor de la operación.
     * @param b, es el segundo valor de la operación.
     * @return regresa el valor de la suma de los elementos.
     */
    public String suma (String X1, String Y1, String X2, String Y2){
        int tmpX1=Integer.parseInt(X1,16);
        int tmpX2=Integer.parseInt(X2,16);
        
        int tmpY1=Integer.parseInt(X2,16);
        int tmpY2=Integer.parseInt(X2,16);
        
        int resX = tmpX1 + tmpX2;
        int resY = tmpY1 + tmpY2;
        
        return "(" + 
                String.format("%02X",  Integer.parseInt(String.valueOf(resX), 10))
                + ", " + 
                String.format("%02X",  Integer.parseInt(String.valueOf(resY), 10)) + 
                ")";
        
    }
    
    public int ejecutarInstruccion(){
        int salida=0;
        
        switch(this.operacion){
            case 1:
                this.acumulador=this.suma(
                        this.registroEntradaX1, 
                        this.registroEntradaY2,
                        this.registroEntradaX2, 
                        this.registroEntradaY2);
                
                this.banderas[3]=1;
                salida=0;
                break;
            /*case 2:
                this.acumulador=this.multiplicacion(this.registroEntrada1, this.registroEntrada2);
                this.banderas[3]=1;
                salida=0;
                break;
            case 3:
                this.acumulador=this.mover();
                this.banderas[3]=1;
                salida=0;
                break;*/
            case 15:
                salida=1;
                break;
        }
        return salida;
    }
    
}
