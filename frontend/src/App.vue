<template>
  <div id="app">
    <b-navbar style="width: 100%" type="dark" variant="dark">
      <b-navbar-brand id="nav-brand" href="#">BoFoRe</b-navbar-brand>
      <router-link to="/"><img height="50px" src="./assets/img/image.png" alt="Kotlin+Spring+Vue"/></router-link>
      <router-link to="/user" class="nav-link text-light" v-if="this.$store.getters.isAuthenticated">User</router-link>
      <router-link to="/admin" class="nav-link text-light" v-if="this.$store.getters.isAuthenticated && this.$store.getters.isAdmin">Admin</router-link>
      <router-link to="/book" class="nav-link text-light" v-if="this.$store.getters.isAuthenticated">Books</router-link>
      <router-link to="/register" class="nav-link text-light" v-if="!this.$store.getters.isAuthenticated">Register</router-link>
      <router-link to="/login" class="nav-link text-light" v-if="!this.$store.getters.isAuthenticated">Login</router-link>
      <a href="#" class="nav-link text-light" v-if="this.$store.getters.isAuthenticated" v-on:click="logout">Logout </a>
    </b-navbar>
    <router-view></router-view>
  </div>
</template>

<script>

export default {
  name: 'app',
  methods: {
    logout() {
      this.$store.dispatch('logout');
      this.$router.push('/')
    }
  } 
}
</script>

<style>
</style>
