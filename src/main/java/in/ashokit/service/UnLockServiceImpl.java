package in.ashokit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.bindings.UserUnlock;
import in.ashokit.constants.AppConstants;
import in.ashokit.enities.UserEntity;
import in.ashokit.props.AppProperties;
import in.ashokit.respositories.UserRepository;

@Service
public class UnLockServiceImpl implements UnLockService
{
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private AppProperties appProps;

	@Override
	public String unlockService(UserUnlock user)
	{
		UserEntity userEntity = userRepo.findByUserEmailAndUserPwd(user.getUserEmail(), user.getTempPwd());
		if(userEntity != null && user.getNewPwd().equals(user.getConfirmPwd()))
		{
			userEntity.setUserPwd(user.getConfirmPwd());
			userEntity.setUserAccStatus(AppConstants.UNLOCKED);
			userRepo.save(userEntity);
			return appProps.getMessages().get(AppConstants.ACCOUNT_UNLOCKED);
		}
		
		if(userEntity != null && user.getNewPwd() != user.getConfirmPwd())
		{
			return appProps.getMessages().get(AppConstants.NEW_CONFIRM_PWD_NOTMATCH);
		}
		return appProps.getMessages().get(AppConstants.INVALID_TEMP_PASSWORD);
	}
	

}
