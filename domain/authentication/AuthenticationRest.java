package api.domain.authentication;

import static io.restassured.RestAssured.*;

import static org.hamcrest.CoreMatchers.*;

import org.json.simple.JSONObject;
import org.junit.Test;

import io.restassured.http.ContentType;
import api.base.BaseRest;
import org.junit.jupiter.api.Tag;

public class AuthenticationRest extends BaseRest {

    @Test
    @SuppressWarnings("unchecked")
    public void authenticationSuccess() {

        String url = "https://keycloak.dev.apptrato.com.br/auth/realms/trato/protocol/openid-connect/token";
        JSONObject payload = new JSONObject();

        given()
                .relaxedHTTPSValidation()
                .header("x-application-key", applicationKey)
                .contentType("application/x-www-form-urlencoded")
                .formParam("grant_type","password")
                .formParam("client_id","web")
                .formParam("username",emailAdmin)
                .formParam("password",password)


                .when()
                .post(url)

                .then()
                .statusCode(200);
    }

    @SuppressWarnings("unchecked")
    //@Test
    public void authenticationFailed() {

        String url = enviroment + "/integra-rodo-entidades/v1/security/authenticate";
        JSONObject payload = new JSONObject();
        payload.put("username", emailAdmin);
        payload.put("password", "SenhaErrada");

        given()
                .relaxedHTTPSValidation()
                .header("X-Application-Key", applicationKey)
                .contentType("application/json")
                .body(payload)

                .when()
                .post(url)

                .then()
                .statusCode(401)
                .contentType(ContentType.JSON)
                .body("code", equalTo("password.invalid.attempt"))
                .body("message", anything());
    }


    @SuppressWarnings("unchecked")
    //@Test
    public void authenticationUnregistredUser() {

        String url = enviroment + "/integra-rodo-entidades/v1/security/authenticate";
        JSONObject payload = new JSONObject();

        payload.put("username", emailAdmin);
        payload.put("password", password);



        given()
                .relaxedHTTPSValidation()
                .header("X-Application-Key", applicationKey)
                .contentType("application/json")
                .body(payload)

                .when()
                .post(url)

                .then()
                .statusCode(401)
                .contentType(ContentType.JSON)
                .body("code", equalTo("user.not.found"))
                .body("message", equalTo("Usuário não cadastrado."));

    }

}
