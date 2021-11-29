import React, { Component } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

class Checkout extends Component{
    constructor(props){
        super(props);
        this.state = {
            checkOut: [],
            cart:[]
        }
    } 



    componentDidMount() {
       this.getCart()
    }
    getCart(){
        axios.get(`http://localhost:8080/cart`).then((response) => {
            console.log(response.data);
            this.setState({ cart: response.data });

        });
    }
    proccedToPayment() {
        axios.get(`http://localhost:8080/1/order/1/payment`).then((response) => {
            console.log(response.data);
            this.setState({ checkOut: response.data });
        }
        ).catch(console.log('here is the error'))
    }
    placeOrder = () => {
       alert('order sucessfull!')

    }


    totalCost() {
        //  alert('order sucessfull!')
          var total = 0;
          this.state.checkOut.forEach((check) => {
              total +=  check.amount; // i
  
          });
          console.log(total)
  
          // your this total is not working that's why you can't see the total pri
          return (<div className="totalCosts">
          <label>Total cost :  {total}</label>
         
          </div>)
  
      }

    
    render(){
        
        return(
        
               <>
                 <div className="container">
                    <table className="table">
                        <thead>  
                            <tr>
                                
                                <td width="33%">Cust Id</td>
                                <td width="33%">Cost</td>
                                <td width="33%">Date</td>
                            </tr>
                        </thead>
                        <tbody>
                            {/* {this.state.checkout} */}
                            


                               
                                        <td>1</td>
                                        <td>{localStorage.getItem('custId')}</td>
                                        <td>{localStorage.getItem('cost')}</td>

                                        <td>{new Date(Date.now()).toLocaleString().substring(0,10)}</td>
                                       
                                
                                
                            
                            
                        </tbody>
                       

                    </table>

                    <br />

                                        <div className="cart-controls">
                                         <button  className="f-right btn btn-cart">{this.totalCost()}</button>
                                        <button  style={{marginLeft: "10px"}} className="f-right btn btn-cart">Place Order</button>
                    </div>
                </div>
            </>
        );
    }
}

// you mean after user see this page then the
export default Checkout;