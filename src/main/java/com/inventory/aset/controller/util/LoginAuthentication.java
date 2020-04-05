/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.controller.util;

import com.inventory.aset.controller.ItemServlet;
import com.inventory.aset.model.users.EntityUsers;
import com.inventory.aset.facadebean.local.EntityCategoriesFacadeLocal;
import com.inventory.aset.facadebean.local.EntityUsersFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *
 * @author newbiecihuy
 */
@WebServlet(name = "LoginAuthentication", urlPatterns = {"/loginAuthentication"})
public class LoginAuthentication extends HttpServlet {

    public LoginAuthentication() {
    }
    @EJB
    private EntityUsersFacadeLocal entityUsersFacadeLocal;

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
//            out.println("<title>Servlet LoginAuthentication</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet LoginAuthentication at " + request.getContextPath() + "</h1>");
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
        PrintWriter print = response.getWriter();

//        EntityManager em = null;
        System.out.println("Get Method POST IN");
        HttpSession session = request.getSession();
        try {
//            JPAResourceBean jpaResourceBean = new JPAResourceBean();
//            EntityManagerFactory emf = jpaResourceBean.getEMF();
//            em = emf.createEntityManager();
            String username = request.getParameter("j_username").toLowerCase();
            String password = EncryptionUtil.setMD5(request.getParameter("j_password"));
            System.out.println("isi password :" + password);
            String url = "j_security_check?j_username=" + username + "&j_password=" + password;
            System.out.println("isi username" + username + "isi j_password" + password);
            String redirectUrl = response.encodeRedirectURL(url);
            String isi_pasword = EncryptionUtil.setSHA256(password);
            List<EntityUsers> cekUser = entityUsersFacadeLocal.checkUsers(username, isi_pasword);
//            String queryStmntImei = "SELECT us.id FROM EntityUsers us WHERE us.userPass =\"" + isi_pasword + "\" AND "
//                    + " us.userName =\"" + username + "\" AND "
//                    + " us.isActive =\"" + "1" + "\" ";
//            Query queryUser = em.createQuery(queryStmntImei);
//            System.out.println(cekUser);
//            List<EntityUsers> cekUser = queryUser.getResultList();
            System.out.println("isi cekUser" + cekUser);
            if ((cekUser == null) || (cekUser.isEmpty())) {
                print.println("User0:");
                response.sendRedirect("loginError.jsp");
                System.out.println("User0" + cekUser);
                return;
            } else {

                JSONArray jsonArray = new JSONArray();
                for (int i = 0; i < cekUser.size(); i++) {
                    JSONObject jsonObjectUsers = new JSONObject();
                    EntityUsers dataUsers = cekUser.get(i);
                    jsonObjectUsers.put("idUser", dataUsers.getUserId());
                    jsonObjectUsers.put("username", EncryptionUtil.upperCaseFirst(dataUsers.getUsername()));
                    jsonObjectUsers.put("userRole", dataUsers.getRoleName());
//                        HttpSession session = request.getSession();
                    session.setAttribute("idUser", dataUsers.getUserId());
                    session.setAttribute("username", dataUsers.getUsername());
                    session.setAttribute("userRole", dataUsers.getRoleName());
                    jsonArray.add(jsonObjectUsers);
                }
//                em.close();
//                response.sendRedirect("index.jsp");
                print.print(jsonArray);
                response.sendRedirect(redirectUrl);

            }

        } catch (IOException ex) {
            Logger.getLogger(LoginAuthentication.class.getName()).log(Level.SEVERE, null, ex);
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
