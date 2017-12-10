package shiro;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.learn.bean.User;
import com.learn.service.LoginService;

import exception.CustomException;


public class CustomRealm extends AuthorizingRealm
{

	@Autowired
	LoginService loginservice;
	
	public void setname() {
		super.setName("customRealm");
	}
	
	//Authen 认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		
		String userCode= (String) token.getPrincipal();

		User user = null;
		try {
			user = loginservice.getPassByName(userCode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//账号不存在
		if(user==null) {
			return null;
		}
		
		
		String password = user.getPassword();

		
		SimpleAuthenticationInfo simpleAuthenticationInfo=new
                SimpleAuthenticationInfo(user,password,this.getName());
		
		return simpleAuthenticationInfo;
	}

	//Author 授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//从principals获取主身份信息
	       User user= (User) principals.getPrimaryPrincipal();

	       	//角色查询
		    List<String> roles = null;
			try {
				roles = loginservice.getRoleByName(user.getUsername());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			//权限查询
			List<String> permission = null;
			try {
				permission = loginservice.getPermissionByName(user.getUsername());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	       SimpleAuthorizationInfo Info=new SimpleAuthorizationInfo();
	       
	       //写入角色
	       if(roles != null) {
	    	   Info.addRoles(roles);
	       }
	       
	       //写入权限
	       if(permission != null) {
	    	   Info.addStringPermissions(permission);
	       }
	       return Info;

	}



}
