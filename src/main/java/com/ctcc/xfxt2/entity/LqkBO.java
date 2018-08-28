/**   
* @Title: LqkBo.java 
* @Package com.ctcc.xfxt2.entity 
* @Description: TODO(用一句话描述该文件做什么) 
* @author whn
* @date 2018年7月16日 上午10:01:23 
* @version V1.0   
*/
package com.ctcc.xfxt2.entity;

/**
 * @ClassName: LqkBo
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author whn
 * @date 2018年7月16日 上午10:01:23
 * 
 */
public class LqkBO extends Lqk {

    private String zyfx;

    private Lqk lqk;

    public String getZyfx() {
        return zyfx;
    }

    public void setZyfx(String zyfx) {
        this.zyfx = zyfx;
    }

    public Lqk getLqk() {
        return lqk;
    }

    public void setLqk(Lqk lqk) {
        this.lqk = lqk;
    }

}
