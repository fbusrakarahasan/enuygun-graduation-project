#### 👨🏻‍💻 /allGrocery/
***  

<details>
  <summary>(<i>Testi görüntülemek için tıklayın</i>)</summary>

```java 
@Test
    public void AllGrocery() {
        String requestUrl = String.format("%s/allGrocery/", baseURL);

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

        Assert.assertNotNull(response.getBody()); // Body null kontrolü
        Assert.assertEquals(responseStatusLine, "HTTP/1.1 200 OK");
    }
``` 
</details>

<br>

#### 👨🏻‍💻 /allGrocery/apple
*** 
 
<details>
  <summary>(<i>Testi görüntülemek için tıklayın</i>)</summary>

```java 
@Test
    public void AllGroceryName() {
        String requestUrl = String.format("%s/allGrocery/apple", baseURL);

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

        Assert.assertEquals("1", j.getString("data[0].id"));
        Assert.assertEquals("apple", j.getString("data[0].name"));
        Assert.assertEquals("3", j.getString("data[0].price"));
        Assert.assertEquals("100", j.getString("data[0].stock"));

        Assert.assertNotNull(response.getBody()); // Body null kontrolü
        Assert.assertEquals(responseStatusLine, "HTTP/1.1 200 OK");
    }
``` 
</details>
 
<br>

#### 👨🏻‍💻 /add
*** 
 
<details>
  <summary>(<i>Testi görüntülemek için tıklayın</i>)</summary>

```java 
@Test
    public void AddGrocery() {
        String requestUrl = String.format("%s/add", baseURL);


        String postData = "{\n" +
                "\"id\": 1,\n" +
                "\"name\": \"apple\",\n" +
                "\"price\": 12.3,\n" +
                "\"stock\": 3\n" +
                "}";

        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                        .body(postData)
                        .when()
                        .post(requestUrl)
                        .then()
                        .statusCode(200)
                        .time(lessThan(4000L))
                        .extract().response();


        String responseStatusLine = response.getStatusLine();
        JsonPath j = new JsonPath(response.asString());

        Assert.assertEquals("1", j.getString("id"));
        Assert.assertEquals("apple", j.getString("name"));
        Assert.assertEquals("12.3", j.getString("price"));
        Assert.assertEquals("3", j.getString("stock"));

        Assert.assertNotNull(response.getBody()); // Body null kontrolü
        Assert.assertEquals(responseStatusLine, "HTTP/1.1 200 OK");
    }
``` 
</details>
