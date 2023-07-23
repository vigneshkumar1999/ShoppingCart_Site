import React, { useContext, useState } from 'react'
import "./login.css"
import AdminContext from '../Context/AdminContext';
import { checkCustomer, newCustomer } from '../../Service/CustomerService';

const Login = () => {
    const admincontext=useContext(AdminContext);
    const {toggle,handleToggle,handleLogin}=admincontext;

    const [username,setUsername]=useState("");
    const [usermail,setUsermail]=useState("");
    const [password,setPassword]=useState("");

    const checkLogin=(e)=>{
        e.preventDefault();
        const customer = {
            mail:usermail,
            password:password
        }
        console.log(customer)
        
        checkCustomer(customer).then((res)=>{
            if(res.data===""){
                console.log("Invalid")
                alert('Invalid User mail or Password')
            }else{
                handleLogin(res.data);
            }
            
           
        });
        
        
        //check from db and update isauth
        
        
    }

    const handleRegister=(e)=>{
        e.preventDefault();
        console.log(username,usermail,password)
        const customer = {
            mail:usermail,
            name:username,
            password:password
        }
        newCustomer(customer).then((res)=>{
            console.log(JSON.stringify(res.data));
            handleLogin(res.data);
        });
        
        //add new user to db and update isauth
        
        
    }

    const emptyStates=()=>{
        setPassword("");
        setUsername("");
        setUsermail("");
    }

    return (
        <div>
            <div class="login-page">
                <div class="form">
                    {
                        toggle?<form class="register-form" onSubmit={(e)=>{handleRegister(e)}}>
                                    <h1>Register</h1>
                                    <input onChange={(e)=>setUsername(e.target.value)} type="text" placeholder="name"/>
                                    <input onChange={(e)=>setPassword(e.target.value)} type="password" placeholder="password"/>
                                    <input onChange={(e)=>setUsermail(e.target.value)} type="mail" placeholder="email address"/>
                                    <button>create</button>
                                    <p onClick={()=>{handleToggle();emptyStates();}} class="message">Already registered? <a>Sign In</a></p>
                                </form>:
                            <form class="login-form" onSubmit={(e)=>{checkLogin(e)}}>
                                <h1>Login</h1>
                                <input type="mail" onChange={(e)=>setUsermail(e.target.value)} name='usermail' placeholder="usermail"/>
                                <input type="password" onChange={(e)=>setPassword(e.target.value)} name='password' placeholder="password"/>
                                <button >login</button>
                                <p onClick={()=>{handleToggle();emptyStates();}} class="message">Not registered? <a>Create an account</a></p>
                            </form>
                    }
                </div>
            </div>
        </div>
    )
}

export default Login