<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<html>
<body>
	<div id="outline" style="padding: 2rem; width: 60rem; background-color: #fff2fc;">
		<h5 class="text-right" style="color: red;">상품 매니저 전용</h5>
		<div id="content" style="margin: 0 auto; width: 40rem;">
			<h2 style="margin-bottom: 1rem;">상품 등록</h2>
			<div class="card card-body" style="background-color: #fff7fd">
				<form class="form-horizontal" onsubmit="register(); return false;">
					<div class="form-group">
						<label class="control-label" for="goodsName">상품명</label> <input class="form-control" id="goodsName" />
					</div>
					<div class="form-group">
						<label class="control-label" for="price">가격</label> <input type="number" class="form-control" id="price" />
					</div>

					<div class="text-right">
						<button type="submit" class="btn btn-outline-primary btn-lg">등록</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>

<script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
<script>
    function register() {
        var goodsName = $("#goodsName").val();
        var price = $("#price").val();
        if (goodsName.trim().length === 0) {
            alert("상품명을 올바르게 입력하세요.")
            return;
        }
        if (price <= 0) {
            alert("가격을 올바르게 입력하세요.");
            return;
        }
        $.ajax({
            url : "/goods-manager/goods",
            type : "POST",
            data : {
                goodsName : goodsName,
                price : price
            },
            success : function(result) {
                if (result) {
                    alert("정상적으로 등록 완료되었습니다.");
                    location.reload();
                } else {
                    alert("등록 실패 : 시스템 오류 발생");
                }
            }
        });
    }
</script>


<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">