/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.inventory.aset.entity.EntityCategories;
import com.inventory.aset.entity.EntityProductPurchase;
import com.inventory.aset.entity.EntityProducts;
import com.inventory.aset.entity.EntityPurchases;
import com.inventory.aset.entity.EntityStock;
import com.inventory.aset.entity.EntityTypePO;
import com.inventory.aset.entity.EntityUnits;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import com.inventory.aset.facadebean.local.EntityCategoriesFacadeLocal;
import com.inventory.aset.facadebean.local.EntityProductPurchaseFacadeLocal;
import com.inventory.aset.facadebean.local.EntityProductsFacadeLocal;
import com.inventory.aset.facadebean.local.EntityPurchasesFacadeLocal;
import com.inventory.aset.facadebean.local.EntityStockFacadeLocal;
import com.inventory.aset.facadebean.local.EntityUnitsFacadeLocal;
import com.inventory.aset.facadebean.local.EntityTypePOFacadeLocal;

/**
 *
 * @author newbiecihuy
 */
@WebServlet(name = "CreatePOItemServlet", urlPatterns = {"/ceatePOItemServlet"})
public class CreatePOItemServlet extends HttpServlet {

    public CreatePOItemServlet() {

    }
    @EJB
    EntityPurchasesFacadeLocal entityPurchasesDao;
    @EJB
    EntityProductPurchaseFacadeLocal entityProductPurchaseDao;
    @EJB
    EntityProductsFacadeLocal entityProductsDao;
    @EJB
    EntityStockFacadeLocal entityStockDao;
    @EJB
    EntityUnitsFacadeLocal entityUnitsDao;
//    @EJB
//    EntityTypePOFacadeLocal entityTypePODao;
    @EJB
    EntityCategoriesFacadeLocal entityCategoriesDaoLocal;

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
//            long id_product = 0l;
            long purchase_id = 0;
            long supplier_id_form_create_po = 0l;
//            int qtty_po = 0;
            double tax_po = 0;
            String item_name_po[], qtty_po[], unit_item_po[], id_product[], unit_price_po[], discount_item_po[], price_po[], sub_total, total_price_po = null;
            String isi_item_name, isi_qtty_po, isi_unit_item_po, isi_id_product, isi_unit_price_po, isi_discount_item_po, isi_price_po = null;
            Object node_item_name, node_unit_item_po, node_unit_price_po, node_id_product, node_discount_item_po, node_price_po, node_qtty_po = null;
            JSONArray arr_item_name = null;
            JSONArray arr_unit_item_po = null;
            JSONArray arr_id_product = null;
            JSONArray arr_unit_price_po = null;
            JSONArray arr_discount_item_po = null;
            JSONArray arr_price_po = null;
//            JSONArray arr_total_price_po = null;
            JSONArray arr_qtty_po = null;
//            JSONArray arrMid = null;
            EntityPurchases dataPurcahse = new EntityPurchases();
            EntityProducts dataProducts = new EntityProducts();
            EntityProductPurchase dataProductPurchase = new EntityProductPurchase();
            EntityStock dataStockProduct = new EntityStock();
//            
            EntityCategories dataCategories = new EntityCategories();
            EntityUnits dataUnit = new EntityUnits();
            for (int i = 0; i < array.size(); i++) {
                JSONObject object = array.getJSONObject(0);
                object = array.getJSONObject(i);
                action_edit = object.getString("action_edit_item_po").trim().replaceAll("['\":<>\\[\\],-]", "");
                action_delete = object.getString("action_delete_item_po").trim().replaceAll("['\":<>\\[\\],-]", "");

                if (!"".equals(object.getString("purchase_id")) && !object.getString("purchase_id").isEmpty()) {
                    purchase_id = Long.parseLong(object.getString("purchase_id").trim().replaceAll("['\":<>\\[\\],-]", ""));
                } else {
                    purchase_id = 0l;
                }
                if (!"".equals(object.getString("id_product_purchase")) && !object.getString("id_product_purchase").isEmpty()) {
                    id_product_purchase = Long.parseLong(object.getString("id_product_purchase").trim().replaceAll("['\":<>\\[\\],-]", ""));
                } else {
                    id_product_purchase = 0l;
                }

                if (id_product_purchase == 0l) {

                    dataPurcahse = entityPurchasesDao.find(purchase_id);

                    if (!object.getString("supplier_id_form_create_po").isEmpty()) {
                        supplier_id_form_create_po = Long.parseLong(object.getString("supplier_id_form_create_po").trim().replaceAll("['\":<>\\[\\],-]", ""));
                    } else {
                        supplier_id_form_create_po = 0l;
                    }
                    if (!object.getString("id_product").isEmpty()) {
                        node_id_product = object.getString("id_product").trim().replaceAll("['\":<>\\[\\],-]", "");
                    } else {
                        node_id_product = "";
                    }
                    if (!object.getString("item_name_po").isEmpty()) {
                        node_item_name = object.getString("item_name_po").trim().replaceAll("['\":<>\\[\\],-]", "");
                    } else {
                        node_item_name = "";
                    }
                    if (object.getInt("qtty_po") != 0) {
                        node_qtty_po = object.getInt("qtty_po");
                    } else {
                        node_qtty_po = 0;
                    }
                    if (!object.getString("unit_item_po").isEmpty()) {
                        node_unit_item_po = object.getString("unit_item_po").trim().replaceAll("['\":<>\\[\\],-]", "");
                    } else {
                        node_unit_item_po = "";
                    }
                    if (!object.getString("unit_price_po").isEmpty()) {
                        node_unit_price_po = object.getString("unit_price_po").trim().replaceAll("['\":<>\\[\\],-]", "");
                    } else {
                        node_unit_price_po = "";
                    }
                    if (!object.getString("discount_item_po").isEmpty()) {
                        node_discount_item_po = object.getString("discount_item_po").trim().replaceAll("['\":<>\\[\\],-]", "");
                    } else {
                        node_discount_item_po = "";
                    }
                    if (!object.getString("price_po").isEmpty()) {
                        node_price_po = object.getString("price_po").trim().replaceAll("['\":<>\\[\\],-]", "");
                    } else {
                        node_price_po = "";
                    }
                    if (!object.getString("sub_total").isEmpty()) {
                        sub_total = object.getString("sub_total").trim().replaceAll("['\":<>\\[\\],-]", "");
                    } else {
                        sub_total = "";
                    }
                    if (!object.getString("total_price_po").isEmpty()) {
                        total_price_po = object.getString("total_price_po").trim().replaceAll("['\":<>\\[\\],-]", "");
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
                        item_name_po = new String[arr_item_name.size()];
                    } else {
                        item_name_po = new String[1];
                    }
                    if ((node_qtty_po instanceof JSONArray)) {
                        System.out.println("isi qtty_po: " + node_qtty_po);
                        arr_qtty_po = object.getJSONArray("qtty_po");
                        qtty_po = new String[arr_qtty_po.size()];
                    } else {
                        qtty_po = new String[1];
                    }
                    if ((node_unit_item_po instanceof JSONArray)) {
                        System.out.println("isi node_unit_item_po: " + node_unit_item_po);
                        arr_unit_item_po = object.getJSONArray("unit_item_po");
                        unit_item_po = new String[arr_unit_item_po.size()];
                    } else {
                        unit_item_po = new String[1];
                    }

                    if ((node_id_product instanceof JSONArray)) {
                        System.out.println("isi node_id_product: " + node_id_product);
                        arr_id_product = object.getJSONArray("id_product");
                        id_product = new String[arr_id_product.size()];
                    } else {
                        id_product = new String[1];
                    }
                    if ((node_unit_price_po instanceof JSONArray)) {
                        System.out.println("isi node_unit_price_po: " + node_unit_price_po);
                        arr_unit_price_po = object.getJSONArray("unit_price_po");
                        unit_price_po = new String[arr_unit_price_po.size()];
                    } else {
                        unit_price_po = new String[1];
                    }

                    if ((node_discount_item_po instanceof JSONArray)) {
                        System.out.println("isi node_unit_price_po: " + node_unit_price_po);
                        arr_discount_item_po = object.getJSONArray("discount_item_po");
                        discount_item_po = new String[arr_discount_item_po.size()];
                    } else {
                        discount_item_po = new String[1];
                    }

                    if ((node_price_po instanceof JSONArray)) {
                        System.out.println("isi price_po: " + node_price_po);
                        arr_price_po = object.getJSONArray("price_po");
                        price_po = new String[arr_price_po.size()];
                    } else {
                        price_po = new String[1];
                    }

                    for (int j = 0; j < item_name_po.length; j++) {

                        if (item_name_po.length == 1) {
                            isi_item_name = node_item_name.toString().replaceAll("['\":<>\\[\\],-]", "");
                        } else {
                            isi_item_name = arr_item_name.getString(j).trim().replaceAll("['\":<>\\[\\],-]", "");
                        }
                        if (qtty_po.length == 1) {
                            isi_qtty_po = node_qtty_po.toString().replaceAll("['\":<>\\[\\],-]", "");
                        } else {
                            isi_qtty_po = arr_qtty_po.getString(j).trim().replaceAll("['\":<>\\[\\],-]", "");
                        }
                        if (unit_item_po.length == 1) {
                            isi_unit_item_po = node_unit_item_po.toString().replaceAll("['\":<>\\[\\],-]", "");
                        } else {
                            isi_unit_item_po = arr_unit_item_po.getString(j).trim().replaceAll("['\":<>\\[\\],-]", "");
                        }
                        if (id_product.length == 1) {
                            isi_id_product = node_id_product.toString().replaceAll("['\":<>\\[\\],-]", "");
                        } else {
                            isi_id_product = arr_id_product.getString(j).trim().replaceAll("['\":<>\\[\\],-]", "");
                        }
                        if (unit_price_po.length == 1) {
                            isi_unit_price_po = node_unit_price_po.toString().replaceAll("['\":<>\\[\\],-]", "");
                        } else {
                            isi_unit_price_po = arr_unit_price_po.getString(j).trim().replaceAll("['\":<>\\[\\],-]", "");
                        }
                        if (discount_item_po.length == 1) {
                            isi_discount_item_po = node_discount_item_po.toString().replaceAll("['\":<>\\[\\],-]", "");
                        } else {
                            isi_discount_item_po = arr_discount_item_po.getString(j).trim().replaceAll("['\":<>\\[\\],-]", "");
                        }
                        if (price_po.length == 1) {
                            isi_price_po = node_price_po.toString().replaceAll("['\":<>\\[\\],-]", "");
                        } else {
                            isi_price_po = arr_price_po.getString(j).trim().replaceAll("['\":<>\\[\\],-]", "");
                        }

                        List<EntityUnits> cekUnitName = entityUnitsDao.getUnitName(isi_unit_item_po);
                        if (cekUnitName.size() > 0) {
                            dataUnit = entityUnitsDao.getUnit(cekUnitName.get(0).getUnitId());
                            dataProductPurchase.setUnitId(dataUnit);
                        } else {
                            dataUnit.setUnitName(isi_unit_item_po);
                            dataUnit.setCreatedDate(now);
                            dataUnit.setCreatedTime(time_now);
                            dataUnit.setPic(("PIC").toLowerCase());
                            entityUnitsDao.createUnit(dataUnit);
                            dataProductPurchase.setUnitId(dataUnit);
                        }
//                        List<EntityProducts> cekItemName = entityProductsDao.findWithProductName(isi_item_name.toLowerCase());
                        List<EntityProducts> cekItemName = entityProductsDao.findBySuplierIdItemId(supplier_id_form_create_po, Long.parseLong(isi_id_product));
                        System.out.println("isi cekItemName" + cekItemName);
                        if (cekItemName.size() > 0) {
                            List<EntityStock> dataStokById = entityStockDao.findByIdProduct(cekItemName.get(0).getIdProduct());//id_product
//                            dataStokById.get(0).setStock(Integer.parseInt(isi_qtty_po));
                            if (dataStokById.size() > 0) {
                                dataStockProduct = entityStockDao.find(dataStokById.get(0).getIdStock());
                                dataStockProduct.setDate(now);
                                dataStockProduct.setTime(time_now);
                                dataStockProduct.setPic(("PIC").toLowerCase());
                                dataStockProduct.setStock(Integer.parseInt(isi_qtty_po));
                                entityStockDao.updateStock(dataStockProduct);
                            } else {
                                List<EntityCategories> dataCategory = entityCategoriesDaoLocal.findByCategoriesName("raw material");
                                dataCategories = entityCategoriesDaoLocal.find(dataCategory.get(0).getCategoryId());
                                dataProducts.setProductCode("");
                                dataProducts.setBarcode("");
                                dataProducts.setCategoryId(dataCategories);
                                dataProducts.setCreatedAt(tgl);
                                dataProducts.setCreatedAtTime(time_now);
                                dataProducts.setEntityStock(dataStockProduct);
//                              entityProductsDao.createProducts(dataProducts);
                                dataStockProduct.setIdProduct(dataProducts);
                                dataStockProduct.setBuyPrice(isi_unit_price_po);
                                dataStockProduct.setIdProduct(dataProducts);
                                dataStockProduct.setDate(now);
                                dataStockProduct.setTime(time_now);
                                dataStockProduct.setPic(("PIC").toLowerCase());
                                dataStockProduct.setStock(Integer.parseInt(isi_qtty_po));
                                entityProductsDao.createProducts(dataProducts);
                                entityStockDao.updateStock(dataStockProduct);
                            }

                        } else {
                            code = "xx0";
                        }
//                        List<EntityStock> cekIdProduct = entityStockDao.findByIdProduct(id_product);//dataProducts
//                        if (cekIdProduct != null) {
//                            dataStockProduct.setIdProduct(dataProducts);
//                            dataStockProduct.setDate(now);
//                            dataStockProduct.setTime(code);
//                            dataStockProduct.setPic(("PIC").toLowerCase());
//                            dataStockProduct.setStock(Integer.parseInt(isi_qtty_po));
//                            entityStockDao.createStock(dataStockProduct);
//                        }
                        dataProducts = entityProductsDao.find(cekItemName.get(0).getIdProduct());

                        dataProductPurchase.setPurchaseId(dataPurcahse);
                        dataProductPurchase.setQtty(Integer.parseInt(isi_qtty_po));
                        dataProductPurchase.setDisconto(Integer.parseInt(isi_discount_item_po));
                        dataProductPurchase.setPrice(Integer.parseInt(isi_price_po));
                        dataProductPurchase.setIdProduct(dataProducts);
                        dataProductPurchase.setCreatedDate(now);
                        dataProductPurchase.setInputDate(now);
                        dataProductPurchase.setCreatedTime(time_now);
                        dataProductPurchase.setInputTime(time_now);
                        dataProductPurchase.setPic(("PIC").toLowerCase());
                        entityProductPurchaseDao.createProductPurchase(dataProductPurchase);
                        dataPurcahse.setStatusPo("need approval");
                        dataPurcahse.setTotalProductPurchaseCost(total_price_po);
                        entityPurchasesDao.updatePurchases(dataPurcahse);
                        code = "1";
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
                } else if (action_edit.equalsIgnoreCase("EDIT")) {
                    dataPurcahse = entityPurchasesDao.find(purchase_id);
                    if (!object.getString("supplier_id_form_create_po").isEmpty()) {
                        supplier_id_form_create_po = Long.parseLong(object.getString("supplier_id_form_create_po").trim().replaceAll("['\":<>\\[\\],-]", ""));
                    } else {
                        supplier_id_form_create_po = 0l;
                    }
                    if (!object.getString("id_product").isEmpty()) {
                        node_id_product = object.getString("id_product").trim().replaceAll("['\":<>\\[\\],-]", "");
                    } else {
                        node_id_product = "";
                    }
                    if (!object.getString("item_name_po").isEmpty()) {
                        node_item_name = object.getString("item_name_po").trim().replaceAll("['\":<>\\[\\],-]", "");
                    } else {
                        node_item_name = "";
                    }
                    if (object.getInt("qtty_po") != 0) {
                        node_qtty_po = object.getInt("qtty_po");
                    } else {
                        node_qtty_po = 0;
                    }
                    if (!object.getString("unit_item_po").isEmpty()) {
                        node_unit_item_po = object.getString("unit_item_po").trim().replaceAll("['\":<>\\[\\],-]", "");
                    } else {
                        node_unit_item_po = "";
                    }
                    if (!object.getString("unit_price_po").isEmpty()) {
                        node_unit_price_po = object.getString("unit_price_po").trim().replaceAll("['\":<>\\[\\],-]", "");
                    } else {
                        node_unit_price_po = "";
                    }
                    if (!object.getString("discount_item_po").isEmpty()) {
                        node_discount_item_po = object.getString("discount_item_po").trim().replaceAll("['\":<>\\[\\],-]", "");
                    } else {
                        node_discount_item_po = "";
                    }
                    if (!object.getString("price_po").isEmpty()) {
                        node_price_po = object.getString("price_po").trim().replaceAll("['\":<>\\[\\],-]", "");
                    } else {
                        node_price_po = "";
                    }
                    if (!object.getString("sub_total").isEmpty()) {
                        sub_total = object.getString("sub_total").trim().replaceAll("['\":<>\\[\\],-]", "");
                    } else {
                        sub_total = "";
                    }
                    if (!object.getString("total_price_po").isEmpty()) {
                        total_price_po = object.getString("total_price_po").trim().replaceAll("['\":<>\\[\\],-]", "");
                    } else {
                        total_price_po = "";
                    }
                    if (!object.getString("tax_po").isEmpty()) {
                        tax_po = object.getDouble("tax_po");
                    } else {
                        tax_po = 0;
                    }
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
