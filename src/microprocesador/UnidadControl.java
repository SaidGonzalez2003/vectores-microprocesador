/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package microprocesador;

/**
 *
 * @author Alan
 */
public class UnidadControl {
    String registroInstruccion=new String();
     /** es el registro que sabe la instrucción que se está ejecutando. */
     int contadorPrograma;
     /** esta variable es parte del decodificador y almacena la instrucción a ejecutarse. */
     String decodificarInstruccion=new String();
     /** esta variable es parte del decodificador y almacena la dirección del primer dato de la instruccion. */
     String decodificarDato1=new String();
     String decodificarDatoY1 = new String();
     /** esta variable es parte del decodificador y almacena la dirección del segundo dato de la instruccion. */
     String decodificarDatoX2=new String();
     String decodificarDato2 = new String();
     /** es la variable que contiene la dirección de donde se debe almacenar el resultado. */
     String decodificarResultado=new String();
    
     /**
      * Esta es el método constructor que se encarga de iniciar los atributos
      * de la clase. 
      */
    public  UnidadControl(){
        registroInstruccion="";
        contadorPrograma=0;
        decodificarInstruccion="";
        decodificarDato1="";
        decodificarDato2="";
        
        decodificarDatoX2="";
        decodificarDatoY1="";
        decodificarResultado="";
    }
    
    /**
     * Este método muestra el contenido de los atributos de la clase y las 
     * imprime en la línea de comandos. 
     */
    public void muestraUC(){
        System.out.println("Registro de Instruccion="+this.registroInstruccion);
        System.out.println("contadorPrograma="+this.contadorPrograma);
        System.out.println("decodificarInstruccion="+this.decodificarInstruccion);
        System.out.println("decodificarDato1="+this.decodificarDato1);
        System.out.println("decodificarDato2="+this.decodificarDato2);
        System.out.println("decodificarResultado="+this.decodificarResultado);
    }
    
    /**
     * Este método recupera la instrucción siguiente apuntada por el "contador
     * de programa" y lo pasa al registro de instrucción como lo indica la 
     * teoría del concepto de microprocesador. 
     */
     public void instructionFetch(){         
         microprocesador.MicroprocesadorVectores.UC.registroInstruccion=microprocesador.MicroprocesadorVectores.MEMORIA.lectura(this.contadorPrograma);
    }
     
     /**
      * Este método sirve para realizar las acciones del decodificador de instrucciones de la memoria. 
      */
    public void decode(){
        this.decodificarInstruccion=this.registroInstruccion.substring(0, 4);
        this.decodificarDato1=this.registroInstruccion.substring(4,8);
        this.decodificarDato2=this.registroInstruccion.substring(8,12);
        this.decodificarResultado=this.decodificarDato2;
        microprocesador.MicroprocesadorVectores.ALU.operacion=Integer.parseInt(this.decodificarInstruccion,16);
        microprocesador.MicroprocesadorVectores.ALU.banderas[0]=1;
    }
    
    /**
      * Este método recupera de memoria los datos necesarios para completar
      * la instrucción en funciones y los valores son pasados a la ALU para que
      * sean procesados. 
      */
     public void dataFetch(){
         int tmp;

        /* tmp= Integer.parseInt(this.decodificarDato1,2);
         microprocesador.MicroprocesadorVectores.ALU.registroEntradaX1=microprocesador.MicroprocesadorVectores.MEMORIA.lectura(tmp);
         microprocesador.MicroprocesadorVectores.ALU.banderas[1]=1;
                  
         tmp= Integer.parseInt(this.decodificarDato2,2);
         microprocesador.MicroprocesadorVectores.ALU.registroEntradaX2=microprocesador.MicroprocesadorVectores.MEMORIA.lectura(tmp);
         microprocesador.MicroprocesadorVectores.ALU.banderas[2]=1; */
         
         //tmp2
         
         
         tmp= Integer.parseInt(this.decodificarDato1,2);
         microprocesador.MicroprocesadorVectores.ALU.registroEntradaX1=microprocesador.MicroprocesadorVectores.MEMORIA.lectura(tmp).substring(8, 10);
         microprocesador.MicroprocesadorVectores.ALU.registroEntradaY1=microprocesador.MicroprocesadorVectores.MEMORIA.lectura(tmp).substring(10, 12);
         microprocesador.MicroprocesadorVectores.ALU.banderas[1]=1;
         System.out.println(microprocesador.MicroprocesadorVectores.MEMORIA.lectura(tmp));
         
         tmp= Integer.parseInt(this.decodificarDato2,2);
         System.out.println(tmp);
         
         microprocesador.MicroprocesadorVectores.ALU.registroEntradaX2=microprocesador.MicroprocesadorVectores.MEMORIA.lectura(tmp).substring(8, 10);
         microprocesador.MicroprocesadorVectores.ALU.registroEntradaY2=microprocesador.MicroprocesadorVectores.MEMORIA.lectura(tmp).substring(10, 12);
         microprocesador.MicroprocesadorVectores.ALU.banderas[2]=1;
     }
     
     public int execute(){
        int salida;
        salida=microprocesador.MicroprocesadorVectores.ALU.ejecutarInstruccion();
        return salida;
    }
     
     /**
     * Este método almacena el resultado de la ejecución de una instrucción en la memoria donde diga el Registro decodificador.
     */
    public void store(){
        String tmp = "00000000";
        int direccion;
        int datoX;
        int datoY;
        
        //System.out.println(microprocesador.MicroprocesadorVectores.ALU.acumulador);
        System.out.println("---> "+microprocesador.MicroprocesadorVectores.ALU.acumulador);
        
        
        String tmpX = microprocesador.MicroprocesadorVectores.ALU.acumulador.substring(1, 3);
        String tmpY = microprocesador.MicroprocesadorVectores.ALU.acumulador.substring(5,7);
        
        //System.out.println("X: " + tmpX + " Y: " + tmpY);
        
        //tmp= microprocesador.MicroprocesadorVectores.ALU.acumulador;
        datoX= Integer.parseInt(tmpX, 16);
        datoY=Integer.parseInt(tmpY, 16);
        
        direccion=Integer.parseInt(microprocesador.MicroprocesadorVectores.UC.decodificarResultado,10);
        
        tmp += tmpX + tmpY;
        
        
        microprocesador.MicroprocesadorVectores.MEMORIA.escritura(direccion, tmp);
        microprocesador.MicroprocesadorVectores.UC.contadorPrograma++;
    }
}
