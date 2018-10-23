package com.crm.data;

public class Constant {

	static String sSqltransaction_id;
	static String sSqlTransaction;
	static String sSqlQueryCustomer;
	static String sSqlFDXQueryCustomer;
	static String sSqlFDXQueryCustomerWizard;

	public static String getsSqltransaction_id() {
		setsSqltransaction_id();
		//System.out.println(sSqltransaction_id);
		return sSqltransaction_id;
	}

	public static String getsSqlQueryCustomer() {
		setsSqlQueryCustomer();
		//System.out.println(sSqlQueryCustomer);
		return sSqlQueryCustomer;
	}

	public static String getsSqlTransaction() {
		setsSqlTransaction();
		//System.out.println(sSqlTransaction);
		return sSqlTransaction;
	}
	
	public static String getSqlFDXQueryCustomer() {
		setsSqlFDXQueryCustomer();
		//System.out.println(sSqlFDXQueryCustomer);
		return sSqlFDXQueryCustomer;
	}
	
	public static String getSqlFDXQueryCustomerWizard() {
		setsSqlFDXQueryCustomerWizard();
		System.out.println(sSqlFDXQueryCustomerWizard);
		return sSqlFDXQueryCustomerWizard;
	}

	public static void setsSqltransaction_id() {
		sSqltransaction_id = "Select x.transaction_id from   eai_reporting_data x , eai_reporting_info t "
				+ " where  x.transaction_id = t.transaction_id and    x.entry_datetime > trunc (sysdate)"
				+ " and x.service_name = 'SendInvoice' and    x.App_Src = 'CRM' and    x.message like '%XXXXXX%' "
				+ "order by x.entry_datetime desc";
	}

	public static void setsSqlTransaction() {
		sSqlTransaction = "select x.transaction_id,x.app_src,x.app_dest,x.eai_return_desc,x.app_return_desc  "
				+ "from eai_reporting_data x where x.transaction_id = 'TTTTTT'  order by x.entry_datetime desc";
	}

	//שאילתא לביצוע שליחות פדקס - שליפת מספר אתר
	public static void setsSqlQueryCustomer() {
		sSqlQueryCustomer = "Select  ACCOUNT_NUMBER from  wiz_customer_hp_sub_account tv where   tv.sub_account_number = 1 and "
				+ "tv.sub_account_status = 'AC' and     tv.branch_account_number = 0 and not exists"
				+ " (select  1 from   wiz_work_order w where  w.account_number = tv.account_number) and "
				+ "exists (select 1 from    wiz_customer_hp_life l  where   l.account_number = tv.account_number and  l.customer_type = 'REG') "
				+ "and exists ( select  1  from   wiz_equip e where  e.account_number = tv.account_number and    e.account_number <> 0  and    e.outlet_location <> ' ') "
				+ "and rownum < 3 "
				+ " ORDER BY DBMS_RANDOM.VALUE";

	}
	
	
	//שאילתא לוידואי הכנסת פקע  פדקס למסד נתונים
	public static void setsSqlFDXQueryCustomer() {
		sSqlFDXQueryCustomer = "Select x.message from eai_reporting_data x , eai_reporting_info t "
				+ "where  x.transaction_id = t.transaction_id and x.entry_datetime > trunc (sysdate) and  x.service_name = 'SetWOTask' and  x.app_src = 'CRM'"
				+ " and    x.message like '%FFFFFFFF%'"
				+ " order by x.entry_datetime desc";

	}
	
	// Wizard שאילתא לוידואי הכנסת פקע  ב
	public static void setsSqlFDXQueryCustomerWizard() {
		sSqlFDXQueryCustomerWizard = "select * from wiz_wo_tasks p , wiz_work_order o "
				+ "where p.work_order_number = o.work_order_number and o.account_number = WWWWWWWW"
				+ " and p.curr_sched_time_beg =  '900' "
				+ "and p.guaranteed_time =  '1200' and p.curr_sched_date >= trunc (sysdate)";
		
		 
	}
	
	


}
