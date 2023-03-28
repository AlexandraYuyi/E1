package interfaz;

//import com.sun.xml.internal.ws.util.StringUtils;
import java.math.BigInteger;

public class Logica {

    public static String mostrarMatriz(int[][] matriz){
        String elemento, m="";
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                elemento= String.valueOf(matriz[i][j]);
                m=m+String.format("%4s      ", elemento);
            }
            m=m+"\n\n";
        }
        return m;
    }

    public static String mostrarVector(int[] vector){
        int cont=0;
        String vectorAString="", elemento="";
            for (int i = 1; i < vector.length; i++) {
                cont++;
                elemento= String.valueOf(vector[i-1]);
                vectorAString= vectorAString+String.format("%4s",elemento);
                vectorAString= vectorAString+",";
                if(i%14==0){
                    vectorAString= vectorAString+"\n";
                }
            }
        elemento= String.valueOf(vector[vector.length-1]);
        vectorAString= vectorAString+String.format("%3s",elemento);
        System.out.println("");
        return vectorAString;
    }

    public static int[][] crearMatriz(int n) {//throws Excepciones{
        // if(n < 1 || n > 9){
        //     throw new Excepciones("Error: El número de filas y columnas debe ser mayor a 0");
        // }
        int[][] matriz = new int[n][n];
        return matriz;
    }

    public static int[] crearVector(int n){
        int[] vector = new int[n * n];
        return vector;
    }

    public static int[][] llenarMatriz(int[][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] = (int) (Math.random() *1999 - 999);
            }
        }
        return matriz;
    }

    public static int[] ordenarMatriz(int[][] matriz){
        int[] ordenado = new int[matriz.length * matriz.length];
        int k = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                ordenado[k] = matriz[i][j];
                k++;
            }
        }
        for (int i = 0; i < ordenado.length; i++) {
            for (int j = 0; j < ordenado.length; j++) {
                if(ordenado[i] > ordenado[j]){
                    int tmp = ordenado[i];
                    ordenado[i] = ordenado[j];
                    ordenado[j] = tmp;
                }
            }
        }
        return ordenado;
    }

     public static BigInteger multiplicarColumna(int[][] matriz){
        BigInteger multiplicado = new BigInteger("1");
        for (int i = 0; i < matriz.length; i++) {
            multiplicado = multiplicado.multiply(BigInteger.valueOf(matriz[i][0]));
        }
        return multiplicado;
    }

    public static String invertirNumero(BigInteger numero){
        BigInteger num = numero;
        if(numero.compareTo(BigInteger.ZERO) <0){
            num = numero.negate();
        }
        String str = num.toString();
        String reversedStr = new StringBuilder(str).reverse().toString();
        
        return reversedStr;
    }

    public static float promedioSumaDiagonalSecundaria(int[][] matriz){
        int suma = 0;
        float promedio = 0;
        for (int i = 0; i < matriz.length; i++) {
            suma += matriz[i][matriz.length - 1 - i];
        }
        promedio = (float)suma / matriz.length;
        return promedio;
    }

    public static BigInteger potenciaMenorMayor(int[] vector){
        int mayor = vector[0];
        int menor = vector[vector.length-1];
        BigInteger potencia = new BigInteger("1");
        potencia = BigInteger.valueOf(menor).pow(mayor);
        return potencia;
    }
}
