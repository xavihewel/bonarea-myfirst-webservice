package com.area.bonarea.myfirst.webservice;

import io.swagger.annotations.Contact;
import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Configures JAX-RS for the application.
 *
 * @author Juneau
 */
@ApplicationPath("resources")
@SwaggerDefinition(info = @Info(
        title = "Example Service",
        description = "A simple example of apiee",
        version = "1.0.0",
        contact = @Contact(
                name = "Xavier Vergés",
                email = "xavier.verges@bonarea.com",
                url = "https://o2.bonarea-agrupa.com/miembros/xavier-verges/"
        )
))
public class JAXRSConfiguration extends Application {

}
