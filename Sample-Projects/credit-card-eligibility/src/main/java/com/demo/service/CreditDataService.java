package com.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.CreditData;
import com.demo.model.UserCredit;
import com.demo.repository.CreditDataRepository;

@Service
public class CreditDataService {

	@Autowired
	CreditDataRepository creditDataRepository;
	
	public String validateCreditScore(UserCredit userCredit) {
		List<CreditData> userCreditList = creditDataRepository.getData(userCredit);

		if(Optional.ofNullable(userCreditList).isPresent() && !userCreditList.isEmpty()) {
			Boolean isValid = userCreditList.stream().anyMatch(userCreditData -> userCreditData.getCreditScore() >= 5.0);
			if(!isValid)
				return "error";
		}else {
			return "invalid";
		}
		return "success";
	}
	
	@PostConstruct
	public void insertData() throws Exception {
		
		List<CreditData> creditList = new ArrayList<CreditData>();
		
		CreditData creditData1 = new CreditData();
		creditData1.setPanCard("AXSSP1122H");
		creditData1.setCreditScore(3.10);
		
		CreditData creditData2 = new CreditData();
		creditData2.setPanCard("APPSA3355P");
		creditData2.setCreditScore(8.50);
		
		CreditData creditData3 = new CreditData();
		creditData3.setPanCard("APPXA2244X");
		creditData3.setCreditScore(9.50);
		
		CreditData creditData4 = new CreditData();
		creditData4.setPanCard("AXVPS7766V");
		creditData4.setCreditScore(1.50);
		
		CreditData creditData5 = new CreditData();
		creditData5.setPanCard("ASXPS2121S");
		creditData5.setCreditScore(5.10);
		
		creditList.add(creditData1);
		creditList.add(creditData2);
		creditList.add(creditData3);
		creditList.add(creditData4);
		creditList.add(creditData5);
		
		creditDataRepository.makePersistent(creditList);
		
	}
}
