package com.yuxy.myblog.service.article;

import java.math.BigInteger;
import java.util.List;

import com.yuxy.myblog.domain.Article;

/**
 * 文章服务接口
 * 
 * @author Yuxy
 * @version 2019年5月2日 下午12:13:18
 *
 */
public interface ArticleService {
	/**
	 * 获取所有文章
	 * 
	 * @return 所有文章的列表
	 */
	public List<Article> getAllArticles(int wordNum);
	
	/**
	 * 获取请求的文章
	 * 
	 * @param articleId 请求文章的ID
	 * @return 请求的文章的类
	 */
	public Article getArticle(BigInteger articleId);
	
	/**
	 * 获取当前用户的文章列表
	 * 
	 * @param userID 用户ID
	 * @return 当前用户的文章列表
	 */
	public List<Article> getMyArticleList(BigInteger userID);
	
	/**
	 * 添加文章(状态为edit)
	 * 
	 * @param title 文章标题
	 * @param content 文章内容
	 * @param typeID 类型ID
	 * @return 1成功
	 */
	public int addArticle(String title, String content, BigInteger typeID);
	
	/**
	 * 提交文章(状态为check)
	 * 
	 * @param title 文章标题
	 * @param content 文章内容
	 * @param typeID 类型ID
	 * @return 1成功
	 */
	public int submitArticle(String title, String content, BigInteger typeID);
	
	/**
	 * 提交已保存的文章(状态 edit -> check)
	 * 
	 * @param articleID 待提交文章ID
	 * @return 1成功
	 */
	public int submitArticle(BigInteger articleID);
	
	/**
	 * 删除指定ID的文章
	 * 
	 * @param articleID 文章ID
	 * @return 1成功
	 */
	public int deleteArticle(BigInteger articleID);
	
	/**
	 * 根据关键词查找文章
	 * 
	 * @param searchWord 搜索关键词
	 * @return 搜索的文章列表
	 */
	public List<Article> searchArticle(String searchWord);
	
	/**
	 * 获取最近发表的文章
	 * @return
	 */
	public List<Article> getRecentArticle();
}
