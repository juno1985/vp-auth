package org.softcits.auth.service;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.softcits.auth.model.UserDisplayForm;
import org.softcits.auth.mapper.MbgRoleMapper;
import org.softcits.auth.mapper.MbgUserMapper;
import org.softcits.auth.mapper.MbgUserRoleMapper;
import org.softcits.auth.model.MbgRole;
import org.softcits.auth.model.MbgUser;
import org.softcits.auth.model.MbgUserAndRole;
import org.softcits.auth.model.MbgUserExample;
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
	@Autowired
	private MbgUserRoleMapper mbgUserRoleMapper;
	@Autowired
	private MbgRoleMapper mbgRoleMapper;

	public void addUser(String username, String password) throws NoSuchAlgorithmException {
		
		MbgUser mbgUser = new MbgUser();
		mbgUser.setUsername(username);
		mbgUser.setPasswd(SecurityUtil.md5(password));
		mbgUser.setCreateTime(new Date());
		mbgUser.setState("inactive");
		mbgUser.setRoleId(2);
		
		mbgUserMapper.insert(mbgUser);
		
	}

	public List<MbgUserAndRole> getAllUsers() {
		List<MbgUserAndRole> urList = mbgUserRoleMapper.getAllUsersAndRoles();
		return urList;
	}
	
	public UserDisplayForm userFormById(Integer id) {
		UserDisplayForm userDisplayForm = new UserDisplayForm();
		MbgUser mbgUser = mbgUserMapper.selectByPrimaryKey(id);
		
		Integer roleId = mbgUser.getRoleId();
		MbgRole mbgRole = mbgRoleMapper.selectByPrimaryKey(roleId);
		
		MbgUserAndRole mbgUserAndRole = new MbgUserAndRole();
		mbgUserAndRole.setId(mbgUser.getId());
		mbgUserAndRole.setCreateTime(mbgUser.getCreateTime());
		mbgUserAndRole.setRoleId(roleId);
		mbgUserAndRole.setRolename(mbgRole.getRolename());
		mbgUserAndRole.setState(mbgUser.getState());
		mbgUserAndRole.setUsername(mbgUser.getUsername());
		
		userDisplayForm.setUser(mbgUserAndRole);
		
		userDisplayForm.setRoles(mbgRoleMapper.selectByExample(null));
		
		List<String> states = new ArrayList<String>();
		states.add("active");
		states.add("inactive");
		userDisplayForm.setStates(states);
		
		return userDisplayForm;
	}
	
	public MbgUser login(String username, String passwd) throws NoSuchAlgorithmException {
		MbgUserExample userExa = new MbgUserExample();
		MbgUserExample.Criteria userCri = userExa.createCriteria();
		userCri.andUsernameEqualTo(username);
		List<MbgUser> uList = mbgUserMapper.selectByExample(userExa);
		if(uList.size() > 0 && SecurityUtil.md5(passwd).equals(uList.get(0).getPasswd())) {
		
			return uList.get(0);
		}
		return null;
	}
}
