package pl.coderslab.warsztat5krkw04.service;

import org.springframework.stereotype.Service;
import pl.coderslab.warsztat5krkw04.model.Book;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemoryBookService {
    private long nextId;
    private List<Book> list;
    public MemoryBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel",
                "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz glowa, Java.",
                "Sierra Kathy, Bates Bert", "Helion", "programming"));
        list.add(new Book(3L, "9780130819338", "Java 2. Podstawy",
                "Cay Horstmann, Gary Cornell", "Helion", "programming"));

        setNextId();
    }

    private void setNextId() {
        this.nextId = this.list.stream()
                .mapToLong(Book::getId)
                .max()
                .orElse(0L) + 1;
    }

    public List<Book> getList() {return list;}
    public void setList(List<Book> list) {this.list = list;}

    public Book getById(long id) {
        return this.list.stream()
                .filter(b -> b.getId() == id)
                .findAny()
                .orElse(null);
    }

    public void addBook(Book toAdd) {
        if(this.list.stream().anyMatch(b -> b.getId() == toAdd.getId())){
            return;
        }

        toAdd.setId(this.nextId++);
        this.list.add(toAdd);
    }

    public void deleteById(long idToDelete) {
        final Book bookToDelete = getById(idToDelete);

        this.list.remove(bookToDelete);
    }

    public void editBook(Book toEdit) {
        Book bookToEdit = getById(toEdit.getId());
        bookToEdit.merge(toEdit);
    }
}
