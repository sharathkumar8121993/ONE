package com.comcast.authentications;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

//token
//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
public class OAuth2_authentications {
    @Test
    public void bearer_token_authentications_Test(){
        HashMap<Object,Object> map=new HashMap<Object, Object>();
        map.put("name","sk");

        given().auth().oauth2("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").body(map).when().post("https://api.github.com/user/repos")
                .then().assertThat().statusCode(201).log().all();

    }
}
