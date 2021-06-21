import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import SignIn from '@/components/SignIn'
import SignUp from '@/components/SignUp'
import AdminPage from '@/components/AdminPage'
import UserPage from '@/components/UserPage'
import EmailPage from '@/components/EmailPage'
import BookPage from '@/components/BookPage'
import AddBook from '@/components/AddBook'
import SeeBooks from '@/components/SeeBooks'
import RandBook from '@/components/RandBook'
import SeeReadBooks from '@/components/SeeReadBooks'
import SeeNotReadBooks from '@/components/SeeNotReadBooks'
Vue.use(Router)

export default new Router({
    mode: 'history',
    routes: [
      {
        path: '/',
        name: 'Home',
        component: Home
      },
      {
        path: '/home',
        name: 'Home',
        component: Home
      },
      {
        path: '/login',
        name: 'SignIn',
        component: SignIn
      },
      {
        path: '/register',
        name: 'SignUp',
        component: SignUp
      },
      {
        path: '/user',
        name: 'UserPage',
        component: UserPage
      },
      {
        path: '/admin',
        name: 'AdminPage',
        component: AdminPage
      },
      {
        path: '/email',
        name: 'EmailPage',
        component: EmailPage
      },
      {
        path: '/book',
        name: 'Book',
        component: BookPage
      },
      {
        path: '/book/addnew',
        name: 'AddBook',
        component: AddBook
      },
      {
        path: '/book/showall',
        name: 'SeeBooks',
        component: SeeBooks
      },
      {
        path: '/book/rand',
        name: 'RandBook',
        component: RandBook
      },
      {
        path: '/book/allread',
        name: 'SeeReadBooks',
        component: SeeReadBooks
      },
      {
        path: '/book/allnotread',
        name: 'SeeNotReadBooks',
        component: SeeNotReadBooks
      }
      
    ]
})