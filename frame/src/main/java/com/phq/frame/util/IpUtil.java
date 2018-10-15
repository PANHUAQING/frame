package com.phq.frame.util;


import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
/**
 * 
* @ClassName: IpUtil
* @Description: 
*    ip 工具类
* @author panhuaqing
* @date 2018年10月12日
*
 */
public class IpUtil {
    public static volatile String IP_SINA_API_URL = "http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=json&ip=";
    private static List<InetAddress> localAddressList;

    public IpUtil() {
    }

    public static String getLocalIP() {
        return getLocalIP(false);
    }

    public static String getLocalIP(boolean isInter) {
        if(localAddressList == null) {
            localAddressList = getLocalAddresses();
        }

        String localIP = "";
        Iterator i$ = localAddressList.iterator();

        while(i$.hasNext()) {
            InetAddress ia = (InetAddress)i$.next();
            String ip = ia.getHostAddress();
            if(!(ia instanceof Inet6Address) && !ip.startsWith("127")) {
                if(StringUtils.isNotEmpty(localIP)) {
                    localIP = ip;
                }

                if(isInter && ip.startsWith("19.")) {
                    return ip;
                }

                if(!isInter && !ip.startsWith("19.")) {
                    return ip;
                }
            }
        }

        return localIP;
    }

    public static List<InetAddress> getLocalAddresses() {
        if(localAddressList == null) {
            localAddressList = new ArrayList();

            try {
                Enumeration e = NetworkInterface.getNetworkInterfaces();

                while(e != null && e.hasMoreElements()) {
                    NetworkInterface interfaceN = (NetworkInterface)e.nextElement();
                    Enumeration ienum = interfaceN.getInetAddresses();

                    while(ienum.hasMoreElements()) {
                        InetAddress ia = (InetAddress)ienum.nextElement();
                        localAddressList.add(ia);
                    }
                }
            } catch (Exception var4) {
                var4.printStackTrace();
            }
        }

        return localAddressList;
    }

	public static String getUserIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }

        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Cdn-Src-Ip");
        }

        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }

        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }

        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        if(ip.indexOf(",") > -1) {
            ip = ip.substring(0, ip.indexOf(","));
        }

        return ip;
    }
}

