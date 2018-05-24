package org.softcits.auth.controller;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.softcits.auth.model.MbgUserAndRole;
import org.softcits.auth.service.VPAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public ResponseEntity<List<MbgUserAndRole>> usersGelAll(){
		
		List<MbgUserAndRole> mbgUserAndRoleList = vpAuthService.getAllUsers();
		
		return new ResponseEntity<List<MbgUserAndRole>>(mbgUserAndRoleList,HttpStatus.OK);
	}
}
