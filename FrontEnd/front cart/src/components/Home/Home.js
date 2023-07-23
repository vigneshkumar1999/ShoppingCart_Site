import React, { useContext } from 'react'
import AdminContext from '../Context/AdminContext'
import Login from '../Login/Login';
import Navbar from '../Navbar/Navbar';
import Products from '../Products/Products';
import Cart from '../Mycart/Cart';
import { Route,Routes,useLocation,useNavigate } from 'react-router-dom';
import Orders from '../Orders/Orders';

const Home = () => {
  const admincontext=useContext(AdminContext);
  const {isAuthenticated}=admincontext;
  return (
    <>
    {
      isAuthenticated ? <>
            <Navbar/>
            <Routes>
              <Route exact path="/" element={<Products />}/>
              <Route exact path="/mycart" element={<Cart />}/>
              <Route exact path="/myorders" element={<Orders />}/>
            </Routes>
        </>:(
        <>
          <Navbar/>
          <Routes>
            <Route exact path="/" element={<Login/>}/>
          </Routes>
        </>
      )
    }
    </>
  )
}

export default Home