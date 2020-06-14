/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.dao.TelefonoDao;
import ec.edu.ups.idao.ITelefonoDao;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.vista.VentanaTelefono;

/**
 *
 * @author Anahi
 */
public class ControladorTelefono {
    private VentanaTelefono vent;
    private Telefono telefono;
    private ITelefonoDao telefonoD;
    //constructor

    public ControladorTelefono(TelefonoDao telefonoD) { 
        this.telefonoD = telefonoD;
    }
    
    public void crearTelefono(Telefono telefono){
        telefonoD.create(telefono);
    }
    
    public Telefono encontrarTelefono(int codigo){
        
        telefono = telefonoD.read(codigo);
        
        return telefono;
    }
}
