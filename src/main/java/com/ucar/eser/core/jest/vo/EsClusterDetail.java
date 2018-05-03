package com.ucar.eser.core.jest.vo;

import com.ucar.eser.core.util.exception.BusinessRuntimeException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * Description: es集群对象
 * All Rights Reserved.
 * Created on 2016-7-27 下午1:50:26
 * @author  孔增（kongzeng@zuche.com）
 */
public class EsClusterDetail {

    private static final Logger LOGGER = LoggerFactory.getLogger(EsClusterDetail.class);

    private List<Cluster> clusterList = new ArrayList<Cluster>();
    //权限信息
    private String userPass;

    private String clusterName;

    private String userName;

    private String passwd;

    private volatile List<String> urls = null;

    private boolean isByProxy = false;

    public EsClusterDetail(EsConfigDetailVo esConfig) {
        init(esConfig);
    }

    public void init(EsConfigDetailVo ev){

        clusterName = ev.getClusterName();
        isByProxy = ev.getByProxy();

        String hosts = ev.getHosts();
        Assert.notNull(hosts);
        Integer httpPort = ev.getHttp_port();
        if(httpPort == null){
            httpPort = 9200 ;
        }
        Integer tcpPort = ev.getTcp_port();
        if(tcpPort == null){
            tcpPort = 9300 ;
        }

        String[] hostArray = hosts.split(",");
        List<String> list = Arrays.asList(hostArray);
        Collections.shuffle(list);
        for(String host : list ){
            Cluster c = new Cluster();
            c.setHost(host);
            c.setHttpPort(httpPort);
            c.setTcpPort(tcpPort);
            clusterList.add(c);
        }

        loadAuthInfo(ev);

        urls = new ArrayList<String>();

        for(Cluster c:clusterList) {
            if(c != null){
                urls.add(c.getHost() + ":" + c.getHttpPort());
            }
        }
    }

    /**
     *
     * Description: 加载权限信息
     * Created on 2016-7-21 下午3:54:57
     * @author  孔增（kongzeng@zuche.com）
     * @param
     * @throws UnsupportedEncodingException
     */
    private void loadAuthInfo(EsConfigDetailVo ev) {
        String user = ev.getUser();
        String pass = ev.getPass();

        if (!StringUtils.isBlank(user) && !StringUtils.isBlank(pass)) {
            userName = user;
            passwd = pass;
            String userpass = user+":"+pass;
            try {
                userPass = Base64.encodeBase64String(userpass.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                throw new BusinessRuntimeException("es访问权限信息，加密失败", e);
            }
            return;
        }

        LOGGER.error("Not loaded into the AuthInfo,user:{},pass:{}",user,pass);
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    public List<String> getUrls(){
        return urls ;
    }

    public String getUserPass() {
        return userPass;
    }

    public List<Cluster> getClusterList() {
        return clusterList;
    }

    public void setClusterList(List<Cluster> clusterList) {
        this.clusterList = clusterList;
    }

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    public boolean isByProxy() {
        return isByProxy;
    }

    public void setByProxy(boolean byProxy) {
        isByProxy = byProxy;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}