import Vue from 'vue'
import VueRouter from 'vue-router'
Vue.use(VueRouter)
const routes = [
  {
    path: '/',
    name: 'Manager',
    component: () =>import('../views/Manager.vue'),
    redirect:'/home',//重定向到主页
    children:[
      {path:'home', name:'Home',component: () =>import('../views/manager/Home')},
      { path: 'user', name: 'User', component: () => import('../views/manager/User') },
      { path: 'admin', name: 'Admin', component: () => import('../views/manager/Admin.vue') },
      {path: 'person',name: 'Person',component:()=>import('../views/manager/Person.vue')},
      {path: 'doctor',name: 'Doctor',component:()=>import('../views/manager/Doctor.vue')},
      {path: 'department',name: 'Department',component:()=>import('../views/manager/Department.vue')},
      {path: 'appointment',name: 'Appointment',component:()=>import('../views/manager/Appointment.vue')},
    ]
  },
  {
    path:'/Manager',
    name:'Manager',
    component: () =>import('../views/Manager.vue')
  },
  {
    path:'/login', name:'login', component: () =>import('../views/login.vue')
  },
  {
    path:'/register',
    name:'register',
    component: () =>import('../views/register.vue')
  },

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
