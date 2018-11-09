package com.tyning.nothing.util.test;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class UtilTest {

    @Test
    public void testSerializable(){
//        String projectIdstr = "2";
//        System.out.println(projectIdstr.replaceAll("1","1"));
//        String filePath = "//fdsafdsa//fasfdsa/fdsafdsa";
//        if (filePath.contains("//")){
//            filePath = filePath.replaceAll("//","/");
//        System.out.println(filePath);
       for (int i = 0 ;i<100000000;i++){
           System.out.println( new BigDecimal("10.1000").setScale(2, RoundingMode.HALF_UP).toString());
       }
    }



        public static String WEBHOOK_TOKEN = "https://oapi.dingtalk.com/robot/send?access_token=d276255b5b9cb32aa58acaf5cf3bccc0b5158e78d0698ad21a01bcd417564f31";

        public static void main(String args[]) throws Exception{

            HttpClient httpclient = HttpClients.createDefault();

            HttpPost httppost = new HttpPost(WEBHOOK_TOKEN);
            httppost.addHeader("Content-Type", "application/json; charset=utf-8");

            String textMsg = "{ \"msgtype\": \"text\", \"text\": {\"content\": \"为啥啊。\"}}";
            StringEntity se = new StringEntity(textMsg, "utf-8");
            httppost.setEntity(se);

            HttpResponse response = httpclient.execute(httppost);
            if (response.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
                String result= EntityUtils.toString(response.getEntity(), "utf-8");
                System.out.println(result);
            }
        }

}
