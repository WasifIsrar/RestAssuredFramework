package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {
	
	public static Response createUser(User payload)
	{
		Response response=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(Routes.postUrl);
		return response;
	}
	
	public static Response readUser(String username) {
		Response response=given()
				.pathParam("username", username)
			.when()
				.get(Routes.getUrl);
			return response;
	}
	
	public static Response updateUser(String username,User payload) {
		Response response=given()
				.pathParam("username", username)
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
			.when()
				.put(Routes.updateUrl);
			return response;
	}

}
