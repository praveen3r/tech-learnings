function num_print(upto, filter){
    for(var i=0; i < upto; i++){
        if(filter(i)){
            console.log(i)
        }
    }
}

function odd_filter(i){
    return i % 2 === 0;
}

num_print(10, odd_filter);