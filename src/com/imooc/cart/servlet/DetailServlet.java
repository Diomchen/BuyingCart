package com.imooc.cart.servlet;

import com.imooc.cart.data.LocalCache;
import com.imooc.cart.data.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "DetailServlet")
public class DetailServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(Objects.equals("/detail/detail.do",request.getServletPath())){
            String productId = request.getParameter("productId");
            if( productId != null ){
                Product product = LocalCache.getProducts(Long.valueOf(productId));
                LocalCache.addBrowseLog(product);
                request.setAttribute("product",product);
            }
            request.getRequestDispatcher("/WEB-INF/view/biz/detail.jsp").forward(request,response);
        }
    }
}
