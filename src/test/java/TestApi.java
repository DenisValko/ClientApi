import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.junit.Test;


public class TestApi {
    @Test
    public void Tests1() {

        RestAssured.baseURI = ConfProperties.getProperty("preprodUrl");
        String query = ConfProperties.getProperty("bodyShowUserPlans");
        given()
                .header("Host", "pre.sendpulse.com")
                .header("content-type", "Application/json")
                //.log().all()
                .body(query)
                .when()//.log().all()
                .post("api/pop-ups/schema")
                .then()
                .assertThat().statusCode(200)
                .and().body("data.showUserPlans.edges[0].status",
                        equalTo(1))
                .and().body("data.showUserPlans.result.code", equalTo(200));

    }

    @Test
    public void Test2(){

        RestAssured.baseURI = ConfProperties.getProperty("preprodUrl");
        String query = ConfProperties.getProperty("bodyShowPopups");
        Response response = given()
                .header("Host", "pre.sendpulse.com")
                .header("content-type", "Application/json")
                //.log().all()
                .body(query)
                .when()//.log().all()
                .post("api/pop-ups/schema")
                .then()
                .assertThat().statusCode(200)
                .and().body("data.showPopups.edges[0].type",
                        equalTo(6))
                .and().body("data.showPopups.result.code", equalTo(200))
                .extract()
                .response();
    }
    @Test
    public void Test3(){




    }
}
