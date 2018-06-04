package org.softcits.auth.controller;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.softcits.auth.model.MbgUser;
import org.softcits.auth.model.MbgUserAndRole;
import org.softcits.auth.model.UserDisplayForm;
import org.softcits.auth.service.VPAuthService;
import org.softcits.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.StringUtil;

@Controller
public class VPAuthController {
	
	@Autowired
	private VPAuthService vpAuthService;

	@RequestMapping(path="/register",method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> regist(@RequestParam String username, @RequestParam String password) {
		
		try {
			vpAuthService.addUser(username, password);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<String>("success",HttpStatus.OK);
	}
	
	@RequestMapping(path="/user/getAll", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> usersGelAll(@RequestParam(required=false) String callback){
		
		List<MbgUserAndRole> mbgUserAndRoleList = vpAuthService.getAllUsers();
		String result = JsonUtils.objectToJson(mbgUserAndRoleList);
		if(!StringUtil.isEmpty(callback)) {
			result = callback + "(" + result + ")";
		}
		
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
	
	@RequestMapping(path="/user/{id}/form", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> userFormById(@PathVariable String id, @RequestParam(required=false) String callback){
		UserDisplayForm userDisplayForm = vpAuthService.userFormById(Integer.parseInt(id));
		String result = JsonUtils.objectToJson(userDisplayForm);
		if(!StringUtil.isEmpty(callback)) {
			result = callback + "(" + result + ")";
		}
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
	
	@RequestMapping(path="/user/login", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> login(@RequestParam String username, @RequestParam String passwd){
		String result = null;
		try {
			result = vpAuthService.login(username, passwd);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
