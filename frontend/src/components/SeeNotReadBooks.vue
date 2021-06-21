<template>
    <div div="SeeNotReadBooks">
        <div class="jumbotron jumbotron-fluid">
        <div class="container">
    <h1 class="display-3">Your books:</h1>
    <div v-for="book in books" :key="book.id">
    <p>Titlle: {{ book['tittle'] }}</p>
    <p>Author: {{ book['author'] }}</p>
    <p>Genre: {{ book['genre'] }}</p>
        <div v-if="book['read']">
             <button type="button" class="btn btn-success btn-sm" @click="changeStatus(book['id'])">Read</button>
        </div>
        <div v-else> <button type="button" class="btn btn-danger btn-sm" @click="changeStatus(book['id'])">Not Read</button> </div> 
    <p>Commentary on the book: {{ book['commenta']}}</p>
        <div class="col-15">
            <b-form-input type="reset" placeholder="Enter comment" v-model = "newcomment[book.id-4]"/>
            </div>
        <button type="button" class="btn btn-info btn-sm" @click="changeComment(book['id'])">Change commentary</button> 
     </div> 
  </div>
</div>
    </div>
</template>


<script>
import {AXIOS} from './http-common'

export default {
    name: 'SeeNotReadBooks',
    data() {
        return {
            books: {},
            newcomment: []
        }
    },
    methods: {
        form_fill(){
      let f_a = {}
      for (let i = 0; i < this.books.length; i++){
        f_a[i] = ''
          this.newcomment[this.books[i].id-4] = f_a
      }
    },
          changeComment(ind) {
            for (let j = 0; j < this.books.length; j++){
             if (ind == this.books[j].id) {
            this.books[j]['commenta'] = this.newcomment[j]
            AXIOS.post('/books/upcomm',this.books[j])
            .then(response => {
            console.log(response)
            console.log(this.newcomment)
            })
            .catch(e => {
            console.log(e);
          })
        }}},
        changeComment(ind) {
            for (let j = 0; j < this.books.length; j++){
             if (ind == this.books[j].id) {
            // var Book = {
            //         'id': this.$data.books[j]['id'],
            //         'author': this.$data.books[j]['author'],
            //         'tittle': this.$data.books[j]['tittle'],
            //         'genre': this.$data.books[j]['genre'],
            //         'commenta': this.$data.newcomment[this.$data.books[j]['id']],
            //         'read' :  this.$data.book[j]['read'],
            //     };
            this.books[j]['commenta'] = this.newcomment[j+1]
            AXIOS.post('/books/upcomm',this.books[j])
            .then(response => {
            console.log(response)
            console.log(this.newcomment)
            })
            .catch(e => {
            console.log(e);
          })
        }}},
        loadAllBooks() {
            
            AXIOS.get('/books/allnotread')
            .then(response => {
                this.$data.books = response.data;
            })
            .catch(error => {
                console.log('ERROR: ' + error.response.data);
            })
        }
    },
    mounted() {
        this.loadAllBooks();
        this.form_fill();
    }
}
</script>

<style>
</style>