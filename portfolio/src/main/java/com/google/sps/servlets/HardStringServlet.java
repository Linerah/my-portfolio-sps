package com.google.sps.servlets;

import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.Document;

import java.util.ArrayList;
import java.util.Random;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/hardString")
public class HardStringServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    ArrayList<String> array = new ArrayList<>();
    array.add("Hola, yo soy");
    array.add("Hi, I am");
    array.add("Aloha, wau");
    array.add("Salut je suis");
    array.add("Ciao io sono");
    String json = convertToJsonUsingGson(array);
    response.setContentType("application/json;");
    response.getWriter().println(json);
  }
    // A method that creates a Json file
    private String convertToJsonUsingGson(ArrayList<String> array) {
        Gson gson = new Gson();
        String json = gson.toJson(array);
        return json;
    }
}
