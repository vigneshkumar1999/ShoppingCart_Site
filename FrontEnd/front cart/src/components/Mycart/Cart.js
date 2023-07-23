import React, { useContext, useEffect, useState } from 'react'
import "./cart.css"
import AdminContext from '../Context/AdminContext';
import { deleteCart, getCart, updateCart } from '../../Service/CartService';
import { getAddress, postAddress } from '../../Service/AdressService';
import { postOrder } from '../../Service/OrderService';

const Cart = () => {

    const admincontext=useContext(AdminContext);
    const {cartList,updatecartList,userid,search,cartLength}=admincontext;
    const [cart,setCart]=useState([])
    const[arr,setarr]=useState([])
    const[price,setPrice]=useState(0)

    useEffect(()=>{
        getCart(userid).then((res)=>{
            setCart(res.data);
            console.log(res.data);
        })
        
    })

    const [trigger,settrigger]=useState(false);
    const [isAddressPopup,setisAddressPopup]=useState(false);
    const [isAddressForm,setisAddressForm]=useState(false);
    const [userAddress, setUserAddress] = useState([]);
    const [addressInstance, setaddressInstance] = useState(null);
    const [username, setusername] = useState("");
    const [contact, setcontact] = useState("");
    const [address, setaddress] = useState("");
    const [pincode, setpincode] = useState("");

    console.log(cartList)

    

    const handleInc=(obj)=>{
        obj.count=obj.count+1;
        updateCart(obj.id,obj.count);
        
        // updateCart
    }

    const handleDec=(obj)=>{
        obj.count=obj.count-1;
        if(obj.count===0){
            return;
        }
        updateCart(obj.id,obj.count)
    }

    const handleAddressPopup=()=>{
        getAddress(userid).then((res)=>{
            setUserAddress(res.data);
    
        })
        setisAddressPopup(true);
        setisAddressForm(false);
    }

    const handleAddAddress=()=>{
        setisAddressPopup(false);
        setisAddressForm(true);
    }

    const emptyStates=()=>{
        setusername("");
        setcontact("");
        setaddress("");
        setpincode("");
    }
    const updatePrice=()=>{
        let x = 0
        cart.map((v,i)=>{
            x+=((v.count)*(v.product.price));
        })
        return x;
    }

    const handleAddNewAddress=()=>{
        const obj={
            customer:userid,
            name:username,
            address:address,
            number:contact,
        }
        console.log(obj);
        //call add api here
        postAddress(obj).then((res)=>{
            userAddress.push(res.data);
        });
        
        emptyStates();
        setisAddressPopup(true);
        setisAddressForm(false);
    }

    const handlePlaceOrder=(e)=>{
        e.preventDefault();
        console.log(addressInstance);
        cart.map((v,i)=>{
            const orderObj = {
                customer:userid,
                product:v.product.id,
                count:v.count,
                address:addressInstance.id
            }
            postOrder(orderObj);
            deleteCart(v.id);
        })
        updatecartList(0);
        // console.log(addressInstance,arr);
        // //call place order api here
        setaddressInstance("");
        setisAddressPopup(false);
        setisAddressForm(false);
    }

    const getFilter = ()=>{
        const content = cart;
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

    const handleDelete = (obj)=>{
        deleteCart(obj.id);
        updatecartList(cartLength-1)
    }

    return (
        <>
        <div className='cartContainer'>
            <h2>My Cart</h2>
            <div className='cartListDiv'>
                {
                    getFilter().map((v,i)=>
                    <div className='cartItem'>
                        <img src={v.product.image} />
                        <div className='itemText'>
                            <p><b>{v.product.name}</b></p>
                            <p className='quantity'><b>Quantity :</b>
                                <p onClick={()=>handleDec(v)}>-</p>
                                 {v.count}
                                <p onClick={()=>handleInc(v)}>+</p>
                            </p>
                            <p><b>₹{v.product.price}</b></p>
                            <button className='delete' onClick={()=>handleDelete(v)}>DELETE</button>
                        </div>
                    </div>
                    )
                }
                
            </div>
            <div className='checkoutDiv'>

                <h2>Total Price: ₹{updatePrice()}</h2>
                <p onClick={()=>handleAddressPopup()}>Check Out</p>
            </div>
        </div>

        {isAddressPopup && <>
            <div className="popupContainer">
            <div className="popup-box">
                <h3><p>Select Address</p>  <span onClick={()=>setisAddressPopup(false)}>X</span></h3>
                {userAddress.map((v)=><div className="addressContainer">
                <span><input onClick={()=>setaddressInstance(v)} type="radio" name="address"/></span>
                <div>
                    <h2>{v.name}</h2>
                    <p>{v.address}</p>
                    <p><b>{v.number}</b></p>
                </div>
                </div>)}
                <div className='addrBtnsContainer'>
                    <div className="addAddress" onClick={()=>handleAddAddress()}>+ Add New Address</div>
                    {
                    addressInstance && <div className="placeBtn" onClick={(e)=>handlePlaceOrder(e)}>Place Order</div>
                    }
                </div>
            </div>
            </div>
            </>}

            {isAddressForm && <>
                <div className="popupContainer">
                    <div className="popup-box">
                        <h3>Add Address</h3>
                        <div className='inpDivs'>
                            <label>Name</label>
                            <input
                            value={username}
                            onChange={(e) => setusername(e.target.value)} 
                            type='text'/>
                        </div>
                        <div className='inpDivs'>
                            <label>Address</label>
                            <input
                            value={address}
                            onChange={(e) => setaddress(e.target.value)} 
                            type='text'/>
                        </div>
                        <div className='inpDivs'>
                            <label>Contact</label>
                            <input
                            value={contact}
                            onChange={(e) => setcontact(e.target.value)} 
                            type='text'/>
                        </div>
                        <div className='addrBtns'>
                            <p className='submitAddr' onClick={()=>handleAddressPopup()}>Cancel</p>
                            <p className='submitAddr' onClick={()=>handleAddNewAddress()}>Submit</p>
                        </div>
                    </div>
                </div>
            </>

            }
        </>
    )
}

export default Cart