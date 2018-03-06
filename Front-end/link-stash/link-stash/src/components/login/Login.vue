<template>
        
            <div id="round-box">
                <h1>Link Stash!</h1>
                <form action="">
                    <div id="input-set">
                        <input type="text" name="email" placeholder="Email" class="input login-input">
                        <input type="password" name="password" placeholder="Password" class="input password-input">
                    </div>
                    <div id="button-box">
                        <button class="button" type="submit">Sign in</button>
                        <button type="button" class="button" onclick="window.location.href='/register'">Register</button>
                    </div>
                </form>
                <!-- <slider v-on:click="move('right')"/> -->
            </div> 
        
</template>

<script>

import Slider from '../shared/Slider.vue';

export default {

    components:{
        'slider':Slider
    },
    
    data(){
        return {

        }
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

    .login-input{
        margin: 5%;
    }

    .password-input{
        margin:5%;
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
        width: 100%;
    }

    a:visited{
        color: white;
    }

</style>
