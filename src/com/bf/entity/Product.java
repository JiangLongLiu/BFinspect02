package com.bf.entity;

/**
 * 
 * 产品类
 * ============================================================================
 * 版权所有 2010-2013 北方网有限公司，并保留所有权利。
 * ----------------------------------------------------------------------------
 * 提示：在未取得北方网授权之前，您不能将本软件应用于商业用途，否则北方网将保留追究的权力。
 * ----------------------------------------------------------------------------
 * 官方网站：http://www.ibeifeng.com/
 * ----------------------------------------------------------------------------
 * ============================================================================
 */
public class Product extends BaseEntity {
	private Integer id;
	private String name;
	private int attestation;// 认证 (0表示没有认证1表示已经认证)
	private int validate;// 验证 (0表示没有验证1表示已经验证)
	private int reddereIus;// 执法(0表示没有执法1表示已经执法)
	private int flag;
	private Enterprise enterprise; //多对一 关系
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAttestation() {
		return attestation;
	}

	public void setAttestation(int attestation) {
		this.attestation = attestation;
	}

	public int getValidate() {
		return validate;
	}

	public void setValidate(int validate) {
		this.validate = validate;
	}

	public int getReddereIus() {
		return reddereIus;
	}

	public void setReddereIus(int reddereIus) {
		this.reddereIus = reddereIus;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}
    
	
}
