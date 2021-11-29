import React, { Component } from "react";
import { withRouter } from "react-router";
import axios from "axios";



class Registration extends Component{
    constructor(props){
        super(props);
        this.state = {
            username: "",
            password: "",
            email:""
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
        this.state.password = e.target.value   
    }

    handleChangeEmail= e => {
            console.log(e.target.value)
            this.state.email = e.target.value   
    }
            

    login = (e) => {
        e.preventDefault();

        let data = {
            "name":this.state.username,
            "email":this.state.password,
            "password":this.state.email
        }
    
        axios.post("http://localhost:8080/customers", data)
        .then((response) => {
            console.log(response)
            
                alert('User ['+this.state.username+' ] successfully registered')
                console.log(response.data,'sadas')
                 
                this.props.history.push("/login",{path:response.data})
            }
            
        )
        .catch(err => console.log(err));
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
                <h1 class="my-3 text-3xl font-semibold text-gray-700 dark:text-gray-200">Register Here</h1>
            </div>
            <div class="m-7">
                <form action="">
                    <div class="mb-6">
                        <label for="username" class="block mb-2 text-sm text-gray-600 dark:text-gray-400">User Name</label>
                        <input type="text" name="name" id="name" placeholder="enter user name" onChange={this.handleChangeName}  class="w-full px-3 py-2 placeholder-gray-300 border border-gray-300 rounded-md focus:outline-none focus:ring focus:ring-indigo-100 focus:border-indigo-300 dark:bg-gray-700 dark:text-white dark:placeholder-gray-500 dark:border-gray-600 dark:focus:ring-gray-900 dark:focus:border-gray-500" />
                    </div>
                    <div class="mb-6">
                        <div class="flex justify-between mb-2">
                            <label for="password" class="text-sm text-gray-600 dark:text-gray-400"  >Email</label>
                            {/* <a href="#!" class="text-sm text-gray-400 focus:outline-none focus:text-indigo-500 hover:text-indigo-500 dark:hover:text-indigo-300">Forgot password?</a> */}
                        </div>
                        <input type="email" name="email" id="email" placeholder="Your Password" onChange={this.handleChangeEmail} class="w-full px-3 py-2 placeholder-gray-300 border border-gray-300 rounded-md focus:outline-none focus:ring focus:ring-indigo-100 focus:border-indigo-300 dark:bg-gray-700 dark:text-white dark:placeholder-gray-500 dark:border-gray-600 dark:focus:ring-gray-900 dark:focus:border-gray-500" />
                    </div>
                    <div class="mb-6">
                        <div class="flex justify-between mb-2">
                            <label for="password" class="text-sm text-gray-600 dark:text-gray-400"  >Password</label>
                            {/* <a href="#!" class="text-sm text-gray-400 focus:outline-none focus:text-indigo-500 hover:text-indigo-500 dark:hover:text-indigo-300">Forgot password?</a> */}
                        </div>
                        <input type="text" name="password" id="password" placeholder="Your Password" onChange={this.handleChangePass} class="w-full px-3 py-2 placeholder-gray-300 border border-gray-300 rounded-md focus:outline-none focus:ring focus:ring-indigo-100 focus:border-indigo-300 dark:bg-gray-700 dark:text-white dark:placeholder-gray-500 dark:border-gray-600 dark:focus:ring-gray-900 dark:focus:border-gray-500" />
                    </div>
                    <form className="form" onSubmit={this.login}>
                    
                    <input class="w-full px-3 py-4 text-white bg-indigo-500 rounded-md focus:bg-indigo-600 focus:outline-none"  type="submit" value="Register" />
                   </form>
                    {/* <p class="text-sm text-center text-gray-400">Don&#x27;t have an account yet? <a href="#!" class="text-indigo-400 focus:outline-none focus:underline focus:text-indigo-500 dark:focus:border-indigo-800">Sign up</a>.</p> */}
                </form>
            </div>
        </div>
    </div>
</div>
        );
    }
}

export default withRouter(Registration);