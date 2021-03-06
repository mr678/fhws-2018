package de.fhws.app.presentation.showcase.cdi;

import java.io.IOException;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("cdi2")
public class CdiInjectServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	Instance<Message> messageInstance;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getQueryString() != null) {
			Message m = messageInstance.get();
			System.out.println(m);
		}

		resp.getWriter().println("cdi2");
	}

}
