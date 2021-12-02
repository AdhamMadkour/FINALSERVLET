package com.doma;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet(name = "abbas", urlPatterns = "/abbas")
public class Servlet extends HttpServlet {
    
    public static HashMap<String, ArrayList<String>> chatData = new HashMap<String, ArrayList<String>>();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String roomId = request.getParameter("roomId");
        for (String lineChat : chatData.get(roomId)) {
            response.getWriter().println(lineChat);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        String roomId = request.getParameter("roomId");
        String message = request.getParameter("message");
        chatData.putIfAbsent(roomId, new ArrayList<>());
        chatData.get(roomId).add(userId + " : " + message);
    }
}
