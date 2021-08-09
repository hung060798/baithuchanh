package Controller;

import Model.Product;
import Service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/product"})

public class ProductServlet extends HttpServlet {
    ProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        RequestDispatcher dispatcher;
        if (action == null){
            action = "";
        }
        switch (action) {
            case "create":
                resp.sendRedirect("view/CreateProduct.jsp");
                break;
            case "edit":
                int indextEdit = Integer.parseInt(req.getParameter("index"));
                req.setAttribute("product",productService.list.get(indextEdit));
                dispatcher = req.getRequestDispatcher("view/EditProduct.jsp");
                dispatcher.forward(req,resp);
                break;
            case "delete":
                int index = Integer.parseInt(req.getParameter("index"));
                try {
                    productService.delete(index);
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
                resp.sendRedirect("/");
                break;
            case "findName":
                String name = req.getParameter("findName");
                try {
                    req.setAttribute("ListProduct", productService.findByName(name));
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
                dispatcher = req.getRequestDispatcher("view/ShowProduct.jsp");
                dispatcher.forward(req,resp);
                break;

            default:
                req.setAttribute("ListProduct",productService.list);
                dispatcher = req.getRequestDispatcher("view/ShowProduct.jsp");
                dispatcher.forward(req,resp);

        }
    }
    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        RequestDispatcher dispatcher;
        switch (action) {
            case "create":
                int id = Integer.parseInt(req.getParameter("id"));
                String tensp = req.getParameter("tensp");
                int gia = Integer.parseInt(req.getParameter("gia"));
                int soluong = Integer.parseInt(req.getParameter("soluong"));
                String mausac = req.getParameter("mausac");
                String mota = req.getParameter("mota");
                int danhmuc = Integer.parseInt(req.getParameter("danhmuc"));

                try {
                    Product product = new Product(id, tensp, gia, soluong, mausac, mota,danhmuc);
                    productService.add(product);
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }

                req.setAttribute("ListProduct", productService.list);
                dispatcher = req.getRequestDispatcher("view/ShowProduect.jsp");
                dispatcher.forward(req, resp);
                break;

            case "edit":
                int id1 = Integer.parseInt(req.getParameter("id"));
                String tensp1 = req.getParameter("tensp");
                int gia1 = Integer.parseInt(req.getParameter("gia"));
                int soluong1 = Integer.parseInt(req.getParameter("soluong"));
                String mausac1 = req.getParameter("mausac");
                String mota1 = req.getParameter("mota");
                int danhmuc1 = Integer.parseInt(req.getParameter("danhmuc"));

                Product product1 = new Product(id1, tensp1, gia1 , soluong1,mausac1,mota1,danhmuc1);

                int index = Integer.parseInt(req.getParameter("index"));
                try {
                    productService.edit(product1, index);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

                // chuyển hướng request và response sang thàng jsp
                req.setAttribute("ListProduct", productService.list);
                dispatcher = req.getRequestDispatcher("view/ShowProduct.jsp");
                dispatcher.forward(req, resp);
                break;

            case "find":
                int idfind = Integer.parseInt(req.getParameter("idfind"));
                ArrayList<Product> list1 = new ArrayList<>();
                for(Product p: productService.list){
                    if(p.getId()==idfind){
                        list1.add(p);
                    }
                }
                req.setAttribute("ListProduct",list1);
                dispatcher= req.getRequestDispatcher("view/ShowProduct.jsp");
                dispatcher.forward(req, resp);
                break;

        }
    }
}
