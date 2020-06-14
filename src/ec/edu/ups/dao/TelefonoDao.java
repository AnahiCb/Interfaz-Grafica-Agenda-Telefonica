/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.dao;

import ec.edu.ups.idao.ITelefonoDao;
import ec.edu.ups.modelo.Telefono;
import java.util.*;

/**
 *
 * @author Anahi
 */
public class TelefonoDao implements ITelefonoDao {
    private Map<Integer, Telefono> listaTelefonos;

    public TelefonoDao() {
        listaTelefonos = new HashMap<>();
    }
    @Override
    public void create(Telefono telefono) {
        listaTelefonos.put(telefono.getCodigo(), telefono);
    }
    @Override
    public Telefono read(int id) {
        for (Map.Entry<Integer, Telefono> telefono : listaTelefonos.entrySet()) {
            int cod = telefono.getKey();
            if (cod == id) {
                Telefono tele = listaTelefonos.get(cod);
                return tele;
            }
        }
        return null;
    }

    //para actualizar un telefono
    @Override
    public void update(Telefono telefono) {
        for (Map.Entry<Integer, Telefono> telefono2 : listaTelefonos.entrySet()) {
            int cod = telefono2.getKey();
            if (cod == telefono.getCodigo()) {
                listaTelefonos.replace(cod, telefono);
                break;
            }
        }

    }

    //para eliminar un telefono
    @Override
    public void delete(Telefono telefono) {
        for (Map.Entry<Integer, Telefono> telefono2 : listaTelefonos.entrySet()) {
            int cod = telefono2.getKey();
            if (cod == telefono.getCodigo()) {
                listaTelefonos.remove(telefono.getCodigo());
                break;
            }
        }
    }

    //para devolver un mapa de telefonos
    @Override
    public Map<Integer, Telefono> findAll() {
        return listaTelefonos;
    }

}
