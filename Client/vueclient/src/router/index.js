import Vue from "vue";
import VueRouter from 'vue-router'
import Transaction from "@/components/Transaction";
import Solde from "@/components/Solde";
Vue.use(VueRouter)

const routes = [
    {
      path: '/',
      redirect:'/solde'
    },
    {
      path: '/solde',
      name: 'Solde',
      component: Solde
    },
    {
        path:'/transaction',
        name: 'Transaction',
        component:Transaction
    }
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router
