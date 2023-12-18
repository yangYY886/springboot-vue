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
      {path: 'doctorplan',name: 'DoctorPlan',component:()=>import('../views/manager/DoctorPlan.vue')},
      {path: 'doctorcard',name: 'DoctorCard',component:()=>import('../views/manager/DoctorCard.vue')},
    ]
  },
  {
    path: '/',
    name: 'Layout',
    component: () =>import('../views/Layout.vue'),
    redirect:'/index',//重定向到主页
    children:[
      {path:'index', name:'index',component: () =>import('../views/index.vue')},
      {path:'expert', name:'expert',component: () =>import('../views/managervue/Expert.vue')},
      {path:'keshiIntroduction', name:'keshiIntroduction',component: () =>import('../views/managervue/KeshiIntroduction.vue')},
      //{path:'appointment', name:'appointment',component: () =>import('../views/managervue/Appointment.vue')},
    ]},
  {
    path:'/Manager',
    name:'Manager',
    component: () =>import('../views/Manager.vue')
  },
  {
    path:'/login', name:'login', component: () =>import('../views/login.vue')
  },
  {
    path:'/register', name:'register', component: () =>import('../views/register.vue')
  },

]


const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})
// router.beforeEach((to, from, next) => {
//   // to 是到达的路由信息
//   // from 是开源的路由信息
//   // next 是帮助我们跳转路由的函数
//   let adminPaths = ['/user']
//   let user = JSON.parse(localStorage.getItem('honey-user') || '{}')
//
//   if (user.role !== '管理员' && adminPaths.includes(to.path)) {
//     // 如果当前登录的用户不是管理员，然后当前的到达的路径是管理员才有权限访问的路径，那这个时候我就让用户去到一个没有权限的页面，不让他访问实际的页面
//     next('/403')
//   } else {
//     next()
//   }
// })


export default router
