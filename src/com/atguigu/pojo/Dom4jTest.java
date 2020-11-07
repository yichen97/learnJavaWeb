package com.atguigu.pojo;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

public class Dom4jTest {
    @Test
    public void test1() throws Exception {
        // 创建一个SaxReader输入流，去读取 xml配置文件，生成Document对象
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("src/books.xml");
        System.out.println(document);
    }

    @Test
    public void test2() throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read("src/books.xml");
        Element rootElement = document.getRootElement();
        List<Element> books = rootElement.elements("book");
        for (Element book : books){
            Element nameElement = book.element("name");
            System.out.println(nameElement);
            String name = nameElement.getText();
            String Sn = book.attributeValue("sn");
            System.out.println(name);
            System.out.println(Sn);
        }
    }


}
