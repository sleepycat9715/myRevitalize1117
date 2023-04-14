package model;

import javax.persistence.*;

@Entity
@Table(name="coupon")
@NamedQuery(name="Coupon.findAll", query="SELECT s FROM Coupon s")
public class Coupon {
	
	@Id
	@Column(name="memid")
	String memid;
	Integer type01;
	Integer type02;
	Integer type03;
	Integer type04;
	Integer sum;
	public Coupon() {};
	public Coupon(String memid, Integer type01, Integer type02, Integer type03, Integer type04, Integer sum) {

		this.memid = memid;
		this.type01 = type01;
		this.type02 = type02;
		this.type03 = type03;
		this.type04 = type04;
		this.sum = sum;
	}
	public String getMemid() {
		return memid;
	}
	public void setMemid(String memid) {
		this.memid = memid;
	}
	public Integer getType01() {
		return type01;
	}
	public void setType01(Integer type01) {
		this.type01 = type01;
	}
	public Integer getType02() {
		return type02;
	}
	public void setType02(Integer type02) {
		this.type02 = type02;
	}
	public Integer getType03() {
		return type03;
	}
	public void setType03(Integer type03) {
		this.type03 = type03;
	}
	public Integer getType04() {
		return type04;
	}
	public void setType04(Integer type04) {
		this.type04 = type04;
	}
	public Integer getSum() {
		return sum;
	}
	public void setSum(Integer sum) {
		this.sum = sum;
	}
	@Override
	public String toString() {
		return "Coupon [memid=" + memid + ", type01=" + type01 + ", type02=" + type02 + ", type03=" + type03
				+ ", type04=" + type04 + ", sum=" + sum + "]";
	}
	
}
