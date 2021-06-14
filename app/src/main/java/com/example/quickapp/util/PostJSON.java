package com.example.quickapp.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

public class PostJSON {
    public static String sendPost(String url,String params)
    {
        PrintWriter out = null;
        BufferedReader in = null;
        StringBuilder result = new StringBuilder();
        try{
            URL realUrl = new URL(url);
            //打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            //设置通用的请求属性
            conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");//设置参数类型是json格式
            //conn.setRequestProperty("accept","zhouziming's request");
            conn.setRequestProperty("connection","Keep-Alive");
            conn.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            //发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            //获取URLConnection 对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            //发送请求参数
            out.print(params);
            //flush 输出流的缓冲
            out.flush();
            //定义BufferedReader输出流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while((line = in.readLine()) != null)
            {
                result.append("\n").append(line);
            }
        } catch (Exception e)
        {
            System.out.println("发送POST请求一场"+e);
            e.printStackTrace();
        }
        //使用finally 块来关闭输出流输入流
        finally {
            try{
                if(out != null)
                {
                    out.close();
                }
                if(in != null)
                {
                    in.close();
                }
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
        return result.toString();
    }
}
