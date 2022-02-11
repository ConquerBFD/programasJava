/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vestidos;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;
/**
 *
 * @author esteb
 */
public class Implementa {
    private static Implementa obj=new Implementa();
    private static Datos datos=new Datos();
    private static Scanner teclado=new Scanner(System.in);
    public Implementa() {
    }
    public void ingresardatos(){
        System.out.println("Talla: ");
        datos.setTalla(teclado.nextInt());
        System.out.println("Color: ");
        datos.setColor(teclado.next());
        System.out.println("Marca: ");
        datos.setMarca(teclado.next());
        System.out.println("Precio: ");
        try {
            datos.setPrecio(teclado.nextFloat());
        } catch (InputMismatchException ex) {
            System.out.println("Es un numero entero");
        }
        datos.setPreciototal((datos.getPrecio()*12)/100);
        System.out.println("El precio total es: "+datos.getPreciototal());
    }
    public void grabarArchivo(String dato) throws IOException{
        try {
            System.out.println("dato: "+ dato);
            FileWriter fw = new FileWriter("vestidos.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(dato + "\t\n");
            bw.close();
        } catch (Exception e) {
            throw e;
        }
    }
    public void contarVestidos(){
        try {
            FileReader fr = new FileReader("vestidos.txt");
            BufferedReader bf = new BufferedReader(fr);
            System.out.println("El fichero tiene " + bf.lines().count() + " lineas");
            bf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void leerArchivo(){
        try {
            File archivo = new File("vestidos.txt");
            FileReader fr = new FileReader(archivo);
            BufferedReader br=new BufferedReader(fr);
            String linea;
            linea=datos.getTalla()+"\t"+datos.getColor()+"\t"+datos.getMarca()+"\t"+datos.getPrecio()+"\t"+datos.getPreciototal()+"\n";
            while ((linea=br.readLine())!=null) {                
                System.out.println(linea);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void borrarDatos(){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("vestidos.txt"));
            bw.write("");
            System.out.println("Se ha borrado el contenido del fichero");
            bw.close();
        } catch (Exception e) {
        }
    }
    public static void main(String[] args) {
        String cadena=new String("");
        int opcion=0;
        while (opcion !=6) {            
            System.out.println("Menú ingreso de vestidos");
            System.out.println("1: Ingresar datos");
            System.out.println("2: Grabar archivo");
            System.out.println("3: Contar vestidos");
            System.out.println("4: Leer archivo");
            System.out.println("5: Borrar datos del fichero");
            System.out.println("6: Salir");
            opcion=teclado.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Ingresar los datos del vestido");
                    obj.ingresardatos();
                    break;
                case 2:
                    cadena=datos.getTalla()+"\t"+datos.getColor()+"\t"+datos.getMarca()+"\t"+datos.getPrecio()+"\t"+datos.getPreciototal();
                    try {
                        obj.grabarArchivo(cadena);
                    } catch(IOException io)
                    {
                        System.out.println("Error "+io.getMessage());
                    }
                    break;
                case 3:
                    obj.contarVestidos();
                    break;
                case 4:
                    obj.leerArchivo();
                    break;
                case 5:
                    obj.borrarDatos();
                    break;
                case 6:
                    System.out.println("Gracias");
                    break;
            }
        }
    }
}
