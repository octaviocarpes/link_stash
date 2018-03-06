<template>
        <div id="login-container">
             <h1>Link Stash!</h1>
            <form action="">
                <input id="login-input" class="input" type="text" placeholder="Email">
                <input id="password-input" class="input" type="password" placeholder="Password">
                <div class="buttons">
                    <button id="login-button" class="button login-button" type="submit">Login</button>
                    <button id="register-button" class="button register-button" type="submit">Register</button>
                </div>
            </form>
            
        </div>
</template>

<script>
export default {
    
    
    
}
</script>
<style>
    #login-container{
        display: flex;
        flex-direction: column;
        justify-content: space-between;
        width: 400px;
        height: 400px;
        border-radius: 10px;
        background-color: white;
    }

    .input{
        display: flex;
        flex-direction: column;
        justify-content: center;
        margin: 10px;
        height: 30px;
        border-radius: 2px, 2px, 2px, 2px;
    }

    form{
        display: flex;
        flex-direction: column;
        justify-content: center;
    }

    .buttons{
        width: 90%;
        height: 25px;
        margin: 10px;
        display: flex;
        flex-direction: row;
        justify-content: space-around;
        padding: 15px;
    }
    
    .button{
        width: 50%;
        height: 35px;
        border-radius: 20px;
        font-family: 'Avenir', Helvetica, Arial, sans-serif;
        font-size: 19pt;
    }

    .button:hover{
        opacity: .8;
    }

    .register-button{
        background-color: slategrey;
        color: white;
        margin: 5px;
    }

    .login-button{
        background-color: royalblue;
        color: white;
        margin: 5px;
    }

    
</style>
