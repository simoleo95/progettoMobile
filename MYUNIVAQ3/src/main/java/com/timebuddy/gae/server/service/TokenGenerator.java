package com.timebuddy.gae.server.service;

import java.security.SecureRandom;

public class TokenGenerator {

        protected static SecureRandom random = new SecureRandom();
        
        public synchronized String generateToken( String username ) {
                long longToken = Math.abs( random.nextLong() );
                String a = Long.toString( longToken, 16 );
                return ( username + ":" + a );
        }
}