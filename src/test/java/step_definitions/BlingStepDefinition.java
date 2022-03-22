package step_definitions;

import static org.junit.Assert.*;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import test_resources.Utilities;
import test_resources.BlingReqSpecs;
import test_resources.BlingRespSpecs;

public class BlingStepDefinition {

    private RequestSpecification blingReqSpec = null;
    private Response blingResponse = null;
    private static String task_id = "";
    private static String access_token = "";
    private static String user_id = "";
    private static String single_user_id = "";


    public static String getTaskId() {
        return task_id;
    }

    public static String getAccessToken() {
        return access_token;
    }


    @When("{word} request is sent as {word} HTTP request")
    public void request_is_sent_as_http_request(String api, String requestType) {
        blingResponse = Utilities.getResource(blingReqSpec, api, requestType);

        if (api.equalsIgnoreCase("LoginAPI")) {
            access_token = Utilities.getResponseValue(blingResponse, "access_token");
        }
        if (api.equalsIgnoreCase("AddTaskAPI")) {
            task_id = Utilities.getResponseValue(blingResponse, "data.id");
        }

        if (api.equalsIgnoreCase("CreateUserAPI")) {
            user_id = Utilities.getResponseValue(blingResponse, "id");
            System.out.println("..........    user_id " + user_id);
        }

        if (api.equalsIgnoreCase("ListUsersAPI")) {
            single_user_id = Utilities.getResponseValue(blingResponse, "data[0].id");
            System.out.println("..........    single_user_id " + single_user_id);
        }
    }

    @Then("success/fail response is sent back with status code {int}")
    public void response_is_sent_back_with_status_code(int code) {
        // Then() part of request
        blingResponse = BlingRespSpecs.applyRespSpec(blingResponse, code);
    }

    @Then("{word} value in response is {string}")
    public void value_in_response_is(String data, String expectedValue) {
        // Retrieve actual value from response
        String actualValue = Utilities.getResponseValue(blingResponse, data);

        // Check actual data value matches expected data value in response
        assertEquals(actualValue, expectedValue);
    }

    @Then("place_id maps to {word} {string} using GetPlaceAPI")
    public void place_id_maps_to_data_using_get_place_api(String data, String expectedValue) {
        // Get data from GetUserAPI response
        String actualValue = Utilities.getResponseValue(blingResponse, data);

        // Check actual data value matches expected data value in response
        assertEquals(actualValue, expectedValue);
    }

    @Then("length of {word} value in response must be greater than zero")
    public void length_of_id_value_in_response_must_be_greater_than_zero(String data) {
        // Get data from GetUserAPI response
        String actualValue = Utilities.getResponseValue(blingResponse, data);
        assertTrue(actualValue.length() > 0);
    }

    @Then("response time must be less than {int} ms")
    public void response_time_must_be_less_than_ms(Integer responseTime) {
        long actualValue = BlingRespSpecs.applyRespTimeSpec(blingResponse);
        assertTrue(actualValue < responseTime);
    }


    @Then("Validate that the {word} of the last created Task is in the list")
    public void validate_that_the_id_of_the_last_created_task_is_in_the_list(String data) {
        // Retrieve actual value from response
        Assert.assertTrue(Utilities.extractValueInResponseItemList(blingResponse, data));
    }


    @Given("a {word} ListUsersAPI request")
    public void a_valid_list_users_api_request(String data) {
        blingReqSpec = BlingReqSpecs.getListUsersReqSpec(data);
    }


    @Given("a {word} SingleUserAPI request")
    public void a_valid_single_user_api_request(String data) {
        blingReqSpec = BlingReqSpecs.getSingleUser(single_user_id, data);
    }

    @Given("a valid CreateUserAPI payload with data {string} {string}")
    public void a_valid_create_user_api_payload_with_data(String name, String job) {
        blingReqSpec = BlingReqSpecs.createUserReqSpec(name, job);
    }

    @Given("a valid PutUserAPI payload with data {string} {string}")
    public void a_valid_put_user_api_payload_with_data(String name, String job) {
        blingReqSpec = BlingReqSpecs.putUserReqSpec(user_id, name, job);
    }

    @Given("a valid PatchUserAPI payload with data {string} {string}")
    public void a_valid_patch_user_api_payload_with_data(String name, String job) {
        blingReqSpec = BlingReqSpecs.patchUserReqSpec(user_id, name, job);
    }

    @Given("a valid DeleteUserAPI request")
    public void a_valid_delete_user_api_request() {
        blingReqSpec = BlingReqSpecs.deleteUserReqSpec(single_user_id);
    }
}
