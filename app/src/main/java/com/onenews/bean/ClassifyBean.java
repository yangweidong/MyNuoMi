package com.onenews.bean;

import java.util.List;

/**
 * Created by yangweidong on 16/1/4.
 */
public class ClassifyBean {

    @Override
    public String toString() {
        return "ClassifyBean{" +
                "errno=" + errno +
                ", msg='" + msg + '\'' +
                ", categories=" + categories +
                '}';
    }

    /**
     * errno : 0
     * msg : success
     * categories : [{"cat_id":316,"cat_name":"生活服务","subcategories":[{"subcat_name":"快照冲印","subcat_id":319},{"subcat_name":"宠物服务","subcat_id":367},{"subcat_name":"教育培训","subcat_id":375},{"subcat_name":"儿童摄影","subcat_id":428},{"subcat_name":"口腔","subcat_id":459},{"subcat_name":"其他生活服务","subcat_id":540},{"subcat_name":"婚纱摄影","subcat_id":565},{"subcat_name":"个性写真","subcat_id":614},{"subcat_name":"加油站","subcat_id":616},{"subcat_name":"体检","subcat_id":670},{"subcat_name":"亲子","subcat_id":702},{"subcat_name":"配镜","subcat_id":703},{"subcat_name":"服装定制","subcat_id":704},{"subcat_name":"洗衣店","subcat_id":705},{"subcat_name":"汽车养护","subcat_id":706},{"subcat_name":"婚庆服务","subcat_id":709},{"subcat_name":"本地购物","subcat_id":875},{"subcat_name":"证件照","subcat_id":923},{"subcat_name":"照片冲印","subcat_id":924},{"subcat_name":"家政服务","subcat_id":927},{"subcat_name":"驾校/陪练","subcat_id":928},{"subcat_name":"租车","subcat_id":929},{"subcat_name":"鲜花","subcat_id":930},{"subcat_name":"充值服务","subcat_id":931},{"subcat_name":"送水/送奶","subcat_id":932},{"subcat_name":"丽人","subcat_id":956},{"subcat_name":"药店","subcat_id":2000},{"subcat_name":"药品","subcat_id":2001},{"subcat_name":"保健品","subcat_id":2002},{"subcat_name":"医疗器械","subcat_id":2003},{"subcat_name":"药品相关","subcat_id":2004}]},{"cat_id":320,"cat_name":"休闲娱乐","subcategories":[{"subcat_name":"温泉洗浴","subcat_id":338},{"subcat_name":"KTV","subcat_id":341},{"subcat_name":"足疗按摩","subcat_id":347},{"subcat_name":"文化艺术","subcat_id":349},{"subcat_name":"其他娱乐","subcat_id":528},{"subcat_name":"景点郊游","subcat_id":688},{"subcat_name":"采摘","subcat_id":700},{"subcat_name":"4D/5D电影","subcat_id":891},{"subcat_name":"桌游","subcat_id":895},{"subcat_name":"电玩/游戏币","subcat_id":896},{"subcat_name":"DIY手工","subcat_id":897},{"subcat_name":"密室逃脱","subcat_id":898},{"subcat_name":"真人CS","subcat_id":899},{"subcat_name":"卡丁车","subcat_id":900},{"subcat_name":"其他娱乐活动","subcat_id":901},{"subcat_name":"游泳","subcat_id":911},{"subcat_name":"滑雪/滑冰","subcat_id":914},{"subcat_name":"其他养生保健","subcat_id":919},{"subcat_name":"游乐园/水上乐园","subcat_id":920},{"subcat_name":"录音棚","subcat_id":922},{"subcat_name":"运动健身","subcat_id":952},{"subcat_name":"演出/展览","subcat_id":953}]},{"cat_id":323,"cat_name":"其他","subcategories":[{"subcat_name":"电影","subcat_id":345},{"subcat_name":"0元","subcat_id":682},{"subcat_name":"抽奖","subcat_id":683},{"subcat_name":"其他","subcat_id":684},{"subcat_name":"丽人","subcat_id":955}]},{"cat_id":326,"cat_name":"美食","subcategories":[{"subcat_name":"其他美食","subcat_id":327},{"subcat_name":"火锅","subcat_id":364},{"subcat_name":"小吃快餐","subcat_id":380},{"subcat_name":"粤菜","subcat_id":388},{"subcat_name":"日本料理","subcat_id":389},{"subcat_name":"东南亚菜","subcat_id":390},{"subcat_name":"西餐","subcat_id":391},{"subcat_name":"自助餐","subcat_id":392},{"subcat_name":"川菜","subcat_id":393},{"subcat_name":"江浙菜","subcat_id":424},{"subcat_name":"海鲜","subcat_id":439},{"subcat_name":"北京菜","subcat_id":450},{"subcat_name":"新疆/清真菜","subcat_id":451},{"subcat_name":"湖北菜","subcat_id":454},{"subcat_name":"烧烤/烤肉","subcat_id":460},{"subcat_name":"湘菜","subcat_id":488},{"subcat_name":"韩国料理","subcat_id":501},{"subcat_name":"东北菜","subcat_id":504},{"subcat_name":"云南菜","subcat_id":509},{"subcat_name":"鲁菜","subcat_id":652},{"subcat_name":"西北菜","subcat_id":653},{"subcat_name":"贵州菜","subcat_id":654},{"subcat_name":"素食","subcat_id":655},{"subcat_name":"干锅/香锅","subcat_id":690},{"subcat_name":"聚会宴请","subcat_id":691},{"subcat_name":"创意菜/私房菜","subcat_id":692},{"subcat_name":"江西菜","subcat_id":693},{"subcat_name":"内蒙菜","subcat_id":694},{"subcat_name":"客家菜","subcat_id":695},{"subcat_name":"台湾菜","subcat_id":696},{"subcat_name":"天津菜","subcat_id":697},{"subcat_name":"徽菜","subcat_id":874},{"subcat_name":"中东菜","subcat_id":876},{"subcat_name":"披萨","subcat_id":877},{"subcat_name":"烤鱼","subcat_id":878},{"subcat_name":"辣味美食","subcat_id":879},{"subcat_name":"甜点饮品","subcat_id":880},{"subcat_name":"蛋糕","subcat_id":881},{"subcat_name":"其他异国餐饮","subcat_id":882},{"subcat_name":"烤鸭","subcat_id":883},{"subcat_name":"麻辣烫","subcat_id":884},{"subcat_name":"山西菜","subcat_id":885},{"subcat_name":"海南菜","subcat_id":886},{"subcat_name":"闽菜","subcat_id":887},{"subcat_name":"河南菜","subcat_id":888},{"subcat_name":"河北菜","subcat_id":889},{"subcat_name":"其他中餐","subcat_id":890},{"subcat_name":"咖啡厅/酒吧/茶室","subcat_id":954},{"subcat_name":"全部中餐","subcat_id":962}]},{"cat_id":330,"cat_name":"网购","subcategories":[{"subcat_name":"母婴玩具","subcat_id":351},{"subcat_name":"服装/内衣","subcat_id":353},{"subcat_name":"手表饰品","subcat_id":354},{"subcat_name":"运动户外","subcat_id":355},{"subcat_name":"个护化妆","subcat_id":356},{"subcat_name":"家居家纺","subcat_id":357},{"subcat_name":"图书杂志","subcat_id":360},{"subcat_name":"数码家电","subcat_id":397},{"subcat_name":"鞋/箱包","subcat_id":403},{"subcat_name":"其他","subcat_id":544},{"subcat_name":"食品保健","subcat_id":675}]},{"cat_id":377,"cat_name":"酒店旅游","subcategories":[{"subcat_name":"酒店","subcat_id":642},{"subcat_name":"旅游","subcat_id":708},{"subcat_name":"经济型酒店","subcat_id":934},{"subcat_name":"豪华酒店","subcat_id":935},{"subcat_name":"公寓式酒店","subcat_id":936},{"subcat_name":"商务酒店","subcat_id":937},{"subcat_name":"快捷酒店","subcat_id":938},{"subcat_name":"主题酒店","subcat_id":939},{"subcat_name":"青年旅舍","subcat_id":940},{"subcat_name":"度假酒店","subcat_id":941},{"subcat_name":"农家院","subcat_id":942},{"subcat_name":"钟点房","subcat_id":943},{"subcat_name":"五星","subcat_id":944},{"subcat_name":"四星","subcat_id":945},{"subcat_name":"三星","subcat_id":946},{"subcat_name":"国内游","subcat_id":947},{"subcat_name":"境外游","subcat_id":948}]},{"cat_id":963,"cat_name":"上门服务","subcategories":[{"subcat_name":"美甲","subcat_id":964},{"subcat_name":"美足","subcat_id":965},{"subcat_name":"美睫","subcat_id":966},{"subcat_name":"洗衣","subcat_id":967},{"subcat_name":"洗车","subcat_id":968},{"subcat_name":"手机维修","subcat_id":983}]},{"cat_id":970,"cat_name":"演出赛事","subcategories":[{"subcat_name":"演唱会","subcat_id":971},{"subcat_name":"音乐会","subcat_id":972},{"subcat_name":"话剧舞台剧","subcat_id":973},{"subcat_name":"舞蹈芭蕾","subcat_id":974},{"subcat_name":"戏曲综艺","subcat_id":975},{"subcat_name":"体育赛事","subcat_id":976},{"subcat_name":"休闲娱乐","subcat_id":977},{"subcat_name":"周边商品","subcat_id":978},{"subcat_name":"儿童亲子","subcat_id":979}]},{"cat_id":990,"cat_name":"充值缴费","subcategories":[{"subcat_name":"手机充值","subcat_id":991}]},{"cat_id":1010,"cat_name":"汽车后服务","subcategories":[{"subcat_name":"二手车","subcat_id":1011},{"subcat_name":"维修保养","subcat_id":1012},{"subcat_name":"交通违章","subcat_id":1013}]}]
     */

