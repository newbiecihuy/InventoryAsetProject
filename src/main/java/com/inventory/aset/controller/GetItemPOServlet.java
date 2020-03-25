/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.controller;

import com.google.gson.Gson;
import com.inventory.aset.model.EntityCategories;
import com.inventory.aset.model.EntityProducts;
import com.inventory.aset.controller.util.EncryptionUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import com.inventory.aset.facadebean.local.EntityProductsFacadeLocal;

/**
 *
 * @author newbiecihuy
 */
@WebServlet(name = "GetItemPOServlet", urlPatterns = {"/getItemPOServlet"})
public class GetItemPOServlet extends HttpServlet {

    public GetItemPOServlet() {

    }

    @EJB
    EntityProductsFacadeLocal entityProductsFacadeLocal;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet GetItemPOServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet GetItemPOServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
        PrintWriter out = response.getWriter();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date now = new Date();
            String tgl = sdf.format(now);
            Enumeration<String> paramNames = request.getParameterNames();
            String paramName = "";
            String value = "";
            int result = 0;
            String varName = request.getParameter("term").toLowerCase();
             System.out.println("varName" + varName);
            Long varlong = Long.parseLong(request.getParameter("idSupplier").trim().replaceAll("['\":<>\\[\\],-]", ""));
            System.out.println("varlong" + varlong);
            System.out.println("Entered");
            System.out.println("Entered");
            System.out.println("doGet GetItemPOServlet");
            String json = "";
            List<EntityProducts> dataItem = entityProductsFacadeLocal.findBySuplierId(varlong);
            System.out.println("isi dataItem.getResultList()" + dataItem);
            org.json.simple.JSONArray array = new org.json.simple.JSONArray();
            if (!dataItem.isEmpty()) {
                json = new Gson().toJson(dataItem);
                result = dataItem.size();
            } else {
                json = varName;
                result = 1;
            }
            System.out.println("isi json =>" + json);
            response.getWriter().write(EncryptionUtil.upperCaseFirst(json));

            org.json.simple.JSONObject rows = new org.json.simple.JSONObject();
            rows.put("results", result);
            rows.put("rows", array);

            response.getWriter().close();

        } catch (IOException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        } finally {

        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        PrintWriter out = response.getWriter();
//        response.setContentType("application/json; charset=UTF-8");
//        try {
//            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//            Date now = new Date();
//            String tgl = sdf.format(now);
//            Enumeration<String> paramNames = request.getParameterNames();
//            String paramName = "";
//            String value = "";
//            int result = 0;
//            String varName = request.getParameter("term").toLowerCase();
//            Long varlong = Long.parseLong(request.getParameter("idSupplier"));
//            System.out.println("Entered");
//            System.out.println("varName" + varName);
//            String json = "";
//            List<EntityProducts> dataItem = entityProductsDao.findBySuplierId(varlong);
//            System.out.println("isi dataItem.getResultList()" + dataItem);
//            JSONArray jsonArray = new net.sf.json.JSONArray();
//            JSONObject obj = new JSONObject();
//            for (int i = 0; i < dataItem.size(); i++) {
//                EntityProducts entityProducts = (EntityProducts) dataItem.get(i);
//
//                jsonArray.add(obj);
//            }
//            out.print(obj.toString());
//            System.out.println("isi " + obj.toString());
//            out.close();
//
//        } catch (Exception ex) {
//            System.out.println("ERROR: " + ex.getMessage());
//        } finally {
//            out.close();
//        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
