const isPrime = a =>{
    for(let i = 2 ; i <  a ; i++){
        if(a % i === 0){
            return false;
        }
    }
    return true;
}


let arr = [1,2,3,4,5,6]

console.log(isPrime(4))
