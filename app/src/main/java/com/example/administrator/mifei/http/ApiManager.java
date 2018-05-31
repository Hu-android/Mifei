package com.example.administrator.mifei.http;

/**
 * Created by Administrator on 2018/3/29 0029.
 */

public class ApiManager {

    private static final String HTTP = "http://";
    private static final String IP = "120.79.191.17:";
    private static final String PROT = "80";
    private static final String HOST = HTTP + IP + PROT;
    private static final String API = "/api";
    private static final String USER = "/user";


    public static final String LOGIN = HOST+API+USER+"/login";

}
