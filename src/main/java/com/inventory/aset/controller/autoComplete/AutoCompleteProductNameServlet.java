/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.controller.autoComplete;

import com.google.gson.Gson;
import com.inventory.aset.entity.EntityProducts;
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
import com.inventory.aset.facadebean.local.EntityProtocolFacadeLocal;

/**
 *
 * @author newbiecihuy
 */
@WebServlet(name = "AutoCompleteProductNameServlet", urlPatterns = {"/autoCompleteProductName"})
public class AutoCompleteProductNameServlet extends HttpServlet {

    public AutoCompleteProductNameServlet() {

    }
    @EJB
    EntityProductsFacadeLocal entityProductsDaoLocal;

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

            String varName = request.getParameter("term").toLowerCase();
            System.out.println("Entered");
            System.out.println("varName" + varName);
            String json = "";

            List<EntityProducts> isi_productName = entityProductsDaoLocal.findByProductName(varName);;
            System.out.println("isi isi_productName.getResultList()" + isi_productName);

            JSONArray array = new JSONArray();
//      
            if (isi_productName != null) {
                json = new Gson().toJson(isi_productName);
            } else {
                json = varName;
            }
            response.getWriter().write(json);

            JSONObject rows = new JSONObject();
            rows.put("results", isi_productName.size());
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
