import axios from 'axios';

const Cart_API_BASE_URL = "http://localhost:8080/cart";

class CartServices {

    getCart(){
        return axios.get(Cart_API_BASE_URL);
    }

     createCart(cart){
        const resp =   axios.post(Cart_API_BASE_URL, cart);
        return {status:resp.status, data:resp.data};
    }

    getCartById(cartId){
        return axios.get(Cart_API_BASE_URL + '/' + cartId);
    }

    updateCart(cart, cartId){
        return axios.put(Cart_API_BASE_URL + '/' + cartId, cart);
    }

    deleteCart(cartId){
        return axios.delete(Cart_API_BASE_URL + '/' + cartId);
    }
}

export default new CartServices()