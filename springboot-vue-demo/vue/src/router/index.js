import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Layout from '../layout/Layout'
import Rainfall from '../views/Rainfall.vue'

const routes = [
  {
    path: '/',
    name: 'Layout',
    component: Layout,
    redirect:"/home",
    children:[
      {
        path: 'home',
        name: 'Home',
        component: Home,
      }

    ]
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/Rainfall',
    name: 'Rainfall',
    component: Rainfall
  }

]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
