package com.onenews.api;

/**
 * Created by yangweidong on 15/12/30.
 */
public class ApiUrl {
   private String APIKEY = "abcfe469f2ede2b495055162e97d8b82";

   public static final String CITYS = "http://apis.baidu.com/baidunuomi/openapi/cities";//糯米团单城市接口
   public static final String DISTRICTS = "http://apis.baidu.com/baidunuomi/openapi/districts";//糯米团单行政区接口
   public static final String CLASSIFY = "http://apis.baidu.com/baidunuomi/openapi/categories";//糯米团单分类信息
   public static final String SEARCHDEALS = "http://apis.baidu.com/baidunuomi/openapi/searchdeals";//根据查询条件获相应团单信息


   public static final String SEARCHSHOPS = "http://apis.baidu.com/baidunuomi/openapi/searchshops";//根据查询条件获取查询的商户信息


   public static final String SHOP_ORDER_LIST = "http://apis.baidu.com/baidunuomi/openapi/shopdeals";//糯米商户下团单列表


   public static final String SHOP_INFO = "http://apis.baidu.com/baidunuomi/openapi/shopinfo";//店铺信息

   public static final String DEALDETAIL = "http://apis.baidu.com/baidunuomi/openapi/dealdetail";
   public static final String SEARCH = "http://apis.baidu.com/image_search/search/search";//图片搜索

}
