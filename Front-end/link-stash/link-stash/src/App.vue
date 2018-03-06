<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>

<script>
import { routes } from './routes.js';

export default {
  name: 'app',
  components: {
    
  },

  data(){

    return {
      routes
    }
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
  display: flex;
  justify-content: center;
}
</style>
