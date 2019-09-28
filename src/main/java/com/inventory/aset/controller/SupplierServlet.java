/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.controller;

import com.inventory.aset.entity.EntitySuppliers;
import com.inventory.aset.controller.util.EncryptionUtil;
import com.inventory.aset.entity.EntityProducts;
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
import com.inventory.aset.entity.EntitySettings;
import com.inventory.aset.facadebean.local.EntityProductsFacadeLocal;
import com.inventory.aset.facadebean.local.EntitySettingsFacadeLocal;
import com.inventory.aset.facadebean.local.EntitySuppliersFacadeLocal;

/**
 *
 * @author newbiecihuy
 */
@WebServlet(name = "SupplierServlet", urlPatterns = {"/supplierServlet"})
public class SupplierServlet extends HttpServlet {

    public SupplierServlet() {
    }
    @EJB
    EntitySuppliersFacadeLocal entitySuppliersFacadeLocal;
    @EJB
    EntitySettingsFacadeLocal entitySettingsFacadeLocal;
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
//            out.println("<title>Servlet SupplierServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet SupplierServlet at " + request.getContextPath() + "</h1>");
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
            int recordsFiltered = entitySuppliersFacadeLocal.count();
            System.out.println("recordsFiltered " + recordsFiltered);
            Date d2 = sdf.parse(tgl);
            String relation = "";
            Date tanggalMasuk = null;
            Date tanggalGaransi = null;

            JSONArray jsonArray = new JSONArray();
            int no = Integer.parseInt(start) + 1;
            List<EntitySuppliers> supplierList = null;
            if (searchString.isEmpty()) {
                supplierList = entitySuppliersFacadeLocal.getAllSuppliers(Integer.parseInt(length), Integer.parseInt(start));
            } else {
                supplierList = entitySuppliersFacadeLocal.searchSuppliers(searchString, Integer.parseInt(length), Integer.parseInt(start));
            }

