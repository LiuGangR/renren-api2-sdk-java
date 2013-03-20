/**
 * Autogenerated by renren-api2-generator 2013-03-13 15:27:21
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.renren.api.service;

import java.io.File;
import java.util.*;

import com.renren.api.AccessToken;
import com.renren.api.ObjectMappingException;
import com.renren.api.RennException;
import com.renren.api.RennExecutor;
import com.renren.api.RennParam;
import com.renren.api.RennRequest;
import com.renren.api.RennRequest.Method;
import com.renren.api.RennResponse;
import com.renren.api.mapper.JsonMappingException;
import com.renren.api.mapper.ObjectMapper;

public class CommentService {
	private RennExecutor executor;

    private AccessToken token;

    private ObjectMapper mapper;
	
    /**
     * @param executor
     * @param token
     * @param mapper
     */
    public CommentService(RennExecutor executor, AccessToken token, ObjectMapper mapper) {
        super();
        this.executor = executor;
        this.token = token;
        this.mapper = mapper;
    }

    /**
     * 以分页的方式获取某个UGC的评论
     * @param ugcOwnerId 
     * @param ugcId 
     * @param ugcType 
     * @return Comment 评论
     * @throws   RennException 
     * INVALID_UGCID entryId不合法。 
     * UGCOWNER_NOT_EXIST UGC所有者不存在。 
     * INVALID_UGCOWNERID entryOwnerId不合法。 
     * UGC_NOT_EXIST UGC不存在。 
     * INVALID_UGCTYPE commentType不合法。 
     */
    public Comment [] listComment (Long  ugcOwnerId, Long  ugcId, CommentType  ugcType) throws RennException {
        Map<String, String> textParams = new HashMap<String, String>();
        textParams.put("ugcOwnerId", RennParam.asString(ugcOwnerId));
        textParams.put("ugcId", RennParam.asString(ugcId));
        textParams.put("ugcType", RennParam.asString(ugcType));
        Map<String, String> bodyParams = new HashMap<String, String>();
        Map<String, File> fileParams = new HashMap<String, File>();
        RennRequest request = new RennRequest("/v2/comment/list", Method.GET, textParams, bodyParams, fileParams, token);
        RennResponse response = executor.execute(request);
        try {
            return (Comment [])mapper.mapCommon(response.getResponse().toString(), Comment.class);
        } catch (JsonMappingException e) {
            throw new ObjectMappingException();
        }
    }
}
