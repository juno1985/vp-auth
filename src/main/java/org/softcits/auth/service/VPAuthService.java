package org.softcits.auth.service;

import java.security.NoSuchAlgorithmException;
import java.util.Date;

import org.softcits.auth.mapper.MbgUserMapper;
import org.softcits.auth.model.MbgUser;
import org.softcits.utils.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(value = "transactionManager", rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, timeout = 300)
@Service
public class VPAuthService {
	
	@Autowired
	private MbgUserMapper mbgUserMapper;

	public void addUser(String username, String password) throws NoSuchAlgorithmException {
		
		MbgUser mbgUser = new MbgUser();
		mbgUser.setUsername(username);
		mbgUser.setPasswd(SecurityUtil.md5(password));
		mbgUser.setCreateTime(new Date());
		mbgUser.setState("inactive");
		mbgUser.setRoleId(2);
		
		mbgUserMapper.insert(mbgUser);
		
	}
}