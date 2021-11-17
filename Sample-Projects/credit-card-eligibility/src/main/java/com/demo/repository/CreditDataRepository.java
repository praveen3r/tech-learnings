package com.demo.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.demo.entity.CreditData;
import com.demo.model.UserCredit;

@Repository
public class CreditDataRepository extends BaseRepositoryDAO<CreditData , Serializable>{

	public List<CreditData> getData(UserCredit userCredit){
		List<CreditData> userList = new ArrayList<>();
		try {
			Criterion criterion = Restrictions.eq("panCard", userCredit.getCardNo());
			userList = findByCriteria(criterion);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}
}
