import java.util.ArrayList;
import java.util.Iterator;

public class BookShelf {
    private final int id;
    private final ArrayList<Book> books;

    public BookShelf(int id) {
        this.id = id;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public BookShelf cloneBookshelf() {
        BookShelf clone = new BookShelf(id);
        for (Book book : books) {
            clone.addBook(book);
        }
        return clone;
    }

    public void filter(int num) {
        ArrayList<Book> removeBooks = new ArrayList<>();
        //书被删去的条件是分数不足，存入removeBooks后统一删去
        for (Book book : books) {
            if (book.getScore()<num){
            removeBooks.add(book);
            }
        }

        books.removeAll(removeBooks);
    }

    public void join(BookShelf bookShelf) {
        for (Book book : bookShelf.books) {
            //遍历将加入书的数组，排除书籍重复
            boolean hasBook = false;
            for (Book book1 : books) {
                //使用==判断是否为同一对象
                if (book1 == book) {
                    hasBook = true;
                    break;
                }
            }
            if (!hasBook) {
                books.add(book);
            }
        }
    }

    public void addMagic(String magic) {
        for (Book book : books) {
            book.addMagic(magic);
        }
    }

    public void subMagic(int a, int b) {
        for (Book book : books) {
            book.subMagic(a, b);
        }
    }

    public int getNum1() {
        return books.size();
    }

    public int getNum2(String s) {
        int res = 0;
        for (Book book : books) {
            if (book.contains(s)) {
                res++;
            }
        }
        return res;
    }
}
