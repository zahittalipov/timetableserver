package com.angelectro.zt.controller;

import com.angelectro.zt.config.Config;
import com.angelectro.zt.entity.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@RestController
@RequestMapping("/user")
public class StudentController {

    @RequestMapping(method = RequestMethod.GET)
    public Student getUser(@RequestParam(value = "firstName") String firstName,
                           @RequestParam(value = "lastName") String lastName,
                           @RequestParam(value = "group") String group) {
        put_message("API");
        return new Student(firstName, lastName, group);
    }

    public void put_message(String api) {
        try {
            JSONObject resultJson = new JSONObject();
            if (Config.registration_ids.size() <= 1)
                resultJson.put("to", Config.registration_ids.getFirst());
            else {
                JSONArray objects = new JSONArray();
                objects.put(Config.registration_ids);
                resultJson.put("registration_ids", objects);
            }
            JSONObject object = new JSONObject();
            object.put("title", "zahit");
            object.put("message", "hello");
            resultJson.put("data", object);
            URL url = new URL("https://android.googleapis.com/gcm/send");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Authorization", "key=" + api);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            ObjectMapper mapper = new ObjectMapper();
            System.out.println(resultJson);
            DataOutputStream output = new DataOutputStream(connection.getOutputStream());
            output.write(resultJson.toString().getBytes());
            output.flush();
            output.close();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = reader.readLine()) != null) {
                response.append(inputLine);
            }
            reader.close();

            // 7. Print result
            System.out.println(response.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}