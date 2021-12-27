<template>
  <div id="app">
    <navi-bar id="nav" />
    <router-view />
  </div>
</template>

<script>
import NaviBar from "./components/layout/NaviBar.vue";
export default {
  name: "App",
  components: {
    NaviBar,
  },
};
</script>
<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav a {
  color: gray;
}

#nav a.router-link-exact-active {
  color: black;
}
</style>
