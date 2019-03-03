package com.phq.frame.domain.master;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.phq.frame.common.domain.PageModel;

public class SysUser extends PageModel implements UserDetails {
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String loginname;

    private String name;

    private String password;

    private Integer sex;

    private Integer age;

    private String phone;
    private String wechat;

    private Integer usertype;

    private Integer status;

    private Integer orgId;

    private Date createdate;

    private Integer seq;
	
	private List<SysRole> roles;
	
	private String roleName; //角色
	
	private String strCreatedate;//创建时间
	
	
	private String ids;//删除时多个id集合

	
	
	
	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getStrCreatedate() {
		return strCreatedate;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public void setStrCreatedate(String strCreatedate) {
		this.strCreatedate = strCreatedate;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getUsertype() {
		return usertype;
	}

	public void setUsertype(Integer usertype) {
		this.usertype = usertype;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public List<SysRole> getRoles() {
		return roles;
	}

	public void setRoles(List<SysRole> roles) {
		this.roles = roles;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> GrantedAuthorities = new HashSet<GrantedAuthority>();
		if (roles != null){
			for (SysRole role : roles){
				//添加角色
				GrantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
				
				/*List<Right> rights = role.getRights();
				if (rights != null){
					for (Right right : rights){
						//添加权限
						GrantedAuthorities.add(new SimpleGrantedAuthority("RIGHT_" + right.getName()));
					}
				}*/
			}
		}
		return GrantedAuthorities;
	}

	@Override
	public String getUsername() {
		return loginname;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}


  
	
}
