package com.imooc.cart.servlet;

import com.imooc.cart.data.Cart;
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
        else if(Objects.equals("/cart/delete.do",request.getServletPath())){
            String productId = request.getParameter("productId");
            if(productId != null){
                LocalCache.decCart(Long.valueOf(productId));
            }
            response.sendRedirect("/cart/list.do");
        }
        else if(Objects.equals("/cart/decr.do",request.getServletPath())){
            String productId = request.getParameter("productId");
            if(productId != null){
                LocalCache.decProd(Long.valueOf(productId));
            }
            response.sendRedirect("/cart/list.do");
        }
        else if(Objects.equals("/cart/incr.do",request.getServletPath())){
            String productId = request.getParameter("productId");
            if(productId != null){
                LocalCache.inctProd(Long.valueOf(productId));
            }
            response.sendRedirect("/cart/list.do");
        }
        else if(Objects.equals("/cart/settlement.do",request.getServletPath())){
            String[] productId = request.getParameterValues("carts");
            int totalPrice = 0;
            for(int i=0 ; i<productId.length ; i++ ){
                Cart cart = LocalCache.getCarts(Long.valueOf(productId[i]));
                totalPrice += cart.getTotalPrice();
                LocalCache.decCart(cart.getId());
            }
            request.setAttribute("totalPrice",totalPrice);
            request.getRequestDispatcher("/WEB-INF/view/biz/settlement.jsp").forward(request,response);
        }


    }
}
