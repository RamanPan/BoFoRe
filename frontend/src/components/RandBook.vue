<template>
    
    <div div="RandBook">
        <div class="jumbotron jumbotron-fluid">
        <div class="container">
    <h1 class="display-3">Your book. Read with pleasure</h1>
    <h2 class="display-3">Author: {{ book['author'] }}</h2>
    <h2 class="display-3">Titlle: {{ book['tittle'] }}</h2>
    <h2 class="display-3">Genre: {{ book['genre'] }}</h2>
    <h2 class="display-3">Status of the book:
        <div v-if="book['read'] === true">
            <button type="button" class="btn btn-success " @click="changeStatus()" >Read</button>
        </div>
        <div v-else> <button type="button" class="btn btn-danger"  @click="changeStatus()"> Not Read</button> </div>
        </h2> 
    <h2 class="display-3">Commentary on the book: {{ book['commenta']}}
        <div class="col-15">
            <b-form-input type="text" id="exampleInputComment" placeholder="Enter comment" v-model = "newcomment"/>
            </div>
        <button type="submit" class="btn btn-info"  @click="changeComment()">Change commentary</button>
    </h2>
    <p class="lead"></p>
  </div>
</div>
    </div>
</template>


<script>
import {AXIOS} from './http-common'

export default {
    name: 'RandBook',
    data() {
        return {
            book: [],
            newcomment: ''
        }
    },
    methods: {
        changeStatus() {
            AXIOS.post('/books/upstat',this.$data.book)  
          .catch(e => {
            console.log(e);
          })
           this.$data.book['read'] = !this.$data.book['read']
        },
        changeComment() {
            var Book = {
                    'id': this.$data.book['id'],
                    'author': this.$data.book['author'],
                    'tittle': this.$data.book['tittle'],
                    'genre': this.$data.book['genre'],
                    'commenta': this.$data.newcomment,
                    'read' :  this.$data.book['read'],
                };
            AXIOS.post('/books/upcomm',Book)
            .then(response => {
            console.log(response)
            console.log(this.newcomment)
            })
            .catch(e => {
            console.log(e);
          })
          this.$data.book['commenta'] =  this.$data.newcomment 
        },
        loadRandBook() {
            AXIOS.get('/books/rand')
            .then(response => {
                this.$data.book = response.data;
            })
            .catch(error => {
                console.log('ERROR: ' + error.response.data);
            })
        }
    },
        mounted() {
        this.loadRandBook();
        }
}
</script>

<style>
</style>