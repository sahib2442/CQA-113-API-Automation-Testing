package com.bridgelabz.qa.api;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Json_Server_API_Automation_Test {
//   ---------------*********post************-------------	
	@Test
	
	public void get_Post() {
		Response response = RestAssured.get("http://localhost:3000/posts");
		System.out.println("Response code: " + response.getStatusCode());
		response.prettyPrint();
		}
	

	@Test
	
	public void get_Spicific_Post() {
		Response response = RestAssured.get("http://localhost:3000/posts/3");
		System.out.println("Response code: " + response.getStatusCode());
		response.prettyPrint();
		}
	@Test
	
	public void create_Post() {
		RequestSpecification requestSpisification = RestAssured.given();
		requestSpisification.header("Content-Type", "application/json");
		JSONObject json = new JSONObject();
		json.put("id", 2);
		json.put("title", "CQA");
		json.put("author", "sahib");
		requestSpisification.body(json.toJSONString());
		Response response = requestSpisification.post("http://localhost:3000/posts");
		System.out.println("Response code: " + response.getStatusCode());
		response.prettyPrint();
	}
	
    @Test
	
	public void Update_Post() {
		RequestSpecification requestSpisification = RestAssured.given();
		requestSpisification.header("Content-Type", "application/json");
		JSONObject json = new JSONObject();
		json.put("id", 2);
		json.put("title", "CQA-113");
		json.put("author", "sahib");
		requestSpisification.body(json.toJSONString());
		Response response = requestSpisification.put("http://localhost:3000/posts/2");
		System.out.println("Response code: " + response.getStatusCode());
		response.prettyPrint();
	}

    @Test

    public void update_Posts() {
	    RequestSpecification requestSpisification = RestAssured.given();
	    requestSpisification.header("Content-Type", "application/json");
	    JSONObject json = new JSONObject();
	    json.put("id", 2);
	    json.put("title", "automation");
	    json.put("author", "sahib");
	    requestSpisification.body(json.toJSONString());
	    Response response = requestSpisification.patch("http://localhost:3000/posts/2");
	    System.out.println("Response code: " + response.getStatusCode());
	    response.prettyPrint();
       }
    
    @Test

    public void delete_Post() {
	    RequestSpecification requestSpisification = RestAssured.given();
	    requestSpisification.header("Content-Type", "application/json");
	    JSONObject json = new JSONObject();
	    json.put("id", 2);
	    json.put("title", "automation");
	    json.put("author", "sahib");
	    requestSpisification.body(json.toJSONString());
	    Response response = requestSpisification.delete("http://localhost:3000/posts/2");
	    System.out.println("Response code: " + response.getStatusCode());
	    response.prettyPrint();
        }
//     ---------************Command********--------------
    

	@Test
	
	public void get_Command() {
		Response response = RestAssured.get("http://localhost:3000/comments");
		System.out.println("Response code: " + response.getStatusCode());
		response.prettyPrint();
		}
	
	 @Test
	 
	 public void get_Spicific_Command() {
			Response response = RestAssured.get("http://localhost:3000/comments/3");
			System.out.println("Response code: " + response.getStatusCode());
			response.prettyPrint();
			}
	
	 @Test
	 
	 public void create_Command() {
			RequestSpecification requestSpisification = RestAssured.given();
			requestSpisification.header("Content-Type", "application/json");
			JSONObject json = new JSONObject();
			json.put("id", 2);
			json.put("body", "Command is");
			json.put("postId", "2");
			requestSpisification.body(json.toJSONString());
			Response response = requestSpisification.post("http://localhost:3000/comments");
			System.out.println("Response code: " + response.getStatusCode());
			response.prettyPrint();
		    }
	 
	    @Test
	    
	    public void update_Command() {
			RequestSpecification requestSpisification = RestAssured.given();
			requestSpisification.header("Content-Type", "application/json");
			JSONObject json = new JSONObject();
			json.put("id", 2);
			json.put("body", "First Command");
			json.put("postId", "2");
			requestSpisification.body(json.toJSONString());
			Response response = requestSpisification.put("http://localhost:3000/comments/2");
			System.out.println("Response code: " + response.getStatusCode());
			response.prettyPrint();
		    }
	    
	    @Test
	    
	    public void update_Commands() {
			RequestSpecification requestSpisification = RestAssured.given();
			requestSpisification.header("Content-Type", "application/json");
			JSONObject json = new JSONObject();
			json.put("id", 2);
			json.put("body", "Command is the");
			json.put("postId", "2");
			requestSpisification.body(json.toJSONString());
			Response response = requestSpisification.patch("http://localhost:3000/comments/2");
			System.out.println("Response code: " + response.getStatusCode());
			response.prettyPrint();
		    }
	    
	    @Test
	    
	    public void delete_Command() {
			RequestSpecification requestSpisification = RestAssured.given();
			requestSpisification.header("Content-Type", "application/json");
			JSONObject json = new JSONObject();
			json.put("id", 2);
			json.put("body", "Command is");
			json.put("postId", "2");
			requestSpisification.body(json.toJSONString());
			Response response = requestSpisification.delete("http://localhost:3000/comments/2");
			System.out.println("Response code: " + response.getStatusCode());
			response.prettyPrint();
		    }
	    
	    @Test
	    
	    public void fecth_The_All_Command_In_One_Post() {
			Response response = RestAssured.get("http://localhost:3000/comments?postId=1");
			System.out.println("Response code: " + response.getStatusCode());
			response.prettyPrint();
			}
//   ------------**********Profile**********-----------
	    
	    @Test
	    
	    public void get_Profile() {
			Response response = RestAssured.get("http://localhost:3000/profile");
			System.out.println("Response code: " + response.getStatusCode());
			response.prettyPrint();
			}
	    
	    

}
