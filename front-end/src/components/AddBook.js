import React, { Component } from "react";
import { withRouter } from "react-router";
import axios from "axios";



class AddBook extends Component{
    constructor(props){
        super(props);
        this.state = {
            name: "",
            author: "",
            date:"",
            cost:""
        }
    }

    componentDidMount(){
        document.title = "Login";
    }

    handleChangeName = e => {
        this.state.name = e.target.value        
    }
    handleChangeAN= e => {
        console.log(e.target.value)
        this.state.author = e.target.value   
    }

    handleChangeDate= e => {
            console.log(e.target.value)
            this.state.date = e.target.value   
    }
        
    
    handleChangeCost= e => {
        console.log(e.target.value)
        this.state.cost = e.target.value   
}
    

    login = (e) => {
        e.preventDefault();

        let data = {
            "book_id":this.state.cost/10 + 13,
            "name":this.state.name,
            "author_name":this.state.author,
            "date":this.state.date,
            "cost":this.state.cost

        }
    
        axios.post("http://localhost:8080/Books", data)
        .then((response) => {
            console.log(response)
            
                alert('Book ['+this.state.name+' ] successfully registered')
                console.log(response.data,'sadas')
                 
                this.props.history.push("/adminBook",{path:response.data})
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
                        <label for="username" class="block mb-2 text-sm text-gray-600 dark:text-gray-400">Book name</label>
                        <input type="text" name="name" id="name" placeholder="Book name" onChange={this.handleChangeName}  class="w-full px-3 py-2 placeholder-gray-300 border border-gray-300 rounded-md focus:outline-none focus:ring focus:ring-indigo-100 focus:border-indigo-300 dark:bg-gray-700 dark:text-white dark:placeholder-gray-500 dark:border-gray-600 dark:focus:ring-gray-900 dark:focus:border-gray-500" />
                    </div>
                    <div class="mb-6">
                        <div class="flex justify-between mb-2">
                            <label for="password" class="text-sm text-gray-600 dark:text-gray-400"  >Author name</label>
                            {/* <a href="#!" class="text-sm text-gray-400 focus:outline-none focus:text-indigo-500 hover:text-indigo-500 dark:hover:text-indigo-300">Forgot password?</a> */}
                        </div>
                        <input type="text" name="email" id="email" placeholder="Author name" onChange={this.handleChangeAN} class="w-full px-3 py-2 placeholder-gray-300 border border-gray-300 rounded-md focus:outline-none focus:ring focus:ring-indigo-100 focus:border-indigo-300 dark:bg-gray-700 dark:text-white dark:placeholder-gray-500 dark:border-gray-600 dark:focus:ring-gray-900 dark:focus:border-gray-500" />
                    </div>
                    <div class="mb-6">
                        <div class="flex justify-between mb-2">
                            <label for="password" class="text-sm text-gray-600 dark:text-gray-400"  >Date</label>
                            {/* <a href="#!" class="text-sm text-gray-400 focus:outline-none focus:text-indigo-500 hover:text-indigo-500 dark:hover:text-indigo-300">Forgot password?</a> */}
                        </div>
                        <input type="text" name="password" id="password" placeholder="Date" onChange={this.handleChangeDate} class="w-full px-3 py-2 placeholder-gray-300 border border-gray-300 rounded-md focus:outline-none focus:ring focus:ring-indigo-100 focus:border-indigo-300 dark:bg-gray-700 dark:text-white dark:placeholder-gray-500 dark:border-gray-600 dark:focus:ring-gray-900 dark:focus:border-gray-500" />
                    </div>
                    <div class="mb-6">
                        <div class="flex justify-between mb-2">
                            <label for="password" class="text-sm text-gray-600 dark:text-gray-400"  >Cost</label>
                            {/* <a href="#!" class="text-sm text-gray-400 focus:outline-none focus:text-indigo-500 hover:text-indigo-500 dark:hover:text-indigo-300">Forgot password?</a> */}
                        </div>
                        <input type="text" name="password" id="password" placeholder="Cost" onChange={this.handleChangeCost} class="w-full px-3 py-2 placeholder-gray-300 border border-gray-300 rounded-md focus:outline-none focus:ring focus:ring-indigo-100 focus:border-indigo-300 dark:bg-gray-700 dark:text-white dark:placeholder-gray-500 dark:border-gray-600 dark:focus:ring-gray-900 dark:focus:border-gray-500" />
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

export default withRouter(AddBook);