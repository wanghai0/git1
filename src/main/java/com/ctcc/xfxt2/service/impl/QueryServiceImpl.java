/**   
* @Title: QueryServiceImpl.java 
* @Package com.ctcc.xfxt2.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author whn
* @date 2018年7月12日 上午9:06:46 
* @version V1.0   
*/
package com.ctcc.xfxt2.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ctcc.xfxt2.dao.JhkHsMapper;
import com.ctcc.xfxt2.dao.JhkMapper;
import com.ctcc.xfxt2.dao.KsfsMapper;
import com.ctcc.xfxt2.dao.KssjMapper;
import com.ctcc.xfxt2.dao.LqkBOMapper;
import com.ctcc.xfxt2.dao.TdkMapper;
import com.ctcc.xfxt2.dao.YxdhMapper;
import com.ctcc.xfxt2.dao.ZykHsMapper;
import com.ctcc.xfxt2.dao.ZykMapper;
import com.ctcc.xfxt2.dao.ZzzszykMapper;
import com.ctcc.xfxt2.entity.Jhk;
import com.ctcc.xfxt2.entity.JhkHs;
import com.ctcc.xfxt2.entity.Ksfs;
import com.ctcc.xfxt2.entity.Kssj;
import com.ctcc.xfxt2.entity.LqkBO;
import com.ctcc.xfxt2.entity.Tdk;
import com.ctcc.xfxt2.entity.Yxdh;
import com.ctcc.xfxt2.entity.Zyk;
import com.ctcc.xfxt2.entity.ZykBO;
import com.ctcc.xfxt2.entity.ZykHs;
import com.ctcc.xfxt2.entity.Zzzszyk;
import com.ctcc.xfxt2.service.IQueryService;

/**
 * @ClassName: QueryServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author whn
 * @date 2018年7月12日 上午9:06:46
 * 
 */
@Service("queryService")
public class QueryServiceImpl implements IQueryService {

	@Resource
	private KsfsMapper ksfsMapper;

	@Resource
	private LqkBOMapper lqkBoMapper;

	@Resource
	private TdkMapper tdkMapper;

	@Resource
	private KssjMapper kssjMapper;

	@Resource
	private ZykMapper zykMapper;

	@Resource
	private YxdhMapper yxdhMapper;

	@Resource
	private JhkMapper jhkMapper;
	
	@Resource
	private ZykHsMapper zykHsMapper;
	
	@Resource
	private JhkHsMapper jhkHsMapper;
	
	@Resource
	private ZzzszykMapper zzzsZykMapper;

	// @Resource
	// private ZykBoMapper zykBoMapper;
	@Override
	public Ksfs getScore(String stuNum) {
		List<Ksfs> ksfsList = null;
		if (stuNum.length() == 14) {
			ksfsList = ksfsMapper.selectScoreByKSH(stuNum);
		}
		if (stuNum.length() == 13) {
			ksfsList = ksfsMapper.selectScoreByZKZH(stuNum);
		}
		if (ksfsList != null && ksfsList.size() > 0) {
			return ksfsList.get(0);
		}
		return null;
	}

	@Override
	public LqkBO getLqkBO(String stuNum) {
		List<LqkBO> lqkBoList = lqkBoMapper.selectLqkBoByKsh(stuNum);
		if (lqkBoList != null && lqkBoList.size() > 0) {
			return lqkBoList.get(0);
		}
		return null;
	}

	@Override
	public Tdk getReturn(String stuNum) {
		List<Tdk> tdkList = tdkMapper.selectTdkByKsh(stuNum);
		if (tdkList != null && tdkList.size() > 0) {
			return tdkList.get(0);
		}
		return null;
	}

	@Override
	public Kssj getKssj(String stuNum) {
		List<Kssj> kssjList = kssjMapper.selectKssjByKSH(stuNum);
		if (kssjList != null && kssjList.size() > 0) {
			return kssjList.get(0);
		}
		return null;
	}
	
