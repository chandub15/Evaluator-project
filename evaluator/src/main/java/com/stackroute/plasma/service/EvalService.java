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
    private int[] t=new int[5];
    
    private int[] h=new int[5];
    private int[] p=new int[5];
    private int[] b=new int[5];
    private String[] content={"title","h1","p","body"};
    private String[] level1 = {"basics","tutorials","example","complete reference","trouble shooting"};
    private String[] level2 = {"main","fundamental","essential","beginner","basics","model","secondary","additional","auxiliary","snippets"};
    private String[] level3 = {"acedemic","informational","instructive","guidance","instructional","tutorials","training","primary","primitive","foundation"};
    private String[] level4 = {"source code","reference","relating","snippet","sample","expression","model","instance","class","function"};
    private List<String> strL1 = Arrays.asList(level1);
    private List<String> strL2 = Arrays.asList(level2);
    private List<String> strL3 = Arrays.asList(level3);
    private List<String> strL4 = Arrays.asList(level4);


    private String url = "https://www.geeksforgeeks.org/encapsulation-in-java/";
    //String url="https://www.iplt20.com/auction/2019";


    public EvalService() throws IOException {
        this.docx = Jsoup.connect(url).get();

    }
/*
    public String getHtmlContent() throws IOException {
        docx = Jsoup.connect(url)
                .header("Accept-Encoding", "gzip, deflate")
                .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:23.0) Gecko/20100101 Firefox/23.0")
                .maxBodySize(0)
                .timeout(600000)
                .get();
        // System.out.println("RESPONSE data"+doc);
        return String.valueOf(docx);
    }*/


    public String titleTag() throws IOException {
        //Document docx = Jsoup.connect(url).get();
        int count=0;
        List<String> str= Arrays.asList(docx.title().split(" "));
        t[0]=countOccurences(str,strL1);
        t[1]=countOccurences(str,strL2);
        t[2]=countOccurences(str,strL3);
        t[3]=countOccurences(str,strL4);
        System.out.println("-----Title-----");
        System.out.println("L1 Count "+ t[0]);
        System.out.println("L2 Count "+ t[1]);
        System.out.println("L3 Count "+ t[2]);
        System.out.println("L4 Count "+ t[3]);
        return docx.title();
    }


    public String pTag() throws IOException {
        //Document docx = Jsoup.connect(url).get();
        String ss=docx.select("p").text().toLowerCase().trim().replaceAll(":","");
        String ss1=ss.trim().replaceAll(",","");
//        String ss2=ss.trim().replaceAll("\"","");
        String[] str1=ss1.split(" ");


        String pTag = docx.select("p").text();
        //String[] str=p[0]Tag.toLowerCase().trim().split(" ");
        List<String> strn = Arrays.asList(str1);
        //System.out.println(strn);

        p[0]=countOccurences(strn,strL1);
        p[1]=countOccurences(strn,strL2);
        p[2]=countOccurences(strn,strL3);
        p[3]=countOccurences(strn,strL4);
        System.out.println("-----Paragraph-----");
        System.out.println("L1 Count "+ p[0]);
        System.out.println("L2 Count "+ p[1]);
        System.out.println("L3 Count "+ p[2]);
        System.out.println("L4 Count "+ p[3]);
        return pTag;
    }

    public String headTag() throws IOException {
        //Document docx = Jsoup.connect(url).get();
        String h1Tag = docx.select("h1").first().text();
        String[] str=h1Tag.toLowerCase().trim().split(" ");
        List<String> strn = Arrays.asList(str);
        System.out.println(strn);
        h[0]=countOccurences(strn,strL1);
        h[1]=countOccurences(strn,strL2);
        h[2]=countOccurences(strn,strL3);
        h[3]=countOccurences(strn,strL4);

        System.out.println("-----Head-----");
        System.out.println("L1 Count "+ h[0]);
        System.out.println("L2 Count "+ h[1]);
        System.out.println("L3 Count "+ h[2]);
        System.out.println("L4 Count "+ h[3]);
        return h1Tag;
    }

    public String bodyTag() throws IOException {
        data = docx.text();
        /*int c1=0,c2=0,c3=0;
        for(int i=0;i<level1.length;i++){
        //cL1Occurences();*/



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
        //System.out.println(str);


        b[0]=countOccurences(str,strL1)-t[0]-p[0]-h[0];
        b[1]=countOccurences(str,strL2)-t[1]-p[1]-h[1];
        b[2]=countOccurences(str,strL3)-t[2]-p[2]-h[2];
        b[3]=countOccurences(str,strL4)-t[3]-p[3]-h[3];

        System.out.println("-------Total Content----------");
        //------------Level1-------------

        System.out.println("L1 Count "+ b[0]);
        System.out.println("L2 Count "+ b[1]);
        System.out.println("L3 Count "+ b[2]);
        System.out.println("L4 Count "+ b[3]);



        //-----------Level2-------------------

         /* for (String s : str) {
            if (strL1.contains(s.trim())){
                count1++;
            }

        }

        System.out.println("L1 Count "+ count1);*/

         /*

        for (String s : str) {
            if (strL2.contains(s.trim())){
                count2++;
            }

        }

        System.out.println("L2 count "+ count2);

*/

//        if(str.containsAll(strL2)){
//            count2++;
//
//        }



       /* for (String s : str) {
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
*/
//        if(str.containsAll(strL3)){
//            count3++;
//
//        }
        //---------------Level3--------------------



        return data;
    }



    public int countOccurences(List<String> str,List<String> strL){
        int countx=0;
        for (String s : str) {
            if (strL.contains(s.trim())){
                countx++;
            }
        }
        return countx;
    }




    public int[] getScore() throws IOException {
        System.out.println("in method");
        int[][] val=new int[4][4];
        int[] score=new int[4];
        int i=0;

        titleTag();
        headTag();
        pTag();
        bodyTag();

        for(int j=0;j<4;j++){
            val[0][j]=t[j];
        }
        for(int j=0;j<4;j++){
            val[1][j]=h[j];
        }
        for(int j=0;j<4;j++){
            val[2][j]=p[j];
        }
        for(int j=0;j<4;j++){
            val[3][j]=b[j];
        }


        System.out.println("---------------------------------------------------");
        System.out.println("|       | LEVEL-1 | LEVEL-2 | LEVEL-3 | LEVEL-4 | LEVEL-5 |");
        for(i=0;i<4;i++){
            System.out.print("| "+content[i]+" | ");
            for(int j=0;j<4;j++){
                System.out.print("  "+val[i][j]+"  ");
            }
            System.out.println("| \n");
        }
        System.out.println("---------------------------------------------------");


        for(int j=0;j<4;j++){
            score[j]=0;
            for(i=0;i<4;i++){

                score[j]=score[j]+val[i][j];

            }
            System.out.println(score[j]);
        }


        return score;

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

