package e2e;

import dto.MovieDTO;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ContinuousE2eTests {

    @Test
    void testGetAllMoviesE2e() {
        //act
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
