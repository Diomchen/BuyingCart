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

@WebServlet(name = "BrowseServlet")
public class BrowseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(Objects.equals("/browse/list.do",request.getServletPath())){
            request.setAttribute("products",LocalCache.getBrowse());
            request.getRequestDispatcher("/WEB-INF/view/biz/browse_list.jsp").forward(request,response);
        }
        else if(Objects.equals("/browse/delete.do",request.getServletPath())){
            String productId = request.getParameter("productId");
            if(productId != null) {
                LocalCache.delBrowseLog(LocalCache.getProducts(Long.valueOf(productId)));
                response.sendRedirect("/browse/list.do");
            }
        }

    }
}
