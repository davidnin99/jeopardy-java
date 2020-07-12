/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Pregunta;
import model.Tablero;
import view.VentanaEmpate;
import view.VentanaFinal;
import view.ViewJeopardy;


/**
 *
 * @author usuario
 */
public class ControladorEmpate implements ActionListener{
    
    private VentanaEmpate viewEmpate;
    private Tablero tablero;
    private ViewJeopardy viewJeopardy;
    private Pregunta pregunta;
    
    public ControladorEmpate(VentanaEmpate viewEmpate, Tablero tablero, ViewJeopardy viewJeopardy, Pregunta pregunta ){
        this.viewEmpate = viewEmpate;
        this.tablero = tablero;
        this.viewJeopardy = viewJeopardy;
        this.pregunta = pregunta;
        
        //Add listeners to the view
        viewEmpate.getButton().addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
    viewEmpate.setVisible(false);    
        
    try {
        tablero.cargarDatosFinalRound();
    } catch (IOException ex) {
        Logger.getLogger(ControladorEmpate.class.getName()).log(Level.SEVERE, null, ex);
    }    
      
    VentanaFinal view3 = new VentanaFinal();
    ControladorFinal f = new ControladorFinal(view3,tablero,viewJeopardy,pregunta);   
        
        
    }
    
}
