import axios from "axios";
const url = "http://localhost:8081/api/v2";



export const postOrder=(obj)=>{
    return axios.post(url+`/order`,obj);
}

export const getOrder=(id)=>{
    return axios.get(url+`/order/${id}`);
}