<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="initial-scale=1, width=device-width" />
  <title></title>
  <meta name="description" content="" />

  <link rel="stylesheet" href="./page5.css" />
  <link rel="stylesheet" href="./page6.css" />
  <link rel="stylesheet" href="./page6.html" />

  <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Montserrat:wght@500;600;700&display=swap" />
  <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Poppins:wght@500;600&display=swap" />
  <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;700&display=swap" />
 <script src=
  "https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"
  type="text/javascript">
</script>
</head>
<body>   
  <div class="div">
    <input type="hidden" id="LoginId" name="postId" value=<%=session.getAttribute("LoginId")%> />
    <input type="hidden" id="type0101" name="type0101" value=<%=session.getAttribute("type0101")%> />
    <input type="hidden" id="type0202" name="type0202" value=<%=session.getAttribute("type0202")%> />
    <input type="hidden" id="type0303" name="type0303" value=<%=session.getAttribute("type0303")%> />
    <input type="hidden" id="type0404" name="type0404" value=<%=session.getAttribute("type0404")%> />
    <img class="icon" alt="" src="public/@22x.png" />
    <img class="winter-img-icon" alt=""src="public/winter-img@2x.png" />
    <img class="fall-img-icon" alt="" src="public/fall-img@2x.png" />
    <img class="summer-img-icon" alt="" src="public/summer-img@2x.png" />
    <img class="spring-img-icon" alt="" src="public/spring-img@2x.png" />
      
      <a class="fall-a">
      <div class="div1">
        <p class="p"><span>秋節券500元 僅限北北基商家使用</span></p>
        <p class="p1"><span>期限 2023年 9月1日 至 11月30日</span></p>
      </div></a>
      
      <a class="summer-a">
      <div class="div2">
        <p class="p"><span>仲夏券500元 僅限北北基商家使用</span></p>
        <p class="p1"><span>期限 2023年 6月1日 至 8月31日</span></p>
      </div></a>
      
      <a class="winter-a">
      <div class="div3">
        <p class="p"><span>晚冬券500元 僅限北北基商家使用</span></p>
        <p class="p1"><span>期限 2023年 11月1日 至 2月28日</span></p>
      </div></a>
      
      <a class="spring-a">
      <div class="div2">
        <p class="p"><span>春遊券500元 僅限北北基商家使用</span></p>
        <p class="p1"><span>期限 2023年 3月1日 至 5月31日</span></p>
      </div></a>

    <input class="winter-check-input" id="winter" input name="user_active_col" type="checkbox" value="type04"/>
    <input class="fall-check-input"   id="fall"   input name="user_active_col" type="checkbox" value="type03"/>
    <input class="summer-check-input" id="summer" input name="user_active_col" type="checkbox" value="type02"/>
    <input class="spring-check-input" id="spring" input name="user_active_col" type="checkbox" value="type01"/>


    <h1 class="title-h1">北北基好購券選擇兌換</h1>
    <button id="complete" class="click-1-button" onclick=window.location.href="page6.html"></button>
  </div>
  <script>
  function result2(data){	  
	//alert(data);
  }
  $(document).ready(
		  function(){			  
			  var type01=$("#type0101").val();	 
			  var type02=$("#type0202").val();	
			  var type03=$("#type0303").val();	
			  var type04=$("#type0404").val();	
			  var checkbox=$('input[name=user_active_col]'); 
			  if(type01=="1"){				  
				  //$('checkbox[3]').prop('checked', true);
				  $("#spring").attr("checked",true);//打勾
				  
			  }		  
			  if(type02=="1"){				  
				  //$('checkbox[2]').prop('checked', true);
				  $("#summer").attr("checked",true);//打勾

			  }	  
			  if(type03=="1"){				  
				  //$('checkbox[1]').prop('checked', true);
				  $("#fall").attr("checked",true);//打勾
			  }	  
			  if(type04=="1"){				  
				  //$('checkbox[0]').prop('checked', true);				 
				  $("#winter").attr("checked",true);//打勾
			  }
		  }
  );
  function result(data){
	  //alert(data);
  }
$("#complete").click(function(){   
   var memid=$("#LoginId").val();
   //alert(memid);
   var checkone=false;
   var checkone=[];
   var checkval=[];
   var obj={};
   obj.memid=memid;
   obj.sum=0;
   var checkbox=$('input[name=user_active_col]'); 
   if(checkbox[0].checked){
      obj.type04=1;
      obj.sum++;
   }
   else
	  obj.type04=0;

   if(checkbox[1].checked){
	      obj.type03=1;
	      obj.sum++;
   }
	   else
		  obj.type03=0;
   if(checkbox[2].checked){
	      obj.type02=1;
	      obj.sum++;
   }
	   else
		  obj.type02=0;
   if(checkbox[3].checked){
	      obj.type01=1;
	      obj.sum++;
   }
	   else
		  obj.type01=0;
   
   /*
    
   
   for(var i=0;i<checkbox.length;i++){
	   if(checkbox[i].checked){
		   checkone=true;
		   checkval.push(checkbox[i].value);
		   checkval.push(checkbox[i].checked);
	   }		   
   }*/
   
   //if(checkone==false){
	//   alert("請選擇欲申請的卷!!")
   //}
  // alert(checkval);
   var objData=JSON.stringify(obj);
   console.log(objData);
   $.post("UpdateCouponServlet2",{"obj":objData},result)
});
</script>
</body>
</html>