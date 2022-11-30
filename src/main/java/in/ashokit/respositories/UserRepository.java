package in.ashokit.respositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.enities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Serializable>
{
	public UserEntity findByUserEmailAndUserPwd(String email, String tempPwd);

}
