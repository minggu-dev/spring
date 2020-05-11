package sample05;

public class OrderMessageImpl implements OrderMessage {
	private int orderId;
	private String message;
	private UserBean userBean;
	private ProductBean productBean;
	
	public OrderMessageImpl() {
		super();
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public ProductBean getProductBean() {
		return productBean;
	}

	public void setProductBean(ProductBean productBean) {
		this.productBean = productBean;
	}

	@Override
	public void getOrder_Message() {
		System.out.println("orderId : " + orderId);
		System.out.println("name : " + userBean.getName());
		System.out.println("phone : " + userBean.getPhone());
		System.out.println("p_name : " + productBean.getP_name());
		System.out.println("p_price : " + productBean.getP_price());
		System.out.println("message : " + message);
	}
}