	@Override
	public Map<String,Object> listWishZyk(String stuNum) {
		List<ZykBO> wishList_0=new ArrayList<ZykBO>();
        List<ZykBO> wishList_1=new ArrayList<ZykBO>();
        List<ZykBO> wishList_2=new ArrayList<ZykBO>();
        List<ZykBO> wishList_3=new ArrayList<ZykBO>();
        List<ZykBO> wishList_4=new ArrayList<ZykBO>();
        List<ZykBO> wishList_5=new ArrayList<ZykBO>();
        List<ZykBO> wishList_6=new ArrayList<ZykBO>();
        List<ZykBO> wishList_7=new ArrayList<ZykBO>();
        List<ZykBO> wishList_8=new ArrayList<ZykBO>();
        List<ZykBO> wishList_9=new ArrayList<ZykBO>();
        List<ZykBO> wishList_b=new ArrayList<ZykBO>();
        List<ZykBO> wishList_c=new ArrayList<ZykBO>();
        List<ZykBO> wishList_d=new ArrayList<ZykBO>();
        List<ZykBO> wishList_e=new ArrayList<ZykBO>();
        List<ZykBO> wishList_f=new ArrayList<ZykBO>();
        List<ZykBO> wishList_g=new ArrayList<ZykBO>();
        List<ZykBO> wishList_h=new ArrayList<ZykBO>();
        List<ZykBO> wishList_i=new ArrayList<ZykBO>();
        List<Zyk> zykList=findZykByKsh(stuNum);
		for(int i=0;i<zykList.size();i++){
			ZykBO zykBo=new ZykBO();
			zykBo.setKsh(stuNum);
			String pcdm=zykList.get(i).getPcdm();
			zykBo.setPcdm(pcdm);
			zykBo.setZyh(zykList.get(i).getZyh());
			String yxdh=zykList.get(i).getYxdh();
			zykBo.setYxdh(yxdh);
			Yxdh yx=findYxdhByYxdh(yxdh);
			zykBo.setYxmc(yx.getYxmc());
			String zydh1=zykList.get(i).getZydh1().trim();
			String zydh2=zykList.get(i).getZydh2().trim();
			String zydh3=zykList.get(i).getZydh3().trim();
			String zydh4=zykList.get(i).getZydh4().trim();
			String zydh5=zykList.get(i).getZydh5().trim();
			String zydh6=zykList.get(i).getZydh6().trim();
			if(zydh1!=null&&!"".equals(zydh1)){
				Jhk jhk1 = findJhkByYxdhAndZydh(yxdh,zydh1);
				zykBo.setZydh1(zydh1);
				String zymc=jhk1.getZymc();
				String zyfx=jhk1.getZyfx();
				if(zyfx!=null&&!"".equals(zyfx)){
					zykBo.setZydh1mcfx(zymc+"（-"+zydh1+"-）（"+zyfx+"）");
				}
				else{
					zykBo.setZydh1mcfx(zymc+"（-"+zydh1+"-）");
				}
			}
			if(zydh2!=null&&!"".equals(zydh2)){
				Jhk jhk2 = findJhkByYxdhAndZydh(yxdh,zydh2);
				zykBo.setZydh2(zydh2);
				String zymc=jhk2.getZymc();
				String zyfx=jhk2.getZyfx();
				if(zyfx!=null&&!"".equals(zyfx)){
					zykBo.setZydh2mcfx(zymc+"（-"+zydh2+"-）（"+zyfx+"）");
				}
				else{
					zykBo.setZydh2mcfx(zymc+"（-"+zydh2+"-）");
				}
			}
			if(zydh3!=null&&!"".equals(zydh3)){
				Jhk jhk3 = findJhkByYxdhAndZydh(yxdh,zydh3);
				zykBo.setZydh3(zydh3);
				String zymc=jhk3.getZymc();
				String zyfx=jhk3.getZyfx();
				if(zyfx!=null&&!"".equals(zyfx)){
					zykBo.setZydh3mcfx(zymc+"（-"+zydh3+"-）（"+zyfx+"）");
				}
				else{
					zykBo.setZydh3mcfx(zymc+"（-"+zydh3+"-）");
				}
			}
			if(zydh4!=null&&!"".equals(zydh4)){
				Jhk jhk4 = findJhkByYxdhAndZydh(yxdh,zydh4);
				zykBo.setZydh4(zydh4);
				String zymc=jhk4.getZymc();
				String zyfx=jhk4.getZyfx();
				if(zyfx!=null&&!"".equals(zyfx)){
					zykBo.setZydh4mcfx(zymc+"（-"+zydh4+"-）（"+zyfx+"）");
				}
				else{
					zykBo.setZydh4mcfx(zymc+"（-"+zydh4+"-）");
				}
			}
			if(zydh5!=null&&!"".equals(zydh5)){
				Jhk jhk5 = findJhkByYxdhAndZydh(yxdh,zydh5);
				zykBo.setZydh5(zydh5);
				String zymc=jhk5.getZymc();
				String zyfx=jhk5.getZyfx();
				if(zyfx!=null&&!"".equals(zyfx)){
					zykBo.setZydh5mcfx(zymc+"（-"+zydh5+"-）（"+zyfx+"）");
				}
				else{
					zykBo.setZydh5mcfx(zymc+"（-"+zydh5+"-）");
				}
			}
			if(zydh6!=null&&!"".equals(zydh6)){
				Jhk jhk6 = findJhkByYxdhAndZydh(yxdh,zydh6);
				zykBo.setZydh6(zydh6);
				String zymc=jhk6.getZymc();
				String zyfx=jhk6.getZyfx();
				if(zyfx!=null&&!"".equals(zyfx)){
					zykBo.setZydh6mcfx(zymc+"（-"+zydh6+"-）（"+zyfx+"）");
				}
				else{
					zykBo.setZydh6mcfx(zymc+"（-"+zydh6+"-）");
				}
			}
			zykBo.setZyzyfc(zykList.get(i).getZyzyfc());
			switch(pcdm){
				case "0": wishList_0.add(zykBo);break;
				case "1": wishList_1.add(zykBo);break;
				case "2": wishList_2.add(zykBo);break;
				case "3": wishList_3.add(zykBo);break;
				case "4": wishList_4.add(zykBo);break;
				case "5": wishList_5.add(zykBo);break;
				case "6": wishList_6.add(zykBo);break;
				case "7": wishList_7.add(zykBo);break;
				case "8": wishList_8.add(zykBo);break;
				case "9": wishList_9.add(zykBo);break;
				case "b": wishList_b.add(zykBo);break;
				case "c": wishList_c.add(zykBo);break;
				case "d": wishList_d.add(zykBo);break;
				case "e": wishList_e.add(zykBo);break;
				case "f": wishList_f.add(zykBo);break;
				case "g": wishList_g.add(zykBo);break;
				case "h": wishList_h.add(zykBo);break;
				case "i": wishList_i.add(zykBo);break;
			}
		}
		Map<String,Object> map=new TreeMap<String,Object>();
		if(wishList_0.size()>0){
		    map.put("wishList_0", wishList_0);
		}
		if(wishList_1.size()>0){
            map.put("wishList_1", wishList_1);
        }
		if(wishList_2.size()>0){
            map.put("wishList_2", wishList_2);
        }
		if(wishList_3.size()>0){
            map.put("wishList_3", wishList_3);
        }
		if(wishList_4.size()>0){
            map.put("wishList_4", wishList_4);
        }
		if(wishList_5.size()>0){
            map.put("wishList_5", wishList_5);
        }
		if(wishList_6.size()>0){
            map.put("wishList_6", wishList_6);
        }
		if(wishList_7.size()>0){
            map.put("wishList_7", wishList_7);
        }
		if(wishList_8.size()>0){
            map.put("wishList_8", wishList_8);
        }
		if(wishList_9.size()>0){
            map.put("wishList_9", wishList_9);
        }
		if(wishList_b.size()>0){
            map.put("wishList_b", wishList_b);
        }
		if(wishList_c.size()>0){
            map.put("wishList_c", wishList_c);
        }
		if(wishList_d.size()>0){
            map.put("wishList_d", wishList_d);
        }
		if(wishList_e.size()>0){
            map.put("wishList_e", wishList_e);
        }
		if(wishList_f.size()>0){
            map.put("wishList_f", wishList_f);
        }
		if(wishList_g.size()>0){
            map.put("wishList_g", wishList_g);
        }
		if(wishList_h.size()>0){
            map.put("wishList_h", wishList_h);
        }
		if(wishList_i.size()>0){
            map.put("wishList_i", wishList_i);
        }
		return map;
	}

