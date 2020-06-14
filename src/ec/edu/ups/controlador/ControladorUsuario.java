/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.dao.TelefonoDao;
import ec.edu.ups.dao.UsuarioDao;
import ec.edu.ups.idao.ITelefonoDao;
import ec.edu.ups.idao.IUsuarioDao;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.vista.VentanaAgenda;
import ec.edu.ups.vista.VentanaTelefono;
import java.util.Map;

/**
 *
 * @author Anahi
 */
public class ControladorUsuario {
    VentanaAgenda ventana;
    private Usuario usuario;
    private Telefono telefono;
    
    private UsuarioDao usuarioD;
    private TelefonoDao telefonoD;
    private VentanaTelefono vTele;
    private VentanaAgenda vPrincipal;

    public ControladorUsuario(UsuarioDao usuarioD, TelefonoDao telefonoD) {
        this.usuarioD = usuarioD;
        this.telefonoD = telefonoD;
    }
    public void registrarUsuario(Usuario u) {
        usuarioD.create(u);

    }
    public Usuario iniciarSesion(String correo, String contrasena) {
        usuario = usuarioD.iniciarSesion(correo, contrasena);

        return usuario;
    }

     public void crearTelefono(Usuario usuario1, Telefono telefono1) {
        telefonoD.create(telefono1);
        usuario1.agregarTelefono(telefono1);
        usuarioD.update(usuario1);
    }
    public void imprimirTelefonos() {
        Map<Integer, Telefono> telefonos;
        telefonos=telefonoD.findAll();

        for (Map.Entry<Integer, Telefono> tele : telefonos.entrySet()) {
            System.out.println("uuu\n" + tele.toString());
        }
    }

    
    

}
