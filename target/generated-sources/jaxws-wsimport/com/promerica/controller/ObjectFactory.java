
package com.promerica.controller;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.promerica.controller package. 
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

    private final static QName _ListarProductoResponse_QNAME = new QName("http://controller.promerica.com/", "listarProductoResponse");
    private final static QName _EditarProductoResponse_QNAME = new QName("http://controller.promerica.com/", "editarProductoResponse");
    private final static QName _Exception_QNAME = new QName("http://controller.promerica.com/", "Exception");
    private final static QName _ListarProducto_QNAME = new QName("http://controller.promerica.com/", "listarProducto");
    private final static QName _GuardarProducto_QNAME = new QName("http://controller.promerica.com/", "guardarProducto");
    private final static QName _GuardarProductoResponse_QNAME = new QName("http://controller.promerica.com/", "guardarProductoResponse");
    private final static QName _EditarProducto_QNAME = new QName("http://controller.promerica.com/", "editarProducto");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.promerica.controller
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EditarProductoResponse }
     * 
     */
    public EditarProductoResponse createEditarProductoResponse() {
        return new EditarProductoResponse();
    }

    /**
     * Create an instance of {@link ListarProductoResponse }
     * 
     */
    public ListarProductoResponse createListarProductoResponse() {
        return new ListarProductoResponse();
    }

    /**
     * Create an instance of {@link GuardarProducto }
     * 
     */
    public GuardarProducto createGuardarProducto() {
        return new GuardarProducto();
    }

    /**
     * Create an instance of {@link GuardarProductoResponse }
     * 
     */
    public GuardarProductoResponse createGuardarProductoResponse() {
        return new GuardarProductoResponse();
    }

    /**
     * Create an instance of {@link EditarProducto }
     * 
     */
    public EditarProducto createEditarProducto() {
        return new EditarProducto();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link ListarProducto }
     * 
     */
    public ListarProducto createListarProducto() {
        return new ListarProducto();
    }

    /**
     * Create an instance of {@link Producto }
     * 
     */
    public Producto createProducto() {
        return new Producto();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarProductoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controller.promerica.com/", name = "listarProductoResponse")
    public JAXBElement<ListarProductoResponse> createListarProductoResponse(ListarProductoResponse value) {
        return new JAXBElement<ListarProductoResponse>(_ListarProductoResponse_QNAME, ListarProductoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditarProductoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controller.promerica.com/", name = "editarProductoResponse")
    public JAXBElement<EditarProductoResponse> createEditarProductoResponse(EditarProductoResponse value) {
        return new JAXBElement<EditarProductoResponse>(_EditarProductoResponse_QNAME, EditarProductoResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarProducto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controller.promerica.com/", name = "listarProducto")
    public JAXBElement<ListarProducto> createListarProducto(ListarProducto value) {
        return new JAXBElement<ListarProducto>(_ListarProducto_QNAME, ListarProducto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GuardarProducto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controller.promerica.com/", name = "guardarProducto")
    public JAXBElement<GuardarProducto> createGuardarProducto(GuardarProducto value) {
        return new JAXBElement<GuardarProducto>(_GuardarProducto_QNAME, GuardarProducto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GuardarProductoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controller.promerica.com/", name = "guardarProductoResponse")
    public JAXBElement<GuardarProductoResponse> createGuardarProductoResponse(GuardarProductoResponse value) {
        return new JAXBElement<GuardarProductoResponse>(_GuardarProductoResponse_QNAME, GuardarProductoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditarProducto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controller.promerica.com/", name = "editarProducto")
    public JAXBElement<EditarProducto> createEditarProducto(EditarProducto value) {
        return new JAXBElement<EditarProducto>(_EditarProducto_QNAME, EditarProducto.class, null, value);
    }

}
