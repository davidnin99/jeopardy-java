/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author usuario
 */
public class Jugador {
    
    private String nombreJugador;
    private int puntuacion;
    private boolean ganador;

    public Jugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
        this.puntuacion = 0;
        this.ganador = false;
    }

    public Jugador() {
    }
    
    public void haGanado(){
        ganador = true;
    }
    
    public void actualizarPuntuacion(int puntosPregunta){
        this.puntuacion+=puntosPregunta;  
    }
    
    public int getPuntuacion(){
        return this.puntuacion;
    }
    
    public String getNombreJugador(){
        return this.nombreJugador;
    }
    
    public int comprobarNombre(String J1, String J2){
        if(J1.equals("") || J2.equals("")){
            return -1;
        }else if(J1.equals(J2)){
            return 0;
        }else{
            return 1;
        }
    }
}
