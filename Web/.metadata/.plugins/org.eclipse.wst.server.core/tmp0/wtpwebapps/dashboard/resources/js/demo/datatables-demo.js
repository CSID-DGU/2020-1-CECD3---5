// Call the dataTables jQuery plugin
$(document).ready(function() {
//$('#dataTable').DataTable
  getBoardList();
});

function getBoardList(){
  	$.ajax({         
            type:"GET",
            url:"http://localhost:8080/dashboard/board/getSearch",
            dataType:"JSON",
            success : function(obj) {
                getBoardListCallback(obj);            
            },           
            error:function(request,status,error){
                alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
            }
            	
         });
 }

 function getBoardListCallback(obj){
        var list = obj;
        var listLen = obj.length;
        
        console.log(list);
        console.log(listLen);
        
        var str = "";
        
        if(listLen >  0){
            
            for(var a=0; a<listLen; a++){
                
                var studentName		= list[a].student_name; 
                var studentID		= list[a].student_ID; 
                var studentCurri    = list[a].student_curri;
                
                str += "<tr>";
                str += "<td>"+ studentName +"</td>";
                str += "<td>"+ studentID +"</td>";
                str += "<td>"+ studentCurri +"</td>";
                str += "<td><button style=\"align:left; background-color:#2F504E; color:white; border:0; outline:0; width:80px; height:20px; font-size:10px; align:right; margin-top:-8px; \">상세보기</button></td>";                
                str += "</tr>";
                
            } 
            
        } else {
            
            str += "<tr colspan='4'>";
            str += "<td>등록된 글이 존재하지 않습니다.</td>";
            str += "<tr>";
        }
        
        $("tbody").html(str);
    }