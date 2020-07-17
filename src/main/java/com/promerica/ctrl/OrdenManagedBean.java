/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.promerica.ctrl;

import com.promerica.clientews.Cliente;
import com.promerica.controller.DetalleOrden;
import com.promerica.controller.DetalleOrdenWS_Service;
import com.promerica.controller.Orden;
import com.promerica.controller.OrderWS_Service;
import com.promerica.controller.Producto;
import com.promerica.controller.ProductoWS_Service;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author user
 */
@Named(value = "ordenManagedBean")
@ViewScoped
public class OrdenManagedBean implements Serializable {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/OrderWS/OrderWS.wsdl")
    private OrderWS_Service ordenService;

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/ClienteWS/ClienteWS.wsdl")
    private com.promerica.clientews.ClienteWS_Service clienteService;

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/ProductoWS/ProductoWS.wsdl")
    private ProductoWS_Service service;

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/DetalleOrdenWS/DetalleOrdenWS.wsdl")
    private DetalleOrdenWS_Service detalleOrdenService;

    private double IVA = 0.13;
    private List<Producto> listadoProducto = new ArrayList<Producto>();
    private List<Producto> listadoProductoFiltered;
    private List<Orden> listadoOrden = new ArrayList<Orden>();
    private Producto productoSelec;
    private Orden orden;
    private List<DetalleOrden> listadoDetalleOrden = new ArrayList<DetalleOrden>();
    private Integer accion;
    private List<Cliente> listadoCliente = new ArrayList<Cliente>();
    private List<DetalleOrden> listadoDetOrden = new ArrayList<>();
    private List<Cliente> listadoClienteFiltered;
    private Cliente clienteSeleccion;
    private DetalleOrden detalleOrden;
    private Double total;
    private Double subTotal;
    private Integer cantidad;
    private Orden ordenSeleccion;

    @PostConstruct
    public void init() {
        listarProd();
        listarCliente();
        listarOrder();
        listar$Action();
        inicializarDetalle();
    }

    public OrdenManagedBean() {
    }

    public String obtenerDetalleOrden() {

        try {
            com.promerica.controller.DetalleOrdenWS port = detalleOrdenService.getDetalleOrdenWSPort();
            listadoDetOrden = port.buscarDetalleOrden(ordenSeleccion.getIdOrden());
            System.out.println("listadoDetOrden" + listadoDetOrden.size());
        } catch (Exception ex) {
        }

        return null;
    }

    public void asignarClienteOrden() {
        com.promerica.controller.Cliente cliente = new com.promerica.controller.Cliente();
        cliente.setId(clienteSeleccion.getId());
        orden.setCliente(cliente);
    }

    public void calculoTotales() {
        total = 0.0;
        subTotal = 0.0;
        cantidad = 0;

        for (DetalleOrden e : listadoDetalleOrden) {
            total += new BigDecimal(e.getTotal()).setScale(2, RoundingMode.HALF_DOWN).doubleValue();
            subTotal += new BigDecimal(e.getSubTotal()).setScale(2, RoundingMode.HALF_DOWN).doubleValue();
            cantidad += e.getCantidad();
        }
        System.out.println(total);

        orden.setCantidad(cantidad);
        orden.setSubTotal(subTotal);
        orden.setTotal(total);

    }

    public Orden obtenerOrden(Orden orden) {
        Orden ord = new Orden();
        try {
            com.promerica.controller.OrderWS port = ordenService.getOrderWSPort();
            ord = port.ordenById(orden);
        } catch (Exception e) {
        }
        return ord;
    }

