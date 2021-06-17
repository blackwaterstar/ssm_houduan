//package com.halcyon.controller;
//
//import com.google.zxing.BarcodeFormat;
//import com.google.zxing.EncodeHintType;
//import com.google.zxing.MultiFormatWriter;
//import com.google.zxing.client.j2se.MatrixToImageWriter;
//import com.google.zxing.common.BitMatrix;
//import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
//import com.halcyon.sdk.MyWXPayConfig;
//import com.halcyon.sdk.WXPay;
//import io.goeasy.GoEasy;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.servlet.ServletInputStream;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//@Controller
//@RequestMapping("wxpay")
//public class WXPaycontroller {
//
//    @RequestMapping("showpay")
//    public String showPay(){
//        return "MyPay";
//    }
//
//
//
//    //编写下单接口
//    @RequestMapping("doPay")
//    public void doPay(String orderId,String orderPrice,HttpServletResponse response){
////        用于生成订单编号的随机数
////        Date date = new Date();
////        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHssmm");
////        String orderIdPrefix = sdf.format(date);//创建订单编号的前缀
////        String pid = "2011";//商品id
////        String orderId1 = orderIdPrefix+pid;
//
//        //1.创建配置类对象
//        MyWXPayConfig config = new MyWXPayConfig();
//        //2.创建支付对象
//        WXPay wxpay = null;
//        try {
//            wxpay = new WXPay(config);
//            //3.将一些元数据存入到map集合中
//            Map<String, String> data = new HashMap<String, String>();
//            data.put("body", "今晚的小费");
//            data.put("out_trade_no", orderId);//订单编号
//            data.put("device_info", "");//设备信息
//            data.put("fee_type", "CNY");//货币单位： 分
//            data.put("total_fee", "1");// 1分
//            data.put("spbill_create_ip", "123.12.12.123");//对于这样123.12.12.123IP地址将会被记录
//            //******需要有一个回调的接口，获取此次微信支付的信息。
//            data.put("notify_url", "http://7vesrf.natappfree.cc/wxpay/notify_url");
//            data.put("trade_type", "NATIVE");  // 此处指定为扫码支付
//            data.put("product_id", "1");//商品ID
//
//            Map<String, String> resp = wxpay.unifiedOrder(data);
//            //二维码的链接   code_url
//
//            String code_url = resp.get("code_url");
//
//            //生成二维码
//
//            //二维码需要包含的文本内容
//            HashMap<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
//            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
//            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
//            hints.put(EncodeHintType.MARGIN, 2);
//            try {
//                BitMatrix bitMatrix = new MultiFormatWriter().encode(code_url, BarcodeFormat.QR_CODE, 200, 200, hints);
//                MatrixToImageWriter.writeToStream(bitMatrix, "PNG", response.getOutputStream());
//                System.out.println("创建二维码完成");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//    }
//
//
//
//
//
//    @RequestMapping("notify_url")
//    public void getNotifyURL(HttpServletResponse response, HttpServletRequest request) throws IOException {
//
//
//        //获得微信发送来的请求，从请求消息中获得数据。
//        ServletInputStream is = request.getInputStream();
//        byte[] b = new byte[1024];
//        int len=0;
//        StringBuffer sb = new StringBuffer();
//        while((len = is.read(b))!=-1){
//            sb.append( new String(b,0,len));
//        }
//
//        //  获得订单编号
//        String wxstr = sb.toString();
//        int count = "<out_trade_no><![CDATA[".length();
//        int begin = wxstr.indexOf("<out_trade_no><![CDATA[");
//        int end = wxstr.indexOf("]]></out_trade_no>");
//        String orderId = wxstr.substring(begin+count, end);
//
//        //返回一个标准格式的回信
//        response.getWriter().write("<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>");
//
//        GoEasy goEasy = new GoEasy("http://rest-hangzhou.goeasy.io", "BC-13372467cbde47cb8fa70538dbab4755");
//
//        //放一个订单号
//        //推送
//        goEasy.publish(orderId, "支付成功");
//
//    }
//
//
//}
