import React, { useContext, useEffect, useState } from 'react'
import "./orders.css"
import { getOrder } from '../../Service/OrderService';
import AdminContext from '../Context/AdminContext';

const Orders = () => {
    const admincontext=useContext(AdminContext);
    const {cartList,updatecartList,userid,search}=admincontext;
    const [order,setOrder]=useState([])
    useEffect(()=>{
        getOrder(userid).then((res)=>{
            setOrder(res.data)
        })
    },[])

    const getFilter = ()=>{
        const content = order;
        if(search===""){
            return content;
        }
        const filterBySearch = content.filter((item) => {
            const x = item.product.name.toLowerCase();
            if (x
                .includes(search.toLowerCase())) { return item; }
        })
        return filterBySearch;

    }
console.log(order)

  return (
    <div className='cartContainer'>
            <h2>My Orders</h2>
            <div className='cartListDiv1'>
                {
                    getFilter().map((v,i)=><div className='cartItem1'>
                        <img src={v.product.image} />
                        <div className='itemText'>
                            <p><b>{v.product.name}</b></p>
                            <p><b>Address: </b>
                            <b>{v.address.name}- </b>
                            <b>{v.address.address}</b></p>
                            <p className='quantity'><b>Quantity : {v.count}</b></p>
                            <p><b>₹{v.count*v.product.price}</b></p>
                        </div>
                    </div>)
                }
            </div>
        </div>
  )
}

export default Orders