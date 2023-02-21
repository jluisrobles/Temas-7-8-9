package impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;


public class Resultado {
    public static void main(String[] args) {

        System.out.println("Hola mundo");
        System.out.println(reverse("Hola mundo"));

        //1- Crea un array unidimensional de Strings y recórrelo, mostrando únicamente sus valores.
        System.out.println("Parte 1:\n----------------------------------------------------------------");
        String[] arrayString1 = new String[]{"Valor1","Valor2","Valor3","Valor4","Valor5"};
        for(String s : arrayString1){
            System.out.print(" "+s);
        }
        //2-Crea un array bidimensional de enteros y recórrelo, mostrando la posición y el valor de cada elemento en ambas dimensiones.
        System.out.println("Parte 2:\n----------------------------------------------------------------");
        int [][] arrayIntBidimensional = new int[2][2];
        arrayIntBidimensional[0][0] = 1;
        arrayIntBidimensional[0][1] = 2;
        arrayIntBidimensional[1][0] = 3;
        arrayIntBidimensional[1][1] = 4;
        for(int i = 0; i < arrayIntBidimensional.length; i++){
            for(int j = 0; j < arrayIntBidimensional[i].length; j++){
                System.out.println("Posicion ["+i+"]["+j+"], contenido:"+arrayIntBidimensional[i][j]);
            }
        }
        //3-Crea un "Vector" del tipo de dato que prefieras, y añádele 5 elementos. Elimina el 2o y 3er elemento y muestra el resultado final.
        System.out.println("Parte 3:\n----------------------------------------------------------------");
        Vector<Integer> vectorInt = new Vector<>();
        vectorInt.add(1);
        vectorInt.add(2);
        vectorInt.add(3);
        vectorInt.add(4);
        vectorInt.add(5);
        System.out.println("Contenido vector tras añadir 5 elementos");
        for(int i = 0; i < vectorInt.size(); i++){
            System.out.println("Posicion ["+i+"], contenido:"+vectorInt.get(i));
        }
        //borrar 2 y 3
        System.out.println("Contenido vector tras eliminar elementos 2 y 3");
        vectorInt.remove(2);
        vectorInt.remove(3);
        for(int i = 0; i < vectorInt.size(); i++){
            System.out.println("Posicion ["+i+"], contenido:"+vectorInt.get(i));
        }
        //4-Indica cuál es el problema de utilizar un Vector con la capacidad por defecto si tuviésemos 1000 elementos para ser añadidos al mismo.
        //El problema es que creceria mucho el espacio que reserva para sus datos. Es provable que provoque un desbordamiento de la memoria por intentar reservar mucha memoria para los datos del vector

        //5-Crea un ArrayList de tipo String, con 4 elementos. Cópialo en una LinkedList. Recorre ambos mostrando únicamente el valor de cada elemento.
        System.out.println("Parte 5:\n----------------------------------------------------------------");
        ArrayList<String> arrayListString = new ArrayList<>();
        arrayListString.add("Valor1");
        arrayListString.add("Valor2");
        arrayListString.add("Valor3");
        arrayListString.add("Valor4");

        System.out.println("Contenido del arrayListString:");
        for(String s : arrayListString){
            System.out.print(" "+s);
        }

        //Copia del array list a listaEnlazada
        LinkedList<String> listaEnlazada = new LinkedList<>(arrayListString);
        System.out.println("\nContenido de la LinkedList:");
        for(String s : listaEnlazada){
            System.out.print(" "+s);
        }

        //6-Crea un ArrayList de tipo int, y, utilizando un bucle rellénalo con elementos 1..10.
        // A continuación, con otro bucle, recórrelo y elimina los numeros pares.
        // Por último, vuelve a recorrerlo y muestra el ArrayList final.
        // Si te atreves, puedes hacerlo en menos pasos, siempre y cuando cumplas el primer "for" de relleno.

        System.out.println("\nParte 6:\n----------------------------------------------------------------");
        ArrayList<Integer> arrayListInt = new ArrayList<>();
        for(int i = 1; i <= 10; i++){
            arrayListInt.add(i);
        }
        for(int i=0;i<arrayListInt.size(); i++){
            int elemento=arrayListInt.get(i);
            if(elemento % 2 == 0) {
                try {
                    arrayListInt.remove(i);
                }catch(IndexOutOfBoundsException  e){
                    System.out.println("Exception fuera de rango:"+ e.getMessage());
                }
            }
        }
        System.out.println("Contenido del arrayListInt:");
        for(int i : arrayListInt){
            System.out.print(" "+i);
        }
        System.out.println("\nParte 6B:\n---------------------------------------------------------------");
        //Menos pasos
        ArrayList<Integer> arrayListInt2 = new ArrayList<>();
        for(int i = 1; i <= 10; i++){
            if (i % 2 != 0)
                arrayListInt2.add(i);
        }
        System.out.println("Contenido del arrayListInt:");
        for(int i : arrayListInt2){
            System.out.print(" "+i);
        }

        //7-Crea una función DividePorCero.
        // Esta, debe generar una excepción ("throws") a su llamante del tipo ArithmeticException
        // que será capturada por su llamante (desde "main", por ejemplo). Si se dispara la excepción,
        // mostraremos el mensaje "Esto no puede hacerse". Finalmente, mostraremos en cualquier caso: "Demo de código".

        System.out.println("\nParte 7:\n----------------------------------------------------------------");
        try {
            int resultado=DividePorCero();
            System.out.println("resultado: "+resultado);
        }catch (ArithmeticException e){
            System.out.println("Esto no puede hacerse "+ e);
        }finally {
            System.out.println("Demo de codigo");
        }

        //8-Utilizando InputStream y PrintStream,
        // crea una función que reciba dos parámetros: "fileIn" y "fileOut".
        // La tarea de la función será realizar la copia del fichero dado en el parámetro "fileIn" al fichero dado en "fileOut".

        System.out.println("\nParte 8:\n----------------------------------------------------------------");
        File fileIn=new File("./src/files/fileIn.txt");
        File fileOut=new File("./src/files/fileOut.txt");
        copiarFicheros(fileIn, fileOut);

        //9-Sorpréndenos creando un programa de tu elección que utilice InputStream, PrintStream,
        // excepciones, un HashMap y un ArrayList, LinkedList o array.
        System.out.println("Parte 9:\n----------------------------------------------------------------");
        HashMap<String,Integer> mapa=new HashMap<>();
        mapa.put("clave1", 10);
        mapa.put("clave2", 20);
        mapa.put("clave3", 30);
        mapa.put("clave4", 40);

        System.out.println("Contenido del mapa:");
        System.out.println(mapa);
        System.out.println("Recorrer el mapa elemento a elemento:");
        for(Map.Entry<String, Integer> elemento:mapa.entrySet()){
            System.out.print(elemento.getKey()+" -> ");
            System.out.println(elemento.getValue());
        }


    }

