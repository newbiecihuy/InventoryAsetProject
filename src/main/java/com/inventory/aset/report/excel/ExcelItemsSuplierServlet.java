/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.report.excel;

import com.inventory.aset.controller.CreatePOServlet;
import com.inventory.aset.entity.EntityProducts;
import com.inventory.aset.entity.EntityStock;
import com.inventory.aset.entity.EntitySuppliers;
import com.inventory.aset.facadebean.local.EntityCategoriesFacadeLocal;
import com.inventory.aset.facadebean.local.EntityProductsFacadeLocal;
import com.inventory.aset.facadebean.local.EntityStockFacadeLocal;
import com.inventory.aset.facadebean.local.EntitySuppliersFacadeLocal;
import com.inventory.aset.util.EncryptionUtil;
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
import jxl.HeaderFooter;
import jxl.Workbook;
import jxl.write.Border;
import jxl.write.BorderLineStyle;
import jxl.write.Colour;
import jxl.write.Formula;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

/**
 *
 * @author newbiecihuy
 */
@WebServlet(name = "ExcelItemsSuplierServlet", urlPatterns = {"/excelItemsSuplierServlet"})
public class ExcelItemsSuplierServlet extends HttpServlet {

    public ExcelItemsSuplierServlet() {
    }
    @EJB
    EntityProductsFacadeLocal entityProductsDao;
    @EJB
    EntityCategoriesFacadeLocal entityCategoriesDao;
    @EJB
    EntitySuppliersFacadeLocal entitySuppliersDao;
    @EJB
    EntityStockFacadeLocal entityStockDao;

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
//            out.println("<title>Servlet ExcelItemsSuplierServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ExcelItemsSuplierServlet at " + request.getContextPath() + "</h1>");
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
//        PrintWriter out = response.getWriter();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date now = new Date();
            String tgl = sdf.format(now);
            String supplierId = null;
            Long supplier_id = 0l;
//            System.out.println("isi ->" + request.getParameter("jsonfield"));
//            JSONArray array = (JSONArray) JSONSerializer.toJSON(request.getParameter("JSONFile"));
            JSONObject jsonObject = (JSONObject) JSONSerializer.toJSON(request.getParameter("jsonfield"));

            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment; filename=List_FieldService.xls");
            WritableWorkbook workbook = Workbook.createWorkbook(response.getOutputStream());
            WritableSheet sheet = workbook.createSheet("Sheet1", 0);

            HeaderFooter header = new HeaderFooter();
            header.getLeft().appendWorkbookName();
            header.getCentre().append("PT. Tanata Prima Jaya");
            header.getRight().appendWorkSheetName();
            sheet.getSettings().setHeader(header);

            HeaderFooter footer = new HeaderFooter();
            footer.getLeft().appendDate();

            footer.getCentre().append("Page ");
            footer.getCentre().appendPageNumber();
            footer.getCentre().append("/");
            footer.getCentre().appendTotalPages();

            footer.getRight().appendTime();
            sheet.getSettings().setFooter(footer);

            WritableFont cellFont = new WritableFont(WritableFont.TIMES, 16);
            cellFont.setColour(Colour.BLUE);

            WritableCellFormat cellFormat = new WritableCellFormat(cellFont);
            cellFormat.setBackground(Colour.GREY_25_PERCENT);
            cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);

            WritableFont cellFontRumus = new WritableFont(WritableFont.ARIAL, 12);
            cellFontRumus.setColour(Colour.BLACK);
            WritableCellFormat cellFormatRumus = new WritableCellFormat(cellFontRumus);

            sheet.addCell(new Label(2, 1, "Supplier :", cellFormatRumus));
            sheet.addCell(new Label(2, 2, "Suplier Code :", cellFormatRumus));
            sheet.addCell(new Label(2, 3, "Address :", cellFormatRumus));
