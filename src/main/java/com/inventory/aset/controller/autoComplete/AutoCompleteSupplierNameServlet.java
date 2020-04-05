/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.controller.autoComplete;

import com.google.gson.Gson;
import com.inventory.aset.model.EntitySuppliers;
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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.inventory.aset.facadebean.local.EntitySuppliersFacadeLocal;

/**
 *
 * @author newbiecihuy
 */
@WebServlet(name = "AutoCompleteSupplierNameServlet", urlPatterns = {"/autoCompleteSupplierName"})
public class AutoCompleteSupplierNameServlet extends HttpServlet {

    public AutoCompleteSupplierNameServlet() {

    }
    @EJB
    EntitySuppliersFacadeLocal entitySupplieFacade;

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
            System.out.println("doGet AutoCompleteSupplierNameServlet");
            String varName = request.getParameter("term").toLowerCase();
            System.out.println("Entered");
            System.out.println("varName" + varName);
            String json = "";

            List<EntitySuppliers> isi_supplierName = entitySupplieFacade.findBySupplierName(varName);
            System.out.println("isi_supplierName.getResultList()" + isi_supplierName);

            JSONArray array = new JSONArray();
            json = new Gson().toJson(isi_supplierName);

            response.getWriter().write(json);

            JSONObject rows = new JSONObject();
            rows.put("results", isi_supplierName.size());
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
