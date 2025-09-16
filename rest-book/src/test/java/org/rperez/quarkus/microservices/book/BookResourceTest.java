package org.rperez.quarkus.microservices.book;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.startsWith;

@QuarkusTest
class BookResourceTest {
    @Test
    void shouldCreateABook() {
        given()
                .formParam("title", "Seeking Wisdom")
                .formParam("author", "Peter Bevelin")
                .formParam("year", 2007)
                .formParam("genre", "Non-fiction")
          .when()
                .post("/api/books")
          .then()
             .statusCode(201)
             .body("isbn_13", startsWith("13-"))
             .body("title", startsWith("Seeking Wisdom"))
             .body("author", startsWith("Peter Bevelin"))
             .body("year_of_publication", is(2007))
             .body("genre", startsWith("Non-fiction"))
             .body("creation_date", startsWith("20"));
    }
}