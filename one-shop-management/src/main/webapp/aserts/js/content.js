$(function(){
    $(".but_right_all").on('click', function(){
        var options = $(".select_left option");
        $(".select_right").append(options);
    });
    $(".but_to_right").on("click",function(){
        var options = $(".select_left option:selected");
        $(".select_right").append(options);

    });
    $(".but_to_left").on("click",function(){
        var options = $(".select_right option:selected");
        $(".select_left").append(options);
    });
    $(".but_left_all").on("click",function(){
        var options = $(".select_right option");
        $(".select_left").append(options);
    });
    //双击
    $(".select_right option").on("dblclick",function(){
        $(".select_left").append($(this));
    });
    $(".select_left option").on("dblclick",function(){
        $(".select_right").append($(this));
    });
});