function calender(){
    var day=['Poniedziałek','Wtorek','Środa','Czwartek','Piątek','Sobota','Niedziela'];
    var month= ["Styczeń","Luty","Marzec","Kwiecień","Maj","Czerwiec","Lipiec",
        "Sierpień","Wrzesień","Październik","Listopad","Grudzień"];
    var d=new Date();
    setText('calenderDay',day[d.getDay()]);
    setText('calenderDate',d.getDate());
    setText('calenderMonthYear',month[d.getMonth()]+' '+(1900+d.getYear()));
};
function setText(id, val){
    if(val<10){
        val='0'+val;
    }
    document.getElementById(id).innerHTML=val;
};
// call calender()
window.onload=calender;