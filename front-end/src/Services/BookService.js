import axios from 'axios';

const Book_API_BASE_URL = "http://localhost:8080/Books";

class BookServices {

    getBook(){
        return axios.get(Book_API_BASE_URL);
    }

    createBook(book){
        return axios.post(Book_API_BASE_URL, book);
    }

    getBookById(bookId){
        return axios.get(Book_API_BASE_URL + '/' + bookId);
    }

    updateBook(book, bookId){
        return axios.put(Book_API_BASE_URL + '/' + bookId, book);
    }

    deleteBook(bookId){
        return axios.delete(Book_API_BASE_URL + '/' + bookId);
    }
}

export default new BookServices()