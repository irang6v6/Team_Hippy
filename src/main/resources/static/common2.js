$(function() {    
  $("[data-url]").click(function() {
    let url = $(this).attr("data-url");
    location.href = url;
  });
  
  $(".autosubmit").change(function() {
    $(this).parent("form").submit();    
  });
})
