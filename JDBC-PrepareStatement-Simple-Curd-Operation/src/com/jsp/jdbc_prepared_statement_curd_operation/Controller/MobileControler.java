package com.jsp.jdbc_prepared_statement_curd_operation.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jsp.jdbc_prepared_statement_curd_operation.dto.Mobile;
import com.jsp.jdbc_prepared_statement_curd_operation.service.MobileService;

public class MobileControler {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		
		MobileService mobileService=new  MobileService();
		
		Mobile mobile=new Mobile();
		
		while(true)
		{
			System.out.println("1.Insert\n2.Update\n3.Delete\n4.Diaplay\n5.InsertExecuteAddBach\n6.Exit");
			
			System.out.println("Enter your Choice");
			
			int ch=scanner.nextInt();
			
			switch(ch)
			{
			case 1:
			{
				mobile=new Mobile();
				System.out.println("Enter the mobile");
				mobile.setMobileId(scanner.nextInt());
				
				System.out.println("Enter the mobileName");
				mobile.setMobileName(scanner.next());
				
				System.out.println("Enter the Mobilemodel");
				mobile.setMobileModel(scanner.next());
				
				System.out.println("Enter the MobilePrice");
				mobile.setMobilePrice(scanner.nextDouble());
				
				mobileService.insertMobile(mobile);
			}break;
			case 2:{
				   System.out.println("Enter the mobile id you want to update...");
				   int mobileId=scanner.nextInt();
				   System.out.println("Enter the mobileName");
				   String mobileName=scanner.next();
				   System.out.println("Enter the mobileModel");
				   String mobileModel=scanner.next();
				   
				   mobileService.update(mobileId, mobileName, mobileModel);
				   System.out.println("Data ... Update.....");
			}break;
			
			case 3:
			{
				System.out.println("Pelease enter the id you want to delete");
				int id=scanner.nextInt();
				mobileService.delete(id);
				//System.out.println("Data has been delete successfully..");
			}break;
			
			case 4:{
				List<Mobile> mobiles=mobileService.getAllMobile();
				
				for (Mobile mobile2 : mobiles) {
					
					System.out.println("MobileId ="+mobile2.getMobileId());
					System.out.println("MobileName ="+mobile2.getMobileName());
					System.out.println("MobilePrice ="+mobile2.getMobilePrice());
					System.out.println("MobileModel ="+mobile2.getMobileModel());
					System.out.println("========================================");
					
				}
			}break;
			case 5:
			{
			    List<Mobile> mobiles=new ArrayList<Mobile>();
			    
			    System.out.println("How many mobile you whant to insert...");
			    int size=scanner.nextInt();
			    
			    for(int i=1;i<=size;i++)
			    {
			    	Mobile mobile2=new Mobile();
			    	
			    	System.out.println("Enter the mobile "+i+" id");
			    	mobile2.setMobileId(scanner.nextInt());
			    	
			    	System.out.println("Enter the mobile "+i+" Name");
			    	String name=scanner.next();
			    	
			    	name=scanner.nextLine();
			    	mobile2.setMobileName(name);
			    	
			    	System.out.println("Enter the mobile "+i+"  Model");
			    	  mobile2.setMobileModel(scanner.next());
			    	
			    	System.out.println("Enter the mobile "+i+"  PRICE");
			    	mobile2.setMobilePrice(scanner.nextDouble());
			    	
			    	mobiles.add(mobile2);
			    }
			    mobileService.insertMobileExecution(mobiles);
				
				
			}break;
			case 6:{
				
				System.exit(1);
				
			}break;
			default:{
				System.out.println("Invalid-choice");
			}
			}
		}
	}
}
