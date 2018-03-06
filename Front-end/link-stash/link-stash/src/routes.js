import Login from './components/login/Login.vue';
import Register from './components/register/Register.vue'
export const routes = [
    { path:'', component:Login },
    { path:'/login', component:Login },
    { path:'/register', component:Register}
];