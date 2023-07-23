import axios from "axios";
const url = "http://localhost:8081/api/v2";


export const addCart=(cart)=>{
    return axios.post(url+`/cart`,cart);
}


export const getCart=(id)=>{
    return axios.get(url+`/cart/${id}`);
}

export const updateCart=(id,count)=>{
    return axios.put(url+`/cart-${id}/${count}`);
}

export const deleteCart=(id)=>{
    return axios.delete(url+`/cart/${id}`);
}
