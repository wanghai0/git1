package com.ctcc.xfxt2.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.linuxense.javadbf.DBFReader;
import com.teldev.xfxt.dbfpojo.KSFCTJ;
import com.teldev.xfxt.dbfpojo.KSFS;
import com.teldev.xfxt.dbfpojo.KSSJ;
import com.teldev.xfxt.dbfpojo.LQK;
import com.teldev.xfxt.dbfpojo.TDK;
import com.teldev.xfxt.dbfpojo.ZYK;
import com.teldev.xfxt.dbfpojo.ZYKZQ;

/* 
 * @author: 王欢
 * @功能： dbf转mysql
 * @范围： 录取库、退档库、志愿库
 */
public class TransferService {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// 读取 - 录取库
	public List<LQK> readDBF_LQK(File file) {
		List<LQK> list = new ArrayList<LQK>();
		try {
			InputStream inputStream = new FileInputStream(file);
			if (inputStream == null) {
				System.err.println("error40:" + file);
				return null;
			}
			DBFReader reader = new DBFReader(inputStream);
			reader.setCharactersetName("GBK");
			Object[] rowObjects;
			while ((rowObjects = reader.nextRecord()) != null) {
				String ksh = (String) rowObjects[0];
				if (ksh != null)
					ksh = ksh.trim();
				String xm = (String) rowObjects[1];
				if (xm != null)
					xm = xm.trim();
				String yxdh = (String) rowObjects[2];
				if (yxdh != null)
					yxdh = yxdh.trim();
				String yxmc = (String) rowObjects[3];
				if (yxmc != null)
					yxmc = yxmc.trim();
				String zydh = (String) rowObjects[4];
				if (zydh != null)
					zydh = zydh.trim();
				String zymc = (String) rowObjects[5];
				if (zymc != null)
					zymc = zymc.trim();
				String pcdm = (String) rowObjects[6];
				if (pcdm != null)
					pcdm = pcdm.trim();
				String pcmc = (String) rowObjects[7];
				if (pcmc != null)
					pcmc = pcmc.trim();
				String kldm = (String) rowObjects[8];
				if (kldm != null)
					kldm = kldm.trim();
				String klmc = (String) rowObjects[9];
				if (klmc != null)
					klmc = klmc.trim();
				String lqljzyh = (String) rowObjects[10];
				if (lqljzyh != null)
					lqljzyh = lqljzyh.trim();
				Date lqsj = (Date) rowObjects[11];
				String jhxz = (String) rowObjects[12];
				if (jhxz != null)
					jhxz = jhxz.trim();
				String jhxzmc = (String) rowObjects[13];
				if (jhxzmc != null)
					jhxzmc = jhxzmc.trim();
				String xz = (String) rowObjects[14];
				if (xz != null)
					xz = xz.trim();
				String sfsf = (String) rowObjects[15];
				if (sfsf != null)
					sfsf = sfsf.trim();
				String lqfs = (String) rowObjects[16];
				if (lqfs != null)
					lqfs = lqfs.trim();
				String lqfsmc = (String) rowObjects[17];
				if (lqfsmc != null)
					lqfsmc = lqfsmc.trim();
				String zxmc = (String) rowObjects[18];
				if (zxmc != null)
					zxmc = zxmc.trim();
				String zxdm = (String) rowObjects[19];
				if (zxdm != null)
					zxdm = zxdm.trim();
				String dqdm = (String) rowObjects[20];
				if (dqdm != null)
					dqdm = dqdm.trim();
				String dqmc = (String) rowObjects[21];
				if (dqmc != null)
					dqmc = dqmc.trim();
				String ksztmc = (String) rowObjects[22];
				if (ksztmc != null)
					ksztmc = ksztmc.trim();
				LQK lqk = new LQK();
				lqk.setKsh(ksh.trim());
				lqk.setXm(xm.trim());
				lqk.setYxdh(yxdh.trim());
				lqk.setYxmc(yxmc.trim());
				lqk.setZydh(zydh.trim());
				lqk.setZymc(zymc.trim());
				lqk.setPcdm(pcdm.trim());
				lqk.setPcmc(pcmc.trim());
				lqk.setKldm(kldm.trim());
				lqk.setKlmc(klmc.trim());
				lqk.setLqljzyh(lqljzyh.trim());
				lqk.setLqsj(lqsj);
				lqk.setJhxz(jhxz.trim());
				lqk.setJhxzmc(jhxzmc.trim());
				lqk.setXz(xz.trim());
				lqk.setSfsf(sfsf.trim());
				lqk.setLqfs(lqfs.trim());
				lqk.setLqfsmc(lqfsmc.trim());
				lqk.setZxmc(zxmc.trim());
				lqk.setZxdm(zxdm.trim());
				lqk.setDqdm(dqdm.trim());
				lqk.setDqmc(dqmc.trim());
				lqk.setKsztmc(ksztmc.trim());
				list.add(lqk);
			}
			inputStream.close();
			// setEmpty();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("error147:" + e.getMessage());
		}
		return list;
	}

