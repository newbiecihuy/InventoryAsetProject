/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.controller;

import com.inventory.aset.entity.users.EntityUserRoles;
import com.inventory.aset.entity.users.EntityUserRolesPK;
import com.inventory.aset.entity.users.EntityUsers;
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
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import com.inventory.aset.facadebean.local.EntityUserRolesFacadeLocal;
import com.inventory.aset.facadebean.local.EntityUserRolesPKFacadeLocal;
import com.inventory.aset.facadebean.local.EntityUsersFacadeLocal;

/**
 *
 * @author newbiecihuy https://rudeigerc.github.io/posts/52455/
 *
 */
@WebServlet(name = "UserServlet", urlPatterns = {"/userServlet"})
public class UserServlet extends HttpServlet {

    public UserServlet() {
    }
    @EJB
    private EntityUsersFacadeLocal entityUsersFacadeLocal;

    @EJB
    private EntityUserRolesPKFacadeLocal entityUserRolesPKFacadeLocal;

    @EJB
    private EntityUserRolesFacadeLocal entityUserRolesFacadeLocal;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
            int recordsFiltered = entityUsersFacadeLocal.count();
            System.out.println("recordsFiltered " + recordsFiltered);
            Date d2 = sdf.parse(tgl);
            String relation = "";
            Date tanggalMasuk = null;
            Date tanggalGaransi = null;
            int numbering = 1;
            JSONArray jsonArray = new JSONArray();
            int no = Integer.parseInt(start) + 1;
            List<EntityUsers> usersList = entityUsersFacadeLocal.getAllUsers(Integer.parseInt(length), Integer.parseInt(start));
            if (Integer.parseInt(length) <= usersList.size()) {
                totalCount = usersList.size();
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

            if (usersList.size() > 0) {
                for (int i = 0; i < usersList.size(); i++) {
                    EntityUsers dataUsers = (EntityUsers) usersList.get(i);
                    JSONObject obj = new JSONObject();
//                   numbering =  i + 1;
                    if (dataUsers.isIsActive() == true) {

                        if (dataUsers.getUserId() == null) {
                            obj.put("id_user", "");
                            obj.put("no", "");
                            obj.put("action_user", "");
                        } else {
                            obj.put("id_user", dataUsers.getUserId());
                            obj.put("no", no++);
                            obj.put("action_user", "");
                        }

                        if (dataUsers.getUsername() == null) {
                            obj.put("user_name", "");
                        } else {
                            obj.put("user_name", EncryptionUtil.upperCaseFirst(dataUsers.getUsername()));
                        }

                        if (dataUsers.getGender() == null) {
                            obj.put("gender", "");
                        } else {
                            obj.put("gender", dataUsers.getGender());
                        }
                        if (dataUsers.getCreatedDate() == null) {
                            obj.put("register_date", "");
                        } else {
                            obj.put("register_date", sdf.format(dataUsers.getCreatedDate()) + "-" + dataUsers.getCreatedTime());
                        }

                        if (dataUsers.getEmail() == null) {
                            obj.put("email", "");
                        } else {
                            obj.put("email", dataUsers.getEmail());
                        }
                        if (dataUsers.getAddress() == null) {
                            obj.put("address", "");
                        } else {
                            obj.put("address", EncryptionUtil.upperCaseFirst(dataUsers.getAddress()));
                        }
                        if (dataUsers.getNomorIMEI() == null) {
                            obj.put("imei", "");
                        } else {
                            obj.put("imei", dataUsers.getNomorIMEI());
                        }
                        if (dataUsers.getPhone() == null) {
                            obj.put("phone", "");
                        } else {
                            obj.put("phone", dataUsers.getPhone());
                        }
                        if (dataUsers.getRoleName() == null) {
                            obj.put("role_name", "");
                        } else {
                            obj.put("role_name", EncryptionUtil.upperCaseFirst(dataUsers.getRoleName()));
                        }
                        if (dataUsers.getSesionID() == null) {
                            obj.put("jses_id", "--");
                        } else {
                            obj.put("jses_id", dataUsers.getSesionID());
                        }
                        if (dataUsers.getDateLasetLogin() == null) {
                            obj.put("last_login", "");
                        } else {
                            obj.put("last_login", dataUsers.getDateLasetLogin() + "-" + dataUsers.getTimeLastLogin());
                        }
                        if (dataUsers.getSesionID() == null) {
                            obj.put("getDevice_id_login", "");
                        } else {
                            obj.put("getDevice_id_login", EncryptionUtil.upperCaseFirst(dataUsers.getDevice_id_login()));
                        }

                        if (!dataUsers.isIsActive()) {
                            obj.put("status_user", "NON");
                        } else {
                            obj.put("status_user", "ACTIVE");
                        }

                    }
                    jsonArray.add(obj);
                }
            }

            JSONObject jsonobj = new JSONObject();
            jsonobj.put("draw", request.getParameter("draw"));
            jsonobj.put("totalpages", totalPages);
            jsonobj.put("length", length);
            jsonobj.put("recordsTotal", usersList.size());
            jsonobj.put("recordsFiltered", recordsFiltered);
            jsonobj.put("rows", jsonArray);
            out.println(jsonobj);

            out.close();
        } catch (ParseException ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat jamFormat = new SimpleDateFormat("HH:mm:ss");
            Date tgl = new Date();
            Date now = new Date();
            sdf.format(now);
            String time_now = jamFormat.format(tgl);
            String action_insert = "";
            String action_edit = "";
            String action_delete = "";
            long idUsers = 0;

            String userName = "";
            String userPass = "";
            String password = "";
            String passUser = EncryptionUtil.getPasswordString();
            String address = "";
            String nomorIMEI = "";
            String email = "";
            String action = "";
            String roleName = "";
            String gender = "";
            String phone = "";
            String isi_gender = "";

            EntityUsers dataUser = new EntityUsers();
            EntityUserRolesPK userRolesPK = new EntityUserRolesPK();
//            
            for (int i = 0; i < array.size(); i++) {
                JSONObject object = array.getJSONObject(0);
                object = array.getJSONObject(i);
                action_insert = object.getString("action_insert");
                action_edit = object.getString("action_edit").trim().replaceAll("['\":<>\\[\\],-]", "");
                action_delete = object.getString("action_delete").trim().replaceAll("['\":<>\\[\\],-]", "");

                if (!"".equals(object.getString("id_user")) && !object.getString("id_user").isEmpty()) {
                    idUsers = object.getLong("id_user");
                }
                System.out.println("idUsers =>" + idUsers);
                if (idUsers == 0l) {

                    if (!object.getString("userName").isEmpty()) {
                        userName = object.getString("userName").trim().replaceAll("['\":<>\\[\\],-]", "");
                    } else {
                        userName = "";
                    }
                    if (!object.getString("roleName").isEmpty()) {
                        roleName = object.getString("roleName").trim().replaceAll("['\":<>\\[\\],-]", "");
                    } else {
                        roleName = "";
                    }

                    if (!object.getString("address").isEmpty()) {
                        address = object.getString("address").trim().replaceAll("['\":<>\\[\\],-]", "");
                    } else {
                        address = "";
                    }
                    if (!object.getString("nomorIMEI").isEmpty()) {
                        nomorIMEI = object.getString("nomorIMEI").trim().replaceAll("['\":<>\\[\\],-]", "");
                    } else {
                        nomorIMEI = "";
                    }
                    if (!object.getString("email").isEmpty()) {
                        email = object.getString("email").trim().replaceAll("['\":<>\\[\\],-]", "");
                    } else {
                        email = "";
                    }
                    if (!object.getString("gender").isEmpty()) {
                        gender = object.getString("gender").trim().replaceAll("['\":<>\\[\\],-]", "");
                    } else {
                        gender = "";
                    }
                    if (!object.getString("phone").isEmpty()) {
                        phone = object.getString("phone").trim().replaceAll("['\":<>\\[\\],-]", "");
                    } else {
                        phone = "";
                    }

                    System.out.println("isi passUser" + passUser);
                    String isipassUser = passUser;
                    String isiPassword = EncryptionUtil.setSHA256(passUser);

                    System.out.println("isiPassword" + isiPassword);

//                    EntityUserRolesPK userRolesPK = new EntityUserRolesPK();
//                  EntityUserRoles dataUserRoles = new EntityUserRoles();
                    List<EntityUsers> cekUserName = entityUsersFacadeLocal.findByUsername(userName.toLowerCase());
                    System.out.println("isi cekUserName" + cekUserName);
                    if (cekUserName.size() > 0) {
                        code = "2";
                        return;
                    }
                    dataUser.setUsername(userName.toLowerCase());
                    dataUser.setEmail(email);
                    dataUser.setAddress(address.toLowerCase());
                    dataUser.setNomorIMEI(nomorIMEI);
                    dataUser.setPassword(isipassUser);
                    dataUser.setRoleName(roleName.toLowerCase());
                    dataUser.setPasswordEnc(isiPassword);
                    dataUser.setCreatedDate(now);
                    dataUser.setPhone(phone);
                    dataUser.setCreatedTime(time_now);
                    dataUser.setRoleName(roleName);
                    if (null != gender) {
                        switch (gender) {
                            case "m":
                                dataUser.setGender(EntityUsers.Gender.M);
                                break;
                            case "f":
                                dataUser.setGender(EntityUsers.Gender.F);
                        }
                    }
                    entityUsersFacadeLocal.createUser(dataUser);
                    System.out.println("Persist OK");

                    Long isi_id = entityUsersFacadeLocal.getIdUser();
                    System.out.println("isi_id OK" + isi_id);
                    userRolesPK.setId(isi_id);
                    userRolesPK.setRoleName(roleName.toLowerCase());
                    userRolesPK.setUserName(userName.toLowerCase());
                    EntityUserRoles userRole = entityUserRolesFacadeLocal.find(userRolesPK);
//                    EntityUserRoles userRole = (EntityUserRoles) em.find(EntityUserRoles.class, userRolesPK);
//                    entityUserRolesFacadeLocalPk.getUserRoles(userRolesPK);

                    if (userRole != null) {
                        System.out.println("User sudah terdaftar");
//
//                        if ((em != null) || (em.isOpen())) {
//                            em.close();
//                        }
                        code = "error";
                        return;
                    }
                    userRole = new EntityUserRoles();
                    try {
//                        em.getTransaction().begin();
                        userRole.setUser_roles_pk(userRolesPK);
                        entityUserRolesFacadeLocal.createUserRoles(userRole);

                        System.out.println("Persist OK");
//                        code = "1";
//                        em.getTransaction().commit();

                    } finally {
                    }

                    code = "1";
                    msg = "Has been Recorded";
                } else if (action_edit.equalsIgnoreCase("EDIT")) {
                    dataUser = entityUsersFacadeLocal.find(idUsers);
                    if (!object.getString("userName").isEmpty()) {
                        userName = object.getString("userName").trim().replaceAll("['\":<>\\[\\],-]", "");
                    } else {
                        userName = "";
                    }
                    if (!object.getString("roleName").isEmpty()) {
                        roleName = object.getString("roleName").trim().replaceAll("['\":<>\\[\\],-]", "");
                    } else {
                        roleName = "";
                    }

//                    if (!object.getString("password").isEmpty()) {
//                        password = object.getString("password").trim().replaceAll("['\":<>\\[\\],-]", "");
//                        String isipassUser = password;
//                        String isiPassword = EncryptionUtil.setSHA256(passUser);
//                        dataUser.setPassword(isipassUser);
//                        dataUser.setPasswordEnc(isiPassword);
//                    } else {
//                        password = "";
//                    }
                    if (!object.getString("address").isEmpty()) {
                        address = object.getString("address").trim().replaceAll("['\":<>\\[\\],-]", "");
                    } else {
                        address = "";
                    }
                    if (!object.getString("nomorIMEI").isEmpty()) {
                        nomorIMEI = object.getString("nomorIMEI").trim().replaceAll("['\":<>\\[\\],-]", "");
                    } else {
                        nomorIMEI = "";
                    }
                    if (!object.getString("email").isEmpty()) {
                        email = object.getString("email").trim().replaceAll("['\":<>\\[\\],-]", "");
                    } else {
                        email = "";
                    }
                    if (!object.getString("gender").isEmpty()) {
                        gender = object.getString("gender").trim().replaceAll("['\":<>\\[\\],-]", "");
                    } else {
                        gender = "";
                    }
                    if (!object.getString("phone").isEmpty()) {
                        phone = object.getString("phone").trim().replaceAll("['\":<>\\[\\],-]", "");
                    } else {
                        phone = "";
                    }
                    if (null != gender) {
                        switch (gender) {
                            case "m":
                                dataUser.setGender(EntityUsers.Gender.M);
                                break;
                            case "f":
                                dataUser.setGender(EntityUsers.Gender.F);
                        }
                    }
                    dataUser.setUpdatedDate(now);
                    dataUser.setUpdatedTime(time_now);
                    dataUser.setUsername(userName.toLowerCase());
                    dataUser.setEmail(email);
                    dataUser.setAddress(address.toLowerCase());
                    dataUser.setPhone(phone);
                    dataUser.setNomorIMEI(nomorIMEI);
                    entityUsersFacadeLocal.updateUser(dataUser);
                    Long isi_id = idUsers;
                    System.out.println("isi_id" + isi_id);
//                    userRolesPK.setId(isi_id);
//                    userRolesPK.setRoleName(roleName.toLowerCase());
//                    userRolesPK.setUserName(userName.toLowerCase());
//                    EntityUserRoles userRole = entityUserRolesFacadeLocal.find(userRolesPK);
////                    if (userRole != null) {
////                        System.out.println("User sudah terdaftar");
//////
//////                        if ((em != null) || (em.isOpen())) {
//////                            em.close();
//////                        }
////                        code = "error";
////                        return;
////                    }
//                    userRole = new EntityUserRoles();
//                    try {
////                        em.getTransaction().begin();
//                        userRole.setUser_roles_pk(userRolesPK);
//                        entityUserRolesFacadeLocal.createUserRoles(userRole);
//
//                        System.out.println("Merge OK");
////                        code = "1";
////                        em.getTransaction().commit();
//
//                    } finally {
//                    }

                    code = "3";
                    msg = "Has been Updated";
                } else if (action_delete.equalsIgnoreCase("DELETE")) {
                    dataUser = entityUsersFacadeLocal.find(idUsers);
                    dataUser.setStatusUsers(false);//delete
                    dataUser.setUpdatedDate(now);
                    dataUser.setUpdatedTime(time_now);
                    entityUsersFacadeLocal.deleteUser(dataUser);
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
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
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
