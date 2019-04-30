/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;
import descuentos.Descuentos;
import java.util.Scanner;
/**
 *
 * @author Juan Pablo
 */
public class CalcularMatricula {
    public static void main(String[] args) {
        //declaramos todas las variables a usar
        String lugar;
        int edad;
        int estadoCivil;
        int cargasFamiliares;
        int descuento = 0;
        double descuentoFinal;
        int MatriculaInicial = 1330;
        double MatriculaFinal;
        double aumentoMatricula;
        
        //Creamos el objeto Scanner para poder pedir informacion desde teclado
        Scanner entrada = new Scanner(System.in);

        /*pedimos todos los valores al usuario desde teclaod y los almacenamos 
        * en sus respectivas variables
        */
        System.out.println("Cual es su Lugar de residencia?");
        lugar = entrada.nextLine();
        System.out.println("Cual es su Edad");
        edad = entrada.nextInt();
        System.out.println("Cual es su esatdo civil\n1.- Soltero\n2.- Casado");
        estadoCivil = entrada.nextInt();
        System.out.println("Cuantas cargas familiares tiene usted}'");
        cargasFamiliares = entrada.nextInt();


        //validarmos el lugar de residencia para aplicar el descuento
        if(lugar.equalsIgnoreCase("loja") || lugar.equalsIgnoreCase("zamora")){
            descuento += Descuentos.lugar;
        }
        //validamos la edad y aplicamos el descuento 
        if(edad >= 17 && edad < 20){ 
           descuento += Descuentos.edad;
        }
        //validamos el esatdo civil y aplicamos descuento
        if(estadoCivil == 2){
           descuento += Descuentos.estado_civil;
        }
        //validamos si esque tiene cargas familiares y aplicamos decuento
        if(cargasFamiliares > 0 ){
           descuento += Descuentos.cargas_familiares;	
        }
        

        //calculamos el desceunto final de la matricula
        descuentoFinal = (MatriculaInicial * descuento) / 100;

        //calculamos el valor a pagar de la matricula
        MatriculaFinal = MatriculaInicial - descuentoFinal;
        
        aumentoMatricula = (MatriculaFinal*Descuentos.final_matricula)/100;
        //aplicamos el desceunto general de 2% al valor de la matricula
        MatriculaFinal += aumentoMatricula;
        
        //mostramos el resultado en pantalla de los resultado obtenidos
        System.out.printf("El valor final a pagar de la matricula es de: "
                + "%.2f\n", MatriculaFinal);

    }
}
