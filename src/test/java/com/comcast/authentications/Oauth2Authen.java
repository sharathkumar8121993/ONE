package com.comcast.authentications;


import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Oauth2Authen {
    @Test
    public void oAuth2() {
        //provide client id and client secret to generate code
        Response resp = given()
                .formParam("client_id", "sdet18_2021")
                .formParam("client_secret", "44d4fd4eff30154e852996e51e32ff19")
                .formParam("grant_type", "client_credentials")
                .formParam("redirect_uri", "http://spidermanexample.com").
//generate the token
        when().post("http://coop.apps.symfonycasts.com/token\n");
        //System.out.println(resp.asPrettyString());
        String mytoken = resp.jsonPath().get("access_token");
        System.out.println(mytoken);

        //use this tokenin any API
        given().auth().oauth2(mytoken).pathParam("USER_ID", "2124")
                .when().post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-collect").then().log().all();

    }
}
