package com.ucar.eser.core.jest.vo;

import com.ucar.eser.core.jest.common.EsVoEnum.*;

import java.io.Serializable;

/**
 *
 * Description: 增删改返回结果VO
 * All Rights Reserved.
 * Created on 2016-8-11 下午1:37:39
 * @author  孔增（kongzeng@zuche.com）
 */
public class CrdResultDetailVo implements Serializable {
    //执行结果
    private boolean isSuccess = false;
    //操作类型
    private OperateTypeEnum operateType;

    private String index;

    private String type;

    private String id;
    //原始json串
    private String jsonString;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getJsonString() {
        return jsonString;
    }

    public void setJsonString(String jsonString) {
        this.jsonString = jsonString;
    }

    public OperateTypeEnum getOperateType() {
        return operateType;
    }

    public void setOperateType(OperateTypeEnum operateType) {
        this.operateType = operateType;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
