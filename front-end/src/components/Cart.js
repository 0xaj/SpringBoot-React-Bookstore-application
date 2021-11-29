import React, { Component } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

// import {useHistory} from 'react-router-dom'
import '../tailwind.css'
import CartService from "../Services/CartService";
class Cart extends Component {
    constructor(props) {
        super(props);
        this.state = {
            cart: [],
            total: 0,
            bookPrice:{}
        }
    }


    componentDidMount() {
        document.title = "Cart";
        console.log(window.localStorage);
        axios.get(`http://localhost:8080/cart/${window.localStorage.getItem("custId")}`).then((response) => {
            console.log(response.data);
            
            this.setState({ cart: response.data.list, total: response.data.total });
        });
    }


     async removeItem(index, item){//here
        
        let tempCart = this.state.cart;

        alert(JSON.stringify(tempCart[index]));

        await axios.delete(`http://localhost:8080/cart/${localStorage.getItem("custId")}/${item.cart_id}`).then((res)=>{
            this.setState({
                cart: tempCart.filter(x=>x!==tempCart[index])
            })
        })     
        
        return;
    } 

    modifyAty(action,index){

        let tempList = this.state.cart;

        let arrItem = tempList[index];

        let total = this.state.total;

        //Update cart by api and then add to cart

        if(action === "add"){
            total+=tempList[index].cost;
            tempList[index].quantity  = tempList[index].quantity + 1 ;
        } else{
            total-=tempList[index].cost;
            tempList[index].quantity  = tempList[index].quantity - 1;
        }
        

        

        const sumArr = tempList.map(x=>x.quantity);
        localStorage.getItem('custId')
        localStorage.setItem('cost',this.state.total)
        
        // get your book price

      
    // addToOrder(){
        
    //     let data = {
    //         cust_DELETEid : Number(localStorage.getItem('custId')),
    //         total_cost : this.state.total
    //     }
    //     localStorage.setItem('total_cost',this.state.total)

    // }

        this.setState({
            cart:tempList,
            total
        })
    }
    goCheckout() {
        this.props.history.push("/checkout")
    }

    render() {
       

        return (
            <>
             
                <div className="container">
                    <div class="">
                        <div class="flex shadow-md my-10 cart-bg">
                            <div class="w-3/4 bg-white px-10 py-10 cart-card">
                                <div class="flex justify-between border-b pb-8">
                                    <h1 class="font-semibold text-2xl">Shopping Cart</h1>
                                    <h2 class="font-semibold text-2xl">{this.state.cart.length} Items</h2>
                                </div>
                                <div class="flex mt-10 mb-5">
                                    <h3 class="font-semibold text-gray-600 text-xs uppercase w-2/5">Book ID</h3>
                                    <h3 clacostss="font-semibold text-center text-gray-600 text-xs uppercase w-1/5 text-center">Quanity</h3>
                                    <h3 class="font-semibold text-center text-gray-600 text-xs uppercase w-1/5 text-center">Price</h3>
                                    <h3 class="font-semibold text-center text-gray-600 text-xs uppercase w-1/5 text-center">Cart ID</h3>
                                </div>

                                {
                                    this.state.cart.map((item, index) => {
                                       
                                        return (
                                            <div class="flex items-center hover:bg-gray-100 -mx-8 px-6 py-5">
                                                <div class="flex w-2/5">
                                                    <div className="pd-img"></div>
                                                        {/* <img class="h-24" className="pd-img" alt="" /> */}
                                                    
                                                    <div class="flex flex-col justify-between ml-4 flex-grow">
                                                        <span class="font-bold text-sm">{item.book_id}</span>
                                                        {/* <span class="text-red-500 text-xs">Xiaomi</span> */}
                                                        <span onClick={()=>{this.removeItem(index, item)}} class="font-semibold hover:text-red-500 text-gray-500 text-xs" >Remove</span>
                                                    </div>
                                                </div>
                                                <div class="flex justify-center w-1/5">
                                              
                                                    <svg class="fill-current text-gray-600 w-3" onClick={()=>{this.modifyAty('delete',index)}} viewBox="0 0 448 512"><path d="M416 208H32c-17.67 0-32 14.33-32 32v32c0 17.67 14.33 32 32 32h384c17.67 0 32-14.33 32-32v-32c0-17.67-14.33-32-32-32z" />
                                                    </svg>
                                                    <input class="mx-2 border text-center w-8" type="text" value={item.quantity}  />

                                                    <svg class="fill-current text-gray-600 w-3" viewBox="0 0 448 512" onClick={()=>{this.modifyAty('add',index)}}>
                                                        <path d="M416 208H272V64c0-17.67-14.33-32-32-32h-32c-17.67 0-32 14.33-32 32v144H32c-17.67 0-32 14.33-32 32v32c0 17.67 14.33 32 32 32h144v144c0 17.67 14.33 32 32 32h32c17.67 0 32-14.33 32-32V304h144c17.67 0 32-14.33 32-32v-32c0-17.67-14.33-32-32-32z" />
                                                    </svg>
                                                </div>
                                                <span class="text-center w-1/5 font-semibold text-sm">{item.cost}</span>
                                                <span class="text-center w-1/5 font-semibold text-sm">{item.cart_id}</span>
                                            </div>
                                        )
                                        })
                                    }
                              <Link to='/book'>
                                <button className="btn-back">
                                <svg class="fill-current mr-2 text-indigo-600 w-4" viewBox="0 0 448 512"><path d="M134.059 296H436c6.627 0 12-5.373 12-12v-56c0-6.627-5.373-12-12-12H134.059v-46.059c0-21.382-25.851-32.09-40.971-16.971L7.029 239.029c-9.373 9.373-9.373 24.569 0 33.941l86.059 86.059c15.119 15.119 40.971 4.411 40.971-16.971V296z" /></svg>
                                            Back to book list
                                </button>
                            </Link>
                                   
      </div>

                            <div id="summary" class="w-1/4 px-8 py-10 cart-card">
                                <h1 class="font-semibold text-2xl border-b pb-8">Order Summary</h1>
                                <div class="flex justify-between mt-10 mb-5">
                                    <span class="font-semibold text-sm uppercase">Items {this.state.cart.length}</span>
                                </div>
                                <div class="border-t mt-8">
                                    <div class="flex font-semibold justify-between py-6 text-sm uppercase">
                                        <span>Total cost</span>
                                        <span>
                                            <span className="totalCosts">
                                                <label>${this.state.total}</label>
                                            </span>
                                            
                                        </span>
                                    </div>
                                    <Link to='/checkout'>
                                    <button   class="bg-indigo-500 font-semibold hover:bg-indigo-600 py-3 text-sm text-white uppercase w-full">Checkout</button>
                                    </Link>
                                </div>
                            </div>

                        </div>
                    </div>
                    
                  

                </div>
            </>
        );
    }
}

export default Cart;