/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.controller;

import com.inventory.aset.controller.util.EncryptionUtil;
import com.inventory.aset.facadebean.local.EntityCategoriesFacadeLocal;
import com.inventory.aset.facadebean.local.EntityProductsFacadeLocal;
import com.inventory.aset.facadebean.local.EntityStockFacadeLocal;
import com.inventory.aset.facadebean.local.EntitySuppliersFacadeLocal;
import com.inventory.aset.model.EntityProducts;
import com.inventory.aset.model.EntityStock;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *
 * @author newbiecihuy
 */
@WebServlet(name = "StockItemRaw", urlPatterns = {"/stockItemRaw"})
public class StockItemRaw extends HttpServlet {

    public StockItemRaw() {

    }
    @EJB
    EntityProductsFacadeLocal entityProducts;
    @EJB
    EntityCategoriesFacadeLocal entityCategories;
    @EJB
    EntitySuppliersFacadeLocal entitySuppliers;
    @EJB
    EntityStockFacadeLocal entityStock;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        System.out.println("Inside doGet CreatePOItem");
        PrintWriter out = response.getWriter();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date now = new Date();
            String tgl = sdf.format(now);

            String searchField = request.getParameter("searchField");
            String searchString = request.getParameter("search[value]");
            System.out.println("isi searchField: " + searchField);
            System.out.println("isi searchString: " + searchString);
            String status = request.getParameter("status");

//            String rows = request.getParameter("rows");
            String page = request.getParameter("page");

            // default
            String draw = "0";
            String start = "0";
            String length = "";
            String orderColumnIndex = "0";
            String orderDir = "asc";
            draw = request.getParameter("draw");
            start = request.getParameter("start");
            length = request.getParameter("length");

            System.out.println("length" + length);
//            System.out.println("page" + page);
            int totalPages = 0;
            int totalCount = 0;

//            if (totalCount > 0) {
//                if (totalCount % Integer.parseInt(rows) == 0) {
//                    totalPages = totalCount / Integer.parseInt(rows);
//                } else {
//                    totalPages = totalCount / Integer.parseInt(rows) + 1;
//                }
//            } else {
//                totalPages = 0;
//            }
            int recordsFiltered = entityProducts.count();
            System.out.println("recordsFiltered " + recordsFiltered);
            Date d2 = sdf.parse(tgl);
            String relation = "";
            Date dateBefore_val = null;
            Date dateAfter_val = null;
            Date tanggalMasuk = null;
            Date tanggalGaransi = null;
            JSONArray jsonArray = new JSONArray();
            int no = Integer.parseInt(start) + 1;
            List<EntityProducts> productList = null;

