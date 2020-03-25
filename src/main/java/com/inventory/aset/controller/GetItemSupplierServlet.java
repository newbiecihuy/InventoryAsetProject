/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.controller;

import com.inventory.aset.facadebean.EntityProductsFacade;
import com.inventory.aset.model.EntityProducts;
import com.inventory.aset.model.EntityStock;
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
import com.inventory.aset.facadebean.local.EntityProductsFacadeLocal;
import com.inventory.aset.facadebean.local.EntityStockFacadeLocal;

/**
 *
 * @author newbiecihuy
 */
@WebServlet(name = "GetItemSupplierServlet", urlPatterns = {"/getItemSupplierServlet"})
public class GetItemSupplierServlet extends HttpServlet {

    public GetItemSupplierServlet() {

    }
    @EJB
    EntityProductsFacadeLocal entityProductsFacadeLocal;
    @EJB
    EntityStockFacadeLocal entityStockFacadeLocal;

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
//            out.println("<title>Servlet GetItemSupplierServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet GetItemSupplierServlet at " + request.getContextPath() + "</h1>");
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
//        processRequest(request, response);
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
            String item_name_po = "";
            System.out.println("supplier_name: " + supplier_name);
            Long idSupplier = null;
            System.out.println("doPost GetItemSupplierServlet");
//            if (jsonObject.containsKey("supplier_code")) {
//                supplier_code = jsonObject.getString("supplier_code");
//                param2 = supplier_code;
//            }
            if (!jsonObject.getString("item_name_po").isEmpty() && jsonObject.getString("item_name_po") != null) {
                item_name_po = jsonObject.getString("item_name_po").trim().replaceAll("['\":<>\\[\\],-]", "");
            }
            if (!jsonObject.getString("idSupplier").isEmpty() && jsonObject.getString("idSupplier") != null) {
                idSupplier = Long.parseLong(jsonObject.getString("idSupplier").trim().replaceAll("['\":<>\\[\\],-]", ""));
            }
            List<EntityProducts> dataItem = entityProductsFacadeLocal.getItemDetails(idSupplier, item_name_po);//null;

            JSONArray jsonArray = new JSONArray();
            JSONObject obj = new JSONObject();
            if (dataItem.size() > 0) {
                for (int i = 0; i < dataItem.size(); i++) {
                    EntityProducts entityProducts = (EntityProducts) dataItem.get(i);
                    EntityStock dataStock = entityStockFacadeLocal.find(entityProducts.getIdProduct());

                    if (entityProducts.getIdProduct() == null) {
                        obj.put("product_id", "");
                    } else {
                        obj.put("product_id", entityProducts.getIdProduct());
                    }
                    if (entityProducts.getSupplierId().getSupplierId() == null) {
                        obj.put("supplier_id", "");
                    } else {
                        obj.put("supplier_id", entityProducts.getSupplierId().getSupplierId());
                    }
                    if (entityProducts.getProductName() == null) {
                        obj.put("item_name_po", "");
                    } else {
                        obj.put("item_name_po", EncryptionUtil.upperCaseFirst(entityProducts.getProductName()));
                    }
                    if (dataStock.getEstematedDateBefore() == null) {
                        obj.put("dateBefore", "");
                    } else {
                        obj.put("dateBefore", dataStock.getEstematedDateBefore());
                    }
                    if (dataStock.getEstematedDateAfter() == null) {
                        obj.put("dateAfter", "");
                    } else {
                        obj.put("dateAfter", dataStock.getEstematedDateAfter());
                    }
                    if (dataStock.getBuyPrice() == null) {

                    } else {
                        obj.put("unit_price_po", dataStock.getBuyPrice());
                    }
                    jsonArray.add(obj);
                }
            } else {
                obj.put("product_id", "0");
                obj.put("supplier_id", idSupplier);
                obj.put("item_name_po", "supplier don't have items");
                obj.put("dateBefore", "0");
                obj.put("dateAfter", "0");
                obj.put("unit_price_po", "0");
            }
            out.print(obj.toString());
            System.out.println("isi obj: " + obj.toString());
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
