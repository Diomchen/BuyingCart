package com.imooc.cart.servlet;

import com.imooc.cart.data.LocalCache;
import com.imooc.cart.data.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductServlet extends HttpServlet {
    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("products",LocalCache.getProduct());
        request.getRequestDispatcher("/WEB-INF/view/biz/list.jsp").forward(request,response);
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