	public List<Zyk> findZykByKsh(String stuNum) {
		List<Zyk> zykList = zykMapper.selectZykByKSH(stuNum);
		if (zykList != null && zykList.size() > 0) {
			return zykList;
		}
		return null;
	}

	public Yxdh findYxdhByYxdh(String yxdh) {
		List<Yxdh> yxdhList = yxdhMapper.selectYxdhByYxdh(yxdh);
		if (yxdhList != null && yxdhList.size() > 0) {
			return yxdhList.get(0);
		}
		return null;
	}

	public Jhk findJhkByYxdhAndZydh(String yxdh, String zydh) {
		List<Jhk> jhkList = jhkMapper.selectJhkByYxdhAndZydh(yxdh, zydh);
		if (jhkList != null && jhkList.size() > 0) {
			return jhkList.get(0);
		}
		return null;
	}

	@Override
    public Map<String,Object> listWishZykHs(String stuNum) {
        List<ZykBO> wishList_z=new ArrayList<ZykBO>();
        List<ZykHs> zykHsList=findZykHsByKsh(stuNum);
        for(int i=0;i<zykHsList.size();i++){
            ZykBO zykBo=new ZykBO();
            zykBo.setKsh(stuNum);
            String pcdm=zykHsList.get(i).getPcdm();
            zykBo.setPcdm(pcdm);
            zykBo.setZyh(zykHsList.get(i).getZyh());
            String yxdh=zykHsList.get(i).getYxdh();
            zykBo.setYxdh(yxdh);
            Yxdh yx=findYxdhByYxdh(yxdh);
            zykBo.setYxmc(yx.getYxmc());
            String zydh1=zykHsList.get(i).getZydh1().trim();
            String zydh2=zykHsList.get(i).getZydh2().trim();
            String zydh3=zykHsList.get(i).getZydh3().trim();
            String zydh4=zykHsList.get(i).getZydh4().trim();
            String zydh5=zykHsList.get(i).getZydh5().trim();
            String zydh6=zykHsList.get(i).getZydh6().trim();
            if(zydh1!=null&&!"".equals(zydh1)){
                JhkHs jhk1 = findJhkHsByYxdhAndZydh(yxdh,zydh1);
                zykBo.setZydh1(zydh1);
                String zymc=jhk1.getZymc();
                String zyfx=jhk1.getZyfx();
                if(zyfx!=null&&!"".equals(zyfx)){
                    zykBo.setZydh1mcfx(zymc+"（-"+zydh1+"-）（"+zyfx+"）");
                }
                else{
                    zykBo.setZydh1mcfx(zymc+"（-"+zydh1+"-）");
                }
            }
            if(zydh2!=null&&!"".equals(zydh2)){
                JhkHs jhk2 = findJhkHsByYxdhAndZydh(yxdh,zydh2);
                zykBo.setZydh2(zydh2);
                String zymc=jhk2.getZymc();
                String zyfx=jhk2.getZyfx();
                if(zyfx!=null&&!"".equals(zyfx)){
                    zykBo.setZydh2mcfx(zymc+"（-"+zydh2+"-）（"+zyfx+"）");
                }
                else{
                    zykBo.setZydh2mcfx(zymc+"（-"+zydh2+"-）");
                }
            }
            if(zydh3!=null&&!"".equals(zydh3)){
                JhkHs jhk3 = findJhkHsByYxdhAndZydh(yxdh,zydh3);
                zykBo.setZydh3(zydh3);
                String zymc=jhk3.getZymc();
                String zyfx=jhk3.getZyfx();
                if(zyfx!=null&&!"".equals(zyfx)){
                    zykBo.setZydh3mcfx(zymc+"（-"+zydh3+"-）（"+zyfx+"）");
                }
                else{
                    zykBo.setZydh3mcfx(zymc+"（-"+zydh3+"-）");
                }
            }
            if(zydh4!=null&&!"".equals(zydh4)){
                JhkHs jhk4 = findJhkHsByYxdhAndZydh(yxdh,zydh4);
                zykBo.setZydh4(zydh4);
                String zymc=jhk4.getZymc();
                String zyfx=jhk4.getZyfx();
                if(zyfx!=null&&!"".equals(zyfx)){
                    zykBo.setZydh4mcfx(zymc+"（-"+zydh4+"-）（"+zyfx+"）");
                }
                else{
                    zykBo.setZydh4mcfx(zymc+"（-"+zydh4+"-）");
                }
            }
            if(zydh5!=null&&!"".equals(zydh5)){
                JhkHs jhk5 = findJhkHsByYxdhAndZydh(yxdh,zydh5);
                zykBo.setZydh5(zydh5);
                String zymc=jhk5.getZymc();
                String zyfx=jhk5.getZyfx();
                if(zyfx!=null&&!"".equals(zyfx)){
                    zykBo.setZydh5mcfx(zymc+"（-"+zydh5+"-）（"+zyfx+"）");
                }
                else{
                    zykBo.setZydh5mcfx(zymc+"（-"+zydh5+"-）");
                }
            }
            if(zydh6!=null&&!"".equals(zydh6)){
                JhkHs jhk6 = findJhkHsByYxdhAndZydh(yxdh,zydh6);
                zykBo.setZydh6(zydh6);
                String zymc=jhk6.getZymc();
                String zyfx=jhk6.getZyfx();
                if(zyfx!=null&&!"".equals(zyfx)){
                    zykBo.setZydh6mcfx(zymc+"（-"+zydh6+"-）（"+zyfx+"）");
                }
                else{
                    zykBo.setZydh6mcfx(zymc+"（-"+zydh6+"-）");
                }
            }
            zykBo.setZyzyfc(zykHsList.get(i).getZyzyfc());
            wishList_z.add(zykBo);
        }
        Map<String,Object> map=new TreeMap<String,Object>();
        if(wishList_z.size()>0){
            map.put("wishList_z", wishList_z);
        }
        return map;
    }
	
