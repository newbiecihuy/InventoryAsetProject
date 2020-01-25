/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.controller.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.cert.CertificateException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author newbiecihuy
 */
public class CreateLog {
  public CreateLog() {

    }

    public static void createText(Object object, String namaFile) {
//        SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd_MM_yyyy");
        DateTimeFormatter outputDateFormat = DateTimeFormatter.ofPattern("dd_MM_yyyy");
        DateTimeFormatter lineDateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime line = LocalDateTime.now();
        String path = "/opt/bpr_kanti_log";
        String isifile = path + namaFile + "_" + outputDateFormat.format(now) + ".log";
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(object);

            File f = new File(isifile);
            PrintWriter writer = null;
//            BufferedWriter bw = null;
            writer = new PrintWriter(new FileWriter(f, true));
//             bw = new BufferedWriter(new FileWriter(f, true));
            if (f.exists()) {
//                bw = new BufferedWriter(new FileWriter(f, true));

                writer.println("#" + lineDateFormat.format(line) + "::" + json);
                System.out.println("JSON1 = " + json);
            } else {
//                bw = new BufferedWriter(new FileWriter(f, true));
                writer.println("#" + lineDateFormat.format(line) + "::" + json);
                System.out.println("JSON2 = " + json);
            }

//            CertificateFactory cf = CertificateFactory.getInstance("X.509");
//            Certificate cert = cf.generateCertificate(is);
//            writer.println("The first line" + nilai);
            writer.close();
//            exit(EXIT_CODE_PARSE_ERR);
        } catch (JsonProcessingException | FileNotFoundException | UnsupportedEncodingException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(CreateLog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}