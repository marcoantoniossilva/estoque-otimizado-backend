package io.github.marcoantoniossilva.estoqueotimizadobackend.common.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class HashUtils {

  public static String getSecureHash(String text) {
    return DigestUtils.sha256Hex(text);
  }

}