package in.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import in.ashokit.bindings.UserUnlock;
import in.ashokit.service.UnLockService;

@RestController
public class UnLockController 
{
	@Autowired
	private UnLockService unLockService;
	
	@PostMapping("/unlockaccount")
	public String unlockReq(@RequestBody UserUnlock user)
	{
		return unLockService.unlockService(user);
	
	}

}
