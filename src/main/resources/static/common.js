function closeTable(){
    var table1 = document.getElementById("tableSelector");
    if(table1.style.display==='block'){
        table1.style.display = 'none';
    }else if(table1.style.display==='none'){
        table1.style.display='block';
    }else{
        table1.style.display='block';
    }
}