package com.stackroute.plasma.service;

import com.stackroute.plasma.domain.Evaluator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;


@Service
public class EvalService {

    Document docx;
    String data;
    int cL1 = 0, cL2 = 0, cL3 = 0;
    private String[] level1 = {"basics","tutorials","example","complete reference","trouble shooting"};
    private String[] level2 = {"main","fundamental","essential","beginner","basics","model","secondary","additional","auxiliary","snippets"};
    private String[] level3 = {"acedemic","informational","instructive","guidance","instructional","tutorials","training","primary","primitive","foundation"};
    private String[] level4 = {"source code","reference","relating","snippet","sample","expression","model","instance","class","function","Encapsulation"};



    public EvalService() throws IOException {
        this.docx = Jsoup.connect(url).get();

    }

    String url = "https://www.geeksforgeeks.org/encapsulation-in-java/";
    //String url="https://www.iplt20.com/auction/2019";

    public String getHtmlContent() throws IOException {
        docx = Jsoup.connect(url)
                .header("Accept-Encoding", "gzip, deflate")
                .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:23.0) Gecko/20100101 Firefox/23.0")
                .maxBodySize(0)
                .timeout(600000)
                .get();
        // System.out.println("RESPONSE data"+doc);
        return String.valueOf(docx);
    }


    public String titleTag() throws IOException {
        //Document docx = Jsoup.connect(url).get();
        int count=0;
        List<String> str= Arrays.asList(docx.title().split(" "));
        List<String> strL=Arrays.asList(level1);
       if(str.containsAll(strL)){
           count++;

       }
        System.out.println("count "+ count);

        return docx.title();
    }


    public String headTag() throws IOException {
        //Document docx = Jsoup.connect(url).get();
        Element h1Tag = docx.select("h1").first();
        return h1Tag.text();
    }

    public String bodyTag() throws IOException {
        data = docx.text();
        /*int c1=0,c2=0,c3=0;
        for(int i=0;i<level1.length;i++){
        //cL1Occurences();*/


        int count1 = 0, count2 = 0, count3 = 0,count4=0;
        String ss=docx.text().toLowerCase().trim().replaceAll(":","");
        String ss1=ss.trim().replaceAll(",","");
//        String ss2=ss.trim().replaceAll("\"","");
        String[] str1=ss1.split(" ");
//        System.out.println(Arrays.asList(str1));
//
//        String[] str2=Arrays.toString(str1).split(":");
//        String[] str3=Arrays.toString(str2).split(",");
//
//        System.out.println(Arrays.toString(str3));
        List<String> str = Arrays.asList(str1);
        //  while(str.removeAll(null)){}
        System.out.println(str);
        List<String> strL1 = Arrays.asList(level1);
        List<String> strL2 = Arrays.asList(level2);
        List<String> strL3 = Arrays.asList(level3);
        List<String> strL4 = Arrays.asList(level4);


        //------------Level1-------------
        for (String s : str) {
            if (strL1.contains(s.trim())){
                count1++;
            }

        }

        System.out.println("L1 Count "+ count1);



        //-----------Level2-------------------

        for (String s : str) {
            if (strL2.contains(s.trim())){
                count2++;
            }

        }

        System.out.println("L2 count "+ count2);


//        if(str.containsAll(strL2)){
//            count2++;
//
//        }

        //---------------Level3--------------------


        for (String s : str) {
            if (strL3.contains(s.trim())){
                count3++;
            }

        }
        System.out.println("L3 count "+ count3);



        for (String s : str) {
            if (strL4.contains(s.trim())){
                count4++;
            }

        }
        System.out.println("L4 count "+ count4);

//        if(str.containsAll(strL3)){
//            count3++;
//
//        }

        return data;
    }

   /* public String description(){
        return docx.select("meta[name=description]").first().attr("content");
    }

    public String keywords(){
        return docx.select("meta[name=keywords]").first().attr("content");
    }*/

 /*   public int cL1Occurences(String word) {

        String a[] = data.split(" ");
        for (int i = 0; i < a.length; i++) {
            if (word.equals(a[i]))
                cL1++;
        }

        return cL1;
    }

    public int cL2Occurences(String word) {

        String a[] = data.split(" ");
        for (int i = 0; i < a.length; i++) {
            if (word.equals(a[i]))
                cL2++;
        }

        return cL2;
    }

    public int cL3Occurences(String word) {

        String a[] = data.split(" ");
        for (int i = 0; i < a.length; i++) {
            if (word.equals(a[i]))
                cL3++;
        }

        return cL3;
    }*/


}
























/*    public String calScore() throws IOException {
       //String docx = Jsoup.connect("https://www.geeksforgeeks.org/encapsulation-in-java/").get().body().text();
        Document docx = Jsoup.connect("https://www.geeksforgeeks.org/encapsulation-in-java/").get();

        String description = docx.select("meta[name=description]").first().attr("content");
        //System.out.println("Description : " + description);

        String keywords = docx.select("meta[name=keywords]").first().attr("content");
        //System.out.println("Keywords : " + keywords);
        System.out.println("RESPONSE data"+ description +"\n \n "+keywords);

        Element link = docx.select("a").first();

       // String text = docx.body().text(); // "An example link"
        // String linkHref = link.attr("href"); // "http://example.com/"
        // String linkText = link.text();
        return linkHref;
    }

    public String getScore() {

        return "anythingABC";
    }*/

