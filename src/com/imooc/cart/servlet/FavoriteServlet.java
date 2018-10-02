package com.imooc.cart.servlet;

import com.imooc.cart.data.LocalCache;
import com.imooc.cart.data.Product;
import com.sun.deploy.nativesandbox.comm.Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "FavoriteServlet")
public class FavoriteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(Objects.equals("/favorite/favorite.do",request.getServletPath())){
            String productId = request.getParameter("productId");
            if(productId != null){
                Product product = LocalCache.getProducts(Long.valueOf(productId));
                LocalCache.addFavorite(product);
            }
            response.sendRedirect("/favorite/list.do");
        }
        else if(Objects.equals("/favorite/list.do",request.getServletPath())){
            request.setAttribute("products",LocalCache.getFavorites());
            request.getRequestDispatcher("/WEB-INF/view/biz/favorite.jsp").forward(request,response);
        }
        else if(Objects.equals("/favorite/delete.do",request.getServletPath())){
            String productId = request.getParameter("productId");
            if( productId != null ){
                Product product = LocalCache.getProducts(Long.valueOf(productId));
                LocalCache.delFavorite(product);
            }
            response.sendRedirect("/favorite/list.do");
        }
    }
}