	// 导入 - 录取库
	public int importLQK(File file) {
		int rowCount = 0;
		try {
			InputStream inputStream = new FileInputStream(file);
			DBFReader reader = new DBFReader(inputStream);
			reader.setCharactersetName("GBK");
			Object[] rowObjects;
			jdbcTemplate.update("truncate table lqk");
			while ((rowObjects = reader.nextRecord()) != null) {
				String sql = "";
				String ksh = (String) rowObjects[0];
				if (ksh != null)
					ksh = ksh.trim();
				String xm = (String) rowObjects[1];
				if (xm != null)
					xm = xm.trim();
				String yxdh = (String) rowObjects[2];
				if (yxdh != null)
					yxdh = yxdh.trim();
				String yxmc = (String) rowObjects[3];
				if (yxmc != null)
					yxmc = yxmc.trim();
				String zydh = (String) rowObjects[4];
				if (zydh != null)
					zydh = zydh.trim();
				String zymc = (String) rowObjects[5];
				if (zymc != null)
					zymc = zymc.trim();
				String pcdm = (String) rowObjects[6];
				if (pcdm != null)
					pcdm = pcdm.trim();
				String pcmc = (String) rowObjects[7];
				if (pcmc != null)
					pcmc = pcmc.trim();
				String kldm = (String) rowObjects[8];
				if (kldm != null)
					kldm = kldm.trim();
				String klmc = (String) rowObjects[9];
				if (klmc != null)
					klmc = klmc.trim();
				String lqljzyh = (String) rowObjects[10];
				if (lqljzyh != null)
					lqljzyh = lqljzyh.trim();
				Date lqsj = (Date) rowObjects[11];
				String jhxz = (String) rowObjects[12];
				if (jhxz != null)
					jhxz = jhxz.trim();
				String jhxzmc = (String) rowObjects[13];
				if (jhxzmc != null)
					jhxzmc = jhxzmc.trim();
				String xz = (String) rowObjects[14];
				if (xz != null)
					xz = xz.trim();
				String sfsf = (String) rowObjects[15];
				if (sfsf != null)
					sfsf = sfsf.trim();
				String lqfs = (String) rowObjects[16];
				if (lqfs != null)
					lqfs = lqfs.trim();
				String lqfsmc = (String) rowObjects[17];
				if (lqfsmc != null)
					lqfsmc = lqfsmc.trim();
				String zxmc = (String) rowObjects[18];
				if (zxmc != null)
					zxmc = zxmc.trim();
				String zxdm = (String) rowObjects[19];
				if (zxdm != null)
					zxdm = zxdm.trim();
				String dqdm = (String) rowObjects[20];
				if (dqdm != null)
					dqdm = dqdm.trim();
				String dqmc = (String) rowObjects[21];
				if (dqmc != null)
					dqmc = dqmc.trim();
				String ksztmc = (String) rowObjects[22];
				if (ksztmc != null)
					ksztmc = ksztmc.trim();
				LQK lqk = new LQK();
				lqk.setKsh(ksh.trim());
				lqk.setXm(xm.trim());
				lqk.setYxdh(yxdh.trim());
				lqk.setYxmc(yxmc.trim());
				lqk.setZydh(zydh.trim());
				lqk.setZymc(zymc.trim());
				lqk.setPcdm(pcdm.trim());
				lqk.setPcmc(pcmc.trim());
				lqk.setKldm(kldm.trim());
				lqk.setKlmc(klmc.trim());
				lqk.setLqljzyh(lqljzyh.trim());
				lqk.setLqsj(lqsj);
				lqk.setJhxz(jhxz.trim());
				lqk.setJhxzmc(jhxzmc.trim());
				lqk.setXz(xz.trim());
				lqk.setSfsf(sfsf.trim());
				lqk.setLqfs(lqfs.trim());
				lqk.setLqfsmc(lqfsmc.trim());
				lqk.setZxmc(zxmc.trim());
				lqk.setZxdm(zxdm.trim());
				lqk.setDqdm(dqdm.trim());
				lqk.setDqmc(dqmc.trim());
				lqk.setKsztmc(ksztmc.trim());

				sql = "INSERT INTO lqk(ksh,xm,yxdh,yxmc,zydh,zymc,pcdm,pcmc,kldm,klmc,lqljzyh,lqsj,jhxz,jhxzmc,xz,sfsf,lqfs,lqfsmc,zxmc,zxdm,dqdm,dqmc,ksztmc) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				jdbcTemplate
						.update(sql, new Object[] { lqk.getKsh(), lqk.getXm(),
								lqk.getYxdh(), lqk.getYxmc(), lqk.getZydh(),
								lqk.getZymc(), lqk.getPcdm(), lqk.getPcmc(),
								lqk.getKldm(), lqk.getKlmc(), lqk.getLqljzyh(),
								lqk.getLqsj(), null, null, null, null, null,
								lqk.getLqfsmc(), lqk.getZxmc(), lqk.getZxdm(),
								lqk.getDqdm(), lqk.getDqmc(), lqk.getKsztmc() });
			}
			inputStream.close();
			rowCount = reader.getRecordCount();
			// if (list == null || list.size() < 1)
			// return 0;
			// jdbcTemplate.update("truncate table lqk");
			// String sql = "";
			// for (int i = 0; i < list.size(); i++) {
			// LQK lqk = (LQK) list.get(i);
			// sql =
			// "INSERT INTO lqk(ksh,xm,yxdh,yxmc,zydh,zymc,pcdm,pcmc,kldm,klmc,lqljzyh,lqsj,jhxz,jhxzmc,xz,sfsf,lqfs,lqfsmc,zxmc,zxdm,dqdm,dqmc,ksztmc) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			// jdbcTemplate.update(sql, new Object[] { lqk.getKsh(),
			// lqk.getXm(), lqk.getYxdh(), lqk.getYxmc(),
			// lqk.getZydh(), lqk.getZymc(), lqk.getPcdm(),
			// lqk.getPcmc(), lqk.getKldm(), lqk.getKlmc(),
			// lqk.getLqljzyh(), lqk.getLqsj(), null,
			// null, null, null,
			// null, lqk.getLqfsmc(), lqk.getZxmc(),
			// lqk.getZxdm(), lqk.getDqdm(), lqk.getDqmc(),
			// lqk.getKsztmc() });
			// }
			// rowCount = list.size();
			// list = null;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		return rowCount;
	}

	// 读取 - 退档库
	public List<TDK> readDBF_TDK(File file) {
		List<TDK> list = new ArrayList<TDK>();
		try {
			InputStream inputStream = new FileInputStream(file);
			if (inputStream == null) {
				System.err.println("error304:" + file);
				return null;
			}
			DBFReader reader = new DBFReader(inputStream);
			reader.setCharactersetName("GBK");
			Object[] rowObjects;
			while ((rowObjects = reader.nextRecord()) != null) {
				// System.out.println(reader.getField(0));
				// if (!reader.getField(0).toString().equalsIgnoreCase("ksh")) {
				// throw new Exception();
				// }
				// if (!reader.getField(1).toString().equalsIgnoreCase("wcsj"))
				// {
				// throw new Exception();
				// }
				// if (!reader.getField(2).toString().equalsIgnoreCase("tddw"))
				// {
				// throw new Exception();
				// }
				// if (!reader.getField(3).toString().equalsIgnoreCase("tdyx"))
				// {
				// throw new Exception();
				// }
				// if (!reader.getField(4).toString().equalsIgnoreCase("tdsj"))
				// {
				// throw new Exception();
				// }
				// if
				// (!reader.getField(5).toString().equalsIgnoreCase("ksztmc")) {
				// throw new Exception();
				// }
				// if (!reader.getField(6).toString().equalsIgnoreCase("lqzy"))
				// {
				// throw new Exception();
				// }
				// if
				// (!reader.getField(7).toString().equalsIgnoreCase("tdyymc")) {
				// throw new Exception();
				// }
				// if (!reader.getField(8).toString().equalsIgnoreCase("bz")) {
				// throw new Exception();
				// }
				// if (!reader.getField(9).toString().equalsIgnoreCase("tdmbh"))
				// {
				// throw new Exception();
				// }
				// if (!reader.getField(10).toString().equalsIgnoreCase("tdpc"))
				// {
				// throw new Exception();
				// }
				// if (!reader.getField(11).toString().equalsIgnoreCase("tdzy"))
				// {
				// throw new Exception();
				// }
				// if (!reader.getField(12).toString().equalsIgnoreCase("kl")) {
				// throw new Exception();
				// }
				// if
				// (!reader.getField(13).toString().equalsIgnoreCase("zctddm"))
				// {
				// throw new Exception();
				// }
				// if
				// (!reader.getField(14).toString().equalsIgnoreCase("zctdmc"))
				// {
				// throw new Exception();
				// }
				// if
				// (!reader.getField(15).toString().equalsIgnoreCase("ycczsj"))
				// {
				// throw new Exception();
				// }
				// if (!reader.getField(16).toString().equalsIgnoreCase("lqfs"))
				// {
				// throw new Exception();
				// }
				// if (!reader.getField(17).toString().equalsIgnoreCase("jhxz"))
				// {
				// throw new Exception();
				// }
				String ksh = (String) rowObjects[0];
				if (ksh != null)
					ksh = ksh.trim();
				Date wcsj = (Date) rowObjects[1];
				String tddw = (String) rowObjects[2];
				if (tddw != null)
					tddw = tddw.trim();
				String tdyx = (String) rowObjects[3];
				if (tdyx != null)
					tdyx = tdyx.trim();
				Date tdsj = (Date) rowObjects[4];
				String ksztmc = (String) rowObjects[5];
				if (ksztmc != null)
					ksztmc = ksztmc.trim();
				String lqzy = (String) rowObjects[6];
				if (lqzy != null)
					lqzy = lqzy.trim();
				String tdyymc = (String) rowObjects[7];
				if (tdyymc != null)
					tdyymc = tdyymc.trim();
				String bz = (String) rowObjects[8];
				if (bz != null)
					bz = bz.trim();
				String tdmbh = (String) rowObjects[9];
				if (tdmbh != null)
					tdmbh = tdmbh.trim();
				String tdpc = (String) rowObjects[10];
				if (tdpc != null)
					tdpc = tdpc.trim();
				String tdzy = (String) rowObjects[11];
				if (tdzy != null)
					tdzy = tdzy.trim();
				String kl = (String) rowObjects[12];
				if (kl != null)
					kl = kl.trim();
				String zctddm = (String) rowObjects[13];
				if (zctddm != null)
					zctddm = zctddm.trim();
				String zctdmc = (String) rowObjects[14];
				if (zctdmc != null)
					zctdmc = zctdmc.trim();
				Date ycczsj = (Date) rowObjects[15];
				String lqfs = (String) rowObjects[16];
				if (lqfs != null)
					lqfs = lqfs.trim();
				String jhxz = (String) rowObjects[17];
				if (jhxz != null)
					jhxz = jhxz.trim();
				TDK tdk = new TDK();
				tdk.setKsh(ksh.trim());
				tdk.setWcsj(wcsj);
				tdk.setTddw(tddw.trim());
				tdk.setTdyx(tdyx.trim());
				tdk.setTdsj(tdsj);
				tdk.setKsztmc(ksztmc.trim());
				tdk.setLqzy(lqzy.trim());
				tdk.setTdyymc(tdyymc.trim());
				tdk.setBz(bz.trim());
				tdk.setTdmbh(tdmbh.trim());
				tdk.setTdpc(tdpc.trim());
				tdk.setTdzy(tdzy.trim());
				tdk.setKl(kl.trim());
				tdk.setZctddm(zctddm.trim());
				tdk.setZctdmc(zctdmc.trim());
				tdk.setYcczsj(ycczsj);
				tdk.setLqfs(lqfs.trim());
				tdk.setJhxz(jhxz.trim());
				list.add(tdk);
			}
			inputStream.close();
			// setEmpty();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("error460:" + e.getMessage());
		}
		return list;
	}

	// 导入 - 退档库
	public int importTDK(File file) {
		int rowCount = 0;
		try {
			List<TDK> list = readDBF_TDK(file);
			if (list == null || list.size() < 1)
				return 0;
			// String sql = "TRUNCATE TABLE JHK";
			jdbcTemplate.update("truncate table tdk");
			// ///////////////////////
			String sql = "";
			for (int i = 0; i < list.size(); i++) {
				TDK tdk = (TDK) list.get(i);
				sql = "INSERT INTO tdk(ksh,wcsj,tddw,tdyx,tdsj,ksztmc,lqzy,tdyymc,bz,tdmbh,tdpc,tdzy,kl,zctddm,zctdmc,ycczsj,lqfs,jhxz) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				jdbcTemplate
						.update(sql,
								new Object[] { tdk.getKsh(), tdk.getWcsj(),
										tdk.getTddw(), tdk.getTdyx(),
										tdk.getTdsj(), tdk.getKsztmc(),
										tdk.getLqzy(), tdk.getTdyymc(),
										tdk.getBz(), tdk.getTdmbh(),
										tdk.getTdpc(), tdk.getTdzy(),
										tdk.getKl(), tdk.getZctddm(),
										tdk.getZctdmc(), tdk.getYcczsj(),
										tdk.getLqfs(), tdk.getJhxz() });
			}
			rowCount = list.size();
			list = null;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		return rowCount;
	}

	// 读取 - 志愿库
	public List<ZYK> readDBF_ZYK(File file) {
		List<ZYK> list = new ArrayList<ZYK>();
		try {
			InputStream inputStream = new FileInputStream(file);
			if (inputStream == null) {
				System.err.println("error502:" + file);
				return null;
			}
			DBFReader reader = new DBFReader(inputStream);
			reader.setCharactersetName("GBK");

			Object[] rowObjects;

			while ((rowObjects = reader.nextRecord()) != null) {

				String ksh = (String) rowObjects[0];
				if (ksh != null)
					ksh = ksh.trim();
				String pcdm = (String) rowObjects[1];
				if (pcdm != null)
					pcdm = pcdm.trim();
				String kldm = (String) rowObjects[2];
				if (kldm != null)
					kldm = kldm.trim();
				String kb = (String) rowObjects[3];
				if (kb != null)
					kb = kb.trim();
				String zyh = (String) rowObjects[4];
				if (zyh != null)
					zyh = zyh.trim();
				String yxdh = (String) rowObjects[5];
				if (yxdh != null)
					yxdh = yxdh.trim();
				String zydh1 = (String) rowObjects[6];
				if (zydh1 != null)
					zydh1 = zydh1.trim();
				String zydh2 = (String) rowObjects[7];
				if (zydh2 != null)
					zydh2 = zydh2.trim();
				String zydh3 = (String) rowObjects[8];
				if (zydh3 != null)
					zydh3 = zydh3.trim();
				String zydh4 = (String) rowObjects[9];
				if (zydh4 != null)
					zydh4 = zydh4.trim();
				String zydh5 = (String) rowObjects[10];
				if (zydh5 != null)
					zydh5 = zydh5.trim();
				String zydh6 = (String) rowObjects[11];
				if (zydh6 != null)
					zydh6 = zydh6.trim();
				String zytz = (String) rowObjects[12];
				if (zytz != null)
					zytz = zytz.trim();
				String zyzyfc = (String) rowObjects[13];
				if (zyzyfc != null)
					zyzyfc = zyzyfc.trim();
				String sffhdjyq = (String) rowObjects[14];
				if (sffhdjyq != null)
					sffhdjyq = sffhdjyq.trim();
				String jgdm = (String) rowObjects[15];
				if (jgdm != null)
					jgdm = jgdm.trim();
				String bz = (String) rowObjects[16];
				if (bz != null)
					bz = bz.trim();
				String status = (String) rowObjects[17];
				if (status != null)
					status = status.trim();
				String tsdm = (String) rowObjects[18];
				if (tsdm != null)
					tsdm = tsdm.trim();
				ZYK z = new ZYK();
				z.setKsh(ksh.trim());
				z.setPcdm(pcdm.trim());
				z.setKldm(kldm.trim());
				z.setKb(kb.trim());
				z.setZyh(zyh.trim());
				z.setYxdh(yxdh.trim());
				z.setZydh1(zydh1.trim());
				z.setZydh2(zydh2.trim());
				z.setZydh3(zydh3.trim());
				z.setZydh4(zydh4.trim());
				z.setZydh5(zydh5.trim());
				z.setZydh6(zydh6.trim());
				z.setZytz(zytz.trim());
				z.setZyzyfc(zyzyfc.trim());
				z.setSffhdjyq(sffhdjyq.trim());
				z.setJgdm(jgdm.trim());
				z.setBz(bz.trim());
				z.setStatus(status.trim());
				z.setTsdm(tsdm.trim());
				list.add(z);
			}
			inputStream.close();
			// setEmpty();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("exception:" + e.getMessage());
		}
		return list;
	}

	// 导入 - 志愿库
	public int importZYK(File file) {
		int rowCount = 0;
		try {
			List<ZYK> list = readDBF_ZYK(file);
			if (list == null || list.size() < 1) {
				return 0;
			}
			// String sql = "TRUNCATE TABLE JHK";
			// jdbcTemplate.update("truncate table zyk");
			// ///////////////////////
			String sql = "";
			for (int i = 0; i < list.size(); i++) {
				ZYK z = (ZYK) list.get(i);
				sql = "INSERT INTO zyk(ksh,pcdm,kldm,kb,zyh,yxdh,zydh1,zydh2,zydh3,zydh4,zydh5,zydh6,zytz,zyzyfc,sffhdjyq,jgdm,bz,status,tsdm) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				jdbcTemplate.update(
						sql,
						new Object[] { z.getKsh(), z.getPcdm(), z.getKldm(),
								z.getKb(), z.getZyh(), z.getYxdh(),
								z.getZydh1(), z.getZydh2(), z.getZydh3(),
								z.getZydh4(), z.getZydh5(), z.getZydh6(),
								z.getZytz(), z.getZyzyfc(), z.getSffhdjyq(),
								z.getJgdm(), z.getBz(), z.getStatus(),
								z.getTsdm() });
			}
			rowCount = list.size();
			list = null;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		return rowCount;
	}

	// =========================================================================================
	// 读取 - 征求志愿库
	public List<ZYKZQ> readDBF_ZYKZQ(File file) {
		List<ZYKZQ> list = new ArrayList<ZYKZQ>();
		try {
			InputStream inputStream = new FileInputStream(file);
			if (inputStream == null) {
				System.err.println("error754:" + file);
				return null;
			}
			DBFReader reader = new DBFReader(inputStream);
			reader.setCharactersetName("GBK");
			Object[] rowObjects;
			while ((rowObjects = reader.nextRecord()) != null) {

				String ksh = (String) rowObjects[0];
				if (ksh != null)
					ksh = ksh.trim();
				String pcdm = (String) rowObjects[1];
				if (pcdm != null)
					pcdm = pcdm.trim();
				String kldm = (String) rowObjects[2];
				if (kldm != null)
					kldm = kldm.trim();
				String kb = (String) rowObjects[3];
				if (kb != null)
					kb = kb.trim();
				String zyh = (String) rowObjects[4];
				if (zyh != null)
					zyh = zyh.trim();
				String yxdh = (String) rowObjects[5];
				if (yxdh != null)
					yxdh = yxdh.trim();
				String zydh1 = (String) rowObjects[6];
				if (zydh1 != null)
					zydh1 = zydh1.trim();
				String zydh2 = (String) rowObjects[7];
				if (zydh2 != null)
					zydh2 = zydh2.trim();
				String zydh3 = (String) rowObjects[8];
				if (zydh3 != null)
					zydh3 = zydh3.trim();
				String zydh4 = (String) rowObjects[9];
				if (zydh4 != null)
					zydh4 = zydh4.trim();
				String zydh5 = (String) rowObjects[10];
				if (zydh5 != null)
					zydh5 = zydh5.trim();
				String zydh6 = (String) rowObjects[11];
				if (zydh6 != null)
					zydh6 = zydh6.trim();
				String zytz = (String) rowObjects[12];
				if (zytz != null)
					zytz = zytz.trim();
				String zyzyfc = (String) rowObjects[13];
				if (zyzyfc != null)
					zyzyfc = zyzyfc.trim();
				String sffhdjyq = (String) rowObjects[14];
				if (sffhdjyq != null)
					sffhdjyq = sffhdjyq.trim();
				String jgdm = (String) rowObjects[15];
				if (jgdm != null)
					jgdm = jgdm.trim();
				String bz = (String) rowObjects[16];
				if (bz != null)
					bz = bz.trim();
				double status = (Double) rowObjects[17];
				String digest = (String) rowObjects[18];
				if (digest != null)
					digest = digest.trim();

				// String srzh = (String) rowObjects[20];
				// if (srzh != null)
				// srzh = srzh.trim();
				//
				// String xgzh = (String) rowObjects[21];
				// if (xgzh != null)
				// xgzh = xgzh.trim();
				//

				String tsdm = (String) rowObjects[19];
				if (tsdm != null)
					tsdm = tsdm.trim();
				ZYKZQ z = new ZYKZQ();
				z.setKsh(ksh.trim());
				z.setPcdm(pcdm.trim());
				z.setKldm(kldm.trim());
				z.setKb(kb.trim());
				z.setZyh(zyh.trim());
				z.setYxdh(yxdh.trim());
				z.setZydh1(zydh1.trim());
				z.setZydh2(zydh2.trim());
				z.setZydh3(zydh3.trim());
				z.setZydh6(zydh6.trim());
				z.setZydh5(zydh5.trim());
				z.setZydh4(zydh4.trim());
				z.setZytz(zytz.trim());
				z.setZyzyfc(zyzyfc.trim());
				z.setSffhdjyq(sffhdjyq.trim());
				z.setJgdm(jgdm.trim());
				z.setBz(bz.trim());
				z.setStatus((int) status);
				z.setDigest(digest.trim());
				z.setTsdm(tsdm.trim());
				list.add(z);
			}
			inputStream.close();
			// setEmpty();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("exception:" + e.getMessage());
		}
		return list;
	}

	// 导入 - 征求志愿库
	public int importZYKZQ(File file) {
		int rowCount = 0;
		try {
			List<ZYKZQ> list = readDBF_ZYKZQ(file);
			if (list == null || list.size() < 1)
				return 0;
			// String sql = "TRUNCATE TABLE JHK";
			// jdbcTemplate.update("truncate table zyk_zq");
			// ///////////////////////14320106000381
			String sql = "";
			for (int i = 0; i < list.size(); i++) {

				ZYKZQ z = (ZYKZQ) list.get(i);
				System.out.println("tsdm=" + z.getTsdm());
				sql = "INSERT INTO zyk_zq(ksh,pcdm,kldm,kb,zyh,yxdh,zydh1,zydh2,zydh3,zydh4,zydh5,zydh6,zytz,zyzyfc,sffhdjyq,jgdm,bz,status,digest,tsdm) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				jdbcTemplate.update(
						sql,
						new Object[] { z.getKsh(), z.getPcdm(), z.getKldm(),
								z.getKb(), z.getZyh(), z.getYxdh(),
								z.getZydh1(), z.getZydh2(), z.getZydh3(),
								z.getZydh4(), z.getZydh5(), z.getZydh6(),
								z.getZytz(), z.getZyzyfc(), z.getSffhdjyq(),
								z.getJgdm(), z.getBz(), z.getStatus(),
								z.getDigest(), z.getTsdm() });
			}
			rowCount = list.size();
			list = null;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		return rowCount;
	}

	// 读取 - 考生服从调剂
	public List<KSFCTJ> readDBF_KSFCTJ(File file) {
		List<KSFCTJ> list = new ArrayList<KSFCTJ>();
		try {
			InputStream inputStream = new FileInputStream(file);
			if (inputStream == null) {
				System.err.println("error909:" + file);
				return null;
			}
			DBFReader reader = new DBFReader(inputStream);
			reader.setCharactersetName("GBK");
			Object[] rowObjects;
			while ((rowObjects = reader.nextRecord()) != null) {
				String ksh = (String) rowObjects[0];
				if (ksh != null)
					ksh = ksh.trim();
				String pcdm = (String) rowObjects[1];
				if (pcdm != null)
					pcdm = pcdm.trim();
				String kldm = (String) rowObjects[2];
				if (kldm != null)
					kldm = kldm.trim();
				String kb = (String) rowObjects[3];
				if (kb != null)
					kb = kb.trim();
				String fcyx1 = (String) rowObjects[4];
				if (fcyx1 != null)
					fcyx1 = fcyx1.trim();
				String fcyx2 = (String) rowObjects[5];
				if (fcyx2 != null)
					fcyx2 = fcyx2.trim();
				String fcyx3 = (String) rowObjects[6];
				if (fcyx3 != null)
					fcyx3 = fcyx3.trim();
				String fcyx4 = (String) rowObjects[7];
				if (fcyx4 != null)
					fcyx4 = fcyx4.trim();
				String fcyx5 = (String) rowObjects[8];
				if (fcyx5 != null)
					fcyx5 = fcyx5.trim();
				String fcyx6 = (String) rowObjects[9];
				if (fcyx6 != null)
					fcyx6 = fcyx6.trim();
				String fcyx7 = (String) rowObjects[10];
				if (fcyx7 != null)
					fcyx7 = fcyx7.trim();
				String fcyx8 = (String) rowObjects[11];
				if (fcyx8 != null)
					fcyx8 = fcyx8.trim();
				String fcyx9 = (String) rowObjects[12];
				if (fcyx9 != null)
					fcyx9 = fcyx9.trim();
				String fcyx10 = (String) rowObjects[13];
				if (fcyx10 != null)
					fcyx10 = fcyx10.trim();
				String bz = (String) rowObjects[14];
				if (bz != null)
					bz = bz.trim();
				KSFCTJ z = new KSFCTJ();
				z.setKsh(ksh.trim());
				z.setPcdm(pcdm.trim());
				z.setKldm(kldm.trim());
				z.setKb(kb.trim());
				z.setFcyx1(fcyx1);
				z.setFcyx2(fcyx2);
				z.setFcyx3(fcyx3);
				z.setFcyx4(fcyx4);
				z.setFcyx5(fcyx5);
				z.setFcyx6(fcyx6);
				z.setFcyx7(fcyx7);
				z.setFcyx8(fcyx8);
				z.setFcyx9(fcyx9);
				z.setFcyx10(fcyx10);
				z.setBz(bz);
				list.add(z);
			}
			inputStream.close();
			// setEmpty();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("exception:" + e.getMessage());
		}
		return list;
	}

	// 导入 - 考生服从调剂
	public int importKSFCTJ(File file) {
		int rowCount = 0;
		try {
			List<KSFCTJ> list = readDBF_KSFCTJ(file);
			if (list == null || list.size() < 1)
				return 0;
			String sql = "";
			for (int i = 0; i < list.size(); i++) {
				KSFCTJ z = (KSFCTJ) list.get(i);
				sql = "INSERT INTO ksfctj(ksh,pcdm,kldm,kb,fcyx1,fcyx2,fcyx3,fcyx4,fcyx5,fcyx6,fcyx7,fcyx8,fcyx9,fcyx10,bz) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				jdbcTemplate.update(
						sql,
						new Object[] { z.getKsh(), z.getPcdm(), z.getKldm(),
								z.getKb(), z.getFcyx1(), z.getFcyx2(),
								z.getFcyx3(), z.getFcyx4(), z.getFcyx5(),
								z.getFcyx6(), z.getFcyx7(), z.getFcyx8(),
								z.getFcyx9(), z.getFcyx10(), z.getBz() });
			}
			rowCount = list.size();
			list = null;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		return rowCount;
	}

	// 读取 - 考生信息库
	public List<KSSJ> readDBF_KSSJ(File file) {
		List<KSSJ> list = new ArrayList<KSSJ>();
		try {
			InputStream inputStream = new FileInputStream(file);
			if (inputStream == null) {
				System.err.println("error1021:" + file);
				return null;
			}
			DBFReader reader = new DBFReader(inputStream);
			reader.setCharactersetName("GBK");
			Object[] rowObjects;
			while ((rowObjects = reader.nextRecord()) != null) {
				String ksh = (String) rowObjects[0];
				if (ksh != null)
					ksh = ksh.trim();
				String kjh = (String) rowObjects[1];
				if (kjh != null)
					kjh = kjh.trim();
				String xm = (String) rowObjects[2];
				if (xm != null)
					xm = xm.trim();
				String zjhm = (String) rowObjects[3];
				if (zjhm != null)
					zjhm = zjhm.trim();
				KSSJ s = new KSSJ();
				s.setKsh(ksh.trim());
				s.setKjh(kjh.trim());
				s.setXm(xm.trim());
				s.setZjhm(zjhm.trim());
				list.add(s);
			}
			inputStream.close();
			// setEmpty();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("error1055:" + e.getMessage());
		}
		return list;
	}

	// 导入 - 考生信息库
	public int importKSSJ(File file) {
		int rowCount = 0;
		try {
			List<KSSJ> list = readDBF_KSSJ(file);
			if (list == null || list.size() < 1)
				return 0;
			jdbcTemplate.update("truncate table kssj");
			String sql = "";
			for (int i = 0; i < list.size(); i++) {
				KSSJ s = (KSSJ) list.get(i);
				sql = "INSERT INTO kssj(ksh,kjh,xm,zjhm) VALUES(?,?,?,?)";
				jdbcTemplate.update(sql, new Object[] { s.getKsh(), s.getKjh(),
						s.getXm(), s.getZjhm() });
			}
			rowCount = list.size();
			list = null;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		return rowCount;
	}

	// 读取 - 考生分数库
	public List<KSFS> readDBF_KSFS(File file) {
		List<KSFS> list = new ArrayList<KSFS>();
		try {
			InputStream inputStream = new FileInputStream(file);
			if (inputStream == null) {
				System.err.println("error1090:" + file);
				return null;
			}
			DBFReader reader = new DBFReader(inputStream);
			reader.setCharactersetName("GBK");
			Object[] rowObjects;
			while ((rowObjects = reader.nextRecord()) != null) {
				String kjh = (String) rowObjects[0];
				if (kjh != null)
					kjh = kjh.trim();
				String xm = (String) rowObjects[1];
				if (xm != null)
					xm = xm.trim();
				String bkkldm = (String) rowObjects[2];
				if (bkkldm != null)
					bkkldm = bkkldm.trim();
				String kmzdm = (String) rowObjects[3];
				if (kmzdm != null)
					kmzdm = kmzdm.trim();
				double km1 = (Double) rowObjects[4];
				double km2 = (Double) rowObjects[5];
				double km3 = (Double) rowObjects[6];
				double JLF_PTL = (Double) rowObjects[7];
				double JLF_TYL = (Double) rowObjects[8];
				double zgf = (Double) rowObjects[9];
				double km1fjf = (Double) rowObjects[10];
				double km2fjf = (Double) rowObjects[11];
				double TYLWHZF = (Double) rowObjects[12];
				double PTLZF = (Double) rowObjects[13];
				String XXKM4MC = (String) rowObjects[14];
				if (XXKM4MC != null)
					XXKM4MC = XXKM4MC.trim();
				String XXKM4DD = (String) rowObjects[15];
				if (XXKM4DD != null)
					XXKM4DD = XXKM4DD.trim();
				String XXKM5MC = (String) rowObjects[16];
				if (XXKM5MC != null)
					XXKM5MC = XXKM5MC.trim();
				String XXKM5DD = (String) rowObjects[17];
				if (XXKM5DD != null)
					XXKM5DD = XXKM5DD.trim();
				//del by whn 20170703
				//double QSWC = (Double) rowObjects[18];
				String KSH = (String) rowObjects[18];
				if (KSH != null)
					KSH = KSH.trim();
				String ZKZH = (String) rowObjects[19];
				if (ZKZH != null)
					ZKZH = ZKZH.trim();
				//del by whn 20170703
//				String QSWCMC = (String) rowObjects[21];
//				if (QSWCMC != null)
//					QSWCMC = QSWCMC.trim();
				// del by wanghaining 20170703
//				String TSDM = (String) rowObjects[22];
//				if (TSDM != null)
//					TSDM = TSDM.trim();
				KSFS s = new KSFS();
				s.setKjh(kjh.trim());
				s.setXm(xm.trim());
				s.setBkkldm(bkkldm.trim());
				s.setKmzdm(kmzdm.trim());
				s.setKm1((int) km1);
				s.setKm2((int) km2);
				s.setKm3((int) km3);
				s.setPtl_jlf((int) JLF_PTL);
				s.setTyl_jlf((int) JLF_TYL);
				s.setZgf((int) zgf);
				s.setKm1fjf((int) km1fjf);
				s.setKm2fjf((int) km2fjf);
				s.setTylwhzf((int) TYLWHZF);
				s.setPtlzf((int) PTLZF);
				s.setXxkm4dd(XXKM4DD);
				s.setXxkm4mc(XXKM4MC);
				s.setXxkm5dd(XXKM5DD);
				s.setXxkm5mc(XXKM5MC);
				//s.setQswc((int) QSWC);
				s.setKsh(KSH);
				s.setZkzh(ZKZH);
				//s.setQswcmc(QSWCMC);
				//s.setTsdm(TSDM);
				list.add(s);
			}
			inputStream.close();
			// setEmpty();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("error1180:" + e.getMessage());
		}
		return list;
	}

	// 导入 - 考生分数库
	public int importKSFS(File file) {
		int rowCount = 0;
		KSFS s = null;
		try {
			List<KSFS> list = readDBF_KSFS(file);
			if (list == null || list.size() < 1)
				return 0;
			jdbcTemplate.update("truncate table ksfs");
			String sql = "";

			for (int i = 0; i < list.size(); i++) {
				s = (KSFS) list.get(i);
				sql = "INSERT INTO ksfs(kjh,xm,bkkldm,kmzdm,km1,km2,km3,JLF_PTL,JLF_TYL,ZGF,KM1FJF,KM2FJF,TYLWHZF,PTLZF,XXKM4MC,XXKM4DD,XXKM5MC,XXKM5DD,KSH,ZKZH) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				jdbcTemplate.update(
						sql,
						new Object[] { s.getKjh(), s.getXm(), s.getBkkldm(),
								s.getKmzdm(), s.getKm1(), s.getKm2(),
								s.getKm3(), s.getPtl_jlf(), s.getTyl_jlf(),
								s.getZgf(), s.getKm1fjf(), s.getKm2fjf(),
								s.getTylwhzf(), s.getPtlzf(), s.getXxkm4mc(),
								s.getXxkm4dd(), s.getXxkm5mc(), s.getXxkm5dd(),
								 s.getKsh(), s.getZkzh(), });
			}
			rowCount = list.size();
			list = null;
		} catch (Exception e) {
			System.out.println("姓名----" + s.getXm() + "长度----"
					+ s.getXm().length());
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		return rowCount;
	}

	// ============================================================================================
	// 从这里触发转换
	public int doImport(String dir) {
		int rowCount = 0;
		String flag = "false";
		if (dir == null || dir.trim().length() == 0) {
			System.err.println("error:" + dir);
			return 0;
		}
		List<File> filelist = getFileList(dir);
		if (filelist == null || filelist.size() < 1)
			return 0;
		for (int i = 0; i < filelist.size(); i++) {
			File file = (File) filelist.get(i);
			String filename = file.getName();
			if (filename != null)
				filename = filename.trim();
			System.out.println("走没走---------------------------");
			System.out.println("-----------filename:" + filename);
			// /////////////////////////////////////////////
			if (filename.equalsIgnoreCase("LQK.dbf")) {//
				// 更新录取库
				System.out.println("检测到LQK.DBF");
				rowCount = importLQK(file);
			}
			if (filename.equalsIgnoreCase("TDK.dbf")) {
				// 更新退档库
				System.out.println("检测到TDK.DBF");
				rowCount = importTDK(file);
			}
			if (filename.equalsIgnoreCase("ZYK.dbf")) {
				// 更新志愿库
				System.out.println("检测到ZYK.DBF");
				rowCount = importZYK(file);
			}
			if (filename.equalsIgnoreCase("kssj.dbf")) {
				// 更新考生信息库
				System.out.println("检测到kssj.DBF");
				rowCount = importKSSJ(file);
			}
			if (filename.equalsIgnoreCase("ksfs.dbf")) {
				// 更新考生分数库
				System.out.println("检测到ksfs.DBF");
				rowCount = importKSFS(file);
			}
			if (filename.equalsIgnoreCase("zyk_zq.dbf")) {
				// 更新征求志愿库
				System.out.println("检测到zyk_zq.DBF");
				rowCount = importZYKZQ(file);
			}
			if (filename.equalsIgnoreCase("ksfctj.dbf")) {
				// 更新考生服从调剂库
				System.out.println("检测到ksfctj.DBF");
				rowCount = importKSFCTJ(file);
			} else {
				continue;
			}
		}
		return rowCount;
	}

	// 获得dbf文件列表
	private List<File> getFileList(String dir) {
		if (dir == null || dir.trim().length() == 0) {
			System.err.println("error1281:" + dir);
			return null;
		}
		List<File> list = new ArrayList<File>();
		File f = new File(dir);
		if (!f.isDirectory()) {
			System.err.println("error1287:" + dir);
			return null;
		}
		File[] fileList = f.listFiles();
		for (int i = 0; i < fileList.length; i++) {
			if (fileList[i].isDirectory()) {
				fileList[i].delete();
				continue;
			}
			list.add(fileList[i]);
		}
		return list;
	}

}
