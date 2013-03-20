/**
 * Autogenerated by renren-api2-generator 2013-03-13 15:27:21
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.renren.api.service;
import java.util.*;
/**
 *
 * 评论
 */
public class Comment {
	
	/**
	 * 评论的ID
	 */
	private long id;
	/**
	 * 评论的类型
	 */
	private CommentType commentType;
	/**
	 * 被评论对象的ID
	 */
	private long entryId;
	/**
	 * 评论对象所有者的ID
	 */
	private long entryOwnerId;
	/**
	 * 评论者的ID
	 */
	private long authorId;
	/**
	 * 被回复用户的ID
	 */
	private long targetUserId;
	/**
	 * 评论的内容
	 */
	private String content;
	public void setId(long id) {
		this.id = id;
	}
	public long getId() {
		return this.id;
	}
	public void setCommentType(CommentType commentType) {
		this.commentType = commentType;
	}
	public CommentType getCommentType() {
		return this.commentType;
	}
	public void setEntryId(long entryId) {
		this.entryId = entryId;
	}
	public long getEntryId() {
		return this.entryId;
	}
	public void setEntryOwnerId(long entryOwnerId) {
		this.entryOwnerId = entryOwnerId;
	}
	public long getEntryOwnerId() {
		return this.entryOwnerId;
	}
	public void setAuthorId(long authorId) {
		this.authorId = authorId;
	}
	public long getAuthorId() {
		return this.authorId;
	}
	public void setTargetUserId(long targetUserId) {
		this.targetUserId = targetUserId;
	}
	public long getTargetUserId() {
		return this.targetUserId;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getContent() {
		return this.content;
	}
}
