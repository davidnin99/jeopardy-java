/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author usuario
 */
public class VentanaPreguntasGUI extends JFrame{
    private JButton responderBotton;
    private JLabel labelCategoria, labelPregunta;
    private JFrame framePreguntas;
    private JRadioButton button1, button2, button3;
    private JFrame f2;
    private JFrame finalFrame;
    private ButtonGroup group;
    
    public VentanaPreguntasGUI(){
        this.setTitle("Pregunta");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //cuando le das a la X se cierra solo esta ventana
        addComponentsToPane(this.getContentPane());
        this.setResizable(false); // no se puede hacer pequeño ni grande la pamtala
        this.setSize(new Dimension(700,200));
        this.setVisible(true);
        
    }
    
    private void addComponentsToPane(Container pane) {  
        pane.setLayout(new BorderLayout(0, 10));//creo q los numeros estos son el borde arriba/abajo y derecha/izquierda o alreves
        
        //panel2
        JPanel panel2 = new JPanel(new BorderLayout(0,2));
        pane.add(panel2, BorderLayout.NORTH);
        
        //Jlabel
        labelCategoria = new JLabel();
        labelCategoria.setText("Categoria");
        labelCategoria.setHorizontalAlignment(SwingConstants.CENTER);
        panel2.add(labelCategoria, BorderLayout.NORTH);
        
        
        //Jlabel
        labelPregunta = new JLabel();
        labelPregunta.setText("Pregunta");
        labelPregunta.setHorizontalAlignment(SwingConstants.CENTER);
        panel2.add(labelPregunta, BorderLayout.SOUTH);
        
        
        //panel3
        JPanel panel3 = new JPanel(new BorderLayout(0,3));
        pane.add(panel3, BorderLayout.WEST);
         
        
        
        //radioButtons
        button1 = new JRadioButton("Respuesta 1");
        button1.setActionCommand("0");
        button2 = new JRadioButton("Respuesta 2");
        button2.setActionCommand("1");
        button3 = new JRadioButton("Respuesta 3");
        button3.setActionCommand("2");

        group = new ButtonGroup();
        group.add(button1);
        group.add(button2);
        group.add(button3);
        
        panel3.add(button1, BorderLayout.NORTH);
        panel3.add(button2, BorderLayout.CENTER);
        panel3.add(button3, BorderLayout.SOUTH);
                

        //Jbutton
        responderBotton = new JButton("Responder");
        responderBotton.setVerticalTextPosition(AbstractButton.CENTER);
        responderBotton.setHorizontalTextPosition(AbstractButton.CENTER);
        //b1.setAlignmentX(Component.RIGHT_ALIGNMENT);
        //b1.setHorizontalAlignment(SwingConstants.RIGHT);
        //b1.setPreferredSize(new Dimension(20,25));
        pane.add(responderBotton, BorderLayout.SOUTH);   
    }
    
      public JButton getResponderBotton() {
        return responderBotton;
    }

    public void setResponderBotton(JButton responderBotton) {
        this.responderBotton = responderBotton;
    }

    public JLabel getLabelCategoria() {
        return labelCategoria;
    }

    public void setLabelCategoria(JLabel labelCategoria) {
        this.labelCategoria = labelCategoria;
    }

    public JLabel getLabelPregunta() {
        return labelPregunta;
    }

    public void setLabelPregunta(JLabel labelPregunta) {
        this.labelPregunta = labelPregunta;
    }

    public JFrame getFinalFrame() {
        return finalFrame;
    }

    public void setFinalFrame(JFrame finalFrame) {
        this.finalFrame = finalFrame;
    }

    public JRadioButton getButton1() {
        return button1;
    }

    public void setButton1(JRadioButton button1) {
        this.button1 = button1;
    }

    public JRadioButton getButton2() {
        return button2;
    }

    public void setButton2(JRadioButton button2) {
        this.button2 = button2;
    }

    public JRadioButton getButton3() {
        return button3;
    }

    public void setButton3(JRadioButton button3) {
        this.button3 = button3;
    }

    public JFrame getF2() {
        return f2;
    }

    public void setF2(JFrame f2) {
        this.f2 = f2;
    }

    public ButtonGroup getGroup() {
        return group;
    }

    public void setGroup(ButtonGroup group) {
        this.group = group;
    }
    
}
