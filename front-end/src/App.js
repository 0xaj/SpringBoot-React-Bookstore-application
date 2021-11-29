import React, { Component } from "react";
import {BrowserRouter, Route} from "react-router-dom";
import Login from "./components/Login";
import Registration from "./components/Registration";
import Home from "./components/Home";
import Account from "./components/Account";
import Orders from "./components/Orders";
import Cart from "./components/Cart";
import Search from "./components/Search";
import Checkout from "./components/Checkout";
import {SignOut} from "./components/SignOut";
import "./App.css";
import Book from "./components/Book";
import AdminBook from "./components/AdminBook";
import AddBook from "./components/AddBook";

class App extends Component {
    render() {
        return (
        <BrowserRouter>
            <div>
                <Route exact={true} path="/" component={Home}/>
                <Route exact={true} path="/account" component={Account}/>
                <Route exact={true} path="/orders" component={Orders}/>
                <Route exact={true} path="/cart" component={Cart}/>
                <Route exact={true} path="/checkout" component={Checkout}/>
                {/* <Route exact={true} path="/checkout" component={AdminLogin}/>                 */}
                <Route exact={true} path="/search" component={Search}/>
                <Route exact={true} path="/addBook" component={AddBook}/>

                <Route exact={true} path="/adminBook" component={AdminBook}/>

                <Route exact={true} path="/book" component={Book}/>
                <Route exact={true} path="/login" render={Login}/>
                <Route exact={true} path="/register" render={Registration}/>
                <Route exact={true} path="/signout" render={SignOut}/>
            </div>
        </BrowserRouter>
        );
    }
}

export default App;