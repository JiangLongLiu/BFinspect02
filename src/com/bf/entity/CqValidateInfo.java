package com.bf.entity;

/**
 * 
 * 验证类
 * ============================================================================
 * 版权所有 2010-2013 北方网有限公司，并保留所有权利。
 * ----------------------------------------------------------------------------
 * 提示：在未取得北方网授权之前，您不能将本软件应用于商业用途，否则北方网将保留追究的权力。
 * ----------------------------------------------------------------------------
 * 官方网站：http://www.ibeifeng.com/
 * ----------------------------------------------------------------------------
 * ============================================================================
 */
public class CqValidateInfo extends BaseEntity {
	private Integer id;
	private int validateNo;// 验证报告编号
	private String validateUserName;// 验证人姓名
	private Product product;
	private int flag;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getValidateNo() {
		return validateNo;
	}

	public void setValidateNo(int validateNo) {
		this.validateNo = validateNo;
	}

	public String getValidateUserName() {
		return validateUserName;
	}

	public void setValidateUserName(String validateUserName) {
		this.validateUserName = validateUserName;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	

}