            if (searchString.isEmpty()) {
                productList = entityProducts.getAllProductsRaw(Integer.parseInt(length), Integer.parseInt(start));
            } else {
                productList = entityProducts.serachProductsRaw(searchString.toLowerCase(), Integer.parseInt(length), Integer.parseInt(start));
            }
            if (productList.size() > 0) {
                if (Integer.parseInt(length) <= productList.size()) {
                    totalCount = productList.size();
                    if (totalCount > 0) {
                        if (totalCount % Integer.parseInt(length) == 0) {
                            totalPages = totalCount / Integer.parseInt(length);
                        } else {
                            totalPages = totalCount / Integer.parseInt(length) + 1;
                        }
                    } else {
                        totalPages = 0;
                    }
                } else {
                    totalPages = 0;
                }
//            if (productList.size() > 0) {
                for (int i = 0; i < productList.size(); i++) {
                    EntityProducts dataProduct = (EntityProducts) productList.get(i);
                    EntityStock dataStock = entityStock.find(dataProduct.getIdProduct());
                    JSONObject obj = new JSONObject();
                    if (dataProduct.getIdProduct() == null) {
                        obj.put("id_item_raw", "");
                        obj.put("no_item_raw", "");
//                        obj.put("action_item_raw", "");
                    } else {
                        obj.put("id_item_raw", dataProduct.getIdProduct());
                        obj.put("no_item_raw", no++);
//                        obj.put("action_item_raw", "");
                    }
                    if (dataProduct.getPartnerId().getPartnerId() == null) {
                        obj.put("id_supplier_raw", "");
                    } else {
                        obj.put("id_supplier_raw", dataProduct.getPartnerId().getPartnerId());
                    }
                    
                    if (dataProduct.getPartnerId().getName()== null) {
                        obj.put("supplier_name", "");
                    } else {
                        obj.put("supplier_name", EncryptionUtil.upperCaseFirst(dataProduct.getPartnerId().getName()));
                    }

                    if (dataProduct.getCategoryId().getCategoryId() == null) {
                        obj.put("id_categories_raw", "");
                    } else {
                        obj.put("id_categories_raw", dataProduct.getCategoryId().getCategoryId());
                    }
                    if (dataProduct.getCategoryId().getCategoriesName() == null) {
                        obj.put("categories_raw", "");
                    } else {
                        obj.put("categories_raw", EncryptionUtil.upperCaseFirst(dataProduct.getCategoryId().getCategoriesName()));
                    }

                    if (dataProduct.getProductCode() == null) {
                        obj.put("item_code_raw", "");
                    } else {
                        obj.put("item_code_raw", EncryptionUtil.upperCaseFirst(dataProduct.getProductCode()));
                    }
                    if (dataProduct.getProductName() == null) {
                        obj.put("item_name_raw", "");
                    } else {
                        obj.put("item_name_raw", EncryptionUtil.upperCaseFirst(dataProduct.getProductName()));
                    }

                    if (dataProduct.getDescription() == null) {
                        obj.put("item_desc_raw", "");
                    } else {
                        obj.put("item_desc_raw", EncryptionUtil.upperCaseFirst(dataProduct.getDescription()));
                    }
                    if (dataStock.getIdStock() == 0) {
                        obj.put("id_stock_raw", "");
                    } else {
                        obj.put("id_stock_raw", dataStock.getIdStock());
                    }
                    if (dataStock.getBuyPrice() == null) {
                        obj.put("item_price_raw", "");
                    } else {
                        obj.put("item_price_raw", dataStock.getBuyPrice());
                    }

                    if (dataStock.getSellPrice() == null) {
                        obj.put("item_sell_price_raw", "");
                    } else {
                        obj.put("item_sell_price_raw", dataStock.getSellPrice());
                    }

                    if (dataStock.getEstematedDateBefore() == null) {
                        obj.put("estemated_date_before_raw", "");
                    } else {
                        obj.put("estemated_date_before_raw", sdf.format(dataStock.getEstematedDateBefore()));
                    }

                    if (dataStock.getEstematedDateAfter() == null) {
                        obj.put("estemated_date_after_raw", "");
                    } else {
                        obj.put("estemated_date_after_raw", sdf.format(dataStock.getEstematedDateAfter()));
                    }
                    if (dataStock.getStock() == 0) {
                        obj.put("item_stock_raw", 0);
                    } else {
                        obj.put("item_stock_raw", dataStock.getStock());
                    }

                    if (dataProduct.getStatus_item() == 0) {
                        obj.put("status_item", 0);
                    } else {
                        obj.put("status_item", dataProduct.getStatus_item());
//                        dateAfter_val = sdf.parse(dataStock.getEstematedDateAfter().toString());
                    }

                    if (dataProduct.getPic() == null) {
                        obj.put("pic", "");
                    } else {
                        obj.put("pic", dataProduct.getPic());
                    }

                    jsonArray.add(obj);
                }
            }
            JSONObject jsonobj = new JSONObject();
            jsonobj.put("draw", request.getParameter("draw"));
            jsonobj.put("totalpages", totalPages);
            jsonobj.put("length", length);
            jsonobj.put("recordsTotal", productList.size());
            jsonobj.put("recordsFiltered", recordsFiltered);
            jsonobj.put("rows", jsonArray);
//            jsonobj.put("data", jsonArray);
            out.println(jsonobj);

            out.close();
        } catch (ParseException ex) {
            Logger.getLogger(ItemServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
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
