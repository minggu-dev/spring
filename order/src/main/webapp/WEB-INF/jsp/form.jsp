<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
	<div id="outline" style="padding: 2rem; width: 60rem; background-color: #f0f7ff;">
		<div id="content" style="margin: 0 auto; width: 40rem;">
			<h2 style="margin-bottom: 1rem;">주문하기</h2>
			<div class="card card-body" style="background-color: #fafcff">


				<table class="table table-bordered table-hover" style="width: 38rem;">
					<c:forEach items="${goodsList}" var="item">
						<tr>
							<td class="text-center"><img src="${item.randomImgUrl}" height="150" width="150"></td>
							<td>
								<div class="card-body">
									<h5 class="card-title">${item.goodsName}</h5>
									<h6 class="card-subtitle mb-2 text-muted">${item.priceForDisplay}</h6>
									<div class="form-group row" name='goods-div' data-id='${item.goodsId}'>
										<label for="orderQuantity" class="col-sm-4 col-form-label">구매 수량</label>
										<div class="col-sm-3">
											<input type="number" class="form-control text-right" name="orderQuantity" data-price='${item.price}' value="1" min="1" data-max="${item.inventory}">
										</div>
									</div>
								</div>
							</td>
						</tr>
					</c:forEach>
				</table>
				<div class="form-group row">
					<label class="col-sm-2 offset-sm-6 col-form-label" for="totalPrice"> 총 금액 </label> <label id='totalPrice' class="col-sm-3 col-form-label text-right">0</label> <label class="col-sm-1 col-form-label">원</label>
				</div>

				<div class="form-group">
					<label class="control-label" for="shippingAddress">배송지</label> <input class="form-control" id="shippingAddress" />
				</div>

			</div>
			<div class="text-right" style="margin: 1rem;">
				<button type="button" id='back' class="btn btn-secondary">돌아가기</button>
				<button type="button" id="order" class="btn btn-primary">주문하기</button>
			</div>
		</div>
	</div>
</body>


<!-- https://webclub.tistory.com/523  integrity,crossorigin 보안때문에 있음  -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>

<script>
    $(document).ready(function() {
        function setTotalPrice() {
            var totalPrice = 0;
            $.each($('input[name=orderQuantity]'), function() {
                totalPrice += $(this).data('price') * $(this).val();
            })
            $("#totalPrice").text(totalPrice.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ","));
        }
        
        function checkMaxQuantity($el) {
            if($el.val() > $el.data('max')) {
                alert("해당 상품의 최대 구매 가능 수량은 " + $el.data('max') + " 개 입니다.");
                $el.val($el.data('max'));
            }
        }

        $('input[name=orderQuantity]').on('change', function() {
            checkMaxQuantity($(this));
            setTotalPrice();
        });

        //주문하기 
        $("#order").on('click', function() {
            var shippingAddress = $("#shippingAddress").val();
            if(shippingAddress.length === 0) {
                alert("배송지를 입력해주세요.");
                return false;
            }
            var orderLineItemRequestList = [];
            $.each($("div[name=goods-div]"), function() {
                orderLineItemRequestList.push({
                    goodsId : $(this).data('id'),
                    orderQuantity : $(this).find("input[name=orderQuantity]").val(),
                    unitPrice : $(this).find("input[name=orderQuantity]").data('price')
                })
            });

            $.ajax({
                url : "/order",
                type : "POST",
                contentType : "application/json",
                data : JSON.stringify({
                    shippingAddress : shippingAddress,
                    orderLineItemRequestList : orderLineItemRequestList
                }),
                success : function(result) {
                    if (result > 0) {
                        alert("정상적으로 주문 완료되었습니다.");
                        location.href = 'http://localhost:8000/goods/list';
                    } else {
                        alert("주문 실패 : 시스템 오류 발생");
                    }
                },
                error : function(e) {
                    alert(e.responseJSON.message);
                }
            });
        });
        $("#back").on('click', function() {
            location.href = 'http://localhost:8000/goods/list';
        })
        
        setTotalPrice();
    });
</script>


<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">