    private int errno;
    private String msg;
    /**
     * cat_id : 316
     * cat_name : 生活服务
     * subcategories : [{"subcat_name":"快照冲印","subcat_id":319},{"subcat_name":"宠物服务","subcat_id":367},{"subcat_name":"教育培训","subcat_id":375},{"subcat_name":"儿童摄影","subcat_id":428},{"subcat_name":"口腔","subcat_id":459},{"subcat_name":"其他生活服务","subcat_id":540},{"subcat_name":"婚纱摄影","subcat_id":565},{"subcat_name":"个性写真","subcat_id":614},{"subcat_name":"加油站","subcat_id":616},{"subcat_name":"体检","subcat_id":670},{"subcat_name":"亲子","subcat_id":702},{"subcat_name":"配镜","subcat_id":703},{"subcat_name":"服装定制","subcat_id":704},{"subcat_name":"洗衣店","subcat_id":705},{"subcat_name":"汽车养护","subcat_id":706},{"subcat_name":"婚庆服务","subcat_id":709},{"subcat_name":"本地购物","subcat_id":875},{"subcat_name":"证件照","subcat_id":923},{"subcat_name":"照片冲印","subcat_id":924},{"subcat_name":"家政服务","subcat_id":927},{"subcat_name":"驾校/陪练","subcat_id":928},{"subcat_name":"租车","subcat_id":929},{"subcat_name":"鲜花","subcat_id":930},{"subcat_name":"充值服务","subcat_id":931},{"subcat_name":"送水/送奶","subcat_id":932},{"subcat_name":"丽人","subcat_id":956},{"subcat_name":"药店","subcat_id":2000},{"subcat_name":"药品","subcat_id":2001},{"subcat_name":"保健品","subcat_id":2002},{"subcat_name":"医疗器械","subcat_id":2003},{"subcat_name":"药品相关","subcat_id":2004}]
     */

