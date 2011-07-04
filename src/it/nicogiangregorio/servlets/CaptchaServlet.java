package it.nicogiangregorio.servlets;

import it.nicogiangregorio.core.CaptchaContext;
import it.nicogiangregorio.core.impl.CaptchaRefreshAction;
import it.nicogiangregorio.core.impl.CaptchaVerifyAction;
import it.nicogiangregorio.utils.CaptchaBean;
import it.nicogiangregorio.utils.WebConstants;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CaptchaServlet
 */
@WebServlet("/CaptchaServlet")
public class CaptchaServlet extends HttpServlet implements WebConstants {
	private static final long serialVersionUID = 1L;
	public static List<CaptchaBean> captchaImages;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CaptchaServlet() {
		super();
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		captchaImages = new ArrayList<CaptchaBean>();
		captchaImages.add(starCaptcha);
		captchaImages.add(heartCaptcha);
		captchaImages.add(bwmCaptcha);
		captchaImages.add(diamondCaptcha);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String forwardJsp = null;
		String action = request.getParameter(PARAM_ACTION);

		CaptchaContext captchaCtx = new CaptchaContext();

		if (ACTION_VERIFY.equals(action)) {
			captchaCtx.setCaptchaAction(new CaptchaVerifyAction());
		} else if (ACTION_REFRESH.equals(action)) {
			captchaCtx.setCaptchaAction(new CaptchaRefreshAction());
		} else {
			System.out.println("Undefined behaviour due to unexpected action.");
		}

		forwardJsp = captchaCtx.processCaptcha(request, response);
		getServletContext().getRequestDispatcher(forwardJsp).forward(request,
				response);
	}
}
