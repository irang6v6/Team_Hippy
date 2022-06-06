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
})
