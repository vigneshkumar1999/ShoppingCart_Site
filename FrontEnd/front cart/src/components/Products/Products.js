import React, { useContext, useEffect, useState } from 'react'
import "./product.css"
import AdminContext from '../Context/AdminContext';
import { getProduct } from '../../Service/ProductService';
import { useSearchParams } from 'react-router-dom';
import { addCart, getCart } from '../../Service/CartService';
import { ToastContainer,toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

const Products = () => {

  const [currentPage, setCurrentPage] = useState(1);
  const [itemsPerPage] = useState(4);
  const indexOfLastItem = currentPage * itemsPerPage;
  const indexOfFirstItem = indexOfLastItem - itemsPerPage;

    const [product,setProduct] = useState([]);
    let currentItems = product.slice(indexOfFirstItem, indexOfLastItem);

    const pageNumbers = [];
  for (let i = 1; i <= Math.ceil(product.length / itemsPerPage); i++) {
    pageNumbers.push(i);
  }
  const renderPageNumbers = pageNumbers.map((number) => {
    return (
      <button
        className='paginatebutton'
        key={number}
        onClick={() => setCurrentPage(number)}
      >
        {number}
      </button>
    );
  });
    
      useEffect(()=>{
          getProduct().then((res)=>{
            setProduct(res.data);
          })

          getCart(userid).then((res)=>{
            updatecartList(res.data.length);
          })
      },[])

      
      const admincontext=useContext(AdminContext);
      const {cartLength,updatecartList,userid,search}=admincontext;

      const handleAddtoCart=(cartItem)=>{
        const cart={
          product:cartItem.id,
          customer:userid,
          count:1,
        }
        
        addCart(cart);
        updatecartList(cartLength+1);
        toast.success("Successfully added to cart");
      }

      const getFilter = ()=>{
        const content = currentItems;
        if(search===""){
            return content;
        }
        const filterBySearch = product.filter((item) => {
            const x = item.name.toLowerCase();
            if (x
                .includes(search.toLowerCase())) { return item; }
        })
        currentItems = filterBySearch.slice(indexOfFirstItem, indexOfLastItem);
        return currentItems;

    }

    


  return (
    <div className='productContainer'>
        <h2>Product List</h2>
         <div id="catg_templates">
            {getFilter().map((v,i)=><div className="catg_tmplt" id={`tmplts_id${i + 1}`}>
            <a>
                <div className="catg_tmpimg_div">
                <img src={v.image} />
                </div>
            </a>
            <div className="catg_tmptxt1">
              <h4>{v.name}</h4>
              <h4>₹{v.price}</h4>
            </div>
            <div className="catg_tmptxt2">
              {
                
                true ? <h5 onClick={()=>handleAddtoCart(v)}> Add To Cart 
                </h5> : ""
              }
             
            </div>
            
          </div>
              )}
            
        </div>
        <ToastContainer/>
        <div className='pagination' id='page-numbers'>{renderPageNumbers}</div>
    </div>
  )
}

export default Products