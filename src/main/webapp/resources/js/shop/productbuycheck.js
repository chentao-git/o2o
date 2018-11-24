$(function () {
    var productName = "";
    getList();
    function getList() {
        //获取用户购买信息的url
        var listUrl = '/o2o/shopadmin/listuserproductmapsbyshop?pageIndex=1&pageSize=9999&productName='+productName;
        // 访问后台，获取该店铺的购买信息列表
        $.getJSON(listUrl, function(data) {
            if (data.success){
                var userProductMapList = data.userProductMapList;
                var tempHtml = '';
                // 遍历购买信息列表，拼接出列信息
                userProductMapList.map(function(item, index) {
                    tempHtml += '' + '<div class="row row-productbuycheck">'
                        + '<div class="col-10">' + item.product.productName
                        + '</div>'
                        + '<div class="col-40 productbuycheck-time">'
                        + new Date(item.createTime).Format("yyyy-MM-dd hh:mm:ss")
                        + '</div>' + '<div class="col-20">'
                        + item.user.name + '</div>'
                        + '<div class="col-10">' + item.point + '</div>'
                        + '<div class="col-20">' + item.operator.name
                        + '</div>' + '</div>';
                });
                $('.productbuycheck-wrap').html(tempHtml);
            }
        })
    }
    $('#search').on('change', function(e) {
        // 当在搜索框里输入信息的时候
        // 依据输入的商品名模糊查询该商品的购买记录
        productName = e.target.value;
        // 清空商品购买记录列表
        $('.productbuycheck-wrap').empty();
        // 再次加载
        getList();
    })
})