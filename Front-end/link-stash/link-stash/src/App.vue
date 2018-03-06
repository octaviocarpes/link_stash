<template>
  <div id="app">
    <transition name="fade" mode="out-in" appear>
      <router-view></router-view>
    </transition>
  </div>
</template>

<script>
import { routes } from './routes.js';

export default {
  name: 'app',
  components: {
    
  },

  methods:{

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

.fade-enter-active, .fade-leave-active {
  transition: opacity 1.0s
}

.fade-enter, .fade-leave-active {
  opacity: 0
}
</style>
