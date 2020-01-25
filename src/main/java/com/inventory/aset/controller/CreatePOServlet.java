/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.controller;

import com.inventory.aset.entity.EntityProductPurchase;
import com.inventory.aset.entity.EntityPurchases;
import com.inventory.aset.entity.EntitySuppliers;
import com.inventory.aset.entity.EntityTypePO;
import com.inventory.aset.facadebean.local.EntityProductPurchaseFacadeLocal;
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
import com.inventory.aset.facadebean.local.EntityPurchasesFacadeLocal;
import com.inventory.aset.facadebean.local.EntitySuppliersFacadeLocal;
import com.inventory.aset.facadebean.local.EntityTypePOFacadeLocal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;
import javax.persistence.Query;

/**
 *
 * @author newbiecihuy
 */
@WebServlet(name = "CreatePOServlet", urlPatterns = {"/createPOServlet"})
public class CreatePOServlet extends HttpServlet {

    public CreatePOServlet() {

    }
    @EJB
    EntityPurchasesFacadeLocal entityPurchasesFacadeLocal;
    @EJB
    EntityProductPurchaseFacadeLocal entityProductPurchaseFacadeLocal;
    @EJB
    EntitySuppliersFacadeLocal entitySuppliersFacadeLocal;
    @EJB
    EntityTypePOFacadeLocal entityTypePOFacadeLocal;

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
            SimpleDateFormat sdfMonthPO = new SimpleDateFormat("MM");
            SimpleDateFormat sdfYearNoPO = new SimpleDateFormat("yyyy");
            SimpleDateFormat sdfMonthCompare = new SimpleDateFormat("MM");
            SimpleDateFormat sdfYearCompare = new SimpleDateFormat("yyyy");
//          String rows = request.getParameter("rows");
            String page = request.getParameter("page");
            Date tgl_input_po = null;
            Date tgl_input_po_date = null;
            String noPo, noPoVal, year, monthCompare, yearCompare = null;
            // default
            String draw = "0";
            String start = "0";
            String length = "";
            String orderColumnIndex = "0";
            String orderDir = "asc";
            draw = request.getParameter("draw");
            start = request.getParameter("start");
            length = request.getParameter("length");

            System.out.println("length " + length);
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
            int recordsFiltered = entityPurchasesFacadeLocal.count();
            System.out.println("recordsFiltered " + recordsFiltered);
//             
            Date d2 = sdf.parse(tgl);
            String relation = "";
            Date tanggalMasuk = null;
            Date tanggalGaransi = null;
            JSONArray jsonArray = new JSONArray();
            int no = Integer.parseInt(start) + 1;
            List<EntityPurchases> poList = null;
            if (searchString.isEmpty()) {
                poList = entityPurchasesFacadeLocal.getAllPurchases(Integer.parseInt(length), Integer.parseInt(start));
            } else {
                poList = entityPurchasesFacadeLocal.searchPurchases(searchString.toLowerCase(), Integer.parseInt(length), Integer.parseInt(start));
            }

