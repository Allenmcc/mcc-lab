//package utils;
//
//import org.dom4j.*;
//import org.dom4j.io.OutputFormat;
//import org.dom4j.io.SAXReader;
//import org.dom4j.io.XMLWriter;
//import sun.misc.BASE64Decoder;
//import sun.misc.BASE64Encoder;
//
//import java.io.*;
//import java.util.*;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class ExportDocUtil {
//
//    /**
//     * @return
//     * @Description: 根据图片地址转换为base64编码字符串
//     * @Author:
//     * @CreateTime:
//     */
//    public static String getImageStr(String imgFile) {
//        InputStream inputStream = null;
//        byte[] data = null;
//        try {
//            inputStream = new FileInputStream(imgFile);
//            data = new byte[inputStream.available()];
//            inputStream.read(data);
//            inputStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        // 加密
//        BASE64Encoder encoder = new BASE64Encoder();
//        return encoder.encode(data).trim();
//    }
//
//
//    public static void main(String[] args) {
//        List<Map<String, Object>> datas = new ArrayList<Map<String, Object>>();
//
//        /*Map<String, Object> map = new HashMap<String, Object>();
//        map.put("rowNo","张三");
//        map.put("targetCode","男");
//        map.put("targetName","广州市");
//        map.put("specifications", "12121@qq.com");
//        map.put("currency", "打篮球");
//        map.put("unit", "人长得帅");
//        map.put("num", "12121@qq.com");
//        map.put("taxIncludedPrice", "打篮球");
//        map.put("taxIncludedAmount", "人长得帅");
//
//        Map<String, Object> map1 = new HashMap<String, Object>();
//        map1.put("rowNo","张三");
//        map1.put("targetCode","男");
//        map1.put("targetName","广州市");
//        map1.put("specifications", "12121@qq.com");
//        map1.put("currency", "打篮球");
//        map1.put("unit", "人长得帅");
//        map1.put("num", "12121@qq.com");
//        map1.put("taxIncludedPrice", "打篮球");
//        map1.put("taxIncludedAmount", "人长得帅");
//
//        datas.add(map);
//        datas.add(map1);*/
//
//        Map<String, Object> map1 = new HashMap<String, Object>();
//        map1.put("rowNo", "1");
//        map1.put("name", "男");
//        map1.put("sex", "广州市");
//        map1.put("intesting", "12121@qq.com");
//        map1.put("phone", "打篮球");
//        map1.put("remark", "人长得帅");
//        datas.add(map1);
//
//        Map<String, Object> map2 = new HashMap<String, Object>();
//        map2.put("rowNo", "2");
//        map2.put("name", "男");
//        map2.put("sex", "广州市");
//        map2.put("intesting", "12121@qq.com");
//        map2.put("phone", "打篮球");
//        map2.put("remark", "人长得帅");
//        datas.add(map2);
//
//        Map<String, Object> map3 = new HashMap<String, Object>();
//        map3.put("rowNo", "3");
//        map3.put("name", "男");
//        map3.put("sex", "广州市");
//        map3.put("intesting", "12121@qq.com");
//        map3.put("phone", "打篮球");
//        map3.put("remark", "人长得帅");
//        datas.add(map3);
//
//        Map<String, Object> map4 = new HashMap<String, Object>();
//        map4.put("rowNo", "4");
//        map4.put("name", "男");
//        map4.put("sex", "广州市");
//        map4.put("intesting", "12121@qq.com");
//        map4.put("phone", "打篮球");
//        map4.put("remark", "人长得帅");
//        datas.add(map4);
//
//        Map<String, Object> map5 = new HashMap<String, Object>();
//        map5.put("rowNo", "5");
//        map5.put("name", "男");
//        map5.put("sex", "广州市");
//        map5.put("intesting", "12121@qq.com");
//        map5.put("phone", "打篮球");
//        map5.put("remark", "人长得帅");
//        datas.add(map5);
//
//        List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
//        Map<String, Object> mapph = new HashMap<String, Object>();
//        mapph.put("eiName", "广州市新东方集团");
//        mapph.put("address", "广州市广州塔");
//        mapph.put("representative", "张三");
//        mapph.put("TableRemark", "总重量不超总重量吨，切板头板尾，宽度负差: -0mm/+2mm ");
//        mapph.put("mobile", "埃斯普咨询有限公司");
//        mapph.put("phone", "广州市番禺区海伦堡1座");
//        mapph.put("fax", "2222");
//        listMap.add(mapph);
//
//        List<Map<String, Object>> url_imgs = new ArrayList<Map<String, Object>>();
//        Map<String, Object> imgUrl = new HashMap<String, Object>();
//        imgUrl.put("picture", "/Users/chunchenmeng/Desktop/WechatIMG1.jpeg");
//        imgUrl.put("picture2", "/Users/chunchenmeng/Desktop/WechatIMG2.jpeg");
//        url_imgs.add(imgUrl);
//
//
//        // ExportDocUtil.exportDoc(datas,listMap,url_imgs,"G:\\poi\\srm\\新建文件夹\\合同模板.doc","G:\\poi\\srm\\新建文件夹\\123.doc","164","121");
//
//        exportDoc2Table(datas, listMap, "/Users/chunchenmeng/Desktop/moudue.doc", "/Users/chunchenmeng/Desktop/111.doc");
//
//        /*String base = getImageStr("D:\\picture\\picture\\DCIM\\DCIM\\IMG20160419143404.jpg");
//        GenerateImage(base,"");*/
//
//        // System.out.println(getImageStr("G:\\poi\\srm\\picture.jpg"));
//
//        /*try {
//            addImg2Word(listMap);
//        } catch (DocumentException e) {
//            e.printStackTrace();
//        }*/
//
//        //GetTagContent();
//        //   fiee.createDoc();
//
//
//      /*
//        try {
//            changePatagraphText(listMap);
//        } catch (DocumentException e) {
//            e.printStackTrace();
//        }*/
//
//    }
//
//    /**
//     * 找到{***} 标签内容
//     *
//     * @return
//     */
//    public static Map GetTagContent(Document doc) {
//        Map<String, Object> map = new HashMap<String, Object>();
//        int num = 0;
//        try {
//
////            List<Element> nodeList = doc.selectNodes("//w:tbl//w:tr//w:tc//w:p//w:r//w:t");
//            String selectNodes = "/w\:tbl/w\:tr/w\:tc/w\:p/w\:r/w/:t";
//            List<Element> nodeList = doc.selectNodes("/w:tbl/w:tr/w:tc/w:p/w:r/w:t");
//            if (nodeList.size() > 0) {
//
//                for (Element node : nodeList) {
//                    String Text = "";
//                    String regEx = "\\{.+?\\}";
//                    Pattern pattern = Pattern.compile(regEx);
//                    Matcher matcher = pattern.matcher(node.getText());//正则匹配字符串{****}
//
//                    if (matcher.find()) {
//                        String valText = node.getText();
//                        int beginIndex = valText.indexOf("{");
//                        int endIndex = valText.indexOf("}");
//                        int length = valText.length();
//
//                        Text = valText.substring(1, endIndex);
//                        map.put(String.valueOf(num), Text);
//
//                        num++;
//                        // System.out.println(node.getText() + "--------------------------------------------------------------");
//                    }
//                    //  System.out.println(node.getName()+":"+node.valueOf("@name")+","+node.valueOf("@age") + node.getText());
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return map;
//
//    }
//
//    /**
//     * 删除标签 {***}
//     *
//     * @param doc
//     */
//    public static void deleteElement2tr(Document doc) {
//        List<Element> nodeList = doc.selectNodes("//w:tbl//w:tr");
//
//        if (nodeList != null && nodeList.size() > 0) {
//            nodeList.get(1).getParent().remove(nodeList.get(1));
//        }
//
//       /* if (nodeList.size() > 0) {
//            Iterator<Element> childIter=nodeList.get(1).elementIterator();
//            while(childIter.hasNext()) {
//                Element childElement = childIter.next();
//                String tag = childElement.getName();
//                element.getParent().remove(element);
//            }
//        }*/
//    }
//
//
//    /**
//     * 改变段落内的文字 ${***}
//     */
//    public static void changePatagraphText(List<Map<String, Object>> Paragraph, Document doc) {
//
//        List<Element> elements = doc.selectNodes("//w:t");
//
//        for (Element element : elements) {
//            String name = element.getText();
//            String regEx = "\\$\\{.+?\\}";
//            Pattern pattern = Pattern.compile(regEx);
//            Matcher matcher = pattern.matcher(name);//正则匹配字符串${****}
//            //  System.out.println(element.getText() + "--------------------");
//
//            if (matcher.find()) {
//                for (Map<String, Object> map : Paragraph) {
//                    int endIndex = name.indexOf("}");
//                    String key = name.substring(2, endIndex);
//
//                    if (map.containsKey(key)) {
//                        element.setText(map.get(key).toString());
//                    }
//                }
//            }
//
//        }
//    }
//
//    /**
//     * 添加图片    ,Document doc
//     */
//    public static void addImg2Word(List<Map<String, Object>> list_imgUrl, Document doc, String Width, String Height) throws DocumentException {
//        int num_index = 0;  //末尾有多少多余的图片, 删除
//
//        List<Element> parent_elements = new ArrayList<Element>();   //图片的w:p 集合
//
//        List<Element> sect_element = doc.selectNodes("//wx:sect");//body下面的标签, 一般只有一个
//
//        List<Element> elements = doc.selectNodes("//w:t");
//        Element element_parent = null;
//
//        for (Element element : elements) {
//            String name = element.getText();
//            String regEx = "\\{\\{.+?\\}\\}";
//            Pattern pattern = Pattern.compile(regEx);
//            Matcher matcher = pattern.matcher(name);//正则匹配字符串${****}
//
//            if (matcher.find()) {
//                for (Map<String, Object> map : list_imgUrl) {
//                    int endIndex = name.indexOf("}}");
//                    String key = name.substring(2, endIndex);
//
//                    if (map.containsKey(key)) {
//
//
//                        // System.out.println(key + "--------------------");
//                        String img_url = getValueBykey(key, map);//图片路径
//                        String base64_img = getImageStr(img_url);   //base64
//
//                        element_parent = element.getParent().getParent();//找到父级的父级===> w:p
//
//                        Element element_parent_parent = element_parent.getParent();////找到 w:p 的父级===> wx:sect
//
//                        List<Element> list = element_parent_parent.content();//找到 wx:sect下面的元素集合
//                        int Element_index = list.indexOf(element_parent);//找到下标\
//
//                        //22222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222
//                        Element r_element = element.getParent();      //=====>w:r
//                        /*Iterator<Element> childIter=r_element.elementIterator();
//                        while(childIter.hasNext())
//                        {
//                            Element childElement=childIter.next();
//                            String tag=childElement.getName();
//                            if("name".equals(tag)&&name.equals(childElement.getText()))
//                            {
//                                element.getParent().remove(element);
//                            }
//                        }*/
//
//
//                        //222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222
//
//                        //!!!!!!!====================================================================>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
//
//                        //Document doc1 = DocumentHelper.createDocument();
//
//                     /*   Element p_element = element_parent_parent.addElement("w:p");
//                        p_element.addAttribute("wsp:rsidR","00DD7127");
//                        p_element.addAttribute("wsp:rsidRDefault","00F857E9");*/
//                       /* p_element.addNamespace("w","http://schemas.microsoft.com/office/word/2003/wordml");
//                        p_element.addNamespace("v","http://schemas.microsoft.com/office/word/2003/wordml");
//                        p_element.addNamespace("o","http://schemas.microsoft.com/office/word/2003/wordml");*/
//
//                        //------------------------------------------
//                       /* Element prpelement1 = p_element.addElement("w:pPr");
//                        Element rement = prpelement1.addElement("w:rPr");
//                        rement.addElement("w:rFonts").addAttribute("w:hint","fareast");*/
//                        //-----------------------------------------
//
//
//                        //----------------------------   一行   --------------------
//                      /*  Element r_element = p_element.addElement("w:r");
//                        r_element.addAttribute("wsp:rsidRPr","0090705D");*/
//
//                        Element rpr_element = r_element.addElement("w:rPr");
//                        rpr_element.addElement("w:noProof");
//
//                        Element pic_element = r_element.addElement("w:pict");
//                        Element shapetype_element = pic_element.addElement("v:shapetype");
//
//                        shapetype_element.addAttribute("id", "_x0000_t75");
//                        shapetype_element.addAttribute("coordsize", "21600,21600");
//                        shapetype_element.addAttribute("o:spt", "75");
//                        shapetype_element.addAttribute("o:preferrelative", "t");
//                        shapetype_element.addAttribute("path", "m@4@5l@4@11@9@11@9@5xe");
//                        shapetype_element.addAttribute("filled", "f");
//                        shapetype_element.addAttribute("stroked", "f");
//
//                        Element stroke_element = shapetype_element.addElement("v:stroke");
//                        stroke_element.addAttribute("joinstyle", "miter");
//
//                        //------------------
//                        Element formulas_element = shapetype_element.addElement("v:formulas");
//                        Element formulas_element1 = formulas_element.addElement("v:f");
//                        formulas_element1.addAttribute("eqn", "if lineDrawn pixelLineWidth 0");
//
//                        Element formulas_element2 = formulas_element.addElement("v:f");
//                        formulas_element2.addAttribute("eqn", "sum @0 1 0");
//
//                        Element formulas_element3 = formulas_element.addElement("v:f");
//                        formulas_element3.addAttribute("eqn", "sum 0 0 @1");
//
//                        Element formulas_element4 = formulas_element.addElement("v:f");
//                        formulas_element4.addAttribute("eqn", "prod @2 1 2");
//
//                        Element formulas_element5 = formulas_element.addElement("v:f");
//                        formulas_element5.addAttribute("eqn", "prod @3 21600 pixelWidth");
//
//                        Element formulas_element6 = formulas_element.addElement("v:f");
//                        formulas_element6.addAttribute("eqn", "prod @3 21600 pixelHeight");
//
//                        Element formulas_element7 = formulas_element.addElement("v:f");
//                        formulas_element7.addAttribute("eqn", "sum @0 0 1");
//
//                        Element formulas_element8 = formulas_element.addElement("v:f");
//                        formulas_element8.addAttribute("eqn", "prod @6 1 2");
//
//                        Element formulas_element9 = formulas_element.addElement("v:f");
//                        formulas_element9.addAttribute("eqn", "prod @7 21600 pixelWidth");
//
//                        Element formulas_element10 = formulas_element.addElement("v:f");
//                        formulas_element10.addAttribute("eqn", "sum @8 21600 0");
//
//                        Element formulas_element11 = formulas_element.addElement("v:f");
//                        formulas_element11.addAttribute("eqn", "prod @7 21600 pixelHeight");
//
//                        Element formulas_element12 = formulas_element.addElement("v:f");
//                        formulas_element12.addAttribute("eqn", "sum @10 21600 0");
//
//                        //---------------------------------------------------------------------------------------------
//                        Element path_element = shapetype_element.addElement("v:path");
//                        path_element.addAttribute("o:extrusionok", "f");
//                        path_element.addAttribute("gradientshapeok", "t");
//                        path_element.addAttribute("o:connecttype", "rect");
//
//                        Element lock_element = shapetype_element.addElement("o:lock");
//                        lock_element.addAttribute("v:ext", "edit");
//                        lock_element.addAttribute("aspectratio", "t");
//
//
//                        //============================== 下一标签 ==============================================
//                        Element data_element = pic_element.addElement("w:binData");
//                        data_element.addAttribute("w:name", "wordml://0200000" + String.valueOf(num_index + 1) + ".jpg");
//                        data_element.addAttribute("xml:space", "preserve");
//                        data_element.setText(base64_img);
//
//
//                        Element shape_element = pic_element.addElement("v:shape");
//                        shape_element.addAttribute("id", "图片 " + String.valueOf(num_index + 1));
//                        shape_element.addAttribute("o:spid", "_x0000_i1025");
//                        shape_element.addAttribute("type", "#_x0000_t75");
//                        shape_element.addAttribute("style", "width:" + Width + "pt;height:" + Height + "pt;visibility:visible;mso-wrap-style:square");
//
//                        Element imagedata_element = shape_element.addElement("v:imagedata");
//                        imagedata_element.addAttribute("src", "wordml://0200000" + String.valueOf(num_index + 1) + ".jpg");
//                        imagedata_element.addAttribute("o:title", "");
//
//                        //<<<<<<<<<<<<<<<<<<<<<<<<<<<<===================================================================================!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//
//                        //list.add(Element_index + 1, p_element);
//
//                        parent_elements.add(element_parent);
//                        r_element.remove(element);
//
//                        // element_parent_parent.remove(element_parent);
//
//                        num_index++;
//                    }
//                }
//            }
//        }
//
//        //删除标签 {{******}}
//       /* if (parent_elements != null && parent_elements.size() > 0) {
//            for (Element element1:parent_elements) {
//                sect_element.get(0).remove(element1);
//            }
//        }*/
//
//        Attribute p_attr_rsidR = element_parent.attribute("rsidR");
//        if (p_attr_rsidR != null) {
//            element_parent.remove(p_attr_rsidR);
//        }
//        Attribute p_attr_rsidRDefault = element_parent.attribute("rsidRDefault");
//        if (p_attr_rsidRDefault != null) {
//            element_parent.remove(p_attr_rsidRDefault);
//        }
//        Attribute p_attr_rsidP = element_parent.attribute("rsidP");
//        if (p_attr_rsidP != null) {
//            element_parent.remove(p_attr_rsidP);
//        }
//
//
//        element_parent.addAttribute("wsp:rsidR", "007938E7");
//        element_parent.addAttribute("wsp:rsidRDefault", "00A72728");
//
//        List<Element> Listelement = element_parent.selectNodes("w:pPr");    //添加属性, 让段落格式转成图片格式 ====>begin
//
//        if (Listelement != null && Listelement.size() > 0) {
//
//            Element element_pPr = Listelement.get(0);
//
//            List<Element> element_spacing = element_pPr.selectNodes("w:spacing");
//
//            if (element_spacing != null && element_spacing.size() > 0) {
//                element_pPr.remove(element_spacing.get(0));
//            }
//
//            List<Element> element_rPrs = element_pPr.selectNodes("w:rPr");
//
//            if (element_rPrs != null && element_rPrs.size() > 0) {
//
//                Element element_rPr = element_rPrs.get(0);
//
//                List<Element> element_child = element_rPr.selectNodes("w:lang");
//
//                if (element_child != null && element_child.size() > 0) {
//                    element_rPr.remove(element_child.get(0));
//                }
//                element_rPr.addElement("w:rFonts").addAttribute("w:hint", "fareast");
//
//            }
//            //end  ==============================================================================================
//
//
//        }
//    }
//
//
//    /**
//     * 输出word文档, 带图片
//     *
//     * @param table_datas   表格数据
//     * @param Paragraph     段落数据
//     * @param Img_Urls      图片地址
//     * @param inputDocPath  输入路径
//     * @param outputDocPath 输出路径
//     * @param Img_Width     图片宽度
//     * @param Img_Height    图片高度
//     */
//    public static void exportDoc(List<Map<String, Object>> table_datas, List<Map<String, Object>> Paragraph, List<Map<String, Object>> Img_Urls, String inputDocPath, String outputDocPath,
//                                 String Img_Width, String Img_Height) {
//        try {
//
//            // String getLastsuffix = inputDocPath.substring(inputDocPath.lastIndexOf(".") + 1); //获取后缀
//
//            File file = new File(inputDocPath); //指定文件名及路径
//            String filename = file.getAbsolutePath();
//            String filePath = "";
//            if (filename.indexOf(".") >= 0) {
//                filePath = filename.substring(0, filename.lastIndexOf("."));
//            }
//
//            if (!file.getParentFile().exists()) { //如果文件的目录不存在
//                file.getParentFile().mkdirs(); //创建目录
//
//            }
//            file.renameTo(new File(filePath + ".xml")); //改名
//
//            // ChangeWord2Xml.doc2Xml(inputDocPath,inputDocPath);
//
//            SAXReader reader = new SAXReader();
//            Document doc = reader.read(new File(filePath + ".xml"));
//            List<Element> elementList = doc.selectNodes("//w:tbl");
//
//            if (elementList != null && elementList.size() > 0) {//判断有没表格
//
//                Element element = elementList.get(0);//暂时获取第一个,后面做可配置 --------------------------------------------------------------------------------------------------------------------
//
//                int num = 0;
//                Map<String, Object> map = GetTagContent(doc);
//
//                for (Map<String, Object> data : table_datas) {
//
//                    Element create_tr = element.addElement("w:tr");
//                    create_tr.addAttribute("wsp:rsidR", "00497D9D");
//                    create_tr.addAttribute("wsp:rsidRPr", "002A2AC8");
//                    create_tr.addAttribute("wsp:rsidTr", "002A2AC8");//顶层
//
//                    for (int i = 0; i < map.size(); i++) {
//
//                        //---------------111111111111111111111-----------------------------------------
//                        Element create_tc1 = create_tr.addElement("w:tc");
//                        Element create_tc1_tcPr = create_tc1.addElement("w:tcPr");
//                        //tcpr 下面还有, 后面写
//                        Element create_tc1_tcPr_tcW = create_tc1_tcPr.addElement("w:tcW");
//                        create_tc1_tcPr_tcW.addAttribute("w:w", "800");
//                        create_tc1_tcPr_tcW.addAttribute("w:type", "dxa");
//                        Element create_tc1_tcPr_shd = create_tc1_tcPr.addElement("w:shd");
//                        create_tc1_tcPr_shd.addAttribute("w:val", "clear");
//                        create_tc1_tcPr_shd.addAttribute("w:color", "auto");
//                        create_tc1_tcPr_shd.addAttribute("w:fill", "auto");
//                        Element create_tc1_tcPr_vAlign = create_tc1_tcPr.addElement("w:vAlign");
//                        create_tc1_tcPr_vAlign.addAttribute("w:val", "center");
//
//                        Element create_tc1_p = create_tc1.addElement("w:p");
//                        create_tc1_p.addAttribute("wsp:rsidR", "00E84EF7");
//                        create_tc1_p.addAttribute("wsp:rsidRPr", "002A2AC8");
//                        create_tc1_p.addAttribute("wsp:rsidRDefault", "00E84EF7");
//                        create_tc1_p.addAttribute("wsp:rsidP", "002A2AC8");
//
//                        Element create_tc1_p_r = create_tc1_p.addElement("w:r");
//                        create_tc1_p_r.addAttribute("wsp:rsidRPr", "002A2AC8");
//
//                        Element create_tc1_p_r_t = create_tc1_p_r.addElement("w:t");
//                        create_tc1_p_r_t.setText(getValueBykey(map.get(String.valueOf(num)).toString(), data));
//                        num++;
//                    }
//                    num = 0;
//                }
//            }
//            deleteElement2tr(doc);//
//            changePatagraphText(Paragraph, doc);//替换段落内的标签
//            addImg2Word(Img_Urls, doc, Img_Width, Img_Height);//替换图片图片
//
//            File file_xml = new File(filePath + ".xml"); //指定文件名及路径
//            String fileabsolutePath = file_xml.getAbsolutePath();//  -------> 把.xml 改成 .doc
//            String filePath2Xml = "";
//            if (fileabsolutePath.indexOf(".") >= 0) {
//                filePath2Xml = fileabsolutePath.substring(0, fileabsolutePath.lastIndexOf("."));
//            }
//
//            if (!file.getParentFile().exists()) { //如果文件的目录不存在
//                file.getParentFile().mkdirs(); //创建目录
//            }
//
//            file_xml.renameTo(new File(filePath2Xml + ".doc")); //改名
//
//            //写入文档
//            OutputFormat format = new OutputFormat();
//            format.setEncoding("UTF-8");
//
//            XMLWriter writer = new XMLWriter(new FileOutputStream(new File(outputDocPath)), format);
//
//            writer.write(doc);
//            writer.close();
//        } catch (DocumentException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    private static String getValueBykey(String key, Map<String, Object> map) {
//        String returnValue = "";
//        if (key != null) {
//            try {
//                returnValue = map.get(key) != null ? map.get(key).toString() : "";
//            } catch (Exception e) {
//                // TODO: handle exception
//                //System.out.println("key:"+key+"***"+e);
//                returnValue = "";
//            }
//
//        }
//        return returnValue;
//    }
//
//
//    /**
//     * 输出word文档 (最后一列合并单元格)
//     *
//     * @param table_datas   表格数据
//     * @param Paragraph     段落数据
//     * @param inputDocPath  文件输入路径
//     * @param outputDocPath 文件输出路径
//     */
//    public static void exportDoc2Table(List<Map<String, Object>> table_datas, List<Map<String, Object>> Paragraph, String inputDocPath, String outputDocPath) {
//        try {
//
//            // String getLastsuffix = inputDocPath.substring(inputDocPath.lastIndexOf(".") + 1); //获取后缀
//            File file = new File(inputDocPath); //指定文件名及路径
//
//            String filename = file.getAbsolutePath();
//            String filePath = "";
//            if (filename.indexOf(".") >= 0) {
//                filePath = filename.substring(0, filename.lastIndexOf("."));
//            }
//
//            if (!file.getParentFile().exists()) { //如果文件的目录不存在
//                file.getParentFile().mkdirs(); //创建目录
//
//            }
//            file.renameTo(new File(filePath + ".xml")); //改名
//
//            // ChangeWord2Xml.doc2Xml(inputDocPath,inputDocPath);
//
//            SAXReader reader = new SAXReader();
//            Document doc = reader.read(new File(filePath + ".xml"));
////            List<Element> elementList = doc.selectNodes("//w:tbl");
//            List<Element> elementList = doc.selectNodes("w:tbl");
//
//            if (elementList != null && elementList.size() > 0) {  //判断有没表格
//
//                Element element = elementList.get(0);//暂时获取第一个,后面做可配置 --------------------------------------------------------------------------------------------------------------------
//
//                int num = 0;
//                int lent_tr = 0;
//                Map<String, Object> map = GetTagContent(doc);
//
//                for (Map<String, Object> data : table_datas) {
//                    Element create_tr = element.addElement("w:tr");
//                    create_tr.addAttribute("wsp:rsidR", "00497D9D");
//                    create_tr.addAttribute("wsp:rsidRPr", "002A2AC8");
//                    create_tr.addAttribute("wsp:rsidTr", "002A2AC8");//顶层
//
//                    for (int i = 0; i < map.size(); i++) {
//
//                        if (i != map.size() - 1) {
//                            //---------------111111111111111111111-----------------------------------------
//                            Element create_tc1 = create_tr.addElement("w:tc");
//                            Element create_tc1_tcPr = create_tc1.addElement("w:tcPr");
//                            //tcpr 下面还有, 后面写
//                            Element create_tc1_tcPr_tcW = create_tc1_tcPr.addElement("w:tcW");
//                            create_tc1_tcPr_tcW.addAttribute("w:w", "800");
//                            create_tc1_tcPr_tcW.addAttribute("w:type", "dxa");
//
//                            Element create_tc1_tcPr_shd = create_tc1_tcPr.addElement("w:shd");
//                            create_tc1_tcPr_shd.addAttribute("w:val", "clear");
//                            create_tc1_tcPr_shd.addAttribute("w:color", "auto");
//                            create_tc1_tcPr_shd.addAttribute("w:fill", "auto");
//                            Element create_tc1_tcPr_vAlign = create_tc1_tcPr.addElement("w:vAlign");
//                            create_tc1_tcPr_vAlign.addAttribute("w:val", "center");
//
//                            Element create_tc1_p = create_tc1.addElement("w:p");
//                            create_tc1_p.addAttribute("wsp:rsidR", "00E84EF7");
//                            create_tc1_p.addAttribute("wsp:rsidRPr", "002A2AC8");
//                            create_tc1_p.addAttribute("wsp:rsidRDefault", "00E84EF7");
//                            create_tc1_p.addAttribute("wsp:rsidP", "002A2AC8");
//
//                            Element create_tc1_p_r = create_tc1_p.addElement("w:r");
//                            create_tc1_p_r.addAttribute("wsp:rsidRPr", "002A2AC8");
//
//                            Element create_tc1_p_r_t = create_tc1_p_r.addElement("w:t");
//                            create_tc1_p_r_t.setText(getValueBykey(map.get(String.valueOf(num)).toString(), data));
//                        } else {
//                            Element create_tc1 = create_tr.addElement("w:tc");
//                            Element create_tc1_tcPr = create_tc1.addElement("w:tcPr");
//
//                            Element create_vmerge = create_tc1_tcPr.addElement("w:vmerge");
//
//                            if (lent_tr == 0) {
//                                create_vmerge.addAttribute("w:val", "restart");
//                            }
//
//                            Element create_tc1_tcPr_tcW = create_tc1_tcPr.addElement("w:tcW");
//                            create_tc1_tcPr_tcW.addAttribute("w:w", "800");
//                            create_tc1_tcPr_tcW.addAttribute("w:type", "dxa");
//
//                            Element create_tc1_tcPr_shd = create_tc1_tcPr.addElement("w:shd");
//                            create_tc1_tcPr_shd.addAttribute("w:val", "clear");
//                            create_tc1_tcPr_shd.addAttribute("w:color", "auto");
//                            create_tc1_tcPr_shd.addAttribute("w:fill", "auto");
//
//                            Element create_tc1_p = create_tc1.addElement("w:p");
//                            create_tc1_p.addAttribute("wsp:rsidR", "007D28E2");
//                            create_tc1_p.addAttribute("wsp:rsidRPr", "00293C83");
//                            create_tc1_p.addAttribute("wsp:rsidRDefault", "007D28E2");
//                            create_tc1_p.addAttribute("wsp:rsidP", "00293C83");
//
//                            Element create_tc1_p_r = create_tc1_p.addElement("w:pPr");
//                            Element element_pPr_w = create_tc1_p_r.addElement("w:jc");
//                            element_pPr_w.addAttribute("w:val", "left");
//
//
//                            if (lent_tr == 0) {
//                                Element create_r = create_tc1_p.addElement("w:r");
//                                create_r.addAttribute("wsp:rsidRPr", "00293C83");
//
//
//                                Element element_rPr = create_r.addElement("w:rPr");
//
//                                Element element_rFonts = element_rPr.addElement("w:rFonts");
//                                element_rFonts.addAttribute("w:ascii", "宋体");
//                                element_rFonts.addAttribute("w:fareast", "宋体");
//                                element_rFonts.addAttribute("w:h-ansi", "宋体");
//                                element_rFonts.addAttribute("w:cs", "宋体");
//                                element_rFonts.addAttribute("w:hint", "fareast");
//
//                                Element element_font = element_rPr.addElement("wx:font");
//                                element_font.addAttribute("wx:val", "宋体");
//
//                                Element element_kern = element_rPr.addElement("w:kern");
//                                element_kern.addAttribute("w:val", "0");
//
//                                Element element_sz = element_rPr.addElement("w:sz");
//                                element_sz.addAttribute("w:val", "24");
//
//                                Element element_szcs = element_rPr.addElement("w:sz-cs");
//                                element_szcs.addAttribute("w:val", "24");
//
//                                Element element_wt = create_r.addElement("w:t");
//                                element_wt.setText("${TableRemark}");
//                            }
//                        }
//
//                        num++;
//                    }
//                    num = 0;
//                    lent_tr++;
//                }
//
//                //---------------合计!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!-----------------------------------------
//                Element create_tr = element.addElement("w:tr");
//                create_tr.addAttribute("wsp:rsidR", "00497D9D");
//                create_tr.addAttribute("wsp:rsidRPr", "002A2AC8");
//                create_tr.addAttribute("wsp:rsidTr", "002A2AC8");//顶层
//
//                for (int i = 0; i < table_datas.get(0).size(); i++) {
//                    Element create_tc1 = create_tr.addElement("w:tc");
//                    Element create_tc1_tcPr = create_tc1.addElement("w:tcPr");
//                    //tcpr 下面还有, 后面写
//                    Element create_tc1_tcPr_tcW = create_tc1_tcPr.addElement("w:tcW");
//                    create_tc1_tcPr_tcW.addAttribute("w:w", "1041");
//                    create_tc1_tcPr_tcW.addAttribute("w:type", "dxa");
//                    Element create_tc1_tcPr_shd = create_tc1_tcPr.addElement("w:shd");
//                    create_tc1_tcPr_shd.addAttribute("w:val", "clear");
//                    create_tc1_tcPr_shd.addAttribute("w:color", "auto");
//                    create_tc1_tcPr_shd.addAttribute("w:fill", "auto");
//                    Element create_tc1_tcPr_vAlign = create_tc1_tcPr.addElement("w:vAlign");
//                    create_tc1_tcPr_vAlign.addAttribute("w:val", "center");
//
//                    Element create_tc1_p = create_tc1.addElement("w:p");
//                    create_tc1_p.addAttribute("wsp:rsidR", "00E84EF7");
//                    create_tc1_p.addAttribute("wsp:rsidRPr", "002A2AC8");
//                    create_tc1_p.addAttribute("wsp:rsidRDefault", "00E84EF7");
//                    create_tc1_p.addAttribute("wsp:rsidP", "002A2AC8");
//
//                    Element create_tc1_p_r = create_tc1_p.addElement("w:r");
//                    create_tc1_p_r.addAttribute("wsp:rsidRPr", "002A2AC8");
//
//                    Element create_tc1_p_r_t = create_tc1_p_r.addElement("w:t");
//
//                    if (i == 0) {
//                        create_tc1_p_r_t.setText("合计");
//                    }
//
//                }
//
//            }
//            deleteElement2tr(doc);//
//            changePatagraphText(Paragraph, doc);//替换段落内的标签
//
//
//            File file_xml = new File(filePath + ".xml"); //指定文件名及路径
//            String fileabsolutePath = file_xml.getAbsolutePath();//  -------> 把.xml 改成 .doc
//            String filePath2Xml = "";
//            if (fileabsolutePath.indexOf(".") >= 0) {
//                filePath2Xml = fileabsolutePath.substring(0, fileabsolutePath.lastIndexOf("."));
//            }
//
//            if (!file.getParentFile().exists()) { //如果文件的目录不存在
//                file.getParentFile().mkdirs(); //创建目录
//            }
//
//            file_xml.renameTo(new File(filePath2Xml + ".doc")); //改名
//
//            //写入文档
//            OutputFormat format = new OutputFormat();
//            format.setEncoding("UTF-8");
//
//            XMLWriter writer = new XMLWriter(new FileOutputStream(new File(outputDocPath)), format);
//
//            writer.write(doc);
//            writer.close();
//        } catch (DocumentException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static boolean GenerateImage(String imgStr, String photoname) {
//        //对字节数组字符串进行Base64解码并生成图片
//        //图像数据为空
//        if (imgStr == null)
//            return false;
//
//
//        BASE64Decoder decoder = new BASE64Decoder();
//        try {
//            //Base64解码
//            byte[] b = decoder.decodeBuffer(imgStr);
//            for (int i = 0; i < b.length; ++i) {
//                if (b[i] < 0) {
//                    //调整异常数据
//                    b[i] += 256;
//                }
//            }
//            //生成jpeg图片
//           /* String imagePath= Config.getUploadPhysicalPath();
//            //System.currentTimeMillis()
//            //新生成的图片
//            String imgFilePath = imagePath+photoname;*/
//            OutputStream out = new FileOutputStream("G:\\poi\\test.jpg");
//            out.write(b);
//            out.flush();
//            out.close();
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//}
