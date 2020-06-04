<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
	<div id="outline" style="padding: 2rem; width: 60rem; background-color: #fff2fc;">
		<h5 class="text-right" style="color: red;">물류 매니저 전용</h5>
		<div id="content" style="margin: 0 auto; width: 40rem;">
			<h2 style="margin-bottom: 1rem;">상품 입고</h2>
			<div class="card card-body" style="background-color: #fff7fd">
				<form class="form-horizontal" onsubmit="receive(); return false;">
					<div class="form-group row">
						<label class="col-sm-2 col-form-label" for="goodsId">상품 ID</label>
						<div class="col-sm-8">
							<input type="number" class="form-control" id="goodsId" min='1' />
						</div>
						<div class="col-sm-2">
							<button id='goodsSearch' class="btn btn-primary form-control" type="button">조회</button>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label" for="goodsName">상품명</label> <input readonly class="form-control" id="goodsName" />
					</div>
					<div class="form-group">
						<label class="control-label" for="price">가격</label> <input readonly type="number" class="form-control" id="price" />
					</div>
					<div class="form-group">
						<label class="control-label" for="inventory">재고</label> <input readonly type="number" class="form-control" id="inventory" />
					</div>
					<div class="form-group row">
						<label class="col-sm-2 col-form-label" for="receivedQuantity">입고 수량</label>
						<div class="col-sm-8">
							<input type="number" class="form-control" id="receivedQuantity" min='1' />
						</div>
						<div class="col-sm-2">
							<button type="submit" class="btn btn-outline-primary form-control">입고</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>


<script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>

<script>

   //입고하기 
    function receive() {
        var receivedQuantity = $("#receivedQuantity").val();
        if(receivedQuantity < 1) {
            alert("입고 수량을 입력해 주세요.");
            return false;
        }
        $.ajax({
            url : "/inventory/receive",
            type : "POST",
            data : {
                goodsId : $("#goodsId").val(),
                receivedQuantity : $("#receivedQuantity").val()
            },
            success : function(result) {
                alert("입고 완료 되었습니다");
                location.reload();
            },
            error : function(e) {
                alert(e.responseJSON.message);
            }
        });
    }

    
    $(document).ready(function() {
    	
    	//조회 클릭했을때...
        $("#goodsSearch").on('click', function() {
            $.ajax({
                url : "/inventory/goods?goodsId=" + $("#goodsId").val(),
                type : "GET",
                success : function(result) {
                    if(!result) {
                        alert("상품 ID를 확인해주세요.");
                        return;
                    }
                    $("#goodsName").val(result.goodsName);
                    $("#price").val(result.price);
                    $("#inventory").val(result.inventory);
                },
                error : function(e) {
                    alert(e.responseJSON.message);
                }
            });
        });

    });
</script>


<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">