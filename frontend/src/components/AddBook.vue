<template>
     <div div = "AddBook">
     <form>
        <div class="form-group">
            <div class="col-3">
         <label for="InputAuthor">Author</label>
            <b-form-input type="text" class="form-control" id="exampleInputAuthor" aria-describedby="authorHelp" placeholder="Enter author" v-model = "author"/>
            <small id="author" class="form-text text-muted">Write the author of the book.</small>
            </div>
        <!-- </div> -->
        <!-- <div class="form-group"> -->
            <div class="col-3">
         <label for="InputTittle">Title</label>
            <b-form-input type="text" class="form-control" id="exampleInputTittle" aria-describedby="tittleHelp" placeholder="Enter tittle"  v-model = "tittle"/>
            <small id="titlle" class="form-text text-muted">Write the tittle of the book.</small>
            </div>
        <!-- </div>
        <div class="form-group"> -->
            <div class="col-3">
            <label for="FormControlGenre">Select the genre of the book</label>
                <select class="form-control" v-model = "genre">
                <!-- <select class="form-control" v-model = "genre"  @change="bookAdd()"> -->
                    <option>Fantasy</option>
                    <option>Novel</option>
                    <option>Detectives</option>
                    <option>Cooking</option>
                    <option>Business</option>
                    <option>Mysticism</option>
                    <option>History</option>
                    <option>Comics</option>
                    <option>Erotica</option>
                    <option>Utopia</option>
                    <option>Steampunk</option>
                    <option>Biography</option>
                </select>
        </div>
         <div class="col-1">
            <b-button type="submit" class="btn btn-primary" @click="bookAdd()">Submit</b-button>
        </div>    
        </div>
</form> 
     </div>
</template>

<script>
import {AXIOS} from './http-common'
export default {
    name: 'AddBook',
    data() {
          return {
          author: '',
          tittle: '',
          genre: ''
      }
    },
    methods: {
       bookAdd: function (){
             const header = {'Authorization': 'Bearer ' + this.$store.getters.getToken};
             var newBook = {
                    'author': this.$data.author,
                    'tittle': this.$data.tittle,
                    'genre': this.$data.genre,
                };
            AXIOS.post(`/books/add`, newBook)
          .then(response => {
            console.log(response)
            this.$router.push('/book')
            this.$router.go()
          })
          .catch(e => {
            console.log(e);
            this.showAlert();
          })
      }
    }
}
</script>


<style>
.form-group {
    margin-left: 38%;
    margin-top: 10px;
}
.btn-primary {
    margin-left: 37%;
    margin-top: 20px;
}
</style>