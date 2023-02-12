package com.jsp.jdbc_prepared_statement_curd_operation.service;

import java.util.List;

import com.jsp.jdbc_prepared_statement_curd_operation.dao.MobileDao;
import com.jsp.jdbc_prepared_statement_curd_operation.dto.Mobile;

public class MobileService {
       
	MobileDao mobileDao=new MobileDao();
	
	public void insertMobile(Mobile mobile)
	{
		mobileDao.insertMobile(mobile);
	}
	
	public void update(int mobileId, String mobileName, String mobileModel)
	{
		if(mobileDao.getById(mobileId)==mobileId)
		{
			System.out.println("Updation is in process");
			mobileDao.update(mobileId, mobileName, mobileModel);
		}else {
			System.out.println("provided id is not present");
		}
	}
	
	public void delete(int id)
	{
		int tempId= mobileDao.getById(id);
		if(tempId==id)
		{
			//System.out.println("Deletion is process");
			mobileDao.delete(tempId);
		}else {
			System.out.println("Provided id is not present");
		}
	  	
	}
	
	public List<Mobile> getAllMobile()
	{
		return mobileDao.getAllMobile();
		
	}
	//addBatch and Excquet Batch
    public void insertMobileExecution(List<Mobile> mobiles)
    {
	   
    	mobileDao.insertMobileExecution(mobiles);
	}
}