	public List<ZykHs> findZykHsByKsh(String stuNum) {
        List<ZykHs> zykHsList = zykHsMapper.selectZykHsByKSH(stuNum);
        if (zykHsList != null && zykHsList.size() > 0) {
            return zykHsList;
        }
        return null;
    }
	
	public JhkHs findJhkHsByYxdhAndZydh(String yxdh,String zydh){
	    List<JhkHs> jhkHsList = jhkHsMapper.selectJhkHsByYxdhAndZydh(yxdh, zydh);
        if (jhkHsList != null && jhkHsList.size() > 0) {
            return jhkHsList.get(0);
        }
        return null;
	}
	
	@Override
    public Map<String,Object> listWishZzzsZyk(String stuNum) {
        List<ZykBO> wishList=new ArrayList<ZykBO>();
        List<Zzzszyk> zzzsZykList=findZzzsZykByKsh(stuNum);
        for(int i=0;i<zzzsZykList.size();i++){
            ZykBO zykBo=new ZykBO();
            zykBo.setKsh(stuNum);
//            String pcdm=zykHsList.get(i).getPcdm();
//            zykBo.setPcdm(pcdm);
//            zykBo.setZyh(zykHsList.get(i).getZyh());
            String yxdh=zzzsZykList.get(i).getYxdh();
            zykBo.setYxdh(yxdh);
            Yxdh yx=findYxdhByYxdh(yxdh);
            zykBo.setYxmc(yx.getYxmc());
            String zydh1=zzzsZykList.get(i).getZydh1().trim();
            String zydh2=zzzsZykList.get(i).getZydh2().trim();
            String zydh3=zzzsZykList.get(i).getZydh3().trim();
            String zydh4=zzzsZykList.get(i).getZydh4().trim();
            String zydh5=zzzsZykList.get(i).getZydh5().trim();
            String zydh6=zzzsZykList.get(i).getZydh6().trim();
            if(zydh1!=null&&!"".equals(zydh1)){
                Jhk jhk1 = findJhkByYxdhAndZydh(yxdh,zydh1);
                zykBo.setZydh1(zydh1);
                String zymc=jhk1.getZymc();
                String zyfx=jhk1.getZyfx();
                if(zyfx!=null&&!"".equals(zyfx)){
                    zykBo.setZydh1mcfx(zymc+"（-"+zydh1+"-）（"+zyfx+"）");
                }
                else{
                    zykBo.setZydh1mcfx(zymc+"（-"+zydh1+"-）");
                }
            }
            if(zydh2!=null&&!"".equals(zydh2)){
                Jhk jhk2 = findJhkByYxdhAndZydh(yxdh,zydh2);
                zykBo.setZydh2(zydh2);
                String zymc=jhk2.getZymc();
                String zyfx=jhk2.getZyfx();
                if(zyfx!=null&&!"".equals(zyfx)){
                    zykBo.setZydh2mcfx(zymc+"（-"+zydh2+"-）（"+zyfx+"）");
                }
                else{
                    zykBo.setZydh2mcfx(zymc+"（-"+zydh2+"-）");
                }
            }
            if(zydh3!=null&&!"".equals(zydh3)){
                Jhk jhk3 = findJhkByYxdhAndZydh(yxdh,zydh3);
                zykBo.setZydh3(zydh3);
                String zymc=jhk3.getZymc();
                String zyfx=jhk3.getZyfx();
                if(zyfx!=null&&!"".equals(zyfx)){
                    zykBo.setZydh3mcfx(zymc+"（-"+zydh3+"-）（"+zyfx+"）");
                }
                else{
                    zykBo.setZydh3mcfx(zymc+"（-"+zydh3+"-）");
                }
            }
            if(zydh4!=null&&!"".equals(zydh4)){
                Jhk jhk4 = findJhkByYxdhAndZydh(yxdh,zydh4);
                zykBo.setZydh4(zydh4);
                String zymc=jhk4.getZymc();
                String zyfx=jhk4.getZyfx();
                if(zyfx!=null&&!"".equals(zyfx)){
                    zykBo.setZydh4mcfx(zymc+"（-"+zydh4+"-）（"+zyfx+"）");
                }
                else{
                    zykBo.setZydh4mcfx(zymc+"（-"+zydh4+"-）");
                }
            }
            if(zydh5!=null&&!"".equals(zydh5)){
                Jhk jhk5 = findJhkByYxdhAndZydh(yxdh,zydh5);
                zykBo.setZydh5(zydh5);
                String zymc=jhk5.getZymc();
                String zyfx=jhk5.getZyfx();
                if(zyfx!=null&&!"".equals(zyfx)){
                    zykBo.setZydh5mcfx(zymc+"（-"+zydh5+"-）（"+zyfx+"）");
                }
                else{
                    zykBo.setZydh5mcfx(zymc+"（-"+zydh5+"-）");
                }
            }
            if(zydh6!=null&&!"".equals(zydh6)){
                Jhk jhk6 = findJhkByYxdhAndZydh(yxdh,zydh6);
                zykBo.setZydh6(zydh6);
                String zymc=jhk6.getZymc();
                String zyfx=jhk6.getZyfx();
                if(zyfx!=null&&!"".equals(zyfx)){
                    zykBo.setZydh6mcfx(zymc+"（-"+zydh6+"-）（"+zyfx+"）");
                }
                else{
                    zykBo.setZydh6mcfx(zymc+"（-"+zydh6+"-）");
                }
            }
            zykBo.setZyzyfc(zzzsZykList.get(i).getFcbj());
            wishList.add(zykBo);
        }
        Map<String,Object> map=new TreeMap<String,Object>();
        if(wishList.size()>0){
            map.put("wishList", wishList);
        }
        return map;
    }
    
    public List<Zzzszyk> findZzzsZykByKsh(String stuNum) {
        List<Zzzszyk> zzzsZykList = zzzsZykMapper.selectZzzsZykByKSH(stuNum);
        if (zzzsZykList != null && zzzsZykList.size() > 0) {
            return zzzsZykList;
        }
        return null;
    }
    
    public List<Tdk> findTdkBatch(int start ,int limit){
        List<Tdk> tdkList=tdkMapper.selectTdkBatch(start, limit);
        if (tdkList != null && tdkList.size() > 0) {
            return tdkList;
        }
        return null;
    }
    
    public List<Tdk> findTdkBatch2(){
        List<Tdk> tdkList=tdkMapper.selectTdkBatch2();
        if (tdkList != null && tdkList.size() > 0) {
            return tdkList;
        }
        return null;
    }
}
