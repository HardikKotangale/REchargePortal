
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/rechargesetamount")
public class RechargeAmountSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		UserDetailsDAO user = new UserDetailsDAO();
		List<Operator> oplist =  user.operator_list();
		String opid = req.getParameter("opid");
		List<Plan> planlist = user.plan_list(Integer.parseInt(opid));
		String planid = req.getParameter("planid");
		req.setAttribute("operator_list",oplist);
		req.setAttribute("selectedopid",opid);
		req.setAttribute("plan_list",planlist);
		req.setAttribute("selectedplanid",planid);
		Iterator<Plan> itr = planlist.iterator();
		Plan currentplan = null;
		while(itr.hasNext())
		{
			Plan p = itr.next();
			if(p.getPlanid()==Integer.parseInt(planid))
			{
				currentplan = p;
				break;
			}
		}
		req.setAttribute("amount",currentplan.getPrice());
		req.getRequestDispatcher("recharge.jsp").forward(req, res);
	}
}