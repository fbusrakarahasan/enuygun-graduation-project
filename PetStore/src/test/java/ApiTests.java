import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.number.OrderingComparison.lessThan;

public class ApiTests {

    public String baseURL = "https://petstore.swagger.io";


    @Test
    public void FindByStatusAvailable() {
        String requestUrl = String.format("%s/v2/pet/findByStatus?status=available", baseURL);

        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                        .when()
                        .get(requestUrl)
                        .then()
                        .statusCode(200)
                        .time(lessThan(4000L))
                        .extract().response();


        String responseStatusLine = response.getStatusLine();
        JsonPath j = new JsonPath(response.asString());


        for (int i = 0; i < j.getInt("status.size()"); i++) {
            Assert.assertEquals("available", j.getString("status[" + i + "]"));
        }

        Assert.assertNotNull(response.getBody()); // Body null kontrolü
        Assert.assertEquals(responseStatusLine, "HTTP/1.1 200 OK");
        Assert.assertEquals(8, response.getHeaders().size()); // Header Key Boyutu
        Assert.assertEquals("[application/json]", response.getHeaders().getValues("Content-Type").toString()); // Content-Type içeriyor mu?
        Assert.assertEquals("[chunked]", response.getHeaders().getValues("Transfer-Encoding").toString()); // Transfer-Encoding içeriyor mu?
        Assert.assertEquals("[keep-alive]", response.getHeaders().getValues("Connection").toString()); // Connection içeriyor mu?
        Assert.assertEquals("[*]", response.getHeaders().getValues("Access-Control-Allow-Origin").toString()); // Access-Control-Allow-Origin içeriyor mu?
        Assert.assertEquals("[GET, POST, DELETE, PUT]", response.getHeaders().getValues("Access-Control-Allow-Methods").toString()); // Access-Control-Allow-Methods içeriyor mu?
        Assert.assertEquals("[Content-Type, api_key, Authorization]", response.getHeaders().getValues("Access-Control-Allow-Headers").toString()); // Access-Control-Allow-Headers içeriyor mu?
        Assert.assertEquals("[Jetty(9.2.9.v20150224)]", response.getHeaders().getValues("Server").toString()); // Server içeriyor mu?
    }

    @Test
    public void FindByStatusPending() {
        String requestUrl = String.format("%s/v2/pet/findByStatus?status=pending", baseURL);

        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                        .when()
                        .get(requestUrl)
                        .then()
                        .statusCode(200)
                        .time(lessThan(4000L))
                        .extract().response();


        String responseStatusLine = response.getStatusLine();
        JsonPath j = new JsonPath(response.asString());


        for (int i = 0; i < j.getInt("status.size()"); i++) {
            Assert.assertEquals("pending", j.getString("status[" + i + "]"));
        }

        Assert.assertNotNull(response.getBody()); // Body null kontrolü
        Assert.assertEquals(responseStatusLine, "HTTP/1.1 200 OK");
        Assert.assertEquals(8, response.getHeaders().size()); // Header Key Boyutu
        Assert.assertEquals("[application/json]", response.getHeaders().getValues("Content-Type").toString()); // Content-Type içeriyor mu?
        Assert.assertEquals("[chunked]", response.getHeaders().getValues("Transfer-Encoding").toString()); // Transfer-Encoding içeriyor mu?
        Assert.assertEquals("[keep-alive]", response.getHeaders().getValues("Connection").toString()); // Connection içeriyor mu?
        Assert.assertEquals("[*]", response.getHeaders().getValues("Access-Control-Allow-Origin").toString()); // Access-Control-Allow-Origin içeriyor mu?
        Assert.assertEquals("[GET, POST, DELETE, PUT]", response.getHeaders().getValues("Access-Control-Allow-Methods").toString()); // Access-Control-Allow-Methods içeriyor mu?
        Assert.assertEquals("[Content-Type, api_key, Authorization]", response.getHeaders().getValues("Access-Control-Allow-Headers").toString()); // Access-Control-Allow-Headers içeriyor mu?
        Assert.assertEquals("[Jetty(9.2.9.v20150224)]", response.getHeaders().getValues("Server").toString()); // Server içeriyor mu?
    }

