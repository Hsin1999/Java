package demo08;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

public class Code {
    public static void main(String[] args) throws Exception{
        String encode=URLEncoder.encode("你好hello!!", "UTF-8");
        System.out.println(encode);
        String decode= URLDecoder.decode(encode,"UTF-8");
        System.out.println(decode);
        byte[] input = new byte[] { (byte) 0xe4, (byte) 0xb8 };
        System.out.println(Arrays.toString(input));
//        Base64编码&解码，getUrlEncoder():针对URL的Base64编码
        String b64encoded = Base64.getUrlEncoder().encodeToString(input);
        System.out.println(b64encoded);
        byte[] decode1 = Base64.getDecoder().decode(b64encoded);
        System.out.println(Arrays.toString(decode1).hashCode());
//        MessageDigest.getInstance()获取摘要实例
        MessageDigest messageDigest=MessageDigest.getInstance("SHA-256");
        messageDigest.update("你好".getBytes(StandardCharsets.UTF_8));
        byte[] digest = messageDigest.digest();
//        public BigInteger(int signum, byte[] magnitude):signum:二进制最高符号位为1&-1（正数&负数）
        BigInteger bigInteger=new BigInteger(1,digest);
        System.out.println(bigInteger.toString(16));
//        HmacMD5加盐加密
        KeyGenerator keyGenerator=KeyGenerator.getInstance("HmacMD5");
        SecretKey secretKey = keyGenerator.generateKey();
        byte[] encoded = secretKey.getEncoded();
        System.out.println(Arrays.toString(encoded));
//        SecretKeySpec通过byte[]密钥验证加密结果
        SecretKey secretKey1=new SecretKeySpec(encoded,"HmacMD5");
        Mac mac=Mac.getInstance("HmacMD5");
        mac.init(secretKey1);
        mac.update("大家好！！".getBytes(StandardCharsets.UTF_8));
        byte[] result = mac.doFinal();
        System.out.println(new BigInteger(1,result).toString(16));
//        AES对称加密,SecretKey长度要求16byte，ENCRYPT_MODE：编码，DECRYPT_MODE：解码
        Cipher cipher=Cipher.getInstance("AES/ECB/PKCS5Padding");
        SecretKey secretKey2=new SecretKeySpec("1231231231231231".getBytes(StandardCharsets.UTF_8),"AES");
        cipher.init(Cipher.ENCRYPT_MODE,secretKey2);
        byte[] bytes = cipher.doFinal("大家好！！！".getBytes(StandardCharsets.UTF_8));
        System.out.println(Base64.getEncoder().encodeToString(bytes));
        cipher.init(Cipher.DECRYPT_MODE,secretKey2);
        byte[] bytes1 = cipher.doFinal(bytes);
        String s=new String(bytes1, StandardCharsets.UTF_8);
        System.out.println(s);

    }
}