    /**
     * Metodo que se encarcaga de copiar el contenido de un fichero en otro
     * Nota sobre la copia: Sobrescribe el contenido del fichero Destino
     * @param fileIn Fichero de Origen, del que se saca la informacion
     * @param fileOut Fichero Destino, en el que se copia la informacion
     */
    private static void copiarFicheros(File fileIn, File fileOut) {
        try{
            //Lee un fichero y almacena en datos su contenido
            InputStream in = new FileInputStream(fileIn);
            byte []datos=in.readAllBytes();
            in.close();

            //Especificas un fichero en el que escribes los datos de antes
            PrintStream out = new PrintStream(fileOut);
            out.write(datos);
            out.close();

        }catch(Exception e){
            System.out.println("Excepcion");
        }
    }

    /**
     * Metodo que realiza una division por 0 para lanzar una excepcion y probar a capturar
     * Se ha añadido SuppressWarnings divzero para evitar el warnings
     * @return Tipo entero resultado de la division
     * @throws ArithmeticException Lanzar divzero
     */
    @SuppressWarnings("divzero")
    private static int DividePorCero() throws ArithmeticException{
        int valor1=2;
        int valor2=0;

        return valor1 / valor2;
    }

    public static String reverse(String texto) {
        String textoAlReves="";
        for (int i=texto.length()-1; i>=0; i--){
            textoAlReves = "%s%s".formatted(textoAlReves, texto.charAt(i));
        }
        return textoAlReves;
    }
}


