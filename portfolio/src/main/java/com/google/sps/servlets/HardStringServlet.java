package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.Document;

import java.util.Random;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/hardString")
public class HardStringServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    Random randomNum = new Random();
    int index = randomNum.nextInt(5);
    String[] array = {"Hola, yo soy", "Hi, I am", "Aloha, wau", "Salut je suis", "Ciao io sono"};
    response.getWriter().println(array[index]);
  }
}
