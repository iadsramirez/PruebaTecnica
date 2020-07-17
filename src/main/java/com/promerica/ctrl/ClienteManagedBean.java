/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.promerica.ctrl;

import com.promerica.clientews.Cliente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author user
 */
@Named(value = "clienteManagedBean")
@ViewScoped
public class ClienteManagedBean implements Serializable {

    private Integer accion;
    private List<Cliente> listadoClientes = new ArrayList<>();

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/ClienteWS/ClienteWS.wsdl")
    private com.promerica.clientews.ClienteWS_Service service;

    private Cliente cliente;

    @PostConstruct
    public void init() {
        accion = 0;
        cliente = new Cliente();
        obtenerClientes();
    }

    public ClienteManagedBean() {
    }

    public String crear$Action() {
        cliente = new Cliente();
        accion = 1;
        return null;
    }

    public String eliminar$Action() {
        accion = 2;
        return null;
    }

    public String listar$Action() {
        accion = 0;
        return null;
    }

    public String obtenerClientes() {

        try {
            com.promerica.clientews.ClienteWS port = service.getClienteWSPort();
            listadoClientes = port.listadoClientes();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public boolean validar() {
        boolean error = Boolean.FALSE;
        if (!(cliente.getApellido() != null && !cliente.getApellido().isEmpty())) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Ingrese el apellido", null));

            error = Boolean.TRUE;
        }
        if (!(cliente.getNombre() != null && !cliente.getNombre().isEmpty())) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Ingrese el nombres", null));

            error = Boolean.TRUE;
        }

        return error;
    }

    public String guardar(String tipo) {
        boolean error = validar();
        try {
            if (tipo.equalsIgnoreCase("C") && !error) {
                com.promerica.clientews.ClienteWS port = service.getClienteWSPort();

                port.guardarCliente(getCliente());

            } else if (tipo.equalsIgnoreCase("E") && !error) {
                com.promerica.clientews.ClienteWS port = service.getClienteWSPort();
                port.editarCliente(cliente);
            }
            if (!error) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente Guardado", null));

            }

            obtenerClientes();
            listar$Action();

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al guardar", null));

            ex.printStackTrace();
        }

        return null;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getAccion() {
        return accion;
    }

    public void setAccion(Integer accion) {
        this.accion = accion;
    }

    public List<Cliente> getListadoClientes() {
        return listadoClientes;
    }

    public void setListadoClientes(List<Cliente> listadoClientes) {
        this.listadoClientes = listadoClientes;
    }

}
