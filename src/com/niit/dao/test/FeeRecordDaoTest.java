package com.niit.dao.test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;


import com.niit.dao.impl.FeeRecordDao;
import com.niit.entity.FeeRecord;

public class FeeRecordDaoTest
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		FeeRecordDao feeRecordDao=new FeeRecordDao();
		
		/**
		 * �����ɷѼ�¼
		 */
//		FeeRecord feeRecord=new FeeRecord();
//		feeRecord.setIdentity("101");
//		feeRecord.setFee(200);
//		feeRecord.setPass(0);
//		feeRecord.setFeetime(new Timestamp(new Date().getTime()));
//		feeRecord.setExamtime(new Timestamp(new Date().getTime()));
//		
//		boolean flag=feeRecordDao.addFeeRecord(feeRecord);
//		System.out.println(flag?"�����ɷѼ�¼�ɹ�":"�����ɷѼ�¼ʧ��");
		
		/**
		 * �������нɷѼ�¼
		 */
//		ArrayList<FeeRecord> list=feeRecordDao.findAllFeeRecord();
//		for(FeeRecord f:list)
//		{
//			System.out.println(f.getFeeid()+"\t"+f.getIdentity()+"\t"+f.getFee()+"\t"+f.getPass()+"\t"+f.getFeetime()+"\t"+f.getExamtime());
//		}
		
		/**
		 * ����feeid���ҽɷѼ�¼
		 */
//		FeeRecord feeRecord=feeRecordDao.findFeeRecordByFeeid(2);
//		if(feeRecord==null)
//		{
//			System.out.println("�����ڸýɷѼ�¼");
//		}
//		else
//		{
//			System.out.println(feeRecord.getFeeid()+"\t"+feeRecord.getIdentity()+"\t"+feeRecord.getFee()+"\t"+feeRecord.getPass()+"\t"+feeRecord.getFeetime()+"\t"+feeRecord.getExamtime());
//		}
		
		/**
		 * ����identity���ҽɷѼ�¼�����ܷ��ض�������
		 */
//		ArrayList<FeeRecord> list=feeRecordDao.findFeeRecordByIdentity("101");
//		for(FeeRecord f:list)
//		{
//			System.out.println(f.getFeeid()+"\t"+f.getIdentity()+"\t"+f.getFee()+"\t"+f.getPass()+"\t"+f.getFeetime()+"\t"+f.getExamtime());
//		}
		
		/**
		 * �����Ƿ�ͨ������pass
		 */
//		ArrayList<FeeRecord> list=feeRecordDao.findFeeRecordByPass(1);
//		for(FeeRecord f:list)
//		{
//			System.out.println(f.getFeeid()+"\t"+f.getIdentity()+"\t"+f.getFee()+"\t"+f.getPass()+"\t"+f.getFeetime()+"\t"+f.getExamtime());
//		}
		
		/**
		 * �޸ĽɷѼ�¼
		 */
//		FeeRecord feeRecord1=feeRecordDao.findFeeRecordByFeeid(1);
//		FeeRecord feeRecord=new FeeRecord();
//		feeRecord.setFeeid(feeRecord1.getFeeid());
//		feeRecord.setIdentity(feeRecord1.getIdentity());
//		feeRecord.setFee(feeRecord1.getFee());
//		feeRecord.setPass(1);
//		feeRecord.setFeetime(feeRecord1.getFeetime());
//		feeRecord.setExamtime(new Timestamp(new Date().getTime()));
//		
//		boolean flag=feeRecordDao.modifyFeeRecord(feeRecord);
//		System.out.println(flag?"�޸ĽɷѼ�¼�ɹ�":"�޸ĽɷѼ�¼ʧ��");
		
		
		
		

	}

}
