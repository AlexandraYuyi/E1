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
import javax.swing.JTextArea;

public class Interfaz extends JFrame implements ActionListener {
    private JTextField input; 
    private JLabel enunciado;
    private JLabel warning;
    private JLabel warning2;
    private JButton calcular;
    private JButton limpiar;
    private JLabel ordMayorMenor;
    private JLabel multColUno;
    private JLabel numInvertido;
    private JLabel promDiagSec;
    private JLabel potencia;
    private JTextArea resultadoOrden;
    private JTextField resultadoMult;
    private JTextField resultadoInvert;
    private JTextField resultadoProm;
    private JTextArea resultadoPot;
    private JTextArea matriz;
    
    public Interfaz(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Evaluación 1 de Algoritmos y Estructuras I");
        
        enunciado = new JLabel("Ingrese un número del 1 al 9: ");
        enunciado.setBounds(554,30,480,30);
        enunciado.setFont(new Font("Verdana", Font.BOLD, 24));
        add(enunciado);
        
        input = new JTextField();
        input.setBounds(970,25,40,40);
        input.setFont(new Font("Verdana", Font.BOLD, 24));
        
        input.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                inputKeyTyped(e);
            }
        });
        
        add(input);
        
        warning = new JLabel("Por favor ingrese un numero válido...");
        warning.setBounds(554,70,480,30);
        warning.setFont(new Font("Verdana", Font.BOLD, 18));
        warning.setForeground(Color.red);
        warning.setVisible(false);
        
        add(warning);
        
        warning2 = new JLabel("Por favor ingrese un número válido...");
        warning2.setBounds(554,70,480,30);
        warning2.setFont(new Font("Verdana", Font.BOLD, 18));
        warning2.setForeground(Color.red);
        warning2.setVisible(false);
        
        add(warning2);
        
        calcular = new JButton("Calcular");
        calcular.setBounds(1029,25,150,40);
        calcular.setFont(new Font("Verdana", Font.BOLD, 18));
        add(calcular);
        calcular.addActionListener(this);
        
        limpiar = new JButton("Limpiar");
        limpiar.setBounds(1204,25,150,40);
        limpiar.setFont(new Font("Verdana", Font.BOLD, 18));
        limpiar.setEnabled(false);
        add(limpiar);
        limpiar.addActionListener(this);
        
        ordMayorMenor = new JLabel("Elementos ordenados de mayor a menor: ");
        ordMayorMenor.setBounds(970,115,480,30);
        ordMayorMenor.setFont(new Font("Verdana", Font.BOLD, 20));
        add(ordMayorMenor);
        
        multColUno = new JLabel("Multiplicación de la 1era columna: ");
        multColUno.setBounds(970,310,480,30);
        multColUno.setFont(new Font("Verdana", Font.BOLD, 20));
        add(multColUno);
        
        numInvertido = new JLabel("Número del resultado anterior invertido: ");
        numInvertido.setBounds(970,445,480,30);
        numInvertido.setFont(new Font("Verdana", Font.BOLD, 20));
        add(numInvertido);
        
        promDiagSec = new JLabel("Promedio de la diagonal secundaria: ");
        promDiagSec.setBounds(970,605,480,30);
        promDiagSec.setFont(new Font("Verdana", Font.BOLD, 20));
        add(promDiagSec);
        
        potencia = new JLabel("Potencia del menor elemento positivo elevado al mayor elemento: ");
        potencia.setBounds(970,765,800,30);
        potencia.setFont(new Font("Verdana", Font.BOLD, 20));
        add(potencia);
        
        resultadoOrden = new JTextArea();
        resultadoOrden.setBounds(970,155,900,120);
        resultadoOrden.setFont(new Font("Verdana", Font.LAYOUT_LEFT_TO_RIGHT, 18));
        add(resultadoOrden);
        
        resultadoMult = new JTextField();
        resultadoMult.setBounds(970,345,900,40);
        resultadoMult.setFont(new Font("Verdana", Font.LAYOUT_LEFT_TO_RIGHT, 18));
        add(resultadoMult);
        
        resultadoInvert = new JTextField();
        resultadoInvert.setBounds(970,480,900,40);
        resultadoInvert.setFont(new Font("Verdana", Font.LAYOUT_LEFT_TO_RIGHT, 18));
        add(resultadoInvert);
        
        resultadoProm = new JTextField();
        resultadoProm.setBounds(970,640,900,40);
        resultadoProm.setFont(new Font("Verdana", Font.LAYOUT_LEFT_TO_RIGHT, 18));
        add(resultadoProm);
        
        resultadoPot = new JTextArea();
        resultadoPot.setBounds(970,806,900,120);
        resultadoPot.setFont(new Font("Verdana", Font.LAYOUT_LEFT_TO_RIGHT, 18));
        add(resultadoPot);
        
        matriz = new JTextArea();
        matriz.setBounds(40,125,880,800);
        matriz.setFont(new Font("Verdana", Font.LAYOUT_LEFT_TO_RIGHT, 18));
        add(matriz);
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
            input.setText(null);
        }
    }
    
    public static void main(String[] args) {
        Interfaz interfaz = new Interfaz();
        interfaz.setExtendedState(JFrame.MAXIMIZED_BOTH);
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