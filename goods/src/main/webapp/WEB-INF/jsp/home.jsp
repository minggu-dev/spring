<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<style>
#goodsList td {
	vertical-align: middle;
}
</style>
</head>
<body>
	<div id="outline" style="padding: 2rem; width: 60rem; background-color: #f0f7ff;">
		<div id="content" style="margin: 0 auto; width: 55rem;">
			<h2 style="margin-bottom: 1rem;">상품 조회</h2>
			<div class="card card-body" style="background-color: #fafcff">
				<table id="goodsList" class="table table-hover">
					<thead class="text-center">
						<tr>
							<th></th>
							<th></th>
							<th>상품명</th>
							<th>가격</th>
							<th>등록일</th>
							<th></th>
						</tr>
					</thead>
					<tbody class="text-center">
						<c:forEach items="${goodsList}" var="item">
							<tr>
								<td><input type="checkbox" <c:if test="${item.soldOut}">disabled </c:if> data-id='${item.goodsId}'/></td>
								<td><img src="${item.randomImgUrl}" height="100" width="100"></td>
								<td>${item.goodsName}</td>
								<td>${item.priceForDisplay}</td>
								<td>${item.createdAtForDisplay}</td>
								<td><c:if test="${item.soldOut}">품절</c:if></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<c:if test="${orderAvailable}">
				<div class="text-right" style="margin: 1rem;">
					<button type="button" id="order" class="btn btn-primary">주문하기/${orderAvailable}</button>
				</div>
			</c:if>
		</div>
	</div>
</body>
<script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
<script>
    $(document).ready(function() {
        $("#order").on('click', function() {
            var selectedGoodsIds = [];
            $.each($("#goodsList input[type=checkbox]"), function() {
                if (this.checked) {
                	//alert($(this).data('id'))
                    selectedGoodsIds.push($(this).data('id'));
                }
            });
            
            if (selectedGoodsIds.length === 0) {
                alert("주문할 상품이 없습니다.");
                return false;
            }
            
            var goodsIds = "";
            $.each(selectedGoodsIds, function() {
                goodsIds = goodsIds + this + ",";// id,id,...
            });
            
            //alert(goodsIds)//
            
            location.href = 'http://localhost:8081/order/form?goodsIds=' + goodsIds.substring(0, goodsIds.length - 1);
        });
    });
</script>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">