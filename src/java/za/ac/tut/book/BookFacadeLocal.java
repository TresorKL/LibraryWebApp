/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.ac.tut.book;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author tresorkl
 */
@Local
public interface BookFacadeLocal {

    void addBook(Book book);
    void create(Book book);

    void edit(Book book);

    void remove(Book book);

    Book find(Object id);

    List<Book> findAll();

    List<Book> findRange(int[] range);

    int count();
    
}
