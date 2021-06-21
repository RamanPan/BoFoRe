<template>
    
    <div div="userpage">
        <div class="jumbotron jumbotron-fluid">
        <div class="container">
    <h1 class="display-3">{{ pageContent }}</h1>
    <p class="lead"></p>
  </div>
</div>
    </div>
</template>


<script>
import {AXIOS} from './http-common'

export default {
    name: 'UserPage',
    data() {
        return {
            pageContent: ''
        }
    },
    methods: {
        loadUserContent() {
            const header = {'Authorization': 'Bearer ' + this.$store.getters.getToken};
            AXIOS.get('/usercontent', { headers: header })
            .then(response => {
                this.$data.pageContent = response.data;
            })
            .catch(error => {
                console.log('ERROR: ' + error.response.data);
            })
        }
    },
    mounted() {
        this.loadUserContent();
    }
}
</script>

<style>
</style>