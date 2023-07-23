import React, { useContext, useEffect } from 'react'
import "./navbar.css"
import { NavLink } from 'react-router-dom'
import accolite_logo from "../../Images/Accolite.PNG";
import AdminContext from '../Context/AdminContext';
import { getCart } from '../../Service/CartService';

const Navbar = () => {
  const admincontext=useContext(AdminContext);
  const {cartLength,cartList,updatecartList,isAuthenticated,toggle,handleToggle,handleLogout,userid,updateSearch}=admincontext;
  

  return (
    <nav className='navbar'>
        <div className='website_logo_wrapper'><img className='website_logo' src={accolite_logo}/></div>
        {
          isAuthenticated ? <div className='navlinksContainer'>
                <input type="text" placeholder="Search.." onChange={(e)=>{updateSearch(e.target.value)}}  name="search" style={{width:"600px",height:"33px",marginLeft:"10px",marginRight:"10px"}}></input>
               <NavLink className="navlinks"  to={"/"}>Home</NavLink>
               <NavLink className="navlinks" to={"/myorders"}>Orders</NavLink>
               <NavLink className="navlinks" to={"/mycart"}>MyCart({cartLength})</NavLink>
               <NavLink className="navlinks" onClick={()=>handleLogout()} to={"/"}>Logout</NavLink>
          </div>: <div className='navlinksContainer'>
          {
            <>
            {
               toggle ? <NavLink className="navlinks" onClick={handleToggle} >Login</NavLink> : 
                       <NavLink className="navlinks" onClick={handleToggle}>SignUp</NavLink>
            }
            </>
          }
          </div>
        }
    </nav>
  )
}

export default Navbar