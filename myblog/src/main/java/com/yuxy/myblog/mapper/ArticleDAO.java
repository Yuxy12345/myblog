package com.yuxy.myblog.mapper;

import java.math.BigInteger;
import java.util.List;

import com.yuxy.myblog.domain.Article;

/**
 * 文章DAO接口
 * 
 * @author Yuxy
 * @version 2019年5月2日 上午11:32:17
 *
 */
public interface ArticleDAO {

	/**
	 * 获取所有文章
	 * 
	 * @param wordNum 内容摘要的长度
	 * @return 所有文章的列表
	 */
	public List<Article> getAllArticles(int wordNum);
	
	/**
	 * 获取当前用户的文章列表
	 * 
	 * @return 当前用户的文章列表
	 */
	public List<Article> getMyArticleList(BigInteger userID);

	/**
	 * 获取指定ID的文章
	 * 
	 * @param articleID 文章ID
	 * @return 指定文章的详细信息
	 */
	public Article getArticle(BigInteger articleID);

	/**
	 * 添加文章
	 * 
	 * @param title 标题
	 * @param userID 用户ID
	 * @param content 内容
	 * @param typeID 类型ID
	 * @param abbr 英文名
	 * @return 1成功，0失败
	 */
	public int addArticle(Article article);
	
	/**
	 * 提交文章
	 * 
	 * @param articleID 文章ID
	 * @return 1成功
	 */
	public int submitArticle(BigInteger articleID);
	
	/**
	 * 删除文章
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
