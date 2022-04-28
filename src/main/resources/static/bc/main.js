const tooleb = document.querySelector('.login');
const menu1 = document.querySelector('.list');

tooleb.addEventListener('click',()=>{
    menu1.classList.toggle('active');
});

const check = document.querySelector('.result');
const checklist = document.querySelector('.check_list');

check.addEventListener('click', ()=>{
    checklist.classList.toggle('active');
    check.classList.toggle('active');
})

const check2 = document.querySelector('.result2');
const checklist2 = document.querySelector('.check_list2');

check2.addEventListener('click', ()=>{
    checklist2.classList.toggle('active');
    check2.classList.toggle('active');
})

const check3 = document.querySelector('.result3');
const checklist3 = document.querySelector('.check_list3');

check3.addEventListener('click', ()=>{
    checklist3.classList.toggle('active');
    check3.classList.toggle('active');
})

let i = 0;
document.querySelector('.prev').addEventListener('click',()=>{
    if(i !=0){
    i+=100;
    document.querySelector('.container').style.transform = 'translate('+ i +'vw)';
    }else{
    i=-200;
    document.querySelector('.container').style.transform = 'translate('+ i +'vw)';
    }
})

document.querySelector('.next').addEventListener('click',()=>{
    if(i >-200){
    i-=100;
    document.querySelector('.container').style.transform = 'translate('+ i +'vw)';
    }else{
    i=0;
    document.querySelector('.container').style.transform = 'translate('+ i +'vw)';
    }
})



