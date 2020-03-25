/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.controller.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.impl.crypto.MacProvider;
import java.security.SignatureException;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.TemporalAmount;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.SecretKey;

/**
 *
 * @author https://github.com/Kzis/poc-jwt-authentication-jsp-servelet
 */
public class MainTest {

    final static String CLAIM_ROLE = "role";

    final static SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS256;
    final static SecretKey SECRET_KEY = MacProvider.generateKey(SIGNATURE_ALGORITHM);
    final static TemporalAmount TOKEN_VALIDITY = Duration.ofHours(4L);

    public static void main(String[] args) throws ExpiredJwtException, UnsupportedJwtException {

        String token = createToken("test", "admin");

        System.out.println("Token : " + token);
        System.out.println("Token False : " + token + "xx");

        Jws<Claims> x = null;
        try {
            x = parseToken(token);
        } catch (MalformedJwtException ex) {
            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SignatureException ex) {
            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Validate True : " + x.getSignature());

        Jws<Claims> x2 = null;
        try {
            x2 = parseToken(token + "xx");
        } catch (MalformedJwtException ex) {
            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SignatureException ex) {
            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Validate False : " + x2.getSignature());

    }

    public static String createToken(final String subject, final String role) {
        final Instant now = Instant.now();
        final Date expiryDate = Date.from(now.plus(TOKEN_VALIDITY));
        return Jwts.builder()
                .setSubject(subject)
                .claim(CLAIM_ROLE, role)
                .setExpiration(expiryDate)
                .setIssuedAt(Date.from(now))
                .signWith(SIGNATURE_ALGORITHM, SECRET_KEY)
                .compact();
    }

    public static Jws<Claims> parseToken(final String compactToken)
            throws ExpiredJwtException,
            UnsupportedJwtException,
            MalformedJwtException,
            SignatureException,
            IllegalArgumentException {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(compactToken);
    }

}
