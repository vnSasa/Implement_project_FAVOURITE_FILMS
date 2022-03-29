package my.favourite.films.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.favourite.films.domain.Product;
import my.favourite.films.service.ProductService;
import my.favourite.films.service.impl.ProductServiceImpl;

@WebServlet("/product")
public class ProductController extends HttpServlet {

	ProductService productService = ProductServiceImpl.getProductService();

	// to create resource (product)
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String genre = request.getParameter("genre");
		String alternativegenre = request.getParameter("alternativegenre");
		String release = request.getParameter("release");

		Product product = new Product(name, genre, alternativegenre, release);
		productService.create(product);
		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
	}

	// to get resource (product)
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String productId = request.getParameter("id");
		Product product = productService.read(Integer.parseInt(productId));

		request.setAttribute("product", product);
		request.getRequestDispatcher("singleProduct.jsp").forward(request, response);
	}

	// to update resource (product)
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		super.doPut(req, resp);
	}

	// to delete resource (product)
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		super.doDelete(req, resp);
	}

}
