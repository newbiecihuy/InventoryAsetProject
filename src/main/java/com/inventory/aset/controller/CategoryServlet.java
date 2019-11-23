/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.controller;

import com.inventory.aset.entity.EntityCategories;
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

/**
 *
 * @author newbiecihuy
 */
@WebServlet(name = "CategoryServlet", urlPatterns = {"/categoryServlet"})
public class CategoryServlet extends HttpServlet {

    public CategoryServlet() {
    }
    @EJB
    private EntityCategoriesFacadeLocal entityCategoriesFacadeLocal;

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
//            out.println("<title>Servlet CategoryServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet CategoryServlet at " + request.getContextPath() + "</h1>");
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
            int recordsFiltered = entityCategoriesFacadeLocal.count();
            System.out.println("recordsFiltered " + recordsFiltered);
            Date d2 = sdf.parse(tgl);
            String relation = "";
            Date tanggalMasuk = null;
            Date tanggalGaransi = null;
            int numbering = 1;
            JSONArray jsonArray = new JSONArray();
            int no = Integer.parseInt(start) + 1;
            List<EntityCategories> categoriesList = null;
            if (searchString.isEmpty()) {
                categoriesList = entityCategoriesFacadeLocal.getAllCategories(Integer.parseInt(length), Integer.parseInt(start));
            } else {
                categoriesList = entityCategoriesFacadeLocal.searchCategories(searchString.toLowerCase(), Integer.parseInt(length), Integer.parseInt(start));
            }

            if (Integer.parseInt(length) <= categoriesList.size()) {
                totalCount = categoriesList.size();
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
            if (categoriesList.size() > 0) {
                for (int i = 0; i < categoriesList.size(); i++) {
                    EntityCategories dataCategories = (EntityCategories) categoriesList.get(i);
                    JSONObject obj = new JSONObject();
                    if (dataCategories.getCategoryId() == null) {
                        obj.put("category_id", "");
                        obj.put("no", "");
                        obj.put("action_category", "");
                    } else {
                        obj.put("category_id", dataCategories.getCategoryId());
                        obj.put("no", no++);
                        obj.put("action_category", "");
                    }
                    if (dataCategories.getCategoriesName() == null) {
                        obj.put("name_categories", "");
                    } else {
                        obj.put("name_categories", EncryptionUtil.upperCaseFirst(dataCategories.getCategoriesName()));
                    }
                    if (dataCategories.getCategoryDesc() == null) {
                        obj.put("category_desc", "");
                    } else {
                        obj.put("category_desc", EncryptionUtil.upperCaseFirst(dataCategories.getCategoryDesc()));
                    }
                    if (dataCategories.getCreatedDate() == null) {
                        obj.put("create_date", "");
                    } else {
                        obj.put("create_date", sdf.format(dataCategories.getCreatedDate()) + "-" + dataCategories.getCreatedTime());
                    }
                    if (dataCategories.getPic() == null) {
                        obj.put("pic", "");
                    } else {
                        obj.put("pic", EncryptionUtil.upperCaseFirst(dataCategories.getPic()));
                    }
                    if (!dataCategories.isIsDelete()) {
                        obj.put("is_delete", "0");
                    } else {
                        obj.put("is_delete", "1");
                    }
                    jsonArray.add(obj);
                }
            }

            JSONObject jsonobj = new JSONObject();
            jsonobj.put("draw", request.getParameter("draw"));
            jsonobj.put("totalpages", totalPages);
            jsonobj.put("length", length);
            jsonobj.put("recordsTotal", categoriesList.size());
            jsonobj.put("recordsFiltered", recordsFiltered);
            jsonobj.put("rows", jsonArray);
            out.println(jsonobj);

            out.close();
        } catch (ParseException ex) {
            Logger.getLogger(CategoryServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            String msg = null;
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
            long category_id = 0;

            String category_name, category_desc = null;
            EntityCategories dataCatageroies = new EntityCategories();

            for (int i = 0; i < array.size(); i++) {
                JSONObject object = array.getJSONObject(0);
                object = array.getJSONObject(i);
                action_insert = object.getString("action_insert_category");
                action_edit = object.getString("action_edit_category").trim().replaceAll("['\":<>\\[\\],-]", "");
                action_delete = object.getString("action_delete_category").trim().replaceAll("['\":<>\\[\\],-]", "");

                if (!"".equals(object.getString("category_id")) && !object.getString("category_id").isEmpty()) {
                    category_id = object.getLong("category_id");
                }
                if (category_id == 0l) {//action_insert.equalsIgnoreCase("INSERT")

                    if (!object.getString("category_name").isEmpty()) {
                        category_name = object.getString("category_name").trim().replaceAll("['\":<>\\[\\],-]", "");
                    } else {
                        category_name = "";
                    }
                    if (!object.getString("category_desc").isEmpty()) {
                        category_desc = object.getString("category_desc").trim().replaceAll("['\":<>\\[\\],-]", "");
                    } else {
                        category_desc = "";
                    }
                    List<EntityCategories> cekCategoryName = entityCategoriesFacadeLocal.findWithCategoriesName(category_name.toLowerCase());
                    System.out.println("isi cekCategoryName" + cekCategoryName);
                    if (cekCategoryName.size() > 0) {
                        code = "2";
                        return;
                    }
                    dataCatageroies.setCategoriesName(category_name.toLowerCase());
                    dataCatageroies.setCreatedDate(now);
                    dataCatageroies.setCreatedTime(time_now);
                    dataCatageroies.setPic(("PIC").toLowerCase());
                    dataCatageroies.setCategoryDesc(category_desc.toLowerCase());
                    entityCategoriesFacadeLocal.createCategories(dataCatageroies);
                    code = "1";
                } else if (action_edit.equalsIgnoreCase("EDIT")) {
                    dataCatageroies = entityCategoriesFacadeLocal.getCategories(category_id);

                    if (!object.getString("category_name").isEmpty()) {
                        category_name = object.getString("category_name").trim().replaceAll("['\":<>\\[\\],-]", "");
                    } else {
                        category_name = "";
                    }
                    if (!object.getString("category_desc").isEmpty()) {
                        category_desc = object.getString("category_desc").trim().replaceAll("['\":<>\\[\\],-]", "");
                    } else {
                        category_desc = "";
                    }

                    dataCatageroies.setCategoriesName(category_name.toLowerCase());
                    dataCatageroies.setUpdatedDate(now);
                    dataCatageroies.setUpdatedTime(time_now);
                    dataCatageroies.setPic(("PIC").toLowerCase());
                    dataCatageroies.setCategoryDesc(category_desc);
                    entityCategoriesFacadeLocal.updateCategories(dataCatageroies);
                    code = "1";
                } else if (action_delete.equalsIgnoreCase("DELETE")) {
                    dataCatageroies = entityCategoriesFacadeLocal.getCategories(category_id);
                    dataCatageroies.setUpdatedDate(now);
                    dataCatageroies.setUpdatedTime(time_now);
                    dataCatageroies.setPic("PIC");
                    dataCatageroies.setIsDelete(true);
                    entityCategoriesFacadeLocal.updateCategories(dataCatageroies);
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
            Logger.getLogger(CategoryServlet.class.getName()).log(Level.SEVERE, null, ex);
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
