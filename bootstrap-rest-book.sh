#!/usr/bin/env bash
mvn -U io.quarkus:quarkus-maven-plugin:create \
        -DprojectGroupId=org.rperez.quarkus.microservices \
        -DprojectArtifactId=rest-book \
        -DclassName="org.rperez.quarkus.microservices.book.BookResource" \
        -Dpath="/api/books" \
        -Dextensions="resteasy-jsonb, smallrye-openapi"