    @Test
    public void FindByStatusSold() {
        String requestUrl = String.format("%s/v2/pet/findByStatus?status=sold", baseURL);

        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                        .when()
                        .get(requestUrl)
                        .then()
                        .statusCode(200)
                        .time(lessThan(4000L))
                        .extract().response();


        String responseStatusLine = response.getStatusLine();
        JsonPath j = new JsonPath(response.asString());


        for (int i = 0; i < j.getInt("status.size()"); i++) {
            Assert.assertEquals("sold", j.getString("status[" + i + "]"));
        }

        Assert.assertNotNull(response.getBody()); // Body null kontrolü
        Assert.assertEquals(responseStatusLine, "HTTP/1.1 200 OK");
        Assert.assertEquals(8, response.getHeaders().size()); // Header Key Boyutu
        Assert.assertEquals("[application/json]", response.getHeaders().getValues("Content-Type").toString()); // Content-Type içeriyor mu?
        Assert.assertEquals("[chunked]", response.getHeaders().getValues("Transfer-Encoding").toString()); // Transfer-Encoding içeriyor mu?
        Assert.assertEquals("[keep-alive]", response.getHeaders().getValues("Connection").toString()); // Connection içeriyor mu?
        Assert.assertEquals("[*]", response.getHeaders().getValues("Access-Control-Allow-Origin").toString()); // Access-Control-Allow-Origin içeriyor mu?
        Assert.assertEquals("[GET, POST, DELETE, PUT]", response.getHeaders().getValues("Access-Control-Allow-Methods").toString()); // Access-Control-Allow-Methods içeriyor mu?
        Assert.assertEquals("[Content-Type, api_key, Authorization]", response.getHeaders().getValues("Access-Control-Allow-Headers").toString()); // Access-Control-Allow-Headers içeriyor mu?
        Assert.assertEquals("[Jetty(9.2.9.v20150224)]", response.getHeaders().getValues("Server").toString()); // Server içeriyor mu?
    }

    @Test
    public void FindByPetId() {

        String requestAvailable = String.format("%s/v2/pet/findByStatus?status=pending", baseURL);

        Response responseAvailable =
                given()
                        .contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                        .when()
                        .get(requestAvailable)
                        .then()
                        .statusCode(200)
                        .time(lessThan(4000L))
                        .extract().response();
        JsonPath j = new JsonPath(responseAvailable.asString());

        int petId = j.getInt("id[3]");

        String requestUrl = String.format("%s/v2/pet/" + petId, baseURL);

        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                        .when()
                        .get(requestUrl)
                        .then()
                        .statusCode(200)
                        .time(lessThan(4000L))
                        .extract().response();


        String responseStatusLine = response.getStatusLine();

        for (int i = 0; i < j.getInt("status.size()"); i++) {
            Assert.assertEquals("pending", j.getString("status[" + i + "]"));
        }

        Assert.assertNotNull(response.getBody()); // Body null kontrolü
        Assert.assertEquals(responseStatusLine, "HTTP/1.1 200 OK");
        Assert.assertEquals(8, response.getHeaders().size()); // Header Key Boyutu
        Assert.assertEquals("[application/json]", response.getHeaders().getValues("Content-Type").toString()); // Content-Type içeriyor mu?
        Assert.assertEquals("[chunked]", response.getHeaders().getValues("Transfer-Encoding").toString()); // Transfer-Encoding içeriyor mu?
        Assert.assertEquals("[keep-alive]", response.getHeaders().getValues("Connection").toString()); // Connection içeriyor mu?
        Assert.assertEquals("[*]", response.getHeaders().getValues("Access-Control-Allow-Origin").toString()); // Access-Control-Allow-Origin içeriyor mu?
        Assert.assertEquals("[GET, POST, DELETE, PUT]", response.getHeaders().getValues("Access-Control-Allow-Methods").toString()); // Access-Control-Allow-Methods içeriyor mu?
        Assert.assertEquals("[Content-Type, api_key, Authorization]", response.getHeaders().getValues("Access-Control-Allow-Headers").toString()); // Access-Control-Allow-Headers içeriyor mu?
        Assert.assertEquals("[Jetty(9.2.9.v20150224)]", response.getHeaders().getValues("Server").toString()); // Server içeriyor mu?
    }
}
