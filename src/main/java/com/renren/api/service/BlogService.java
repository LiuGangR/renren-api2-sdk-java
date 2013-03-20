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

public class BlogService {
	private RennExecutor executor;

    private AccessToken token;

    private ObjectMapper mapper;
	
    /**
     * @param executor
     * @param token
     * @param mapper
     */
    public BlogService(RennExecutor executor, AccessToken token, ObjectMapper mapper) {
        super();
        this.executor = executor;
        this.token = token;
        this.mapper = mapper;
    }

    /**
     * 以分页的方式获取某个用户的日志列表
     * @param ownerId 日志所有者的ID
     * @param pageSize 页面大小。取值范围1-200，默认大小20
     * @param pageNumber 页码。取值大于零，默认值为1
     * @return Blog 日志
     * @throws   RennException 
     * PAGESIZE_NOT_IN_RANGE 页面大小不在1-200范围内。 
     * PAGE_NUMBER_MUST_LARGER_0 页码必须大于0。 
     */
    public Blog [] listBlog (Long  ownerId, Integer  pageSize, Integer  pageNumber) throws RennException {
        Map<String, String> textParams = new HashMap<String, String>();
        textParams.put("ownerId", RennParam.asString(ownerId));
        if (pageSize != null) {
            textParams.put("pageSize", RennParam.asString(pageSize));
        }
        if (pageNumber != null) {
            textParams.put("pageNumber", RennParam.asString(pageNumber));
        }
        Map<String, String> bodyParams = new HashMap<String, String>();
        Map<String, File> fileParams = new HashMap<String, File>();
        RennRequest request = new RennRequest("/v2/blog/list", Method.GET, textParams, bodyParams, fileParams, token);
        RennResponse response = executor.execute(request);
        try {
            return (Blog [])mapper.mapCommon(response.getResponse().toString(), Blog.class);
        } catch (JsonMappingException e) {
            throw new ObjectMappingException();
        }
    }
    /**
     * 创建一个日志
     * @param title 日志的标题
     * @param accessControl 日志的访问控制
     * @param password 日志的访问控制
     * @param content 日志的内容
     * @return Blog 日志
     * @throws   RennException 
     * FAST_RATE_SAME_CONTENT 请您不要频繁发布相同内容的日志。 
     * BLOG_PASSWORD_ILLAGE 日志密码不合法，设定的访问密码中可能包含非法字符或汉字，或位数不在1-16范围内，请修改后重试。 
     * FAST_RATE_PUBLISH 请您不要频繁发布日志。 
     * BLOG_TOO_LONG 日志内容不能长于120000个字符。 
     * BLOG_TITLE_NOT_NULL 日志标题不能为空。 
     * BLOG_PROHIBITED 抱歉，某些信息不能发布的哦：）谢谢您的谅解。 
     * BLOG_TITLE_TOO_LONG 日志标题不能长于100个字符。 
     * BLOG_NOT_NULL 日志内容不能为空。 
     * FAST_RATE_COUNT 发布日志过于频繁，请稍后再试。 
     * SAME_CONTENT 请您不要频繁发布相同内容的日志。 
     */
    public Blog putBlog (String  title, AccessControl  accessControl, String  password, String content) throws RennException {
        Map<String, String> textParams = new HashMap<String, String>();
        textParams.put("title", title);
        if (accessControl != null) {
            textParams.put("accessControl", RennParam.asString(accessControl));
        }
        if (password != null) {
	    textParams.put("password", password);
        }
        Map<String, String> bodyParams = new HashMap<String, String>();
        bodyParams.put("content", content);
        Map<String, File> fileParams = new HashMap<String, File>();
        RennRequest request = new RennRequest("/v2/blog/put", Method.POST, textParams, bodyParams, fileParams, token);
        RennResponse response = executor.execute(request);
        try {
            return (Blog)mapper.mapCommon(response.getResponse().toString(), Blog.class);
        } catch (JsonMappingException e) {
            throw new ObjectMappingException();
        }
    }
    /**
     * 获取某个用户的某个日志
     * @param ownerId 日志所有者的ID
     * @param blogId 日志的ID
     * @param password 日志访问密码
     * @return Blog 日志
     * @throws   RennException 
     * ERROR_PASSWORD 密码错误。 
     * BLOG_NOT_EXIST 日志不存在。 
     * NO_RIGHT 没有获取此日志的权限。 
     */
    public Blog getBlog (Long  ownerId, Long  blogId, String  password) throws RennException {
        Map<String, String> textParams = new HashMap<String, String>();
        textParams.put("ownerId", RennParam.asString(ownerId));
        textParams.put("blogId", RennParam.asString(blogId));
        if (password != null) {
	    textParams.put("password", password);
        }
        Map<String, String> bodyParams = new HashMap<String, String>();
        Map<String, File> fileParams = new HashMap<String, File>();
        RennRequest request = new RennRequest("/v2/blog/get", Method.GET, textParams, bodyParams, fileParams, token);
        RennResponse response = executor.execute(request);
        try {
            return (Blog)mapper.mapCommon(response.getResponse().toString(), Blog.class);
        } catch (JsonMappingException e) {
            throw new ObjectMappingException();
        }
    }
}
