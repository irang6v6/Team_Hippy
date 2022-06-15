$(function() {
    
  $("[data-url]").click(function() {
    var url = $(this).attr("data-url");
    location.href = url;
  })

  $("[data-confirm-delete]").click(function() {
    return confirm("삭제하시겠습니까?");
  })
  
    $("[data-confirm-pwd]").click(function() {
    var pp = prompt('삭제','삭제');
	 return alert("안녕");
  })

})
