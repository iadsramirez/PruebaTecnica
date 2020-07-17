package com.promerica.ctrl;

import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import com.promerica.controller.Producto;
import com.promerica.controller.ProductoWS_Service;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.xml.ws.WebServiceRef;

@Named(value = "productoManagedBean")
@ViewScoped
public class ProductoManagedBean implements Serializable {
    
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/ProductoWS/ProductoWS.wsdl")
    private ProductoWS_Service serviceProducto;
    
    private List<Producto> listadoProducto = new ArrayList<Producto>();
    private Producto producto;
    private Integer accion;
    
    @PostConstruct
    public void init() {
        listar();
        listar$Action();
    }
    
    public String listar$Action() {
        accion = 0;
        return null;
    }
    
    public String editar$Action() {
        accion = 2;
        return null;
    }
    
    public String crear$Action() {
        accion = 1;
        inicializar();
        return null;
    }

    public void inicializar() {
        producto = new Producto();
    }
    
    public String listar() {
        try {
            com.promerica.controller.ProductoWS port = serviceProducto.getProductoWSPort();
            listadoProducto = port.listarProducto();
        } catch (Exception e) {
        }
        return null;
    }
    
    public boolean validar() {
        boolean error = Boolean.FALSE;
        if ((producto.getDescripcion().isEmpty()) || (producto.getNombre().isEmpty()) || (producto.getPrecio() == null)) {
            error = Boolean.TRUE;
        }
        
        return error;
    }
    
    public String cambiarEstado() {
        try {
            Integer resultado = 0;
            com.promerica.controller.ProductoWS port = serviceProducto.getProductoWSPort();
            producto.setEstado("I");
            resultado = port.editarProducto(producto);
            listar();
        } catch (Exception e) {
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Producto Eliminado", null));
        
        return null;
    }
    
    public String guardar() {
        Integer resultado = 0;
        
        if (validar()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Complete la Informacion", null));
            
            return null;
        }
        try {
            if (accion == 1) {
                com.promerica.controller.ProductoWS port = serviceProducto.getProductoWSPort();
                producto.setEstado("A");
                
                resultado = port.guardarProducto(producto);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Producto Guardado", null));
                
            } else {
                com.promerica.controller.ProductoWS port = serviceProducto.getProductoWSPort();
                resultado = port.editarProducto(producto);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Producto Editado", null));
                
            }
            
            listar();
            listar$Action();
            inicializar();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public ProductoManagedBean() {
    }
    
    public List<Producto> getListadoProducto() {
        return listadoProducto;
    }
    
    public void setListadoProducto(List<Producto> listadoProducto) {
        this.listadoProducto = listadoProducto;
    }
    
    public Producto getProducto() {
        return producto;
    }
    
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    public Integer getAccion() {
        return accion;
    }
    
    public void setAccion(Integer accion) {
        this.accion = accion;
    }
    
}
