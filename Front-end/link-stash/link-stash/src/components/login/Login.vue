<template>
        
            <div id="round-box">
                <h1>Link Stash!</h1>
                <form action="">
                    <div id="input-set">
                        <input id="user-email-text" type="text" name="email" placeholder="Email" v-model="user.userEmail" class="input login-input">
                        <input id="user-password-text" type="password" name="password" placeholder="Password" v-model="user.userPassword" class="input password-input">
                    </div>
                    <div id="button-box">
                        <button class="button" type="button" :click="performLoginPost">Sign in</button>
                        <button type="button" class="button" onclick="window.location.href='/register'">Register</button>
                    </div>
                </form>
                <!-- <slider v-on:click="move('right')"/> -->
            </div> 
        
</template>

<script>

import axios from 'axios';
import Slider from '../shared/Slider.vue';

export default {

    components:{
        'slider':Slider
    },
    
    methods:{
        performLoginPost() {
            axios.post('http://localhost:8080/login', this.user)
            .then(res => console.log(res))
            .catch(err => console.log(err))
        }
    },

    data(){
        return {
            user: {
                userEmail: '',
                userPassword: ''
            }
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