    public String realizarOperacion() {
        try {
            calculoTotales();
            int idOrden = guardarEncabezado();
            orden.setIdOrden(idOrden);
            for (DetalleOrden e : listadoDetalleOrden) {
                e.setOrden(obtenerOrden(orden));
                guardarDetalle(e);
            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Orden Guardada", null));
            listar$Action();
            listarOrder();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al Guardar", null));
            System.err.println(e.getMessage());
        }

        return null;
    }

    public Integer guardarDetalle(DetalleOrden detalle) {
        Integer resultado = 0;
        try {
            com.promerica.controller.DetalleOrdenWS port = detalleOrdenService.getDetalleOrdenWSPort();
            resultado = port.guardarOrdenDetalle(detalle);

        } catch (Exception ex) {
            resultado = 0;
            ex.printStackTrace();
        }
        return resultado;
    }

    public Integer guardarEncabezado() {
        Integer resultado = 0;
        try {
            asignarClienteOrden();
            com.promerica.controller.OrderWS port = ordenService.getOrderWSPort();
            resultado = port.guardarOrden(orden, orden.getCliente());

        } catch (Exception ex) {
            resultado = 0;
            ex.printStackTrace();
        }
        return resultado;
    }

    public String confirmar() {
        if (listadoDetalleOrden == null) {
            setListadoDetalleOrden(new ArrayList<DetalleOrden>());
        }

        detalleOrden.setSubTotal(detalleOrden.getCantidad() * detalleOrden.getProducto().getPrecio());
        detalleOrden.setTotal((detalleOrden.getSubTotal() * IVA) + detalleOrden.getSubTotal());
        getListadoDetalleOrden().add(detalleOrden);
        inicializarDetalle();
        calculoTotales();

        return null;
    }

    public void asignarProdDetalle() {
        detalleOrden.setProducto(productoSelec);
    }

    public String listar$Action() {
        accion = 0;
        return null;
    }

    public String crear$Action() {
        accion = 1;
        try {
            inicializarOrden();
            inicializarDetalle();
        } catch (Exception e) {
        }
        return null;
    }

    public void inicializarDetalle() {
        detalleOrden = new DetalleOrden();

    }

    public void inicializarOrden() throws DatatypeConfigurationException {
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(new Date());
        XMLGregorianCalendar fecha = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);

        orden = new Orden();
        orden.setFecha(fecha);

    }

    public void listarProd() {

        try {
            com.promerica.controller.ProductoWS port = service.getProductoWSPort();

            listadoProducto = port.listarProducto();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void listarOrder() {

        try {
            com.promerica.controller.OrderWS port = ordenService.getOrderWSPort();

            listadoOrden = port.listaOrden();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void listarCliente() {

        try {
            com.promerica.clientews.ClienteWS port = clienteService.getClienteWSPort();

            listadoCliente = port.listadoClientes();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public List<Producto> getListadoProducto() {
        return listadoProducto;
    }

    public void setListadoProducto(List<Producto> listadoProducto) {
        this.listadoProducto = listadoProducto;
    }

    public List<Orden> getListadoOrden() {
        return listadoOrden;
    }

    public void setListadoOrden(List<Orden> listadoOrden) {
        this.listadoOrden = listadoOrden;
    }

    public Producto getProductoSelec() {
        return productoSelec;
    }

    public void setProductoSelec(Producto productoSelec) {
        this.productoSelec = productoSelec;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public Integer getAccion() {
        return accion;
    }

    public void setAccion(Integer accion) {
        this.accion = accion;
    }

    public List<DetalleOrden> getListadoDetalleOrden() {
        return listadoDetalleOrden;
    }

    public void setListadoDetalleOrden(List<DetalleOrden> listadoDetalleOrden) {
        this.listadoDetalleOrden = listadoDetalleOrden;
    }

    public List<Cliente> getListadoCliente() {
        return listadoCliente;
    }

    public void setListadoCliente(List<Cliente> listadoCliente) {
        this.listadoCliente = listadoCliente;
    }

    public Cliente getClienteSeleccion() {
        return clienteSeleccion;
    }

    public void setClienteSeleccion(Cliente clienteSeleccion) {
        this.clienteSeleccion = clienteSeleccion;
    }

    public List<Cliente> getListadoClienteFiltered() {
        return listadoClienteFiltered;
    }

    public void setListadoClienteFiltered(List<Cliente> listadoClienteFiltered) {
        this.listadoClienteFiltered = listadoClienteFiltered;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<Producto> getListadoProductoFiltered() {
        return listadoProductoFiltered;
    }

    public void setListadoProductoFiltered(List<Producto> listadoProductoFiltered) {
        this.listadoProductoFiltered = listadoProductoFiltered;
    }

    public DetalleOrden getDetalleOrden() {
        return detalleOrden;
    }

    public void setDetalleOrden(DetalleOrden detalleOrden) {
        this.detalleOrden = detalleOrden;
    }

    public List<DetalleOrden> getListadoDetOrden() {
        return listadoDetOrden;
    }

    public void setListadoDetOrden(List<DetalleOrden> listadoDetOrden) {
        this.listadoDetOrden = listadoDetOrden;
    }

    public Orden getOrdenSeleccion() {
        return ordenSeleccion;
    }

    public void setOrdenSeleccion(Orden ordenSeleccion) {
        this.ordenSeleccion = ordenSeleccion;
    }

}
