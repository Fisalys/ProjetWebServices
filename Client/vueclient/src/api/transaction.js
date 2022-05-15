import Vue from 'vue'
const API_BASE_URL = 'http://localhost:8080';

export default class TransactionApi{
    static getSolde(id)
    {
        return Vue.http.get(`${API_BASE_URL}/comptes/solde/${id}`, {headers:{
            'Access-Control-Allow-Origin':'*'
            }})
    }
}
