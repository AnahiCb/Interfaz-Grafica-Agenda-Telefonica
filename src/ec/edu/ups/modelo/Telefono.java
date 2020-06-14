/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

/**
 *
 * @author Anahi
 */
public class Telefono {
    //declaracion de atributos
    private int codigo;
    private String numero;
    private String tipo;
    private String operadora;
    //Constructor vacío
    public Telefono() {
    }

    /**
     * metodo constructor Telefono.
     *
     * Inicializa los atributos para comprobar que tienen valores vàlidos
     * @param codigo
     * @param numero
     * @param tipo
     * @param operadora
     */
    public Telefono(int codigo, String numero, String tipo, String operadora) {
        this.codigo = codigo;
        this.numero = numero;
        this.tipo = tipo;
        this.operadora = operadora;
    }
    //Mètodos Getter y Setter
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getOperadora() {
        return operadora;
    }
    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }

    /**
     * metodo hashCode.
     * este metodo crea el codigo unico del codigo de un telefono
     *
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.codigo;
        return hash;
    }

    /**
     * metodo equals.
     *
     * este metodo es el encargado de comparar el codigo del telefono, en caso
     * de que lo enuentre devuelve un true, caso contrario un false
     *
     * @param obj
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Telefono other = (Telefono) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

    /**
     * metodo toString.
     * @return String
     */
    @Override
    public String toString() {
        return "\nTelefono:\n" + "Codigo: " + codigo + ", :\nNumero: " + numero
                + "\nTipo: " + tipo + ", :\nOperadora: " + operadora;
    }
}
