import React, { Component } from "react";
import { withRouter } from "react-router";
import axios from "axios";
import { Link } from 'react-router-dom'



class Login extends Component{
    constructor(props){
        super(props);
        this.state = {
            username: "",
            password: ""
        }
    }

    componentDidMount(){
        document.title = "Login";
    }

    handleChangeName = e => {
        this.state.username = e.target.value        
    }
    handleChangePass= e => {
        console.log(e.target.value)
        this.state.password = e.target.value     }

    login = (e) => {
        e.preventDefault();
    
        axios.get("http://localhost:8080/customers/"+this.state.username+"/"+this.state.password)
        .then((response) => {
            console.log(response)
            if (response.data === 1){
                alert(response.message+" invalid user name or password");
            }
            else {
                localStorage.setItem('custId',response.data)
                console.log(response.data,'sadas')
                    console.log(localStorage.getItem('custId'))
                this.props.history.push("/book",{path:response.data})
            }
            }
        )
        .catch(err => console.log(err));
    }

    signup = (e) => {
        e.preventDefault();
        alert('sss')
        this.props.history.push("/registration")
    }
  
    
        lo(){
            return(
                <p>Don't have an account? Please <a className="linkToPages" href="register">register</a></p>

            );
        }

    render(){
        return(
        
            <div class="flex items-center min-h-screen bg-white dark:bg-gray-900 sign-bg">

    <div class="container mx-auto card-width">
        <div class="max-w-md mx-auto my-10">
            <div class="text-center">
                <h1 class="my-3 text-3xl font-semibold text-gray-700 dark:text-gray-200">Sign in</h1>
                {/* <p class="text-gray-500 dark:text-gray-400">Customer Sign in</p> */}
            </div>
            <div class="m-7">
                <form action="">
                    <div class="mb-6">
                        <label for="username" class="block mb-2 text-sm text-gray-600 dark:text-gray-400">User Name</label>
                        <input type="text" name="name" id="name" placeholder="enter user name" onChange={this.handleChangeName}  class="w-full px-3 py-2 placeholder-gray-300 border border-gray-300 rounded-md focus:outline-none focus:ring focus:ring-indigo-100 focus:border-indigo-300 dark:bg-gray-700 dark:text-white dark:placeholder-gray-500 dark:border-gray-600 dark:focus:ring-gray-900 dark:focus:border-gray-500" />
                    </div>
                    <div class="mb-6">
                        <div class="flex justify-between mb-2">
                            <label for="password" class="text-sm text-gray-600 dark:text-gray-400"  >Password</label>
                            {/* <a href="#!" class="text-sm text-gray-400 focus:outline-none focus:text-indigo-500 hover:text-indigo-500 dark:hover:text-indigo-300">Forgot password?</a> */}
                        </div>
                        <input type="password" name="password" id="password" placeholder="Your Password" onChange={this.handleChangePass} class="w-full px-3 py-2 placeholder-gray-300 border border-gray-300 rounded-md focus:outline-none focus:ring focus:ring-indigo-100 focus:border-indigo-300 dark:bg-gray-700 dark:text-white dark:placeholder-gray-500 dark:border-gray-600 dark:focus:ring-gray-900 dark:focus:border-gray-500" />
                    </div>
                    <form className="form" onSubmit={this.login}>
                    
                    <input class="w-full px-3 py-4 text-white bg-indigo-500 rounded-md focus:bg-indigo-600 focus:outline-none"  type="submit" value="Login" />
                    
                   </form>
<center>
                   <Link to="/register">
                            <button  variant="primary" size="xlg" active="true" className="btn-home">
                                Sign Up
                            </button>
                    </Link>
                    </center>
                    {/* <p class="text-sm text-center text-gray-400">Don&#x27;t have an account yet? <a href="#!" class="text-indigo-400 focus:outline-none focus:underline focus:text-indigo-500 dark:focus:border-indigo-800">Sign up</a>.</p> */}
                </form>
            </div>
        </div>
    </div>
</div>
        );
    }
}

export default withRouter(Login);