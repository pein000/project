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
    //上下箭头，触发
    $(".but_to_up").on("click",function(){
        var options = $(".select_down option:selected");
        $(options).each(function(index){
            var option = options[index];
            var aid = $(option).attr("aid");
            var b = $(".select_up option[uid='"+aid+"'");
            if($(b).length > 0){
                return;
            }
            $(".select_up").append(option);
        });
    });
    $(".but_to_down").on("click",function(){
        var options = $(".select_up option:selected");
        $(options).each(function(index){
            var option = options[index];
            var uid = $(option).attr("uid");
            var b = $(".select_up option[aid='"+uid+"'");
            if($(b).length > 0){
                return;
            }
            $(".select_down").append(option);
        });
    });
});