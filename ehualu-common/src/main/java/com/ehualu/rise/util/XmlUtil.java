package com.ehualu.rise.util;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.InputSource;

public class XmlUtil {
	 /**
     * 将xml形式的string 转化成实体类时 出错和根结点及属性处理
     * 
     * @param xmlString
     * @return
     * @throws Message
     */
    public static Element getRoot(String xmlString) {
        SAXReader saxReader = new SAXReader();
        Document doc = null;
        try {
            // 读字符串
            InputSource is = new InputSource(new ByteArrayInputStream(xmlString.getBytes("UTF-8")));
            doc = saxReader.read(is);
        } catch (Exception e) {
           e.printStackTrace();
        }
        return doc.getRootElement();
    }

    /**
     * 获取XML文件中的“FAULTS”节点
     * 
     * @param root
     *            XML文件节点
     * @return XML中包含的异常信息
     * 
     */
    public static String getErrMsg(Element root) {
        // 得到结点
        List<Element> list_faults = root.elements("error");
        StringBuffer message = new StringBuffer();
        for (Element faults : list_faults) {
        	message.append(faults.getText()) ;
        }
        return message.toString();
    }
}
