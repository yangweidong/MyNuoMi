package com.onenews.bean;

import com.onenews.test.FatherItem;

import java.util.List;

/**
 * Created by yangweidong on 15/12/31.
 */
public class CityBean extends FatherItem {


    private int errno;
    private String msg;

    private String cityId;

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }


    /**
     * city_id : 100010000
     * city_name : 北京市
     * short_name : 北京
     * city_pinyin : beijing
     * short_pinyin : bj
     */

    private List<CitiesEntity> cities;

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCities(List<CitiesEntity> cities) {
        this.cities = cities;
    }

    public int getErrno() {
        return errno;
    }

    public String getMsg() {
        return msg;
    }

    public List<CitiesEntity> getCities() {
        return cities;
    }

    public static class CitiesEntity {
        private String city_id;
        private String city_name;
        private String short_name;
        private String city_pinyin;
        private String short_pinyin;

        public void setCity_id(String city_id) {
            this.city_id = city_id;
        }

        public void setCity_name(String city_name) {
            this.city_name = city_name;
        }

        public void setShort_name(String short_name) {
            this.short_name = short_name;
        }

        public void setCity_pinyin(String city_pinyin) {
            this.city_pinyin = city_pinyin;
        }

        public void setShort_pinyin(String short_pinyin) {
            this.short_pinyin = short_pinyin;
        }

        public String getCity_id() {
            return city_id;
        }

        public String getCity_name() {
            return city_name;
        }

        public String getShort_name() {
            return short_name;
        }

        public String getCity_pinyin() {
            return city_pinyin;
        }

        public String getShort_pinyin() {
            return short_pinyin;
        }


        @Override
        public String toString() {
            return "CitiesEntity{" +
                    "city_id=" + city_id +
                    ", city_name='" + city_name + '\'' +
                    ", short_name='" + short_name + '\'' +
                    ", city_pinyin='" + city_pinyin + '\'' +
                    ", short_pinyin='" + short_pinyin + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "CityBean{" +
                "errno=" + errno +
                ", msg='" + msg + '\'' +
                ", cities=" + cities +
                '}';
    }
}
