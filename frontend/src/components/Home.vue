<template>
    <div div="home">
        <b-jumbotron>
        <template slot="header">BoFoRe</template>

        <template slot="lead">
          This is a service, when you can add your books for read. Read with pleasure!
        </template>

        <hr class="my-4" />

        <p v-if="!this.$store.getters.isAuthenticated">
          Login and start
        </p>

        <router-link to="/login" v-if="!this.$store.getters.isAuthenticated">
            <b-button variant="info">Login</b-button>
        </router-link>

      </b-jumbotron>
    </div>
</template>

<script>
export default {
    name: 'Home'
}
</script>

<style>
</style>