            if (Integer.parseInt(length) <= poList.size()) {
                totalCount = poList.size();
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
            if (poList.size() > 0) {
                for (int i = 0; i < poList.size(); i++) {
                    EntityPurchases dataPO = (EntityPurchases) poList.get(i);
                    JSONObject obj = new JSONObject();

                    if (dataPO.getPurchaseId() == null) {
                        obj.put("purchase_id", "");
                        obj.put("no", "");
                        obj.put("action_po", "");
                    } else {
                        obj.put("purchase_id", dataPO.getPurchaseId());
                        obj.put("no", no++);
                        obj.put("action_po", "");
                    }
                    if (dataPO.getPurchaseCode() == null) {
                        obj.put("purchase_code", "");
                    } else {
                        obj.put("purchase_code", dataPO.getPurchaseCode());
                    }
                    if (dataPO.getSupplierId().getSupplierId() == null) {
                        obj.put("supplier_id", "");
                    } else {
                        obj.put("supplier_id", dataPO.getSupplierId().getSupplierId());
                    }
                    if (dataPO.getSupplierId().getSupplierName() == null) {
                        obj.put("supplier_name", "");
                    } else {
                        obj.put("supplier_name", EncryptionUtil.upperCaseFirst(dataPO.getSupplierId().getSupplierName()));
                    }
                    if (dataPO.getSupplierId().getSupplierCode() == null) {
                        obj.put("supplier_code", "");
                    } else {
                        obj.put("supplier_code", EncryptionUtil.upperCaseFirst(dataPO.getSupplierId().getSupplierCode()));
                    }
                    if (dataPO.getSupplierId().isTax()) {
                        obj.put("supplier_tax", "1");
                    } else {
                        obj.put("supplier_tax", "0");
                    }
                    if (dataPO.getDate() == null) {
                        obj.put("tgl_input_po", "");
                    } else {
                        obj.put("tgl_input_po", sdf.format(dataPO.getDate()));
                    }
                    if (dataPO.getTime() == null) {
                        obj.put("time_input_po", "");
                    } else {
                        obj.put("time_input_po", dataPO.getTime());
                    }
                    if (dataPO.getTypePOId().getTypePo() == null) {
                        obj.put("po_type", "");
                    } else {
                        obj.put("po_type", EncryptionUtil.upperCaseFirst(dataPO.getTypePOId().getTypePo()));
                    }
                    if (dataPO.getTypePOId().getPaymentTerm() == null) {
                        obj.put("payment_term", "");
                    } else {
                        obj.put("payment_term", EncryptionUtil.upperCaseFirst(dataPO.getTypePOId().getPaymentTerm()));
                    }
                    if (dataPO.getDeliveryTerm() == null) {
                        obj.put("delivery_term", "");
                    } else {
                        obj.put("delivery_term", EncryptionUtil.upperCaseFirst(dataPO.getDeliveryTerm()));
                    }
                    if (dataPO.getTransportMode() == null) {
                        obj.put("transport_mode", "");
                    } else {
                        obj.put("transport_mode", EncryptionUtil.upperCaseFirst(dataPO.getTransportMode()));
                    }
                    if (dataPO.getQuotationNumber() == null) {
                        obj.put("quotation_number", "");
                    } else {
                        obj.put("quotation_number", dataPO.getQuotationNumber());
                    }
                    if (dataPO.getRfqNumber() == null) {
                        obj.put("rfq_number", "");
                    } else {
                        obj.put("rfq_number", dataPO.getRfqNumber());
                    }
                    if (dataPO.getDeliveryPoint() == null) {
                        obj.put("dlvr_point", "");
                    } else {
                        obj.put("dlvr_point", EncryptionUtil.upperCaseFirst(dataPO.getDeliveryPoint()));
                    }
                    if (dataPO.getInvoiceTo() == null) {
                        obj.put("invoice_to", "");
                    } else {
                        obj.put("invoice_to", EncryptionUtil.upperCaseFirst(dataPO.getInvoiceTo()));
                    }
                    if (dataPO.getPurchaseDesc() == null) {
                        obj.put("purchase_desc", "");
                    } else {
                        obj.put("purchase_desc", EncryptionUtil.upperCaseFirst(dataPO.getPurchaseDesc()));
                    }
                    if (dataPO.getStatusPo() == null) {
                        obj.put("status_po", "");
                    } else {
                        List<EntityProductPurchase> itemPurchaseList = entityProductPurchaseFacadeLocal.productPOlist(dataPO.getPurchaseId());
                        System.out.println("itemPurchaseList == " + itemPurchaseList);
                        if (itemPurchaseList.isEmpty()) {
                            System.out.println("itemPurchaseList == " + null);
                            obj.put("status_po", "No Item");
                        } else {
                            obj.put("status_po", EncryptionUtil.upperCaseFirst(dataPO.getStatusPo()));
                        }
                    }
                    if (dataPO.getPic() == null) {
                        obj.put("pic", "");
                    } else {
                        obj.put("pic", EncryptionUtil.upperCaseFirst(dataPO.getPic()));
                    }
//                    if (!dataPO.isIsApprove()) {
//                        obj.put("is_approve", "0");
//                    } else {
//                        obj.put("is_approve", "1");
//                    }
                    if (dataPO.getIsApprove() == 0) {
                        obj.put("is_approve", 0);
                    } else {
                        obj.put("is_approve", dataPO.getIsApprove());
                    }

                    if (!dataPO.isIsDelete()) {
                        obj.put("is_delete", "0");
                    } else {
                        obj.put("is_delete", "1");
                    }

                    if (dataPO.getAppproveBy() == null) {
                        obj.put("approve_by", "");
                    } else {
                        obj.put("approve_by", EncryptionUtil.upperCaseFirst(dataPO.getAppproveBy()));
                    }

                    EntityPurchases dataPurchases = entityPurchasesFacadeLocal.getPurchases(dataPO.getPurchaseId());
                    if (dataPurchases != null) {
                        int nilai = 0;
                        String PONumber = null;
                        monthCompare = sdfMonthCompare.format(now);
                        yearCompare = sdfYearCompare.format(now);

                        noPo = sdfMonthPO.format(dataPO.getDate());
                        year = sdfYearNoPO.format(dataPO.getDate());
                        noPoVal = EncryptionUtil.setMonth(noPo);
                        System.out.println("monthCompare :" + monthCompare);
                        System.out.println("noPo :" + noPo);
                        System.out.println("yearCompare :" + yearCompare);
                        System.out.println("year :" + year);
//                        int nilai = i + 1;
                        if (monthCompare.equals(noPo) && yearCompare.equals(year)) {
                            System.out.println("equals");
                            nilai = dataPO.getNoPo().intValue() + 1;
                            PONumber = EncryptionUtil.setNumber(String.valueOf(nilai)) + "/" + "PO" + "/" + "TNT" + "/" + noPoVal + "/" + year;
//                            dataPurchases.setPurchaseCode(PONumber);
//                            dataPurchases.setNoPo(Long.valueOf(nilai));
//                            entityPurchasesDao.updatePurchases(dataPurchases);
                        } else {
                            System.out.println("!equals");
                            nilai = 1;
                            PONumber = EncryptionUtil.setNumber(String.valueOf(nilai)) + "/" + "PO" + "/" + "TNT" + "/" + noPoVal + "/" + year;
//                             dataPurchases.setPurchaseCode(PONumber);
//                            dataPurchases.setNoPo(Long.valueOf(nilai));
//                            entityPurchasesDao.updatePurchases(dataPurchases);
                        }

                    }
                    jsonArray.add(obj);
                }
            }
            JSONObject jsonobj = new JSONObject();
            jsonobj.put("draw", request.getParameter("draw"));
            jsonobj.put("totalpages", totalPages);
            jsonobj.put("length", length);
            jsonobj.put("recordsTotal", poList.size());
            jsonobj.put("recordsFiltered", recordsFiltered);
            jsonobj.put("rows", jsonArray);
            out.println(jsonobj);

            out.close();
        } catch (ParseException ex) {
            Logger.getLogger(CreatePOServlet.class.getName()).log(Level.SEVERE, null, ex);
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

            System.out.println("Tester");
            response.setContentType("application/json");
            response.setHeader("cache-control", "no-cache");
            PrintWriter out = response.getWriter();

            String code = "0";
            String msg = "";
            System.out.println("cek json" + request.getParameter("JSONFile"));
//            if (!request.getParameter("JSONFile").isEmpty()) {
//                System.out.println("cek json" + request.getParameter("JSONFile"));
//                return;
//            }
            JSONArray array = (JSONArray) JSONSerializer.toJSON(request.getParameter("JSONFile"));
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat sdfa = new SimpleDateFormat("yyyy/MM/dd");
//            SimpleDateFormat sdfc = new SimpleDateFormat("yyyy/MM/dd");
            SimpleDateFormat sdfMonthPO = new SimpleDateFormat("MM");
            SimpleDateFormat sdfYearNoPO = new SimpleDateFormat("yyyy");
            SimpleDateFormat jamFormat = new SimpleDateFormat("HH:mm:ss");
            SimpleDateFormat sdfMonthCompare = new SimpleDateFormat("MM");
            SimpleDateFormat sdfYearCompare = new SimpleDateFormat("yyyy");

//             SimpleDateFormat sdfMonthPO = new SimpleDateFormat("MM");
//            SimpleDateFormat sdfYearNoPO = new SimpleDateFormat("yyyy");
            Date tgl = new Date();
            Date now = new Date();
            sdf.format(now);
            String time_now = jamFormat.format(tgl);
            String action_insert = "";
            String action_edit = "";
            String action_delete = "";
            String tgl_1 = "";
            Date cek_tanggal = null;
            long purchase_id = 0l;
            long supplier_id = 0l;
            Date tgl_input_po = null;
            Date tgl_input_po_date = null;
            String noPo, noPoVal, year, monthCompare, yearCompare = null;
            String supplier_name, supplier_code, isi_tgl_input, po_type, payment_term,
                    delivery_term, transport_mode, quotation_number, rfq_number, invoice_to, tax_po,
                    dlvr_point, purchase_desc = "";

            EntityPurchases dataPurchases = new EntityPurchases();
            EntitySuppliers dataSupplier = new EntitySuppliers();
            EntityTypePO dataTypePO = new EntityTypePO();

            for (int i = 0; i < array.size(); i++) {
                JSONObject object = array.getJSONObject(0);
                object = array.getJSONObject(i);
                action_insert = object.getString("action_insert_po");
                action_edit = object.getString("action_edit_po").trim().replaceAll("['\":<>\\[\\],-]", "");
                action_delete = object.getString("action_delete_po").trim().replaceAll("['\":<>\\[\\],-]", "");

                if (!"".equals(object.getString("purchase_id")) && !object.getString("purchase_id").isEmpty()) {
                    purchase_id = object.getLong("purchase_id");
                }

                if (purchase_id == 0l) {

                    if (!object.getString("supplier_name_po").isEmpty()) {
                        supplier_name = object.getString("supplier_name_po");
                    } else {
                        supplier_name = "";
                    }
                    if (!object.getString("supplier_code_po").isEmpty()) {
                        supplier_code = object.getString("supplier_code_po");
                    } else {
                        supplier_code = "";
                    }
                    if (!object.getString("tgl_input_po").isEmpty()) {
                        isi_tgl_input = object.getString("tgl_input_po");
                        try {
                            tgl_input_po_date = sdf.parse(isi_tgl_input);
                            String newDateString = sdf.format(tgl_input_po_date);
                            tgl_input_po = sdf.parse(newDateString);
                        } catch (ParseException ex) {
                            Logger.getLogger(CreatePOServlet.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else {
                        tgl_input_po = now;
                    }
                    if (!object.getString("po_type").isEmpty()) {
                        po_type = object.getString("po_type").toLowerCase();
                    } else {
                        po_type = "";
                    }
                    if (!object.getString("payment_term").isEmpty()) {
                        payment_term = object.getString("payment_term");
                    } else {
                        payment_term = "";
                    }

                    if (!object.getString("purchase_desc").isEmpty()) {
                        purchase_desc = object.getString("purchase_desc");
                    } else {
                        purchase_desc = "";
                    }
                    if (!object.getString("delivery_term").isEmpty()) {
                        delivery_term = object.getString("delivery_term");
                    } else {
                        delivery_term = "";
                    }
                    if (!object.getString("transport_mode").isEmpty()) {
                        transport_mode = object.getString("transport_mode");
                    } else {
                        transport_mode = "";
                    }
                    if (!object.getString("quotation_number").isEmpty()) {
                        quotation_number = object.getString("quotation_number");
                    } else {
                        quotation_number = "";
                    }
                    if (!object.getString("rfq_number").isEmpty()) {
                        rfq_number = object.getString("rfq_number");
                    } else {
                        rfq_number = "";
                    }
                    if (!object.getString("rfq_number").isEmpty()) {
                        rfq_number = object.getString("rfq_number");
                    } else {
                        rfq_number = "";
                    }
                    if (!object.getString("invoice_to").isEmpty()) {
                        invoice_to = object.getString("invoice_to");
                    } else {
                        invoice_to = "";
                    }
                    if (!object.getString("dlvr_point").isEmpty()) {
                        dlvr_point = object.getString("dlvr_point");
                    } else {
                        dlvr_point = "";
                    }
                    if (!object.getString("tax_po").isEmpty()) {
                        tax_po = object.getString("tax_po");
                    } else {
                        tax_po = "";
                    }

                    List<EntityTypePO> cekTypePO = entityTypePOFacadeLocal.getByTypePO(po_type.toLowerCase());
                    System.out.println("isi cekTypePO" + cekTypePO);
                    if (cekTypePO.size() > 0) {
                        dataTypePO = entityTypePOFacadeLocal.getTypePO(cekTypePO.get(0).getTypePOId());
                        dataPurchases.setTypePOId(dataTypePO);
                    } else {
                        dataTypePO.setTypePo(po_type.toLowerCase());
                        dataTypePO.setPaymentTerm(payment_term.toLowerCase());
                        dataTypePO.setInputDate(now);
                        dataTypePO.setInputTime(time_now);
                        dataTypePO.setPic(("PIC").toLowerCase());

                        entityTypePOFacadeLocal.createTypePO(dataTypePO);
                        dataPurchases.setTypePOId(dataTypePO);
                    }

                    List<EntitySuppliers> cekSuplierName = entitySuppliersFacadeLocal.getSupplierName(supplier_name.toLowerCase());
                    System.out.println("isi cekSuplierName" + cekSuplierName);
                    if (cekSuplierName.size() > 0) {
                        dataSupplier = entitySuppliersFacadeLocal.getSuppliers(cekSuplierName.get(0).getSupplierId());
                        dataPurchases.setSupplierId(dataSupplier);
                    }
                    dataPurchases.setPic(("PIC").toLowerCase());
                    dataPurchases.setDate(tgl_input_po);
                    dataPurchases.setInputDate(now);
                    dataPurchases.setInputTime(time_now);
//                    noPo = sdfNoPO.format(tgl_input_po);
//                    year = sdfYearNoPO.format(tgl_input_po);
//                    noPoVal = EncryptionUtil.setMonth(noPo);
//                    int nilai = i++;
//                    dataPurchases.setPurchaseCode(EncryptionUtil.setNumber(String.valueOf(nilai)) + "/" + "PO" + "/" + "TNT" + "/" + noPoVal + "/" + year);
                    dataPurchases.setTime(time_now);
//                    dataPurchases.setPoType(po_type.toLowerCase());
                    dataPurchases.setDeliveryTerm(delivery_term);
                    dataPurchases.setTransportMode(transport_mode.toLowerCase());
                    dataPurchases.setQuotationNumber(quotation_number);
                    dataPurchases.setRfqNumber(rfq_number);
                    dataPurchases.setPurchaseDesc(purchase_desc.toLowerCase());
                    dataPurchases.setDeliveryPoint(dlvr_point.toLowerCase());
                    dataPurchases.setInvoiceTo(invoice_to.toLowerCase());

                    int nilai = 0;
                    String PONumber = null;
                    monthCompare = sdfMonthCompare.format(now);
                    yearCompare = sdfYearCompare.format(now);
                    noPo = sdfMonthPO.format(tgl_input_po);
                    year = sdfYearNoPO.format(tgl_input_po);
                    noPoVal = EncryptionUtil.setMonth(noPo);
                    System.out.println("monthCompare :" + monthCompare);
                    System.out.println("noPo :" + noPo);
                    System.out.println("yearCompare :" + yearCompare);
                    System.out.println("year :" + year);
//                        int nilai = i + 1;
                    if (monthCompare.equals(noPo) && yearCompare.equals(year)) {
                        System.out.println("equals");
                        System.out.println("now :" + now);
                        tgl_1 = sdfa.format(now);
                        cek_tanggal = sdfa.parse(tgl_1);
                        System.out.println("cek_tanggal :" + cek_tanggal);
                        System.out.println("time_now :" + time_now);
                        EntityPurchases getNopo = entityPurchasesFacadeLocal.findByNoPo(cek_tanggal, time_now);
                        if (getNopo !=null ) {
                            System.out.println("getNopo.size()" + getNopo);
                            nilai = getNopo.getNoPo().intValue() + 1;
                            System.out.println("equals nilai" + nilai);
                            PONumber = EncryptionUtil.setNumber(String.valueOf(nilai)) + "/" + "PO" + "/" + "TNT" + "/" + noPoVal + "/" + year;
                            dataPurchases.setPurchaseCode(PONumber);
                            dataPurchases.setNoPo(Long.valueOf(nilai));
                        } else {
                            System.out.println("empty");
                            nilai = 1;
                            PONumber = EncryptionUtil.setNumber(String.valueOf(nilai)) + "/" + "PO" + "/" + "TNT" + "/" + noPoVal + "/" + year;
                            dataPurchases.setPurchaseCode(PONumber);
                            dataPurchases.setNoPo(Long.valueOf(nilai));
                        }
                    } else {
                        System.out.println("!equals");
                        nilai = 1;
                        PONumber = EncryptionUtil.setNumber(String.valueOf(nilai)) + "/" + "PO" + "/" + "TNT" + "/" + noPoVal + "/" + year;
                        dataPurchases.setPurchaseCode(PONumber);
                        dataPurchases.setNoPo(Long.valueOf(nilai));
                    }
                    entityPurchasesFacadeLocal.createPurchases(dataPurchases);
                    code = "1";
                    msg = "Has been Recorded";
                    System.out.println("isi c" + dataPurchases);
                } else if (action_edit.equalsIgnoreCase("EDIT")) {
                    dataPurchases = entityPurchasesFacadeLocal.getPurchases(purchase_id);

                    entitySuppliersFacadeLocal.getSuppliers(supplier_id);
                    if (!object.getString("supplier_name_po").isEmpty()) {
                        supplier_name = object.getString("supplier_name_po");
                    } else {
                        supplier_name = "";
                    }
                    if (!object.getString("supplier_code_po").isEmpty()) {
                        supplier_code = object.getString("supplier_code_po");
                    } else {
                        supplier_code = "";
                    }
                    if (!object.getString("tgl_input_po").isEmpty()) {
                        isi_tgl_input = object.getString("tgl_input_po");
                        try {
                            tgl_input_po_date = sdf.parse(isi_tgl_input);
                            String newDateString = sdf.format(tgl_input_po_date);
                            tgl_input_po = sdf.parse(newDateString);
                        } catch (ParseException ex) {
                            Logger.getLogger(CreatePOServlet.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else {
                        tgl_input_po = now;
                    }
                    if (!object.getString("po_type").isEmpty()) {
                        po_type = object.getString("po_type").toLowerCase();
                    } else {
                        po_type = "";
                    }
                    if (!object.getString("payment_term").isEmpty()) {
                        payment_term = object.getString("payment_term");
                    } else {
                        payment_term = "";
                    }
                    if (!object.getString("purchase_desc").isEmpty()) {
                        purchase_desc = object.getString("purchase_desc");
                    } else {
                        purchase_desc = "";
                    }
                    if (!object.getString("delivery_term").isEmpty()) {
                        delivery_term = object.getString("delivery_term");
                    } else {
                        delivery_term = "";
                    }
                    if (!object.getString("transport_mode").isEmpty()) {
                        transport_mode = object.getString("transport_mode");
                    } else {
                        transport_mode = "";
                    }
                    if (!object.getString("quotation_number").isEmpty()) {
                        quotation_number = object.getString("quotation_number");
                    } else {
                        quotation_number = "";
                    }
                    if (!object.getString("rfq_number").isEmpty()) {
                        rfq_number = object.getString("rfq_number");
                    } else {
                        rfq_number = "";
                    }
                    if (!object.getString("invoice_to").isEmpty()) {
                        invoice_to = object.getString("invoice_to");
                    } else {
                        invoice_to = "";
                    }
                    if (!object.getString("dlvr_point").isEmpty()) {
                        dlvr_point = object.getString("dlvr_point");
                    } else {
                        dlvr_point = "";
                    }
                    if (!object.getString("tax_po").isEmpty()) {
                        tax_po = object.getString("tax_po");
                    } else {
                        tax_po = "";
                    }
                    List<EntityTypePO> cekTypePO = entityTypePOFacadeLocal.getByTypePO(po_type.toLowerCase());
                    System.out.println("isi cekTypePO" + cekTypePO);
                    if (cekTypePO.size() > 0) {
                        dataTypePO = entityTypePOFacadeLocal.getTypePO(cekTypePO.get(0).getTypePOId());
                        dataPurchases.setTypePOId(dataTypePO);
                    } else {
                        dataTypePO.setTypePo(po_type.toLowerCase());
                        dataTypePO.setPaymentTerm(payment_term.toLowerCase());
                        dataTypePO.setInputDate(now);
                        dataTypePO.setInputTime(time_now);
                        dataTypePO.setPic(("PIC").toLowerCase());

                        entityTypePOFacadeLocal.createTypePO(dataTypePO);
                        dataPurchases.setTypePOId(dataTypePO);
                    }

                    List<EntitySuppliers> cekSuplierName = entitySuppliersFacadeLocal.getSupplierName(supplier_name.toLowerCase());
                    System.out.println("isi cekSuplierName" + cekSuplierName);
                    if (cekSuplierName.size() > 0) {
                        dataSupplier = entitySuppliersFacadeLocal.getSuppliers(cekSuplierName.get(0).getSupplierId());
                        dataPurchases.setSupplierId(dataSupplier);
                    }
                    dataPurchases.setPic(("PIC").toLowerCase());
                    dataPurchases.setDate(tgl_input_po);
                    dataPurchases.setTime(time_now);
                    dataPurchases.setDateEdit(now);
                    dataPurchases.setTimeEdit(time_now);
//                    dataPurchases.setPoType(po_type.toLowerCase());
                    dataPurchases.setDeliveryTerm(delivery_term);
                    dataPurchases.setTransportMode(transport_mode.toLowerCase());
                    dataPurchases.setQuotationNumber(quotation_number);
                    dataPurchases.setRfqNumber(rfq_number);
                    dataPurchases.setPurchaseDesc(purchase_desc.toLowerCase());
                    dataPurchases.setDeliveryPoint(dlvr_point.toLowerCase());
                    dataPurchases.setInvoiceTo(invoice_to.toLowerCase());

                    int nilai = 0;
                    String PONumber = null;
                    monthCompare = sdfMonthCompare.format(now);
                    yearCompare = sdfYearCompare.format(now);
                    noPo = sdfMonthPO.format(tgl_input_po);
                    year = sdfYearNoPO.format(tgl_input_po);
                    noPoVal = EncryptionUtil.setMonth(noPo);
//                        int nilai = i + 1;
                    if (monthCompare.equals(noPo) && yearCompare.equals(year)) {
                        nilai = i + 1;
                        PONumber = EncryptionUtil.setNumber(String.valueOf(nilai)) + "/" + "PO" + "/" + "TNT" + "/" + noPoVal + "/" + year;
                        dataPurchases.setPurchaseCode(PONumber);
                    } else {
                        nilai = 1;
                        PONumber = EncryptionUtil.setNumber(String.valueOf(nilai)) + "/" + "PO" + "/" + "TNT" + "/" + noPoVal + "/" + year;
                        dataPurchases.setPurchaseCode(PONumber);
                    }

                    entityPurchasesFacadeLocal.updatePurchases(dataPurchases);
                    System.out.println("isi e" + dataPurchases);
                    code = "2";
                    msg = "Has been Updated";
                } else if (action_edit.equalsIgnoreCase("Approve")) {
                    dataPurchases = entityPurchasesFacadeLocal.getPurchases(purchase_id);
                    dataPurchases.setIsApprove(1);
                    dataPurchases.setAppproveBy("Pak Yos");
                    dataPurchases.setDateEdit(now);
                    dataPurchases.setTimeEdit(time_now);
                    entityPurchasesFacadeLocal.updatePurchases(dataPurchases);
                    System.out.println("isi a" + dataPurchases);
                    code = "3";
                    msg = "Approved";
                } else if (action_edit.equalsIgnoreCase("DELETE")) {
                    dataPurchases = entityPurchasesFacadeLocal.getPurchases(purchase_id);
                    dataPurchases.setIsDelete(false);
                    dataPurchases.setPic("PIC");
                    dataPurchases.setDateEdit(now);
                    dataPurchases.setTimeEdit(time_now);
                    entityPurchasesFacadeLocal.updatePurchases(dataPurchases);
                    System.out.println("isi d" + dataPurchases);
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
        } catch (IOException | ParseException ex) {
            Logger.getLogger(CreatePOServlet.class.getName()).log(Level.SEVERE, null, ex);
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
