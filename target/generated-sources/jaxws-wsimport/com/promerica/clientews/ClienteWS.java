
package com.promerica.clientews;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ClienteWS", targetNamespace = "http://controller.promerica.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ClienteWS {


    /**
     * 
     * @param cliente
     * @return
     *     returns java.lang.Integer
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "guardarCliente", targetNamespace = "http://controller.promerica.com/", className = "com.promerica.clientews.GuardarCliente")
    @ResponseWrapper(localName = "guardarClienteResponse", targetNamespace = "http://controller.promerica.com/", className = "com.promerica.clientews.GuardarClienteResponse")
    @Action(input = "http://controller.promerica.com/ClienteWS/guardarClienteRequest", output = "http://controller.promerica.com/ClienteWS/guardarClienteResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://controller.promerica.com/ClienteWS/guardarCliente/Fault/Exception")
    })
    public Integer guardarCliente(
        @WebParam(name = "cliente", targetNamespace = "")
        Cliente cliente)
        throws Exception_Exception
    ;

    /**
     * 
     * @return
     *     returns java.util.List<com.promerica.clientews.Cliente>
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listadoClientes", targetNamespace = "http://controller.promerica.com/", className = "com.promerica.clientews.ListadoClientes")
    @ResponseWrapper(localName = "listadoClientesResponse", targetNamespace = "http://controller.promerica.com/", className = "com.promerica.clientews.ListadoClientesResponse")
    @Action(input = "http://controller.promerica.com/ClienteWS/listadoClientesRequest", output = "http://controller.promerica.com/ClienteWS/listadoClientesResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://controller.promerica.com/ClienteWS/listadoClientes/Fault/Exception")
    })
    public List<Cliente> listadoClientes()
        throws Exception_Exception
    ;

    /**
     * 
     * @param cliente
     * @return
     *     returns java.lang.Integer
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "editarCliente", targetNamespace = "http://controller.promerica.com/", className = "com.promerica.clientews.EditarCliente")
    @ResponseWrapper(localName = "editarClienteResponse", targetNamespace = "http://controller.promerica.com/", className = "com.promerica.clientews.EditarClienteResponse")
    @Action(input = "http://controller.promerica.com/ClienteWS/editarClienteRequest", output = "http://controller.promerica.com/ClienteWS/editarClienteResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://controller.promerica.com/ClienteWS/editarCliente/Fault/Exception")
    })
    public Integer editarCliente(
        @WebParam(name = "cliente", targetNamespace = "")
        Cliente cliente)
        throws Exception_Exception
    ;

    /**
     * 
     * @param cliente
     * @return
     *     returns com.promerica.clientews.Cliente
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "clienteById", targetNamespace = "http://controller.promerica.com/", className = "com.promerica.clientews.ClienteById")
    @ResponseWrapper(localName = "clienteByIdResponse", targetNamespace = "http://controller.promerica.com/", className = "com.promerica.clientews.ClienteByIdResponse")
    @Action(input = "http://controller.promerica.com/ClienteWS/clienteByIdRequest", output = "http://controller.promerica.com/ClienteWS/clienteByIdResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://controller.promerica.com/ClienteWS/clienteById/Fault/Exception")
    })
    public Cliente clienteById(
        @WebParam(name = "cliente", targetNamespace = "")
        Cliente cliente)
        throws Exception_Exception
    ;

}
