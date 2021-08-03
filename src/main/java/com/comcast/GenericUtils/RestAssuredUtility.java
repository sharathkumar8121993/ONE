package com.comcast.GenericUtils;


import io.restassured.response.Response;

/**
 * RestAssured generic methods
 * @author Sharath
 */
public class RestAssuredUtility {
    /**
     * returns json data wrt jsonpath
     * @param response
     * @param jsonxpath
     * @return
     */
    public String jsonPathConstant(Response response, String jsonxpath){
        String jsondata =response.jsonPath().getString(jsonxpath);
        return jsondata;
    }
}
