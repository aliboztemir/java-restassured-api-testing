package test_resources;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import java_resources.ExternalData;
import java_resources.Payloads;

public class BlingReqSpecs {

    private static String baseUri = ExternalData.getGlobalData("baseUri");
    private static ContentType contentType = ContentType.JSON;
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private static LocalDateTime time;

    public static RequestSpecification blingAwayReqSpec() {
        PrintStream log = null;
        try {
            log = new PrintStream(new FileOutputStream("logging.txt", true));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        time = LocalDateTime.now();
        log.append("\n******************************************************\n");
        log.append("***   Reqres Request Sent at: " + dtf.format(time).toString() + "   ***\n");
        log.append("******************************************************\n\n");

        // Create a generic RequestSpecification that can be used for all Reqres API requests (and not just for AddUserAPI)
        RequestSpecification blingAwayReqSpec = new RequestSpecBuilder()
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
                .setBaseUri(baseUri)
                .setContentType(contentType)
                .build();

        return blingAwayReqSpec;
    }

    public static RequestSpecification getListUsersReqSpec(String data) {
        RequestSpecification getListUsersReqSpec = given().spec(BlingReqSpecs.blingAwayReqSpec());
        return getListUsersReqSpec;
    }

    public static RequestSpecification getSingleUser(String single_user_id, String data) {
        RequestSpecification getSingleUser = given().spec(BlingReqSpecs.blingAwayReqSpec().pathParam("id", single_user_id));
        return getSingleUser;
    }

    public static RequestSpecification createUserReqSpec(String name, String job) {
        RequestSpecification createUserReqSpec = given().spec(BlingReqSpecs.blingAwayReqSpec()).body(Payloads.createUserApiPayload(name, job));
        return createUserReqSpec;
    }

    public static RequestSpecification putUserReqSpec(String user_id, String name, String job) {
        RequestSpecification putUserReqSpec = given().spec(BlingReqSpecs.blingAwayReqSpec()).body(Payloads.putUserApiPayload(name, job)).pathParam("id", user_id);
        return putUserReqSpec;
    }

    public static RequestSpecification patchUserReqSpec(String user_id, String name, String job) {
        RequestSpecification patchUserReqSpec = given().spec(BlingReqSpecs.blingAwayReqSpec()).body(Payloads.patchUserApiPayload(name, job)).pathParam("id", user_id);
        return patchUserReqSpec;
    }

    public static RequestSpecification deleteUserReqSpec(String single_user_id) {
        RequestSpecification deleteUserReqSpec = given().spec(BlingReqSpecs.blingAwayReqSpec()).pathParam("id", single_user_id);
        return deleteUserReqSpec;
    }
}
