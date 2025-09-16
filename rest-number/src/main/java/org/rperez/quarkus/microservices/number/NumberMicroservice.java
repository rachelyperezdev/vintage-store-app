package org.rperez.quarkus.microservices.number;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.ExternalDocumentation;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.openapi.annotations.tags.Tags;

@ApplicationPath("/")
@OpenAPIDefinition(
        info = @Info(title = "Number API",
        description = "This microservice generates ISBN book numbers",
        version = "1.0",
        contact = @Contact(name = "@rachely-perez-dev", url = "https://www.linkedin.com/in/rachely-perez-dev/")),
        externalDocs = @ExternalDocumentation(url = "https://github.com/rachelyperezdev/vintage-bookstore", description = "All the microservice code"),
        tags = {
                @Tag(name = "api", description = "Public API that can be used by anybody"),
                @Tag(name = "book numbers", description = "Anybody interested in ISBN book numbers")
        }
)
public class NumberMicroservice extends Application {
}
