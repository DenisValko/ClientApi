import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;


public class TestApi {
    @Order(1)
    @Test
    public void ShowUserPlans() {

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
    @Order(2)
    @Test
    public void ShowPopups(){

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
                .and().body("data.showPopups.edges[0].type",equalTo(6))
                .and().body("data.showPopups.result.code", equalTo(200))
                .extract()
                .response();
    }
    @Order(3)
    @Test
    public void ShowWidget(){
        //String idNum  = "ce1f1047-db7b-4c4d-a891-28949df6c65d";
        RestAssured.baseURI = ConfProperties.getProperty("preprodUrl");
        String query = ConfProperties.getProperty("bodyShowWidget");
        Response response = given()
                .header("Host", "pre.sendpulse.com")
                .header("content-type", "Application/json")
                //.log().all()
                .body(query)
                .when()//.log().all()
                .post("api/pop-ups/schema")
                .then()
                .assertThat().statusCode(200)
                .and().body("data.showWidget.Widget.id", equalTo(ConfProperties.getProperty("widgetId")))
                .and().body("data.showWidget.result.code", equalTo(200))
                .extract()
                .response();
    }
    @Order(4)
    @Test
        public void ShowProjectActionButtons(){


        RestAssured.baseURI = ConfProperties.getProperty("preprodUrl");
        String query = ConfProperties.getProperty("bodyShowProjectActionButtons");
        Response response = given()
                .header("Host", "pre.sendpulse.com")
                .header("content-type", "Application/json")
                //.log().all()
                .body(query)
                .when()//.log().all()
                .post("api/pop-ups/schema")
                .then()
                .assertThat().statusCode(200)
                .and().body("data.showWidgetActionButtons.result.code", equalTo(200))
                .extract()
                .response();
    }



}
