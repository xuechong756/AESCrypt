package com.hzy.aes;

import java.io.UnsupportedEncodingException;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;


/**
 * AES加密解密算法
 * 
 * @author long
 */
public class AESCrypt {
    // /** 算法/模式/填充 **/
    private static final String CipherMode = "AES/CBC/PKCS5Padding";

    private static final String DefaultPwd = "wedobest20171109";

    /** 
     * base 64 encode 
     * @param bytes 待编码的byte[] 
     * @return 编码后的base 64 code 
     */
	public static String base64Encode(byte[] bytes){  
        return Base64.encodeBase64String(bytes);  
    }  
      
    /** 
     * base 64 decode 
     * @param base64Code 待解码的base 64 code 
     * @return 解码后的byte[] 
     * @throws Exception 
     */
	public static byte[] base64Decode(String base64Code) throws Exception{
    	if(base64Code!= null && !base64Code.isEmpty())    	
    		return  Base64.decodeBase64(base64Code);
    	else
    		return null;
    }  
    
    // /** 创建密钥 **/
    private static SecretKeySpec createKey(String key) {
        byte[] data = null;
        if (key == null) {
            key = "";
        }
        StringBuffer sb = new StringBuffer(16);
        sb.append(key);
        while (sb.length() < 16) {
            sb.append("0");
        }
        if (sb.length() > 16) {
            sb.setLength(16);
        }

        try {
            data = sb.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return new SecretKeySpec(data, "AES");
    }

    private static IvParameterSpec createIV(String password) {
        byte[] data = null;
        if (password == null) {
            password = "";
        }
        StringBuffer sb = new StringBuffer(16);
        sb.append(password);
        while (sb.length() < 16) {
            sb.append("0");
        }
        if (sb.length() > 16) {
            sb.setLength(16);
        }

        try {
            data = sb.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return new IvParameterSpec(data);
    }

    // /** 加密字节数据 **/
    public static byte[] encrypt(byte[] content, String password, String iv) {
        try {
            SecretKeySpec key = createKey(password);
            Cipher cipher = Cipher.getInstance(CipherMode);
            cipher.init(Cipher.ENCRYPT_MODE, key, createIV(iv));
            byte[] result = cipher.doFinal(content);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
	public static String encrypt(String content) {
		return encrypt(content, DefaultPwd, null);
	}
    
    //默认iv为16个0
    public static String encrypt(String content, String password) {
    	 return encrypt(content, password, null);
    }

    // /** 加密(结果为16进制字符串) **/
    public static String encrypt(String content, String password, String iv) {
        byte[] data = null;
        try {
            data = content.getBytes("UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        data = encrypt(data, password, iv);
        //System.out.println(Md5Crypt.toHexString(data));
        //String result = Crypt.toHexString(data);
        String result = base64Encode(data);
        return result;
    }

    // /** 解密字节数组 **/
    public static byte[] decrypt(byte[] content, String password, String iv) {
        try {
            SecretKeySpec key = createKey(password);
            Cipher cipher = Cipher.getInstance(CipherMode);
            cipher.init(Cipher.DECRYPT_MODE, key, createIV(iv));
            byte[] result = cipher.doFinal(content);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // /** 解密 **/
    public static String decrypt(String content, String password, String iv) {
        byte[] data = null;
        try {
            //data = Crypt.hexStringToByte(content);
        	data = base64Decode(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        data = decrypt(data, password, iv);
        if (data == null)
            return null;
        String result = null;
        try {
            result = new String(data, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public static String decrypt(String content)
    {
    	return decrypt(content, DefaultPwd, null);
    }
    
    public static String decrypt(String content, String pwd)
    {
    	return decrypt(content, pwd, null);
    }
    
//    public static void main(String[] args) throws Exception{
//    	String base = "ads*Vx&158";
//    	String en = encrypt(base);
//    	System.out.println(en);
//    	String de = decrypt(en);
//    	System.out.println(de);
//    	
//    }
    
}
