package com.bridgelabz.qa.api;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class Rest_API_Automation_Testing_Tests {
	
        String token;
		String userid;
		String playlistid;
		String trackid="1Nr46gjiP50uPsz30gYhAd";
		
		@BeforeTest
		
		public void getToken() {
			token = "Bearer BQAecre1xCDvdkZE-RuQJrOvojOst7VE0efVcLGjea5Ue51O0ePnJxxXc12PfwW4zwcL17ie5643gRm6sS17oLEy9KxfAdIMfp7vkaq-yDpQfgp2SQ4oOVUh8QxSv_8JEXSVZctx2NOiBjowhH3rJe2lIQCscar4mm8l9xXD8L76PJi08k44ieI4ws3mn6jJykjwaHJfMddmUfVEumtZ-pOcocav9cB6EN8anNwNEmpfJcMUC-HFp5T1UP6Yj1qlg2O54tkKbxW5H7kATom9M-siW0X2udFGTTyFF8t_";
		}
//     ------------************profile***************----------------	
	   @Test (priority = 1)
		
		public void get_Current_User_Profile() {
			
			Response response =RestAssured.given() 
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					//.header("Accept","application/json")
					//.header("Content-Type","application/json")
					.header("Authorization", token)
					.when()
					.get("https://api.spotify.com/v1/me");
			response.prettyPrint();
			response.then().assertThat().statusCode(200);
			userid=response.path("id");
			System.out.printf("current userid is:"+ userid);
			Assert.assertEquals("316vgajbiwd6frxbqkw4vy33veta", userid);
			
		}
		
		@Test (priority = 2)
		
	    public void get_Users_Profile() {
			
			Response response =RestAssured.given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					//.header("Accept","application/json")
					//.header("Content-Type","application/json")
					.header("Authorization", token)
					.when()
					.get("https://api.spotify.com/v1/users/"+userid+"");
			response.prettyPrint();
			response.then().assertThat().statusCode(200);
		}
//    ----------**********search*********------------	
		@Test (priority = 3)
		
		public void search_For_Items() {
			Response response =RestAssured.given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					//.header("Accept","application/json")
					//.header("Content-Type","application/json")
					.header("Authorization", token)
					.queryParam("q", "anirudh ravichandran")
					.queryParam("type", "track")
					.queryParam("limit", "4")
					.when()
					.get("https://api.spotify.com/v1/search");
			response.prettyPrint();
			response.then().assertThat().statusCode(200);
		}
		
//    ---------********playList**********------------		
		@Test (priority = 4)
		
		public void create_Playlist() {
			Response response =RestAssured.given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					//.header("Accept","application/json")
					//.header("Content-Type","application/json")
					.header("Authorization", token)
					.body("{\r\n"
							+ "  \"name\": \"CQA-113 sahib\",\r\n"
							+ "  \"description\": \"New playlist description\",\r\n"
							+ "  \"public\": false\r\n"
							+ "}")
					.when()
					.post("	https://api.spotify.com/v1/users/"+userid+"/playlists");
			response.prettyPrint();
			response.then().assertThat().statusCode(201);
			playlistid = response.path("id");
			System.out.printf("CQA-113 sahib is:"+ playlistid);
			
			
		}
		
	  @Test (priority = 5)
		
		public void add_Items_To_Playlist() {
			Response response =RestAssured.given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					//.header("Accept","application/json")
					//.header("Content-Type","application/json")
					.header("Authorization", token)
					.queryParam("uris","spotify:track:1Nr46gjiP50uPsz30gYhAd")
					.when()
					.post("https://api.spotify.com/v1/playlists/"+playlistid+"/tracks?uris=spotify:track:6sPW145Y3LSXd4p1LjBOcS&uris=spotify:track:7H7ktpLPBvpJ0A2pwUy4hB");
			response.prettyPrint();
			response.then().assertThat().statusCode(201);
		}
	  
		@Test (priority = 6)
		
		public void get_Current_Users_Playlists() {
			Response response =RestAssured.given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					//.header("Accept","application/json")
					//.header("Content-Type","application/json")
					.header("Authorization", token)
					.when()
					.get("https://api.spotify.com/v1/me/playlists");
			response.prettyPrint();
			response.then().assertThat().statusCode(200);
		}
		
		
		@Test (priority = 7)
		
		public void get_Playlist_Items() {
			Response response =RestAssured.given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					//.header("Accept","application/json")
					//.header("Content-Type","application/json")
					.header("Authorization", token)
					.when()
					.get("https://api.spotify.com/v1/playlists/"+playlistid+"/tracks");
			response.prettyPrint();
			response.then().assertThat().statusCode(200);
		}
		
		@Test (priority = 8)
		
		public void get_Playlist() {
			Response response =RestAssured.given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					//.header("Accept","application/json")
					//.header("Content-Type","application/json")
					.header("Authorization", token)
					.when()
					.get("https://api.spotify.com/v1/playlists/"+playlistid+"");
			response.prettyPrint();
			response.then().assertThat().statusCode(200);
		}
		
		@Test (priority = 9)
		
		public void get_Users_Playlist() {
			Response response =RestAssured.given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					//.header("Accept","application/json")
					//.header("Content-Type","application/json")
					.header("Authorization", token)
					.when()
					.get("https://api.spotify.com/v1/users/"+userid+"/playlists");
			response.prettyPrint();
			response.then().assertThat().statusCode(200);
		}
		
		@Test (priority = 10)
		
		public void get_Playlist_Cover_Image() {
			Response response =RestAssured.given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					//.header("Accept","application/json")
					//.header("Content-Type","application/json")
					.header("Authorization", token)
					.when()
					.get("https://api.spotify.com/v1/playlists/3a56K3Ah4R4Ds29fWsZ4it/images");
			response.prettyPrint();
			response.then().assertThat().statusCode(200);
		}
		
		@Test (priority = 11)
		
		public void change_Playlist_Details() {
			Response response =RestAssured.given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					//.header("Accept","application/json")
					//.header("Content-Type","application/json")
					.header("Authorization", token)
					.body("{\r\n"
							+ "  \"name\": \"CQA-113 kms\",\r\n"
							+ "  \"description\": \"Updated playlist description\",\r\n"
							+ "  \"public\": false\r\n"
							+ "}")
					.when()
					.put("https://api.spotify.com/v1/playlists/3a56K3Ah4R4Ds29fWsZ4it");
			response.prettyPrint();
			response.then().assertThat().statusCode(200);
		}
		
		@Test (priority = 12)
		
		public void update_Playlist_Items() {
			Response response =RestAssured.given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					//.header("Accept","application/json")
					//.header("Content-Type","application/json")
					.header("Authorization", token)
					.queryParam("uris","spotify:track:1Nr46gjiP50uPsz30gYhAd")
					.body("{\r\n"
							+ "  \"range_start\": 1,\r\n"
							+ "  \"insert_before\": 3,\r\n"
							+ "  \"range_length\": 2\r\n"
							+ "}")
					.when()
					.put("	https://api.spotify.com/v1/playlists/3a56K3Ah4R4Ds29fWsZ4it/tracks");
			response.prettyPrint();
			response.then().assertThat().statusCode(201);
		}
		
       @Test (priority = 13)
		
		public void remove_Playlist_Items() {
			Response response =RestAssured.given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					//.header("Accept","application/json")
					//.header("Content-Type","application/json")
					.header("Authorization", token)
					.body("{{\r\n"
							+ "    \"tracks\": [\r\n"
							+ "        {\r\n"
							+ "            \"uri\":\"spotify:track:7H7ktpLPBvpJ0A2pwUy4hB\",\r\n"
							+ "            \"position\":[0]\r\n"
							+ "        }\r\n"
							+ "    ]\r\n"
							+ "}}")
					.when()
					.delete("https://api.spotify.com/v1/playlists/"+playlistid+"/tracks");
			response.prettyPrint();
			response.then().assertThat().statusCode(200);
			playlistid = response.path("id");
			System.out.printf("CQA-113 sahib is:"+ playlistid);
			
			
		}
		
//   ----------**********track*******-----------	
		@Test (priority = 14)
		
		public void get_Track() {
			Response response =RestAssured.given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					//.header("Accept","application/json")
					//.header("Content-Type","application/json")
					.header("Authorization", token)
					.when()
					.get("	https://api.spotify.com/v1/tracks/7H7ktpLPBvpJ0A2pwUy4hB");
			response.prettyPrint();
			response.then().assertThat().statusCode(200);
			trackid = response.path("id");
			System.out.printf("Track id is:"+ trackid);
		}
		
		@Test (priority = 15)
		
		public void get_Several_Track() {
			Response response =RestAssured.given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					//.header("Accept","application/json")
					//.header("Content-Type","application/json")
					.header("Authorization", token)
					.when()
					.get("https://api.spotify.com/v1/tracks/7H7ktpLPBvpJ0A2pwUy4hB");
			response.prettyPrint();
			response.then().assertThat().statusCode(200);
		}
		
		@Test (priority = 16)
		
		public void get_Tracks_Audio_Feature() {
			Response response =RestAssured.given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					//.header("Accept","application/json")
					//.header("Content-Type","application/json")
					.header("Authorization", token)
					.when()
					.get("https://api.spotify.com/v1/audio-features/7H7ktpLPBvpJ0A2pwUy4hB");
			response.prettyPrint();
			response.then().assertThat().statusCode(200);
		}
		
		@Test (priority = 17)
		
		public void get_Several_Tracks_Audio_Feature() {
			Response response =RestAssured.given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					//.header("Accept","application/json")
					//.header("Content-Type","application/json")
					.header("Authorization", token)
					.when()
					.get("https://api.spotify.com/v1/audio-features/7H7ktpLPBvpJ0A2pwUy4hB");
			response.prettyPrint();
			response.then().assertThat().statusCode(200);
		}
		
	    @Test (priority = 18)
		
		public void get_Tracks_Audio_Analiysis() {
			Response response =RestAssured.given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					//.header("Accept","application/json")
					//.header("Content-Type","application/json")
					.header("Authorization", token)
					.when()
					.get("https://api.spotify.com/v1/audio-analysis/7H7ktpLPBvpJ0A2pwUy4hB");
			response.prettyPrint();
			response.then().assertThat().statusCode(200);
	    }
}


