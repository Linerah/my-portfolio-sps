package com.google.sps.servlets;

// imports for the DataStore 
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.api.client.util.store.DataStore;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // Create an instance of Datastore database
    Datastore database = DatastoreOptions.getDefaultInstance().getService();

    // Creat a key factory with a kind to store in the Entity
    KeyFactory keyFactory = database.newKeyFactory().setKind("Contact");

    // Get the value entered in the form.
    // Uses Jsoup to o sanitize user input, like users entering HTML tags or JavaScript in their input. 
    // Not handling this can lead to security issues like cross-site scripting (XSS).
    String fname = Jsoup.clean(request.getParameter("firstname"), Whitelist.none());
    String lname = Jsoup.clean(request.getParameter("lastname"), Whitelist.none());
    String email = Jsoup.clean(request.getParameter("email"), Whitelist.none());
    String reason = Jsoup.clean(request.getParameter("reason"), Whitelist.none());
    String info = Jsoup.clean(request.getParameter("info"), Whitelist.none());

    // Create an entity with its key and properties
    FullEntity taskEntity =
        Entity.newBuilder(keyFactory.newKey())
            .set("firstname", fname)
            .set("lastname", lname)
            .set("email", email)
            .set("reason", reason)
            .set("subject", info)
            .build();

    // Puts the entity/data in the database/Datastore
     database.put(taskEntity);


    // Print the value so you can see it in the server logs.
    System.out.println("Their name: " + fname);
    System.out.println("Their last name: " + lname);
    System.out.println("Their email: " + email);
    System.out.println("Their reason: " + reason);
    System.out.println("Their summary: " + info);


    // Write a response if i decide not to redirect the user to the index.html
    response.getWriter().println("Your submission has been received");
    
    // To redirect the user, when submmiting the info
    response.sendRedirect("/index.html");
  }
}