package com.ehualu.cms.service.topic.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ehualu.cms.dao.topic.CmsLinkDao;
import com.ehualu.cms.pojo.admin.CmsLink;
import com.ehualu.cms.service.topic.CmsLinkService;
import com.ehualu.rise.page.PageBoundsUtil;
import com.ehualu.rise.page.Pager;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

@Service("cmsLinkService")
public class CmsLinkServiceImpl implements CmsLinkService {
	private CmsLinkDao cmsLinkDao;
	
	

	public CmsLinkDao getCmsLinkDao() {
		return cmsLinkDao;
	}

	@Inject
	public void setCmsLinkDao(CmsLinkDao cmsLinkDao) {
		this.cmsLinkDao = cmsLinkDao;
	}

	@Override
	public void add(CmsLink cl) {
		cmsLinkDao.add(cl);
	}

	@Override
	public void delete(int id) {
		cmsLinkDao.delete(id);
	}

	@Override
	public void update(CmsLink cl) {
		cmsLinkDao.update(cl);
	}

	@Override
	public CmsLink load(int id) {
		return cmsLinkDao.load(id);
	}

	@Override
	public Pager<CmsLink> findByType(String type) {
		int count = cmsLinkDao.findByTypeCount(type);
		PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("pos");
		List<CmsLink> list = cmsLinkDao.findByType(type,pageBounds);
		Pager<CmsLink> pages = new Pager<CmsLink>(count,list);
		return pages;
	}

	@Override
	public List<CmsLink> listByType(String type) {
		return cmsLinkDao.listByType(type);
	}

	@Override
	public List<String> listAllType() {
		return cmsLinkDao.listAllType();
	}

	@Override
	public Map<String, Integer> getMinAndMaxPos() {
		String pos = cmsLinkDao.getMinAndMaxPos();
		if(!"".equals(pos) && null != pos){
			String objs[] = pos.split(",");
			Map<String,Integer> map = new HashMap<String,Integer>();
			map.put("max", Integer.parseInt(objs[0]));
			map.put("min", Integer.parseInt(objs[1]));
			return map;
		}
		return new HashMap<String,Integer>();
	}

	@Override
	public void updatePos(int id, int oldPos, int newPos) {
		cmsLinkDao.updatePos(id, oldPos, newPos);
	}

}
