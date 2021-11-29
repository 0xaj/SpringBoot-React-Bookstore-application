import React, { Component } from "react";
import BookService from "../Services/BookService";
import CartService from "../Services/CartService";
import { withRouter } from "react-router";
import axios from "axios";

class Book extends Component{
    constructor(props) {
        super(props)

        this.state = {
                book: []
        }
       console.log(this.props.location.state,'custid')
    }

    
    async addToCart(book){
        
        let data = {cust_id:Number(localStorage.getItem('custId')),
        book_id:book.book_id,
        quantity:1,
        cost:book.cost
        }
        console.log(localStorage.getItem('custId'))
        return CartService.createCart(data);           
    }
    
    viewCart(){
        this.props.history.push("/cart")
    }

    mainPage(){
        this.props.history.push("/")
    }
    
   
    componentDidMount(){
        BookService.getBook().then((res) => {
            this.setState({ book: res.data});
        });
    }
    render() {
        return (
            <div class ="bg">
                 <h2 className="main-heading">Books List</h2>
                
                 <br></br>
                 <div className = "container">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Book_id    </th>
                                    <th> Book Name   </th>
                                    <th> Author Name    </th>
                                    <th> Date    </th>
                                    <th> Cost    </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.book.map(
                                        b=> 
                                        <tr key = {b.book_id}>
                                             <td> { b.book_id} </td>  
                                             <td> { b.name} </td>   
                                             <td> {b.author_name}</td>
                                             <td> {b.date}</td>
                                             <td> {b.cost}</td>
                                             <td>
                                                 
                                                 <button onClick={() => this.addToCart(b)} style={{marginLeft: "10px"}} className="f-right btn btn-cart-primary">Add to Cart </button>
                                             </td>
                                        </tr>
                                    )
                                }
                                {/* <tr>
                                    <td colSpan="5"></td>
                                </tr> */}
                            </tbody>
                        </table>

                                    <div className="cart-controls">
                                         <button onClick={() => this.mainPage()} style={{marginLeft: "10px"}} className="f-right btn btn-cart">Main Page </button>
                                        <button onClick={() => this.viewCart()} style={{marginLeft: "10px"}} className="f-right btn btn-cart">View Cart </button>
                    </div>
                    </div>

            </div>
        )
    }
}


export default withRouter(Book);