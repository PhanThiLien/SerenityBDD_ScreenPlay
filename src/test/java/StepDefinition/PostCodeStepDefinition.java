package StepDefinition;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.util.EnvironmentVariables;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class PostCodeStepDefinition {
    private String theRestApiBaseUrl;
    private EnvironmentVariables environmentVariables;
    private Actor sam;
    private RequestSpecification requestSpec;
    private ResponseSpecification responseSpecification;

    @Before
    public void set_the_stage() {
        theRestApiBaseUrl = environmentVariables.optionalProperty("restapi.baseurl")
                .orElse("http://api.zippopotam.us");

        sam = Actor.named("Sam the supervisor")
                .whoCan(CallAnApi.at(theRestApiBaseUrl));

        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri(theRestApiBaseUrl);
        builder.setContentType("application/json");
        requestSpec = builder.build();

        ResponseSpecBuilder responseBuilder = new ResponseSpecBuilder();
        responseBuilder.expectContentType("application/json").expectStatusCode(200);
        responseSpecification = responseBuilder.build();

    }

    @When("^I look up a post code (.*) for country code (.*)$")
    public void look_up_a_postcode_for_country_code(int postCode, String countryCode) {
//        RestAssured.given().
//                        spec(requestSpec).
//                        basePath("/{countryCode}/{postCode}").
//                        pathParam("countryCode", countryCode).
//                        pathParam("postCode", postCode)
//                    .when().
//                        get();
        sam.attemptsTo(
                Get.resource("/{countryCode}/{postCode}")
                        .with(request -> request.given().spec(requestSpec)
                                .pathParam("countryCode", countryCode)
                                .pathParam("postCode", postCode))
        );
    }

    @Then("^the resulting location should be (.*) in (.*)$")
    public void the_resulting_location_should_be(String placeName, String countryName) {
        sam.should(seeThatResponse(response -> response.statusCode(404)));
        restAssuredThat(response -> response.statusCode(404));
//        restAssuredThat(response -> response.spec(responseSpecification).log());

//        RestAssured.expect().spec(responseSpecification).log();
    }

}
