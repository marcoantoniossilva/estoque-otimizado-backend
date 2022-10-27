package io.github.marcoantoniossilva.estoqueotimizadobackend.domain.service.util;

import org.apache.commons.codec.digest.DigestUtils;

public class HashUtil {

  public static String getSecureHash(String text) {
    return DigestUtils.sha256Hex(text);
  }

}