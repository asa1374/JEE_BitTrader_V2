package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import command.MoveCommand;
public class LoginCommand extends Command{
	public LoginCommand(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("====4.로그인 커멘드 진입====");
		execute();
	}
}
