package com.bf.action;

import java.util.List;

import javax.annotation.Resource;

import com.bf.common.Pager;
import com.bf.entity.Enterprise;
import com.bf.service.EnterpriseService;

public class EnterpriseAction extends BaseAction<Enterprise> {
	@Resource(name = "enterpriseServiceImpl")
	private EnterpriseService es;

	private Enterprise enterprise;

	public String index() {
		Pager<Enterprise> pager = es.findByPage(
				"from Enterprise en where en.flag=1", getPageNo(), PAGESIZE);
		setAttribute("pager", pager);
		return INDEX;
	}

	public String showAdd() {
		return SHOWADD;
	}

	// 新增
	public String add() {
		enterprise.setFlag(1);
		es.save(enterprise);
		return index();
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

}