            if (Integer.parseInt(length) <= supplierList.size()) {
                totalCount = supplierList.size();
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

            if (supplierList.size() > 0) {
                for (int i = 0; i < supplierList.size(); i++) {
                    EntitySuppliers dataSuppliers = (EntitySuppliers) supplierList.get(i);
                    JSONObject obj = new JSONObject();
//                    if (dataSuppliers.isIsActive() == true) {
                    if (dataSuppliers.getSupplierId() == null) {
                        obj.put("supplier_id", "");
                        obj.put("no", "");
                        obj.put("action_supp", "");
                    } else {
                        obj.put("supplier_id", dataSuppliers.getSupplierId());
                        obj.put("no", no++);
                        obj.put("action_supp", "");
                    }
                    if (dataSuppliers.getCreatedDate() == null) {
                        obj.put("created_date", "");
                    } else {
                        obj.put("created_date", sdf.format(dataSuppliers.getCreatedDate()) + "-" + dataSuppliers.getCreatedTime());
                    }
                    if (dataSuppliers.getSupplierName() == null) {
                        obj.put("supplier_name", "");
                    } else {
                        obj.put("supplier_name", EncryptionUtil.upperCaseFirst(dataSuppliers.getSupplierName()));
                    }
                    if (dataSuppliers.getSupplierCode() == null) {
                        obj.put("supplier_code", "");
                    } else {
                        obj.put("supplier_code", EncryptionUtil.upperCaseFirst(dataSuppliers.getSupplierCode()));
                    }
                    if (dataSuppliers.getAddress() == null) {
                        obj.put("address", "");
                    } else {
                        obj.put("address", EncryptionUtil.upperCaseFirst(dataSuppliers.getAddress()));
                    }
                    if (dataSuppliers.getContactName() == null) {
                        obj.put("contact_name", "");
                    } else {
                        obj.put("contact_name", EncryptionUtil.upperCaseFirst(dataSuppliers.getContactName()));
                    }
                    if (dataSuppliers.getContactNum() == null) {
                        obj.put("contact_num", "");
                    } else {
                        obj.put("contact_num", dataSuppliers.getContactNum());
                    }
                    if (dataSuppliers.isTax()) {
                        obj.put("tax", "1");
                    } else {
                        obj.put("tax", "0");
                    }
//                        if (!dataSuppliers.isIsActive()) {
//                            obj.put("status_supp", "0");
//                        } else {
//                            obj.put("status_supp", "1");
//                        }
                    if (dataSuppliers.getIsActive() == 0) {
                        obj.put("status_supp", 0);
                    } else {
                        obj.put("status_supp", dataSuppliers.getIsActive());
                    }
                    List<EntityProducts> chekList = entityProductsFacadeLocal.findByProductActiveBySup(dataSuppliers.getSupplierId());
                    if (chekList.size() > 0) {
                        obj.put("listItem", "1");
                    } else {
                        obj.put("listItem", "0");
                    }
//                         if (dataSuppliers.getContactNum() == null) {
//                            obj.put("status_supp", "");
//                        } else {
//                            obj.put("status_supp", dataSuppliers.getContactNum());
//                        }
                    List<EntitySettings> getSupllierCode = entitySettingsFacadeLocal.findWithParamName("supplier_code");
                    if (getSupllierCode.size() > 0) {
                        EntitySettings dataSetting = getSupllierCode.get(0);

                        EntitySuppliers updateData = entitySuppliersFacadeLocal.getSuppliers(dataSuppliers.getSupplierId());
                        updateData.setSupplierCode(dataSetting.getValue());
                        entitySuppliersFacadeLocal.updateSuppliers(updateData);
                    }
//                    }
                    jsonArray.add(obj);
                }
            }
            JSONObject jsonobj = new JSONObject();
            jsonobj.put("draw", request.getParameter("draw"));
            jsonobj.put("totalpages", totalPages);
            jsonobj.put("length", length);
            jsonobj.put("recordsTotal", supplierList.size());
            jsonobj.put("recordsFiltered", recordsFiltered);
            jsonobj.put("rows", jsonArray);
            out.println(jsonobj);

            out.close();
        } catch (ParseException ex) {
            Logger.getLogger(SupplierServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            System.out.println("isi" + request.getParameter("JSONFile"));
            JSONArray array = (JSONArray) JSONSerializer.toJSON(request.getParameter("JSONFile"));
//JSONArray array = (JSONArray) JSONSerializer.toJSON(EscapeChars.forJSON(request.getParameter("JSONFile")));
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat jamFormat = new SimpleDateFormat("HH:mm:ss");
            Date tgl = new Date();
            Date now = new Date();
            sdf.format(now);
            String time_now = jamFormat.format(tgl);
            String action_insert = "";
            String action_edit = "";
            String action_delete = "";
            long supplier_id = 0;

//            String supplier_name = "";
            String supplier_name = null;
            String supplier_code = null, address_supplier, contact_suplier_name, cotact_suplier_num = null;
            String checkbox_value = null;
            EntitySuppliers dataSupplier = new EntitySuppliers();
            for (int i = 0; i < array.size(); i++) {
                JSONObject object = array.getJSONObject(0);
                object = array.getJSONObject(i);
                action_insert = object.getString("action_insert_supp");
                action_edit = object.getString("action_edit_supp").trim().replaceAll("['\":<>\\[\\],-]", "");
                action_delete = object.getString("action_delete_supp").trim().replaceAll("['\":<>\\[\\],-]", "");

//                if ((object.containsKey("supplier_id")) && (object.getLong("supplier_id") > 0L)) {
//                    supplier_id = object.getLong("supplier_id");
//                }
                if (!"".equals(object.getString("supplier_id")) && !object.getString("supplier_id").isEmpty()) {
                    supplier_id = object.getLong("supplier_id");
                }
                if (supplier_id == 0l) {//action_insert.equalsIgnoreCase("INSERT")
                    if (!object.getString("supplier_name").isEmpty()) {
                        supplier_name = object.getString("supplier_name");
                    } else {
                        supplier_name = "";
                    }
                    if (!object.getString("address_supplier").isEmpty()) {
                        address_supplier = object.getString("address_supplier").trim().replaceAll("['\":<>\\[\\],-]", "");
                    } else {
                        address_supplier = "";
                    }
                    if (!object.getString("supplier_code").isEmpty()) {
                        supplier_code = object.getString("supplier_code");
                    } else {
                        address_supplier = "";
                    }
                    if (!object.getString("contact_suplier_name").isEmpty()) {
                        contact_suplier_name = object.getString("contact_suplier_name");
                    } else {
                        contact_suplier_name = "";
                    }
                    if (!object.getString("cotact_suplier_num").isEmpty()) {
                        cotact_suplier_num = object.getString("cotact_suplier_num");
                    } else {
                        cotact_suplier_num = "";
                    }
//                    if (object.containsKey("checkbox_value")) {
//                        checkbox_value = object.getString("checkbox_value");
//                    } else {
//                        checkbox_value = "";
//                    }
                    if (object.containsKey("tax")) {
                        checkbox_value = object.getString("tax");
                    } else {
                        checkbox_value = "";
                    }
                    List<EntitySuppliers> cekSupplierName = entitySuppliersFacadeLocal.getSupplierName(supplier_name.toLowerCase());
                    System.out.println("isi cekSupplierName" + cekSupplierName);
                    if (cekSupplierName.size() > 0) {
                        code = "2";
                        JSONObject jsonobj = new JSONObject();
                        jsonobj.put("RC", code);
                        jsonobj.put("msg", msg);
                        out.println(jsonobj.toString());
                        out.flush();
                        System.out.println(jsonobj.toString());
                        return;
                    }
                    List<EntitySuppliers> cekSupplierCode = entitySuppliersFacadeLocal.getSupplierCode(supplier_code.toLowerCase());
                    System.out.println("isi cekSupplierCode" + cekSupplierCode);
                    if (cekSupplierCode.size() > 0) {
                        code = "33";
                        msg = "Already Registered";
                        JSONObject jsonobj = new JSONObject();
                        jsonobj.put("RC", code);
                        jsonobj.put("msg", msg);
                        out.println(jsonobj.toString());
                        out.flush();
                        System.out.println(jsonobj.toString());
                        return;
                    }

                    dataSupplier.setSupplierName(supplier_name.toLowerCase());
                    dataSupplier.setSupplierCode(supplier_code.toLowerCase());
                    dataSupplier.setAddress(address_supplier.toLowerCase());
                    dataSupplier.setCreatedDate(now);
                    dataSupplier.setCreatedTime(time_now);
                    dataSupplier.setPic(("PIC").toLowerCase());
                    dataSupplier.setContactName(contact_suplier_name.toLowerCase());
                    dataSupplier.setContactNum(cotact_suplier_num);
                    if ("on".equalsIgnoreCase(checkbox_value)) {
                        dataSupplier.setTax(true);
                    } else {
                        dataSupplier.setTax(false);
                    }
                    entitySuppliersFacadeLocal.createSuppliers(dataSupplier);

                    code = "1";
                    msg = "Has been Recorded";
                } else if (action_edit.equalsIgnoreCase("EDIT")) {
                    dataSupplier = entitySuppliersFacadeLocal.getSuppliers(supplier_id);
                    if (!object.getString("supplier_name").isEmpty()) {
                        supplier_name = object.getString("supplier_name");
                    } else {
                        supplier_name = "";
                    }
                    if (!object.getString("address_supplier").isEmpty()) {
                        address_supplier = object.getString("address_supplier").trim().replaceAll("['\":<>\\[\\],-]", "");
                    } else {
                        address_supplier = "";
                    }
                    if (!object.getString("supplier_code").isEmpty()) {
                        supplier_code = object.getString("supplier_code");
                    } else {
                        address_supplier = "";
                    }
                    if (!object.getString("contact_suplier_name").isEmpty()) {
                        contact_suplier_name = object.getString("contact_suplier_name");
                    } else {
                        contact_suplier_name = "";
                    }
                    if (!object.getString("cotact_suplier_num").isEmpty()) {
                        cotact_suplier_num = object.getString("cotact_suplier_num");
                    } else {
                        cotact_suplier_num = "";
                    }
//                    if (object.containsKey("checkbox_value")) {
//                        checkbox_value = object.getString("checkbox_value");
//                    } else {
//                        checkbox_value = "";
//                    }
                    if (object.containsKey("tax")) {
                        checkbox_value = object.getString("tax");
                    } else {
                        checkbox_value = "";
                    }

                    dataSupplier.setSupplierName(supplier_name.toLowerCase());
                    dataSupplier.setSupplierCode(supplier_code.toLowerCase());
                    dataSupplier.setAddress(address_supplier.toLowerCase());
                    dataSupplier.setUpdatedDate(now);
                    dataSupplier.setUpdatedTime(time_now);
                    dataSupplier.setContactName(contact_suplier_name.toLowerCase());
                    dataSupplier.setContactNum(cotact_suplier_num);
                    if ("on".equalsIgnoreCase(checkbox_value)) {
                        dataSupplier.setTax(true);
                    } else {
                        dataSupplier.setTax(false);
                    }
                    entitySuppliersFacadeLocal.updateSuppliers(dataSupplier);
                    code = "3";
                    msg = "Has been Updated";
                } else if (action_delete.equalsIgnoreCase("DELETE")) {
                    dataSupplier = entitySuppliersFacadeLocal.getSuppliers(supplier_id);
                    dataSupplier.setIsActive(0);
                    dataSupplier.setUpdatedDate(now);
                    dataSupplier.setUpdatedTime(time_now);
                    entitySuppliersFacadeLocal.deleteSuppliers(dataSupplier);
                    code = "4";
                    msg = "Has been Deleted";
                }

            }
            JSONObject jsonobj = new JSONObject();
            jsonobj.put("RC", code);
            jsonobj.put("msg", msg);
            out.println(jsonobj.toString());
            out.flush();
            System.out.println(jsonobj.toString());
        } catch (IOException ex) {
            Logger.getLogger(SupplierServlet.class.getName()).log(Level.SEVERE, null, ex);
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
