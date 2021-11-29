import React, { Component } from "react";
import BookService from "../Services/BookService";
import CartService from "../Services/CartService";
import { withRouter } from "react-router";
import axios from "axios";

class AdminBook extends Component{
    constructor(props) {
        super(props)

        this.state = {
                book: []
        }
       console.log(this.props.location.state,'custid')
    }

    
    async addToCart(book,index){

        let tempCart = this.state.book
        
        axios.delete("http://localhost:8080/Books/"+book.book_id)
        .then((response) => {

            this.setState({
                book: tempCart.filter(x=>x!==tempCart[index])
            })
            console.log(response)
            
                alert('Book ['+book.name+' ] successfully removed!')
                console.log(response.data,'sadas')
                 
            }
            
        )
        .catch(err => console.log(err));      
        
            
        
        return;
    }
    
    viewCart(){
        this.props.history.push("/cart")
    }

    mainPage(){
        this.props.history.push("/addBook")
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
                                        (b,index)=> 
                                        <tr key = {b.book_id}>
                                             <td> {b.book_id} </td>  
                                             <td> {b.name} </td>   
                                             <td> {b.author_name}</td>
                                             <td> {b.date}</td>
                                             <td> {b.cost}</td>
                                             <td>
                                                 
                                                 <button onClick={() => this.addToCart(b,index)} style={{marginLeft: "10px"}} className="f-right btn btn-cart-primary">Remove Book</button>
                                             </td>
                                        </tr>
                                    )
                                }
                                {/* <tr>
                                    <td colSpan="5"></td>
                                </tr> */}
                            </tbody>
                            <button onClick={() => this.mainPage()} style={{marginLeft: "10px"}} className="f-right btn btn-cart">Add Book </button>

                        </table>

                                    <div className="cart-controls">
                                         <button onClick={() => this.mainPage()} style={{marginLeft: "10px"}} className="f-right btn btn-cart">Main Page </button>
                                        <button onClick={() => this.viewCart()} style={{marginLeft: "10px"}} className="f-right btn btn-cart">View Orders </button>
                    </div>
                    </div>

            </div>
        )
    }
}


export default withRouter(AdminBook);