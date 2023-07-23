import axios from "axios";
const url = "http://localhost:8081/api/v2";


export const newCustomer=(customer)=>{
    return axios.post(url+`/customer`,customer);
}

export const checkCustomer=(customer)=>{
    return axios.put(url+`/customer/check`,customer);
}