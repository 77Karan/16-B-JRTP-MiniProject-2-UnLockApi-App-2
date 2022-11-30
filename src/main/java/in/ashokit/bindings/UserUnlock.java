package in.ashokit.bindings;
import lombok.Data;

@Data
public class UserUnlock 
{
	public String userEmail;
	public String tempPwd;
	public String newPwd;
	public String confirmPwd;

}
