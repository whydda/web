package com.example.demo.util;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by IntelliJ IDEA.
 * User: whydda
 * Date: 2020-02-12
 * Time: 오후 5:41
 */
public class CommonUtils {
    /**
     * 값이 없는 Object 객체 삭제
     * @param i
     * @return
     */
    public static boolean chkRemoveObj(Map<String, String> i) {
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        atomicBoolean.set(false);

        i.forEach((k, v) -> {
            if(StringUtils.isEmpty(v)){
                atomicBoolean.set(true);
            }
        });

        return atomicBoolean.get();
    }
}
