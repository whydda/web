package com.example.demo;

import com.example.demo.util.excel.ExcelReadOption;
import com.example.demo.util.excel.ExcelUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: whydda
 * Date: 2020-02-12
 * Time: 오후 5:47
 */
public class DefaultTest {

    @Test
    public void excelupload() throws Exception {
        String filePath = "C:\\Users\\whydd\\Desktop\\test.xlsx";
        // 값 읽어 오는 과정임
        ExcelReadOption read = new ExcelReadOption();
        read.setFilePath(filePath);
        read.setStartRow(2);
        //DB에 업로드될 컬럼과 맞추면 좋음
        read.setOutputColumns("A","B","C","D","E","F","G","H");
        Workbook workbook = ExcelUtils.getWorkbook(new FileInputStream(read.getFilePath()));
        List<Map<String, String>> list = ExcelUtils.excelDataUpload(workbook, read);

        // 이거 이대로 가져가서 DB에 넣어 주면 됨
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
             System.out.println(list.get(i).values());
            for (String key : list.get(i).keySet()) {
                 System.out.println("key: " + key + " / value :" + list.get(i).get(key) );
            }
        }

        System.out.println("끝");
    }
}
