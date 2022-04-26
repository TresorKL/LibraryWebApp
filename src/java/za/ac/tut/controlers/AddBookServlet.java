/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.controlers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.book.Book;
import za.ac.tut.book.BookFacadeLocal;

/**
 *
 * @author tresorkl
 */
public class AddBookServlet extends HttpServlet {

    @EJB
    private BookFacadeLocal bookFacade;

    

     
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String title = request.getParameter("title");
        String[] lifOfAth = request.getParameterValues("author[]");
        
        
        List<String> authors = generateListOfAuthors(lifOfAth);
        
        Book book = new Book();
        
        book.setId(id);
        book.setTitle(title);
        book.setAuthors(authors);
        
        bookFacade.addBook(book);
        
        RequestDispatcher disp = request.getRequestDispatcher("index.html");
        disp.forward(request, response);
        
        
        
    }
    
    
    public List<String> generateListOfAuthors(String[]lifOfAth){
    
        List<String> authors = new ArrayList<>();
        
        for(int i=0; i<lifOfAth.length;i++){
        authors.add(lifOfAth[i]);
        }
     
        return authors;
    }
    
    

    
}