//
//            sheet.addCell(new Label(5, 1, "MACHCO"));
//            sheet.addCell(new Label(5, 2, "True"));
//            Formula sum = new Formula(5, 2, ""));
//            sheet.addCell(sum);

            sheet.addCell(new Label(0, 5, "No", cellFormat));
            sheet.setColumnView(1, 25);
            sheet.addCell(new Label(1, 5, "Item Code", cellFormat));
            sheet.setColumnView(2, 40);
            sheet.addCell(new Label(2, 5, "Item Name", cellFormat));
            sheet.setColumnView(3, 20);
            sheet.addCell(new Label(3, 5, "Description", cellFormat));
            sheet.setColumnView(4, 20);
            sheet.addCell(new Label(4, 5, "Stock", cellFormat));
            sheet.setColumnView(5, 30);
            sheet.addCell(new Label(5, 5, "Price", cellFormat));
//            sheet.setColumnView(6, 30);
//            sheet.addCell(new Label(6, 0, "MINOR", cellFormat));
//            sheet.setColumnView(7, 30);
//            sheet.addCell(new Label(7, 0, "EXPLANATION", cellFormat));
//            sheet.setColumnView(8, 30);
//            sheet.addCell(new Label(8, 0, "Merchant Status", cellFormat));

            int rowNum = 6;

            EntitySuppliers dataSupplier = new EntitySuppliers();
            EntityProducts dataProducts = new EntityProducts();
            EntityStock dataStock = new EntityStock();
            supplierId = jsonObject.getString("supplier_id").trim().replaceAll("['\";:<>\\[\\],-]", "");
            System.out.println("isi supplierId ->" + supplierId);
            List<EntitySuppliers> dataSupplierList = entitySuppliersDao.findByStatusActive(Long.parseLong(supplierId));
            System.out.println("isi dataSupplierList.get(0).getSupplierId() ->" + dataSupplierList.get(0).getSupplierId());
            if (dataSupplierList.size() > 0) {
                List<EntityProducts> dataProductsList = entityProductsDao.listItemBySuplierId(dataSupplierList.get(0).getSupplierId());
                System.out.println("isi dataProductsList.get(0).getIdProduct() ->" + dataProductsList.get(0).getIdProduct());
                if (dataProductsList.size() > 0) {
                    for (int j = 0; j < dataProductsList.size(); j++) {

                        dataProducts = entityProductsDao.find(dataProductsList.get(0).getIdProduct());

//                      List<EntityStock> dataStockList = entityStockDao.findByIdProduct(dataProducts.getIdProduct());
                        dataStock = entityStockDao.find(dataProducts.getIdProduct());
                        sheet.addCell(new Label(3, 1,  EncryptionUtil.upperCaseFirst(dataSupplierList.get(0).getSupplierName())));
                        sheet.addCell(new Label(3, 2,  EncryptionUtil.upperCaseFirst(dataSupplierList.get(0).getSupplierCode())));
                        sheet.addCell(new Label(3, 3,  EncryptionUtil.upperCaseFirst(dataSupplierList.get(0).getAddress())));
                        sheet.addCell(new Label(0, rowNum, String.valueOf(rowNum)));
                        sheet.addCell(new Label(1, rowNum, dataProducts.getProductCode()));
                        sheet.addCell(new Label(2, rowNum, dataProducts.getProductName()));
                        sheet.addCell(new Label(3, rowNum, dataProducts.getDescription()));
                        sheet.addCell(new Label(4, rowNum, String.valueOf(dataStock.getStock())));
                        sheet.addCell(new Label(5, rowNum, String.valueOf(dataStock.getPrice())));

                        rowNum++;
                        System.out.println("rowNum --> \n" + rowNum);
                    }

                }
                workbook.write();
                workbook.close();
            }

//            out.close();
        } catch (WriteException ex) {
            Logger.getLogger(ExcelItemsSuplierServlet.class.getName()).log(Level.SEVERE, null, ex);
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
//        processRequest(request, response);
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
