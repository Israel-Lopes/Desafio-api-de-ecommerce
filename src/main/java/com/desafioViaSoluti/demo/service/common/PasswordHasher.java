package com.desafioViaSoluti.demo.service.common;

import org.apache.commons.codec.digest.DigestUtils;

public class PasswordHasher {
    public static String hashPassword(String password) {
        return DigestUtils.sha256Hex(password);
    }
}
