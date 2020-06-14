/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.dao;

import ec.edu.ups.idao.IUsuarioDao;
import ec.edu.ups.modelo.Usuario;
import java.util.*;

/**
 *
 * @author Anahi
 */
public class UsuarioDao implements IUsuarioDao{
    //instancia de un diccionario privado de usuarios
    private Map<String, Usuario> listaUsuarios;

    public UsuarioDao(){
        listaUsuarios = new HashMap<String, Usuario>();
    }
    @Override
    public void create(Usuario usuario) {
        //se añade el usuario al diccionario
        listaUsuarios.put(usuario.getCedula(), usuario);
    }
    @Override
    public Usuario read(String cedula) {
        //bucle for each para buscar el usuario
        for (Map.Entry<String, Usuario> usuario : listaUsuarios.entrySet()) {
            String key = usuario.getKey();
            Usuario valor = usuario.getValue();
            //se compara la cedula o el correo
            if (valor.getCedula().equals(cedula)
                    || (valor.getCorreo().equals(cedula))) {
                //se obtiene el usuario con el key
                Usuario usuario2 = listaUsuarios.get(key);
                return usuario2;
            }

        }
        return null;
    }
    @Override
    public void update(Usuario usuario) {
        
        for (Map.Entry<String, Usuario> usuario2 : listaUsuarios.entrySet()){
            Usuario usuario3 = usuario2.getValue();
            if (usuario3.getCedula().equals(usuario.getCedula())){
                listaUsuarios.replace(usuario.getCedula(), usuario);
                break;
            }
            
        }
    }
    @Override
    public void delete(Usuario usuario) {
        Iterator it = listaUsuarios.keySet().iterator();
        while (it.hasNext()) {
            Usuario usuario2 = (Usuario) it.next();
            if (usuario2.getCedula().equals(usuario)) {
                listaUsuarios.remove(usuario.getCedula());
                break;
            }
        }
    }
    @Override
    public Usuario iniciarSesion(String correo, String contraseña) {
        //bucle for each para recorrer los usuarios
        for (Map.Entry<String, Usuario> usuario : listaUsuarios.entrySet()) {
            String key = usuario.getKey();
            Usuario valor = usuario.getValue();
            //compara primero el correo
            if (valor.getCorreo().equals(correo)) {
                //si el correo es igual, compara la contraseña
                if (valor.getContraseña().equals(contraseña)) {
                    Usuario usu = new Usuario();
                    usu = listaUsuarios.get(key);
                    return usu;
                }
            }

        }

        return null;
    }
    @Override
    public Map<String, Usuario> llamarUsuarios() {
        return listaUsuarios;
    }
}
