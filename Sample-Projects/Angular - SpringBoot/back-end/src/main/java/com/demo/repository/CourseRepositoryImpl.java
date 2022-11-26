package com.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.demo.dto.CourseDto;
import com.demo.util.CommonUtil;

public class CourseRepositoryImpl implements CourseRepositoryCustom{

	@PersistenceContext(unitName = "defaultUnit")
	private EntityManager em;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<CourseDto> getSearchData(String name, String startDate, String endDate) {
		List<CourseDto> queryResult = null;
		
		final StringBuilder queryStr = new StringBuilder("select new com.demo.dto.CourseDto(cs.id, cs.name, ctm.value, ctm.id, cs.author) from Course cs JOIN cs.courseTypeMaster ctm where 1=1 and ");
		
		if (CommonUtil.isNotEmpty(name)) {
			queryStr.append("LOWER(name) LIKE LOWER(:name)");
		}
		
		final Query query = em.createQuery(queryStr.toString());

		if (CommonUtil.isNotEmpty(name)) {
			final StringBuilder paramStr = new StringBuilder();
	         paramStr.append("%").append(name).append("%");
			query.setParameter("name", paramStr.toString());
		}
	      
	    queryResult = query.getResultList();
	      return queryResult;
	}

}
