/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.controller;

import com.inventory.aset.controller.SupplierServlet;
import com.inventory.aset.dao.local.EntityCategoriesDaoLocal;
import com.inventory.aset.entity.EntityCategories;
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
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

/**
 *
 * @author newbiecihuy
 */
@WebServlet(name = "GetCategoryServlet", urlPatterns = {"/getCategoryServlet"})
public class GetCategoryServlet extends HttpServlet {

    public GetCategoryServlet() {
    }
    @EJB
    EntityCategoriesDaoLocal entityCategoriesDao;

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

            String param = jsonObject.getString("categories_name");
            System.out.println("param: " + param);
            List<EntityCategories> dataCategories = entityCategoriesDao.findWithCategoriesName(param.toLowerCase());
            JSONArray jsonArray = new JSONArray();
            JSONObject obj = new JSONObject();
            if (dataCategories.size() > 0) {
                for (int i = 0; i < dataCategories.size(); i++) {
                    EntityCategories entityCategories = (EntityCategories) dataCategories.get(i);

                    if (entityCategories.getCategoryId() == null) {
                        obj.put("categori_id", "");
                    } else {
                        obj.put("categori_id", entityCategories.getCategoryId());
                    }
                    if (entityCategories.getCategoriesName() == null) {
                        obj.put("categories_name", "");
                    } else {
                        obj.put("categories_name", EncryptionUtil.upperCaseFirst(entityCategories.getCategoriesName()));
                    }

                    jsonArray.add(obj);
                }
            } else {
                obj.put("categori_id", "0");
                obj.put("categories_name", EncryptionUtil.upperCaseFirst(param));
                jsonArray.add(obj);
            }
            System.out.println("obj.toString(): " + obj.toString());
            out.print(obj.toString());
            out.close();

        } catch (NumberFormatException ex) {
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
