$(function() {    
  $("[data-url]").click(function() {
    let url = $(this).attr("data-url");
    location.href = url;
  });
  
  $(".autosubmit").change(function() {
    $(this).parent("form").submit();    
  });
  $("[data-confirm-delete]").click(function() {
    return confirm("삭제하시겠습니까?");
  });
  	$("[data-confirm-pwd]").click(function() {
		var pwd = $(this).data('value');
		alert(pwd);
		pwd = (pwd-10)/2;
		var epwd = prompt('비밀번호입력','');
		if( pwd == epwd){
		alert('삭제가 완료 되었습니다!');
		return true;
		}else{
		alert('번호가 틀렸습니다.');
		return false;
		}
	})
})
