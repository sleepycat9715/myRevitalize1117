package model;

import javax.persistence.*;

@Entity
@Table(name="member")
@NamedQuery(name="Member.findAll", query="SELECT s FROM Member s")
public class Member {
	//field
	@Id
	@Column(name="sid")
	String sid;
	String sname;
	String password;
	String email;
	String cell;
	public Member() {}
	public Member(String sid, String sname, String password, String email, String cell) {

		this.sid = sid;
		this.sname = sname;
		this.password = password;
		this.email = email;
		this.cell = cell;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCell() {
		return cell;
	}
	public void setCell(String cell) {
		this.cell = cell;
	}
	@Override
	public String toString() {
		return "member [sid=" + sid + ", sname=" + sname + ", password=" + password + ", email=" + email + ", cell="
				+ cell + "]";
	}

}
