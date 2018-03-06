<template>
  <div id="round-box">
      <h1>Link Stash!</h1>
      <form action="">
          <div id="input-set">
            <input type="text" name="name" class="input" placeholder="First Name">
            <input type="text" name="lastName" class="input" placeholder="Last Name">
            <input type="text" name="email" class="input" placeholder="Email">
            <input type="password" name="password" class="input" placeholder="Password">
          </div>
          <div id="button-box">
              <button type="button" class="button" onclick="window.location.href='/login'">Login</button>
              <button class="button" id="register-button">Register</button>
          </div>
      </form>
  </div>
</template>
<script>
export default {
    
    data(){

    }
}
</script>

<style>
    #round-box{
        background-color: white;
        padding: 4%;
        border-radius: 10px;
        width: 50%;
    }

    .input{
        border-top:none;
        border-left: none;
        border-right: none;
        font-size: 12pt;
        height: 5%;
        margin:7%;
    }
     input:focus{
        outline: 0;
    }

    #input-set{
        display: flex;
        flex-direction: column;
    }

     #button-box{
        display: flex;
        flex-direction: row;
        justify-content: space-around;
        padding: 5%;
    }

     .button{
        width: 45%;
        border-radius: 10px;
        font-size: 12pt;
        color: white;
        background-color: steelblue;
        height: 35px;
    }

    .button:focus{
        outline: 0;
    }

    .button:hover{
        opacity: 0.8;
    }

    a{
        text-decoration: none;
    }

    a:visited{
        color: white;
    }
</style>
