

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rechargeplanlist")
public class RechargePlanListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		UserDetailsDAO user = new UserDetailsDAO();
		List<Operator> oplist =  user.operator_list();
		String opid = req.getParameter("opid");
		List<Plan> planlist = user.plan_list(Integer.parseInt(opid));
		req.setAttribute("operator_list",oplist);
		req.setAttribute("selectedopid",opid);
		req.setAttribute("plan_list",planlist);
		req.getRequestDispatcher("recharge.jsp").forward(req, res);
	}
}