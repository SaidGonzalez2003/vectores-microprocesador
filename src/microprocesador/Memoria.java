/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package microprocesador;

/**
 *
 * @author Alan
 */
public class Memoria {
    
    /** direccionMaxima, es el máximo de registros en la memoria. */
    int direccionMaxima=20;
    /** vector, es el vector donde se almacenan los datos. */
    String[] vector=new String[direccionMaxima];
    
    public void enlaceCodigo(){
        // e=a+b+c+d
        this.escritura(0,  "000000000A07");  // a= (10,7)
        this.escritura(1,  "000000000503");  // b= (5,3)
        this.escritura(2,  "000000000B08");  // c= (11,8)
        this.escritura(3,  "000000000602");  // d= (6,2)
        this.escritura(4,  "000000000000");  // e   
        this.escritura(5,  "000000000000");  //     
        this.escritura(6,  "000000000000");  //       
        this.escritura(7,  "000000000000");
        this.escritura(8,  "000000000000");
        this.escritura(9,  "000000000000");
        this.escritura(10, "000100000001");  // a+b
        this.escritura(11, "000100010010");  // (a+b)+c
        this.escritura(12, "000100100011");  // (a+b+c)+d
        this.escritura(13, "001100110100");  // e
        this.escritura(14, "111100000000");  
        this.escritura(15, "000000000000");
    }
    
    /**
     * Este método ejecuta una operación de lectura sobre la memoria.
     * @param direccion, es la dirección de memoria que se quiere recuperar. 
     * @return regresa el valor almancenado en la dirección solicitada. 
     */
    public String lectura(int direccion){
        return this.vector[direccion];
    }
    
    /**
     * Este método ejecuta la operación escritura sobre la memoria de la computadora. 
     * @param direccion, es la dirección donde se va almacenar el dato
     * @param valor, es el valor del dato que se quiere almacenar. 
     */
    public void escritura(int direccion, String valor){
        this.vector[direccion]=valor;
        //System.out.println(valor);
    }
    
    
    public void muestraMemoria(){
        int i;
        String salida;
        for (i=0; i<this.direccionMaxima; i++){
            salida="["+i+"]="+this.vector[i];
            System.out.println(salida);
        }
    }
    
}
