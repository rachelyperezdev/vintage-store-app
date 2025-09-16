#!/usr/bin/env bash
mvn -U io.quarkus:quarkus-maven-plugin:create \
        -DprojectGroupId=org.rperez.quarkus.microservices \
        -DprojectArtifactId=rest-number \
        -DclassName="org.rperez.quarkus.microservices.number.NumberResource" \
        -Dpath="/api/numbers" \
        -Dextensions="resteasy-jsonb, smallrye-openapi"
