<template>
        <div id="animated-object" class="animate" v-on:click="move(direction)"></div>
</template>
<script>

function move(direction){
    console.log('Function MOVE to' + direction);
    if(direction == 'left'){
        move2left();
    }else{
        move2right();
    }
}

function move2left(){
    let animate = document.querySelector('#animated-object');
    animate.classList.add('animate-right-to-left-move')
}

function move2right(){
    let animate = document.querySelector('#animated-object');
    animate.classList.add('animate-left-to-right-move');
}

export default {
    
    props:['direction','animate'],

    methods:{
        move
    },

    computed:{
        animation(){
            if(this.animate == 'animate-begin-left') return 'animate-begin-left';
            if(this.animate == 'animate-begin-right') return 'animate-begin-right';
        }
    },

    data(){

        return{

        }
    }
}
</script>
<style>
    .animate{
  height: 100px;
  width: 100px;
  background-color: #c00;
  -webkit-transition: all 1s ease;
  -moz-transition: all 1s ease;
  -o-transition: all 1s ease;
  -ms-transition: all 1s ease;
  transition: all 1s ease;
  position: absolute;
  top: 30%;
  /* left:0; */
}

.animate-left-to-right-move {
  left:100%;  
  margin-left: -100px; /*.animate width*/
}

.animate-begin-right {
  height: 100px;
  width: 100px;
  background-color: #c00;
  -webkit-transition: all 1s ease;
  -moz-transition: all 1s ease;
  -o-transition: all 1s ease;
  -ms-transition: all 1s ease;
  transition: all 1s ease;
  position: absolute;
  top: 30%;
}

.animate-right-to-left-move{
    right:100%;
    margin-right: -100px;
}

</style>
