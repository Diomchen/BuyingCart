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

@WebServlet(name = "CartServlet")
public class CartServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(Objects.equals("/cart/cart.do",request.getServletPath())){
            String productId = request.getParameter("productId");
            if(productId != null){
                Product product = LocalCache.getProducts(Long.valueOf(productId));
                LocalCache.addCart(product);
            }
            response.sendRedirect("/cart/list.do");
        }
        else if(Objects.equals("/cart/list.do",request.getServletPath())){
            request.setAttribute("carts",LocalCache.getCart());
            request.getRequestDispatcher("/WEB-INF/view/biz/cart.jsp").forward(request,response);
        }
    }
}
