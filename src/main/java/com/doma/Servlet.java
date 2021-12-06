package com.doma;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "abbas", urlPatterns = "/abbas")
public class Servlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String roomId = request.getParameter("roomId"), finalk = "NOT FOUND !";
        try {
            finalk = MySqlClass.getChat(roomId);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        response.getWriter().println(finalk);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        String roomId = request.getParameter("roomId");
        String message = request.getParameter("message");
        try {
            MySqlClass.witeData(roomId, message, userId);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
