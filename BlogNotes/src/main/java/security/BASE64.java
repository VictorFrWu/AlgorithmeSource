package security;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
public class BASE64 {
    /**  
     * BASE64解密  
     *   
     * @param key  
     * @return  
     * @throws Exception  
     */  
    public static byte[] decryptBASE64(String key) throws Exception {   
        return (new BASE64Decoder()).decodeBuffer(key);   
    }   

    /**  
     * BASE64加密  
     *   
     * @param key  
     * @return  
     * @throws Exception  
     */  
    public static String encryptBASE64(byte[] key) throws Exception {   
        return (new BASE64Encoder()).encodeBuffer(key);   
    }  

    public static void main(String[] args) {

     String  str="12345678";

        try {
        String  result1= BASE64.encryptBASE64(str.getBytes());
         System.out.println("result1=====加密数据=========="+result1);

         byte  result2[]= BASE64.decryptBASE64(result1);
         String  str2=new String(result2);
         System.out.println("str2========解密数据========"+str2);
    } catch (Exception e) {
        e.printStackTrace();
    }

    }

}