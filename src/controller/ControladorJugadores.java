/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Jugador;
import model.Tablero;
import view.ViewJeopardy;
import view.VentanaJugadorGUI;

/**
 *
 * @author usuario
 */
public class ControladorJugadores implements ActionListener{
    private final Jugador model;
    private final VentanaJugadorGUI view;
    
     public ControladorJugadores(Jugador model, VentanaJugadorGUI view) {
        this.model = model;
        this.view = view;
        
        //Add listeners to the view
        view.getPlay().addActionListener(this);

    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()== view.getPlay()){
            String nombre1 = this.view.getNombreJugador1().getText();
            String nombre2 = this.view.getNombreJugador2().getText();
            switch (model.comprobarNombre(nombre1, nombre2)) {
                case 0:
                    Frame f = view.getFrame();
                    f = new JFrame();
                    JOptionPane.showMessageDialog(f, "Los nombres son iguales.", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
                case 1:
                    model.Jugador J1 = new model.Jugador(nombre1);
                    
                    model.Jugador J2 = new model.Jugador(nombre2);
                    
                    view.setVisible(false);
                    
                    Jugador jugador1 = J1;
                    Jugador jugador2 = J2;
                    
                    ViewJeopardy view2 = new ViewJeopardy();
                    Tablero model2 = new Tablero(jugador1,jugador2,view2);
                    
                    ControladorJeopardy controller = new ControladorJeopardy(view2,model2);
                    break;
                case -1:
                    f = new JFrame();
                    JOptionPane.showMessageDialog(f, "Uno de los nombres (o los dos) esta vacio.", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }
    }
    
}