    private List<CategoriesEntity> categories;

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCategories(List<CategoriesEntity> categories) {
        this.categories = categories;
    }

    public int getErrno() {
        return errno;
    }

    public String getMsg() {
        return msg;
    }

    public List<CategoriesEntity> getCategories() {
        return categories;
    }

    public static class CategoriesEntity {
        private int cat_id;
        private String cat_name;
        /**
         * subcat_name : 快照冲印
         * subcat_id : 319
         */

        private List<SubcategoriesEntity> subcategories;

        public void setCat_id(int cat_id) {
            this.cat_id = cat_id;
        }

        public void setCat_name(String cat_name) {
            this.cat_name = cat_name;
        }

        public void setSubcategories(List<SubcategoriesEntity> subcategories) {
            this.subcategories = subcategories;
        }

        public int getCat_id() {
            return cat_id;
        }

        public String getCat_name() {
            return cat_name;
        }

        public List<SubcategoriesEntity> getSubcategories() {
            return subcategories;
        }

        public static class SubcategoriesEntity {
            private String subcat_name;
            private int subcat_id;

            public void setSubcat_name(String subcat_name) {
                this.subcat_name = subcat_name;
            }

            public void setSubcat_id(int subcat_id) {
                this.subcat_id = subcat_id;
            }

            public String getSubcat_name() {
                return subcat_name;
            }

            public int getSubcat_id() {
                return subcat_id;
            }
        }

        @Override
        public String toString() {
            return "CategoriesEntity{" +
                    "cat_id=" + cat_id +
                    ", cat_name='" + cat_name + '\'' +
                    ", subcategories=" + subcategories +
                    '}';
        }
    }
}
