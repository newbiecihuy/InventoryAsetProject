/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.controller;

import com.inventory.aset.entity.EntityProtocol;
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
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import com.inventory.aset.facadebean.local.EntityProtocolFacadeLocal;

/**
 *
 * @author newbiecihuy
 */
@WebServlet(name = "ProtocolServlet", urlPatterns = {"/protocolServlet"})
public class ProtocolServlet extends HttpServlet {
    
    public ProtocolServlet() {
        
    }
    @EJB
    EntityProtocolFacadeLocal entityProtocolDao;

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
            String searchString = request.getParameter("searchString");
            System.out.println("isi searchField: " + searchField);
            System.out.println("isi searchString: " + searchString);
            String status = request.getParameter("status");
            SimpleDateFormat sdfMonthPO = new SimpleDateFormat("MM");
            SimpleDateFormat sdfMonthCompare = new SimpleDateFormat("MM");
            SimpleDateFormat sdfYearNoPO = new SimpleDateFormat("yyyy");
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
            
            System.out.println("length" + length);
//            System.out.println("page" + page);
            int totalPages = 0;
            int totalCount = 0;
            Date d2 = sdf.parse(tgl);
            String relation = "";
            Date tanggalMasuk = null;
            Date tanggalGaransi = null;
            
            JSONArray jsonArray = new JSONArray();
            List<EntityProtocol> protocolList = entityProtocolDao.getAllProtocol(Integer.parseInt(length));
            if (Integer.parseInt(length) <= protocolList.size()) {
                totalCount = protocolList.size();
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
            if (protocolList.size() > 0) {
                for (int i = 0; i < protocolList.size(); i++) {
                    System.out.println("protocolList.size() > 0");
                    
                    JSONObject obj = new JSONObject();
                    EntityProtocol db = (EntityProtocol) protocolList.get(i);
                    
                    if (db.getIdProtocol() == null) {
                        obj.put("idProtocol", "");
                        obj.put("no_protocol", "");
                        obj.put("action_email", "");
                    } else {
                        obj.put("idProtocol", db.getIdProtocol());
                        obj.put("no_protocol", i + 1);
                        obj.put("action_email", "");
                    }
                    if (db.getSmtpHost() == null) {
                        obj.put("smtpHost", "");
                    } else {
                        obj.put("smtpHost", db.getSmtpHost());
                    }
                    if (db.getSmtpSocketFactoryPort() == null) {
                        obj.put("smtpSocketFactoryPort", "");
                    } else {
                        obj.put("smtpSocketFactoryPort", db.getSmtpSocketFactoryPort());
                    }
                    if (db.getSmtpSocketFactoryClass() == null) {
                        obj.put("smtpSocketFactoryClass", "");
                    } else {
                        obj.put("smtpSocketFactoryClass", db.getSmtpSocketFactoryClass());
                    }
                    if (db.getSmtpPort() == null) {
                        obj.put("smtpPort", "");
                    } else {
                        obj.put("smtpPort", db.getSmtpPort());
                    }
                    if (db.getEmail() == null) {
                        obj.put("email", "");
                    } else {
                        obj.put("email", db.getEmail());
                    }
                    if (db.getEmailPass() == null) {
                        obj.put("email_pass", "");
                    } else {
                        obj.put("email_pass", db.getEmailPass());
                    }
                    if (!db.isIsActive()) {
                        obj.put("isActive", "NON");
                    } else {
                        obj.put("isActive", "ACTIVE");
                    }
                    jsonArray.add(obj);
                }
            }
            JSONObject jsonobj = new JSONObject();
            jsonobj.put("totalpages", totalPages);
            jsonobj.put("length", page);
            jsonobj.put("recordsTotal", protocolList.size());
            jsonobj.put("recordsFiltered", protocolList.size());
            jsonobj.put("rows", jsonArray);
            out.println(jsonobj);
            
            out.close();
        } catch (ParseException ex) {
            Logger.getLogger(ProtocolServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        PrintWriter out = null;
        response.setContentType("application/json; charset=UTF-8");
        out = response.getWriter();
//        EntityManager em = null;
        String code = "0";
        try {
            System.out.println("METHON POST IN");
            JSONArray jsonArray = (JSONArray) JSONSerializer.toJSON(request.getParameter("JSONFile"));
            
            System.out.println("isi jsonArray" + jsonArray);

//            JPAResourceBean jpaResourceBean = new JPAResourceBean();
//            EntityManagerFactory emf = jpaResourceBean.getEMF();
//            System.out.println(emf.isOpen());
//            em = emf.createEntityManager();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
            Date now = new Date();
            String strDate = sdf.format(now);
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            Date tgl = new Date();
            
            String smtpHost = "";
            String smtpSocketFactoryPort = "";
            String smtpSocketFactoryClass = "";
            String smtpPort = "";
            String email_form_config = "";
            String pass_email_config = "";
            String email_config_val = "";
            Long id_email_config = Long.valueOf(0L);
            String isActive = "";
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                
                EntityProtocol emailProtocol = new EntityProtocol();
                email_config_val = jsonObject.getString("email_config_val");
                
                if (email_config_val.equalsIgnoreCase("INPUT")) {
                    System.out.println("INPUT");
                    smtpHost = jsonObject.getString("smtpHost");
                    smtpSocketFactoryPort = jsonObject.getString("smtpSocketFactoryPort");
                    smtpSocketFactoryClass = jsonObject.getString("smtpSocketFactoryClass");
                    smtpPort = jsonObject.getString("smtpPort");
                    email_form_config = jsonObject.getString("email_form_config");
                    pass_email_config = jsonObject.getString("pass_email_config");
                    
                    emailProtocol.setEmail(email_form_config);
                    emailProtocol.setEmailPass(pass_email_config);
                    emailProtocol.setSmtpHost(smtpHost);
                    emailProtocol.setSmtpSocketFactoryPort(smtpSocketFactoryPort);
                    emailProtocol.setSmtpSocketFactoryClass(smtpSocketFactoryClass);
                    emailProtocol.setSmtpPort(smtpPort);
                    emailProtocol.setIsActive(true);
                    try {
                        entityProtocolDao.createProtocol(emailProtocol);
                    } finally {
                        code = "1";
                    }
                } else if (email_config_val.equalsIgnoreCase("EDIT")) {
                    System.out.println("EDIT");
                    id_email_config = Long.parseLong(jsonObject.getString("id_email_config"));
                    smtpHost = jsonObject.getString("smtpHost");
                    smtpSocketFactoryPort = jsonObject.getString("smtpSocketFactoryPort");
                    smtpSocketFactoryClass = jsonObject.getString("smtpSocketFactoryClass");
                    smtpPort = jsonObject.getString("smtpPort");
                    email_form_config = jsonObject.getString("email_form_config");
                    pass_email_config = jsonObject.getString("pass_email_config");
                    
                    EntityProtocol editEmailProtocol = entityProtocolDao.getProtocol(id_email_config);
                    
                    editEmailProtocol.setEmail(email_form_config);
                    editEmailProtocol.setEmailPass(pass_email_config);
                    editEmailProtocol.setSmtpHost(smtpHost);
                    editEmailProtocol.setSmtpSocketFactoryPort(smtpSocketFactoryPort);
                    editEmailProtocol.setSmtpSocketFactoryClass(smtpSocketFactoryClass);
                    editEmailProtocol.setSmtpPort(smtpPort);
                    try {
                        entityProtocolDao.updateProtocol(emailProtocol);
                    } finally {
                        code = "1xp";
                    }
                } else if (email_config_val.equalsIgnoreCase("ENABLE")) {
                    System.out.println("enable/disable");
                    id_email_config = Long.parseLong(jsonObject.getString("id_email_config"));
                    EntityProtocol enableProtocol = entityProtocolDao.getProtocol(id_email_config);//(EntityProtocol) em.find(EntityProtocol.class, id_email_config);
                    isActive = jsonObject.getString("isActive");
                    
                    if (isActive.equalsIgnoreCase("ACTIVE")) {
                        enableProtocol.setIsActive(false);
                    } else {
                        enableProtocol.setIsActive(true);
                    }
                    try {
                        entityProtocolDao.updateProtocol(emailProtocol);
                    } finally {
                        code = "1xpl";
                    }
                } else if (email_config_val.equalsIgnoreCase("Delete")) {
                    System.out.println("Delete");
                    id_email_config = Long.parseLong(jsonObject.getString("id_email_config"));
//                    EntityProtocol deleteEmailProtocol = (EntityProtocol) em.find(EntityProtocol.class, id_email_config);
                    try {
                        entityProtocolDao.updateProtocol(emailProtocol);
                    } finally {
                        code = "1xpld";
                    }
                }
            }
//            em.close();
            JSONObject jsonobj = new JSONObject();
            
            jsonobj.put("RC", code);
            out.println(jsonobj.toString());
            out.close();
            System.out.println(jsonobj.toString());
        } catch (NumberFormatException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        } finally {
//            if ((em != null) && (em.isOpen())) {
//                em.close();
//            }
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
