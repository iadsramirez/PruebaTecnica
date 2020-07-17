
package com.promerica.clientews;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "ClienteWS", targetNamespace = "http://controller.promerica.com/", wsdlLocation = "http://localhost:8080/ClienteWS/ClienteWS?WSDL")
public class ClienteWS_Service
    extends Service
{

    private final static URL CLIENTEWS_WSDL_LOCATION;
    private final static WebServiceException CLIENTEWS_EXCEPTION;
    private final static QName CLIENTEWS_QNAME = new QName("http://controller.promerica.com/", "ClienteWS");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/ClienteWS/ClienteWS?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CLIENTEWS_WSDL_LOCATION = url;
        CLIENTEWS_EXCEPTION = e;
    }

    public ClienteWS_Service() {
        super(__getWsdlLocation(), CLIENTEWS_QNAME);
    }

    public ClienteWS_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), CLIENTEWS_QNAME, features);
    }

    public ClienteWS_Service(URL wsdlLocation) {
        super(wsdlLocation, CLIENTEWS_QNAME);
    }

    public ClienteWS_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CLIENTEWS_QNAME, features);
    }

    public ClienteWS_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ClienteWS_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ClienteWS
     */
    @WebEndpoint(name = "ClienteWSPort")
    public ClienteWS getClienteWSPort() {
        return super.getPort(new QName("http://controller.promerica.com/", "ClienteWSPort"), ClienteWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ClienteWS
     */
    @WebEndpoint(name = "ClienteWSPort")
    public ClienteWS getClienteWSPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://controller.promerica.com/", "ClienteWSPort"), ClienteWS.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CLIENTEWS_EXCEPTION!= null) {
            throw CLIENTEWS_EXCEPTION;
        }
        return CLIENTEWS_WSDL_LOCATION;
    }

}
