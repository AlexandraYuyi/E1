package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.math.BigInteger;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Interfaz extends JFrame implements ActionListener {
    private JTextField input; 
    private JLabel enunciado;
    private JLabel warning;
    private JLabel warning2;
    private JButton calcular;
    private JButton limpiar;
    private JLabel matrizLabel;
    private JLabel ordMayorMenor;
    private JLabel multColUno;
    private JLabel numInvertido;
    private JLabel promDiagSec;
    private JLabel potencia;
    private JTextArea resultadoOrden;
    private JTextArea resultadoMult;
    private JTextArea resultadoInvert;
    private JTextArea resultadoProm;
    private JTextArea resultadoPot;
    private JScrollPane scrollpane1;
    private JTextArea matrizCuadro;
    
    public Interfaz(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Evaluación 1 de Algoritmos y Estructuras I");
        
        enunciado = new JLabel("Ingrese un número del 1 al 9: ");
        enunciado.setBounds(331,30,480,30);
        enunciado.setFont(new Font("Verdana", Font.BOLD, 24));
        add(enunciado);
        
        input = new JTextField();
        input.setBounds(741,25,40,40);
        input.setFont(new Font("Verdana", Font.BOLD, 24));
        
        input.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                inputKeyTyped(e);
            }
        });
        
        add(input);
        
        warning = new JLabel("Por favor ingrese un numero válido...");
        warning.setBounds(331,70,480,30);
        warning.setFont(new Font("Verdana", Font.BOLD, 18));
        warning.setForeground(Color.red);
        warning.setVisible(false);
        
        add(warning);
        
        warning2 = new JLabel("Por favor ingrese un número válido...");
        warning2.setBounds(331,70,480,30);
        warning2.setFont(new Font("Verdana", Font.BOLD, 18));
        warning2.setForeground(Color.red);
        warning2.setVisible(false);
        
        add(warning2);
        
        calcular = new JButton("Calcular");
        calcular.setBounds(803,25,150,40);
        calcular.setFont(new Font("Verdana", Font.BOLD, 18));
        add(calcular);
        calcular.addActionListener(this);
        
        limpiar = new JButton("Limpiar");
        limpiar.setBounds(980,25,150,40);
        limpiar.setFont(new Font("Verdana", Font.BOLD, 18));
        limpiar.setEnabled(false);
        add(limpiar);
        limpiar.addActionListener(this);
        
        matrizLabel = new JLabel("Matriz:");
        matrizLabel.setBounds(40,115,480,30);
        matrizLabel.setFont(new Font("Verdana", Font.BOLD, 20));
        add(matrizLabel);
        
        ordMayorMenor = new JLabel("Elementos ordenados de mayor a menor: ");
        ordMayorMenor.setBounds(743,115,480,30);
        ordMayorMenor.setFont(new Font("Verdana", Font.BOLD, 20));
        add(ordMayorMenor);
        
        multColUno = new JLabel("Multiplicación de la 1era columna: ");
        multColUno.setBounds(743,310,480,30);
        multColUno.setFont(new Font("Verdana", Font.BOLD, 20));
        add(multColUno);
        
        numInvertido = new JLabel("Número del resultado anterior invertido: ");
        numInvertido.setBounds(743,400,480,30);
        numInvertido.setFont(new Font("Verdana", Font.BOLD, 20));
        add(numInvertido);
        
        promDiagSec = new JLabel("Promedio de la diagonal secundaria: ");
        promDiagSec.setBounds(743,490,480,30);
        promDiagSec.setFont(new Font("Verdana", Font.BOLD, 20));
        add(promDiagSec);
        
        potencia = new JLabel("Potencia del menor elemento positivo elevado al mayor elemento: ");
        potencia.setBounds(40,605,800,30);
        potencia.setFont(new Font("Verdana", Font.BOLD, 20));
        add(potencia);
        
        resultadoOrden = new JTextArea();
        resultadoOrden.setBounds(743,155,700,140);
        resultadoOrden.setFont(new Font("Verdana", Font.LAYOUT_LEFT_TO_RIGHT, 18));
        resultadoOrden.setEditable(false);
        add(resultadoOrden);
        
        resultadoMult = new JTextArea();
        resultadoMult.setBounds(743,345,700,40);
        resultadoMult.setFont(new Font("Verdana", Font.LAYOUT_LEFT_TO_RIGHT, 18));
        resultadoMult.setEditable(false);
        add(resultadoMult);
        
        resultadoInvert = new JTextArea();
        resultadoInvert.setBounds(743,435,700,40);
        resultadoInvert.setFont(new Font("Verdana", Font.LAYOUT_LEFT_TO_RIGHT, 18));
        resultadoInvert.setEditable(false);
        add(resultadoInvert);
        
        resultadoProm = new JTextArea();
        resultadoProm.setBounds(743,525,700,40);
        resultadoProm.setFont(new Font("Verdana", Font.LAYOUT_LEFT_TO_RIGHT, 18));
        resultadoProm.setEditable(false);
        add(resultadoProm);
        
        resultadoPot = new JTextArea();
        resultadoPot.setEditable(false);
        resultadoPot.setFont(new Font("Verdana", Font.LAYOUT_LEFT_TO_RIGHT, 18));
        add(resultadoPot);
        scrollpane1 = new JScrollPane(resultadoPot);
        scrollpane1.setBounds(40,640,1405,50);
        add(scrollpane1);
        
        matrizCuadro = new JTextArea();
        matrizCuadro.setBounds(40,155,640,400);
        matrizCuadro.setFont(new Font("Verdana", Font.LAYOUT_LEFT_TO_RIGHT, 18));
        matrizCuadro.setEditable(false);
        add(matrizCuadro);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        try{
            if(e.getSource() == calcular){
                if(input.getText().isEmpty()){
                warning2.setVisible(true);
                }else{
                    String text = input.getText();
                    int entero = Integer.parseInt(text);
                    if(entero >0 && entero < 10){
                    warning.setVisible(false);
                    warning2.setVisible(false);
                    limpiar.setEnabled(true);
                    calcular.setEnabled(false);
                    input.setEditable(false);
                    
                    int[][] matriz = Logica.crearMatriz(entero);
                    int[] vector = Logica.crearVector(entero);
                    int escalar = 0;
                    float real = 0;
                    BigInteger potencia = new BigInteger("1");
                    
                    matriz = Logica.llenarMatriz(matriz);
                    matrizCuadro.setText(Logica.mostrarMatriz(matriz));
                    vector = Logica.ordenarMatriz(matriz);
                    resultadoOrden.setText(Logica.mostrarVector(vector));
                    escalar = Logica.multiplicarColumna(matriz);
                    resultadoMult.setText(String.valueOf(escalar));
                    resultadoInvert.setText(Logica.invertirNumero(escalar));
                    real = Logica.promedioSumaDiagonalSecundaria(matriz);
                    resultadoProm.setText(Float.toString(real));
                    potencia = Logica.potenciaMenorMayor(vector);
                    resultadoPot.setText(String.valueOf(potencia));
                    
                    }else{
                        warning.setVisible(true);
                    }
                }
            }
        }
        catch(NumberFormatException err){
        
        }
        
        if(e.getSource() == limpiar){
            limpiar.setEnabled(false);
            calcular.setEnabled(true);
            input.setEditable(true);
            input.setText(null);
            matrizCuadro.setText("");
            resultadoOrden.setText("");
            resultadoMult.setText("");
            resultadoInvert.setText("");
            resultadoProm.setText("");
            resultadoPot.setText("");
        }
    }
    
    public static void main(String[] args) {
        Interfaz interfaz = new Interfaz();
        interfaz.setBounds(0,0,1500,770);
        interfaz.setResizable(false);
        interfaz.setVisible(true);
        interfaz.setLocationRelativeTo(null);
    }
    
    private void inputKeyTyped(KeyEvent e){
        char tecla= e.getKeyChar();
        if(!(Character.isDigit(tecla)) || (tecla == KeyEvent.VK_BACK_SPACE) || (tecla == KeyEvent.VK_DELETE)){
            e.consume();
            }
    }
}