///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.inventory.aset.controller;
//
//import com.inventory.aset.dao.local.EntityUserRolesLocal;
//import com.inventory.aset.dao.local.EntityUsersLocal;
//import com.inventory.aset.entity.users.EntityUsers;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.ejb.EJB;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import net.sf.json.JSONArray;
//import net.sf.json.JSONObject;
//import net.sf.json.JSONSerializer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
///**
// *
// * @author newbiecihuy
// */
//@Controller
////@RequestMapping(value = "/userController")
//public class UserController {
////     @RequestMapping(value = "/userController")
////    public ModelAndView hello(){
////        String myMessage = "Hallo ini dari kelas HelloJava";
////        ModelAndView mav = new ModelAndView();
////        mav.setViewName("hello");
////        mav.addObject("message", myMessage);
////        return mav;
////    }
////
//    @Autowired
//    public UserController() {
//
//    }
//
//    @EJB
//    private EntityUsersLocal usersDao;
//
//    @EJB
//    private EntityUserRolesLocal userRolesDao;
//
//    @RequestMapping(value = "/userController", method = RequestMethod.POST)
//    public @ResponseBody
//    String processRegistration(HttpServletRequest request, HttpServletResponse response) {
//        try {
//            response.setContentType("application/json");
//            response.setHeader("cache-control", "no-cache");
//            PrintWriter out = response.getWriter();
//            String code = "";
//
//            System.out.println(request.getParameter("JSONFile"));
//            JSONArray array = (JSONArray) JSONSerializer.toJSON(request.getParameter("JSONFile"));
//            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//            SimpleDateFormat jamFormat = new SimpleDateFormat("HH:mm:ss");
//            Date tgl = new Date();
//            Date now = new Date();
//            sdf.format(now);
//            String time_now = jamFormat.format(tgl);
//            String action_insert = "";
//            String action_edit = "";
//            String action_delete = "";
//            long idUsers = 0;
//            EntityUsers dataUser = new EntityUsers();
////            
//            for (int i = 0; i < array.size(); i++) {
//                JSONObject object = array.getJSONObject(0);
//                object = array.getJSONObject(i);
//                action_insert = object.getString("action_insert");
//                action_edit = object.getString("action_edit");
//                action_delete = object.getString("action_delete");
//
//                if ((object.containsKey("idUsers_edit")) && (object.getLong("idUsers_edit") > 0L)) {
//                    idUsers = object.getLong("idUsers_edit");
//                }
//                if (action_insert.equalsIgnoreCase("INSERT")) {
//
//                    usersDao.createUser(dataUser);
//                } else if (action_insert.equalsIgnoreCase("EDIT")) {
//                    dataUser = usersDao.find(idUsers);
//                    dataUser.setUpdatedDate(now);
//                    dataUser.setUpdatedTime(time_now);
//
//                    usersDao.updateUser(dataUser);
//                } else if (action_delete.equalsIgnoreCase("DELETE")) {
//                    dataUser = usersDao.find(idUsers);
//                    dataUser.setStatusUsers(false);//delete
//                    dataUser.setUpdatedDate(now);
//                    dataUser.setUpdatedTime(time_now);
//
//                    usersDao.deleteUser(dataUser);
//                }
//
//            }
//
//            JSONObject jsonobj = new JSONObject();
//            jsonobj.put("RC", code);
//            out.println(jsonobj.toString());
//            out.flush();
//
//            System.out.println(jsonobj.toString());
//        } catch (IOException ex) {
//            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return "Registration Success";
//    }
//}
