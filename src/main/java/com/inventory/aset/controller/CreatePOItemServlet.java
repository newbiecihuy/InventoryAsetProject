/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.controller;

import com.inventory.aset.dao.local.EntityPurchasesDaoLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.inventory.aset.dao.local.EntityProductPurchaseDaoLocal;
import com.inventory.aset.dao.local.EntityProductsDaoLocal;
import com.inventory.aset.dao.local.EntityStockDaoLocal;
import com.inventory.aset.dao.local.EntityTypePODaoLocal;
import com.inventory.aset.dao.local.EntityUnitsDaoLocal;
import com.inventory.aset.entity.EntityProductPurchase;
import com.inventory.aset.entity.EntityProducts;
import com.inventory.aset.entity.EntityPurchases;
import com.inventory.aset.entity.EntityStock;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

/**
 *
 * @author newbiecihuy
 */
@WebServlet(name = "CreatePOItemServlet", urlPatterns = {"/ceatePOItemServlet"})
public class CreatePOItemServlet extends HttpServlet {

    public CreatePOItemServlet() {

    }
    @EJB
    EntityPurchasesDaoLocal entityPurchasesDao;
    @EJB
    EntityProductPurchaseDaoLocal entityProductPurchaseDao;
    @EJB
    EntityProductsDaoLocal entityProductsDao;
    @EJB
    EntityStockDaoLocal entityStockDao;
    @EJB
    EntityUnitsDaoLocal entityUnitsDao;
    @EJB
    EntityTypePODaoLocal EntityTypePODao;

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
        try {
            System.out.println("Inside doPost");
            processRequest(request, response);
            System.out.println("Inside doPost");

            System.out.println("Tester");
            response.setContentType("application/json");
            response.setHeader("cache-control", "no-cache");
            PrintWriter out = response.getWriter();

            String code = "0";
            System.out.println(request.getParameter("JSONFile"));
            JSONArray array = (JSONArray) JSONSerializer.toJSON(request.getParameter("JSONFile"));
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat jamFormat = new SimpleDateFormat("HH:mm:ss");
            Date tgl = new Date();
            Date now = new Date();
            sdf.format(now);
            String time_now = jamFormat.format(tgl);
            String action_insert = "";
            String action_edit = "";
            String action_delete = "";
            long id_product_purchase = 0;
            long purchase_id = 0;
//            int qtty_po = 0;
            double tax_po = 0;
            String item_name[], qtty_po[], unit_item_po[], unit_price_po[], discount_item_po[], price_po[], sub_total, total_price_po = null;
            String isi_item_name, isi_qtty_po, isi_unit_item_po, isi_unit_price_p, isi_discount_item_po, isi_price_po = null;
            Object node_item_name, node_unit_item_po, node_unit_price_po, node_discount_item_po, node_price_po, node_qtty_po = null;
            JSONArray arr_item_name = null;
            JSONArray arr_unit_item_po = null;
            JSONArray arr_unit_price_po = null;
            JSONArray arr_discount_item_po = null;
            JSONArray arr_total_price_po = null;
            JSONArray arr_qtty_po = null;
//            JSONArray arrMid = null;
            EntityProducts dataProducts = new EntityProducts();
            EntityProductPurchase dataProductPurchase = new EntityProductPurchase();
            EntityStock dataStockProduct = new EntityStock();
//            
            for (int i = 0; i < array.size(); i++) {
                JSONObject object = array.getJSONObject(0);
                object = array.getJSONObject(i);
                action_edit = object.getString("action_edit_item_po");
                action_delete = object.getString("action_delete_item_po");

                if (!"".equals(object.getString("purchase_id")) && !object.getString("purchase_id").isEmpty()) {
                    purchase_id = Long.parseLong(object.getString("purchase_id"));
                }
                if (!"".equals(object.getString("id_product_purchase")) && !object.getString("id_product_purchase").isEmpty()) {
                    id_product_purchase = Long.parseLong(object.getString("id_product_purchase"));
                }
                if (id_product_purchase == 0l) {

                    EntityPurchases dataPurcahse = entityPurchasesDao.find(purchase_id);
                    if (!object.getString("item_name").isEmpty()) {
                        node_item_name = object.getString("item_name");
                    } else {
                        node_item_name = "";
                    }
                    if (object.getInt("qtty_po") != 0) {
                        node_qtty_po = object.getInt("qtty_po");
                    } else {
                        node_qtty_po = 0;
                    }
                    if (!object.getString("unit_item_po").isEmpty()) {
                        node_unit_item_po = object.getString("unit_item_po");
                    } else {
                        node_unit_item_po = "";
                    }
                    if (!object.getString("unit_price_po").isEmpty()) {
                        node_unit_price_po = object.getString("unit_price_po");
                    } else {
                        node_unit_price_po = "";
                    }
                    if (!object.getString("discount_item_po").isEmpty()) {
                        node_discount_item_po = object.getString("discount_item_po");
                    } else {
                        node_discount_item_po = "";
                    }
                    if (!object.getString("price_po").isEmpty()) {
                        node_price_po = object.getString("price_po");
                    } else {
                        node_price_po = "";
                    }
                    if (!object.getString("sub_total").isEmpty()) {
                        sub_total = object.getString("sub_total");
                    } else {
                        sub_total = "";
                    }
                    if (!object.getString("total_price_po").isEmpty()) {
                        total_price_po = object.getString("total_price_po");
                    } else {
                        total_price_po = "";
                    }
                    if (!object.getString("tax_po").isEmpty()) {
                        tax_po = object.getDouble("tax_po");
                    } else {
                        tax_po = 0;
                    }

                    if ((node_item_name instanceof JSONArray)) {
                        System.out.println("isi node_item_name: " + node_item_name);
                        arr_item_name = object.getJSONArray("item_name");
                        item_name = new String[arr_item_name.size()];
                    } else {
                        item_name = new String[1];
                    }
                    if ((node_qtty_po instanceof JSONArray)) {
                        System.out.println("isi qtty_po: " + node_qtty_po);
                        arr_qtty_po = object.getJSONArray("qtty_po");
                        qtty_po = new String[arr_qtty_po.size()];
                    } else {
                        qtty_po = new String[1];
                    }

                    for (int j = 0; j < item_name.length; j++) {

                        if (item_name.length == 1) {
                            isi_item_name = node_item_name.toString().replaceAll("['\":<>\\[\\],-]", "");
                        } else {
                            isi_item_name = arr_item_name.getString(j).trim().replaceAll("['\":<>\\[\\],-]", "");
                        }
                        if (qtty_po.length == 1) {
                            isi_qtty_po = node_qtty_po.toString().replaceAll("['\":<>\\[\\],-]", "");
                        } else {
                            isi_qtty_po = arr_qtty_po.getString(j).trim().replaceAll("['\":<>\\[\\],-]", "");
                        }
                        List<EntityProducts> cekItemName = entityProductsDao.findWithProductName(isi_item_name.toLowerCase());
                        System.out.println("isi cekItemName" + cekItemName);
                        if (cekItemName.size() > 0) {
                            dataProducts.setProductName(isi_item_name.toLowerCase());
                            dataProducts.setPic(("PIC").toLowerCase());
                            dataProducts.setCreatedAt(now);
                            dataProducts.setCreatedAtTime(time_now);
                            String sub_str = Arrays.toString(item_name).toLowerCase().substring(0, 4);
                            dataProducts.setProductCode(sub_str);
                            dataProducts.setBarcode("");
                            dataProducts.setPict_path("");
                            dataProducts.setStatus_item(true);
                            dataProducts.setDescription(Arrays.toString(item_name).toLowerCase() + "/" + "Date Input :" + now + ":" + time_now);
                            entityProductsDao.createProducts(dataProducts);
                        } else {
                            dataProducts = entityProductsDao.getProducts(cekItemName.get(0).getIdProduct());
                            dataProducts.setProductName(Arrays.toString(item_name).toLowerCase());
                            dataProducts.setPic(("PIC").toLowerCase());
                            dataProducts.setUpdatedAt(now);
                            dataProducts.setUpdatedAtTime(time_now);
                            String sub_str = Arrays.toString(item_name).toLowerCase().substring(0, 4);
                            dataProducts.setProductCode(sub_str);
                            dataProducts.setBarcode("");
                            dataProducts.setPict_path("");
                            dataProducts.setStatus_item(true);
                            dataProducts.setDescription(Arrays.toString(item_name).toLowerCase() + "/" + "Date Input :" + now + ":" + time_now);
                            entityProductsDao.updateProducts(dataProducts);
                        }
                        List<EntityStock> cekIdProduct = entityStockDao.findByIdProduct(dataProducts);
                        if (cekIdProduct == null) {
                            EntityProducts regProducts = entityProductsDao.find(cekIdProduct.get(0).getIdProduct());
                            dataStockProduct.setIdProduct(regProducts);
                            dataStockProduct.setDate(now);
                            dataStockProduct.setTime(code);
                            dataStockProduct.setPic(("PIC").toLowerCase());
                            dataStockProduct.setStock(Integer.parseInt(isi_qtty_po));
                            entityStockDao.updateStock(dataStockProduct);

                        } else {
                            dataStockProduct.setIdProduct(dataProducts);
                            dataStockProduct.setDate(now);
                            dataStockProduct.setTime(code);
                            dataStockProduct.setPic(("PIC").toLowerCase());
                            dataStockProduct.setStock(Integer.parseInt(isi_qtty_po));
                            entityStockDao.createStock(dataStockProduct);
                        }

                        dataProductPurchase.setIdProduct(dataProducts);
                        dataProductPurchase.setCreatedDate(now);
                        dataProductPurchase.setCreatedTime(time_now);
                        dataProductPurchase.setPic(("PIC").toLowerCase());

                    }

//                    if (!object.getString("item_name").isEmpty()) {
//                        item_name = object.getString("item_name");
//                    } else {
//                        item_name = "";
//                    }
//                    if (object.getInt("qtty_po") != 0) {
//                        qtty_po = object.getInt("qtty_po");
//                    } else {
//                        qtty_po = 0;
//                    }
//                    if (!object.getString("unit_item_po").isEmpty()) {
//                        unit_item_po = object.getString("unit_item_po");
//                    } else {
//                        unit_item_po = "";
//                    }
//                    if (!object.getString("unit_price_po").isEmpty()) {
//                        unit_price_po = object.getString("unit_price_po");
//                    } else {
//                        unit_price_po = "";
//                    }
//                    if (!object.getString("discount_item_po").isEmpty()) {
//                        discount_item_po = object.getString("discount_item_po");
//                    } else {
//                        discount_item_po = "";
//                    }
//                    if (!object.getString("total_price_po").isEmpty()) {
//                        total_price_po = object.getString("total_price_po");
//                    } else {
//                        total_price_po = "";
//                    }
//                    if (!object.getString("sub_total").isEmpty()) {
//                        sub_total = object.getString("sub_total");
//                    } else {
//                        sub_total = "";
//                    }
//                    if (!object.getString("total_price_po").isEmpty()) {
//                        total_price_po = object.getString("total_price_po");
//                    } else {
//                        total_price_po = "";
//                    }
                }

            }

            JSONObject jsonobj = new JSONObject();
            jsonobj.put("RC", code);
            out.println(jsonobj.toString());
            out.flush();
            System.out.println(jsonobj.toString());
        } catch (IOException ex) {
            Logger.getLogger(CreatePOItemServlet.class.getName()).log(Level.SEVERE, null, ex);
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
