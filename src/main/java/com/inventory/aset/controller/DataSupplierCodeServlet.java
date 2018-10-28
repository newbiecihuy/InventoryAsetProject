/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.controller;

import com.inventory.aset.entity.EntitySuppliers;
import com.inventory.aset.util.EncryptionUtil;
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
@WebServlet(name = "DataSupplierCodeServlet", urlPatterns = {"/dataSupplierCodeServlet"})
public class DataSupplierCodeServlet extends HttpServlet {

    public DataSupplierCodeServlet() {

    }
    @EJB
    EntitySuppliersFacadeLocal entitySupplierDao;

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
            if (!jsonObject.getString("supplier_code_po").isEmpty() && jsonObject.getString("supplier_code_po") != null) {
                supplier_code = jsonObject.getString("supplier_code_po");
                param = supplier_code;
            }
//            System.out.println("supplier_code: " + supplier_code);
            List<EntitySuppliers> dataSuppliers = entitySupplierDao.getSupplierCode(param);//null;
            JSONArray jsonArray = new JSONArray();
            JSONObject obj = new JSONObject();

            for (int i = 0; i < dataSuppliers.size(); i++) {
                EntitySuppliers entitySuppliers = (EntitySuppliers) dataSuppliers.get(i);

                if (entitySuppliers.getSupplierId() == null) {
                    obj.put("supplier_id", "");
                } else {
                    obj.put("supplier_id", entitySuppliers.getSupplierId());
                }
                if (entitySuppliers.getSupplierName() == null) {
                    obj.put("supplier_name", "");
                } else {
                    obj.put("supplier_name", EncryptionUtil.upperCaseFirst(entitySuppliers.getSupplierName()));
                }
                if (entitySuppliers.getSupplierCode() == null) {
                    obj.put("supplier_code", "");
                } else {
                    obj.put("supplier_code", EncryptionUtil.upperCaseFirst(entitySuppliers.getSupplierCode()));
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
