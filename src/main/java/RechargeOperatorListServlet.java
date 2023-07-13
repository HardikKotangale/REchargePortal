

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/rechargeoperatorlist")
public class RechargeOperatorListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		UserDetailsDAO user = new UserDetailsDAO();
		List<Operator> oplist =  user.operator_list();
		req.setAttribute("operator_list",oplist);
		req.getRequestDispatcher("recharge.jsp").forward(req, res);
	}
}