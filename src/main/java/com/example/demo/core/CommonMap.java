package com.example.demo.core;

import org.apache.commons.collections.map.ListOrderedMap;
import org.springframework.jdbc.support.JdbcUtils;

/**
 * Created by IntelliJ IDEA.
 * User: whydda
 * Date: 2020-01-13
 * Time: 오후 4:49
 */
public class CommonMap extends ListOrderedMap {

    private static final long serialVersionUID = 1L;

    /*컬렉션 객체는 camelcase 옵션이 설정안됨 수동으로 만들어야함*/
    @Override
    public Object put(Object key, Object value) {
        return super.put(JdbcUtils.convertUnderscoreNameToPropertyName(String.valueOf(key)), value);
    }

    public String getString(Object key) {
        String result = "";
        if (super.get(key) != null) {
            result = super.get(key).toString();
        }
        return result;
    }

    public int getInt(Object key) {
        String result = "0";
        if (super.get(key) != null) {
            result = super.get(key).toString();
        }
        return Integer.parseInt(result);
    }

    public long getLong(Object key) {
        String result = "0";
        if (super.get(key) != null) {
            result = super.get(key).toString();
        }
        return Long.parseLong(result);
    }

    public float getFloat(Object key) {
        String result = "0";
        if (super.get(key) != null) {
            result = super.get(key).toString();
        }
        return Float.parseFloat(result);
    }
}
