/**
 * Created by pein on 2015/10/24.
 */
var pay = {
    point : {
        strategy : function(amount){
            if(amount >=0){
                return amount /100;
            }
        }
    },

    legal : function(totalAmount,curAmount){
        if(curAmount <= totalAmount){
            return true;
        }
        return false;
    }

}