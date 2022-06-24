/*
 * Licensed Materials - Property of IBM
 * 5737-I23
 * Copyright IBM Corp. 2018 - 2022. All Rights Reserved.
 * U.S. Government Users Restricted Rights:
 * Use, duplication or disclosure restricted by GSA ADP Schedule
 * Contract with IBM Corp.
 */
package com.ibm.ads.samples.quarkus.simple;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class DecisionResourceTest {

    @Test
    public void testSampleInput() {
        given().when().get("/decision/input-sample?operation=approval")
            .then()
                .statusCode(200)
                .body(containsString("borrower"));
    }

    @Test
    public void testOperations() {
        var r = given().when().get("/decision/operations")
                .then()
                    .statusCode(200)                
                    .body(containsString("approval"));
    }

}