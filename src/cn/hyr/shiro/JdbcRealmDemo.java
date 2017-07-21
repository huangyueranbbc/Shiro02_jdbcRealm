package cn.hyr.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * @category JDBCRealm
 * @author huangyueran
 *
 */
public class JdbcRealmDemo {

	public static void main(String[] args) {
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("lisi", "2222");
		try {
			subject.login(token);
			if (subject.isAuthenticated()) {
				System.out.println("登录成功");
			}
		} catch (AuthenticationException e) {
			System.out.println("验证失败");
		}
	}

}
