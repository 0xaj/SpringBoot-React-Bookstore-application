import React, { Component } from "react";
import { Link } from 'react-router-dom'


class Home extends Component{
    initHome(){
     
       
            return(
                <div>

                     {/* <h1>Welcome to Online Book Store</h1> */}
                     
                    <div className="home-bg">

                       <div className="header-text">
                    <h1>Welcome to Online Book Store</h1>
                    </div>

                    <div className="button-align">
                        <Link to="/login">
                            <button  variant="primary" size="xlg" active="true" className="btn-home">
                                Customer Login
                            </button>
                        </Link>
                        <br />
                        <Link to="/adminLogin">
                            <button  variant="primary" size="xlg" active="true" className="btn-home">
                                Admin Login
                            </button>
                        </Link>
                       
                        </div>
                        </div>
                   
                   
                </div>
            )
        
    }

    render(){
        return(
            <div>
                {this.initHome()}
            </div>
        );
    }
}

export default Home;