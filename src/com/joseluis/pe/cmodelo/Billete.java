
package com.joseluis.pe.cmodelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Billete {
    
    private int nro_billete;
    private Date fecha;
    private Date hora;
    private String itinerario;
    private String origen;
    private String destino;
    private int dni_cliente;
    private int nro_compañia;

    public int getNro_billete() {
        return nro_billete;
    }

    public void setNro_billete(int nro_billete) {
        this.nro_billete = nro_billete;
    }

    public String getFecha() {
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        return formato.format(fecha);
        
    }

    public void setFecha(String  fecha) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        this.fecha = dateFormat.parse(fecha);
    }

    public String getHora() {
        SimpleDateFormat formato = new SimpleDateFormat("hh:mm");
        return formato.format(hora);
    }

    public void setHora(String hora)throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm");
        this.hora = dateFormat.parse(hora);
    }

    public String getItinerario() {
        return itinerario;
    }

    public void setItinerario() {
        this.itinerario = itinerario;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
    
    

    public int getDni_cliente() {
        return dni_cliente;
    }

    public void setDni_cliente(int dni_cliente) {
        this.dni_cliente = dni_cliente;
    }

    public int getNro_compañia() {
        return nro_compañia;
    }

    public void setNro_compañia(int nro_compañia) {
        this.nro_compañia = nro_compañia;
    }
    
    
}

