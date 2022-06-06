package e2e;

import dto.MovieDTO;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ContinuousE2eTests {

    @Test
    void testGetAllMoviesE2e() {

        MovieDTO[] list =
                given()
                        .accept(ContentType.JSON)
                        .contentType(ContentType.JSON).
                        when()
                        .get("/movies").
                        then()
                        .statusCode(HttpStatus.SC_OK)
                        .extract().body().as(MovieDTO[].class);

        //assert
        assertNotNull(list);
    }
}
