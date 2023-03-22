package interfaz;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;

public class Interfaz extends JFrame implements ActionListener {
    private JTextField input; 
    private JLabel enunciado;
    private JButton calcular;
    private JButton limpiar;
    
    
    public Interfaz(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        enunciado = new JLabel("Ingrese un número del 1 al 9: ");
        enunciado.setBounds(15,10,200,30);
        add(enunciado);
        
        input = new JTextField();
        input.setBounds(190,16,40,20);
        
        input.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                inputKeyTyped(e);
            }
        });
        
        add(input);
        
        calcular = new JButton("Calcular");
        calcular.setBounds(240,16,100,30);
        add(calcular);
        calcular.addActionListener(this);
        
        limpiar = new JButton("Limpiar");
        limpiar.setBounds(360,16,100,30);
        add(limpiar);
        limpiar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
    
    }
    
    public static void main(String[] args) {
        Interfaz interfaz = new Interfaz();
        interfaz.setBounds(0, 0, 800, 1000);
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