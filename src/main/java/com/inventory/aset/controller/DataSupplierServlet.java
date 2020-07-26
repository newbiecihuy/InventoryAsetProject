/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.controller;

import com.inventory.aset.model.EntitySuppliers;
import com.inventory.aset.controller.util.EncryptionUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import com.inventory.aset.facadebean.local.EntitySuppliersFacadeLocal;

/**
 *
 * @author newbiecihuy
 */
@WebServlet(name = "DataSupplierServlet", urlPatterns = {"/dataSupplierServlet"})
public class DataSupplierServlet extends HttpServlet {

    public DataSupplierServlet() {

    }
    @EJB
    EntitySuppliersFacadeLocal entitySupplierFacade;

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
//            out.println("<title>Servlet DataSupplierServlet</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet DataSupplierServlet at " + request.getContextPath() + "</h1>");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        PrintWriter out = response.getWriter();
        response.setContentType("application/json; charset=UTF-8");

        try {

            JSONObject jsonObject = (JSONObject) JSONSerializer.toJSON(request.getParameter("jsonfield"));
            System.out.println("isi jsonObject" + jsonObject);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            Date now = new Date();
            String strDate = sdf.format(now);
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            Date tgl = new Date();
            String time = dateFormat.format(tgl);

            String supplier_name = "";
            String param = "";
            String param2 = "null";
            System.out.println("supplier_name: " + supplier_name);
            String supplier_code = null;
//            if (jsonObject.containsKey("supplier_code")) {
//                supplier_code = jsonObject.getString("supplier_code");
//                param2 = supplier_code;
//            }
            if (!jsonObject.getString("supplier_name").isEmpty() && jsonObject.getString("supplier_name") != null) {
                supplier_name = jsonObject.getString("supplier_name");
                param = supplier_name;
            }
//            System.out.println("supplier_code: " + supplier_code);
            List<EntitySuppliers> dataSuppliers = entitySupplierFacade.listSupplierName(param);//null;
            JSONArray jsonArray = new JSONArray();
            JSONObject obj = new JSONObject();

            for (int i = 0; i < dataSuppliers.size(); i++) {
                EntitySuppliers entitySuppliers = (EntitySuppliers) dataSuppliers.get(i);

                if (entitySuppliers.getPartnerId()== null) {
                    obj.put("supplier_id", "");
                } else {
                    obj.put("supplier_id", entitySuppliers.getPartnerId());
                }
                if (entitySuppliers.getName()== null) {
                    obj.put("supplier_name", "");
                } else {
                    obj.put("supplier_name", EncryptionUtil.upperCaseFirst(entitySuppliers.getName()));
                }
                if (entitySuppliers.getPartnerCode() == null) {
                    obj.put("supplier_code", "");
                } else {
                    obj.put("supplier_code", EncryptionUtil.upperCaseFirst(entitySuppliers.getPartnerCode()));
                }
                if (entitySuppliers.isTax()) {
                    obj.put("tax", "1");
                } else {
                    obj.put("tax", "0");
                }
                jsonArray.add(obj);
            }
            out.print(obj.toString());
            out.close();

        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
        } finally {
            out.close();
        }
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
