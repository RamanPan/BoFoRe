<template>
    <div div="books">
        <b-jumbotron>
        <template slot="header">What you wanna do?</template>

        <template slot="lead">
          You can:
        </template>

        <hr class="my-4" />

        <router-link to="/book/showall">
            <b-button variant="info btn-bg" >See all books</b-button>
        </router-link>

        <router-link to="/book/addnew">
            <b-button variant="info btn-bg">Add new book</b-button>
        </router-link>

        <router-link to="/book/rand">
            <b-button variant="info btn-bg">What to read?</b-button>
        </router-link>
        <router-link to="/book/allread">
            <b-button variant="info btn-bg">What was read?</b-button>
        </router-link>
        <router-link to="/book/allnotread">
            <b-button variant="info btn">What not read?</b-button>
        </router-link>              
      </b-jumbotron>
    </div>
</template>

<script>
export default {
    name: 'BookPage'
}
</script>

<style>
</style>