
package com.promerica.clientews;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.promerica.clientews package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GuardarClienteResponse_QNAME = new QName("http://controller.promerica.com/", "guardarClienteResponse");
    private final static QName _ListadoClientes_QNAME = new QName("http://controller.promerica.com/", "listadoClientes");
    private final static QName _ListadoClientesResponse_QNAME = new QName("http://controller.promerica.com/", "listadoClientesResponse");
    private final static QName _EditarCliente_QNAME = new QName("http://controller.promerica.com/", "editarCliente");
    private final static QName _Exception_QNAME = new QName("http://controller.promerica.com/", "Exception");
    private final static QName _ClienteByIdResponse_QNAME = new QName("http://controller.promerica.com/", "clienteByIdResponse");
    private final static QName _EditarClienteResponse_QNAME = new QName("http://controller.promerica.com/", "editarClienteResponse");
    private final static QName _ClienteById_QNAME = new QName("http://controller.promerica.com/", "clienteById");
    private final static QName _GuardarCliente_QNAME = new QName("http://controller.promerica.com/", "guardarCliente");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.promerica.clientews
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GuardarClienteResponse }
     * 
     */
    public GuardarClienteResponse createGuardarClienteResponse() {
        return new GuardarClienteResponse();
    }

    /**
     * Create an instance of {@link ListadoClientes }
     * 
     */
    public ListadoClientes createListadoClientes() {
        return new ListadoClientes();
    }

    /**
     * Create an instance of {@link ListadoClientesResponse }
     * 
     */
    public ListadoClientesResponse createListadoClientesResponse() {
        return new ListadoClientesResponse();
    }

    /**
     * Create an instance of {@link GuardarCliente }
     * 
     */
    public GuardarCliente createGuardarCliente() {
        return new GuardarCliente();
    }

    /**
     * Create an instance of {@link EditarCliente }
     * 
     */
    public EditarCliente createEditarCliente() {
        return new EditarCliente();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link ClienteByIdResponse }
     * 
     */
    public ClienteByIdResponse createClienteByIdResponse() {
        return new ClienteByIdResponse();
    }

    /**
     * Create an instance of {@link EditarClienteResponse }
     * 
     */
    public EditarClienteResponse createEditarClienteResponse() {
        return new EditarClienteResponse();
    }

    /**
     * Create an instance of {@link ClienteById }
     * 
     */
    public ClienteById createClienteById() {
        return new ClienteById();
    }

    /**
     * Create an instance of {@link Cliente }
     * 
     */
    public Cliente createCliente() {
        return new Cliente();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GuardarClienteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controller.promerica.com/", name = "guardarClienteResponse")
    public JAXBElement<GuardarClienteResponse> createGuardarClienteResponse(GuardarClienteResponse value) {
        return new JAXBElement<GuardarClienteResponse>(_GuardarClienteResponse_QNAME, GuardarClienteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListadoClientes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controller.promerica.com/", name = "listadoClientes")
    public JAXBElement<ListadoClientes> createListadoClientes(ListadoClientes value) {
        return new JAXBElement<ListadoClientes>(_ListadoClientes_QNAME, ListadoClientes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListadoClientesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controller.promerica.com/", name = "listadoClientesResponse")
    public JAXBElement<ListadoClientesResponse> createListadoClientesResponse(ListadoClientesResponse value) {
        return new JAXBElement<ListadoClientesResponse>(_ListadoClientesResponse_QNAME, ListadoClientesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditarCliente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controller.promerica.com/", name = "editarCliente")
    public JAXBElement<EditarCliente> createEditarCliente(EditarCliente value) {
        return new JAXBElement<EditarCliente>(_EditarCliente_QNAME, EditarCliente.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controller.promerica.com/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClienteByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controller.promerica.com/", name = "clienteByIdResponse")
    public JAXBElement<ClienteByIdResponse> createClienteByIdResponse(ClienteByIdResponse value) {
        return new JAXBElement<ClienteByIdResponse>(_ClienteByIdResponse_QNAME, ClienteByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditarClienteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controller.promerica.com/", name = "editarClienteResponse")
    public JAXBElement<EditarClienteResponse> createEditarClienteResponse(EditarClienteResponse value) {
        return new JAXBElement<EditarClienteResponse>(_EditarClienteResponse_QNAME, EditarClienteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClienteById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controller.promerica.com/", name = "clienteById")
    public JAXBElement<ClienteById> createClienteById(ClienteById value) {
        return new JAXBElement<ClienteById>(_ClienteById_QNAME, ClienteById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GuardarCliente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controller.promerica.com/", name = "guardarCliente")
    public JAXBElement<GuardarCliente> createGuardarCliente(GuardarCliente value) {
        return new JAXBElement<GuardarCliente>(_GuardarCliente_QNAME, GuardarCliente.class, null, value);
    }

}
