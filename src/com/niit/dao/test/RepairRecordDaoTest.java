package com.niit.dao.test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import com.niit.dao.impl.RepairRecordDao;
import com.niit.entity.RepairRecord;

public class RepairRecordDaoTest 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		RepairRecordDao repairRecordDao=new RepairRecordDao();
		/**
		 * �������޼�¼
		 */
//		RepairRecord repairRecord=new RepairRecord();
//		repairRecord.setIdentity("101");
//		repairRecord.setRepairdetail("��");
//		repairRecord.setRepairtime(new Timestamp(new Date().getTime()));
//		repairRecord.setState(0);
//		repairRecord.setDealtime(new Timestamp(new Date().getTime()));
//		repairRecord.setEmployeeid(4);
//		boolean flag=repairRecordDao.addRepairRecord(repairRecord);
//		System.out.println(flag?"�������޼�¼�ɹ�":"�������޼�¼ʧ��");
		
		
		/**
		 * ��ѯ���б��޼�¼
		 */
//		ArrayList<RepairRecord> list=repairRecordDao.findAllRepairRecord();
//		for(RepairRecord r:list)
//		{
//			System.out.println(r.getRepairid()+"\t"+r.getIdentity()+"\t"+r.getRepairdetail()+"\t"+r.getRepairtime()+"\t"+r.getState()+"\t"+r.getDealtime()+"\t"+r.getEmployeeid());
//		}
		
		/**
		 * ���ݱ���id���ұ��޼�¼
		 */
//		RepairRecord repairRecord=repairRecordDao.findRepairRecordByRepairid(2);
//		if(repairRecord==null)
//		{
//			System.out.println("���޼�¼������");
//		}
//		else
//		{
//			System.out.println(repairRecord.getRepairid()+"\t"+repairRecord.getIdentity()+"\t"+repairRecord.getRepairdetail()+"\t"+repairRecord.getRepairtime()+"\t"+repairRecord.getState()+"\t"+repairRecord.getDealtime()+"\t"+repairRecord.getEmployeeid());
//		}
		
		/**
		 * ����״̬���ұ��޼�¼
		 */
//		ArrayList<RepairRecord> list=repairRecordDao.findRepairRecordByState(0);
//		for(RepairRecord r:list)
//		{
//			System.out.println(r.getRepairid()+"\t"+r.getIdentity()+"\t"+r.getRepairdetail()+"\t"+r.getRepairtime()+"\t"+r.getState()+"\t"+r.getDealtime()+"\t"+r.getEmployeeid());
//		}
		
		/**
		 * �޸ı��޼�¼���������޸�dealtime����ʱ�䣬state״̬��employeeidָ��Ա��id
		 */
//		RepairRecord repairRecord1=repairRecordDao.findRepairRecordByRepairid(2);
//		RepairRecord repairRecord=new RepairRecord();
//		repairRecord.setRepairid(repairRecord1.getRepairid());
//		repairRecord.setIdentity(repairRecord1.getIdentity());
//		repairRecord.setRepairdetail(repairRecord1.getRepairdetail());
//		repairRecord.setRepairtime(repairRecord1.getRepairtime());
//		repairRecord.setState(2);
//		repairRecord.setDealtime(repairRecord1.getDealtime());
//		repairRecord.setEmployeeid(2003);
//		
//		boolean flag=repairRecordDao.modifyRepairRecord(repairRecord);
//		System.out.println(flag?"�޸ı��޼�¼��ɹ�":"�޸ı��޼�¼��ʧ��");
		
		/**
		 * ����ҵ��id��identity������
		 */
//		ArrayList<RepairRecord> list=repairRecordDao.findRepairRecordByIdentity("101");
//		for(RepairRecord r:list)
//		{
//			System.out.println(r.getRepairid()+"\t"+r.getIdentity()+"\t"+r.getRepairdetail()+"\t"+r.getRepairtime()+"\t"+r.getState()+"\t"+r.getDealtime()+"\t"+r.getEmployeeid());
//		}
		
	}

}
