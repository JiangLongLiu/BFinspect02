package com.bf.action;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bf.common.Pager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * 通用的Action
 * ============================================================================
 * 版权所有 2010-2013 北方网有限公司，并保留所有权利。
 * ----------------------------------------------------------------------------
 * 提示：在未取得北方网授权之前，您不能将本软件应用于商业用途，否则北方网将保留追究的权力。
 * ----------------------------------------------------------------------------
 * 官方网站：http://www.ibeifeng.com/
 * ----------------------------------------------------------------------------
 * ============================================================================
 */
public class BaseAction<T> extends ActionSupport {
	public static final String SUCCESS = "success";
	public static final String ERROR = "error";
	public static final String INDEX = "index";
	public static final String FINDBYPAGE = "findByPage";
	public static final String LIST = "list";
	public static final String SHOWADD = "showAdd";
	public static final String SHOWUPDATE = "showUpdate";
	public static final int PAGESIZE = 3;
	private int pageNo = 0;
	protected Pager<T> pager;
	protected Integer id;
	protected Integer[] ids;
	
	public String getParameter(String str) {
		return ServletActionContext.getRequest().getParameter(str);
	}
	
	public void setAttribute(String key,Object value) {
		ServletActionContext.getRequest().setAttribute(key, value);
	}
	
	public Object getAttribute(String key) {
		return ServletActionContext.getRequest().getAttribute(key);
	}
	
	
	
	public HttpSession getSession() {
		return ServletActionContext.getRequest().getSession();
	}
	
	public HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	
	
	public Pager<T> getPager() {
		return pager;
	}

	public void setPager(Pager<T> pager) {
		this.pager = pager;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

	public int getPageNo() {
		String str_pageNo = getParameter("pager.offset");
		if (str_pageNo != null) {
			pageNo = Integer.parseInt(str_pageNo);
		}
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	

}
