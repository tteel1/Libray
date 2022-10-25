import java.util.ArrayList;
import java.util.Objects;

public class Library {
    String address;
    ArrayList<Book> collection = new ArrayList<Book>();


    public  Library(String addressToAdd){
        this.address = addressToAdd;
    }
    public void printOpeningHours(){
        System.out.println("Libraries are open daily from 9am to 5pm.");
    }

    public void addBook(Book A){
        this.collection.add(A);
    }

    public void printAddress(){
       System.out.println( this.address);
    }

    public void borrowBook(String borrowed){
        boolean found =false;
        for (Book book:collection)
        {
            if (book.title.equals(borrowed)&& !book.isBorrowed()){
                book.borrowed();
               System.out.println("You successfully borrowed "+book.title);
               found = true;
            }
            else if(book.title.equals(borrowed)&& book.isBorrowed()){
                System.out.println("Sorry, this book is already borrowed");
                found = true;
            }

        }
        if(!found) {
            System.out.println("Sorry, this book is not in our catalog");
        }
    }

    public void returnBook(String toReturn) {
        for (Book book : collection)
            if(book.title.equals(toReturn)&& book.isBorrowed()){
                System.out.println("You successfully returned "+toReturn);
                book.returned();
            }
    }

    public void printAvailableBooks(){
        if(collection.size()==0){
            System.out.println("no books in catalog");
        }
        else {
            for (Book book : collection) {
                if(!book.isBorrowed())
                 System.out.println(book.title);
            }
        }

    }
}
