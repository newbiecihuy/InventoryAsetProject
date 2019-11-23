/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.controller;

import com.inventory.aset.entity.EntityCategories;
import com.inventory.aset.entity.EntityProducts;
import com.inventory.aset.entity.EntityStock;
import com.inventory.aset.entity.EntitySuppliers;
import com.inventory.aset.controller.util.EncryptionUtil;
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
import net.sf.json.JSONSerializer;
import com.inventory.aset.facadebean.local.EntityCategoriesFacadeLocal;
import com.inventory.aset.facadebean.local.EntityProductsFacadeLocal;
import com.inventory.aset.facadebean.local.EntityStockFacadeLocal;
import com.inventory.aset.facadebean.local.EntitySuppliersFacadeLocal;

/**
 *
 * @author newbiecihuy
 */
@WebServlet(name = "ItemServlet", urlPatterns = {"/itemServlet"})
public class ItemServlet extends HttpServlet {

    public ItemServlet() {

    }

    @EJB
    EntityProductsFacadeLocal entityProductsFacadeLocal;
    @EJB
    EntityCategoriesFacadeLocal entityCategoriesFacadeLocal;
    @EJB
    EntitySuppliersFacadeLocal entitySuppliersFacadeLocal;
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
        System.out.println("Inside doGet");
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
            int recordsFiltered = entityProductsFacadeLocal.count();
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
                productList = entityProductsFacadeLocal.getAllProducts(Integer.parseInt(length), Integer.parseInt(start));
            } else {
                productList = entityProductsFacadeLocal.serachProducts(searchString.toLowerCase(), Integer.parseInt(length), Integer.parseInt(start));
            }

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
            if (productList.size() > 0) {
                for (int i = 0; i < productList.size(); i++) {
                    EntityProducts dataProduct = (EntityProducts) productList.get(i);
//                    EntityStock dataStock = (EntityStock) productList.get(i);
                    EntityStock dataStock = entityStockFacadeLocal.find(dataProduct.getIdProduct());
                    JSONObject obj = new JSONObject();
                    if (dataProduct.getIdProduct() == null) {
                        obj.put("id_product", "");
                        obj.put("no", "");
                        obj.put("action_item", "");
                    } else {
                        obj.put("id_product", dataProduct.getIdProduct());
                        obj.put("no", no++);
                        obj.put("action_item", "");
                    }
                    if (dataProduct.getProductCode() == null) {
                        obj.put("product_code", "");
                    } else {
                        obj.put("product_code", EncryptionUtil.upperCaseFirst(dataProduct.getProductCode()));
                    }
                    if (dataProduct.getProductName() == null) {
                        obj.put("product_name", "");
                    } else {
                        obj.put("product_name", EncryptionUtil.upperCaseFirst(dataProduct.getProductName()));
                    }
                    if (dataProduct.getCreatedAt() == null) {
                        obj.put("create_date", "");
                    } else {
                        obj.put("create_date", sdf.format(dataProduct.getCreatedAt()) + "-" + dataProduct.getCreatedAtTime());
                    }

                    if (dataProduct.getSupplierId().getSupplierId() == null) {
                        obj.put("supplier_id", "");
                    } else {
                        obj.put("supplier_id", dataProduct.getSupplierId().getSupplierId());
                    }

                    if (dataProduct.getSupplierId().getSupplierName() == null) {
                        obj.put("supplier_name", "");
                    } else {
                        obj.put("supplier_name", EncryptionUtil.upperCaseFirst(dataProduct.getSupplierId().getSupplierName()));
                    }

                    if (dataProduct.getCategoryId().getCategoriesName() == null) {
                        obj.put("name_category", "");
                    } else {
                        obj.put("name_category", EncryptionUtil.upperCaseFirst(dataProduct.getCategoryId().getCategoriesName()));
                    }

                    if (dataProduct.getCategoryId().getCategoryId() == null) {
                        obj.put("category_id", "");
                    } else {
                        obj.put("category_id", dataProduct.getCategoryId().getCategoryId());
                    }

                    if (dataProduct.getCategoryId().getCategoryDesc() == null) {
                        obj.put("category_desc", "");
                    } else {
                        obj.put("category_desc", EncryptionUtil.upperCaseFirst(dataProduct.getCategoryId().getCategoryDesc()));
                    }

                    if (dataProduct.getDescription() == null) {
                        obj.put("description", "");
                    } else {
                        obj.put("description", EncryptionUtil.upperCaseFirst(dataProduct.getDescription()));
                    }
                    if (dataStock.getIdStock() == 0) {
                        obj.put("id_stock", "");
                    } else {
                        obj.put("id_stock", dataStock.getIdStock());
                    }
                    if (dataStock.getBuyPrice() == null) {
                        obj.put("price_item", "");
                    } else {
                        obj.put("price_item", dataStock.getBuyPrice());
                    }

                    if (dataStock.getSellPrice() == null) {
                        obj.put("sell_price", "");
                    } else {
                        obj.put("sell_price", dataStock.getSellPrice());
                    }

                    if (dataStock.getEstematedDateBefore() == null) {
                        obj.put("estemated_date_before", "");
                    } else {
                        obj.put("estemated_date_before", sdf.format(dataStock.getEstematedDateBefore()));
//                        dateBefore_val = sdf.parse(dataStock.getEstematedDateBefore().toString());
                    }

                    if (dataStock.getEstematedDateAfter() == null) {
                        obj.put("estemated_date_after", "");
                    } else {
                        obj.put("estemated_date_after", sdf.format(dataStock.getEstematedDateAfter()));
//                        dateAfter_val = sdf.parse(dataStock.getEstematedDateAfter().toString());
                    }
                    if (dataStock.getStock() == 0) {
                        obj.put("stock", 0);
                    } else {
                        obj.put("stock", dataStock.getStock());
                    }

                    if (dataProduct.isIsApprove()) {
                        obj.put("isApprove", "1");
                    } else {
                        obj.put("isApprove", "0");
                    }

//                    if (!dataProduct.isStatus_item()) {
//                        obj.put("status_item", "0");
//                    } else {
//                        obj.put("status_item", "1");
//                    }
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
            String msg = "";
            System.out.println(request.getParameter("JSONFile"));
            JSONArray array = (JSONArray) JSONSerializer.toJSON(request.getParameter("JSONFile"));
//            JSONArray array = (JSONArray) JSONSerializer.toJSON(EscapeChars.forJSON(request.getParameter("JSONFile")));
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat jamFormat = new SimpleDateFormat("HH:mm:ss");
            Date tgl = new Date();
            Date now = new Date();
            sdf.format(now);
            String time_now = jamFormat.format(tgl);
            String action_insert = "";
            String action_edit = "";
            String action_delete = "";
            long id_product = 0;
            long categori_id = 0;
            long supplier_id = 0;
            long id_stock = 0l;
//            boolean isi_status = false;
            String item_name, categories_name, description, status_item, supplier_name, product_code, price_item, estemated_date_before, estemated_date_after = null;

            EntityProducts dataProducts = new EntityProducts();
            EntityCategories dataCategory = new EntityCategories();
            EntitySuppliers dataSuppplier = new EntitySuppliers();
            EntityStock dataStock = new EntityStock();

            for (int i = 0; i < array.size(); i++) {
                JSONObject object = array.getJSONObject(0);
                object = array.getJSONObject(i);
                action_insert = object.getString("action_insert_item");
                action_edit = object.getString("action_edit_item").trim().replaceAll("['\":<>\\[\\],-]", "");
                action_delete = object.getString("action_delete_item").trim().replaceAll("['\":<>\\[\\],-]", "");

                if (object.containsKey("id_product")) {
                    if (!"".equals(object.getString("id_product")) && !object.getString("id_product").isEmpty()) {
                        id_product = object.getLong("id_product");
                    }
                }
                if (object.containsKey("id_stock")) {
                    if (!"".equals(object.getString("id_stock")) && !object.getString("id_stock").isEmpty()) {
                        id_stock = object.getLong("id_stock");
                    }
                }

                if (id_product == 0l) {//action_insert.equalsIgnoreCase("INSERT")
                    if (!object.getString("item_name").isEmpty()) {
                        item_name = object.getString("item_name");
                    } else {
                        item_name = "";
                    }
                    if (!object.getString("product_code").isEmpty()) {
                        product_code = object.getString("product_code");

                    } else {
                        product_code = "";
                    }
                    if (!object.getString("categories_name").isEmpty()) {
                        categories_name = object.getString("categories_name");

                    } else {
                        categories_name = "";
                    }
                    if (!object.getString("category_id").isEmpty()) {
                        categori_id = Long.parseLong(object.getString("category_id").trim().replaceAll("['\":<>\\[\\],-]", ""));
                    } else {
                        categori_id = 0l;
                    }
                    if (!object.getString("supplier_name").isEmpty()) {
                        supplier_name = object.getString("supplier_name");

                    } else {
                        supplier_name = "";
                    }

                    if (!object.getString("supplier_id").isEmpty()) {
                        supplier_id = Long.parseLong(object.getString("supplier_id").trim().replaceAll("['\":<>\\[\\],-]", ""));
                    } else {
                        supplier_id = 0l;
                    }
                    if (!object.getString("price_item").isEmpty()) {
                        price_item = object.getString("price_item");
                    } else {
                        price_item = "";
                    }

                    if (!object.getString("description").isEmpty()) {
                        description = object.getString("description").trim().replaceAll("['\":<>\\[\\],-]", "");
                    } else {
                        description = "";
                    }
                    if (!object.getString("estemated_date_before").isEmpty()) {
                        estemated_date_before = object.getString("estemated_date_before");
                    } else {
                        estemated_date_before = null;
                    }

                    if (!object.getString("estemated_date_after").isEmpty()) {
                        estemated_date_after = object.getString("estemated_date_after");
                    } else {
                        estemated_date_after = null;
                    }
//                    if (object.containsValue("status_item")) {
//                        status_item = object.getString("status_item");
//                    } else {
//                        status_item = "";
//                    }
//                    if (!status_item.isEmpty()) {
//                        if (status_item.contentEquals("1")) {
//                            isi_status = true;
//                        } else if (status_item.contentEquals("0")) {
//                            isi_status = false;
//                        }
//                    } else {
//                        isi_status = true;
//                    }
//                    List<EntityProducts> cekItemName = entityProductsFacadeLocal.findWithProductName(item_name.toLowerCase());
//                    System.out.println("isi cekItemName" + cekItemName);
//                    if (cekItemName.size() > 0) {
//                        code = "2";
//                        return;
//                    }
                    List<EntityProducts> cekItemName = entityProductsFacadeLocal.findWithProductNameSuplier(item_name.toLowerCase(), supplier_id);
                    System.out.println("isi cekItemName" + cekItemName);
                    if (cekItemName.size() > 0) {
                        code = "2";
                        JSONObject jsonobj = new JSONObject();
                        jsonobj.put("RC", code);
                        jsonobj.put("msg", msg);
                        out.println(jsonobj.toString());
                        out.flush();
                        System.out.println(jsonobj.toString());
                        return;
                    }
                    List<EntityProducts> cekProductCode = entityProductsFacadeLocal.findByProductCode(product_code.toLowerCase());
                    System.out.println("isi cekProductCode.size" + cekProductCode.size());
                    if (cekProductCode.size() > 0) {
                        code = "33";
                        msg = "Product Code Already Registered";
                        JSONObject jsonobj = new JSONObject();
                        jsonobj.put("RC", code);
                        jsonobj.put("msg", msg);
                        out.println(jsonobj.toString());
                        out.flush();
                        System.out.println(jsonobj.toString());
                        return;
                    }
                    dataSuppplier = entitySuppliersFacadeLocal.find(supplier_id);
                    System.out.println("isi dataSuppplier" + dataSuppplier);
                    if (dataSuppplier == null) {
                        code = "44";
                        JSONObject jsonobj = new JSONObject();
                        jsonobj.put("RC", code);
                        jsonobj.put("msg", msg);
                        out.println(jsonobj.toString());
                        out.flush();
                        System.out.println(jsonobj.toString());
                        return;
                    }

                    dataProducts.setSupplierId(dataSuppplier);
                    dataProducts.setProductName(item_name.toLowerCase());
                    dataProducts.setCreatedAt(now);
                    dataProducts.setProductCode(product_code.toLowerCase());
                    dataProducts.setCreatedAtTime(time_now);
                    dataProducts.setPic("PIC");
                    System.out.println("categories_name ==>" + categories_name);
                    List<EntityCategories> cekCategoryName = entityCategoriesFacadeLocal.findWithCategoriesName(categories_name.toLowerCase());
                    if (cekCategoryName.size() > 0) {
                        System.out.println("isi cekCategoryName" + cekCategoryName);
                        dataCategory = entityCategoriesFacadeLocal.getCategories(cekCategoryName.get(0).getCategoryId());
                        dataProducts.setCategoryId(dataCategory);
                    } else {
                        System.out.println("isi categories_name" + categories_name.toLowerCase());
                        dataCategory.setCategoriesName(categories_name.toLowerCase());
                        dataCategory.setCategoryDesc(categories_name.toLowerCase());
                        dataCategory.setCreatedDate(now);
                        dataCategory.setCreatedTime(time_now);
                        dataCategory.setPic(("PIC").toLowerCase());
                        dataCategory.setIsDelete(false);
                        entityCategoriesFacadeLocal.createCategories(dataCategory);
                        dataProducts.setCategoryId(dataCategory);
                    }
//                  dataCategory = entityCategoriesFacadeLocal.getCategories(categori_id);
//                  dataProducts.setCategoryId(dataCategory);
//                  dataProducts.setStatus_item(isi_status);
                    dataProducts.setDescription(description.toLowerCase());
//                    String sub_str = item_name.substring(0, 4);
//                    dataProducts.setProductCode(sub_str);
                    dataProducts.setBarcode("");
                    dataProducts.setPict_path("");

                    dataProducts.setEntityStock(dataStock);
//                    entityProductsFacadeLocal.createProducts(dataProducts);
                    dataStock.setIdProduct(dataProducts);
                    dataStock.setBuyPrice(price_item);

                    try {
                        dataStock.setEstematedDateBefore(sdf.parse(estemated_date_before));
                    } catch (ParseException ex) {
                        Logger.getLogger(ItemServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        dataStock.setEstematedDateAfter(sdf.parse(estemated_date_after));
                    } catch (ParseException ex) {
                        Logger.getLogger(ItemServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    entityProductsFacadeLocal.createProducts(dataProducts);
                    entityStockFacadeLocal.updateStock(dataStock);
                    code = "1";
                    msg = "Has been Recorded";
                } else if (action_edit.equalsIgnoreCase("EDIT")) {

                    dataProducts = entityProductsFacadeLocal.getProducts(id_product);
                    dataStock = entityStockFacadeLocal.getStock(id_stock);
                    if (!object.getString("item_name").isEmpty()) {
                        item_name = object.getString("item_name");
                    } else {
                        item_name = "";
                    }
                    if (!object.getString("product_code").isEmpty()) {
                        product_code = object.getString("product_code");

                    } else {
                        product_code = "";
                    }
                    if (!object.getString("categories_name").isEmpty()) {
                        categories_name = object.getString("categories_name");

                    } else {
                        categories_name = "";
                    }
                    if (!object.getString("category_id").isEmpty()) {
                        categori_id = Long.parseLong(object.getString("category_id").trim().replaceAll("['\":<>\\[\\],-]", ""));
                    } else {
                        categori_id = 0l;
                    }
                    if (!object.getString("supplier_name").isEmpty()) {
                        supplier_name = object.getString("supplier_name");
                    } else {
                        supplier_name = "";
                    }

                    if (!object.getString("supplier_id").isEmpty()) {
                        supplier_id = Long.parseLong(object.getString("supplier_id").trim().replaceAll("['\":<>\\[\\],-]", ""));
                    } else {
                        supplier_id = 0l;
                    }
                    if (!object.getString("description").isEmpty()) {
                        description = object.getString("description").trim().replaceAll("['\":<>\\[\\],-]", "");
                    } else {
                        description = "";
                    }
                    if (!object.getString("price_item").isEmpty()) {
                        price_item = object.getString("price_item");
                    } else {
                        price_item = "";
                    }
                    if (!object.getString("estemated_date_before").isEmpty()) {
                        estemated_date_before = object.getString("estemated_date_before");
                    } else {
                        estemated_date_before = null;
                    }

                    if (!object.getString("estemated_date_after").isEmpty()) {
                        estemated_date_after = object.getString("estemated_date_after");
                    } else {
                        estemated_date_after = null;
                    }

                    dataSuppplier = entitySuppliersFacadeLocal.find(supplier_id);
                    System.out.println("isi dataSuppplier" + dataSuppplier);
                    if (dataSuppplier == null) {
                        code = "44";
                        return;
                    }

                    dataProducts.setSupplierId(dataSuppplier);
                    dataProducts.setProductName(item_name.toLowerCase());
                    dataProducts.setCreatedAt(now);
                    dataProducts.setCreatedAtTime(time_now);
                    dataProducts.setPic("PIC");
                    List<EntityCategories> cekCategoryName = entityCategoriesFacadeLocal.findWithCategoriesName(categories_name.toLowerCase());
                    System.out.println("isi cekCategoryName" + cekCategoryName);
                    if (cekCategoryName.size() > 0) {
                        dataCategory = entityCategoriesFacadeLocal.getCategories(cekCategoryName.get(0).getCategoryId());
                        dataProducts.setCategoryId(dataCategory);
                    } else {
                        dataCategory.setCategoriesName(categories_name.toLowerCase());
                        dataCategory.setCategoryDesc(categories_name.toLowerCase());
                        dataCategory.setCreatedDate(now);
                        dataCategory.setCreatedTime(time_now);
                        dataCategory.setPic(("PIC").toLowerCase());
                        dataCategory.setIsDelete(false);
                        entityCategoriesFacadeLocal.createCategories(dataCategory);
                        dataProducts.setCategoryId(dataCategory);
                    }
//                  dataCategory = entityCategoriesFacadeLocal.getCategories(categori_id);
//                  dataProducts.setCategoryId(dataCategory);
                    dataProducts.setStatus_item(0);
                    dataProducts.setDescription(description.toLowerCase());
                    dataProducts.setProductCode(product_code.toLowerCase());
                    dataProducts.setBarcode("");
                    dataProducts.setPict_path("");
                    dataProducts.setUpdatedAt(now);
                    dataProducts.setUpdatedAtTime(time_now);
                    entityProductsFacadeLocal.updateProducts(dataProducts);
                    dataStock.setIdProduct(dataProducts);
                    dataStock.setBuyPrice(price_item);
                    dataStock.setSellPrice("0");
                    try {
                        dataStock.setEstematedDateBefore(sdf.parse(estemated_date_before));
                    } catch (ParseException ex) {
                        Logger.getLogger(ItemServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        dataStock.setEstematedDateAfter(sdf.parse(estemated_date_after));
                    } catch (ParseException ex) {
                        Logger.getLogger(ItemServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    entityStockFacadeLocal.updateStock(dataStock);

                    code = "3";
                    msg = "Has been Updated";
                } else if (action_delete.equalsIgnoreCase("DELETE")) {
                    dataProducts = entityProductsFacadeLocal.getProducts(id_product);
                    dataStock = entityStockFacadeLocal.find(id_product);
                    dataProducts.setStatus_item(2);
                    dataProducts.setIsDelete(true);
                    dataProducts.setUpdatedAt(now);
                    dataProducts.setUpdatedAtTime(time_now);
                    dataStock.setIsDelete(true);
                    entityProductsFacadeLocal.updateProducts(dataProducts);
                    entityStockFacadeLocal.updateStock(dataStock);
                    code = "4";
                    msg = "Has been Deleted";
                } else if (action_delete.equalsIgnoreCase("Approve")) {
                    dataProducts = entityProductsFacadeLocal.getProducts(id_product);
                    dataProducts.setStatus_item(1);
                    dataProducts.setIsDelete(false);
                    dataProducts.setUpdatedAt(now);
                    dataProducts.setUpdatedAtTime(time_now);
                    entityProductsFacadeLocal.updateProducts(dataProducts);
                    code = "4";
                    msg = "Has been Approved";
                } else if (action_delete.equalsIgnoreCase("reject")) {
                    dataProducts = entityProductsFacadeLocal.getProducts(id_product);
                    dataProducts.setStatus_item(2);
                    dataProducts.setIsDelete(false);
                    dataProducts.setUpdatedAt(now);
                    dataProducts.setUpdatedAtTime(time_now);
                    entityProductsFacadeLocal.updateProducts(dataProducts);
                    code = "4";
                    msg = "Has been rejected";
                }

            }
            JSONObject jsonobj = new JSONObject();
            jsonobj.put("RC", code);
            jsonobj.put("msg", msg);
            out.println(jsonobj.toString());
            out.flush();
            System.out.println(jsonobj.toString());
        } catch (IOException ex) {
            Logger.getLogger(ItemServlet.class.getName()).log(Level.SEVERE, null, ex);
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
