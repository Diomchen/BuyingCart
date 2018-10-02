package com.imooc.cart.servlet;

import com.imooc.cart.data.LocalCache;
import com.imooc.cart.data.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProductServlet extends HttpServlet {
    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setAttribute("products",LocalCache.getProduct());
//        request.getRequestDispatcher("/WEB-INF/view/biz/list.jsp").forward(request,response);
        String pagestr = request.getParameter("page");
        int page = 1;
        if( pagestr != null && !pagestr.equals("")){
            page = Integer.parseInt(pagestr);
        }

        List<Product> productList = LocalCache.getProduct();
        int size = productList.size();
        int totalPage = size % 3 == 0?size/3:size/3+1;

        request.setAttribute("prePage",page > 1 ? page-1 : 1);
        request.setAttribute("nextPage",totalPage > page ? page+1 : totalPage);
        request.setAttribute("totalPage",totalPage);

        request.setAttribute("products",LocalCache.getProduct(page,3));
        request.getRequestDispatcher("/WEB-INF/view/biz/list.jsp").forward(request,response);
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
