package com.readwrite.json;
import java.math.BigInteger;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;

import org.json.JSONException;

public class GsonProgram {

	public static void main(String... args) throws JSONException {
/* Json Java API for JSON Processing – Creating JSON Objects*/
//1.json formate jsonObject1 -> {"name":"Fikret","surname":"Savaş","age":25}

JsonObject jsonObject1 =Json.createObjectBuilder()
                .add("name", "Fikret")
                .add("surname", "Savaş")
                .add("age", 25)
        .build();

    System.out.println("jsonObject1 -> "+jsonObject1+"\n\n");

//2. json formate jsonArray1 -> ["A",5,6.3,false,30,{"name":"Fikret","surname":"Savaş","age":25}]

JsonArray jsonArray1= Json.createArrayBuilder()
        .add("A") // String
        .add(5)   // int
        .add(6.3) // double
        .add(false)  // boolean
        .add(new BigInteger("30"))  // Big(Integer) | (Decimal)
        .add(jsonObject1)  // JsonValue
        .build();

    System.out.println("jsonArray1 -> "+jsonArray1+"\n\n");


	//3.json formate jsonArray2 -> ["Emin","Şahin"]
    
JsonArray jsonArray2=Json.createArrayBuilder()
        .add("Emin").add("Şahin").build();

    System.out.println("jsonArray2 -> "+jsonArray2+"\n\n");
    
 //4. json formate  jsonObject2 -> {"name":["Emin","Şahin"],"surname":"Demir"}

JsonObject jsonObject2 = Json.createObjectBuilder()
        .add("name", jsonArray2)
        .add("surname", "Demir")
        .build();

    System.out.println("jsonObject2 -> "+jsonObject2+"\n\n");

  
  //5 json format jsonObject3 -> {"name":"Ersin","surname":"Çetinkaya","age":25,"address":{"city":"Bursa","country":"Türkiye","zipCode":"33444"},"phones":["234234242","345345354"]}

   
JsonObject jsonObject3 =
    Json.createObjectBuilder()
        .add("name", "Ersin")
        .add("surname", "Çetinkaya")
        .add("age", 25)
        .add("address",
              Json.createObjectBuilder()
                  .add("city", "Bursa")
                  .add("country", "Türkiye")
                  .add("zipCode", "33444"))
        .add("phones",
                      Json.createArrayBuilder()
                          .add("234234242")
                          .add("345345354"))
        .build();

    System.out.println("jsonObject3 -> "+jsonObject3+"\n\n");

	}
}

