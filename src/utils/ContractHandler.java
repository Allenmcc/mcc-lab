package utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class ContractHandler {

    //饱汉模式，需要用到时才去创建
    private Configuration configuration = null;
    public ContractHandler() {
        configuration = new Configuration();
        configuration.setDefaultEncoding("utf-8");
        try {
            configuration.setDirectoryForTemplateLoading(new File("/Users/chunchenmeng/work/mcc-lab/src/utils"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //创建后缀为.doc的文档
    public void creatDoc() {
        //把数据放进这个map里面进行填充
        Map dataMap = new HashMap();
        //获取数据的方法
        getData(dataMap);
        //模板文件的位置，你们的模板就是自己修改的flt文档，我的是跟代码同一个包下（确保能找到就可以）
        configuration.setClassForTemplateLoading(this.getClass(), "/utils");
        Template template = null;
        try {
            //加载---要装载的模板文件
            template = configuration.getTemplate("yituProduct.ftl");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //输出文档路径及名称,注意后缀一定要.doc！不然代码运行完后会打不开
        File outFile = new File("/Users/chunchenmeng/Desktop/yituProduct2.doc");
        Writer out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            template.process(dataMap, out);
            // System.out.println(out); 查看数据
            //  System.out.println(dataMap); 查看数据
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void getData(Map dataMap) {
        List<User> userList = new ArrayList<>();
        /**
         *这里有循环，是因为我的模板中序号可能有多条，所以我把序号，地区，数量，日	通话量，备注作为了一个bean
         进行了循环添加，如果你们遇上要循环的地方也可以这样，但是模板文件也要修改， ctrl+F 搜索<w:tr，
         找到对应的文字需要循环的下面添加   <#list userList as user>，并在</w:tr后面加上</#list>结尾！
         */
        for (int i = 0; i < 4; i++) {
            if (i != 3) {
                User u = new User();
                u.setSequence("1" + i);
                u.setLocal("浙江杭州" + i);
                u.setNumber("2" + i);
                userList.add(u);
            } else {
                User u = new User();
                u.setSequence("合计");
                u.setLocal("----");
                u.setNumber("1000");
                userList.add(u);
            }
        }
        User user = new User();
        user.setNumber("200");
        user.setLocal("浙江杭州");
        user.setSequence("110");

        dataMap.put("userList", userList);
        dataMap.put("contract", user);
        dataMap.put("partya", "依图网络科技有限公司");
        dataMap.put("partyaDelegate", "孟春晨");
        dataMap.put("partyb", "长宁区公安局");
        dataMap.put("partybDelegate", "eric.zhang");
        dataMap.put("contractValue", "100");
        dataMap.put("productPrice", "100W");
        dataMap.put("connect", "102");
        dataMap.put("afterSaleServiceFee", "103");
        dataMap.put("customFee", "104");
        dataMap.put("otherFee", "105");
        dataMap.put("test", "105");
        dataMap.put("foo",false);
        dataMap.put("display","mcc");
        dataMap.put("reportDate","2019-10-20");
        dataMap.put("projectName","四叶草");
        dataMap.put("money","200W");
    }

    /**
     * 生成docx文件
     *
     * @param docxTemplate    docx的模板docx文件路径
     * @param docxXmlTemplate docx的模板xml文件名称
     * @param tempDocxXmlPath docx的临时xml文件(docx的模板xml文件填充完数据生成的临时文件)
     * @param params          填充到docx的临时xml文件中的数据
     * @param toFilePath      最终输出的docx文件路径
     */
    public  void xmlToDocx(String docxTemplate, String docxXmlTemplate, String tempDocxXmlPath, Map params, String toFilePath) {
        try {
            Template template = configuration.getTemplate(docxXmlTemplate);

            Writer fileWriter = new FileWriter(new File(tempDocxXmlPath));
            template.process(params, fileWriter);
            if (fileWriter != null) {
                fileWriter.close();
            }

            File docxFile = new File(docxTemplate);
            ZipFile zipFile = new ZipFile(docxFile);
            Enumeration<? extends ZipEntry> zipEntrys = zipFile.entries();
            ZipOutputStream zipout = new ZipOutputStream(new FileOutputStream(toFilePath));
            int len = -1;
            byte[] buffer = new byte[1024];
            while (zipEntrys.hasMoreElements()) {
                ZipEntry next = zipEntrys.nextElement();
                InputStream is = zipFile.getInputStream(next);
                //把输入流的文件传到输出流中 如果是word/document.xml由我们输入
                zipout.putNextEntry(new ZipEntry(next.toString()));
                if ("word/document.xml".equals(next.toString())) {
                    //InputStream in = new FileInputStream(new File(XmlToDocx.class.getClassLoader().getResource("").toURI().getPath()+"template/test.xml"));
                    InputStream in = new FileInputStream(tempDocxXmlPath);
                    while ((len = in.read(buffer)) != -1) {
                        zipout.write(buffer, 0, len);
                    }
                    in.close();
                } else {
                    while ((len = is.read(buffer)) != -1) {
                        zipout.write(buffer, 0, len);
                    }
                    is.close();
                }
            }
            zipout.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ZipException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testDocx() {
        // docx模板文件的路径和文件名
        String docxTemplate = "/Users/chunchenmeng/work/mcc-lab/src/utils/yituProduct2x.docx";

        // docx模板文件名称，该文件可以直接使用解压软件打开docx文件，复制word/document.xml文件内容进行修改
        String docxXmlTemplate = "/yituProduct.xml";

        // docx需要的临时xml文件路径，名称和路径都无所谓，只是中间过程会用到，之后可以删除,文件不需存在，但路径必须存在
//        String tempDocxXmlPath = "E:\\freemarker\\temp\\temp.xml";
        String tempDocxXmlPath = "temp.xml";

        // 目标文件名
//        String outputFilePath = "E:\\freemarker\\docxTemplate.docx";
        String outputFilePath = "/Users/chunchenmeng/Desktop/docx33.docx";

        // 需要动态传入的数据
        Map<String, Object> params = new HashMap<String, Object>();
//        params.put("name", "四个空格-https://www.4spaces.org");
        getData(params);

        ContractHandler xtd = new ContractHandler();
        xtd.xmlToDocx(docxTemplate, docxXmlTemplate, tempDocxXmlPath, params, outputFilePath);
    }

    public static void main(String[] args) {
        ContractHandler documentHandler = new ContractHandler();
//        documentHandler.creatDoc();
        documentHandler.testDocx();
    }
}
